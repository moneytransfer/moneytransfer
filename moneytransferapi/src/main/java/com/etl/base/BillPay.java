package com.etl.base;

import java.io.File;
import java.io.IOException;
import java.io.StringBufferInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.FileRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.pininteract.*;
import com.pininteract.www.*;
public class BillPay {
	public String InvoiceNumber;
	public String FaceAmount;
	public int VersionNo;
	public int SkuId;
	public String SenderName;
	public String SenderMobileNumber;
	public double Amount;
	public String MobileNumber;
	public String Result;
	public String Error;
	
	private void setInvoiceNumber(String InvoiceNumber){
		this.InvoiceNumber = InvoiceNumber;
	}	
	private String getInvoiceNumber(){
		return InvoiceNumber;
	}
	
	private void setFaceAmount(String FaceAmount){
		this.FaceAmount = FaceAmount;
	}	
	private String getFaceAmount(){
		return FaceAmount;
	}
	
	private void setVersionNo(int VersionNo){
		this.VersionNo = VersionNo;
	}	
	private int getVersionNo(){
		return VersionNo;
	}
	
	private void setSkuId(int SkuId){
		this.SkuId = SkuId;
	}	
	private int getSkuId(){
		return SkuId;
	}
	
	private void setSenderName(String SenderName){
		this.SenderName = SenderName;
	}	
	private String getSenderName(){
		return SenderName;
	}
	private void setSenderMobileNumber(String SenderMobileNumber){
		this.SenderMobileNumber = SenderMobileNumber;
	}	
	private String getSenderMobileNumber(){
		return SenderMobileNumber;
	}
	private void setAmount(double Amount){
		this.Amount = Amount;
	}	
	private double getAmount(){
		return Amount;
	}
	private void setMobileNumber(String MobileNumber){
		this.MobileNumber = MobileNumber;
	}	
	private String getMobileNumber(){
		return MobileNumber;
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
	 
	
	public static String  GetRequest(String sUsername, String sPassword, String sVersion, String sSku, double dAmount, String sSenderName, String sSenderMobile, String sMobileNumber)
	{
		String sRequest = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pin=\"http://www.pininteract.com\">";
		sRequest += "<soapenv:Header>";
		sRequest += "<pin:AuthenticationHeader>";
		sRequest += "<pin:userId>" + sUsername + "</pin:userId>";
		sRequest += "<pin:password>" + sPassword + "</pin:password>";
		sRequest += "</pin:AuthenticationHeader>";
		sRequest += "</soapenv:Header>";
		sRequest += "<soapenv:Body>";
		sRequest += "<pin:BillPay>";
		sRequest += "<pin:version>" + sVersion + "</pin:version>";
		sRequest += "<pin:skuId>" + sSku + "</pin:skuId>";
		sRequest += "<pin:amount>" + dAmount + "</pin:amount>";
		sRequest += "<pin:accountNumber>?</pin:accountNumber>";
		sRequest += "<pin:checkDigits>?</pin:checkDigits>";
		sRequest += "<pin:correlationId>?</pin:correlationId>";
		sRequest += "<pin:senderName>" + sSenderName + "</pin:senderName>";
		sRequest += "<pin:senderMobile>" + sSenderMobile + "</pin:senderMobile>";
		sRequest += "<pin:storeId>?</pin:storeId>";
		sRequest += "<pin:mobileNumber>" + sMobileNumber + "</pin:mobileNumber>";
		sRequest += "<pin:accountType>?</pin:accountType>";
		sRequest += "<pin:accountStatus>?</pin:accountStatus>";
		sRequest += "</pin:BillPay>";
		sRequest += "</soapenv:Body>";
		sRequest += "</soapenv:Envelope>";
		
		return sRequest;
		
	}
	
	public  BillPay billpayment(BillPay _BillPay) {
		
		
		String strURL = "https://qa.valuetopup.com/posaservice/servicemanager.asmx";
		 String strSoapAction = "http://www.pininteract.com/BillPay";

		 PostMethod post = new PostMethod(strURL);
		 String sRequest = GetRequest("Falcontest", "Hello@123", "1.0", "1560", _BillPay.Amount , _BillPay.SenderName, _BillPay.SenderMobileNumber, _BillPay.MobileNumber);
		 RequestEntity entity = new StringRequestEntity(sRequest);
		 
	        post.setRequestEntity(entity);
	        post.setRequestHeader("SOAPAction", strSoapAction);
	        post.setRequestHeader("Content-Type", "text/xml; charset=ISO-8859-1");
	        HttpClient httpclient = new HttpClient();
	        
	        try {
	            int result = 0;
				try {
					result = httpclient.executeMethod(post);
				} catch (HttpException e) {
					
					 System.out.println("error code1: " + result);
				} catch (IOException e) {
					 System.out.println("error code11: " + result);
				}
	            // Display status code
	            System.out.println("Response status code: " + result);
	            // Display response
	            System.out.println("Response body: ");
	            try {
					System.out.println(post.getResponseBodyAsString());
					if(result==200)
			        {
			        	
						_BillPay.setResult("Success");
			        }
					else
					{
						_BillPay.setResult("Failed");
			        	_BillPay.setError("Your transaction could not be completed due to some issue, please contact administrator.");
					}
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        } finally {
	            // Release current connection to the connection pool once you are done
	            post.releaseConnection();
	        }
	        
			try {
				DocumentBuilderFactory _DocumentBuilderFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder _DocumentBuilder = _DocumentBuilderFactory.newDocumentBuilder();
				Document _Document = _DocumentBuilder.parse(new StringBufferInputStream(post.getResponseBodyAsString()));
				_Document.getDocumentElement().normalize();
				NodeList _NodeList = _Document.getElementsByTagName("orderResponse");
				
				
				if(_NodeList.getLength() > 0)
				{
					Node _Node = _NodeList.item(0);
					if (_Node.getNodeType() == Node.ELEMENT_NODE) 
					{
						Element _Element = (Element) _Node;	
						System.out.println(_Element.getAttribute("responseCode")); 
						NodeList _tNodeList = _Document.getElementsByTagName("invoice");
						if(_tNodeList.getLength() > 0)
						{
							Node _tNode = _tNodeList.item(0);
							if (_tNode.getNodeType() == Node.ELEMENT_NODE) 
							{
								Element _tElement = (Element) _tNode;	
								System.out.println(_tElement.getAttribute("invoiceNumber")); 
								_BillPay.setInvoiceNumber(_tElement.getAttribute("invoiceNumber"));
								if(_tElement.getNodeType() == Node.ELEMENT_NODE)
								{
									Element _cElement = (Element) _tElement;
									System.out.println(_cElement.getAttribute("faceValueAmount")); 
									_BillPay.setFaceAmount(_tElement.getAttribute("faceValueAmount"));
									_BillPay.Result="Success";
								}
								
							}
						}
						
					}
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	return _BillPay;	
	}
	
	
				 
}
