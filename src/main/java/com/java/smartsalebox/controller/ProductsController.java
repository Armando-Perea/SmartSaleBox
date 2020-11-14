package com.java.smartsalebox.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.smartsalebox.models.Products;
import com.java.smartsalebox.repo.impl.ProductsRepoImpl;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("smartsalebox/system/products")
public class ProductsController {

	@Autowired
	ProductsRepoImpl productsRepoImpl;
	
	@GetMapping("/getAllProducts")
	public List<Products> getAllProducts(){
		log.info("getAllProducts Controller");
	 return productsRepoImpl.getAllProducts();
	}
	
	@GetMapping("/getProductById/{id}")
	public Optional<Products> getProductById(@PathVariable Integer id){
		log.info("getProductById Controller");
	 return productsRepoImpl.getProductById(id);
	}
	
	@GetMapping("/getProductByName/{name}")
	public List<Products> getProductByName(@PathVariable String name){
		log.info("getProductByName Controller");
	 return productsRepoImpl.getProductByName(name);
	}
	
	@PostMapping("/createProduct")
	public Products createProduct(@RequestBody Products product){
		log.info("createProduct Controller");
	 return productsRepoImpl.saveProduct(product);
	}
	
	@PutMapping("/updateProduct")
	public Products updateProduct(@RequestBody Products product){
		log.info("updateProduct Controller");
		return productsRepoImpl.saveProduct(product);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public void deleteProduct(@PathVariable Integer id){
		log.info("deleteProduct Controller");
	    productsRepoImpl.deleteProduct(id);
	}
	
	@Transactional
	@GetMapping("/truncateProducts")
	public String truncateProducts(){
		log.info("truncateProducts Controller");
		productsRepoImpl.truncateProducts();
		return "Truncated";
	}
	
}
