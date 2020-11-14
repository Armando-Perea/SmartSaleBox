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
import com.java.smartsalebox.models.BulkProducts;

public class BulkProductsClient {

	public static Logger logger = Logger.getLogger(BulkProductsClient.class.getName());

	public static BulkProducts[] getAllBulkProducts() {
		HttpHeaders headers = new HttpHeaders();
		BulkProducts[] products = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/bulkProducts/getAllBulkProducts";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<BulkProducts[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					BulkProducts[].class);
			products = responseEntity.getBody();
			logger.info("Before Returning getAllBulkProducts");
			return products;
		} catch (Exception ex) {
			logger.error("ERROR GET ALL BULK PRODUCTS: " + ex);
		}
		return products;
	}

	public static BulkProducts getBulkProductById(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		BulkProducts product = new BulkProducts();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/bulkProducts/getBulkProductsById/{id}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<BulkProducts> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					BulkProducts.class, id);
			product = responseEntity.getBody();
			logger.info("Before Returning getBulkProductById");
			return product;
		} catch (Exception ex) {
			logger.error("ERROR GET BULK PRODUCTS BY ID: " + ex);
		}
		return product;
	}

	public static BulkProducts[] getBulkProductByName(String name) {
		HttpHeaders headers = new HttpHeaders();
		BulkProducts[] products = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/bulkProducts/getBulkProductsByName/{name}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<BulkProducts[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					BulkProducts[].class, name);
			products = responseEntity.getBody();
			logger.info("Before Returning getBulkProductByName");
			return products;
		} catch (Exception ex) {
			logger.error("ERROR GET BULK PRODUCTS NAME: " + ex);
		}
		return products;
	}

	public static BulkProducts addBulkProduct(final BulkProducts product) {
		HttpHeaders headers = new HttpHeaders();
		BulkProducts productResponse = new BulkProducts();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/bulkProducts/createBulkProducts";
			HttpEntity<BulkProducts> requestEntity = new HttpEntity<BulkProducts>(product, headers);
			ResponseEntity<BulkProducts> result = restTemplate.postForEntity(url, requestEntity, BulkProducts.class);
			productResponse = result.getBody();
			logger.info("Before Returning addBulkProduct");
			return productResponse;
		} catch (Exception ex) {
			logger.error("ADD BULK PRODUCTS: " + productResponse.toString());
		}
		return productResponse;
	}

	public static Integer updateBulkProduct(final BulkProducts product) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/bulkProducts/updateBulkProducts";
		HttpEntity<BulkProducts> requestEntity = new HttpEntity<BulkProducts>(product, headers);
		try {
			ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(result);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			if (HttpStatus.NOT_FOUND.equals(httpClientOrServerExc.getStatusCode())
					|| HttpStatus.INTERNAL_SERVER_ERROR.equals(httpClientOrServerExc.getStatusCode())) {
				status = httpClientOrServerExc.getRawStatusCode();
			}
			logger.error("Catch Returning updateBulkProduct " + product.toString());
			return status;
		}
		logger.info("Before Returning updateBulkProduct");
		return status;
	}

	public static Integer deleteBulkProduct(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/bulkProducts/deleteBulkProduct/{id}";
		HttpEntity<BulkProducts> requestEntity = new HttpEntity<BulkProducts>(headers);
		try {
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class,
					id);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(response);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			logger.error("ERROR deleteBulkProduct: " + httpClientOrServerExc);
			status = httpClientOrServerExc.getRawStatusCode();
			return status;
		}
		logger.info("Before Returning deleteBulkProduct");
		return status;
	}
	
	public static String truncateBulkProducts() {
		HttpHeaders headers = new HttpHeaders();
		String resp = "Not Processed";
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/bulkProducts/truncateBulkProducts";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					String.class);
			resp = responseEntity.getBody();
			logger.info("Before Returning truncateBulkProducts");
			return resp;
		} catch (Exception ex) {
			logger.error("ERROR TRUNCATE BULK PRODUCTS " + ex);
		}
		return resp;
	}
	
}
