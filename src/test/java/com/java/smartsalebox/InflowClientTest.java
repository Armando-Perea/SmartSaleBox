package com.java.smartsalebox;

import java.util.Arrays;
import java.util.List;

import com.java.smartsalebox.client.InflowClient;
import com.java.smartsalebox.models.Inflow;

public class InflowClientTest {

	public void createDummyInflow() {
		Inflow inflow = new Inflow(); 
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
		inflow.setIdInflow(2);
		inflow.setInflowDate(date);
		inflow.setPaymentType("EFECTIVO TEST");
		inflow.setQuantity(380.00);
		inflow.setAttendee("TEST PEREZ");
		inflow.setConcept("Concetp Test");
		inflow.setDescription("Description Test");
		inflow = InflowClient.addInflow(inflow);
		System.out.println("INFLOW CREATED: "+inflow.toString());
	}
	
	public void updateDummyInflow() {
		Inflow inflow = new Inflow(); 
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
		inflow.setIdInflow(2);
		inflow.setInflowDate(date);
		inflow.setPaymentType("EFECTIVO TEST UPDATED");
		inflow.setQuantity(380.00);
		inflow.setAttendee("TEST PEREZ UPDATED");
		inflow.setConcept("Concetp Test UPDATED");
		inflow.setDescription("Description Test UPDATED");
		int response = InflowClient.updateInflow(inflow);
		System.out.println("UPDATE RESPONSE: "+response);
	}
	
	public void getAllInflow() {
		List<Inflow> admin = Arrays.asList(InflowClient.getAllInflow());
		admin.forEach(System.out::println);
	}
	
	public void getInflowById(Integer id) {
		Inflow employee = InflowClient.getInflowById(id);
		System.out.println("INFLOW ID: "+employee.toString());
	}
	
	public void getInflowByConcept(String concept) {
		List<Inflow> inflowList = Arrays.asList(InflowClient.getInflowByConcept(concept));
		inflowList.forEach(System.out::println);
	}
	
	public void getInflowByPaymentType(String paymentType) {
		List<Inflow> inflowList = Arrays.asList(InflowClient.getInflowByPaymentType(paymentType));
		inflowList.forEach(System.out::println);
	}
	
	public void deleteInflow(Integer id) {
		Integer admin = InflowClient.deleteInflow(id);
		System.out.println("INFLOW REMOVED: "+admin);
	}

	public static void main(String[] args) {
		InflowClientTest inflowClientTest = new InflowClientTest();
		//inflowClientTest.createDummyInflow();
		//inflowClientTest.updateDummyInflow();
		//inflowClientTest.getInflowById(1);
		//inflowClientTest.getInflowByConcept("Concetp Test");
		//inflowClientTest.getInflowByPaymentType("EFECTIVO TEST UPDATED");
		//inflowClientTest.getAllInflow();
		inflowClientTest.deleteInflow(2);
		// EVERYTHING WORKING OK !!!
	}
	
}
