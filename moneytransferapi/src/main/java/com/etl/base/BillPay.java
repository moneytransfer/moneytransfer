package com.etl.base;

import java.io.File;
import java.io.IOException;
import java.io.StringBufferInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

import com.etl.util.MYSQLConnection;
import com.etl.util.MYSQLHelper;
import com.pininteract.*;
import com.pininteract.www.*;
public class BillPay {
	public int BillPayId;
	public String InvoiceNumber;
	public String FaceAmount;
	public String InvoiceAmount;
	public String VersionNo;
	public String SkuId;
	public int CompanyId;
	public int CustomerId;
	public String SenderName;
	public String SenderMobileNumber;
	public double Amount;
	public String MobileNumber;
	public String ResponseCode;
	public String TransactionDate;
	public String Result;
	public String Error;
	
	
	
	private void setBillPayId(int BillPayId){
		this.BillPayId = BillPayId;
	}	
	private int getBillPayId(){
		return BillPayId;
	}
	
	
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
	
	private void setCompanyId(int CompanyId){
		this.CompanyId = CompanyId;
	}	
	private int getCompanyId(){
		return CompanyId;
	}
	
	private void setCustomerId(int CustomerId){
		this.CustomerId = CustomerId;
	}	
	private int getCustomerId(){
		return CustomerId;
	}
	private void setInvoiceAmount(String InvoiceAmount){
		this.InvoiceAmount = InvoiceAmount;
	}	
	private String getInvoiceAmount(){
		return InvoiceAmount;
	}
	
	
	private void setVersionNo(String VersionNo){
		this.VersionNo = VersionNo;
	}	
	private String getVersionNo(){
		return VersionNo;
	}
	
	private void setSkuId(String SkuId){
		this.SkuId = SkuId;
	}	
	private String getSkuId(){
		return SkuId;
	}
	
	private void setResponseCode(String ResponseCode){
		this.ResponseCode = ResponseCode;
	}	
	private String getResponseCode(){
		return ResponseCode;
	}
	
	private void setTransactionDate(String TransactionDate){
		this.TransactionDate = TransactionDate;
	}	
	private String getTransactionDate(){
		return TransactionDate;
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
	
	
	
	private void setSenderName(String SenderName){
		this.SenderName = SenderName;
	}	
	private String getSenderName(){
		return SenderName;
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
		
		Connection _Connection = MYSQLConnection.GetConnection();
		 PreparedStatement _PreparedStatement = null;
		 MYSQLHelper _MYSQLHelper = new MYSQLHelper();
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
					_BillPay.setResult("Failed");
		        	_BillPay.setError("Your transaction could not be completed due to some issue, please contact administrator.");
		        	clear(_BillPay);
					// System.out.println("error code1: " + result);
				} catch (IOException e) {
					 //System.out.println("error code11: " + result);
					_BillPay.setResult("Failed");
		        	_BillPay.setError("Your transaction could not be completed due to some issue, please contact administrator.");
		        	clear(_BillPay);
				}
	          
	           // System.out.println("Response status code: " + result);
	         
	          //  System.out.println("Response body: ");
	            try {
					System.out.println(post.getResponseBodyAsString());
					if(result==200)
			        {
			        	
						//_BillPay.setResult("Success");
			        }
					else
					{
						_BillPay.setResult("Failed");
			        	_BillPay.setError("Your transaction could not be completed due to some issue, please contact administrator.");
			        	clear(_BillPay);
					}
					
					
				} catch (IOException e) {
					
					clear(_BillPay);
					_BillPay.setResult("Failed");
		        	_BillPay.setError("Your transaction could not be completed due to some issue, please contact administrator.");
		        	clear(_BillPay);
				}
	        } finally {
	          
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
						
						
						 ResultSet _ResultSetcompany = _MYSQLHelper.GetResultSet("SELECT * FROM company where Company_Id='"+_BillPay.CompanyId+"'",_Connection);
							if (_ResultSetcompany.next())
							{
								 ResultSet _ResultSetcustomer = _MYSQLHelper.GetResultSet("SELECT * FROM customer where customer_Id='"+_BillPay.CustomerId+"'",_Connection);
									if (_ResultSetcustomer.next())
									{
						
						
						
						
						if(_tNodeList.getLength() > 0)
						{
							Node _tNode = _tNodeList.item(0);
							if (_tNode.getNodeType() == Node.ELEMENT_NODE) 
							{
								Element _tElement = (Element) _tNode;	
								//System.out.println(_tElement.getAttribute("invoiceNumber")); 
								//System.out.println(_tElement.getAttribute("transactionDateTime")); 
								_BillPay.setInvoiceNumber(_tElement.getAttribute("invoiceNumber"));
								_BillPay.setTransactionDate(_tElement.getAttribute("transactionDateTime"));
								if(_tElement.getNodeType() == Node.ELEMENT_NODE)
								{
									Element _cElement = (Element) _tElement;
									//System.out.println(_cElement.getAttribute("invoiceAmount")); 
									//System.out.println(_cElement.getAttribute("faceValueAmount")); 
									_BillPay.setFaceAmount(_tElement.getAttribute("faceValueAmount"));
									_BillPay.setInvoiceAmount(_cElement.getAttribute("invoiceAmount"));									
									//System.out.println(_cElement.getAttribute("skuId")); 
									_BillPay.setResponseCode("000");								
									
									
													_BillPay.setSkuId("1560");
													_BillPay.setVersionNo("1.0");
													String sInsertStatement = "INSERT INTO billpaydetails( CompanyId, CustomerId,SenderName,SenderMobileNumber,MobileNumber, Version,SkuId,InvoiceNumber,TransactionDate,InvoiceAmount,FaceValueAmount,ResponseCode)";
													 sInsertStatement = sInsertStatement + " VALUES(?, ?, ?,?, ?, ?,?, ?, ?,?,?,?)";
													   _PreparedStatement = _Connection.prepareStatement(sInsertStatement);
														_PreparedStatement.setInt(1, _BillPay.CompanyId);							
														_PreparedStatement.setInt(2, _BillPay.CustomerId); 
														_PreparedStatement.setString(3, _BillPay.SenderName); 
														_PreparedStatement.setString(4, _BillPay.SenderMobileNumber);
														_PreparedStatement.setString(5, _BillPay.MobileNumber);
														_PreparedStatement.setString(6, _BillPay.VersionNo); 
														_PreparedStatement.setString(7, _BillPay.SkuId); 
														_PreparedStatement.setString(8, _BillPay.InvoiceNumber); 
														_PreparedStatement.setString(9, _BillPay.TransactionDate); 
														_PreparedStatement.setString(10, _BillPay.InvoiceAmount);
														_PreparedStatement.setString(11, _BillPay.FaceAmount); 	
														_PreparedStatement.setString(12, _BillPay.ResponseCode); 
														_PreparedStatement.executeUpdate();
														_BillPay.setResult("Success");
														
														ResultSet _ResultSetld = _MYSQLHelper.GetResultSet("SELECT MAX(BillPayId) AS BillPayId FROM billpaydetails",_Connection);
														if (_ResultSetld.next()){
														int lastid = _ResultSetld.getInt("BillPayId");								
														_BillPay.setBillPayId(lastid);
														//clear(_BillPay);
														}
												
								}
								
							}
						}
						else{
							System.out.println(_Element.getAttribute("responseCode")); 
							NodeList _oNodeList = _Document.getElementsByTagName("orderResponse");
							Node _tNode = _oNodeList.item(0);
							if (_tNode.getNodeType() == Node.ELEMENT_NODE) 
							{
								Element _tElement = (Element) _tNode;
								_BillPay.setResponseCode(_tElement.getAttribute("invoiceNumber"));
								_BillPay.setResult("Failed!");
								_BillPay.setError(_tElement.getAttribute("responseMessage"));
								clear(_BillPay);
							}
							
						}
						
						
									}
									else{
										_BillPay.setResult("Failed!");
										_BillPay.setError("Invalid Customer Id!");
										clear(_BillPay);
									}
							}
							else{
								_BillPay.setResult("Failed!");
								_BillPay.setError("Invalid Company Id!");
								clear(_BillPay);
							}
						
						
						
						
					}
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	return _BillPay;	
	}
	
	
	public static ArrayList<BillPay> getBillPayDetails(int CustomerId) {
		Connection _Connection = MYSQLConnection.GetConnection();		
		ArrayList<BillPay> _BillPayDetaillist = new ArrayList<BillPay>();		
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		try
		{
			 if(_Connection!=null)	
			 {
				 ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM billpaydetails where CustomerId='"+CustomerId+"'",_Connection);
					
					while  (_ResultSet.next())
					{
						BillPay _BillPay=new BillPay();
						_BillPay.setBillPayId(_ResultSet.getInt("BillPayId"));
						_BillPay.setCompanyId(_ResultSet.getInt("CompanyId"));
						_BillPay.setCustomerId(_ResultSet.getInt("CustomerId"));
						_BillPay.setSenderName(_ResultSet.getString("SenderName"));
						_BillPay.setSenderMobileNumber(_ResultSet.getString("SenderMobileNumber"));
						_BillPay.setMobileNumber(_ResultSet.getString("MobileNumber"));
						_BillPay.setVersionNo(_ResultSet.getString("Version"));
						_BillPay.setSkuId(_ResultSet.getString("SkuId"));						
						_BillPay.setInvoiceNumber(_ResultSet.getString("InvoiceNumber"));
						_BillPay.setTransactionDate(_ResultSet.getString("TransactionDate"));
						_BillPay.setInvoiceAmount(_ResultSet.getString("InvoiceAmount"));
						_BillPay.setFaceAmount(_ResultSet.getString("FaceValueAmount"));
						_BillPay.setAmount(_ResultSet.getDouble("FaceValueAmount"));
						_BillPay.setResponseCode(_ResultSet.getString("ResponseCode"));											
						_BillPay.setResult("Success");
						_BillPayDetaillist.add(_BillPay);
					}
					 _ResultSet.close();
			 }
			
		}
		catch (Exception e) {
		
		}
		finally {
			
			if (_Connection != null) {
				try {
					_Connection.close();
				} catch (SQLException e) {
					
				}
			}
		}
		
		return _BillPayDetaillist;
	}
	
	
	
	public BillPay clear(BillPay _BillPay) {
		_BillPay.setCompanyId(0);_BillPay.setCustomerId(0);	
		//_BillPay.setInvoiceNumber("");
		_BillPay.setFaceAmount("");
		_BillPay.setInvoiceAmount("");
		_BillPay.setVersionNo("");
		_BillPay.setSkuId("");
		_BillPay.setSenderName("");
		_BillPay.setSenderMobileNumber("");
		_BillPay.setAmount(0);
		_BillPay.setMobileNumber("");
		_BillPay.setResponseCode("");
		return _BillPay;
	}
	
				 
}
