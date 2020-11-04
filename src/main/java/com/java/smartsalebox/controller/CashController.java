package com.java.smartsalebox.controller;

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

import com.java.smartsalebox.models.Cash;
import com.java.smartsalebox.repo.impl.CashRepoImpl;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("smartsalebox/system/cash")
public class CashController {
	
	@Autowired
	CashRepoImpl cashRepoImpl;
	
	@GetMapping("/getCashById/{id}")
	public Optional<Cash> getCashById(@PathVariable Integer id){
		log.info("getCashById Controller");
	 return cashRepoImpl.getCashById(id);
	}
	
	@PostMapping("/createCash")
	public Cash createCash(@RequestBody Cash cash){
		log.info("createCash Controller");
	 return cashRepoImpl.saveCash(cash);
	}
	
	@PutMapping("/updateCash")
	public Cash updateCash(@RequestBody Cash cash){
		log.info("updateCash Controller");
	 return cashRepoImpl.saveCash(cash);
	}
	
	@DeleteMapping("/deleteCash/{id}")
	public void deleteCash(@PathVariable Integer id){
		log.info("deleteCash Controller");
		cashRepoImpl.deleteCash(id);
	}
	
	@Transactional
	@GetMapping("/truncateCash")
	public String truncateCash(){
		log.info("truncateCash Controller");
		cashRepoImpl.truncateCash();
		return "Truncated";
	}

}