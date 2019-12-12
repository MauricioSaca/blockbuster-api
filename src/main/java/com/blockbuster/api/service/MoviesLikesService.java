package com.blockbuster.api.service;

import java.util.List;

import com.blockbuster.api.models.MoviesLikes;

public interface MoviesLikesService {

	MoviesLikes findMoviesLikesById(Long id);

	List<MoviesLikes> findAllMoviesLikess();

	void saveMoviesLikes(MoviesLikes moviesLikes);

	void updateMoviesLikes(MoviesLikes moviesLikes);

	void deleteMoviesLikes(Long id);

}
