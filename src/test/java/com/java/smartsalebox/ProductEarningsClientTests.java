package com.java.smartsalebox;

import java.util.Arrays;
import java.util.List;
import com.java.smartsalebox.client.ProductEarningsClient;
import com.java.smartsalebox.models.ProductEarnings;


public class ProductEarningsClientTests {

	public void createDummyProduct() {  
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
	    ProductEarnings productEarnings = new ProductEarnings();
	    productEarnings.setIdProductEarning(4);
	    productEarnings.setIdProduct(2);
	    productEarnings.setProductName("Test Prod");
	    productEarnings.setSoldQuantity(3);
	    productEarnings.setUnitEarning(2.50);
	    productEarnings.setTotalEarning(7.50);
	    productEarnings.setSaleDate(date);
	    productEarnings = ProductEarningsClient.addProductEarnings(productEarnings);
		System.out.println("PRODUCT EARNING CREATED: "+productEarnings.toString());
	}
	
	public void updateDummyProduct() {
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
		ProductEarnings productEarnings = new ProductEarnings();
	    productEarnings.setIdProductEarning(3);
	    productEarnings.setIdProduct(2);
	    productEarnings.setProductName("Test Prod3");
	    productEarnings.setSoldQuantity(3);
	    productEarnings.setUnitEarning(2.50);
	    productEarnings.setTotalEarning(7.50);
	    productEarnings.setSaleDate(date);
		int response = ProductEarningsClient.updateProductEarnings(productEarnings);
		System.out.println("UPDATE RESPONSE: "+response);
	}
	
	public void getAllProductEarnings() {
		List<ProductEarnings> admin = Arrays.asList(ProductEarningsClient.getAllProductEarnings());
		admin.forEach(System.out::println);
	}
	
	public void getProductEarningsById(Integer id) {
		ProductEarnings productEarnings = ProductEarningsClient.getProductEarningsById(id);
		System.out.println("ProductEarningsClient ID: "+productEarnings.toString());
	}
	
	public void getProductEarningsByProductId(Integer idProduct) {
		List<ProductEarnings> productEarningsList = Arrays.asList(ProductEarningsClient.getProductEarningsByProductId(idProduct));
		System.out.println("PRODUCT EARNINGS ID: "+productEarningsList.toString());
	}
	
	public void getProductByProductName(String name) {
		List<ProductEarnings> productEarningsList = Arrays.asList(ProductEarningsClient.getProductEarningsByName(name));
		System.out.println("PRODUCT EARINIGS NAME: "+productEarningsList.toString());
	}
	
	public void deleteProductEarning(Integer id) {
		Integer admin = ProductEarningsClient.deleteProductEarnings(id);
		System.out.println("PRODUCT EARINIGS REMOVED: "+admin);
	}

	public static void main(String[] args) {
		ProductEarningsClientTests productsClientTest = new ProductEarningsClientTests();
		//productsClientTest.createDummyProduct();
		//productsClientTest.updateDummyProduct();
		//productsClientTest.getProductEarningsById(2);
		//productsClientTest.getProductEarningsByProductId(2);
		//productsClientTest.getProductByProductName("3");
		productsClientTest.deleteProductEarning(3);
		// EVERYTHING WORKING OK !!!
	}
	
}
