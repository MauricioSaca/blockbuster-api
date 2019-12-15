package com.blockbuster.api.service;

import java.util.List;

import com.blockbuster.api.models.Movie;
import com.blockbuster.api.models.MovieLog;

public interface MovieService {

	List<Movie> findAllMoviesByAvailability(Integer pageNo, Integer pageSize, String sortBy, String direction,
			Boolean availability);

	List<Movie> findAllMoviesByTitle(Integer pageNo, Integer pageSize, String sortBy, String direction, String title);

	void saveMovie(Movie movie);

	void updateMovie(Movie movie, MovieLog movieLog);

}
