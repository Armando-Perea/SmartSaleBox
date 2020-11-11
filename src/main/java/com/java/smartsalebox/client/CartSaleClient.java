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
import com.java.smartsalebox.models.CartSale;

public class CartSaleClient {

	public static Logger logger = Logger.getLogger(CartSaleClient.class.getName());

	public static CartSale[] getAllCartSale() {
		HttpHeaders headers = new HttpHeaders();
		CartSale[] cartSales = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/cartSale/getAllCartSale";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<CartSale[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					CartSale[].class);
			cartSales = responseEntity.getBody();
			logger.info("Before Returning getAllCartSale");
			return cartSales;
		} catch (Exception ex) {
			logger.error("ERROR GET ALL CARTSALE: " + ex);
		}
		return cartSales;
	}

	public static CartSale getCartSaleById(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		CartSale cartSale = new CartSale();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/cartSale/getCartSaleById/{id}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<CartSale> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					CartSale.class, id);
			cartSale = responseEntity.getBody();
			logger.info("Before Returning getCartSaleById");
			return cartSale;
		} catch (Exception ex) {
			logger.error("ERROR GET CARTSALE BY ID: " + ex);
		}
		return cartSale;
	}

	public static CartSale[] getCartSaleByNoSale(Integer noSale) {
		HttpHeaders headers = new HttpHeaders();
		CartSale[] cartSales = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/cartSale/getCartSaleByNoSale/{noSale}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<CartSale[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					CartSale[].class, noSale);
			cartSales = responseEntity.getBody();
			logger.info("Before Returning getCartSaleByNoSale");
			return cartSales;
		} catch (Exception ex) {
			logger.error("ERROR GET getCartSaleByNoSale: " + ex);
		}
		return cartSales;
	}

	public static CartSale addCartSale(final CartSale cartSale) {
		HttpHeaders headers = new HttpHeaders();
		CartSale cartSaleResponse = new CartSale();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/cartSale/createCartSale";
			HttpEntity<CartSale> requestEntity = new HttpEntity<CartSale>(cartSale, headers);
			ResponseEntity<CartSale> result = restTemplate.postForEntity(url, requestEntity, CartSale.class);
			cartSaleResponse = result.getBody();
			logger.info("Before Returning addCartSale");
			return cartSaleResponse;
		} catch (Exception ex) {
			logger.error("CartSale: " + cartSaleResponse.toString());
		}
		return cartSaleResponse;
	}

	public static Integer updateCartSale(final CartSale cartSale) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/cartSale/updateCartSale";
		HttpEntity<CartSale> requestEntity = new HttpEntity<CartSale>(cartSale, headers);
		try {
			ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(result);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			if (HttpStatus.NOT_FOUND.equals(httpClientOrServerExc.getStatusCode())
					|| HttpStatus.INTERNAL_SERVER_ERROR.equals(httpClientOrServerExc.getStatusCode())) {
				status = httpClientOrServerExc.getRawStatusCode();
			}
			logger.error("Catch Returning updateCartSale " + cartSale.toString());
			return status;
		}
		logger.info("Before Returning updateCartSale");
		return status;
	}

	public static Integer deleteCartSale(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/cartSale/deleteCartSale/{id}";
		HttpEntity<CartSale> requestEntity = new HttpEntity<CartSale>(headers);
		try {
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class,
					id);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(response);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			logger.error("ERROR deleteCartSale: " + httpClientOrServerExc);
			status = httpClientOrServerExc.getRawStatusCode();
			return status;
		}
		logger.info("Before Returning deleteCartSale");
		return status;
	}
	
	public static String truncateCartSale() {
		HttpHeaders headers = new HttpHeaders();
		String resp = "Not Processed";
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/cartSale/truncateCartSale";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					String.class);
			resp = responseEntity.getBody();
			logger.info("Before Returning truncateCartSale");
			return resp;
		} catch (Exception ex) {
			logger.error("ERROR TRUNCATE CARTSALE: " + ex);
		}
		return resp;
	}

}
