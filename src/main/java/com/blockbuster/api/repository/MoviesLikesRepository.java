package com.blockbuster.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blockbuster.api.models.MoviesLikes;

@Repository
public interface MoviesLikesRepository extends JpaRepository<MoviesLikes, Long>{

}
