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

import com.java.smartsalebox.models.Closure;
import com.java.smartsalebox.repo.impl.ClosureRepoImpl;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("smartsalebox/system/closure")
public class ClosureController {

	@Autowired
	ClosureRepoImpl closureRepoImpl;
	
	@GetMapping("/getAllClosure")
	public List<Closure> getAllClosure(){
		log.info("getAllClosure Controller");
	 return closureRepoImpl.getAllClosure();
	}
	
	@GetMapping("/getClosureById/{id}")
	public Optional<Closure> getClosureById(@PathVariable Integer id){
		log.info("closureRepoImpl Controller");
	 return closureRepoImpl.getClosureById(id);
	}
	
	@PostMapping("/createClosure")
	public Closure createClosure(@RequestBody Closure closure){
		log.info("createClosure Controller");
	 return closureRepoImpl.saveClosure(closure);
	}
	
	@PutMapping("/updateClosure")
	public Closure updateClosure(@RequestBody Closure closure){
		log.info("updateClosure Controller");
	 return closureRepoImpl.updateClosure(closure);
	}
	
	@DeleteMapping("/deleteClosure/{id}")
	public void deleteClosure(@PathVariable Integer id){
		log.info("deleteClosure Controller");
		closureRepoImpl.deleteClosure(id);
	}
	
	@Transactional
	@GetMapping("/truncateClosure")
	public String truncateClosure(){
		log.info("truncateClosure Controller");
		closureRepoImpl.truncateClosure();
		return "Truncated";
	}
	
}
