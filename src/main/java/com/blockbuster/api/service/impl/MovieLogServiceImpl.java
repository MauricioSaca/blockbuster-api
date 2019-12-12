package com.blockbuster.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blockbuster.api.models.MovieLog;
import com.blockbuster.api.repository.MovieLogRepository;
import com.blockbuster.api.service.MovieLogService;

@Service
public class MovieLogServiceImpl implements MovieLogService {

	@Autowired
	private MovieLogRepository movieLogRepository;

	@Override
	public MovieLog findMovieLogById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieLog> findAllMovieLogs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveMovieLog(MovieLog movieLog) {
		movieLogRepository.save(movieLog);

	}

	@Override
	public void updateMovieLog(MovieLog movieLog) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMovieLog(Long id) {
		// TODO Auto-generated method stub

	}

}
