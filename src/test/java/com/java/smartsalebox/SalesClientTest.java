package com.java.smartsalebox;

import java.util.Arrays;
import java.util.List;

import com.java.smartsalebox.client.SalesClient;
import com.java.smartsalebox.models.Sales;

public class SalesClientTest {

	public void createDummySales() { 
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
	    Sales sales = new Sales();
	    sales.setIdSale(2);
	    sales.setNoSale(1);
	    sales.setDescription("TEST DESC");
	    sales.setPaymentType("EFECTIVO TEST");
	    sales.setUnits(2);
	    sales.setSaleDate(date);
	    sales.setTotal(200.00);
	    sales.setCardFare(15.00);
	    sales = SalesClient.addSale(sales);
		System.out.println("SALES CREATED: "+sales.toString());
	}
	
	public void updateDummySales() {
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
	    Sales sales = new Sales();
	    sales.setIdSale(2);
	    sales.setNoSale(1);
	    sales.setDescription("TEST DESC UPDATED");
	    sales.setPaymentType("EFECTIVO TEST UPDATED");
	    sales.setUnits(2);
	    sales.setSaleDate(date);
	    sales.setTotal(200.00);
	    sales.setCardFare(00.00);
		int response = SalesClient.updateSale(sales);
		System.out.println("UPDATE RESPONSE: "+response);
	}
	
	public void getAllSales() {
		List<Sales> admin = Arrays.asList(SalesClient.getAllSales());
		admin.forEach(System.out::println);
	}
	
	public void getSalesBySalesId(Integer id) {
		List<Sales> admin = Arrays.asList(SalesClient.getSaleById(id));
		System.out.println("SALE ID: "+admin.toString());
	}
	
	public void getSalesByNoSale(Integer noSale) {
		List<Sales> admin = Arrays.asList(SalesClient.getSaleByNoSale(noSale));
		System.out.println("NO SALE ID: "+admin.toString());
	}
	
	public void deleteSale(Integer id) {
		Integer admin = SalesClient.deleteSale(id);
		System.out.println("SALE REMOVED: "+admin);
	}

	public static void main(String[] args) {
		SalesClientTest salesClientTest = new SalesClientTest();
		//salesClientTest.createDummySales();
		//salesClientTest.updateDummySales();
		salesClientTest.getAllSales();
		//salesClientTest.getSalesByNoSale(1);
		//salesClientTest.getSalesBySalesId(1);
		//salesClientTest.deleteSale(2);
		// EVERYTHING WORKING OK !!!
	}
	
}
