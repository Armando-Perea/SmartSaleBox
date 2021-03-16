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
import com.java.smartsalebox.models.Administrator;

public class AdministratorClient {

	public static Logger logger = Logger.getLogger(AdministratorClient.class.getName());

	public static Administrator[] getAllAdmins() {
		HttpHeaders headers = new HttpHeaders();
		Administrator[] employees = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/admin/getAllAdmins";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<Administrator[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					Administrator[].class);
			employees = responseEntity.getBody();
			logger.info("Before Returning getAllEmployee");
			return employees;
		} catch (Exception ex) {
			logger.error("ERROR GET ALL EMPLOYEES: " + ex);
		}
		return employees;
	}

	public static Administrator getAdminById(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		Administrator employee = new Administrator();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/admin/getAdminById/{id}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<Administrator> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					Administrator.class, id);
			employee = responseEntity.getBody();
			logger.info("Before Returning getAdminById");
			return employee;
		} catch (Exception ex) {
			logger.error("ERROR GET ADMIN BY ID: " + ex);
		}
		return employee;
	}
	
	public static Administrator[] getAdminByNameAndPassword(String name,String pass) {
		HttpHeaders headers = new HttpHeaders();
		Administrator[] Administrators = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/admin/getAdminByNameAndPassword/{name}/{pass}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<Administrator[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					Administrator[].class, name,pass);
			Administrators = responseEntity.getBody();
			logger.info("Before Returning getAdminByNameAndPassword");
			return Administrators;
		} catch (Exception ex) {
			logger.error("ERROR GET ADMIN NAME AND PASS: " + ex);
		}
		return Administrators;
	}

	public static Administrator[] getAdminByName(String name) {
		HttpHeaders headers = new HttpHeaders();
		Administrator[] Administrators = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/admin/getAdminByName/{name}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<Administrator[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					Administrator[].class, name);
			Administrators = responseEntity.getBody();
			logger.info("Before Returning getAdminByName");
			return Administrators;
		} catch (Exception ex) {
			logger.error("ERROR GET ADMIN NAME: " + ex);
		}
		return Administrators;
	}

	public static Administrator addAdmin(final Administrator admin) {
		HttpHeaders headers = new HttpHeaders();
		Administrator administratorResponse = new Administrator();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/admin/createAdmin";
			HttpEntity<Administrator> requestEntity = new HttpEntity<Administrator>(admin, headers);
			ResponseEntity<Administrator> result = restTemplate.postForEntity(url, requestEntity, Administrator.class);
			administratorResponse = result.getBody();
			logger.info("Before Returning addAdmin");
			return admin;
		} catch (Exception ex) {
			logger.error("ADMINISTRATOR: " + administratorResponse.toString());
		}
		return administratorResponse;
	}

	public static Integer updateAdmin(final Administrator admin) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/admin/updateAdmin";
		HttpEntity<Administrator> requestEntity = new HttpEntity<Administrator>(admin, headers);
		try {
			ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(result);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			if (HttpStatus.NOT_FOUND.equals(httpClientOrServerExc.getStatusCode())
					|| HttpStatus.INTERNAL_SERVER_ERROR.equals(httpClientOrServerExc.getStatusCode())) {
				status = httpClientOrServerExc.getRawStatusCode();
			}
			logger.error("Catch Returning updateAdmin " + admin.toString());
			return status;
		}
		logger.info("Before Returning updateAdmin");
		return status;
	}

	public static Integer deleteAdmin(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/admin/deleteAdmin/{id}";
		HttpEntity<Administrator> requestEntity = new HttpEntity<Administrator>(headers);
		try {
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class,
					id);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(response);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			logger.error("ERROR deleteAdmin: " + httpClientOrServerExc);
			status = httpClientOrServerExc.getRawStatusCode();
			return status;
		}
		logger.info("Before Returning deleteAdmin");
		return status;
	}
	
	public static String truncateAdmin() {
		HttpHeaders headers = new HttpHeaders();
		String resp = "Not Processed";
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/admin/truncateAdmin";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					String.class);
			resp = responseEntity.getBody();
			logger.info("Before Returning truncateAdmin");
			return resp;
		} catch (Exception ex) {
			logger.error("ERROR TRUNCATE ADMIN " + ex);
		}
		return resp;
	}

}
