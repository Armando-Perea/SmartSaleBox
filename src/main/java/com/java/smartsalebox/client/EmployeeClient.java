package com.java.smartsalebox.client;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.java.smartsalebox.SmartSaleBoxApp;
import com.java.smartsalebox.models.Employee;

public class EmployeeClient {

	public static Logger logger = Logger.getLogger(EmployeeClient.class.getName());

	public static Employee[] getAllEmployees() {
		HttpHeaders headers = new HttpHeaders();
		Employee[] employees = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/employee/getAllEmployee";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<Employee[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					Employee[].class);
			employees = responseEntity.getBody();
			logger.info("Before Returning getAllEmployee");
			return employees;
		} catch (Exception ex) {
			logger.error("ERROR GET ALL EMPLOYEES: " + ex);
		}
		return employees;
	}

	public static Employee getEmployeeById(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		Employee employee = new Employee();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/employee/getEmployeeById/{id}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<Employee> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					Employee.class, id);
			employee = responseEntity.getBody();
			logger.info("Before Returning getAdminById");
			return employee;
		} catch (Exception ex) {
			logger.error("ERROR GET ADMIN BY ID: " + ex);
		}
		return employee;
	}

	public static Employee[] getEmployeeByName(String name) {
		HttpHeaders headers = new HttpHeaders();
		Employee[] Administrators = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/employee/getEmployeeByName/{name}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<Employee[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					Employee[].class, name);
			Administrators = responseEntity.getBody();
			logger.info("Before Returning getEmployeeByName");
			return Administrators;
		} catch (Exception ex) {
			logger.error("ERROR GET EMPLOYEE NAME: " + ex);
		}
		return Administrators;
	}

	public static Employee addEmployee(final Employee employee) {
		HttpHeaders headers = new HttpHeaders();
		Employee administratorResponse = new Employee();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/employee/createEmployee";
			HttpEntity<Employee> requestEntity = new HttpEntity<Employee>(employee, headers);
			ResponseEntity<Employee> result = restTemplate.postForEntity(url, requestEntity, Employee.class);
			administratorResponse = result.getBody();
			logger.info("Before Returning addEmployee");
			return employee;
		} catch (Exception ex) {
			logger.error("ADMINISTRATOR: " + administratorResponse.toString());
		}
		return administratorResponse;
	}

	public static Integer updateEmployee(final Employee employee) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/employee/updateEmployee";
		HttpEntity<Employee> requestEntity = new HttpEntity<Employee>(employee, headers);
		try {
			ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(result);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			if (HttpStatus.NOT_FOUND.equals(httpClientOrServerExc.getStatusCode())
					|| HttpStatus.INTERNAL_SERVER_ERROR.equals(httpClientOrServerExc.getStatusCode())) {
				status = httpClientOrServerExc.getRawStatusCode();
			}
			logger.error("Catch Returning updateEmployee " + employee.toString());
			return status;
		}
		logger.info("Before Returning updateEmployee");
		return status;
	}

	public static Integer deleteEmployee(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/employee/deleteEmployee/{id}";
		HttpEntity<Employee> requestEntity = new HttpEntity<Employee>(headers);
		try {
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class,
					id);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(response);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			logger.error("ERROR deleteEmployee: " + httpClientOrServerExc);
			status = httpClientOrServerExc.getRawStatusCode();
			return status;
		}
		logger.info("Before Returning deleteEmployee");
		return status;
	}

}
