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
import com.java.smartsalebox.models.ControlProductStock;

public class ControlProductStockClient {
	
	public static Logger logger = Logger.getLogger(ControlProductStockClient.class.getName());

	public static ControlProductStock[] getAllControlProductStock() {
		HttpHeaders headers = new HttpHeaders();
		ControlProductStock[] products = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/controlProductStock/getAllControlProductStock";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<ControlProductStock[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					ControlProductStock[].class);
			products = responseEntity.getBody();
			logger.info("Before Returning getAllProducts");
			return products;
		} catch (Exception ex) {
			logger.error("ERROR GET ALL CONTROL PRODUCT STOCK: " + ex);
		}
		return products;
	}

	public static ControlProductStock getControlProductStockById(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		ControlProductStock product = new ControlProductStock();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/controlProductStock/getControlProductStockById/{id}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<ControlProductStock> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					ControlProductStock.class, id);
			product = responseEntity.getBody();
			logger.info("Before Returning getControlProductStockById");
			return product;
		} catch (Exception ex) {
			logger.error("ERROR GET CONTROL PRODUCT STOCK BY ID: " + ex);
		}
		return product;
	}
	
	public static ControlProductStock[] getControlProductStockByIdProduct(Integer idProduct) {
		HttpHeaders headers = new HttpHeaders();
		ControlProductStock[] controlProductStock = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/controlProductStock/getControlProductStockByIdProduct/{idProduct}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<ControlProductStock[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					ControlProductStock[].class, idProduct);
			controlProductStock = responseEntity.getBody();
			logger.info("Before Returning getControlProductStockByIdProduct");
			return controlProductStock;
		} catch (Exception ex) {
			logger.error("ERROR GET getControlProductStockByIdProduct: " + ex);
		}
		return controlProductStock;
	}

	

	public static ControlProductStock addControlProductStock(final ControlProductStock controlProductStock) {
		HttpHeaders headers = new HttpHeaders();
		ControlProductStock productResponse = new ControlProductStock();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/controlProductStock/createControlProductStock";
			HttpEntity<ControlProductStock> requestEntity = new HttpEntity<ControlProductStock>(controlProductStock, headers);
			ResponseEntity<ControlProductStock> result = restTemplate.postForEntity(url, requestEntity, ControlProductStock.class);
			productResponse = result.getBody();
			logger.info("Before Returning updateControlProductStock");
			return productResponse;
		} catch (Exception ex) {
			logger.error("UPDATE CONTROL PRODUCT STOCK: " + productResponse.toString());
		}
		return productResponse;
	}

	public static Integer updateControlProductStock(final ControlProductStock controlProductStock) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/controlProductStock/updateControlProductStock";
		HttpEntity<ControlProductStock> requestEntity = new HttpEntity<ControlProductStock>(controlProductStock, headers);
		try {
			ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(result);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			if (HttpStatus.NOT_FOUND.equals(httpClientOrServerExc.getStatusCode())
					|| HttpStatus.INTERNAL_SERVER_ERROR.equals(httpClientOrServerExc.getStatusCode())) {
				status = httpClientOrServerExc.getRawStatusCode();
			}
			logger.error("Catch Returning updateControlProductStock " + controlProductStock.toString());
			return status;
		}
		logger.info("Before Returning updateControlProductStock");
		return status;
	}

	public static Integer deleteControlProductStock(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/controlProductStock/deleteControlProductStock/{id}";
		HttpEntity<ControlProductStock> requestEntity = new HttpEntity<ControlProductStock>(headers);
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
		logger.info("Before Returning deleteControlProductStock");
		return status;
	}
	
	public static String truncateControlProductStock() {
		HttpHeaders headers = new HttpHeaders();
		String resp = "Not Processed";
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/controlProductStock/truncateControlProductStock";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					String.class);
			resp = responseEntity.getBody();
			logger.info("Before Returning truncateControlProductStock");
			return resp;
		} catch (Exception ex) {
			logger.error("ERROR TRUNCATE CONTROL PRODUCT STOCK " + ex);
		}
		return resp;
	}

}
