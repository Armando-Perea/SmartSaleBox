package com.java.smartsalebox.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.smartsalebox.models.ProductEarnings;
import com.java.smartsalebox.repo.impl.ProductEarningsRepoImpl;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("smartsalebox/system/productEarnings")
public class ProductEarningsController {

	@Autowired
	ProductEarningsRepoImpl productEarningsRepoImpl;
	
	@GetMapping("/getAllProductEarnings")
	public List<ProductEarnings> getAllProductEarnings(){
		log.info("getAllProductEarnings Controller");
	 return productEarningsRepoImpl.getAllProductEarnings();
	}
	
	@GetMapping("/getProductEarningsById/{id}")
	public Optional<ProductEarnings> getProductEarningsById(@PathVariable Integer id){
		log.info("getProductEarningsById Controller");
	 return productEarningsRepoImpl.getProductEarningsById(id);
	}
	
	@GetMapping("/getProductEarningsByProductId/{idProduct}")
	public Optional<ProductEarnings> getProductEarningsByProductId(@PathVariable Integer idProduct){
		log.info("getProductEarningsByProductId Controller");
	 return productEarningsRepoImpl.getProductEarningsByProductId(idProduct);
	}
	
	@GetMapping("/getProductEarningsByName/{name}")
	public List<ProductEarnings> getProductEarningsByName(@PathVariable String name){
		log.info("getProductEarningsByName Controller");
	 return productEarningsRepoImpl.getProductEarningsByName(name);
	}
	
	@PostMapping("/createProductEarnings")
	public ProductEarnings createProductEarnings(@RequestBody ProductEarnings productEarnings){
		log.info("createProductEarnings Controller");
	 return productEarningsRepoImpl.saveProductEarnings(productEarnings);
	}
	
	@PutMapping("/updateProductEarnings")
	public ProductEarnings updateProductEarnings(@RequestBody ProductEarnings productEarnings){
		log.info("updateProductEarnings Controller");
		 return productEarningsRepoImpl.saveProductEarnings(productEarnings);
	}
	
	@DeleteMapping("/deleteProductEarnings/{id}")
	public void deleteProductEarnings(@PathVariable Integer id){
		log.info("deleteProductEarnings Controller");
		productEarningsRepoImpl.deleteProductEarnings(id);
	}
}
