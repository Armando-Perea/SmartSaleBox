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
import com.java.smartsalebox.models.Outflow;


public class OutflowClient {

	public static Logger logger = Logger.getLogger(OutflowClient.class.getName());

	public static Outflow[] getAllOutflow() {
		HttpHeaders headers = new HttpHeaders();
		Outflow[] outflow = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/outflow/getAllOutflow";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<Outflow[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					Outflow[].class);
			outflow = responseEntity.getBody();
			logger.info("Before Returning getAllOutflow");
			return outflow;
		} catch (Exception ex) {
			logger.error("ERROR GET ALL OUTFLOWS: " + ex);
		}
		return outflow;
	}

	public static Outflow getOutflowById(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		Outflow outflow = new Outflow();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/outflow/getOutflowById/{id}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<Outflow> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					Outflow.class, id);
			outflow = responseEntity.getBody();
			logger.info("Before Returning getInflowById");
			return outflow;
		} catch (Exception ex) {
			logger.error("ERROR GET OUTFLOW BY ID: " + ex);
		}
		return outflow;
	}
	
	public static Outflow[] getOutflowByConcept(String concept) {
		HttpHeaders headers = new HttpHeaders();
		Outflow[] outflow = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/outflow/getOutflowByConcept/{concept}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<Outflow[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					Outflow[].class, concept);
			outflow = responseEntity.getBody();
			logger.info("Before Returning getOutflowByPaymentType");
			return outflow;
		} catch (Exception ex) {
			logger.error("ERROR GET CONCEPT: " + ex);
		}
		return outflow;
	}
	
	public static Outflow[] getOutflowByPaymentType(String paymentType) {
		HttpHeaders headers = new HttpHeaders();
		Outflow[] outflow = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/outflow/getOutflowByPaymentType/{paymentType}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<Outflow[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					Outflow[].class, paymentType);
			outflow = responseEntity.getBody();
			logger.info("Before Returning getOutflowByPaymentType");
			return outflow;
		} catch (Exception ex) {
			logger.error("ERROR GET PAYMENTTYPE: " + ex);
		}
		return outflow;
	}

	public static Outflow addOutflow(final Outflow outflow) {
		HttpHeaders headers = new HttpHeaders();
		Outflow outflowResponse = new Outflow();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/outflow/createOutflow";
			HttpEntity<Outflow> requestEntity = new HttpEntity<Outflow>(outflow, headers);
			ResponseEntity<Outflow> result = restTemplate.postForEntity(url, requestEntity, Outflow.class);
			outflowResponse = result.getBody();
			logger.info("Before Returning addOutflow");
			return outflowResponse;
		} catch (Exception ex) {
			logger.error("OUTFLOW: " + outflowResponse.toString());
		}
		return outflowResponse;
	}

	public static Integer updateOutflow(final Outflow outflow) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/outflow/updateOutflow";
		HttpEntity<Outflow> requestEntity = new HttpEntity<Outflow>(outflow, headers);
		try {
			ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(result);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			if (HttpStatus.NOT_FOUND.equals(httpClientOrServerExc.getStatusCode())
					|| HttpStatus.INTERNAL_SERVER_ERROR.equals(httpClientOrServerExc.getStatusCode())) {
				status = httpClientOrServerExc.getRawStatusCode();
			}
			logger.error("Catch Returning updateOutflow " + outflow.toString());
			return status;
		}
		logger.info("Before Returning updateOutflow");
		return status;
	}

	public static Integer deleteOutflow(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/outflow/deleteOutflow/{id}";
		HttpEntity<Outflow> requestEntity = new HttpEntity<Outflow>(headers);
		try {
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class,
					id);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(response);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			logger.error("ERROR deleteOutflow: " + httpClientOrServerExc);
			status = httpClientOrServerExc.getRawStatusCode();
			return status;
		}
		logger.info("Before Returning deleteOutflow");
		return status;
	}

}
