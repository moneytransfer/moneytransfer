package com.etl.base;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.etl.provider.Configuration.MYSQLConfiguration;
import com.etl.util.MYSQLConnection;
import com.etl.util.MYSQLHelper;

import javax.mail.Transport;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class Email {

	public int CustomerId;
	public String Result;
	public String Error;
	public String email;
	private void setCustomerId(int CustomerId) {
		this.CustomerId = CustomerId;
	}

	private int getCustomerId() {
		return CustomerId;
	}

	private void setResult(String Result) {
		this.Result = Result;
	}

	private String getResult() {
		return Result;
	}

	private void setError(String Error) {
		this.Error = Error;
	}

	private String getError() {
		return Error;
	}
	private void setemail(String email) {
		this.email = email;
	}

	private String getemail() {
		return email;
	}

	public Email emailtest() {
		Email _Email = new Email();
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("AKIAJVJMLNXW4NIKDQVQ",
						"AkyACbOk/UecjTCXmDdmdUbflpvWQnMuCdpBYKZz13kM");
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from@no-spam.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("to@no-spam.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler," + "\n\n No spam to my email, please!");
			Transport.send(message);
			System.out.println("Done");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return _Email;
	}

	public Email go(int CustomerId) {
		Email _Email = new Email();

		/*
		 * 
		 * String Name="";String Emaila="";String Phone=""; String FROM =
		 * "engineering@falconloop.com"; // String FROMNAME = "Ishu Kumar";
		 * String TO = "engineering@falconloop.com";
		 * 
		 * 
		 * 
		 * 
		 * String SMTP_USERNAME = MYSQLConfiguration.getsmtpuser(); String
		 * SMTP_PASSWORD = MYSQLConfiguration.getsmtppwd(); // String CONFIGSET
		 * = "ConfigSet"; String HOST = "email-smtp.us-west-2.amazonaws.com";
		 * int PORT = 587; String SUBJECT = "New user registeration"; try {
		 * Connection _Connection = MYSQLConnection.GetConnection(); MYSQLHelper
		 * _MYSQLHelper = new MYSQLHelper(); ResultSet _ResultSet =
		 * _MYSQLHelper.
		 * GetResultSet("SELECT * FROM customer where customer_Id='"+CustomerId+
		 * "'",_Connection); if (_ResultSet.next()) {
		 * Name=_ResultSet.getString("FirstName")+" "+_ResultSet.getString(
		 * "LastName"); Emaila=_ResultSet.getString("Email");
		 * Phone=_ResultSet.getString("Phone"); } } catch (Exception e) { //
		 * TODO: handle exception }
		 * 
		 * String BODY = String.join( System.getProperty("line.separator"),
		 * "<h1>New user registered with following details</h1>",
		 * "<p>Name:-"+" "+Name, "<p>Email address:-"+" "+Emaila,
		 * "<p>Phone:-"+" "+Phone
		 * 
		 * 
		 * //
		 * "<a href='https://github.com/javaee/javamail'>Javamail Package</a>",
		 * //" for <a href='https://www.java.com'>Java</a>." );
		 * 
		 * Properties props = System.getProperties();
		 * props.put("mail.transport.protocol", "smtp");
		 * props.put("mail.smtp.port", PORT);
		 * props.put("mail.smtp.starttls.enable", "true");
		 * props.put("mail.smtp.auth", "true");
		 * props.put("mail.smtp.starttls.enable", "true");
		 * //props.put("mail.smtp.ssl.trust", "smtp.gmail.com"); Session session
		 * = Session.getDefaultInstance(props);
		 * session.getProperties().put("mail.smtp.starttls.enable", "true");
		 * props.put("mail.smtp.socketFactory.class",
		 * "javax.net.ssl.SSLSocketFactory"); try { MimeMessage msg = new
		 * MimeMessage(session); msg.setFrom(new InternetAddress(FROM));
		 * msg.setRecipients(Message.RecipientType.TO,
		 * InternetAddress.parse(TO)); msg.setSubject(SUBJECT);
		 * msg.setContent(BODY,"text/html"); Transport transport =
		 * session.getTransport(); System.out.println("Sending...");
		 * transport.connect("email-smtp.us-west-2.amazonaws.com",
		 * SMTP_USERNAME, SMTP_PASSWORD); transport.sendMessage(msg,
		 * msg.getAllRecipients()); System.out.println("Email sent!");
		 * _Email.setResult("Email sent!"); } catch (Exception e) {
		 * System.out.println("The email was not sent.");
		 * System.out.println("Error message: " + e.getMessage());
		 * _Email.setResult("The email was not sent.");
		 * _Email.setError("Error message: " + e.getMessage()); }
		 */
		String FROM = "engineering@falconloop.com";
		String FROMNAME = "Rajeev";

		String TO = "engineering@falconloop.com";

		String SMTP_USERNAME = MYSQLConfiguration.getsmtpuser();

		String SMTP_PASSWORD = MYSQLConfiguration.getsmtppwd();

		String CONFIGSET = "ConfigSet";

		String HOST = "email-smtp.us-west-2.amazonaws.com";

		int PORT = 587;

		String SUBJECT = "Amazon SES test (SMTP interface accessed using Java)";

		String BODY = String.join(System.getProperty("line.separator"), "<h1>Amazon SES SMTP Email Test</h1>",
				"<p>This email was sent with Amazon SES using the ",
				"<a href='https://github.com/javaee/javamail'>Javamail Package</a>",
				" for <a href='https://www.java.com'>Java</a>.");

		Properties props = System.getProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.port", PORT);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(props);

		try {

			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(FROM, FROMNAME));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
			msg.setSubject(SUBJECT);
			msg.setContent(BODY, "text/html");

			// msg.setHeader("X-SES-CONFIGURATION-SET", CONFIGSET);
			Transport transport = session.getTransport();

			try {
				System.out.println("Sending...");

				// Connect to Amazon SES using the SMTP username and password
				// you specified above.
				transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);

				// Send the email.
				transport.sendMessage(msg, msg.getAllRecipients());
				System.out.println("Email sent!");
				_Email.setResult("Success");
			} catch (Exception ex) {
				System.out.println("The email was not sent.");
				System.out.println("Error message: " + ex.getMessage());
				_Email.setResult("failed!");
				_Email.setError(ex.getMessage());
			} finally {
				// Close and terminate the connection.
				transport.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return _Email;
	}

	public Email go1(String email) {
		Email _Email = new Email();

		String FROM = "engineering@falconloop.com";
		String FROMNAME = "engineering@falconloop.com";

		String TO = email;

		String SMTP_USERNAME = MYSQLConfiguration.getsmtpuser();

		String SMTP_PASSWORD = MYSQLConfiguration.getsmtppwd();

		String CONFIGSET = "ConfigSet";

		String HOST = "email-smtp.us-east-1.amazonaws.com";

		int PORT = 587;

		String SUBJECT = "Amazon SES test (SMTP interface accessed using Java)";

		String BODY = String.join(System.getProperty("line.separator"), "<h1>Amazon SES SMTP Email Test</h1>",
				"<p>This email was sent with Amazon SES using the ",
				"<a href='https://github.com/javaee/javamail'>Javamail Package</a>",
				" for <a href='https://www.java.com'>Java</a>.");

		Properties props = System.getProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.port", PORT);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(props);

		try {

			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(FROM, FROMNAME));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
			msg.setSubject(SUBJECT);
			msg.setContent(BODY, "text/html");

			// msg.setHeader("X-SES-CONFIGURATION-SET", CONFIGSET);
			Transport transport = session.getTransport();

			try {
				System.out.println("Sending...");

				// Connect to Amazon SES using the SMTP username and password
				// you specified above.
				transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);

				// Send the email.
				transport.sendMessage(msg, msg.getAllRecipients());
				System.out.println("Email sent!");
				_Email.setResult("Success");
			} catch (Exception ex) {
				System.out.println("The email was not sent.");
				System.out.println("Error message: " + ex.getMessage());
				_Email.setResult("failed!");
				_Email.setError(ex.getMessage());
			} finally {
				// Close and terminate the connection.
				transport.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return _Email;
	}
}
