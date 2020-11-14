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

import com.java.smartsalebox.models.BulkProducts;
import com.java.smartsalebox.repo.impl.BulkProductsRepoImpl;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("smartsalebox/system/bulkProducts")
public class BulkProductsController {

	@Autowired
	BulkProductsRepoImpl bulkProductsRepoImpl;
	
	@GetMapping("/getAllBulkProducts")
	public List<BulkProducts> getAllBulkProducts(){
		log.info("getAllBulkProducts Controller");
	 return bulkProductsRepoImpl.getAllBulkProducts();
	}
	
	@GetMapping("/getBulkProductsById/{id}")
	public Optional<BulkProducts> getBulkProductsById(@PathVariable Integer id){
		log.info("getBulkProductsById Controller");
	 return bulkProductsRepoImpl.getBulkProductsById(id);
	}
	
	@GetMapping("/getBulkProductsByName/{name}")
	public List<BulkProducts> getBulkProductsByName(@PathVariable String name){
		log.info("getBulkProductsByName Controller");
	 return bulkProductsRepoImpl.getBulkProductsByName(name);
	}
	
	@PostMapping("/createBulkProducts")
	public BulkProducts getBulkProductsByName(@RequestBody BulkProducts product){
		log.info("createBulkProducts Controller");
	 return bulkProductsRepoImpl.saveBulkProducts(product);
	}
	
	@PutMapping("/updateBulkProducts")
	public BulkProducts updateBulkProducts(@RequestBody BulkProducts product){
		log.info("updateBulkProducts Controller");
		return bulkProductsRepoImpl.saveBulkProducts(product);
	}
	
	@DeleteMapping("/deleteBulkProduct/{id}")
	public void deleteBulkProduct(@PathVariable Integer id){
		log.info("deleteBulkProduct Controller");
		bulkProductsRepoImpl.deleteBulkProducts(id);
	}
	
	@Transactional
	@GetMapping("/truncateBulkProducts")
	public String truncateBulkProducts(){
		log.info("truncateBulkProducts Controller");
		bulkProductsRepoImpl.truncateBulkProducts();
		return "Truncated";
	}
	
}
