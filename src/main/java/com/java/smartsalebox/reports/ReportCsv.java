package com.java.smartsalebox.reports;

import java.io.*;
import java.sql.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;

public class ReportCsv {

	  public static void main(String[] args) {
          try {
                  Class.forName("com.mysql.jdbc.Driver").newInstance();
                  Connection connection = DriverManager.getConnection(
                                  "jdbc:mysql://localhost:33061/smartsalebox?useSSL=false", "root", "mysql");
                  PreparedStatement psmnt = null;
                  Statement st = connection.createStatement();
                  ResultSet rs = st.executeQuery("select * from inflow");

                  HSSFWorkbook wb = new HSSFWorkbook();
                  HSSFSheet sheet = wb.createSheet("Excel Sheet");
                  HSSFRow rowhead = sheet.createRow((short) 0);
                  rowhead.createCell((short) 0).setCellValue("idInflow");
                  rowhead.createCell((short) 1).setCellValue("Atendio");
                  rowhead.createCell((short) 2).setCellValue("Concepto");
                  rowhead.createCell((short) 3).setCellValue("Descripcion");
                  rowhead.createCell((short) 4).setCellValue("TipoPago");
                  rowhead.createCell((short) 5).setCellValue("Cantidad");
                  rowhead.createCell((short) 6).setCellValue("Fecha");

                  int index = 1;
                  while (rs.next()) {

                          HSSFRow row = sheet.createRow((short) index);
                          row.createCell((short) 0).setCellValue(rs.getInt(1));
                          row.createCell((short) 1).setCellValue(rs.getString(2));
                          row.createCell((short) 2).setCellValue(rs.getString(3));
                          row.createCell((short) 3).setCellValue(rs.getString(4));
                          row.createCell((short) 4).setCellValue(rs.getString(5));
                          row.createCell((short) 5).setCellValue(rs.getDouble(6));
                          row.createCell((short) 6).setCellValue(rs.getString(7));
                          index++;
                  }
                  FileOutputStream fileOut = new FileOutputStream("/home/armando/Documents/NewYorkCoffeeReports/excelEntradas.xls");
                  wb.write(fileOut);
                  fileOut.close();
                  System.out.println("Data is saved in excel file.");
                  rs.close();
                  connection.close();
          } catch (Exception e) {
        	  System.out.println("Exception: "+e.getMessage());
          }
  }
	  
}
