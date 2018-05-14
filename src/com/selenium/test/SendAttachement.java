package com.selenium.test;
 
import java.util.Properties;
 
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
 
public class SendAttachement{
 
public static void main(String[] args) {
 
    final String username = "bhargav.eswar3"; //change to your Gmail username
    final String password = " "; //change to your Gmail password
    final String from = "bhargav.eswar3@gmail.com"; //change to from email address
   final String to = "bhargav.eswar3@gmail.com"; //change to to email address
 //   final String cc = "test.cc.email@helloselenium.com"; //change to cc email address
//    final String bcc = "test.bcc.email@helloselenium.com"; //change to bcc email address
    final String subject = "Test Email from Hello Selenium"; //change to your subject
    final String msg = "Test Email from Hello Selenium to learn the automation of email message sending using Java Mail API from Gmail."; //change to your message
 
    Properties props = new Properties();
    props.put("mail.smtp.auth", true);
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");
 
    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
 
    try {
 
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));
        //below code only requires if your want cc email address
  //      message.setRecipients(Message.RecipientType.CC,
   //             InternetAddress.parse(cc));
        //below code only requires if your want bcc email address
 //       message.setRecipients(Message.RecipientType.BCC,
  //              InternetAddress.parse(bcc));
        message.setSubject(subject);
        message.setText(msg);
 
        MimeBodyPart messageBodyPart = new MimeBodyPart();
 
        Multipart multipart = new MimeMultipart();
 
        messageBodyPart = new MimeBodyPart();
        String file1 = "C:/Users/Bhargav/Desktop\\Need To Discuss.txt"; //change to your attachment filepath
        String fileName1 = "Capture.PNG"; //change to your attachment filename
        DataSource source1 = new FileDataSource(file1);
        messageBodyPart.setDataHandler(new DataHandler(source1));
        messageBodyPart.setFileName(fileName1);
        multipart.addBodyPart(messageBodyPart);
 
        message.setContent(multipart);
 
        System.out.println("Sending");
 
        Transport.send(message);
 
        System.out.println("Done");
 
    } catch (MessagingException e) {
        e.printStackTrace();
    }
  }
}