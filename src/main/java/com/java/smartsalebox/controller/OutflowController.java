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
import com.java.smartsalebox.models.Outflow;
import com.java.smartsalebox.repo.impl.OutflowRepoImpl;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("smartsalebox/system/outflow")
public class OutflowController {

	@Autowired
	OutflowRepoImpl outflowRepoImpl;
	
	@GetMapping("/getAllOutflow")
	public List<Outflow> getAllOutflow(){
		log.info("getAllOutflow Controller");
	 return outflowRepoImpl.getAllOutflow();
	}
	
	@GetMapping("/getTotalOutflow")
	public Double getTotalOutflow(){
		log.info("getTotalOutflow Controller");
		List<Outflow> outflowList = outflowRepoImpl.getAllOutflow();
		Double totalAmount = outflowList.stream().mapToDouble(total -> total.getQuantity()).sum();
	 return totalAmount;
	}
	
	@GetMapping("/getOutflowById/{id}")
	public Optional<Outflow> getOutflowById(@PathVariable Integer id){
		log.info("getOutflowById Controller");
	 return outflowRepoImpl.getOutflowById(id);
	}
	
	@GetMapping("/getOutflowByConcept/{concept}")
	public List<Outflow> getOutflowByConcept(@PathVariable String concept){
		log.info("getOutflowByConcept Controller");
	 return outflowRepoImpl.getOutflowByConcept(concept);
	}
	
	@GetMapping("/getOutflowByPaymentType/{paymentType}")
	public List<Outflow> getOutflowByPaymentType(@PathVariable String paymentType){
		log.info("getInflowByPaymentType Controller");
	 return outflowRepoImpl.getOutflowByPaymentType(paymentType);
	}
	
	@PostMapping("/createOutflow")
	public Outflow createOutflow(@RequestBody Outflow outflow){
		log.info("createOutflow Controller");
	 return outflowRepoImpl.saveOutflow(outflow);
	}
	
	@PutMapping("/updateOutflow")
	public Outflow updateOutflow(@RequestBody Outflow outflow){
		log.info("updateOutflow Controller");
	 return outflowRepoImpl.updateOutflow(outflow);
	}
	
	@DeleteMapping("/deleteOutflow/{id}")
	public void deleteOutflow(@PathVariable Integer id){
		log.info("deleteOutflow Controller");
		outflowRepoImpl.deleteOutflow(id);
	}
	
	@Transactional
	@GetMapping("/truncateOutflow")
	public String truncateOutflow(){
		log.info("truncateOutflow Controller");
		outflowRepoImpl.truncateOutflow();
		return "Truncated";
	}
	
	
}
