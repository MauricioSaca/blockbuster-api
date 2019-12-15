package com.blockbuster.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blockbuster.api.models.Movie;
import com.blockbuster.api.models.MoviesLikes;
import com.blockbuster.api.models.UserPrincipal;
import com.blockbuster.api.pojos.ApiResponse;
import com.blockbuster.api.repository.MovieRepository;
import com.blockbuster.api.repository.MoviesLikesRepository;
import com.blockbuster.api.utils.SecurityUtils;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author msaca
 *
 */

@RestController
@RequestMapping("/blockbuster")
@Validated
@Getter
@Setter
public class LikesMovieController {

	@Autowired
	private MoviesLikesRepository moviesLikesRepository;

	@Autowired
	private MovieRepository movieRepository;
	
	/**
	 * Metodo para dar like a las peliculas
	 * @param id de la movie
	 * @return ResponseEntity<?>
	 */
	@PostMapping("/like/movies/{id}/userlike")
	public ResponseEntity<?> likeUserMovie(@PathVariable("id") Long id) {

		if (movieRepository.existsById(id)) {
			UserPrincipal user = SecurityUtils.getCurrentUser();
			Movie movie = movieRepository.findById(id).orElse(new Movie());
			MoviesLikes likeMovie = new MoviesLikes();
			likeMovie.setUserPrincipal(user);
			likeMovie.setMovie(movie);
			moviesLikesRepository.save(likeMovie);
		} else {
			return new ResponseEntity(new ApiResponse(false, "Movie not exist!"), HttpStatus.BAD_REQUEST);
		}

		return ResponseEntity.ok(new ApiResponse(true, "like registered"));
	}

}
