package com.blockbuster.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blockbuster.api.models.Authorities;
import com.blockbuster.api.models.UserPrincipal;
import com.blockbuster.api.repository.AuthoritiesRepository;
import com.blockbuster.api.repository.UserPrincipalRepository;
import com.blockbuster.api.service.UserPrincipalService;

@Service
public class UserPrincipalServiceImpl implements UserPrincipalService {

	@Autowired
	private UserPrincipalRepository userPrincipalRepository;

	@Autowired
	private AuthoritiesRepository authoritiesRepository;

	@Override
	public UserPrincipal saveUserPrincipal(UserPrincipal userPrincipal, Authorities authorities) {
		UserPrincipal user = userPrincipalRepository.save(userPrincipal);
		authoritiesRepository.save(authorities);
		return user;
	}

}
