package com.java.smartsalebox;

import java.util.Arrays;
import java.util.List;

import com.java.smartsalebox.client.ClosureClient;
import com.java.smartsalebox.models.Closure;


public class ClosureClientTest {

	public void createDummyClosure() {
		Closure closure = new Closure();
		 long millis=System.currentTimeMillis();  
	     java.sql.Date date=new java.sql.Date(millis);  
	     closure.setIdClosure(2);
	     closure.setAttendee("ATTENDEE TEST");
	     closure.setCardPayments(100.0);
	     closure.setCashPayments(100.0);
	     closure.setClosureCash(100.0);
	     closure.setClosureDate(date.toString());
	     closure.setEarning(100.0);
	     closure.setInitCash(100.0);
	     closure.setProducts(100.0);
	     closure.setTotalInflow(100.0);
	     closure.setTotalOutflow(100.0);
	     closure = ClosureClient.addClosure(closure);
		System.out.println("CLOSURE CREATED: "+closure.toString());
	}
	
	public void updateDummyClosure() {
		Closure closure = new Closure();
		 long millis=System.currentTimeMillis();  
	     java.sql.Date date=new java.sql.Date(millis);  
	     closure.setIdClosure(2);
	     closure.setAttendee("ATTENDEE TEST UPDATED");
	     closure.setCardPayments(200.0);
	     closure.setCashPayments(200.0);
	     closure.setClosureCash(200.0);
	     closure.setClosureDate(date.toString());
	     closure.setEarning(200.0);
	     closure.setInitCash(200.0);
	     closure.setProducts(200.0);
	     closure.setTotalInflow(200.0);
	     closure.setTotalOutflow(200.0);
	     int number = ClosureClient.updateClosure(closure);
		System.out.println("UPDATED RESPONSE: "+number);
	}
	
	public void getAllClosure() {
		List<Closure> admin = Arrays.asList(ClosureClient.getAllClosure());
		admin.forEach(System.out::println);
	}
	
	public void getClosureById(Integer id) {
		Closure closure = ClosureClient.getClosureById(id);
		System.out.println("CLOSURE ID: "+closure.toString());
	}
	
	public void deleteClosure(Integer id) {
		Integer admin = ClosureClient.deleteClosure(id);
		System.out.println("CLOSURE IN REMOVED: "+admin);
	}

	public static void main(String[] args) {
		ClosureClientTest closureClientTest = new ClosureClientTest();
		//closureClientTest.createDummyClosure();
		//closureClientTest.updateDummyClosure();
		//closureClientTest.getClosureById(1);
		//closureClientTest.getAllClosure();
		closureClientTest.deleteClosure(2);
		// EVERYTHING WORKING OK !!!
	}
}
