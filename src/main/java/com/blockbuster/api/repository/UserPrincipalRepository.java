package com.blockbuster.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blockbuster.api.models.UserPrincipal;

@Repository
public interface UserPrincipalRepository extends JpaRepository<UserPrincipal, Long> {

	public UserPrincipal findByUsername(String username);

	public UserPrincipal findByEmailIgnoreCase(String email);

	public Boolean existsByUsername(String username);

	public Boolean existsByEmail(String email);

}
