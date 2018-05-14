package com.selenium.test;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
 
/**
 * This program tests out the EmbeddedImageEmailUtil utility class.
 * @author www.codejava.net
 *
 */
public class EmailMain01 

{

	
	
	
	//em.main(ser);
	
	
    static String host = "smtp.gmail.com";
    //static String host = "mail.prolifics.com";
   // static String port = "587";
    static String port = "587";
    static String mailFrom = "bhargav.eswar3@gmail.com";
   // static String mailFrom = "Nandeeswara.Padala@prolifics.com";
    static String password = "bhargav@#bob";
    //static String password = "1!Jkilabcd";

    static String message = "Pleae find the Report in the attached";
    // message info
  //static String mailTo = "Nandeeswara.Padala@prolifics.com";
 
   // static String mailTo = "nandi.testing@gmail.com";
    static String subject = "Test Execution Report";
    static Multipart multipart = new MimeMultipart();
    static Properties properties = new Properties();
    /**
     * main entry of the program
     */
    public static void main(String[] args) {
    	//String[] mailTo = {"Nandeeswara.Padala@prolifics.com","nandi.testing@gmail.com"};
    	String[] mailTo=args;
        // SMTP info
       /* String host = "smtp.gmail.com";
        String port = "587";
        String mailFrom = "YOUR_EMAIL";
        String password = "YOUR_PASSWORD";*/
       
       // 
        // message info
       // String mailTo = "YOUR_RECIPIENT";
       // String subject = "Test e-mail with inline images";
        StringBuffer body
            = new StringBuffer("<html>");
       // = new StringBuffer("<html align=\"center\">ELLIEMAE_POC_EXCEUTION_STATUS<br>");
        body.append("<h1 align=\"center\" style=\"color:blue;\">POC EXCEUTION STATUS</h1>");
       // body.append("The first image is a chart:<br>");
     //  body.append("<img align=\"left\" src=\"cid:image1\" width=\"30%\" height=\"30%\" /><br>");
       // body.append("The second one is a cube:<br>");
       //body.append("<img align=\"right\" src=\"cid:image2\" width=\"15%\" height=\"15%\" /><br>");
        //body.append("End of message.");
        body.append("</html>");
        
        StringBuilder contentBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader("D:\\Users\\bhargav\\workspace32\\Seleniumexplore\\extentReportFile.html"));
            String str;
            while ((str = in.readLine()) != null) {
                //contentBuilder.append(str);
            	/*if(str.contains("<tr><td width=\"10%\" class=\"table_cell\" bgcolor =\"#FFFFF0\" style=\"color:blue;\">")){
            		 break;
            	}
            	
            	else{
            		if(str.contains("<td class=\"table_cell\" align=\"center\"  valign=\"top\" bgcolor =\"#444\" width=\"10%\" style=\"color:white;\"><b><center>Total Scripts  :<br>")){
            			str.replace("<td class=\"table_cell\" align=\"center\"  valign=\"top\" bgcolor =\"#444\" width=\"10%\" style=\"color:white;\"><b><center>Total Scripts  :<br>", "<td class=\"table_cell\" align=\"center\"  valign=\"top\" bgcolor =\"#2F4F4F\" width=\"10%\" style=\"color:white;\"><b><center>Total Scripts  :<br>");
            		}
            		if(str.contains("<tr><td width=\"10%\" class=\"table_cell\" bgcolor =\"#FFFFF0\" style=\"color:blue;\">")){
               		 break;
               	}*/
            		body.append(str);
            	}
           // }
           // in.close();
        } catch (IOException e) {
        }
        String content = contentBuilder.toString();
               // inline images
        Map<String, String> inlineImages = new HashMap<String, String>();
    // inlineImages.put("image1", "C:\\Users\\nandeeswara_padala\\Desktop\\image1.png");
    // inlineImages.put("image2", "C:\\Users\\nandeeswara_padala\\Desktop\\image2.png");
 
        try {
            EmbeddedImageEmailUtil(host, port, mailFrom, password, mailTo,
                subject, body.toString(), inlineImages);
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Could not send email.");
            ex.printStackTrace();
        }
    }
    
    public static void EmbeddedImageEmailUtil(String host, String port,
            final String userName, final String password, String toAddress[],
            String subject, String htmlBody,
            Map<String, String> mapInlineImages) throws AddressException, MessagingException{
    	 // sets SMTP server properties
        
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.user", userName);
        properties.put("mail.password", password);
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(userName));
     // InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
       // msg.setRecipients(Message.RecipientType.TO, toAddresses);
        
        InternetAddress[] addressTo = new InternetAddress[toAddress.length];
        for (int i = 0; i < toAddress.length; i++)
        {
            addressTo[i] = new InternetAddress(toAddress[i]);
        }
       // msg.setRecipients(RecipientType.TO, addressTo); 
        msg.setRecipients(Message.RecipientType.TO, addressTo);
        
        
        //msg.addRecipient(Message.RecipientType.CC, new InternetAddress("nandi.testing@gmail.com"));
        msg.setSubject(subject);
        msg.setSentDate(new Date());
 
        // creates message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(htmlBody, "text/html");
 
        // creates multi-part
      
        multipart.addBodyPart(messageBodyPart);
        String[] attachFiles = new String[1];
        attachFiles[0] = "D:\\Users\\bhargav\\workspace32\\Seleniumexplore\\extentReportFile.html";
       
        
        // adds attachments
        if (attachFiles != null && attachFiles.length > 0) {
            for (String filePath : attachFiles) {
                MimeBodyPart attachPart = new MimeBodyPart();
 
                try {
                    attachPart.attachFile(filePath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
 
                multipart.addBodyPart(attachPart);
            }
        }
 
        // adds inline image attachments
        if (mapInlineImages != null && mapInlineImages.size() > 0) {
            Set<String> setImageID = mapInlineImages.keySet();
             
            for (String contentId : setImageID) {
                MimeBodyPart imagePart = new MimeBodyPart();
                imagePart.setHeader("Content-ID", "<" + contentId + ">");
                imagePart.setDisposition(MimeBodyPart.INLINE);
                 
                String imageFilePath = mapInlineImages.get(contentId);
                try {
                    imagePart.attachFile(imageFilePath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
 
                multipart.addBodyPart(imagePart);
            }
        }
        // attachments
       /* String[] attachFiles = new String[1];
        attachFiles[0] = "C:\\Users\\nandeeswara_padala\\Desktop\\TS_PRE_AggregatorAcc_8e9d8f969c5a36d0e3901f318812eca7_Pass.html";
       
        
        try {
            sendEmailWithAttachments(host, port, mailFrom, password, mailTo,
                subject, message, attachFiles);
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Could not send email.");
            ex.printStackTrace();
        }*/
        
        msg.setContent(multipart);
 
        Transport.send(msg);
        
        // sets the multi-part as e-mail's content
        // msg.setContent(multipart);
  
         // sends the e-mail
        // Transport.send(msg);
    
    }
    public static void sendEmailWithAttachments(String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message, String[] attachFiles)
            throws AddressException, MessagingException {
        // sets SMTP server properties
       /* Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.user", userName);
        properties.put("mail.password", password);*/
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
 
        // creates message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(message, "text/html");
 
        // creates multi-part
       // Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
 
        // adds attachments
        if (attachFiles != null && attachFiles.length > 0) {
            for (String filePath : attachFiles) {
                MimeBodyPart attachPart = new MimeBodyPart();
 
                try {
                    attachPart.attachFile(filePath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
 
                multipart.addBodyPart(attachPart);
            }
        }
 
        // sets the multi-part as e-mail's content
       // msg.setContent(multipart);
 
        // sends the e-mail
       // Transport.send(msg);
 
    }
}