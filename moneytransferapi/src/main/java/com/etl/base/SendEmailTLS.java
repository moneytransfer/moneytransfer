package com.etl.base;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.context.support.StaticApplicationContext;

import com.etl.provider.Configuration.MYSQLConfiguration;

public class SendEmailTLS {
	public String Name;
	public String Email;
	public String ReceivingCountry;
	public String FalconLoopTransactionNumber;
	public String Subject;
	public String Question;
	public String Result;
	public String Error;
	
	private void setName(String Name){
		this.Name = Name;
	}	
	private String getName(){
		return Name;
	}
	private void setEmail(String Email){
		this.Email = Email;
	}	
	private String getEmail(){
		return Email;
	}
	
	private void setReceivingCountry(String ReceivingCountry){
		this.ReceivingCountry = ReceivingCountry;
	}	
	private String getReceivingCountry(){
		return ReceivingCountry;
	}
	
	private void setFalconLoopTransactionNumber(String FalconLoopTransactionNumber){
		this.FalconLoopTransactionNumber = FalconLoopTransactionNumber;
	}	
	private String getFalconLoopTransactionNumber(){
		return FalconLoopTransactionNumber;
	}
	
	
	private void setSubjectr(String Subject){
		this.Subject = Subject;
	}	
	private String getSubject(){
		return Subject;
	}
	
	private void setQuestion(String Question){
		this.Question = Question;
	}	
	private String getQuestion(){
		return Subject;
	}
	private void setResult(String Result){
		this.Result = Result;
	}	
	private String getResult(){
		return Result;
	}
	private void setError(String Error){
		this.Error = Error;
	}	
	private String getError(){
		return Error;
	}
	
	private static String USER_NAME =  MYSQLConfiguration.getemailuser();
	private static String PASSWORD =  MYSQLConfiguration.getemailppwd();
	
	public SendEmailTLS addSendEmailTLS(String Name,String Email,String ReceivingCountry,String FalconLoopTransactionNumber,String Subject,String Question) {
		SendEmailTLS _SendEmailTLS = new SendEmailTLS();
		final  String username = USER_NAME;
		final String password = PASSWORD;
		final String RECIPIENT = Email;
		final String RECIPIENT2 = MYSQLConfiguration.emailUserName2();
		
		
		Properties props = new Properties();
		 props.put("mail.smtp.host", "smtp.gmail.com");    
         props.put("mail.smtp.socketFactory.port", "465");    
         props.put("mail.smtp.socketFactory.class",    
                   "javax.net.ssl.SSLSocketFactory");    
         props.put("mail.smtp.auth", "true");    
         props.put("mail.smtp.port", "465");    
         //get Session   
         Session session = Session.getDefaultInstance(props,    
          new javax.mail.Authenticator() {    
          protected PasswordAuthentication getPasswordAuthentication() {    
          return new PasswordAuthentication(username,password);  
          }    
         });    
				
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(USER_NAME));
			//message.setRecipients(Message.RecipientType.TO,
			//	InternetAddress.parse(RECIPIENT));
			
			message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(RECIPIENT));
			message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(RECIPIENT2));
		 
			
			
			message.setSubject("Sendingloop Team");
			//message.setText("Dear Mail Crawler,"
			//	+ "\n\n No spam to my email, please!");
			//message.setHeader("Content-Type", "text/html");
			message.setContent("<html><body><h3 style =\"color:black;\">Thank you for submitting your information.</h3><br><p style=\"font-size: 15px;margin-top:0;\">Name: "+Name +" <br>Receiving Country: "+ReceivingCountry +" <br>FalconLoop Transaction Number: "+FalconLoopTransactionNumber +" <br>Subject: "+Subject +" <br>Query or Problem: "+Question +" <br><br>sendingloop team will check your query or problem and get back soon.<br></p></body></html>",
		             "text/html");
			Transport.send(message);

			System.out.println("Done");

			_SendEmailTLS.setResult("Success");
		} catch (Exception e) {
			_SendEmailTLS.setResult("Failed");
			_SendEmailTLS.setError(e.getMessage());
			throw new RuntimeException(e);
		}
		
		/*    String from = USER_NAME;
	        String pass = PASSWORD;
	        String[] to = { RECIPIENT }; // list of recipient email addresses
	        String subject = "Java send mail example";
	        String body = "Welcome to JavaMail!";

	        sendFromGMail(from, pass, to, subject, body);*/
		return _SendEmailTLS;
	}
	
	private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (Exception ae) {
            ae.printStackTrace();
        }
    }


	
	public SendEmailTLS sendNewletterEmailadmin(String Email) {
		SendEmailTLS _SendEmailTLS = new SendEmailTLS();
		 
		
		final  String username = USER_NAME;
		final String password = PASSWORD;
		final String RECIPIENT = Email;
		final String RECIPIENT2 = MYSQLConfiguration.emailUserName2();
		
		
		Properties props = new Properties();
		 props.put("mail.smtp.host", "smtp.gmail.com");    
         props.put("mail.smtp.socketFactory.port", "465");    
         props.put("mail.smtp.socketFactory.class",    
                   "javax.net.ssl.SSLSocketFactory");    
         props.put("mail.smtp.auth", "true");    
         props.put("mail.smtp.port", "465");    
         //get Session   
         Session session = Session.getDefaultInstance(props,    
          new javax.mail.Authenticator() {    
          protected PasswordAuthentication getPasswordAuthentication() {    
          return new PasswordAuthentication(username,password);  
          }    
         });    
				
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(USER_NAME));
			//message.setRecipients(Message.RecipientType.TO,
			//	InternetAddress.parse(RECIPIENT));
			
			//message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(RECIPIENT));
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(RECIPIENT2));
		 
			
			
			message.setSubject("Signup to Newsletter and Alerts");
			// message.setText("THE EMAIL TEXT");
			//message.setHeader("Content-Type", "text/html");
			message.setContent("<html><body><h3 style =\"color:black;\">New user signup to Newsletter and Alerts.</h3><br><p style=\"font-size: 15px;margin-top:0;\">Email: "+Email +"<br></p></body></html>",
		            "text/html");
			Transport.send(message);

			System.out.println("Done");
			_SendEmailTLS.setResult("Success");
			_SendEmailTLS.sendNewletterEmailuser(Email);
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			_SendEmailTLS.setResult("Failed");
			_SendEmailTLS.setError(e.getMessage());
			throw new RuntimeException(e);
		}
		
		return _SendEmailTLS;
	}
	
	
	
	
	
	 
	public SendEmailTLS sendNewletterEmailuser(String Email) {
		SendEmailTLS _SendEmailTLS = new SendEmailTLS();
		final  String username = USER_NAME;
		final String password = PASSWORD;
		final String RECIPIENT = Email;
		final String RECIPIENT2 = MYSQLConfiguration.emailUserName2();
		
		
		Properties props = new Properties();
		 props.put("mail.smtp.host", "smtp.gmail.com");    
         props.put("mail.smtp.socketFactory.port", "465");    
         props.put("mail.smtp.socketFactory.class",    
                   "javax.net.ssl.SSLSocketFactory");    
         props.put("mail.smtp.auth", "true");    
         props.put("mail.smtp.port", "465");    
         //get Session   
         Session session = Session.getDefaultInstance(props,    
          new javax.mail.Authenticator() {    
          protected PasswordAuthentication getPasswordAuthentication() {    
          return new PasswordAuthentication(username,password);  
          }    
         });    
				
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(USER_NAME));
			//message.setRecipients(Message.RecipientType.TO,
			//	InternetAddress.parse(RECIPIENT));
			
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(RECIPIENT));
			//message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(RECIPIENT2));
		 
			
			
			message.setSubject("Subscribe Newsletter and Alerts");
			//message.setText("Dear Mail Crawler,"
			//	+ "\n\n No spam to my email, please!");
			//message.setHeader("Content-Type", "text/html");
			message.setContent("<html><body><h3 style =\"color:black;\">Thank you for subscribe Newsletter and Alerts.</h3><br></p></body></html>",
		             "text/html");
			Transport.send(message);

			System.out.println("Done");
			_SendEmailTLS.setResult("Success");
		} catch (Exception e) {
			_SendEmailTLS.setResult("Failed");
			_SendEmailTLS.setError(e.getMessage());
			throw new RuntimeException(e);
		}
		
		return _SendEmailTLS;
	}

	
	
	
	
	
	
	 public SendEmailTLS send(){  
		 SendEmailTLS _SendEmailTLS=new SendEmailTLS();
		 final  String from="falconloopincusa@gmail.com";
		 final  String password="falconloopincusa@gmail.com";
		 final  String to="falconloopincusa@gmail.com";
		 final  String sub="welcome";
		 final  String msg="tank you ishu";
         Properties props = new Properties();    
         props.put("mail.smtp.host", "smtp.gmail.com");    
         props.put("mail.smtp.socketFactory.port", "465");    
         props.put("mail.smtp.socketFactory.class",    
                   "javax.net.ssl.SSLSocketFactory");    
         props.put("mail.smtp.auth", "true");    
         props.put("mail.smtp.port", "465");    
         //get Session   
         Session session = Session.getDefaultInstance(props,    
          new javax.mail.Authenticator() {    
          protected PasswordAuthentication getPasswordAuthentication() {    
          return new PasswordAuthentication(from,password);  
          }    
         });    
         //compose message    
         try {    
          MimeMessage message = new MimeMessage(session);    
          message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
          message.setSubject(sub);    
          message.setText(msg);    
          //send message  
          Transport.send(message);    
          System.out.println("message sent successfully");    
         } catch (Exception e) {throw new RuntimeException(e);}    
      return _SendEmailTLS;      
   }  
}
