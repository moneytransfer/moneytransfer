package com.etl.base;

import java.io.IOException;
import java.io.StringBufferInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CarrierInfoByMobileNumber {
	public String MobileNumber;
	public String carrierId;
	public String carrierName;
	public String category;
	public String countryCode;
	public String currencyCode;
	public String productId;
	public String operator;
	public String denominationType;
	public String skuId;
	public String productName;
	public String denomination;
	public String minAmount;
	public String maxAmount;
	public String discount;
	public String isSalesTaxCharged;
	public String exchangeRate;
	public String bonusAmount;
	public String localPhoneNumberLength;
	public String internationalCodes;	
	
	public String Result;
	public String Error;
	
	private void setMobileNumber(String MobileNumber){
		this.MobileNumber = MobileNumber;
	}	
	private String getMobileNumber(){
		return MobileNumber;
	}
	
	
	private void setcarrierId(String carrierId){
		this.carrierId = carrierId;
	}	
	private String getcarrierId(){
		return carrierId;
	}
	
	private void setcarrierName(String carrierName){
		this.carrierName = carrierName;
	}	
	private String getcarrierName(){
		return carrierName;
	}
	
	
	private void setcategory(String category){
		this.category = category;
	}	
	private String getcategory(){
		return category;
	}
	private void setcountryCode(String countryCode){
		this.countryCode = countryCode;
	}	
	private String getcountryCode(){
		return countryCode;
	}
	
	private void setcurrencyCode(String currencyCode){
		this.currencyCode = currencyCode;
	}	
	private String getcurrencyCode(){
		return currencyCode;
	}
	private void setproductId(String productId){
		this.productId = productId;
	}	
	private String getproductId(){
		return productId;
	}
	
	private void setoperator(String operator){
		this.operator = operator;
	}	
	private String getoperator(){
		return operator;
	}
	private void setdenominationType(String denominationType){
		this.denominationType = denominationType;
	}	
	private String getdenominationType(){
		return denominationType;
	}
	private void setskuId(String skuId){
		this.skuId = skuId;
	}	
	private String getskuId(){
		return skuId;
	}
	private void setproductName(String productName){
		this.productName = productName;
	}	
	private String getproductName(){
		return productName;
	}
	private void setdenomination(String denomination){
		this.denomination = denomination;
	}	
	private String getdenomination(){
		return denomination;
	}
	private void setminAmount(String minAmount){
		this.minAmount = minAmount;
	}	
	private String getminAmount(){
		return minAmount;
	}
	private void setmaxAmount(String maxAmount){
		this.maxAmount = maxAmount;
	}	
	private String getmaxAmount(){
		return maxAmount;
	}
	private void setdiscount(String discount){
		this.discount = discount;
	}	
	private String getdiscount(){
		return discount;
	}
	private void setisSalesTaxCharged(String isSalesTaxCharged){
		this.isSalesTaxCharged = isSalesTaxCharged;
	}	
	private String getisSalesTaxCharged(){
		return isSalesTaxCharged;
	}
	private void setexchangeRate(String exchangeRate){
		this.exchangeRate = exchangeRate;
	}	
	private String getexchangeRate(){
		return exchangeRate;
	}
	private void setbonusAmount(String bonusAmount){
		this.bonusAmount = bonusAmount;
	}	
	private String getbonusAmount(){
		return bonusAmount;
	}
	private void setlocalPhoneNumberLength(String localPhoneNumberLength){
		this.localPhoneNumberLength = localPhoneNumberLength;
	}	
	private String getlocalPhoneNumberLength(){
		return localPhoneNumberLength;
	}
	private void setinternationalCodes(String internationalCodes){
		this.internationalCodes = internationalCodes;
	}	
	private String getinternationalCodes(){
		return internationalCodes;
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
	public static String  GetRequest(String sUsername, String sPassword,String sMobileNumber)
	{
		String sRequest = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pin=\"http://www.pininteract.com\">";
		sRequest += "<soapenv:Header>";
		sRequest += "<pin:AuthenticationHeader>";
		sRequest += "<pin:userId>" + sUsername + "</pin:userId>";
		sRequest += "<pin:password>" + sPassword + "</pin:password>";
		sRequest += "</pin:AuthenticationHeader>";
		sRequest += "</soapenv:Header>";
		sRequest += "<soapenv:Body>";
		sRequest += "<pin:GetCarrierInfoByMobileNumber>";		
		sRequest += "<pin:mobile>" + sMobileNumber + "</pin:mobile>";		
		sRequest += "</pin:GetCarrierInfoByMobileNumber>";
		sRequest += "</soapenv:Body>";
		sRequest += "</soapenv:Envelope>";
		
		return sRequest;
		
	}
	public CarrierInfoByMobileNumber getCarrierInfoByMobileNumber(CarrierInfoByMobileNumber _CarrierInfoByMobileNumber) {
		
		String strURL = "https://valuetopup.com/posaservice/servicemanager.asmx";
		//String strURL = "https://qa.valuetopup.com/posaservice/servicemanager.asmx";
		 String strSoapAction = "http://www.pininteract.com/GetCarrierInfoByMobileNumber";

		 PostMethod post = new PostMethod(strURL);
		String sRequest = GetRequest("Falconclk", "Ah2yinI37Dfi80cx7", _CarrierInfoByMobileNumber.MobileNumber);
		// String sRequest = GetRequest("Falcontest", "Hello@123", _CarrierInfoByMobileNumber.MobileNumber);
		 RequestEntity entity = new StringRequestEntity(sRequest);
		 post.setRequestEntity(entity);
	        post.setRequestHeader("SOAPAction", strSoapAction);
	        post.setRequestHeader("Content-Type", "text/xml; charset=ISO-8859-1");
	        HttpClient httpclient = new HttpClient();
	        
	        try {
	            int resultpay = 0;
				try {
					resultpay = httpclient.executeMethod(post);
				} catch (HttpException e) {
					_CarrierInfoByMobileNumber.setResult("Failed");
					//_CarrierInfoByMobileNumber.setError("Your transaction could not be completed due to some issue, please contact administrator.");
					_CarrierInfoByMobileNumber.setError(e.getMessage());
		        	//clear(_BillPay);
					// System.out.println("error code1: " + result);
				} catch (IOException e) {
					 //System.out.println("error code11: " + result);
					_CarrierInfoByMobileNumber.setResult("Failed");
					//_CarrierInfoByMobileNumber.setError("Server was unable to process request, please contact administrator.");
					_CarrierInfoByMobileNumber.setError(e.getMessage());
		        	//clear(_BillPay);
				}
				try {
					System.out.println(post.getResponseBodyAsString());
					if(resultpay==200)
			        {
			        	
						//_BillPay.setResult("Success");
			        }
					else
					{
						_CarrierInfoByMobileNumber.setResult("Failed");
						_CarrierInfoByMobileNumber.setError("error due to "+' '+resultpay);
						
			        	//clear(_BillPay);
					}
					
					
				} catch (IOException e) {
					
					//clear(_CarrierInfoByMobileNumber);
					_CarrierInfoByMobileNumber.setResult("Failed");
					//_CarrierInfoByMobileNumber.setError("Server was unable to process request, please contact administrator.");
					_CarrierInfoByMobileNumber.setError(e.getMessage());
		        	//clear(_CarrierInfoByMobileNumber);
				}
	        } finally {
	          
	            post.releaseConnection();
	        }
	        
	        
	        try {
	        	DocumentBuilderFactory _DocumentBuilderFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder _DocumentBuilder = _DocumentBuilderFactory.newDocumentBuilder();
				Document _Document = _DocumentBuilder.parse(new StringBufferInputStream(post.getResponseBodyAsString()));
				_Document.getDocumentElement().normalize();
				NodeList _NodeList = _Document.getElementsByTagName("GetCarrierInfoByMobileNumberResult");
				
				if(_NodeList.getLength() > 0)
				{
					Node _Node = _NodeList.item(0);
					if (_Node.getNodeType() == Node.ELEMENT_NODE) 
					{
						Element _Element = (Element) _Node;	
						System.out.println(_Element.getAttribute("GetCarrierInfoByMobileNumberResult")); 
						NodeList _tNodeList = _Document.getElementsByTagName("carrier");
						
						if(_tNodeList.getLength() > 0)
						{
							Node _tNode = _tNodeList.item(0);
							if (_tNode.getNodeType() == Node.ELEMENT_NODE) 
							{
								Element _tElement = (Element) _tNode;	
								////System.out.println(_tElement.getAttribute("carrierId")); 
								//System.out.println(_tElement.getAttribute("carrierName")); 
								//System.out.println(_tElement.getAttribute("category")); 
								//System.out.println(_tElement.getAttribute("countryCode")); 
								//System.out.println(_tElement.getAttribute("productId")); 
								//System.out.println(_tElement.getAttribute("operator")); 
								//System.out.println(_tElement.getAttribute("denominationType")); 
								
								_CarrierInfoByMobileNumber.setcarrierId(_tElement.getAttribute("carrierId"));
								_CarrierInfoByMobileNumber.setcarrierName(_tElement.getAttribute("carrierName"));
								_CarrierInfoByMobileNumber.setcategory(_tElement.getAttribute("category"));
								_CarrierInfoByMobileNumber.setcountryCode(_tElement.getAttribute("countryCode"));
								_CarrierInfoByMobileNumber.setproductId(_tElement.getAttribute("productId"));
								_CarrierInfoByMobileNumber.setoperator(_tElement.getAttribute("operator"));
								_CarrierInfoByMobileNumber.setdenominationType(_tElement.getAttribute("denominationType"));
								
								if(_tElement.getNodeType() == Node.ELEMENT_NODE)
								{
									
									NodeList _iNodeList = _Document.getElementsByTagName("sku");
									if(_iNodeList.getLength() > 0)
									{
										Node _pNodeList = _iNodeList.item(0);
										if (_pNodeList.getNodeType() == Node.ELEMENT_NODE) 
										{
											Element _cElement = (Element) _pNodeList;
											//System.out.println(_cElement.getAttribute("skuId"));
											//System.out.println(_cElement.getAttribute("productName"));
											//System.out.println(_cElement.getAttribute("denomination"));
											//System.out.println(_cElement.getAttribute("minAmount"));
											//System.out.println(_cElement.getAttribute("maxAmount"));
											//System.out.println(_cElement.getAttribute("discount"));
											//System.out.println(_cElement.getAttribute("isSalesTaxCharged"));
											//System.out.println(_cElement.getAttribute("exchangeRate"));
											//System.out.println(_cElement.getAttribute("bonusAmount"));
											//System.out.println(_cElement.getAttribute("currencyCode"));											
											//System.out.println(_cElement.getAttribute("localPhoneNumberLength"));
											//System.out.println(_cElement.getAttribute("internationalCodes"));
											_CarrierInfoByMobileNumber.setskuId(_cElement.getAttribute("skuId"));
											_CarrierInfoByMobileNumber.setproductName(_cElement.getAttribute("productName"));
											_CarrierInfoByMobileNumber.setdenomination(_cElement.getAttribute("denomination"));
											_CarrierInfoByMobileNumber.setminAmount(_cElement.getAttribute("minAmount"));
											_CarrierInfoByMobileNumber.setmaxAmount(_cElement.getAttribute("maxAmount"));
											_CarrierInfoByMobileNumber.setdiscount(_cElement.getAttribute("discount"));
											_CarrierInfoByMobileNumber.setisSalesTaxCharged(_cElement.getAttribute("isSalesTaxCharged"));
											_CarrierInfoByMobileNumber.setexchangeRate(_cElement.getAttribute("exchangeRate"));
											_CarrierInfoByMobileNumber.setbonusAmount(_cElement.getAttribute("bonusAmount"));
											_CarrierInfoByMobileNumber.setcurrencyCode(_cElement.getAttribute("currencyCode"));
											_CarrierInfoByMobileNumber.setlocalPhoneNumberLength(_cElement.getAttribute("localPhoneNumberLength"));
											_CarrierInfoByMobileNumber.setinternationalCodes(_cElement.getAttribute("internationalCodes"));
											_CarrierInfoByMobileNumber.setResult("Success");
										}
										
										
									}
									
									
									
									
								}
							}
						}
						else{
							_CarrierInfoByMobileNumber.setResult("Failed");
							_CarrierInfoByMobileNumber.setError("Server was unable to process request, please contact administrator.");
						}
					}
				}
				else{
					//System.out.println(_Element.getAttribute("responseCode")); 
					NodeList _oNodeList = _Document.getElementsByTagName("GetCarrierInfoByMobileNumberResult");
					Node _tNode = _oNodeList.item(0);
					if (_tNode.getNodeType() == Node.ELEMENT_NODE) 
					{
						Element _tElement = (Element) _tNode;
						//_CarrierInfoByMobileNumber.setResponseCode(_tElement.getAttribute("invoiceNumber"));
						_CarrierInfoByMobileNumber.setResult("Failed");
						_CarrierInfoByMobileNumber.setError("Server was unable to process request, please contact administrator.");
						//_CarrierInfoByMobileNumber.setError(_tElement.getAttribute("responseMessage"));
						//clear(_CarrierInfoByMobileNumber);
					}
					
				}
	        }
	        catch (Exception e) {
	        	
			}
		 
		 return _CarrierInfoByMobileNumber;
	}

}
