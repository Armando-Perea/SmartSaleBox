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

import com.java.smartsalebox.models.Administrator;
import com.java.smartsalebox.repo.impl.AdminRepoImpl;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("smartsalebox/system/admin")
public class AdminController {

	@Autowired
	AdminRepoImpl adminRepoImpl;
	
	@GetMapping("/getAllAdmins")
	public List<Administrator> getAllAdmins(){
		log.info("getAllAdmins Controller");
	 return adminRepoImpl.getAllAdmins();
	}
	
	@GetMapping("/getAdminById/{id}")
	public Optional<Administrator> getAdminById(@PathVariable Integer id){
		log.info("getAdminById Controller");
	 return adminRepoImpl.getAdminById(id);
	}
	
	@GetMapping("/getAdminByNameAndPassword/{name}/{pass}")
	public List<Administrator> getAdminByNameAndPassword(@PathVariable String name,@PathVariable String pass){
		log.info("getAdminByPassword Controller");
	 return adminRepoImpl.getAdminByNameAndPassword(name,pass);
	}
	
	@GetMapping("/getAdminByName/{name}")
	public List<Administrator> getAdminByName(@PathVariable String name){
		log.info("getAdminByName Controller");
	 return adminRepoImpl.getAdminByName(name);
	}
	
	@PostMapping("/createAdmin")
	public Administrator createAdmin(@RequestBody Administrator employee){
		log.info("createAdmin Controller");
	 return adminRepoImpl.saveAdmin(employee);
	}
	
	@PutMapping("/updateAdmin")
	public Administrator updateAdmin(@RequestBody Administrator employee){
		log.info("updateAdmin Controller");
	 return adminRepoImpl.updateAdmin(employee);
	}
	
	@DeleteMapping("/deleteAdmin/{id}")
	public void deleteAdmin(@PathVariable Integer id){
		log.info("deleteAdmin Controller");
		adminRepoImpl.deleteAdmin(id);
	}
	
	@Transactional
	@GetMapping("/truncateAdmin")
	public String truncateAdmin(){
		log.info("truncateAdmin Controller");
		adminRepoImpl.truncateAdmin();
		return "Truncated";
	}
	
}
