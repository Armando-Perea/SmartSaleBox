package com.java.smartsalebox;

import java.util.Arrays;
import java.util.List;

import com.java.smartsalebox.client.CartSaleClient;
import com.java.smartsalebox.models.CartSale;


public class CartSaleClientTest {

	public void createDummyCartSale() {
		CartSale cartSale = new CartSale();
		cartSale.setIdCartSale(2);
		cartSale.setNoSale(1);
		cartSale.setDescription("Test Desc 2");
		cartSale.setQuantity(3);
		cartSale.setTotal(489.90);
		cartSale = CartSaleClient.addCartSale(cartSale);
		System.out.println("CARTSALE CREATED: "+cartSale.toString());
	}
	
	public void updateDummyCartSale() {
		CartSale cartSale = new CartSale();
		cartSale.setIdCartSale(2);
		cartSale.setNoSale(2);
		cartSale.setDescription("Test Desc Updated");
		cartSale.setQuantity(4);
		cartSale.setTotal(896.90);
		int response = CartSaleClient.updateCartSale(cartSale);
		System.out.println("UPDATE RESPONSE: "+response);
	}
	
	public void getAllCartSale() {
		List<CartSale> admin = Arrays.asList(CartSaleClient.getAllCartSale());
		admin.forEach(System.out::println);
	}
	
	public void getCartSaleById(Integer id) {
		CartSale admin = CartSaleClient.getCartSaleById(id);
		System.out.println("CARTSALE ID: "+admin.toString());
	}
	
	public void getCartSaleByNoSale(Integer noSale) {
		List<CartSale> admin = Arrays.asList(CartSaleClient.getCartSaleByNoSale(noSale));
		admin.forEach(System.out::println);
	}
	
	public void deleteAdmin(Integer id) {
		Integer admin = CartSaleClient.deleteCartSale(id);
		System.out.println("CARTSALE REMOVED: "+admin);
	}

	public static void main(String[] args) {
		CartSaleClientTest cartSaleClientTest = new CartSaleClientTest();
		//cartSaleClientTest.createDummyCartSale();
		//cartSaleClientTest.updateDummyCartSale();
		//cartSaleClientTest.getCartSaleById(1);
		//cartSaleClientTest.getCartSaleByNoSale(2);
		//cartSaleClientTest.getAllCartSale();
		cartSaleClientTest.deleteAdmin(2);
		// EVERYTHING WORKING OK !!!
	}
	
}
