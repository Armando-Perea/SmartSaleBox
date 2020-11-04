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
import com.java.smartsalebox.models.ProductEarnings;

public class ProductEarningsClient {

	public static Logger logger = Logger.getLogger(ProductEarningsClient.class.getName());

	public static ProductEarnings[] getAllProductEarnings() {
		HttpHeaders headers = new HttpHeaders();
		ProductEarnings[] products = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/productEarnings/getAllPatients";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<ProductEarnings[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					ProductEarnings[].class);
			products = responseEntity.getBody();
			logger.info("Before Returning getAllProductEarnings");
			return products;
		} catch (Exception ex) {
			logger.error("ERROR GET ALL PRODUCTS EARNINGS: " + ex);
		}
		return products;
	}

	public static ProductEarnings getProductEarningsById(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		ProductEarnings product = new ProductEarnings();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/productEarnings/getProductEarningsById/{id}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<ProductEarnings> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					ProductEarnings.class, id);
			product = responseEntity.getBody();
			logger.info("Before Returning getProductById");
			return product;
		} catch (Exception ex) {
			logger.error("ERROR GET PRODUCT BY ID: " + ex);
		}
		return product;
	}
	
	public static ProductEarnings getProductEarningsByProductId(Integer idProduct) {
		HttpHeaders headers = new HttpHeaders();
		ProductEarnings product = new ProductEarnings();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/productEarnings/getProductEarningsByProductId/{idProduct}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<ProductEarnings> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					ProductEarnings.class, idProduct);
			product = responseEntity.getBody();
			logger.info("Before Returning getProductEarningsByProductId");
			return product;
		} catch (Exception ex) {
			logger.error("ERROR GET PRODUCT EARNING BY ID: " + ex);
		}
		return product;
	}

	public static ProductEarnings[] getProductEarningsByName(String name) {
		HttpHeaders headers = new HttpHeaders();
		ProductEarnings[] products = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/productEarnings/getProductEarningsByName/{name}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<ProductEarnings[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					ProductEarnings[].class, name);
			products = responseEntity.getBody();
			logger.info("Before Returning getProductEarningsByName");
			return products;
		} catch (Exception ex) {
			logger.error("ERROR GET PRODUCT EARNING BY NAME: " + ex);
		}
		return products;
	}

	public static ProductEarnings addProductEarnings(final ProductEarnings product) {
		HttpHeaders headers = new HttpHeaders();
		ProductEarnings productResponse = new ProductEarnings();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/productEarnings/createProductEarnings";
			HttpEntity<ProductEarnings> requestEntity = new HttpEntity<ProductEarnings>(product, headers);
			ResponseEntity<ProductEarnings> result = restTemplate.postForEntity(url, requestEntity, ProductEarnings.class);
			productResponse = result.getBody();
			logger.info("Before Returning addProductEarnings");
			return productResponse;
		} catch (Exception ex) {
			logger.error("ADD PRODUCT EARNINGS: " + productResponse.toString());
		}
		return productResponse;
	}

	public static Integer updateProductEarnings(final ProductEarnings product) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/productEarnings/updateProductEarnings";
		HttpEntity<ProductEarnings> requestEntity = new HttpEntity<ProductEarnings>(product, headers);
		try {
			ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(result);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			if (HttpStatus.NOT_FOUND.equals(httpClientOrServerExc.getStatusCode())
					|| HttpStatus.INTERNAL_SERVER_ERROR.equals(httpClientOrServerExc.getStatusCode())) {
				status = httpClientOrServerExc.getRawStatusCode();
			}
			logger.error("Catch Returning updateProductEarnings " + product.toString());
			return status;
		}
		logger.info("Before Returning updateProductEarnings");
		return status;
	}

	public static Integer deleteProductEarnings(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/productEarnings/deleteProductEarnings/{id}";
		HttpEntity<ProductEarnings> requestEntity = new HttpEntity<ProductEarnings>(headers);
		try {
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class,
					id);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(response);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			logger.error("ERROR deleteProductEarnings: " + httpClientOrServerExc);
			status = httpClientOrServerExc.getRawStatusCode();
			return status;
		}
		logger.info("Before Returning deleteProductEarnings");
		return status;
	}
	
	public static String truncateProductEarnings() {
		HttpHeaders headers = new HttpHeaders();
		String resp = "Not Processed";
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/cartSale/truncateProductEarnings";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					String.class);
			resp = responseEntity.getBody();
			logger.info("Before Returning truncateProductEarnings");
			return resp;
		} catch (Exception ex) {
			logger.error("ERROR TRUNCATE PRODUCT EARNINGS: " + ex);
		}
		return resp;
	}
	
}
