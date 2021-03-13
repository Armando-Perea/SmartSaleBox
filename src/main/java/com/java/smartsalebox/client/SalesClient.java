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
import com.java.smartsalebox.models.Sales;


public class SalesClient {

	public static Logger logger = Logger.getLogger(SalesClient.class.getName());

	public static Sales[] getAllSales() {
		HttpHeaders headers = new HttpHeaders();
		Sales[] sales = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/sales/getAllSales";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<Sales[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					Sales[].class);
			sales = responseEntity.getBody();
			logger.info("Before Returning getAllSales");
			return sales;
		} catch (Exception ex) {
			logger.error("ERROR GET ALL SALES: " + ex);
		}
		return sales;
	}
	
	public static Double getTotalSale() {
		HttpHeaders headers = new HttpHeaders();
		Double totalSale = 0.0;
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/sales/getTotalSale";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<Double> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					Double.class);
			totalSale = responseEntity.getBody();
			logger.info("Before Returning getTotalSale");
			return totalSale;
		} catch (Exception ex) {
			logger.error("ERROR GET TOTAL SALES: " + ex);
		}
		return totalSale;
	}

	public static Sales getSaleById(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		Sales sales = new Sales();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/sales/getSaleById/{id}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<Sales> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					Sales.class, id);
			sales = responseEntity.getBody();
			logger.info("Before Returning getProductById");
			return sales;
		} catch (Exception ex) {
			logger.error("ERROR GET SALE BY ID: " + ex);
		}
		return sales;
	}
	
	public static Sales getSaleByProductId(Integer productId) {
		HttpHeaders headers = new HttpHeaders();
		Sales sales = null;
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/sales/getSaleByProductId/{productId}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<Sales> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					Sales.class, productId);
			sales = responseEntity.getBody();
			logger.info("Before Returning getProductById");
			return sales;
		} catch (Exception ex) {
			logger.error("ERROR GET SALE BY ID: " + ex);
		}
		return sales;
	}
	
	public static Sales getSaleByProductIdAndNoSale(Integer idProduct, Integer noSale) {
		HttpHeaders headers = new HttpHeaders();
		Sales sales = null;
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/sales/getSaleByProductIdAndNoSale/{idProduct}/{noSale}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<Sales> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					Sales.class, idProduct,noSale);
			sales = responseEntity.getBody();
			logger.info("Before Returning getProductById");
			return sales;
		} catch (Exception ex) {
			logger.error("ERROR GET SALE BY ID: " + ex);
		}
		return sales;
	}

	public static Sales[] getSaleByNoSale(Integer noSale) {
		HttpHeaders headers = new HttpHeaders();
		Sales[] sales = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/sales/getSaleByNoSale/{noSale}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<Sales[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					Sales[].class, noSale);
			sales = responseEntity.getBody();
			logger.info("Before Returning getSaleByNoSale");
			return sales;
		} catch (Exception ex) {
			logger.error("ERROR GET SALE BY NOSALE: " + ex);
		}
		return sales;
	}

	public static Sales addSale(final Sales sale) {
		HttpHeaders headers = new HttpHeaders();
		Sales saleResponse = new Sales();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/sales/createSale";
			HttpEntity<Sales> requestEntity = new HttpEntity<Sales>(sale, headers);
			ResponseEntity<Sales> result = restTemplate.postForEntity(url, requestEntity, Sales.class);
			saleResponse = result.getBody();
			logger.info("Before Returning addSale");
			return saleResponse;
		} catch (Exception ex) {
			logger.error("ADD SALE: " + saleResponse.toString());
		}
		return saleResponse;
	}

	public static Integer updateSale(final Sales sales) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/sales/updateSale";
		HttpEntity<Sales> requestEntity = new HttpEntity<Sales>(sales, headers);
		try {
			ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(result);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			if (HttpStatus.NOT_FOUND.equals(httpClientOrServerExc.getStatusCode())
					|| HttpStatus.INTERNAL_SERVER_ERROR.equals(httpClientOrServerExc.getStatusCode())) {
				status = httpClientOrServerExc.getRawStatusCode();
			}
			logger.error("Catch Returning updateSale " + sales.toString());
			return status;
		}
		logger.info("Before Returning updateSale");
		return status;
	}

	public static Integer deleteSale(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/sales/deleteSale/{id}";
		HttpEntity<Sales> requestEntity = new HttpEntity<Sales>(headers);
		try {
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class,
					id);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(response);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			logger.error("ERROR deleteSale: " + httpClientOrServerExc);
			status = httpClientOrServerExc.getRawStatusCode();
			return status;
		}
		logger.info("Before Returning deleteSale");
		return status;
	}
	
	public static Integer deleteSaleByNoSale(Integer noSale) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/sales/deleteSaleByNoSale/{noSale}";
		HttpEntity<Sales> requestEntity = new HttpEntity<Sales>(headers);
		try {
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class,
					noSale);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(response);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			logger.error("ERROR deleteSaleByNoSale: " + httpClientOrServerExc);
			status = httpClientOrServerExc.getRawStatusCode();
			return status;
		}
		logger.info("Before Returning deleteSaleByNoSale");
		return status;
	}
	
	public static String truncateSales() {
		HttpHeaders headers = new HttpHeaders();
		String resp = "Not Processed";
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/sales/truncateSales";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					String.class);
			resp = responseEntity.getBody();
			logger.info("Before Returning truncateSales");
			return resp;
		} catch (Exception ex) {
			logger.error("ERROR TRUNCATE SALES " + ex);
		}
		return resp;
	}

}
