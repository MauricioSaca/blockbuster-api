package com.blockbuster.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.blockbuster.api.models.Movie;

public interface MovieService {

	Movie findMovieById(Long id);

	List<Movie> findAllMovies();

	void saveMovie(Movie movie);

	void updateMovie(Movie movie);

	void removeMovie(Long id);

	void deleteMovie(Long id);

	Page<Movie> findAll(Pageable page);

	List<Movie> findByTitle(String title);

}
