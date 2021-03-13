package com.java.smartsalebox;

import java.util.Arrays;
import java.util.List;
import com.java.smartsalebox.client.ProductsClient;
import com.java.smartsalebox.models.Products;

public class ProductsClientTest {

	public void createDummyProduct() {  
	    Products products = new Products();
	    products.setIdProduct(3);
	    products.setProduct("TEST PRODUCT 2");
	    products.setCostPrice(100.00);
	    products.setEarning(560.00);
	    products.setStock(50);
	    products.setSalePrice(560.00);
	    products.setBarCode("123456789");
	    products = ProductsClient.addProduct(products);
		System.out.println("PRODUCT CREATED: "+products.toString());
	}
	
	public void updateDummyProduct() {
		 Products products = new Products();
		 products.setIdProduct(2);
		    products.setProduct("TEST PRODUCT UPDATED");
		    products.setCostPrice(100.00);
		    products.setEarning(200.00);
		    products.setStock(50);
		    products.setSalePrice(560.00);
		    products.setBarCode("123");
		int response = ProductsClient.updateProduct(products);
		System.out.println("UPDATE RESPONSE: "+response);
	}
	
	public void getProductByProductId(Integer id) {
		Products admin = ProductsClient.getProductById(id);
		System.out.println("PRODUCT PAYMENT ID: "+admin.toString());
	}
	
	public void getProductByBarCode(String barCode) {
		Products product = ProductsClient.getProductByBarCode(barCode);
		System.out.println("PRODUCT PAYMENT ID: "+product.toString());
	}
	
	public void getAllProducts() {
		List<Products> admin = Arrays.asList(ProductsClient.getAllProducts());
		admin.forEach(System.out::println);
	}
	
	public void getProductByProductName(String name) {
		List<Products> admin = Arrays.asList(ProductsClient.getProductByName(name));
		System.out.println("PRODUCT PAYMENT ID: "+admin.toString());
	}
	
	public void deleteProduct(Integer id) {
		Integer admin = ProductsClient.deleteProduct(id);
		System.out.println("PATIENT PAYMENT REMOVED: "+admin);
	}

	public static void main(String[] args) {
		ProductsClientTest productsClientTest = new ProductsClientTest();
		//productsClientTest.createDummyProduct();
		//productsClientTest.updateDummyProduct();
		//productsClientTest.getProductByProductId(2);
		//productsClientTest.getProductByProductName("Product");
		productsClientTest.getProductByBarCode("123");
		//productsClientTest.deleteProduct(2);
		//productsClientTest.getAllProducts();
		// EVERYTHING WORKING OK !!!
	}
	
}
