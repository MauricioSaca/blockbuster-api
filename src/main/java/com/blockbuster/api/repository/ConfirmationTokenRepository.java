package com.blockbuster.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blockbuster.api.models.ConfirmationToken;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {

	public ConfirmationToken findByConfirmationToken(String confirmationToken);

}
