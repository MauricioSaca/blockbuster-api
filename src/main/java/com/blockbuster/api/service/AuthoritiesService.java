package com.blockbuster.api.service;

import java.util.List;

import com.blockbuster.api.models.Authorities;

public interface AuthoritiesService {

	Authorities findAuthoritiesById(Long id);

	List<Authorities> findAllAuthorities();

	void saveAuthorities(Authorities authorities);

	void updateAuthorities(Authorities authorities);

	void deleteAuthorities(Long id);

}
