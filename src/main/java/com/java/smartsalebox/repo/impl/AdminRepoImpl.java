package com.java.smartsalebox.repo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.java.smartsalebox.models.Administrator;
import com.java.smartsalebox.repository.AdminRepository;

@Repository
public class AdminRepoImpl {

	@Autowired
	AdminRepository adminRepository;
	
	public List<Administrator> getAllAdmins() {
		return (List<Administrator>) adminRepository.findAll();
	}
	
	public Optional<Administrator> getAdminById(Integer id) {
		return adminRepository.findById(id);
	}
	
	public List<Administrator> getAdminByNameAndPassword(String name, String pass) {
		return adminRepository.getAdminByNameAndPassword(name,pass);
	}
	
	public List<Administrator> getAdminByName(String name) {
		return adminRepository.findByName(name);
	}
	
	public Administrator saveAdmin(Administrator employee) {
		return adminRepository.save(employee);
	}
	
	public Administrator updateAdmin(Administrator employee) {
		return adminRepository.save(employee);
	}
	
	public void deleteAdmin(Integer id) {
		adminRepository.deleteById(id);
	}
	
	public void truncateAdmin() {
		adminRepository.truncateAdmin();
	}
}