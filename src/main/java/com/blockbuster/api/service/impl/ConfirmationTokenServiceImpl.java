package com.blockbuster.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blockbuster.api.models.ConfirmationToken;
import com.blockbuster.api.repository.ConfirmationTokenRepository;
import com.blockbuster.api.service.ConfirmationTokenService;

@Service
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {

	@Autowired
	private ConfirmationTokenRepository confirmationTokenRepository;

	@Override
	public ConfirmationToken findConfirmationTokenById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConfirmationToken> findAllConfirmationToken() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveConfirmationToken(ConfirmationToken confirmationToken) {
		confirmationTokenRepository.save(confirmationToken);
	}

	@Override
	public void updateConfirmationToken(ConfirmationToken confirmationToken) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteConfirmationToken(Long id) {
		// TODO Auto-generated method stub

	}

}
