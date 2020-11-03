package com.java.smartsalebox;

import java.util.Arrays;
import java.util.List;

import com.java.smartsalebox.client.OutflowClient;
import com.java.smartsalebox.models.Outflow;


public class OutflowClientTest {

	public void createDummyOutflow() {
		Outflow outflow = new Outflow(); 
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
	    outflow.setIdOutflow(2);
	    outflow.setOutflowDate(date);
	    outflow.setPaymentType("EFECTIVO TEST2");
	    outflow.setQuantity(380.00);
	    outflow.setAttendee("TEST PEREZ2");
	    outflow.setConcept("Concept Test2");
	    outflow.setDescription("Description Test2");
	    outflow = OutflowClient.addOutflow(outflow);
		System.out.println("OUTFLOW CREATED: "+outflow.toString());
	}
	
	public void updateDummyOutflow() {
		Outflow outflow = new Outflow(); 
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
	    outflow.setIdOutflow(2);
	    outflow.setOutflowDate(date);
	    outflow.setPaymentType("EFECTIVO TEST UPDATE2");
	    outflow.setQuantity(380.00);
	    outflow.setAttendee("TEST PEREZ UPDATE");
	    outflow.setConcept("Concetp Test UPDATE");
	    outflow.setDescription("Description Test UPDATE");
	    int response = OutflowClient.updateOutflow(outflow);
		System.out.println("UPDATE RESPONSE: "+response);
	}
	
	public void getAllOutflow() {
		List<Outflow> admin = Arrays.asList(OutflowClient.getAllOutflow());
		admin.forEach(System.out::println);
	}
	
	public void getOutflowById(Integer id) {
		Outflow employee = OutflowClient.getOutflowById(id);
		System.out.println("OUTFLOW ID: "+employee.toString());
	}
	
	public void getOutflowByConcept(String concept) {
		List<Outflow> inflowList = Arrays.asList(OutflowClient.getOutflowByConcept(concept));
		inflowList.forEach(System.out::println);
	}
	
	public void getOutflowByPaymentType(String paymentType) {
		List<Outflow> inflowList = Arrays.asList(OutflowClient.getOutflowByPaymentType(paymentType));
		inflowList.forEach(System.out::println);
	}
	
	public void deleteInflow(Integer id) {
		Integer admin = OutflowClient.deleteOutflow(id);
		System.out.println("OUTFLOW REMOVED: "+admin);
	}

	public static void main(String[] args) {
		OutflowClientTest outflowClientTest = new OutflowClientTest();
		outflowClientTest.createDummyOutflow();
		//outflowClientTest.updateDummyOutflow();
		//outflowClientTest.getOutflowById(1);
		//outflowClientTest.getAllOutflow();
		//outflowClientTest.deleteInflow(2);
		//outflowClientTest.getOutflowByConcept("Concetp Test UPDATE");
		//outflowClientTest.getOutflowByPaymentType("EFECTIVO TEST UPDATE");
		// EVERYTHING WORKING OK !!!
	}
	
}

