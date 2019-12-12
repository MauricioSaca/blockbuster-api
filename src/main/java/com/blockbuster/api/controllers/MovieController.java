package com.blockbuster.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blockbuster.api.models.Movie;
import com.blockbuster.api.repository.MovieRepository;

import lombok.Getter;
import lombok.Setter;

@RestController
@Validated
@Getter
@Setter
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;

	// Find
	@GetMapping("/movies")
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

}
