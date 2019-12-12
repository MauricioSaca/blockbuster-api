package com.blockbuster.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blockbuster.api.models.MovieLog;

@Repository
public interface MovieLogRepository extends JpaRepository<MovieLog, Long>{

}
