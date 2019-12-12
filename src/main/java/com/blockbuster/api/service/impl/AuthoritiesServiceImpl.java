package com.blockbuster.api.service.impl;

import java.util.List;

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
	public Authorities findAuthoritiesById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Authorities> findAllAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAuthorities(Authorities authorities) {
		authoritiesRepository.save(authorities);

	}

	@Override
	public void updateAuthorities(Authorities authorities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAuthorities(Long id) {
		// TODO Auto-generated method stub

	}

}
