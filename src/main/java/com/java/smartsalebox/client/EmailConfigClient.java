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
import com.java.smartsalebox.models.EmailConfig;

public class EmailConfigClient {

	public static Logger logger = Logger.getLogger(EmailConfigClient.class.getName());

	public static EmailConfig[] getAllEmailConfig() {
		HttpHeaders headers = new HttpHeaders();
		EmailConfig[] emailConfig = {};
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/emailConfig/getAllEmailConfig";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<EmailConfig[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					EmailConfig[].class);
			emailConfig = responseEntity.getBody();
			logger.info("Before Returning all emailConfig");
			return emailConfig;
		} catch (Exception ex) {
			logger.error("ERROR GET ALL EMAILCONFIG: " + ex);
		}
		return emailConfig;
	}

	public static EmailConfig getEmailConfigById(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		EmailConfig emailConfig = new EmailConfig();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/emailConfig/getEmailConfigById/{id}";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<EmailConfig> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
					EmailConfig.class, id);
			emailConfig = responseEntity.getBody();
			logger.info("Before Returning getClosureById");
			return emailConfig;
		} catch (Exception ex) {
			logger.error("ERROR GET EMAIL CONFIG BY ID: " + ex);
		}
		return emailConfig;
	}

	public static EmailConfig addEmailConfig(final EmailConfig emailConfig) {
		HttpHeaders headers = new HttpHeaders();
		EmailConfig emailConfigResponse = new EmailConfig();
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/emailConfig/createEmailConfig";
			HttpEntity<EmailConfig> requestEntity = new HttpEntity<EmailConfig>(emailConfig, headers);
			ResponseEntity<EmailConfig> result = restTemplate.postForEntity(url, requestEntity, EmailConfig.class);
			emailConfigResponse = result.getBody();
			logger.info("Before Returning addClosure");
			return emailConfigResponse;
		} catch (Exception ex) {
			logger.error("addClosure: " + emailConfigResponse.toString());
		}
		return emailConfigResponse;
	}

	public static Integer updateEmailConfig(final EmailConfig emailConfig) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/emailConfig/updateEmailConfig";
		HttpEntity<EmailConfig> requestEntity = new HttpEntity<EmailConfig>(emailConfig, headers);
		try {
			ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(result);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			if (HttpStatus.NOT_FOUND.equals(httpClientOrServerExc.getStatusCode())
					|| HttpStatus.INTERNAL_SERVER_ERROR.equals(httpClientOrServerExc.getStatusCode())) {
				status = httpClientOrServerExc.getRawStatusCode();
			}
			logger.error("Catch Returning updateEmailConfig " + emailConfig.toString());
			return status;
		}
		logger.info("Before Returning updateEmailConfig");
		return status;
	}

	public static Integer deleteEmailConfig(Integer id) {
		HttpHeaders headers = new HttpHeaders();
		int status = 200;
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = SmartSaleBoxApp.SYSTEM_URL + "/emailConfig/deleteEmailConfig/{id}";
		HttpEntity<EmailConfig> requestEntity = new HttpEntity<EmailConfig>(headers);
		try {
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class,
					id);
			HttpStatus statusResponse = ClientResponseHandler.getHttpResponse(response);
			status = statusResponse.value();
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			logger.error("ERROR deleteEmailConfig: " + httpClientOrServerExc);
			status = httpClientOrServerExc.getRawStatusCode();
			return status;
		}
		logger.info("Before Returning deleteEmailConfig");
		return status;
	}

}
