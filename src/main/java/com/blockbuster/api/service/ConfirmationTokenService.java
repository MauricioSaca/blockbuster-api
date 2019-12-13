package com.blockbuster.api.service;

import java.util.List;

import com.blockbuster.api.models.ConfirmationToken;

public interface ConfirmationTokenService {

	ConfirmationToken findConfirmationTokenById(Long id);

	List<ConfirmationToken> findAllConfirmationToken();

	void saveConfirmationToken(ConfirmationToken confirmationToken);

	void updateConfirmationToken(ConfirmationToken confirmationToken);

	void deleteConfirmationToken(Long id);
}
