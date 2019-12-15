package com.blockbuster.api.service;

import com.blockbuster.api.models.Movie;
import com.blockbuster.api.models.SaleLogBook;

public interface SaleLogBookService {

	void saveSaleLogBook(SaleLogBook saleLogBook, Movie movie);

}
