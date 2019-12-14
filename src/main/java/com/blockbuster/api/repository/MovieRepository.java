package com.blockbuster.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blockbuster.api.models.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

	public List<Movie> findByTitle(String title);

	public Boolean existsByTitle(String title);
}
