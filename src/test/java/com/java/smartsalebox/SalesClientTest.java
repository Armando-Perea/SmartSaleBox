package com.java.smartsalebox;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import com.java.smartsalebox.client.SalesClient;
import com.java.smartsalebox.models.Sales;

public class SalesClientTest {

	public void createDummySales() { 
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new Locale("es", "ES"));
		String formattedDate = myDateObj.format(myFormatObj);
	    Sales sales = new Sales();
	    sales.setIdSale(2);
	    sales.setNoSale(1);
	    sales.setDescription("TEST DESC");
	    sales.setUnits(2);
	    sales.setSaleDate(formattedDate);
	    sales.setTotal(200.00);
	    sales = SalesClient.addSale(sales);
		System.out.println("SALES CREATED: "+sales.toString());
	}
	
	public void updateDummySales() {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new Locale("es", "ES"));
		String formattedDate = myDateObj.format(myFormatObj);
	    Sales sales = new Sales();
	    sales.setIdSale(2);
	    sales.setNoSale(1);
	    sales.setDescription("TEST DESC UPDATED");
	    sales.setUnits(2);
	    sales.setSaleDate(formattedDate);
	    sales.setTotal(200.00);
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
	
	public void getSalesByProductIdAndNoSale(Integer idProduct,Integer noSale) {
		Sales sale = SalesClient.getSaleByProductIdAndNoSale(idProduct, noSale);
		System.out.println("NO SALE ID: "+sale.toString());
	}
	
	public void deleteSale(Integer id) {
		Integer admin = SalesClient.deleteSale(id);
		System.out.println("SALE REMOVED: "+admin);
	}

	public static void main(String[] args) {
		SalesClientTest salesClientTest = new SalesClientTest();
		//salesClientTest.createDummySales();
		//salesClientTest.updateDummySales();
		//salesClientTest.getAllSales();
		//salesClientTest.getSalesByProductIdAndNoSale(1,1);
		salesClientTest.getSalesByNoSale(1);
		//salesClientTest.getSalesBySalesId(1);
		//salesClientTest.deleteSale(2);
		// EVERYTHING WORKING OK !!!
	}
	
}
