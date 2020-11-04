package com.java.smartsalebox.repo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.smartsalebox.models.ProductEarnings;
import com.java.smartsalebox.repository.ProductEarningsRepository;

@Repository
public class ProductEarningsRepoImpl {

	@Autowired
	ProductEarningsRepository productEarningsRepository;
	
	public List<ProductEarnings> getAllProductEarnings() {
		return (List<ProductEarnings>) productEarningsRepository.findAll();
	}
	
	public Optional<ProductEarnings> getProductEarningsById(Integer id) {
		return productEarningsRepository.findById(id);
	}
	
	public Optional<ProductEarnings> getProductEarningsByProductId(Integer idProduct) {
		return productEarningsRepository.findByProductId(idProduct);
	}
	
	public List<ProductEarnings> getProductEarningsByName(String name) {
		return productEarningsRepository.findByName(name);
	}
	
	public ProductEarnings saveProductEarnings(ProductEarnings product) {
		return productEarningsRepository.save(product);
	}
	
	public ProductEarnings updateProductEarnings(ProductEarnings product) {
		return productEarningsRepository.save(product);
	}
	
	public void deleteProductEarnings(Integer id) {
		productEarningsRepository.deleteById(id);
	}
	
	public void truncateProductEarnings() {
		productEarningsRepository.truncateProductEarnings();
	}
	
}
