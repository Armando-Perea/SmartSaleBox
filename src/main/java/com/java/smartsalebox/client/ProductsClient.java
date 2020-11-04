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
import com.java.smartsalebox.models.Products;


public class ProductsClient {

	public static Logger logger = Logger.getLogger(ProductsClient.class.getName());

	public static Products[] getAllProducts() {
		HttpHeaders headers = new HttpHeaders();
		Products[] products = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/products/getAllProducts";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<Products[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					Products[].class);
			products = responseEntity.getBody();
			logger.info("Before Returning getAllProducts");
			return products;
		} catch (Exception ex) {
			logger.error("ERROR GET ALL PRODUCTS: " + ex);
		}
		return products;
	}

	public static Products getProductById(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		Products product = new Products();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/products/getProductById/{id}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<Products> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					Products.class, id);
			product = responseEntity.getBody();
			logger.info("Before Returning getProductById");
			return product;
		} catch (Exception ex) {
			logger.error("ERROR GET PRODUCT BY ID: " + ex);
		}
		return product;
	}

	public static Products[] getProductByName(String name) {
		HttpHeaders headers = new HttpHeaders();
		Products[] products = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/products/getProductByName/{name}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<Products[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					Products[].class, name);
			products = responseEntity.getBody();
			logger.info("Before Returning getPatientByName");
			return products;
		} catch (Exception ex) {
			logger.error("ERROR GET PRODUCT NAME: " + ex);
		}
		return products;
	}

	public static Products addProduct(final Products product) {
		HttpHeaders headers = new HttpHeaders();
		Products productResponse = new Products();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/products/createProduct";
			HttpEntity<Products> requestEntity = new HttpEntity<Products>(product, headers);
			ResponseEntity<Products> result = restTemplate.postForEntity(url, requestEntity, Products.class);
			productResponse = result.getBody();
			logger.info("Before Returning addProduct");
			return productResponse;
		} catch (Exception ex) {
			logger.error("ADD PRODUCT: " + productResponse.toString());
		}
		return productResponse;
	}

	public static Integer updateProduct(final Products product) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/products/updateProduct";
		HttpEntity<Products> requestEntity = new HttpEntity<Products>(product, headers);
		try {
			ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(result);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			if (HttpStatus.NOT_FOUND.equals(httpClientOrServerExc.getStatusCode())
					|| HttpStatus.INTERNAL_SERVER_ERROR.equals(httpClientOrServerExc.getStatusCode())) {
				status = httpClientOrServerExc.getRawStatusCode();
			}
			logger.error("Catch Returning updateProduct " + product.toString());
			return status;
		}
		logger.info("Before Returning updateProduct");
		return status;
	}

	public static Integer deleteProduct(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/products/deleteProduct/{id}";
		HttpEntity<Products> requestEntity = new HttpEntity<Products>(headers);
		try {
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class,
					id);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(response);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			logger.error("ERROR deleteProduct: " + httpClientOrServerExc);
			status = httpClientOrServerExc.getRawStatusCode();
			return status;
		}
		logger.info("Before Returning deleteProduct");
		return status;
	}
	
	public static String truncateProducts() {
		HttpHeaders headers = new HttpHeaders();
		String resp = "Not Processed";
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/products/truncateProducts";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					String.class);
			resp = responseEntity.getBody();
			logger.info("Before Returning truncateProduct");
			return resp;
		} catch (Exception ex) {
			logger.error("ERROR TRUNCATE PRODUCTS " + ex);
		}
		return resp;
	}
}
