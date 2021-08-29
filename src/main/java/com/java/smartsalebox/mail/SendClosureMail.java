package com.java.smartsalebox.mail;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

import com.java.smartsalebox.client.EmailConfigClient;
import com.java.smartsalebox.client.SystemPathsClient;
import com.java.smartsalebox.models.Closure;
import com.java.smartsalebox.models.EmailConfig;
import com.java.smartsalebox.models.SystemPaths;
import com.java.util.smartsalebox.utils.SmartSaleBoxConstants;

public class SendClosureMail {
	
	public static Logger logger = Logger.getLogger(SendClosureMail.class.getName());

	public static Boolean sendMail(Closure closureData) throws Exception {
		String bodyClosureMail;
		bodyClosureMail = MailAuthData.bodyMailClosureBuilder(closureData);
		EmailConfig emailConfig = EmailConfigClient.getEmailConfigById(1);
		Properties props = new Properties();
		props.put(MailAuthData.SMPT_AUTH, MailAuthData.SMTP_ENABLE);
		props.put(MailAuthData.SMPT_STARTTLS, MailAuthData.SMTP_ENABLE);
		props.put(MailAuthData.SMPT_HOST, MailAuthData.GMAIL_HOST);
		props.put(MailAuthData.SMTP_PORT, MailAuthData.SMTP_PORT_NUMBER);
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				try {
					return new PasswordAuthentication(emailConfig.getEmail(),
							EncryptSecurity.decrypt(emailConfig.getPassword()));
				} catch (Exception e) {
					logger.error("Exception: "+e.getMessage());
					logger.error(MailAuthData.FAIL_AUTH);
				}
				return null;
			}
		});
		try {
			BodyPart messageBodyPart = new MimeBodyPart();
			BodyPart messageBodyPartIncomes = new MimeBodyPart();
			BodyPart messageBodyPartOutgoings = new MimeBodyPart();
			BodyPart messageBodyPartClosure = new MimeBodyPart();
			BodyPart messageBodyPartSales = new MimeBodyPart();
			BodyPart messageBodyPartProduct = new MimeBodyPart();
			BodyPart messageBodyPartProductEarnings = new MimeBodyPart();

			messageBodyPart.setText(bodyClosureMail);

			Multipart multipart = new MimeMultipart();

			multipart.addBodyPart(messageBodyPart);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(emailConfig.getEmail()));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(emailConfig.getEmail()));
			message.setSubject(MailAuthData.CLOSURE_NOTIF + closureData.getAttendee());
			message.setText(bodyClosureMail);
			DataSource sourceIncomes = new FileDataSource(SmartSaleBoxConstants.INFLOW_PATH);
			DataSource sourceOutgoings = new FileDataSource(SmartSaleBoxConstants.OUTFLOW_PATH);
			DataSource sourceClosure = new FileDataSource(SmartSaleBoxConstants.CLOSURE_PATH);
			DataSource sourceSales = new FileDataSource(SmartSaleBoxConstants.SALES_PATH);
			DataSource sourceProduct = new FileDataSource(SmartSaleBoxConstants.PRODUCT_PATH);
			DataSource sourceProductEarnings = new FileDataSource(SmartSaleBoxConstants.PRODUCT_EARNINGS_PATH);

			messageBodyPartIncomes.setDataHandler(new DataHandler(sourceIncomes));
			messageBodyPartOutgoings.setDataHandler(new DataHandler(sourceOutgoings));
			messageBodyPartClosure.setDataHandler(new DataHandler(sourceClosure));
			messageBodyPartSales.setDataHandler(new DataHandler(sourceSales));
			messageBodyPartProduct.setDataHandler(new DataHandler(sourceProduct));
			messageBodyPartProductEarnings.setDataHandler(new DataHandler(sourceProductEarnings));

			messageBodyPartIncomes.setFileName(MailAuthData.INCOMES_REPORT);
			messageBodyPartOutgoings.setFileName(MailAuthData.OUTGOINGS_REPORT);
			messageBodyPartClosure.setFileName(MailAuthData.CLOSURE_REPORT);
			messageBodyPartSales.setFileName(MailAuthData.SALES_REPORT);
			messageBodyPartProduct.setFileName(MailAuthData.PRODUCT_REPORT);
			messageBodyPartProductEarnings.setFileName(MailAuthData.PRODUCT_EARNINGS_REPORT);

			multipart.addBodyPart(messageBodyPartIncomes);
			multipart.addBodyPart(messageBodyPartOutgoings);
			multipart.addBodyPart(messageBodyPartClosure);
			multipart.addBodyPart(messageBodyPartSales);
			multipart.addBodyPart(messageBodyPartProduct);
			multipart.addBodyPart(messageBodyPartProductEarnings);

			message.setContent(multipart);
			Transport.send(message);
			logger.info("Email Successfully Sent!");
		} catch (MessagingException e) {
			System.out.println("Exception Sending Mail: "+e.getMessage());
			logger.error("Exception Sending Mail: "+e.getMessage());
			return false;
		}
		return true;
	}

//	public static void main(String[] args) throws Exception {
//		
//		List<SystemPaths> systemPathsList = Arrays.asList(SystemPathsClient.getAllSystemPaths());
//		if(!systemPathsList.isEmpty()) {
//			SmartSaleBoxConstants.INFLOW_PATH = systemPathsList.get(0).getInflowsPdf();
//			SmartSaleBoxConstants.OUTFLOW_PATH = systemPathsList.get(0).getOutflowsPdf();
//			SmartSaleBoxConstants.SALES_PATH = systemPathsList.get(0).getSalesPdf();
//			SmartSaleBoxConstants.CLOSURE_PATH = systemPathsList.get(0).getClosurePdf();
//			SmartSaleBoxConstants.PRODUCT_PATH = systemPathsList.get(0).getProductsPdf();
//			SmartSaleBoxConstants.PRODUCT_EARNINGS_PATH = systemPathsList.get(0).getProductEarningsPdf();
//		}
//		//LocalDateTime myDateObj = LocalDateTime.now();
//		Closure closure = new Closure();
//		closure.setIdClosure(1);
//		closure.setClosureCash(569.00);
//		closure.setAttendee("LA OINK");
//		closure.setInitCash(500.0);
//		closure.setProducts(9500.00);
//		closure.setTotalInflow(2500.0);
//		closure.setTotalOutflow(250.00);
//		closure.setCashPayments(569.00);
//		closure.setCardPayments(894.00);
//		closure.setEarning(2569.00);
//
//		SendClosureMail.sendMail(closure);
//	}

}
