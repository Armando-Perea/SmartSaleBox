package com.java.smartsalebox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello SmartSaleBoxApp!
 *
 */
@SpringBootApplication
public class SmartSaleBoxApp {
	
	public static final String SYSTEM_URL = "http://localhost:3001/smartsalebox/system";
	
	public static void main( String[] args ){
        SpringApplication.run(SmartSaleBoxApp.class, args);
    }
}
