package com.blockbuster.api.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blockbuster.api.enums.PenaltyPeriodicity;
import com.blockbuster.api.enums.TransactionType;
import com.blockbuster.api.models.Movie;
import com.blockbuster.api.models.SaleLogBook;
import com.blockbuster.api.models.UserPrincipal;
import com.blockbuster.api.pojos.ApiResponse;
import com.blockbuster.api.repository.MovieRepository;
import com.blockbuster.api.repository.SaleLogBookRepository;
import com.blockbuster.api.service.SaleLogBookService;
import com.blockbuster.api.utils.SecurityUtils;

import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/blockbuster")
@Validated
@Getter
@Setter
public class SalesMovieController {

	@Autowired
	private SaleLogBookRepository saleLogBookRepository;

	@Autowired
	private SaleLogBookService saleLogBookService;

	@Autowired
	private MovieRepository movieRepository;

	@PostMapping("/rent/movies/{id}/salelogbook")
	public ResponseEntity<?> registerMovieRentTransaction(@PathVariable("id") Long id,
			@Valid @RequestBody SaleLogBook saleLogBook) {

		if (movieRepository.existsById(id)) {
			UserPrincipal user = SecurityUtils.getCurrentUser();
			Movie movie = movieRepository.findById(id).orElse(new Movie());

			if (isNotAvailableMovie(movie)) {
				return new ResponseEntity(new ApiResponse(false, "Movie not have stock!"), HttpStatus.BAD_REQUEST);
			} else {
				substractMovieStock(movie);
				saleLogBook.setTransactionType(TransactionType.RENT);
				saleLogBook.setStartDate(new Date());
				saleLogBook.setTransationDate(new Date());
				saleLogBook.setMovie(movie);
				saleLogBook.setUserPrincipal(user);
				saleLogBook.setEnableRent(true);
				Double price = movie.getRentalPrice() * saleLogBook.getStock();
				saleLogBook.setTotal(price);
				saleLogBookService.saveSaleLogBook(saleLogBook, movie);
			}
			
		} else {
			return new ResponseEntity(new ApiResponse(false, "Movie not exist!"), HttpStatus.BAD_REQUEST);
		}

		return ResponseEntity.ok(new ApiResponse(true, "Rent registered"));
	}

	@PatchMapping("/rent/movies/giveback/salelogbook/{id}")
	public ResponseEntity<?> giveBackMovieRentTransaction(@PathVariable("id") Long id) {

		if (saleLogBookRepository.existsById(id)) {
			SaleLogBook saleLogBook = saleLogBookRepository.findById(id).orElse(new SaleLogBook());
			int days = getNumberOfPenaltyDays(saleLogBook);
			PenaltyPeriodicity penalty = getPenaltyPeriodicity(days);
			Double penaltyMoney = saleLogBook.getMovie().getRentalPrice() * penalty.getValue();
			Double newTotal = saleLogBook.getTotal() + penaltyMoney;
			Movie movie = saleLogBook.getMovie();
			sumMovieStock(movie);
			
			saleLogBook.setReturnDate(new Date());
			saleLogBook.setEnableRent(false);
			saleLogBook.setPenaltyDays(days);
			saleLogBook.setPenaltyPeriodicity(penalty);
			saleLogBook.setPenalty(penaltyMoney);
			saleLogBook.setTotal(newTotal);

			saleLogBookService.saveSaleLogBook(saleLogBook, movie);
		} else {
			return new ResponseEntity(new ApiResponse(false, "Movie not exist!"), HttpStatus.BAD_REQUEST);
		}

		return ResponseEntity.ok(new ApiResponse(true, "Rent paid registered"));
	}

	@PostMapping("/purchase/movies/{id}/salelogbook")
	public ResponseEntity<?> registerMoviePurchaseTransaction(@PathVariable("id") Long id,
			@Valid @RequestBody SaleLogBook saleLogBook) {

		if (movieRepository.existsById(id)) {
			UserPrincipal user = SecurityUtils.getCurrentUser();
			Movie movie = movieRepository.findById(id).orElse(new Movie());
			saleLogBook.setTransactionType(TransactionType.PURCHASE);
			saleLogBook.setTransationDate(new Date());
			saleLogBook.setMovie(movie);
			saleLogBook.setUserPrincipal(user);
			saleLogBook.setEnableRent(false);
			Double price = movie.getRentalPrice() * saleLogBook.getStock();
			saleLogBook.setTotal(price);
			saleLogBookRepository.save(saleLogBook);
		} else {
			return new ResponseEntity(new ApiResponse(false, "Movie not exist!"), HttpStatus.BAD_REQUEST);
		}

		return ResponseEntity.ok(new ApiResponse(true, "Purchase registered"));
	}

	private int getNumberOfPenaltyDays(SaleLogBook saleLogBook) {
		DateTime startDate = new DateTime(saleLogBook.getEndDate().getTime());
		DateTime endDate = new DateTime(new Date().getTime());
		int days = Days.daysBetween(startDate, endDate).getDays();
		return days;
	}

	private PenaltyPeriodicity getPenaltyPeriodicity(int days) {
		if (days == 0) {
			return PenaltyPeriodicity.NONE;
		} else if (days >= 1 && days <= 3) {
			return PenaltyPeriodicity.LOW;
		} else if (days >= 5 && days <= 10) {
			return PenaltyPeriodicity.MEDIUM;
		} else {
			return PenaltyPeriodicity.HIGH;
		}
	}
	

	private void substractMovieStock(Movie movie) {
		Integer newStock = movie.getStock() - 1;
		movie.setStock(newStock);
		setUnavailabilityMovie(movie);
	}
	
	private void setUnavailabilityMovie(Movie movie) {
		if (isNotAvailableMovie(movie)) {
			movie.setAvailability(false);
		}
	}

	private void sumMovieStock(Movie movie) {
		Integer newStock = movie.getStock() + 1;
		movie.setStock(newStock);
	}
	

	private boolean isNotAvailableMovie(Movie movie) {
		if (movie.getStock() == 0) {
			return true;
		} else {
			return false;
		}
	}

}
