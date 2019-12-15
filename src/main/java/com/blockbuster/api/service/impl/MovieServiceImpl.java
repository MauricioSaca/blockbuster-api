package com.blockbuster.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.blockbuster.api.enums.SortingDirection;
import com.blockbuster.api.models.Movie;
import com.blockbuster.api.models.MovieLog;
import com.blockbuster.api.repository.MovieLogRepository;
import com.blockbuster.api.repository.MovieRepository;
import com.blockbuster.api.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private MovieLogRepository movieLogRepository;

	@Override
	public List<Movie> findAllMoviesByAvailability(Integer pageNo, Integer pageSize, String sortBy, String direction,
			Boolean availability) {

		Sort sortOrder = Sort.by((new Sort.Order(
				(SortingDirection.ASCENDING.getCode().equals(direction) ? Sort.Direction.ASC : Sort.Direction.DESC),
				sortBy).nullsLast()));

		Pageable paging = PageRequest.of(pageNo, pageSize, sortOrder);

		Page<Movie> pagedResult = movieRepository.findByFilterAvailability(paging, availability);

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Movie>();
		}
	}

	@Override
	public List<Movie> findAllMoviesByTitle(Integer pageNo, Integer pageSize, String sortBy, String direction,
			String title) {

		Sort sortOrder = Sort.by((new Sort.Order(
				(SortingDirection.ASCENDING.getCode().equals(direction) ? Sort.Direction.ASC : Sort.Direction.DESC),
				sortBy).nullsLast()));

		Pageable paging = PageRequest.of(pageNo, pageSize, sortOrder);

		Page<Movie> pagedResult = movieRepository.findByFilterTitle(paging, title);

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Movie>();
		}
	}

	@Override
	public void saveMovie(Movie movie) {
		movieRepository.save(movie);
	}

	@Override
	public void updateMovie(Movie movie, MovieLog movieLog) {
		movieRepository.save(movie);
		movieLogRepository.save(movieLog);
	}

}
