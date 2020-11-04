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

import com.java.smartsalebox.models.Inflow;
import com.java.smartsalebox.repo.impl.InflowRepoImpl;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("smartsalebox/system/inflow")
public class InflowController {

	@Autowired
	InflowRepoImpl inflowRepoImpl;
	
	@GetMapping("/getAllInflow")
	public List<Inflow> getAllInflow(){
		log.info("getAllInflow Controller");
	 return inflowRepoImpl.getAllInflow();
	}
	
	@GetMapping("/getInflowById/{id}")
	public Optional<Inflow> getInflowById(@PathVariable Integer id){
		log.info("getInflowById Controller");
	 return inflowRepoImpl.getInflowById(id);
	}
	
	@GetMapping("/getInflowByConcept/{concept}")
	public List<Inflow> getInflowByConcept(@PathVariable String concept){
		log.info("getInflowByConcept Controller");
	 return inflowRepoImpl.getInflowByConcept(concept);
	}
	
	@GetMapping("/getInflowByPaymentType/{paymentType}")
	public List<Inflow> getInflowByPaymentType(@PathVariable String paymentType){
		log.info("getInflowByPaymentType Controller");
	 return inflowRepoImpl.getInflowByPaymentType(paymentType);
	}
	
	@PostMapping("/createInflow")
	public Inflow createInflow(@RequestBody Inflow inflow){
		log.info("createInflow Controller");
	 return inflowRepoImpl.saveInflow(inflow);
	}
	
	@PutMapping("/updateInflow")
	public Inflow updateInflow(@RequestBody Inflow inflow){
		log.info("updateInflow Controller");
	 return inflowRepoImpl.updateInflow(inflow);
	}
	
	@DeleteMapping("/deleteInflow/{id}")
	public void deleteInflow(@PathVariable Integer id){
		log.info("deleteInflow Controller");
		inflowRepoImpl.deleteInflow(id);
	}
	
	@Transactional
	@GetMapping("/truncateInflow")
	public String truncateInflow(){
		log.info("truncateInflow Controller");
		inflowRepoImpl.truncateInflow();
		return "Truncated";
	}
	
	
}
