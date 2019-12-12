package com.blockbuster.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blockbuster.api.models.UserPrincipal;
import com.blockbuster.api.repository.UserPrincipalRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserPrincipalRepository userPrincipalRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserPrincipal user = userPrincipalRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return user;
	}

	public UserPrincipal loadUserById(Long id) {
		UserPrincipal user = userPrincipalRepository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with id : " + id));

		return user;
	}

}
