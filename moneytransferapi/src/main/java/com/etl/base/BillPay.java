package com.etl.base;

import java.io.IOException;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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

import com.etl.util.*;


import net.authorize.Environment;
import net.authorize.api.contract.v1.CreateTransactionRequest;
import net.authorize.api.contract.v1.CreateTransactionResponse;
import net.authorize.api.contract.v1.CreditCardType;
import net.authorize.api.contract.v1.MerchantAuthenticationType;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.PaymentType;
import net.authorize.api.contract.v1.TransactionRequestType;
import net.authorize.api.contract.v1.TransactionResponse;
import net.authorize.api.contract.v1.TransactionTypeEnum;
import net.authorize.api.controller.CreateTransactionController;
import net.authorize.api.controller.base.ApiOperationBase;



public class BillPay {
	public int BillPayId;
	public int TransactionId;
	public String PreNationInvoiceNumber;
	public String InvoiceNumber;
	public String FaceAmount;
	public double InvoiceAmount;
	public String VersionNo;
	public String SkuId;
	public int CompanyId;
	public int CustomerId;
	public String SenderName;
	public String Amount;
	public String Fees;
	public String MobileNumber;
	public String ResponseCode;
	public String TransactionDate;
	public String Status;
	public String CardNumber;
	public String setExpirationDate;
	public String cvv;
	public int PaymentMethodId;
	public String CreatedDate;
	public String PaymentGatewayResponse;
	public String PaymentGatewayTransactionId;
	public boolean IsLive;
	public String Result;
	public String Error;
	public String PreNationResponse;
	public String SKUId;

	private void setTransactionId(int TransactionId) {
		this.TransactionId = TransactionId;
	}

	private int getTransactionId() {
		return TransactionId;
	}

	private void setBillPayId(int BillPayId) {
		this.BillPayId = BillPayId;
	}

	private int getBillPayId() {
		return BillPayId;
	}

	private void setPreNationInvoiceNumber(String PreNationInvoiceNumber) {
		this.PreNationInvoiceNumber = PreNationInvoiceNumber;
	}

	private String getPreNationInvoiceNumber() {
		return PreNationInvoiceNumber;
	}

	private void setInvoiceNumber(String InvoiceNumber) {
		this.InvoiceNumber = InvoiceNumber;
	}

	private String getInvoiceNumber() {
		return InvoiceNumber;
	}

	private void setPaymentMethodId(int PaymentMethodId) {
		this.PaymentMethodId = PaymentMethodId;
	}

	private int getPaymentMethodId() {
		return PaymentMethodId;
	}

	private void setFaceAmount(String FaceAmount) {
		this.FaceAmount = FaceAmount;
	}

	private String getFaceAmount() {
		return FaceAmount;
	}

	private void setCompanyId(int CompanyId) {
		this.CompanyId = CompanyId;
	}

	private int getCompanyId() {
		return CompanyId;
	}

	private void setCustomerId(int CustomerId) {
		this.CustomerId = CustomerId;
	}

	private int getCustomerId() {
		return CustomerId;
	}

	private void setInvoiceAmount(double InvoiceAmount) {
		this.InvoiceAmount = InvoiceAmount;
	}

	private double getInvoiceAmount() {
		return InvoiceAmount;
	}

	private void setFees(String Fees) {
		this.Fees = Fees;
	}

	private String getFees() {
		return Fees;
	}

	private void setVersionNo(String VersionNo) {
		this.VersionNo = VersionNo;
	}

	private String getVersionNo() {
		return VersionNo;
	}

	private void setSkuId(String SkuId) {
		this.SkuId = SkuId;
	}

	private String getSkuId() {
		return SkuId;
	}

	private void setResponseCode(String ResponseCode) {
		this.ResponseCode = ResponseCode;
	}

	private String getResponseCode() {
		return ResponseCode;
	}

	private void setTransactionDate(String TransactionDate) {
		this.TransactionDate = TransactionDate;
	}

	private String getTransactionDate() {
		return TransactionDate;
	}

	private void setAmount(String Amount) {
		this.Amount = Amount;
	}

	private String getAmount() {
		return Amount;
	}

	private void setMobileNumber(String MobileNumber) {
		this.MobileNumber = MobileNumber;
	}

	private String getMobileNumber() {
		return MobileNumber;
	}

	private void setIsLive(boolean IsLive) {
		this.IsLive = IsLive;
	}

	private boolean getIsLive() {
		return IsLive;
	}

	private void setSenderName(String SenderName) {
		this.SenderName = SenderName;
	}

	private String getSenderName() {
		return SenderName;
	}

	private void setStatus(String Status) {
		this.Status = Status;
	}

	private String getStatus() {
		return Status;
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

	private void setcvv(String cvv) {
		this.cvv = cvv;
	}

	private String getcvv() {
		return cvv;
	}

	private void setCardNumber(String CardNumber) {
		this.CardNumber = CardNumber;
	}

	private String getCardNumber() {
		return CardNumber;
	}

	private void setExpirationDate(String setExpirationDate) {
		this.setExpirationDate = setExpirationDate;
	}

	private String getExpirationDate() {
		return setExpirationDate;
	}

	private void setCreatedDate(String CreatedDate) {
		this.CreatedDate = CreatedDate;
	}

	private String getCreatedDate() {
		return CreatedDate;
	}

	private void setPaymentGatewayResponse(String PaymentGatewayResponse) {
		this.PaymentGatewayResponse = PaymentGatewayResponse;
	}

	private String getPaymentGatewayResponse() {
		return PaymentGatewayResponse;
	}

	private void setPaymentGatewayTransactionId(String PaymentGatewayTransactionId) {
		this.PaymentGatewayTransactionId = PaymentGatewayTransactionId;
	}

	private String getPaymentGatewayTransactionId() {
		return PaymentGatewayTransactionId;
	}

	private void setPreNationResponse(String PreNationResponse) {
		this.PreNationResponse = PreNationResponse;
	}

	private String getPreNationResponse() {
		return PreNationResponse;
	}

	private void setSKUId(String SKUId) {
		this.SKUId = SKUId;
	}

	private String getSKUId() {
		return SKUId;
	}

	public static String GetRequest(String sUsername, String sPassword, String sVersion, String sSku, double dAmount,
			String sMobileNumber) {
		String sRequest = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pin=\"http://www.pininteract.com\">";
		sRequest += "<soapenv:Header>";
		sRequest += "<pin:AuthenticationHeader>";
		sRequest += "<pin:userId>" + sUsername + "</pin:userId>";
		sRequest += "<pin:password>" + sPassword + "</pin:password>";
		sRequest += "</pin:AuthenticationHeader>";
		sRequest += "</soapenv:Header>";
		sRequest += "<soapenv:Body>";
		sRequest += "<pin:PurchaseRtr2>";
		sRequest += "<pin:version>" + sVersion + "</pin:version>";
		sRequest += "<pin:skuId>" + sSku + "</pin:skuId>";
		sRequest += "<pin:amount>" + dAmount + "</pin:amount>";
		sRequest += "<pin:mobile>" + sMobileNumber + "</pin:mobile>";
		sRequest += "<pin:correlationId>?</pin:correlationId>";
		sRequest += "<pin:senderMobile>" + sMobileNumber + "</pin:senderMobile>";
		sRequest += "<pin:storeId>?</pin:storeId>";
		sRequest += "</pin:PurchaseRtr2>";
		sRequest += "</soapenv:Body>";
		sRequest += "</soapenv:Envelope>";

		return sRequest;

	}

	public static String GetRequestSKU(String sUsername, String sPassword, String sVersion) {
		String sRequest = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pin=\"http://www.pininteract.com\">";
		sRequest += "<soapenv:Header>";
		sRequest += "<pin:AuthenticationHeader>";
		sRequest += "<pin:userId>" + sUsername + "</pin:userId>";
		sRequest += "<pin:password>" + sPassword + "</pin:password>";
		sRequest += "</pin:AuthenticationHeader>";
		sRequest += "</soapenv:Header>";
		sRequest += "<soapenv:Body>";
		sRequest += "<pin:GetSkuList>";
		sRequest += "<pin:version>" + sVersion + "</pin:version>";

		sRequest += "</pin:GetSkuList>";
		sRequest += "</soapenv:Body>";
		sRequest += "</soapenv:Envelope>";

		return sRequest;

	}

	public BillPay billpayment(BillPay _BillPay) {

		Connection _Connection = MYSQLConnection.GetConnection();
		PreparedStatement _PreparedStatement = null;
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();

		// authrozie.net start

		try {

			ResultSet _ResultSet = _MYSQLHelper.GetResultSet(
					"SELECT * FROM authorizepaymentsettings where PaymentMethodId='" + _BillPay.PaymentMethodId + "'",
					_Connection);
			if (_ResultSet.next()) {
				ResultSet _ResultSetPayment = _MYSQLHelper.GetResultSet(
						"SELECT * FROM paymentmethod where PaymentMethodId='" + _BillPay.PaymentMethodId + "'",
						_Connection);
				if (_ResultSetPayment.next()) {
					String PaymentMethod = _ResultSetPayment.getString("Title");

					if (PaymentMethod.contains("Authorize")) {
						ApiOperationBase.setEnvironment(Environment.SANDBOX);
						MerchantAuthenticationType merchantAuthenticationType = new MerchantAuthenticationType();
						String apiLoginId = _ResultSet.getString("MerchantLoginId");
						String transactionKey = _ResultSet.getString("MerchantTransactionKey");
						merchantAuthenticationType.setName(apiLoginId);
						merchantAuthenticationType.setTransactionKey(transactionKey);
						PaymentType paymentType = new PaymentType();
						CreditCardType creditCard = new CreditCardType();
						creditCard.setCardNumber(_BillPay.CardNumber);
						creditCard.setExpirationDate(_BillPay.setExpirationDate);
						creditCard.setCardCode(_BillPay.cvv);
						paymentType.setCreditCard(creditCard);
						TransactionRequestType txnRequest = new TransactionRequestType();
						txnRequest.setTransactionType(TransactionTypeEnum.AUTH_ONLY_TRANSACTION.value());
						txnRequest.setPayment(paymentType);
						txnRequest.setAmount(new BigDecimal(_BillPay.Amount).setScale(2, RoundingMode.CEILING));

						CreateTransactionRequest apiRequest = new CreateTransactionRequest();
						apiRequest.setMerchantAuthentication(merchantAuthenticationType);

						apiRequest.setTransactionRequest(txnRequest);
						CreateTransactionController controller = new CreateTransactionController(apiRequest);
						controller.execute();
						CreateTransactionResponse response = controller.getApiResponse();

						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Calendar cal = Calendar.getInstance();
						String date = format.format(cal.getTime());
						_BillPay.setCreatedDate(date);
						_BillPay.setTransactionDate(date);
						if (response != null) {
							// System.out.println("Response Code ishu: " +
							// response.getMessages().getResultCode());

							// If API Response is ok, go ahead and check the
							// transaction
							// response
							if (response.getMessages().getResultCode() == MessageTypeEnum.OK) {
								TransactionResponse result = response.getTransactionResponse();
								if (result.getMessages() != null) {
									// System.out.println("Successfully created
									// transaction with Transaction ID: " +
									// result.getTransId());
									// System.out.println("Response Code: " +
									// result.getResponseCode());
									//// System.out.println("Message Code: " +
									// result.getMessages().getMessage().get(0).getCode());
									// System.out.println("Description: " +
									// result.getMessages().getMessage().get(0).getDescription());
									// System.out.println("Auth code: " +
									// result.getAuthCode());

									// _AuthrozieTranscation.setResult(result.getMessages().getMessage().get(0).getDescription());

									_BillPay.setStatus("Success");
									_BillPay.setPaymentGatewayResponse(result.getResponseCode());
									_BillPay.setPaymentGatewayTransactionId(result.getTransId());
									_BillPay.setIsLive(false);

									// Rest code for Bill pay

									// String strURL =
									// "https://valuetopup.com/posaservice/servicemanager.asmx";
									String strURL = "https://qa.valuetopup.com/posaservice/servicemanager.asmx";
									String strSoapAction = "http://www.pininteract.com/BillPay";
									double sAmount = Double.parseDouble(_BillPay.Amount);
									PostMethod post = new PostMethod(strURL);
									String sRequest = GetRequest("Falcontest", "Hello@123", "1.0", _BillPay.SKUId,
											sAmount, _BillPay.MobileNumber);
									RequestEntity entity = new StringRequestEntity(sRequest);

									post.setRequestEntity(entity);
									post.setRequestHeader("SOAPAction", strSoapAction);
									post.setRequestHeader("Content-Type", "text/xml; StandardCharsets.UTF_8");
									HttpClient httpclient = new HttpClient();

									try {
										int resultpay = 0;
										try {
											resultpay = httpclient.executeMethod(post);
										} catch (HttpException e) {
											_BillPay.setResult("Failed");
											_BillPay.setError(
													"Your transaction could not be completed due to some issue, please contact administrator.");
											clear(_BillPay);
											// System.out.println("error code1:
											// " +
											// result);
										} catch (IOException e) {
											// System.out.println("error code11:
											// " +
											// result);
											_BillPay.setResult("Failed");
											_BillPay.setError(
													"Your transaction could not be completed due to some issue, please contact administrator.");
											clear(_BillPay);
										}

										// System.out.println("Response status
										// code: " +
										// result);

										// System.out.println("Response body:
										// ");
										try {
											System.out.println(post.getResponseBodyAsString());
											if (resultpay == 200) {

												// _BillPay.setResult("Success");
											} else {
												_BillPay.setResult("Failed");
												_BillPay.setError(
														"Your transaction could not be completed due to some issue, please contact administrator.");
												clear(_BillPay);
											}

										} catch (IOException e) {

											clear(_BillPay);
											_BillPay.setResult("Failed");
											_BillPay.setError(
													"Your transaction could not be completed due to some issue, please contact administrator.");
											clear(_BillPay);
										}
									} finally {

										post.releaseConnection();
									}

									try {
										DocumentBuilderFactory _DocumentBuilderFactory = DocumentBuilderFactory
												.newInstance();
										DocumentBuilder _DocumentBuilder = _DocumentBuilderFactory.newDocumentBuilder();
										Document _Document = _DocumentBuilder
												.parse(new StringBufferInputStream(post.getResponseBodyAsString()));
										_Document.getDocumentElement().normalize();
										NodeList _NodeList = _Document.getElementsByTagName("orderResponse");

										if (_NodeList.getLength() > 0) {
											Node _Node = _NodeList.item(0);
											if (_Node.getNodeType() == Node.ELEMENT_NODE) {
												Element _Element = (Element) _Node;
												System.out.println(_Element.getAttribute("responseCode"));
												NodeList _tNodeList = _Document.getElementsByTagName("invoice");

												ResultSet _ResultSetcompany = _MYSQLHelper
														.GetResultSet("SELECT * FROM company where Company_Id='"
																+ _BillPay.CompanyId + "'", _Connection);
												if (_ResultSetcompany.next()) {
													ResultSet _ResultSetcustomer = _MYSQLHelper
															.GetResultSet("SELECT * FROM customer where customer_Id='"
																	+ _BillPay.CustomerId + "'", _Connection);
													if (_ResultSetcustomer.next()) {

														if (_tNodeList.getLength() > 0) {
															Node _tNode = _tNodeList.item(0);
															if (_tNode.getNodeType() == Node.ELEMENT_NODE) {
																Element _tElement = (Element) _tNode;
																// System.out.println(_tElement.getAttribute("invoiceNumber"));
																// System.out.println(_tElement.getAttribute("transactionDateTime"));
																_BillPay.setInvoiceNumber(
																		_tElement.getAttribute("invoiceNumber"));
																_BillPay.setTransactionDate(
																		_tElement.getAttribute("transactionDateTime"));
																if (_tElement.getNodeType() == Node.ELEMENT_NODE) {
																	Element _cElement = (Element) _tElement;
																	// System.out.println(_cElement.getAttribute("invoiceAmount"));
																	// System.out.println(_cElement.getAttribute("faceValueAmount"));
																	_BillPay.setFaceAmount(
																			_tElement.getAttribute("faceValueAmount"));

																	_BillPay.setInvoiceAmount(Double.parseDouble(
																			_cElement.getAttribute("invoiceAmount")));
																	// System.out.println(_cElement.getAttribute("skuId"));
																	_BillPay.setResponseCode("000");

																	AuthrozieTranscation _AuthrozieTranscation = new AuthrozieTranscation();
																	double sFees = Double.parseDouble(_BillPay.Fees);

																	int lastid = _AuthrozieTranscation
																			.saveDataTranscationDetails(
																					_BillPay.CompanyId,
																					_BillPay.CustomerId,
																					_BillPay.SenderName,
																					_BillPay.InvoiceAmount, 0.00, sFees,
																					0.00, _BillPay.TransactionDate,
																					_BillPay.Status,
																					_BillPay.PaymentGatewayResponse,
																					_BillPay.PaymentGatewayTransactionId
																							.toString(),
																					3, 3, 3, 0,
																					_BillPay.PaymentMethodId, 226, 226,
																					_BillPay.IsLive, "Bill Payment", 0,
																					"0", _BillPay.CreatedDate);
																	_BillPay.setTransactionId(lastid);

																	_BillPay.setVersionNo("1.0");
																	int Resultlastid = _BillPay.addbillPayDetails(
																			_BillPay.CompanyId, _BillPay.CustomerId,
																			_BillPay.TransactionId, _BillPay.SenderName,
																			_BillPay.MobileNumber, _BillPay.VersionNo,
																			_BillPay.SKUId, _BillPay.InvoiceNumber,
																			_BillPay.TransactionDate,
																			_BillPay.InvoiceAmount, _BillPay.FaceAmount,
																			_BillPay.ResponseCode);

																	_BillPay.setResult("Success");
																	_BillPay.setBillPayId(Resultlastid);
																	// clear(_BillPay);

																}

															}

														} else {
															// System.out.println(_Element.getAttribute("responseCode"));
															NodeList _oNodeList = _Document
																	.getElementsByTagName("orderResponse");
															Node _tNode = _oNodeList.item(0);
															if (_tNode.getNodeType() == Node.ELEMENT_NODE) {
																Element _tElement = (Element) _tNode;
																_BillPay.setResponseCode(
																		_tElement.getAttribute("invoiceNumber"));
																_BillPay.setResult("Failed!");
																_BillPay.setError(
																		_tElement.getAttribute("responseMessage"));
																clear(_BillPay);
															}

														}

													} else {
														_BillPay.setResult("Failed!");
														_BillPay.setError("Invalid Customer Id!");
														clear(_BillPay);
													}
												} else {
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

									// Bill Pay end

									// clear(_BillPay);
								} else {
									// System.out.println("Failed
									// Transaction.");
									if (response.getTransactionResponse().getErrors() != null) {
										// System.out.println("Error Code: " +
										// response.getTransactionResponse().getErrors().getError().get(0).getErrorCode());
										// System.out.println("Error message: "
										// +
										// response.getTransactionResponse().getErrors().getError().get(0).getErrorText());
										_BillPay.setResult("failed");
										_BillPay.setError("Failed Transaction!");
										clear(_BillPay);
									}
								}
							} else {
								// System.out.println("Failed Transaction.");
								if (response.getTransactionResponse() != null
										&& response.getTransactionResponse().getErrors() != null) {
									// System.out.println("Error Code: " +
									// response.getTransactionResponse().getErrors().getError().get(0).getErrorCode());
									// System.out.println("Error message: " +
									// response.getTransactionResponse().getErrors().getError().get(0).getErrorText());
									_BillPay.setResult("failed");
									_BillPay.setError("Invalid api Login Id!");
									clear(_BillPay);
								} else {
									// System.out.println("Error Code: " +
									// response.getMessages().getMessage().get(0).getCode());
									// System.out.println("Error message: " +
									// response.getMessages().getMessage().get(0).getText());
									_BillPay.setResult("failed");
									_BillPay.setError("Failed Transaction!");
									clear(_BillPay);
								}
							}
						} else {
							// System.out.println("Null Response.");
							_BillPay.setResult("failed");
							_BillPay.setError("Invalid transaction Key!");
							clear(_BillPay);
						}
					} else if (PaymentMethod.contains("Visa Credit Card")
							|| PaymentMethod.contains("MasterCard Credit Card")
							|| PaymentMethod.contains("Visa Debit Card")
							|| PaymentMethod.contains("MasterCard Debit Card")
							|| PaymentMethod.contains("Bank Debit (ACH)")) {
						MagicPay _MagicPay = new MagicPay();

						try {
							int resultpay = 0;

							try {

								double sAmounts = Double.parseDouble(_BillPay.Amount);
								SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								Calendar cal = Calendar.getInstance();
								String date = format.format(cal.getTime());
								_BillPay.setCreatedDate(date);
								_BillPay.setTransactionDate(date);
								_MagicPay.PaymentMethodId = _BillPay.PaymentMethodId;
								_MagicPay.CompanyId = _BillPay.CompanyId;
								_MagicPay.CustomerId = _BillPay.CustomerId;
								_MagicPay.SenderName = _BillPay.SenderName;
								_MagicPay.SendingAmount = sAmounts;
								_MagicPay.Charges = 0.00;
								_MagicPay.Tax = 0.00;
								_MagicPay.SendingCurrencyId = 3;
								_MagicPay.ReceivingAmount = 0;
								_MagicPay.ReceivingCurrencytId = 3;
								_MagicPay.BeneficiaryId = 0;
								_MagicPay.TransferPurpose = "Bill Payment";
								_MagicPay.ExchangeRate = 0;
								_MagicPay.DeliveryType = "0";
								_MagicPay.CardNumber = _BillPay.CardNumber;
								_MagicPay.setExpirationDate = _BillPay.setExpirationDate;
								_MagicPay.cvv = _BillPay.cvv;
								
								_MagicPay.addMagicPay(_MagicPay);
								if (_MagicPay.Result == "Success") {

									_BillPay.setVersionNo("1.0");
									_BillPay.setFaceAmount("0.00");
									_BillPay.setResponseCode("000");
									// _BillPay.setInvoiceNumber(_BillPay.PreNationInvoiceNumber);

									_BillPay.TransactionId = _MagicPay.TransactionId;
									double sAmountss = Double.parseDouble(_BillPay.Amount);
									int Resultlastid = _BillPay.addbillPayDetails(_BillPay.CompanyId,
											_BillPay.CustomerId, _BillPay.TransactionId, _BillPay.SenderName,
											_BillPay.MobileNumber, _BillPay.VersionNo, _BillPay.SKUId,
											_BillPay.InvoiceNumber, _BillPay.TransactionDate, sAmountss,
											_BillPay.FaceAmount, _BillPay.ResponseCode);

									_BillPay.setResult("Success");
									_BillPay.setBillPayId(Resultlastid);
									String dPaymentGatewayTransactionId = _MagicPay.PaymentGatewayTransactionId
											.toString();
									_BillPay.setPaymentGatewayTransactionId(dPaymentGatewayTransactionId);

									
									_BillPay.Prenation(_BillPay);
									
									
									// clear(_BillPay);
								} else {
									_BillPay.setResult(_MagicPay.Result);
									_BillPay.setError(_MagicPay.Error);
									clear(_BillPay);
								}

							} catch (Exception e) {

								clear(_BillPay);
								_BillPay.setResult("Failed");
								_BillPay.setError(
										"Your transaction could not be completed due to some issue, please contact administrator.");
								clear(_BillPay);
							}
						} catch (Exception e) {

							clear(_BillPay);
							_BillPay.setResult("Failed");
							_BillPay.setError(
									"Your transaction could not be completed due to some issue, please contact administrator.");
							clear(_BillPay);
						}
					}

				} else {
					// System.out.println("Null Response.");
					_BillPay.setResult("failed");
					_BillPay.setError("Invalid Payment Method Id!");
					clear(_BillPay);
				}

			} else {
				// System.out.println("Null Response.");
				_BillPay.setResult("failed");
				_BillPay.setError(
						"Payment settings are not available for this Payment Method, please contact to system administrator!");
				clear(_BillPay);
			}

		} catch (Exception e) {
			clear(_BillPay);
		}
		// end

		return _BillPay;
	}

	public int addbillPayDetails(int CompanyId, int CustomerId, int TransactionId, String SenderName,
			String MobileNumber, String Version, String SkuId, String InvoiceNumber, String TransactionDate,
			Double InvoiceAmount, String FaceValueAmount, String ResponseCode) {
		int Result = 0;
		Connection _Connection = MYSQLConnection.GetConnection();
		try {
			DecimalFormat _decimalFormat = new DecimalFormat("##.00");
			// String _formate = _decimalFormat.format(InvoiceAmount);
			double _invoiceAmount = (Double) InvoiceAmount;
			PreparedStatement _PreparedStatement = null;
			MYSQLHelper _MYSQLHelper = new MYSQLHelper();
			String sInsertStatement = "INSERT INTO billpaydetails( CompanyId, CustomerId,TransactionId,SenderName,MobileNumber, Version,SkuId,InvoiceNumber,TransactionDate,InvoiceAmount,FaceValueAmount,ResponseCode)";
			sInsertStatement = sInsertStatement + " VALUES(?, ?, ?,?, ?, ?,?, ?, ?,?,?,?)";
			_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
			_PreparedStatement.setInt(1, CompanyId);
			_PreparedStatement.setInt(2, CustomerId);
			_PreparedStatement.setInt(3, TransactionId);
			_PreparedStatement.setString(4, SenderName);
			_PreparedStatement.setString(5, MobileNumber);
			_PreparedStatement.setString(6, VersionNo);
			_PreparedStatement.setString(7, SkuId);
			_PreparedStatement.setString(8, InvoiceNumber);
			_PreparedStatement.setString(9, TransactionDate);
			_PreparedStatement.setDouble(10, _invoiceAmount);
			_PreparedStatement.setString(11, FaceAmount);
			_PreparedStatement.setString(12, ResponseCode);
			_PreparedStatement.executeUpdate();

			ResultSet _ResultSetbillpayld = _MYSQLHelper
					.GetResultSet("SELECT MAX(BillPayId) AS BillPayId FROM billpaydetails", _Connection);
			if (_ResultSetbillpayld.next()) {
				int lastid = _ResultSetbillpayld.getInt("BillPayId");
				Result = lastid;

			}
		} catch (Exception e) {
			System.out.println("error:" + e.getMessage());
		}

		return Result;
	}

	public static ArrayList<BillPay> getBillPayDetails(int CustomerId) {
		Connection _Connection = MYSQLConnection.GetConnection();
		ArrayList<BillPay> _BillPayDetaillist = new ArrayList<BillPay>();
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		try {
			if (_Connection != null) {

				ResultSet _ResultSet = _MYSQLHelper.GetResultSet(
						"SELECT * FROM billpaydetails where CustomerId='" + CustomerId + "'", _Connection);

				while (_ResultSet.next()) {
					BillPay _BillPay = new BillPay();
					_BillPay.setBillPayId(_ResultSet.getInt("BillPayId"));
					_BillPay.setCompanyId(_ResultSet.getInt("CompanyId"));
					_BillPay.setCustomerId(_ResultSet.getInt("CustomerId"));
					_BillPay.setTransactionId(_ResultSet.getInt("TransactionId"));
					_BillPay.setSenderName(_ResultSet.getString("SenderName"));
					_BillPay.setMobileNumber(_ResultSet.getString("MobileNumber"));
					_BillPay.setVersionNo(_ResultSet.getString("Version"));
					_BillPay.setSkuId(_ResultSet.getString("SkuId"));
					_BillPay.setInvoiceNumber(_ResultSet.getString("InvoiceNumber"));
					_BillPay.setTransactionDate(_ResultSet.getString("TransactionDate"));
					_BillPay.setInvoiceAmount(_ResultSet.getDouble("InvoiceAmount"));
					_BillPay.setFaceAmount(_ResultSet.getString("FaceValueAmount"));
					_BillPay.setAmount(_ResultSet.getString("FaceValueAmount"));
					_BillPay.setResponseCode(_ResultSet.getString("ResponseCode"));
					_BillPay.setResult("Success");
					_BillPayDetaillist.add(_BillPay);
				}
				_ResultSet.close();
			}

		} catch (Exception e) {

		} finally {

			if (_Connection != null) {
				try {
					_Connection.close();
				} catch (SQLException e) {

				}
			}
		}

		return _BillPayDetaillist;
	}

	public BillPay Prenation(BillPay _BillPay) {
		

		// String strURL =
		
		String strURL = "https://valuetopup.com/posaservice/servicemanager.asmx";
		//String strURL = "https://qa.valuetopup.com/posaservice/servicemanager.asmx";
		String strSoapAction = "http://www.pininteract.com/PurchaseRtr2";
		double sAmount = Double.parseDouble(_BillPay.Amount);
		PostMethod post = new PostMethod(strURL);
		
		String sRequest = GetRequest("Falconclk", "Ah2yinI37Dfi80cx7", "1.0", _BillPay.SKUId, sAmount,
				_BillPay.MobileNumber);
		//String sRequest = GetRequest("Falcontest", "Hello@123", "1.0", _BillPay.SKUId, sAmount,
			//	_BillPay.MobileNumber);
		RequestEntity entity = new StringRequestEntity(sRequest);

		post.setRequestEntity(entity);
		post.setRequestHeader("SOAPAction", strSoapAction);
		// post.setRequestHeader("Content-Type", "text/xml;
		// charset=ISO-8859-1");
		post.setRequestHeader("Content-Type", "text/xml; StandardCharsets.UTF_8");
		HttpClient httpclient = new HttpClient();

		try {

			int resultpay = 0;
			try {
				resultpay = httpclient.executeMethod(post);
			} catch (HttpException e) {
				_BillPay.setResult("Failed");
				_BillPay.setError(
						"Your transaction could not be completed due to some issue, please contact administrator.");
				clear(_BillPay);

			} catch (IOException e) {

				_BillPay.setResult("Failed");
				_BillPay.setError(
						"Your transaction could not be completed due to some issue, please contact administrator.");
				clear(_BillPay);
			}

			try {
				DocumentBuilderFactory _DocumentBuilderFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder _DocumentBuilder = _DocumentBuilderFactory.newDocumentBuilder();
				Document _Document = _DocumentBuilder
						.parse(new StringBufferInputStream(post.getResponseBodyAsString()));
				_Document.getDocumentElement().normalize();
				NodeList _NodeList = _Document.getElementsByTagName("orderResponse");

				System.out.println("aya:" + post.getResponseBodyAsString());
				_BillPay.setPreNationResponse(post.getResponseBodyAsString());
				NodeList _tNodeList = _Document.getElementsByTagName("invoice");

				if (_tNodeList.getLength() > 0) {
					Node _tNode = _tNodeList.item(0);
					if (_tNode.getNodeType() == Node.ELEMENT_NODE) {
						Element _tElement = (Element) _tNode;
						// System.out.println(_tElement.getAttribute("invoiceNumber"));
						// System.out.println(_tElement.getAttribute("transactionDateTime"));
						_BillPay.setPreNationInvoiceNumber(_tElement.getAttribute("invoiceNumber"));
						_BillPay.setInvoiceNumber(_tElement.getAttribute("invoiceNumber"));
						System.out.println(post.getResponseBodyAsString());
						if (resultpay == 200) {
							MYSQLHelper _MYSQLHelper = new MYSQLHelper();
							Connection _Connection = MYSQLConnection.GetConnection();
							 PreparedStatement _PreparedStatement = null;
							String sInsertStatement ="UPDATE billpaydetails SET InvoiceNumber = ?"+ " WHERE BillPayId = ?";
							_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
							_PreparedStatement.setString(1, _BillPay.InvoiceNumber);							
							_PreparedStatement.setInt(2, _BillPay.BillPayId);
							_PreparedStatement.executeUpdate();
							_BillPay.setResult("Success");
						}
					}

				} else {
					_BillPay.setResult("Failed");
					_BillPay.setError(
							"Your transaction could not be completed due to some issue, please contact administrator.");
					clear(_BillPay);
				}

			} catch (IOException e) {

				clear(_BillPay);
				_BillPay.setResult("Failed");
				_BillPay.setError(
						"Your transaction could not be completed due to some issue, please contact administrator.");
				clear(_BillPay);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			post.releaseConnection();
		}
		return _BillPay;
	}

	public BillPay clear(BillPay _BillPay) {
		_BillPay.setCompanyId(0);
		_BillPay.setCustomerId(0);
		_BillPay.setInvoiceNumber("");
		_BillPay.setFaceAmount("");
		_BillPay.setInvoiceAmount(0);
		_BillPay.setVersionNo("");
		_BillPay.setSkuId("");
		_BillPay.setSenderName("");
		_BillPay.setAmount("");
		_BillPay.setMobileNumber("");
		_BillPay.setResponseCode("");
		_BillPay.setCardNumber("");
		_BillPay.setExpirationDate("");
		_BillPay.setcvv("");
		_BillPay.setPaymentMethodId(0);
		_BillPay.setTransactionDate("");
		_BillPay.setCreatedDate("");
		_BillPay.setFees("");
		return _BillPay;
	}

}
