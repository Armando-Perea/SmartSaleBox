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
	
	@GetMapping("/getTotalSale")
	public Double getTotalSale(){
		log.info("getTotalSale Controller");
		List<Sales> outflowList = salesRepoImpl.getAllSales();
		Double totalAmount = outflowList.stream().mapToDouble(total -> total.getTotal()).sum();
	 return totalAmount;
	}
	
	@GetMapping("/getSaleById/{id}")
	public Optional<Sales> getSaleById(@PathVariable Integer id){
		log.info("getPatientScheduleById Controller");
	 return salesRepoImpl.getSaleById(id);
	}
	
	@GetMapping("/getSaleByProductId/{productId}")
	public Optional<Sales> getSaleByProductId(@PathVariable Integer productId){
		log.info("getSaleByProductId Controller");
	 return salesRepoImpl.getSaleByProductId(productId);
	}
	
	@GetMapping("/getSaleByNoSale/{noSale}")
	public List<Sales> getSaleByNoSale(@PathVariable Integer noSale){
		log.info("getSaleByNoSale Controller");
	 return salesRepoImpl.getSaleByNoSale(noSale);
	}
	
	@GetMapping("/getSaleByProductIdAndNoSale/{idProduct}/{noSale}")
	public Sales getSaleByNoSale(@PathVariable Integer idProduct,@PathVariable Integer noSale){
		log.info("getSaleByNoSale Controller");
	 return salesRepoImpl.getSaleByProductIdAndNoSale(idProduct,noSale);
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
	
	@DeleteMapping("/deleteSaleByNoSale/{noSale}")
	public void deleteSaleByNoSale(@PathVariable Integer noSale){
		log.info("deleteSaleByNoSale Controller");
		salesRepoImpl.deleteSaleByNoSale(noSale);
	}
	
	@Transactional
	@GetMapping("/truncateSales")
	public String truncateSales(){
		log.info("truncateSales Controller");
		salesRepoImpl.truncateSales();
		return "Truncated";
	}

}
