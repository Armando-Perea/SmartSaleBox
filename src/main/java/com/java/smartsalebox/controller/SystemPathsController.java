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

import com.java.smartsalebox.models.SystemPaths;
import com.java.smartsalebox.repo.impl.SystemPathsRepoImpl;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("smartsalebox/system/systempaths")
public class SystemPathsController {

	@Autowired
	SystemPathsRepoImpl systemPathsRepoImpl;
	
	@GetMapping("/getAllSystemPaths")
	public List<SystemPaths> getAllSystemPaths(){
		log.info("getAllSystemPaths Controller");
	 return systemPathsRepoImpl.getAllSystemPaths();
	}
	
	@GetMapping("/getSystemPathById/{id}")
	public Optional<SystemPaths> getSystemPathById(@PathVariable Integer id){
		log.info("getSystemPathById Controller");
	 return systemPathsRepoImpl.getSystemPathById(id);
	}
	
	@PostMapping("/createSystemPath")
	public SystemPaths createSystemPath(@RequestBody SystemPaths systemPaths){
		log.info("createSystemPath Controller");
	 return systemPathsRepoImpl.saveSystemPath(systemPaths);
	}
	
	@PutMapping("/updateSystemPath")
	public SystemPaths updateSystemPath(@RequestBody SystemPaths systemPaths){
		log.info("updateSystemPath Controller");
	 return systemPathsRepoImpl.saveSystemPath(systemPaths);
	}
	
	@DeleteMapping("/deleteSystemPath/{id}")
	public void deleteSystemPath(@PathVariable Integer id){
		log.info("deleteSystemPath Controller");
		systemPathsRepoImpl.deleteSystemPath(id);
	}
	
	@Transactional
	@GetMapping("/truncateSystemPaths")
	public String truncateSystemPaths(){
		log.info("truncateSystemPaths Controller");
		systemPathsRepoImpl.truncateSystemPaths();
		return "Truncated";
	}
}
