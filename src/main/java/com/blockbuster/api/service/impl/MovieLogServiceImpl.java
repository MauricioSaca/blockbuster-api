package com.blockbuster.api.service.impl;

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
	public void saveMovieLog(MovieLog movieLog) {
		movieLogRepository.save(movieLog);
	}

}
