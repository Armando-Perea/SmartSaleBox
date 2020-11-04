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

import com.java.smartsalebox.models.EmailConfig;
import com.java.smartsalebox.repo.impl.EmailConfigRepoImpl;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("smartsalebox/system/emailConfig")
public class EmailConfigController {

	@Autowired
	EmailConfigRepoImpl emailConfigRepoImpl;
	
	@GetMapping("/getAllEmailConfig")
	public List<EmailConfig> getAllEmailConfig(){
		log.info("getAllClosure Controller");
	 return emailConfigRepoImpl.getAllEmailConfig();
	}
	
	@GetMapping("/getEmailConfigById/{id}")
	public Optional<EmailConfig> getEmailConfigById(@PathVariable Integer id){
		log.info("getEmailConfigById Controller");
	 return emailConfigRepoImpl.getEmailConfigById(id);
	}
	
	@PostMapping("/createEmailConfig")
	public EmailConfig createEmailConfig(@RequestBody EmailConfig emailConfig){
		log.info("createEmailConfig Controller");
	 return emailConfigRepoImpl.saveEmailConfig(emailConfig);
	}
	
	@PutMapping("/updateEmailConfig")
	public EmailConfig updateEmailConfig(@RequestBody EmailConfig emailConfig){
		log.info("updateEmailConfig Controller");
	 return emailConfigRepoImpl.updateEmailConfig(emailConfig);
	}
	
	@DeleteMapping("/deleteEmailConfig/{id}")
	public void deleteEmailConfig(@PathVariable Integer id){
		log.info("deleteEmailConfig Controller");
		emailConfigRepoImpl.deleteEmailConfig(id);
	}
	
	@Transactional
	@GetMapping("/truncateEmailConfig")
	public String truncateEmailConfig(){
		log.info("truncateEmailConfig Controller");
		emailConfigRepoImpl.truncateEmailConfig();
		return "Truncated";
	}
	
}
