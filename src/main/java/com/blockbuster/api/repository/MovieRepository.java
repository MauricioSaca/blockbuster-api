package com.blockbuster.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blockbuster.api.models.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>, PagingAndSortingRepository<Movie, Long> {

	public List<Movie> findByTitle(String title);

	public Boolean existsByTitle(String title);
	
	@Query("SELECT movie "
			+ " FROM Movie movie "
	        + "WHERE"  
	        + "  (:availabilityValue is null or :availabilityValue = movie.availability )")
	public Page<Movie> findByFilterAvailability(Pageable page ,@Param("availabilityValue")  Boolean availabilityValue);
	
	@Query("SELECT movie "
			+ " FROM Movie movie "
	        + "WHERE"  
	        + " (:titleValue is null or lower(movie.title) LIKE %:titleValue%) and "
	        + " movie.availability = true")
	public Page<Movie> findByFilterTitle(Pageable page ,@Param("titleValue")  String titleValue);
}
