package com.java.smartsalebox.repo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.java.smartsalebox.models.Employee;
import com.java.smartsalebox.repository.EmployeeRepository;

@Repository
public class EmployeeRepoImpl {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployee() {
		return (List<Employee>) employeeRepository.findAll();
	}
	
	public Optional<Employee> getEmployeeById(Integer id) {
		return employeeRepository.findById(id);
	}
	
	public List<Employee> getEmployeeByName(String name) {
		return employeeRepository.findByName(name);
	}
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}
}