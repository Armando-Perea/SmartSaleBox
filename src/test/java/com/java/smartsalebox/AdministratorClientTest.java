package com.java.smartsalebox;

import java.util.Arrays;
import java.util.List;

import com.java.smartsalebox.client.AdministratorClient;
import com.java.smartsalebox.models.Administrator;

public class AdministratorClientTest {

	public void createDummyEmployee() {
		Administrator employee = new Administrator(); 
		employee.setIdAdministrator(2);
		employee.setAdminName("TestName");
		employee.setAdminLastName("Test LastName");
		employee.setAdminPhone("5526987454512457");
		employee.setAdminRole("Cajero");
		employee.setAdminPassword("123");
		employee = AdministratorClient.addAdmin(employee);
		System.out.println("EMPLOYEE CREATED: "+employee.toString());
	}
	
	public void updateDummyEmployee() {
		Administrator employee = new Administrator(); 
		employee.setIdAdministrator(2);
		employee.setAdminName("TestName UPDATED");
		employee.setAdminLastName("Test LastName");
		employee.setAdminPhone("5526987454512457");
		employee.setAdminRole("Recepcionista");
		employee.setAdminPassword("123");
		int response = AdministratorClient.updateAdmin(employee);
		System.out.println("UPDATE RESPONSE: "+response);
	}
	
	public void getAllEmployee() {
		List<Administrator> admin = Arrays.asList(AdministratorClient.getAllAdmins());
		admin.forEach(System.out::println);
	}
	
	public void getEmployeeById(Integer id) {
		Administrator employee = AdministratorClient.getAdminById(id);
		System.out.println("EMPLOYEE ID: "+employee.toString());
	}
	
	public void getEmployeeByName(String name) {
		List<Administrator> admin = Arrays.asList(AdministratorClient.getAdminByName(name));
		admin.forEach(System.out::println);
	}
	
	public void deleteEmployee(Integer id) {
		Integer admin = AdministratorClient.deleteAdmin(id);
		System.out.println("EMPLOYEE REMOVED: "+admin);
	}

	public static void main(String[] args) {
		AdministratorClientTest administratorClientTest = new AdministratorClientTest();
		//administratorClientTest.createDummyEmployee();
		//administratorClientTest.updateDummyEmployee();
		//administratorClientTest.getEmployeeById(2);
		//administratorClientTest.getEmployeeByName("TEST");
		//administratorClientTest.getAllEmployee();
		administratorClientTest.deleteEmployee(2);
		// EVERYTHING WORKING OK !!!
	}
	
}
