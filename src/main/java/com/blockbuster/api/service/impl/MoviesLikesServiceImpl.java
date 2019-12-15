package com.blockbuster.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blockbuster.api.models.MoviesLikes;
import com.blockbuster.api.repository.MoviesLikesRepository;
import com.blockbuster.api.service.MoviesLikesService;

@Service
public class MoviesLikesServiceImpl implements MoviesLikesService {

	@Autowired
	private MoviesLikesRepository moviesLikesRepository;

	@Override
	public void saveMoviesLikes(MoviesLikes moviesLikes) {
		moviesLikesRepository.save(moviesLikes);
	}

}
