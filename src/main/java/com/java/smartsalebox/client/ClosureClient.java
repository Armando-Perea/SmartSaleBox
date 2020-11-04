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
import com.java.smartsalebox.models.Closure;


public class ClosureClient {

	public static Logger logger = Logger.getLogger(ClosureClient.class.getName());

	public static Closure[] getAllClosure() {
		HttpHeaders headers = new HttpHeaders();
		Closure[] closure = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/closure/getAllClosure";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<Closure[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					Closure[].class);
			closure = responseEntity.getBody();
			logger.info("Before Returning all closure");
			return closure;
		} catch (Exception ex) {
			logger.error("ERROR GET ALL CLOSURE: " + ex);
		}
		return closure;
	}

	public static Closure getClosureById(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		Closure closure = new Closure();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/closure/getClosureById/{id}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<Closure> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					Closure.class, id);
			closure = responseEntity.getBody();
			logger.info("Before Returning getClosureById");
			return closure;
		} catch (Exception ex) {
			logger.error("ERROR GET CLOSURE BY ID: " + ex);
		}
		return closure;
	}

	public static Closure addClosure(final Closure closure) {
		HttpHeaders headers = new HttpHeaders();
		Closure closureResponse = new Closure();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/closure/createClosure";
			HttpEntity<Closure> requestEntity = new HttpEntity<Closure>(closure, headers);
			ResponseEntity<Closure> result = restTemplate.postForEntity(url, requestEntity, Closure.class);
			closureResponse = result.getBody();
			logger.info("Before Returning addClosure");
			return closureResponse;
		} catch (Exception ex) {
			logger.error("addClosure: " + closureResponse.toString());
		}
		return closureResponse;
	}

	public static Integer updateClosure(final Closure closure) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/closure/updateClosure";
		HttpEntity<Closure> requestEntity = new HttpEntity<Closure>(closure, headers);
		try {
			ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(result);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			if (HttpStatus.NOT_FOUND.equals(httpClientOrServerExc.getStatusCode())
					|| HttpStatus.INTERNAL_SERVER_ERROR.equals(httpClientOrServerExc.getStatusCode())) {
				status = httpClientOrServerExc.getRawStatusCode();
			}
			logger.error("Catch Returning updateClosure " + closure.toString());
			return status;
		}
		logger.info("Before Returning updateClosure");
		return status;
	}

	public static Integer deleteClosure(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/closure/deleteClosure/{id}";
		HttpEntity<Closure> requestEntity = new HttpEntity<Closure>(headers);
		try {
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class,
					id);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(response);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			logger.error("ERROR deleteClosure: " + httpClientOrServerExc);
			status = httpClientOrServerExc.getRawStatusCode();
			return status;
		}
		logger.info("Before Returning deleteClosure");
		return status;
	}
	
	public static String truncateClosure() {
		HttpHeaders headers = new HttpHeaders();
		String resp = "Not Processed";
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/closure/truncateClosure";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					String.class);
			resp = responseEntity.getBody();
			logger.info("Before Returning truncateClosure");
			return resp;
		} catch (Exception ex) {
			logger.error("ERROR TRUNCATE CLOSURE " + ex);
		}
		return resp;
	}

}
