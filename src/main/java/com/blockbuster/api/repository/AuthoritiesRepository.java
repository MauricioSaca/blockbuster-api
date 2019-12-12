package com.blockbuster.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blockbuster.api.models.Authorities;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, Long> {

}
