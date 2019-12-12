package com.blockbuster.api.service.impl;

import java.util.List;

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
	public MoviesLikes findMoviesLikesById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MoviesLikes> findAllMoviesLikess() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveMoviesLikes(MoviesLikes moviesLikes) {
		moviesLikesRepository.save(moviesLikes);
	}

	@Override
	public void updateMoviesLikes(MoviesLikes moviesLikes) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMoviesLikes(Long id) {
		// TODO Auto-generated method stub

	}

}
