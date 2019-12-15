package com.blockbuster.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blockbuster.api.models.Authorities;
import com.blockbuster.api.repository.AuthoritiesRepository;
import com.blockbuster.api.service.AuthoritiesService;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {

	@Autowired
	private AuthoritiesRepository authoritiesRepository;

	@Override
	public void saveAuthorities(Authorities authorities) {
		authoritiesRepository.save(authorities);

	}

}
