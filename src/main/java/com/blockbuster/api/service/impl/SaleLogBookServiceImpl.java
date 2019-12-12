package com.blockbuster.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blockbuster.api.models.SaleLogBook;
import com.blockbuster.api.repository.SaleLogBookRepository;
import com.blockbuster.api.service.SaleLogBookService;

@Service
public class SaleLogBookServiceImpl implements SaleLogBookService {

	@Autowired
	private SaleLogBookRepository saleLogBookRepository;

	@Override
	public SaleLogBook findSaleLogBookById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SaleLogBook> findAllSaleLogBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveSaleLogBook(SaleLogBook saleLogBook) {
		saleLogBookRepository.save(saleLogBook);
	}

	@Override
	public void updateSaleLogBook(SaleLogBook saleLogBook) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSaleLogBook(Long id) {
		// TODO Auto-generated method stub

	}

}
