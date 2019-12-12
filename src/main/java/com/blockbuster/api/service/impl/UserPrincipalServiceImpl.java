package com.blockbuster.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blockbuster.api.models.UserPrincipal;
import com.blockbuster.api.repository.UserPrincipalRepository;
import com.blockbuster.api.service.UserPrincipalService;

@Service
public class UserPrincipalServiceImpl implements UserPrincipalService {

	@Autowired
	private UserPrincipalRepository userPrincipalRepositoryu;

	@Override
	public UserPrincipal findUserPrincipalById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserPrincipal> findAllUserPrincipals() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUserPrincipal(UserPrincipal userPrincipal) {
		userPrincipalRepositoryu.save(userPrincipal);
	}

	@Override
	public void updateUserPrincipal(UserPrincipal userPrincipal) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUserPrincipal(Long id) {
		// TODO Auto-generated method stub

	}

}
