package com.blockbuster.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blockbuster.api.models.SaleLogBook;

@Repository
public interface SaleLogBookRepository extends JpaRepository<SaleLogBook, Long>{

}
