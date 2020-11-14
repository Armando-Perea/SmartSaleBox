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

import com.java.smartsalebox.models.ControlBulkStock;
import com.java.smartsalebox.repo.impl.ControlBulkStockRepoImpl;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("smartsalebox/system/controlBulkStock")
public class ControlBulkStockController {

	@Autowired
	ControlBulkStockRepoImpl controlBulkStockRepoImpl;
	
	@GetMapping("/getAllControlBulkStock")
	public List<ControlBulkStock> getAllControlBulkStock(){
		log.info("getAllControlBulkStock Controller");
	 return controlBulkStockRepoImpl.getAllControlBulkStock();
	}
	
	@GetMapping("/getControlBulkStockById/{id}")
	public Optional<ControlBulkStock> getControlBulkStockById(@PathVariable Integer id){
		log.info("getControlBulkStockById Controller");
	 return controlBulkStockRepoImpl.getControlBulkStockById(id);
	}
	
	@GetMapping("/getControlBulkStockByIdProduct/{idProduct}")
	public List<ControlBulkStock> getControlBulkStockByIdProduct(@PathVariable Integer idProduct){
		log.info("getControlBulkStockByIdProduct Controller");
	 return controlBulkStockRepoImpl.getControlBulkStockByIdProduct(idProduct);
	}
	
	@PostMapping("/createControlBulkStock")
	public ControlBulkStock createControlBulkStock(@RequestBody ControlBulkStock controlBulkStock){
		log.info("createControlBulkStock Controller");
	 return controlBulkStockRepoImpl.saveControlBulkStock(controlBulkStock);
	}
	
	@PutMapping("/updateControlBulkStock")
	public ControlBulkStock updateControlBulkStock(@RequestBody ControlBulkStock controlBulkStock){
		log.info("updateControlBulkStock Controller");
		return controlBulkStockRepoImpl.updateControlBulkStock(controlBulkStock);
	}
	
	@DeleteMapping("/deleteControlBulkStock/{id}")
	public void deleteControlBulkStock(@PathVariable Integer id){
		log.info("deleteControlBulkStock Controller");
		controlBulkStockRepoImpl.deleteControlBulkStock(id);
	}
	
	@Transactional
	@GetMapping("/truncateControlBulkStock")
	public String truncateControlBulkStock(){
		log.info("truncateControlBulkStock Controller");
		controlBulkStockRepoImpl.truncateControlBulkStock();
		return "Truncated";
	}
}
