package com.blockbuster.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.blockbuster.api.models.Movie;
import com.blockbuster.api.repository.MovieRepository;
import com.blockbuster.api.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Movie findMovieById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> findAllMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveMovie(Movie movie) {
		movieRepository.save(movie);
	}

	@Override
	public void updateMovie(Movie movie) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeMovie(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMovie(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Page<Movie> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
