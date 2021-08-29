package com.java.smartsalebox.client;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.java.smartsalebox.SmartSaleBoxApp;

public class ReportClient {
	
	public static Logger logger = Logger.getLogger(ReportClient.class.getName());
	
	public static Boolean generateClosureReports() {
		HttpHeaders headers = new HttpHeaders();
		String reportGeneratorResponse = "FAIL";
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
			String url = SmartSaleBoxApp.SYSTEM_URL + "/report/createClosureReports";
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			ResponseEntity<String> result = restTemplate.postForEntity(url, requestEntity, String.class);
			reportGeneratorResponse = result.getBody();
			logger.info("Before Returning Reports");
			return "OK".equals(reportGeneratorResponse);
		} catch (Exception ex) {
			logger.error("Generating Reports Error: " + reportGeneratorResponse.toString());
		}
		return "OK".equals(reportGeneratorResponse);
	}

}
