package com.java.smartsalebox.repo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.smartsalebox.models.BulkProducts;
import com.java.smartsalebox.repository.BulkProductsRepository;


@Repository
public class BulkProductsRepoImpl {

	@Autowired
	BulkProductsRepository bulkProductsRepository;
	
	public List<BulkProducts> getAllBulkProducts() {
		return (List<BulkProducts>) bulkProductsRepository.findAll();
	}
	
	public Optional<BulkProducts> getBulkProductsById(Integer id) {
		return bulkProductsRepository.findById(id);
	}
	
	public List<BulkProducts> getBulkProductsByName(String name) {
		return bulkProductsRepository.findByName(name);
	}
	
	public BulkProducts saveBulkProducts(BulkProducts product) {
		return bulkProductsRepository.save(product);
	}
	
	public BulkProducts updateBulkProducts(BulkProducts product) {
		return bulkProductsRepository.save(product);
	}
	
	public void deleteBulkProducts(Integer id) {
		bulkProductsRepository.deleteById(id);
	}
	
	public void truncateBulkProducts() {
		bulkProductsRepository.truncateBulkProducts();
	}
	
}
