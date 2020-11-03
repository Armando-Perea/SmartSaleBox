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

import com.java.smartsalebox.models.Sales;
import com.java.smartsalebox.repo.impl.SalesRepoImpl;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("smartsalebox/system/sales")
public class SalesController {
	
	@Autowired
	SalesRepoImpl salesRepoImpl;
	
	@GetMapping("/getAllSales")
	public List<Sales> getAllPatients(){
		log.info("getAllProducts Controller");
	 return salesRepoImpl.getAllSales();
	}
	
	@GetMapping("/getSaleById/{id}")
	public Optional<Sales> getSaleById(@PathVariable Integer id){
		log.info("getPatientScheduleById Controller");
	 return salesRepoImpl.getSaleById(id);
	}
	
	@GetMapping("/getSaleByNoSale/{noSale}")
	public List<Sales> getSaleByNoSale(@PathVariable Integer noSale){
		log.info("getSaleByNoSale Controller");
	 return salesRepoImpl.getSaleByNoSale(noSale);
	}
	
	@PostMapping("/createSale")
	public Sales createSale(@RequestBody Sales sale){
		log.info("createSale Controller");
	 return salesRepoImpl.saveSale(sale);
	}
	
	@PutMapping("/updateSale")
	public Sales updateSale(@RequestBody Sales sale){
		log.info("updateSale Controller");
		return salesRepoImpl.saveSale(sale);
	}
	
	@DeleteMapping("/deleteSale/{id}")
	public void deleteSale(@PathVariable Integer id){
		log.info("deleteSale Controller");
		salesRepoImpl.deleteSale(id);
	}

}
