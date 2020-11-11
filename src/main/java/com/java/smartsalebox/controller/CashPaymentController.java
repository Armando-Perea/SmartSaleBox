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

import com.java.smartsalebox.models.CashPayment;
import com.java.smartsalebox.repo.impl.CashPaymentRepoImpl;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("smartsalebox/system/cashPayment")
public class CashPaymentController {

	@Autowired
	CashPaymentRepoImpl cashPaymentRepoImpl;
	
	@GetMapping("/getAllCashPayment")
	public List<CashPayment> getAllCashPayment(){
		log.info("getAllCashPayment Controller");
	 return cashPaymentRepoImpl.getAllCashPayment();
	}
	
	@GetMapping("/getCashPaymentById/{id}")
	public Optional<CashPayment> getCashPaymentById(@PathVariable Integer id){
		log.info("getCashPaymentById Controller");
	 return cashPaymentRepoImpl.getCashPaymentById(id);
	}
	
	@PostMapping("/createCashPayment")
	public CashPayment createCashPayment(@RequestBody CashPayment cashPayment){
		log.info("createCashPayment Controller");
	 return cashPaymentRepoImpl.saveCashPayment(cashPayment);
	}
	
	@PutMapping("/updateCashPayment")
	public CashPayment updateCashPayment(@RequestBody CashPayment cashPayment){
		log.info("updateCashPayment Controller");
		return cashPaymentRepoImpl.saveCashPayment(cashPayment);
	}
	
	@DeleteMapping("/deleteCashPayment/{id}")
	public void deleteCashPayment(@PathVariable Integer id){
		log.info("deleteCashPayment Controller");
		cashPaymentRepoImpl.deleteCashPayment(id);
	}
	
	@GetMapping("/truncateCashPayment")
	public String truncateCashPayment(){
		log.info("truncateCashPayment Controller");
		cashPaymentRepoImpl.truncateCashPayment();
		return "Truncated";
	}
	
}
