package com.java.smartsalebox;

import java.util.Arrays;
import java.util.List;

import com.java.smartsalebox.client.SystemPathsClient;
import com.java.smartsalebox.models.SystemPaths;

public class SystemPathsClientTest {

	public void createDummySystemPaths() {
		SystemPaths systemPaths = new SystemPaths();
		systemPaths.setIdPath(1);
	     systemPaths.setClosurePdf("/home/armando/Documents/NewYorkCoffeeReports/ReporteCorte.pdf");
	     systemPaths.setInflowsPdf("/home/armando/Documents/NewYorkCoffeeReports/ReporteEntradas.pdf");
	     systemPaths.setOutflowsPdf("/home/armando/Documents/NewYorkCoffeeReports/ReporteSalidas.pdf");
	     systemPaths.setSalesPdf("/home/armando/Documents/NewYorkCoffeeReports/ReporteVentas.pdf");
	     systemPaths.setProductsPdf("/home/armando/Documents/NewYorkCoffeeReports/ReporteCheckin.pdf");
	     systemPaths.setProductEarningsPdf("/home/armando/Documents/NewYorkCoffeeReports/ReporteGananciaProductos.pdf");
	     systemPaths = SystemPathsClient.addSystemPath(systemPaths);
		System.out.println("SYSTEMPATHS CREATED: "+systemPaths.toString());
	}
	
	public void updateDummySystemPaths() {
		SystemPaths systemPaths = new SystemPaths();
		 systemPaths.setIdPath(2);
	     systemPaths.setClosurePdf("/updated/armando/Documents/NewYorkCoffeeReports/ReporteCorte.pdf");
	     systemPaths.setInflowsPdf("/updated/armando/Documents/NewYorkCoffeeReports/ReporteEntradas.pdf");
	     systemPaths.setOutflowsPdf("/updated/armando/Documents/NewYorkCoffeeReports/ReporteSalidas.pdf");
	     systemPaths.setSalesPdf("/updated/armando/Documents/NewYorkCoffeeReports/ReporteVentas.pdf");
	     systemPaths.setProductsPdf("/home/armando/Documents/NewYorkCoffeeReports/ReporteProductos.pdf");
	     systemPaths.setProductEarningsPdf("/home/armando/Documents/NewYorkCoffeeReports/ReporteGananciaProductos.pdf");
		int response = SystemPathsClient.updateSystemPath(systemPaths);
		System.out.println("UPDATE RESPONSE: "+response);
	}
	
	public void getAllSystemPaths() {
		List<SystemPaths> admin = Arrays.asList(SystemPathsClient.getAllSystemPaths());
		admin.forEach(System.out::println);
	}
	
	public void getSystemPathById(Integer id) {
		SystemPaths checkIn = SystemPathsClient.getSystemPathById(id);
		System.out.println("PATH ID: "+checkIn.toString());
	}
	
	public void deleteSystemPath(Integer id) {
		Integer admin = SystemPathsClient.deleteSystemPath(id);
		System.out.println("PATH REMOVED: "+admin);
	}

	public static void main(String[] args) {
		SystemPathsClientTest systemPathsClientTest = new SystemPathsClientTest();
		systemPathsClientTest.createDummySystemPaths();
		//systemPathsClientTest.updateDummySystemPaths();
		//systemPathsClientTest.getAllSystemPaths();
		//systemPathsClientTest.getSystemPathById(2);
		//systemPathsClientTest.deleteSystemPath(2);
		// EVERYTHING WORKING OK !!!
	}
	
}
