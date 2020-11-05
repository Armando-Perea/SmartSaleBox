package com.java.smartsalebox;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.java.smartsalebox.models.SystemPaths;
import com.java.smartsalebox.repo.impl.SystemPathsRepoImpl;
import com.java.util.smartsalebox.utils.SmartSaleBoxConstants;

/**
 * Hello SmartSaleBoxApp!
 *
 */
@SpringBootApplication
public class SmartSaleBoxApp {
	
	public static final String SYSTEM_URL = "http://localhost:3001/smartsalebox/system";
	
	@Autowired
	SystemPathsRepoImpl systemPathsRepoImpl;
	
	public static void main( String[] args ){
        SpringApplication.run(SmartSaleBoxApp.class, args);
    }
	
	@PostConstruct
	private void initializeSystemPaths() {
		List<SystemPaths> systemPathsList = systemPathsRepoImpl.getAllSystemPaths();
		if(!systemPathsList.isEmpty()) {
			SmartSaleBoxConstants.INFLOW_PATH = systemPathsList.get(0).getInflowsPdf();
			SmartSaleBoxConstants.OUTFLOW_PATH = systemPathsList.get(0).getOutflowsPdf();
			SmartSaleBoxConstants.SALES_PATH = systemPathsList.get(0).getSalesPdf();
			SmartSaleBoxConstants.CLOSURE_PATH = systemPathsList.get(0).getClosurePdf();
			SmartSaleBoxConstants.PRODUCT_PATH = systemPathsList.get(0).getProductsPdf();
			SmartSaleBoxConstants.PRODUCT_EARNINGS_PATH = systemPathsList.get(0).getProductEarningsPdf();
		}
	}
}
