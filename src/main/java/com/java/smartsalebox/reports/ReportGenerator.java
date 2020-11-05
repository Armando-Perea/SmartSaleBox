package com.java.smartsalebox.reports;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import org.apache.log4j.Logger;
import com.java.util.smartsalebox.utils.SmartSaleBoxConstants;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public class ReportGenerator {

	public static Logger logger = Logger.getLogger(ReportGenerator.class.getName());

	@SuppressWarnings("deprecation")
	public static void salesReport() throws SQLException {
		ReportConnection cn = new ReportConnection();
		JasperReport jr = null;
		try {
			Map<String, Object> parameters = new HashMap<>();
			InputStream inputStream = ReportGenerator.class.getClassLoader()
					.getResourceAsStream(SmartSaleBoxConstants.PATH_IMAGE);
			parameters.put("smartBoxImage", ImageIO.read(new ByteArrayInputStream(JRLoader.loadBytes(inputStream))));
			InputStream is = ReportGenerator.class.getClassLoader()
					.getResourceAsStream(SmartSaleBoxConstants.JASPER_PATH_SALES);
			jr = (JasperReport) JRLoader.loadObject(is);
			JasperPrint jp = JasperFillManager.fillReport(jr, parameters, cn.conexion());
			JRExporter exp = new JRPdfExporter();
			exp.setParameter(JRExporterParameter.JASPER_PRINT, jp);
			exp.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(SmartSaleBoxConstants.SALES_PATH));
			exp.exportReport();
		} catch (JRException | IOException ex) {
			java.util.logging.Logger.getLogger(ReportGenerator.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
			logger.info(SmartSaleBoxConstants.REPORT_GENERATION_ERROR + " " + ex);
		}
	}

	@SuppressWarnings("deprecation")
	public static void incomesReport() throws SQLException {
		ReportConnection cn = new ReportConnection();
		JasperReport jr = null;
		try {
			Map<String, Object> parameters = new HashMap<>();
			InputStream inputStream = ReportGenerator.class.getClassLoader()
					.getResourceAsStream(SmartSaleBoxConstants.PATH_IMAGE);
			parameters.put("smartBoxImage", ImageIO.read(new ByteArrayInputStream(JRLoader.loadBytes(inputStream))));
			InputStream is = ReportGenerator.class.getClassLoader()
					.getResourceAsStream(SmartSaleBoxConstants.JASPER_PATH_INCOMES);
			jr = (JasperReport) JRLoader.loadObject(is);
			JasperPrint jp = JasperFillManager.fillReport(jr, parameters, cn.conexion());

			JRExporter exp = new JRPdfExporter();
			exp.setParameter(JRExporterParameter.JASPER_PRINT, jp);
			exp.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(SmartSaleBoxConstants.INFLOW_PATH));
			exp.exportReport();
		} catch (JRException | IOException ex) {
			java.util.logging.Logger.getLogger(ReportGenerator.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
			logger.info(SmartSaleBoxConstants.REPORT_GENERATION_ERROR + " " + ex);
		}
	}

	@SuppressWarnings("deprecation")
	public static void outgoingsReport() throws SQLException {
		ReportConnection cn = new ReportConnection();
		JasperReport jr = null;
		try {
			Map<String, Object> parameters = new HashMap<>();
			InputStream inputStream = ReportGenerator.class.getClassLoader()
					.getResourceAsStream(SmartSaleBoxConstants.PATH_IMAGE);
			parameters.put("smartBoxImage", ImageIO.read(new ByteArrayInputStream(JRLoader.loadBytes(inputStream))));
			InputStream is = ReportGenerator.class.getClassLoader()
					.getResourceAsStream(SmartSaleBoxConstants.JASPER_PATH_OUTGOINGS);
			jr = (JasperReport) JRLoader.loadObject(is);
			JasperPrint jp = JasperFillManager.fillReport(jr, parameters, cn.conexion());
			JRExporter exp = new JRPdfExporter();
			exp.setParameter(JRExporterParameter.JASPER_PRINT, jp);
			exp.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(SmartSaleBoxConstants.OUTFLOW_PATH));
			exp.exportReport();
		} catch (JRException | IOException ex) {
			java.util.logging.Logger.getLogger(ReportGenerator.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
			logger.info(SmartSaleBoxConstants.REPORT_GENERATION_ERROR + " " + ex);
		}

	}

	@SuppressWarnings("deprecation")
	public static void productReport() throws SQLException {
		ReportConnection cn = new ReportConnection();
		JasperReport jr = null;
		try {
			Map<String, Object> parameters = new HashMap<>();
			InputStream inputStream = ReportGenerator.class.getClassLoader()
					.getResourceAsStream(SmartSaleBoxConstants.PATH_IMAGE);
			parameters.put("smartBoxImage", ImageIO.read(new ByteArrayInputStream(JRLoader.loadBytes(inputStream))));
			InputStream is = ReportGenerator.class.getClassLoader()
					.getResourceAsStream(SmartSaleBoxConstants.JASPER_PATH_PRODUCTS);
			jr = (JasperReport) JRLoader.loadObject(is);
			JasperPrint jp = JasperFillManager.fillReport(jr, parameters, cn.conexion());
			JRExporter exp = new JRPdfExporter();
			exp.setParameter(JRExporterParameter.JASPER_PRINT, jp);
			exp.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(SmartSaleBoxConstants.PRODUCT_PATH));
			exp.exportReport();
		} catch (JRException | IOException ex) {
			java.util.logging.Logger.getLogger(ReportGenerator.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
			logger.info(SmartSaleBoxConstants.REPORT_GENERATION_ERROR + " " + ex);
		}

	}

	@SuppressWarnings("deprecation")
	public static void productEarningsReport() throws SQLException {
		ReportConnection cn = new ReportConnection();
		JasperReport jr = null;
		try {
			Map<String, Object> parameters = new HashMap<>();
			InputStream inputStream = ReportGenerator.class.getClassLoader()
					.getResourceAsStream(SmartSaleBoxConstants.PATH_IMAGE);
			parameters.put("smartBoxImage", ImageIO.read(new ByteArrayInputStream(JRLoader.loadBytes(inputStream))));
			InputStream is = ReportGenerator.class.getClassLoader()
					.getResourceAsStream(SmartSaleBoxConstants.JASPER_PATH_PRODUCT_EARNINGS);
			jr = (JasperReport) JRLoader.loadObject(is);
			JasperPrint jp = JasperFillManager.fillReport(jr, parameters, cn.conexion());
			JRExporter exp = new JRPdfExporter();
			exp.setParameter(JRExporterParameter.JASPER_PRINT, jp);
			exp.setParameter(JRExporterParameter.OUTPUT_FILE,
					new java.io.File(SmartSaleBoxConstants.PRODUCT_EARNINGS_PATH));
			exp.exportReport();
		} catch (JRException | IOException ex) {
			java.util.logging.Logger.getLogger(ReportGenerator.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
			logger.info(SmartSaleBoxConstants.REPORT_GENERATION_ERROR + " " + ex);
		}

	}

	@SuppressWarnings("deprecation")
	public static void closureReport() throws SQLException {
		ReportConnection cn = new ReportConnection();
		JasperReport jr = null;
		try {
			Map<String, Object> parameters = new HashMap<>();
			InputStream inputStream = ReportGenerator.class.getClassLoader()
					.getResourceAsStream(SmartSaleBoxConstants.PATH_IMAGE);
			parameters.put("smartBoxImage", ImageIO.read(new ByteArrayInputStream(JRLoader.loadBytes(inputStream))));
			InputStream is = ReportGenerator.class.getClassLoader()
					.getResourceAsStream(SmartSaleBoxConstants.JASPER_PATH_CLOSURE);
			jr = (JasperReport) JRLoader.loadObject(is);
			JasperPrint jp = JasperFillManager.fillReport(jr, parameters, cn.conexion());
			JRExporter exp = new JRPdfExporter();
			exp.setParameter(JRExporterParameter.JASPER_PRINT, jp);
			exp.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(SmartSaleBoxConstants.CLOSURE_PATH));
			exp.exportReport();
		} catch (JRException | IOException ex) {
			java.util.logging.Logger.getLogger(ReportGenerator.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
			logger.info(SmartSaleBoxConstants.REPORT_GENERATION_ERROR + " " + ex);
		}

	}

//	public static void main(String[] args) throws SQLException {
//		ReportGenerator.closureReport();
//		ReportGenerator.outgoingsReport();
//		ReportGenerator.incomesReport();
//		ReportGenerator.salesReport();
//		ReportGenerator.productEarningsReport();
//		ReportGenerator.productReport();
//	}

}
