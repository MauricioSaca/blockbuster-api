package com.blockbuster.api.service;

import java.util.List;

import com.blockbuster.api.models.Authorities;
import com.blockbuster.api.models.UserPrincipal;

public interface UserPrincipalService {

	UserPrincipal findUserPrincipalById(Long id);

	List<UserPrincipal> findAllUserPrincipals();

	UserPrincipal saveUserPrincipal(UserPrincipal userPrincipal, Authorities authorities);

	void updateUserPrincipal(UserPrincipal userPrincipal);

	void deleteUserPrincipal(Long id);

}
