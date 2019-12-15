package com.blockbuster.api.service.impl;

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
	public void saveConfirmationToken(ConfirmationToken confirmationToken) {
		confirmationTokenRepository.save(confirmationToken);
	}

}
