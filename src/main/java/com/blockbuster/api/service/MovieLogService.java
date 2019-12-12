package com.blockbuster.api.service;

import java.util.List;

import com.blockbuster.api.models.MovieLog;

public interface MovieLogService {

	MovieLog findMovieLogById(Long id);

	List<MovieLog> findAllMovieLogs();

	void saveMovieLog(MovieLog movieLog);

	void updateMovieLog(MovieLog movieLog);

	void deleteMovieLog(Long id);

}
