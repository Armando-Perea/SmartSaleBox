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
import com.java.smartsalebox.models.CashPayment;

public class CashPaymentClient {

	public static Logger logger = Logger.getLogger(CartSaleClient.class.getName());

	public static CashPayment[] getAllCashPayment() {
		HttpHeaders headers = new HttpHeaders();
		CashPayment[] cashPayment = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/cashPayment/getAllCashPayment";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<CashPayment[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					CashPayment[].class);
			cashPayment = responseEntity.getBody();
			logger.info("Before Returning getAllCashPayment");
			return cashPayment;
		} catch (Exception ex) {
			logger.error("ERROR GET ALL CASH PAYMENTS: " + ex);
		}
		return cashPayment;
	}

	public static CashPayment getCashPaymentById(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		CashPayment cashPayment = new CashPayment();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/cashPayment/getCashPaymentById/{id}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<CashPayment> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					CashPayment.class, id);
			cashPayment = responseEntity.getBody();
			logger.info("Before Returning getCashPaymentById");
			return cashPayment;
		} catch (Exception ex) {
			logger.error("ERROR GET CASHPAYMENT BY ID: " + ex);
		}
		return cashPayment;
	}

	public static CashPayment addCashPayment(final CashPayment cashPayment) {
		HttpHeaders headers = new HttpHeaders();
		CashPayment cashPaymentResponse = new CashPayment();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/cashPayment/createCashPayment";
			HttpEntity<CashPayment> requestEntity = new HttpEntity<CashPayment>(cashPayment, headers);
			ResponseEntity<CashPayment> result = restTemplate.postForEntity(url, requestEntity, CashPayment.class);
			cashPaymentResponse = result.getBody();
			logger.info("Before Returning addCashPayment");
			return cashPaymentResponse;
		} catch (Exception ex) {
			logger.error("CashPayment: " + cashPaymentResponse.toString());
		}
		return cashPaymentResponse;
	}

	public static Integer updateCashPayment(final CashPayment cashPayment) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/cashPayment/updateCashPayment";
		HttpEntity<CashPayment> requestEntity = new HttpEntity<CashPayment>(cashPayment, headers);
		try {
			ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(result);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			if (HttpStatus.NOT_FOUND.equals(httpClientOrServerExc.getStatusCode())
					|| HttpStatus.INTERNAL_SERVER_ERROR.equals(httpClientOrServerExc.getStatusCode())) {
				status = httpClientOrServerExc.getRawStatusCode();
			}
			logger.error("Catch Returning updateCashPayment " + cashPayment.toString());
			return status;
		}
		logger.info("Before Returning updateCashPayment");
		return status;
	}

	public static Integer deleteCashPayment(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/cashPayment/deleteCashPayment/{id}";
		HttpEntity<CashPayment> requestEntity = new HttpEntity<CashPayment>(headers);
		try {
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class,
					id);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(response);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			logger.error("ERROR deleteCashPayment: " + httpClientOrServerExc);
			status = httpClientOrServerExc.getRawStatusCode();
			return status;
		}
		logger.info("Before Returning deleteCashPayment");
		return status;
	}
	
	public static String truncateCashPayment() {
		HttpHeaders headers = new HttpHeaders();
		String resp = "Not Processed";
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/cashPayment/truncateCashPayment";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					String.class);
			resp = responseEntity.getBody();
			logger.info("Before Returning truncateCashPayment");
			return resp;
		} catch (Exception ex) {
			logger.error("ERROR TRUNCATE CASH PAYMENT: " + ex);
		}
		return resp;
	}
	
}
