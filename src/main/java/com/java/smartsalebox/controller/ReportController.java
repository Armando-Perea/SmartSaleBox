package com.java.smartsalebox.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.java.smartsalebox.reports.ReportGenerator;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("smartsalebox/system/report")
public class ReportController {
	
	@PostMapping("/createClosureReports")
	public String createCash(){
		log.info("creating reports Controller");
		try {
			ReportGenerator.closureReport();
			ReportGenerator.outgoingsReport();
			ReportGenerator.incomesReport();
			ReportGenerator.salesReport();
			ReportGenerator.productEarningsReport();
			ReportGenerator.productReport();
		} catch (Exception e) {
			log.error("creating reports Controller Failed");
			return "ERROR "+e.getMessage();
		}
	 return "Report Success";
	}

}
