package com.java.smartsalebox;

import java.util.Arrays;
import java.util.List;

import com.java.smartsalebox.client.EmailConfigClient;
import com.java.smartsalebox.models.EmailConfig;


public class EmailConfigClientTest {

	public void createDummyEmailConfig() {
		EmailConfig emailConfig = new EmailConfig(); 
		emailConfig.setIdEmail(2);
		emailConfig.setEmail("test_mail23@gmail.com");
		emailConfig.setPassword("12354678");
		emailConfig.setIsActiveService(true);
		emailConfig = EmailConfigClient.addEmailConfig(emailConfig);
		System.out.println("EMAIL CONFIG CREATED: "+emailConfig.toString());
	}
	
	public void updateDummyEmailConfig() {
		EmailConfig emailConfig = new EmailConfig(); 
		emailConfig.setIdEmail(2);
		emailConfig.setEmail("test_mail_updated@gmail.com");
		emailConfig.setPassword("123546Updated");
		emailConfig.setIsActiveService(true);
		int response = EmailConfigClient.updateEmailConfig(emailConfig);
		System.out.println("UPDATE RESPONSE: "+response);
	}
	
	public void getAllEmailConfig() {
		List<EmailConfig> admin = Arrays.asList(EmailConfigClient.getAllEmailConfig());
		admin.forEach(System.out::println);
	}
	
	public void getEmailConfigById(Integer id) {
		EmailConfig checkIn = EmailConfigClient.getEmailConfigById(id);
		System.out.println("EMAIL CONFIG ID: "+checkIn.toString());
	}
	
	public void deleteEmailConfig(Integer id) {
		Integer admin = EmailConfigClient.deleteEmailConfig(id);
		System.out.println("EMAIL CONFIG REMOVED: "+admin);
	}

	public static void main(String[] args) {
		EmailConfigClientTest emailConfigClientTest = new EmailConfigClientTest();
		//emailConfigClientTest.createDummyEmailConfig();
		//emailConfigClientTest.updateDummyEmailConfig();
		//emailConfigClientTest.getEmailConfigById(2);
		//emailConfigClientTest.getAllEmailConfig();
		emailConfigClientTest.deleteEmailConfig(2);
		// EVERYTHING WORKING OK !!!
	}
	
}
