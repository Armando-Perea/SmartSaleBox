package com.java.smartsalebox;

import com.java.smartsalebox.client.CashClient;
import com.java.smartsalebox.models.Cash;

public class CashClientTest {

	public void createDummyCash() {
		Cash cash = new Cash();
		cash.setIdCash(2);
		cash.setNoSale(9);
		cash.setQuantity(569.00);
		cash = CashClient.addCash(cash);
		System.out.println("CASH CREATED: "+cash.toString());
	}
	
	public void updateDummyCash() {
		Cash cash = new Cash();
		cash.setIdCash(1);
		cash.setNoSale(8);
		cash.setQuantity(300.00);
		int response = CashClient.updateCash(cash);
		System.out.println("UPDATE RESPONSE: "+response);
	}
	
	public void getCashById(Integer id) {
		Cash cash = CashClient.getCashById(id);
		System.out.println("CASH ID: "+cash.toString());
	}
	
	public void deleteCash(Integer id) {
		Integer admin = CashClient.deleteCash(id);
		System.out.println("CASH REMOVED: "+admin);
	}

	public static void main(String[] args) {
		CashClientTest cashClientTest = new CashClientTest();
		//cashClientTest.createDummyCash();
		//cashClientTest.updateDummyCash();
		//cashClientTest.getCashById(1);
		cashClientTest.deleteCash(2);
		// EVERYTHING WORKING OK !!!
	}
	
}
