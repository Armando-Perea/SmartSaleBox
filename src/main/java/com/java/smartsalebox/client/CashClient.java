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
import com.java.smartsalebox.models.Cash;


public class CashClient {

	public static Logger logger = Logger.getLogger(CashClient.class.getName());

	public static Cash getCashById(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		Cash cartSale = new Cash();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/cash/getCashById/{id}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<Cash> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Cash.class,
					id);
			cartSale = responseEntity.getBody();
			logger.info("Before Returning getCashById");
			return cartSale;
		} catch (Exception ex) {
			logger.error("ERROR GET CASH BY ID: " + ex);
		}
		return cartSale;
	}

	public static Cash addCash(final Cash cash) {
		HttpHeaders headers = new HttpHeaders();
		Cash cashResponse = new Cash();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/cash/createCash";
			HttpEntity<Cash> requestEntity = new HttpEntity<Cash>(cash, headers);
			ResponseEntity<Cash> result = restTemplate.postForEntity(url, requestEntity, Cash.class);
			cashResponse = result.getBody();
			logger.info("Before Returning addCash");
			return cashResponse;
		} catch (Exception ex) {
			logger.error("addCash: " + cashResponse.toString());
		}
		return cashResponse;
	}

	public static Integer updateCash(final Cash cash) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/cash/updateCash";
		HttpEntity<Cash> requestEntity = new HttpEntity<Cash>(cash, headers);
		try {
			ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(result);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			if (HttpStatus.NOT_FOUND.equals(httpClientOrServerExc.getStatusCode())
					|| HttpStatus.INTERNAL_SERVER_ERROR.equals(httpClientOrServerExc.getStatusCode())) {
				status = httpClientOrServerExc.getRawStatusCode();
			}
			logger.error("Catch Returning updateCash " + cash.toString());
			return status;
		}
		logger.info("Before Returning updateCash");
		return status;
	}

	public static Integer deleteCash(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/cash/deleteCash/{id}";
		HttpEntity<Cash> requestEntity = new HttpEntity<Cash>(headers);
		try {
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class,
					id);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(response);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			logger.error("ERROR deleteCash: " + httpClientOrServerExc);
			status = httpClientOrServerExc.getRawStatusCode();
			return status;
		}
		logger.info("Before Returning deleteCash");
		return status;
	}
	
	public static String truncateCash() {
		HttpHeaders headers = new HttpHeaders();
		String resp = "Not Processed";
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/cash/truncateCash";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					String.class);
			resp = responseEntity.getBody();
			logger.info("Before Returning truncateCash");
			return resp;
		} catch (Exception ex) {
			logger.error("ERROR TRUNCATE CASH " + ex);
		}
		return resp;
	}

}
