package com.blockbuster.api.service;

import java.util.List;

import com.blockbuster.api.models.SaleLogBook;

public interface SaleLogBookService {

	SaleLogBook findSaleLogBookById(Long id);

	List<SaleLogBook> findAllSaleLogBooks();

	void saveSaleLogBook(SaleLogBook saleLogBook);

	void updateSaleLogBook(SaleLogBook saleLogBook);

	void deleteSaleLogBook(Long id);
	
}
