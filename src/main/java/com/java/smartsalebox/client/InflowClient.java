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
import com.java.smartsalebox.models.Inflow;

public class InflowClient {

	public static Logger logger = Logger.getLogger(InflowClient.class.getName());

	public static Inflow[] getAllInflow() {
		HttpHeaders headers = new HttpHeaders();
		Inflow[] inflow = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/inflow/getAllInflow";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<Inflow[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					Inflow[].class);
			inflow = responseEntity.getBody();
			logger.info("Before Returning getAllInflow");
			return inflow;
		} catch (Exception ex) {
			logger.error("ERROR GET ALL INFLOWS: " + ex);
		}
		return inflow;
	}

	public static Inflow getInflowById(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		Inflow inflow = new Inflow();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/inflow/getInflowById/{id}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<Inflow> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					Inflow.class, id);
			inflow = responseEntity.getBody();
			logger.info("Before Returning getInflowById");
			return inflow;
		} catch (Exception ex) {
			logger.error("ERROR GET INFLOW BY ID: " + ex);
		}
		return inflow;
	}
	
	public static Inflow[] getInflowByConcept(String concept) {
		HttpHeaders headers = new HttpHeaders();
		Inflow[] inflow = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/inflow/getInflowByConcept/{concept}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<Inflow[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					Inflow[].class, concept);
			inflow = responseEntity.getBody();
			logger.info("Before Returning getInflowByConcept");
			return inflow;
		} catch (Exception ex) {
			logger.error("ERROR GET INFLOW CONCEPT: " + ex);
		}
		return inflow;
	}
	
	public static Inflow[] getInflowByPaymentType(String paymentType) {
		HttpHeaders headers = new HttpHeaders();
		Inflow[] inflow = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/inflow/getInflowByPaymentType/{paymentType}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<Inflow[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					Inflow[].class, paymentType);
			inflow = responseEntity.getBody();
			logger.info("Before Returning getInflowByPaymentType");
			return inflow;
		} catch (Exception ex) {
			logger.error("ERROR GET PAYMENTTYPE: " + ex);
		}
		return inflow;
	}

	public static Inflow addInflow(final Inflow inflow) {
		HttpHeaders headers = new HttpHeaders();
		Inflow inflowResponse = new Inflow();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/inflow/createInflow";
			HttpEntity<Inflow> requestEntity = new HttpEntity<Inflow>(inflow, headers);
			ResponseEntity<Inflow> result = restTemplate.postForEntity(url, requestEntity, Inflow.class);
			inflowResponse = result.getBody();
			logger.info("Before Returning addInflow");
			return inflowResponse;
		} catch (Exception ex) {
			logger.error("INFLOW: " + inflowResponse.toString());
		}
		return inflowResponse;
	}

	public static Integer updateInflow(final Inflow inflow) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/inflow/updateInflow";
		HttpEntity<Inflow> requestEntity = new HttpEntity<Inflow>(inflow, headers);
		try {
			ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(result);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			if (HttpStatus.NOT_FOUND.equals(httpClientOrServerExc.getStatusCode())
					|| HttpStatus.INTERNAL_SERVER_ERROR.equals(httpClientOrServerExc.getStatusCode())) {
				status = httpClientOrServerExc.getRawStatusCode();
			}
			logger.error("Catch Returning updateInflow " + inflow.toString());
			return status;
		}
		logger.info("Before Returning updateInflow");
		return status;
	}

	public static Integer deleteInflow(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/inflow/deleteInflow/{id}";
		HttpEntity<Inflow> requestEntity = new HttpEntity<Inflow>(headers);
		try {
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class,
					id);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(response);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			logger.error("ERROR deleteInflow: " + httpClientOrServerExc);
			status = httpClientOrServerExc.getRawStatusCode();
			return status;
		}
		logger.info("Before Returning deleteInflow");
		return status;
	}

}
