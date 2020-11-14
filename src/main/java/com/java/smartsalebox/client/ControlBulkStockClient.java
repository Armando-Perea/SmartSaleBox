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
import com.java.smartsalebox.models.ControlBulkStock;

public class ControlBulkStockClient {

	public static Logger logger = Logger.getLogger(ControlBulkStockClient.class.getName());

	public static ControlBulkStock[] getAllControlBulkStock() {
		HttpHeaders headers = new HttpHeaders();
		ControlBulkStock[] products = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/controlBulkStock/getAllControlBulkStock";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<ControlBulkStock[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					ControlBulkStock[].class);
			products = responseEntity.getBody();
			logger.info("Before Returning getAllControlBulkStock");
			return products;
		} catch (Exception ex) {
			logger.error("ERROR GET ALL CONTROL BULK STOCK: " + ex);
		}
		return products;
	}

	public static ControlBulkStock getControlBulkStockById(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		ControlBulkStock product = new ControlBulkStock();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/controlBulkStock/getControlBulkStockById/{id}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<ControlBulkStock> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					ControlBulkStock.class, id);
			product = responseEntity.getBody();
			logger.info("Before Returning getControlBulkStockById");
			return product;
		} catch (Exception ex) {
			logger.error("ERROR GET CONTROL BULK STOCK BY ID: " + ex);
		}
		return product;
	}
	
	public static ControlBulkStock[] getControlBulkStockByIdProduct(Integer idProduct) {
		HttpHeaders headers = new HttpHeaders();
		ControlBulkStock[] controlProductStock = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/controlBulkStock/getControlBulkStockByIdProduct/{idProduct}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<ControlBulkStock[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					ControlBulkStock[].class, idProduct);
			controlProductStock = responseEntity.getBody();
			logger.info("Before Returning getControlBulkStockByIdProduct");
			return controlProductStock;
		} catch (Exception ex) {
			logger.error("ERROR GET getControlBulkStockByIdProduct: " + ex);
		}
		return controlProductStock;
	}

	

	public static ControlBulkStock addControlBulkStock(final ControlBulkStock controlProductStock) {
		HttpHeaders headers = new HttpHeaders();
		ControlBulkStock productResponse = new ControlBulkStock();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/controlBulkStock/createControlBulkStock";
			HttpEntity<ControlBulkStock> requestEntity = new HttpEntity<ControlBulkStock>(controlProductStock, headers);
			ResponseEntity<ControlBulkStock> result = restTemplate.postForEntity(url, requestEntity, ControlBulkStock.class);
			productResponse = result.getBody();
			logger.info("Before Returning addControlBulkStock");
			return productResponse;
		} catch (Exception ex) {
			logger.error("CREATE CONTROL BULK STOCK: " + productResponse.toString());
		}
		return productResponse;
	}

	public static Integer updateControlBulkStock(final ControlBulkStock controlBulkStock) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/controlBulkStock/updateControlBulkStock";
		HttpEntity<ControlBulkStock> requestEntity = new HttpEntity<ControlBulkStock>(controlBulkStock, headers);
		try {
			ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(result);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			if (HttpStatus.NOT_FOUND.equals(httpClientOrServerExc.getStatusCode())
					|| HttpStatus.INTERNAL_SERVER_ERROR.equals(httpClientOrServerExc.getStatusCode())) {
				status = httpClientOrServerExc.getRawStatusCode();
			}
			logger.error("Catch Returning updateControlBulkStock " + controlBulkStock.toString());
			return status;
		}
		logger.info("Before Returning updateControlBulkStock");
		return status;
	}

	public static Integer deleteControlBulkStock(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/controlBulkStock/deleteControlBulkStock/{id}";
		HttpEntity<ControlBulkStock> requestEntity = new HttpEntity<ControlBulkStock>(headers);
		try {
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class,
					id);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(response);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			logger.error("ERROR deleteControlProductStock: " + httpClientOrServerExc);
			status = httpClientOrServerExc.getRawStatusCode();
			return status;
		}
		logger.info("Before Returning deleteControlBulkStock");
		return status;
	}
	
	public static String truncateControlBulkStock() {
		HttpHeaders headers = new HttpHeaders();
		String resp = "Not Processed";
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/controlBulkStock/truncateControlBulkStock";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					String.class);
			resp = responseEntity.getBody();
			logger.info("Before Returning truncateControlBulkStock");
			return resp;
		} catch (Exception ex) {
			logger.error("ERROR TRUNCATE CONTROL PRODUCT STOCK " + ex);
		}
		return resp;
	}
	
}
