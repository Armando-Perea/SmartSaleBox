package com.java.smartsalebox.mail;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.java.smartsalebox.models.Closure;


public class MailAuthData {
	
	public final static String USERNAME="J3FPukD52orOWTfXdvMDlUUkkdXz2cs3QW7EK7rmy7M=";
    public final static String PASSWORD="7WFF0dFj970VNFycLLPKQw==";
    public final static String DESTINATION="J3FPukD52orOWTfXdvMDlUUkkdXz2cs3QW7EK7rmy7M=";
    public final static String SMPT_AUTH="mail.smtp.auth";
    public final static String SMPT_STARTTLS="mail.smtp.starttls.enable";
    public final static String SMPT_HOST="mail.smtp.host";
    public final static String GMAIL_HOST="smtp.gmail.com";
    public final static String SMTP_PORT="mail.smtp.port";
    public final static String SMTP_ENABLE="true";
    public final static String SMTP_PORT_NUMBER="587";
    
    public static final String INCOMES_REPORT="ReporteEntradas.pdf";
    public static final String OUTGOINGS_REPORT="ReporteSalidas.pdf";
    public static final String SALES_REPORT="ReporteVentas.pdf";
    public static final String CLOSURE_REPORT="ReporteCorte.pdf";
    public static final String PRODUCT_REPORT="ReporteProducto.pdf";
    public static final String PRODUCT_EARNINGS_REPORT="ReporteGananciaProducto.pdf";
    public static final String FAIL_REPORT="Favor de enviar Reportes al correo del encargado";
    public static final String FAIL_AUTH="Problemas al descifrar usuario y constraseña";
    public static final String CLOSURE_NOTIF="SmartSaleBox Corte Hecho Por ";

    public static String bodyMailClosureBuilder(Closure closureData) {
    	String initCash,closureCash,totalCard,totalCash,totalIn,totalOut,totalGenerated,employee,products;
        String bodyClosureMail;
        LocalDateTime myDateObj = LocalDateTime.now();  
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new Locale("es","ES"));
        String closureDate = myDateObj.format(myFormatObj);  

    	initCash = closureData.getInitCash().toString();
    	closureCash = closureData.getClosureCash().toString();
        products = closureData.getProducts().toString();
        totalCard = closureData.getCardPayments().toString();
        totalCash = closureData.getCashPayments().toString();
        totalIn = closureData.getTotalInflow().toString();
        totalOut = closureData.getTotalOutflow().toString();
        totalGenerated = closureData.getEarning().toString();
        employee = closureData.getAttendee();
 
	        bodyClosureMail = "** SMARTSALEBOX SYSTEM **\n"+
	    "\t CORTE DE CAJA\n"+    
	    "=============================\n"+
	    "DETALLE DE CORTE\n"+           
	    "=============================\n"+
	    "INICIO CAJA: "+initCash+
	    "\nCIERRE CAJA: "+closureCash+
	    "\nTOTAL PRODUCTOS: "+products+
	    "\nTOTAL ENTRADAS: "+totalIn+
	    "\nTOTAL SALIDAS: "+totalOut+
	    "\nTOTAL EFECTIVO: "+totalCash+
	    "\nTOTAL TARJETA: "+totalCard+
	    "\nTOTAL GANANCIA PRODUCTOS: "+totalGenerated+      
	    "\n"+
	    "\n=============================\n"+
	    "ATENDIO:\t"+employee+
	    "\nFECHA: "+closureDate+
	    "\n=============================\n"+
	    "\n\n\n\n\n"; 
	  
	   return bodyClosureMail;
    	
    }

}
