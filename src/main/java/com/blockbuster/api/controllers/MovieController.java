package com.blockbuster.api.controllers;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blockbuster.api.models.Movie;
import com.blockbuster.api.models.MovieLog;
import com.blockbuster.api.models.UserPrincipal;
import com.blockbuster.api.pojos.ApiResponse;
import com.blockbuster.api.repository.MovieRepository;
import com.blockbuster.api.service.MovieService;
import com.blockbuster.api.utils.SecurityUtils;

import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/blockbuster")
@Validated
@Getter
@Setter
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private MovieService movieService;

	@GetMapping("/movies")
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

	@GetMapping("/movies/{id}")
	public Movie getMovieDetails(@PathVariable("id") Long id) {
		return movieRepository.findById(id).orElse(new Movie());
	}

	@PostMapping("/action/movies/save")
	public ResponseEntity<?> registerMovie(@Valid @RequestBody Movie movie) {

		if (movieRepository.existsByTitle(movie.getTitle())) {
			return new ResponseEntity(new ApiResponse(false, "Movie title is already exist!"), HttpStatus.BAD_REQUEST);
		}

		movieRepository.save(movie);

		return ResponseEntity.ok(new ApiResponse(true, "Movie registered"));
	}

	@PutMapping("/action/movies/update")
	public ResponseEntity<?> updateMovie(@Valid @RequestBody Movie movie) {
		UserPrincipal user = SecurityUtils.getCurrentUser();
		MovieLog movieLog = new MovieLog();
		movieLog.setTitle(movie.getTitle());
		movieLog.setRentalPrice(movie.getRentalPrice());
		movieLog.setSalesPrice(movie.getSalesPrice());
		movieLog.setMovie(movie);
		movieLog.setUsername(user.getUsername());
		movieLog.setModificateDate(new Date());
		movieService.updateMovie(movie, movieLog);
		return ResponseEntity.ok(new ApiResponse(true, "Movie updated"));
	}

	@PatchMapping("/action/movies/remove/{id}/{enabled}")
	public ResponseEntity<?> qualificationMovie(@PathVariable("id") Long id, @PathVariable("enabled") int enabled) {

		if (movieRepository.existsById(id)) {
			if (isValidEnabledValue(enabled)) {
				Movie movie = movieRepository.findById(id).orElse(new Movie());
				Boolean availability = enabled == 1 ? Boolean.TRUE : Boolean.FALSE;
				movie.setAvailability(availability);
				movieRepository.save(movie);
			} else {
				return new ResponseEntity(new ApiResponse(false, "Value not permited"), HttpStatus.NOT_FOUND);
			}

		} else {
			return new ResponseEntity(new ApiResponse(false, "Movie not exist!"), HttpStatus.BAD_REQUEST);
		}

		return ResponseEntity.ok(new ApiResponse(true, "Movie availability updated"));
	}

	@DeleteMapping("/action/movies/delete/{id}")
	public ResponseEntity<?> deleteMovie(@PathVariable("id") Long id) {

		if (movieRepository.existsById(id)) {
			movieRepository.deleteById(id);
		} else {
			return new ResponseEntity(new ApiResponse(false, "Movie not exits!"), HttpStatus.BAD_REQUEST);
		}

		return ResponseEntity.ok(new ApiResponse(true, "Movie deleted"));
	}

	private boolean isValidEnabledValue(Integer enabled) {
		if (enabled == 1 || enabled == 0) {
			return true;
		} else {
			return false;
		}
	}

}
