package com.java.smartsalebox.repo.impl;

import com.java.smartsalebox.models.Sales;
import com.java.smartsalebox.repository.SalesRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SalesRepoImpl {

	@Autowired
	SalesRepository salesRepository;
	
	public List<Sales> getAllSales() {
		return (List<Sales>) salesRepository.findAll();
	}
	
	public Optional<Sales> getSaleById(Integer id) {
		return salesRepository.findById(id);
	}
	
	public Optional<Sales> getSaleByProductId(Integer productId) {
		return salesRepository.findByIdProductGeneral(productId);
	}
	
	public List<Sales> getSaleByNoSale(Integer noSale) {
		return salesRepository.findByNoSale(noSale);
	}
	
	public Sales getSaleByProductIdAndNoSale(Integer idProduct, Integer noSale) {
		return salesRepository.findByProductIdGeneralAndNoSale(idProduct,noSale);
	}
	
	public Sales saveSale(Sales sales) {
		return salesRepository.save(sales);
	}
	
	public Sales updateSale(Sales sales) {
		return salesRepository.save(sales);
	}
	
	public void deleteSale(Integer id) {
		salesRepository.deleteById(id);
	}
	
	public void truncateSales() {
		salesRepository.truncateSales();
	}
	
}
