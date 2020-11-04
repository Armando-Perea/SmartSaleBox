package com.java.smartsalebox;

import java.util.Arrays;
import java.util.List;

import org.springframework.scheduling.annotation.Async;

import com.java.smartsalebox.client.CartSaleClient;
import com.java.smartsalebox.client.ProductEarningsClient;
import com.java.smartsalebox.client.ProductsClient;
import com.java.smartsalebox.models.CartSale;
import com.java.smartsalebox.models.ProductEarnings;
import com.java.smartsalebox.models.Products;


public class ProductEarningsClientTests {

	public void createDummyProduct() {  
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
	    ProductEarnings productEarnings = new ProductEarnings();
	    productEarnings.setIdProductEarning(4);
	    productEarnings.setIdProduct(2);
	    productEarnings.setProductName("Test Prod");
	    productEarnings.setUnits(3);
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
	    productEarnings.setUnits(3);
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
	
	public void updateProductStock() {
		List<CartSale> cartSaleList = Arrays.asList(CartSaleClient.getAllCartSale());
		System.out.println("Si hay elementos en el carrito de ventas: ");
		cartSaleList.forEach(System.out::println);
		for(CartSale cartSale : cartSaleList) {
			System.out.println("Obteniendo Producto por ID: ");
			Products product = ProductsClient.getProductById(cartSale.getIdProduct());
			if(product != null) {
				System.out.println("Restando Stock");
				product.setStock(minusStockProductOperation(product.getStock(),cartSale.getUnits()));
				ProductsClient.updateProduct(product);
				System.out.println("Stock Actualizado!");
			}else {
				System.out.println("Producto No Existe!");
			}
		}
	}
	
	public static Integer minusStockProductOperation(Integer currentStock, Integer stockToDecrease) {
		return currentStock-stockToDecrease;
	}
	
	@Async
	public void fillProductEarning() {
		List<CartSale> cartSaleList = Arrays.asList(CartSaleClient.getAllCartSale());
		System.out.println("Si hay elementos en el carrito de ventas: ");
		cartSaleList.forEach(System.out::println);
		for(CartSale cartSale : cartSaleList) {
			System.out.println("Obteniendo Producto por ID: ");
			Products product = ProductsClient.getProductById(cartSale.getIdProduct());
			if(product != null) {
				System.out.println("Producto Existe!");
				System.out.println("Revisando si el producto ya esta registrado en la lista de ganancias");
				List<ProductEarnings> productEarningsList = Arrays.asList(ProductEarningsClient.getProductEarningsByProductId(cartSale.getIdProduct()));
				System.out.println("Si hay elementos en el reporte de ganancias: "+productEarningsList.size());
				productEarningsList.forEach(System.out::println);
					if(productEarningsList.get(0)==null) {
						System.out.println("Nuevo Producto Para Informe de ganancias");
						addEarning(product,cartSale,product.getStock());
					}else {
						System.out.println("Actualizando Producto para Informe de ganancias");
						updateEarning(productEarningsList.get(0),cartSale,product.getStock());
					}
				
			}else {
				System.out.println("Producto No Existe!");
			}
		}
		System.out.println("Proceso de reporte de ganancias terminado con exito!");
	    
	}
	
	public static void addEarning(Products product,CartSale cartSale,Integer stock) {
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
		ProductEarnings productEarnings = new ProductEarnings();
	    productEarnings.setIdProductEarning(0);
	    productEarnings.setIdProduct(product.getIdProduct());
	    productEarnings.setProductName(product.getProduct());
	    productEarnings.setUnits(cartSale.getUnits());
	    productEarnings.setUnitEarning(product.getEarning());
	    productEarnings.setTotalEarning(getTotalEarning(cartSale.getUnits(),product.getEarning()));
	    productEarnings.setProductStock(stock);
	    productEarnings.setSaleDate(date);
	    ProductEarningsClient.addProductEarnings(productEarnings);
	}
	
	public static void updateEarning(ProductEarnings productEarnings,CartSale cartSale,Integer stock) {
	    productEarnings.setUnits(sumNewQuantity(productEarnings.getUnits(),cartSale.getUnits()));
	    productEarnings.setTotalEarning(getTotalEarning(productEarnings.getUnits(),productEarnings.getUnitEarning()));
	    productEarnings.setProductStock(stock);
	    ProductEarningsClient.updateProductEarnings(productEarnings);
	}
	
	public static Integer sumNewQuantity(Integer quantity, Integer newQuantity) {
		return quantity+newQuantity;
	}
	
	public static Double getTotalEarning(Integer quantity, Double unitEarning) {
		return quantity*unitEarning;
	}

	public static void main(String[] args) {
		ProductEarningsClientTests productsClientTest = new ProductEarningsClientTests();
		//productsClientTest.createDummyProduct();
		//productsClientTest.updateDummyProduct();
		//productsClientTest.getProductEarningsById(2);
		//productsClientTest.getProductEarningsByProductId(2);
		//productsClientTest.getProductByProductName("3");
		//productsClientTest.deleteProductEarning(3);
		productsClientTest.updateProductStock();
		productsClientTest.fillProductEarning();
		System.out.println("Continua Venta Normal ...............................................");
		CartSaleClient.truncateCartSale();
		// EVERYTHING WORKING OK !!!
	}
	
}
