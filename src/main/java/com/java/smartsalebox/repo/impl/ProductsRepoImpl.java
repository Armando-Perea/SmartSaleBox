package com.java.smartsalebox.repo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.smartsalebox.models.Products;
import com.java.smartsalebox.repository.ProductsRepository;


@Repository
public class ProductsRepoImpl {
	
	@Autowired
	ProductsRepository productsRepository;
	
	public List<Products> getAllProducts() {
		return (List<Products>) productsRepository.findAll();
	}
	
	public Optional<Products> getProductById(Integer id) {
		return productsRepository.findById(id);
	}
	
	public List<Products> getProductByName(String name) {
		return productsRepository.findByName(name);
	}
	
	public Products saveProduct(Products product) {
		return productsRepository.save(product);
	}
	
	public Products updateProduct(Products product) {
		return productsRepository.save(product);
	}
	
	public void deleteProduct(Integer id) {
		productsRepository.deleteById(id);
	}
	
	public void truncateProducts() {
		productsRepository.truncateProducts();
	}

}
