package com.java.smartsalebox;

import java.util.Arrays;
import java.util.List;

import com.java.smartsalebox.client.EmployeeClient;
import com.java.smartsalebox.models.Employee;

public class EmployeeClientTest {

	public void createDummyEmployee() {
		Employee employee = new Employee(); 
		employee.setIdEmployee(2);
		employee.setEmployeeName("TestName");
		employee.setEmployeeLastName("Test LastName");
		employee.setEmployeePhone("5526987454512457");
		employee.setEmployeeRole("Cajero");
		employee.setEmployeePassword("123");
		employee = EmployeeClient.addEmployee(employee);
		System.out.println("EMPLOYEE CREATED: "+employee.toString());
	}
	
	public void updateDummyEmployee() {
		Employee employee = new Employee(); 
		employee.setIdEmployee(2);
		employee.setEmployeeName("TestName UPDATED");
		employee.setEmployeeLastName("Test LastName");
		employee.setEmployeePhone("5526987454512457");
		employee.setEmployeeRole("Recepcionista");
		employee.setEmployeePassword("123");
		int response = EmployeeClient.updateEmployee(employee);
		System.out.println("UPDATE RESPONSE: "+response);
	}
	
	public void getAllEmployee() {
		List<Employee> admin = Arrays.asList(EmployeeClient.getAllEmployees());
		admin.forEach(System.out::println);
	}
	
	public void getEmployeeById(Integer id) {
		Employee employee = EmployeeClient.getEmployeeById(id);
		System.out.println("EMPLOYEE ID: "+employee.toString());
	}
	
	public void getEmployeeByName(String name) {
		List<Employee> admin = Arrays.asList(EmployeeClient.getEmployeeByName(name));
		admin.forEach(System.out::println);
	}
	
	public void deleteEmployee(Integer id) {
		Integer admin = EmployeeClient.deleteEmployee(id);
		System.out.println("EMPLOYEE REMOVED: "+admin);
	}

	public static void main(String[] args) {
		EmployeeClientTest employeeClientTest = new EmployeeClientTest();
		//employeeClientTest.createDummyEmployee();
		//employeeClientTest.updateDummyEmployee();
		//employeeClientTest.getEmployeeById(2);
		//employeeClientTest.getEmployeeByName("TEST");
		//employeeClientTest.getAllEmployee();
		employeeClientTest.deleteEmployee(2);
		// EVERYTHING WORKING OK !!!
	}
	
}
