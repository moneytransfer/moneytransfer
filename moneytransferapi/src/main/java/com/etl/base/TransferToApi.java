package com.etl.base;

import java.io.IOException;
import java.io.StringReader;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.etl.util.MYSQLConnection;
import com.etl.util.MYSQLHelper;

public class TransferToApi {

	public int CompanyId;
	public int CustomerId;
	public int TransactionId;
	public String PaymentGatewayTransactionId;
	public String Login;
	public String Key;
	public String MD5;
	public String Country;
	public String CountryId;
	public String Operator;
	public String OperatorId;
	public String MobileNumber;
	public double Amount;
	public double FaceAmount;
	public double Fees;
	public String Sender;
	public String TransactionDetail;
	public double Charges;
	public double Tax;
	public int SendingCurrencyId;
	public int BeneficiaryId;
	public int SourceCountryId;
	public int DestinationCountryId;
	public int PaymentMethodId;
	public boolean IsLive;
	public String TransferPurpose;
	public double ExchangeRate;

	public int ReceivingCurrencytId;
	public String AuthenticationKey;
	public String DestinationCurrency;
	public String ProductList;
	public String RetailPriceList;
	public String WholesalePriceList;
	public String LocalInfoValueList;
	public String LocalInfoAmountList;
	public String TransfertToApiResponse;
	public String ReservedId;

	public String DestinationMsisdn;
	public String ReferenceOperator;
	public String OriginatingCurrency;
	public String ProductRequested;
	public String ActualProductSent;
	public String Balance;
	public String SmsSent;
	public String Sms;
	public String Cid1;
	public String TransactionDate;
	public String ReturnRersion;
	public String SenderSms;
	public String SenderText;
	public String TransferttoTransid;
	public String CardNumber;
	public String setExpirationDate;
	public String cvv;
	public String Result;
	public String Error;

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

	private void setTransferttoTransid(String TransferttoTransid) {
		this.TransferttoTransid = TransferttoTransid;
	}

	private String getTransferttoTransid() {
		return TransferttoTransid;
	}

	private void setTransferPurpose(String TransferPurpose) {
		this.TransferPurpose = TransferPurpose;
	}

	private String getTransferPurpose() {
		return TransferPurpose;
	}

	private void setPaymentGatewayTransactionId(String PaymentGatewayTransactionId) {
		this.PaymentGatewayTransactionId = PaymentGatewayTransactionId;
	}

	private String getPaymentGatewayTransactionId() {
		return PaymentGatewayTransactionId;
	}

	private void setSender(String Sender) {
		this.Sender = Sender;
	}

	private String getSender() {
		return Sender;
	}

	private void setExchangeRate(double ExchangeRate) {
		this.ExchangeRate = ExchangeRate;
	}

	private double getExchangeRate() {
		return ExchangeRate;
	}

	private void setIsLive(boolean IsLive) {
		this.IsLive = IsLive;
	}

	private boolean getIsLive() {
		return IsLive;
	}

	private void setPaymentMethodId(int PaymentMethodId) {
		this.PaymentMethodId = PaymentMethodId;
	}

	private int getPaymentMethodId() {
		return PaymentMethodId;
	}

	private void setDestinationCountryId(int DestinationCountryId) {
		this.DestinationCountryId = DestinationCountryId;
	}

	private int getDestinationCountryId() {
		return DestinationCountryId;
	}

	private void setSendingCurrencyId(int SendingCurrencyId) {
		this.SendingCurrencyId = SendingCurrencyId;
	}

	private int getSendingCurrencyId() {
		return SendingCurrencyId;
	}

	private void setSourceCountryId(int SourceCountryId) {
		this.SourceCountryId = SourceCountryId;
	}

	private int getSourceCountryId() {
		return SourceCountryId;
	}

	private void setBeneficiaryId(int BeneficiaryId) {
		this.BeneficiaryId = BeneficiaryId;
	}

	private int getBeneficiaryId() {
		return BeneficiaryId;
	}

	private void setCharges(double Charges) {
		this.Charges = Charges;
	}

	private double getCharges() {
		return Charges;
	}

	private void setTax(double Tax) {
		this.Tax = Tax;
	}

	private double getTax() {
		return Tax;
	}

	private void setTransactionDetail(String TransactionDetail) {
		this.TransactionDetail = TransactionDetail;
	}

	private String getTransactionDetail() {
		return TransactionDetail;
	}

	private void setCustomerId(int CustomerId) {
		this.CustomerId = CustomerId;
	}

	private int getCustomerId() {
		return CustomerId;
	}

	private void setCompanyId(int CompanyId) {
		this.CompanyId = CompanyId;
	}

	private int getCompanyId() {
		return CompanyId;
	}

	private void setTransactionId(int TransactionId) {
		this.TransactionId = TransactionId;
	}

	private int getTransactionId() {
		return TransactionId;
	}

	private void setLogin(String Login) {
		this.Login = Login;
	}

	private String getLogin() {
		return Login;
	}

	private void setKey(String Key) {
		this.Key = Key;
	}

	private String getKey() {
		return Key;
	}

	private void setMD5(String MD5) {
		this.MD5 = MD5;
	}

	private String getMD5() {
		return MD5;
	}

	private void setCountry(String Country) {
		this.Country = Country;
	}

	private String getCountry() {
		return Country;
	}

	private void setCountryId(String CountryId) {
		this.CountryId = CountryId;
	}

	private String getCountryId() {
		return CountryId;
	}

	private void setOperator(String Operator) {
		this.Operator = Operator;
	}

	private String getOperator() {
		return Operator;
	}

	private void setOperatorId(String OperatorId) {
		this.OperatorId = OperatorId;
	}

	private String getOperatorId() {
		return OperatorId;
	}

	private void setMobileNumber(String MobileNumber) {
		this.MobileNumber = MobileNumber;
	}

	private String getMobileNumber() {
		return MobileNumber;
	}
	
	private void setFaceAmount(double FaceAmount) {
		this.FaceAmount = FaceAmount;
	}

	private double getFaceAmount() {
		return FaceAmount;
	}

	
	private void setAmount(double Amount) {
		this.Amount = Amount;
	}

	private double getAmount() {
		return Amount;
	}

	private void setFees(double Fees) {
		this.Fees = Fees;
	}

	private double getFees() {
		return Fees;
	}

	private void setAuthenticationKey(String AuthenticationKey) {
		this.AuthenticationKey = AuthenticationKey;
	}

	private String getAuthenticationKey() {
		return AuthenticationKey;
	}

	private void setDestinationCurrency(String DestinationCurrency) {
		this.DestinationCurrency = DestinationCurrency;
	}

	private String getDestinationCurrency() {
		return DestinationCurrency;
	}

	private void setLocalInfoAmountList(String LocalInfoAmountList) {
		this.LocalInfoAmountList = LocalInfoAmountList;
	}

	private String getLocalInfoAmountList() {
		return LocalInfoAmountList;
	}

	private void setLocalInfoValueList(String LocalInfoValueList) {
		this.LocalInfoValueList = LocalInfoValueList;
	}

	private String getLocalInfoValueList() {
		return DestinationCurrency;
	}

	private void setWholesalePriceList(String WholesalePriceList) {
		this.WholesalePriceList = WholesalePriceList;
	}

	private String getWholesalePriceList() {
		return WholesalePriceList;
	}

	private void setRetailPriceList(String RetailPriceList) {
		this.RetailPriceList = RetailPriceList;
	}

	private String getRetailPriceList() {
		return RetailPriceList;
	}

	private void setProductList(String ProductList) {
		this.ProductList = ProductList;
	}

	private String getProductList() {
		return ProductList;
	}

	private void setTransfertToApiResponse(String TransfertToApiResponse) {
		this.TransfertToApiResponse = TransfertToApiResponse;
	}

	private String getTransfertToApiResponse() {
		return TransfertToApiResponse;
	}

	private void setReservedId(String ReservedId) {
		this.ReservedId = ReservedId;
	}

	private String getReservedId() {
		return ReservedId;
	}

	private void setResult(String Result) {
		this.Result = Result;
	}

	private String getResult() {
		return Result;
	}

	private void setDestinationMsisdn(String DestinationMsisdn) {
		this.DestinationMsisdn = DestinationMsisdn;
	}

	private String getDestinationMsisdn() {
		return DestinationMsisdn;
	}

	private void setError(String Error) {
		this.Error = Error;
	}

	private String getError() {
		return Error;
	}

	private void setReferenceOperator(String ReferenceOperator) {
		this.ReferenceOperator = ReferenceOperator;
	}

	private String getReferenceOperator() {
		return ReferenceOperator;
	}

	private void setOriginatingCurrency(String OriginatingCurrency) {
		this.OriginatingCurrency = OriginatingCurrency;
	}

	private String getOriginatingCurrency() {
		return OriginatingCurrency;
	}

	private void setProductRequested(String ProductRequested) {
		this.ProductRequested = ProductRequested;
	}

	private String getProductRequested() {
		return ProductRequested;
	}

	private void setActualProductSent(String ActualProductSent) {
		this.ActualProductSent = ActualProductSent;
	}

	private String getActualProductSent() {
		return ActualProductSent;
	}

	private void setBalance(String Balance) {
		this.Balance = Balance;
	}

	private String getBalance() {
		return Balance;
	}

	private void setSmsSent(String SmsSent) {
		this.SmsSent = SmsSent;
	}

	private String getSmsSent() {
		return SmsSent;
	}

	private void setSms(String Sms) {
		this.Sms = Sms;
	}

	private String geTSms() {
		return Sms;
	}

	private void setCid1(String Cid1) {
		this.Cid1 = Cid1;
	}

	private String getCid1() {
		return Cid1;
	}

	private void setTransactionDate(String TransactionDate) {
		this.TransactionDate = TransactionDate;
	}

	private String getTransactionDate() {
		return TransactionDate;
	}

	private void setReturnRersion(String ReturnRersion) {
		this.ReturnRersion = ReturnRersion;
	}

	private String getReturnRersion() {
		return ReturnRersion;
	}

	private void setSenderSms(String SenderSms) {
		this.SenderSms = SenderSms;
	}

	private String getSenderSms() {
		return SenderSms;
	}

	private void setSenderText(String SenderText) {
		this.SenderText = SenderText;
	}

	private String getSenderText() {
		return SenderText;
	}

	public TransferToApi addTransferTomsisdn_info(String MobileNumber) throws IOException {
		TransferToApi _TransferToApi = new TransferToApi();

		try {
			Connection _Connection = MYSQLConnection.GetConnection();
			MYSQLHelper _MYSQLHelper = new MYSQLHelper();

			ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM transfertoApi where isdeleted=0",
					_Connection);
			if (_ResultSet.next()) {
				long unixTime = System.currentTimeMillis() / 1000L;

				String aapiUrl = _ResultSet.getString("api_url");
				String lLogin = _ResultSet.getString("login");
				String tToken = _ResultSet.getString("token");
				String md5_string = getKeyedDigest(lLogin, tToken, unixTime);
				String strSoapAction = aapiUrl;
				String sRequest = GetRequest(lLogin, unixTime, md5_string, MobileNumber, "1", "0", "msisdn_info");
				RequestEntity entity = new StringRequestEntity(sRequest);

				PostMethod post = new PostMethod(strSoapAction);
				post.setRequestEntity(entity);
				post.setRequestHeader("Content-Type", "text/xml; StandardCharsets.UTF_8");
				HttpClient httpclient = new HttpClient();
				int resultpay = 0;
				try {
					resultpay = httpclient.executeMethod(post);
					// System.out.println(resultpay);
				} catch (HttpException e) {
					_TransferToApi.setResult("failed!");
					_TransferToApi.setError(e.getMessage());
				}
				System.out.println(post.getResponseBodyAsString());
				if (resultpay == 200) {
					// System.out.println("Success");
					try {

						DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
						InputSource src = new InputSource();
						src.setCharacterStream(new StringReader(post.getResponseBodyAsString()));
						Document doc = builder.parse(src);
						String country = doc.getElementsByTagName("country").item(0).getTextContent();

						String countryId = doc.getElementsByTagName("countryid").item(0).getTextContent();
						String operator = doc.getElementsByTagName("operator").item(0).getTextContent();
						String operatorid = doc.getElementsByTagName("operatorid").item(0).getTextContent();
						String destination_msisdn = doc.getElementsByTagName("destination_msisdn").item(0)
								.getTextContent();
						String destination_currency = doc.getElementsByTagName("destination_currency").item(0)
								.getTextContent();
						String authentication_key = doc.getElementsByTagName("authentication_key").item(0)
								.getTextContent();
						String error_txt = doc.getElementsByTagName("error_txt").item(0).getTextContent();
						String product_list = doc.getElementsByTagName("product_list").item(0).getTextContent();
						String retail_price_list = doc.getElementsByTagName("retail_price_list").item(0)
								.getTextContent();
						String wholesale_price_list = doc.getElementsByTagName("wholesale_price_list").item(0)
								.getTextContent();
						String local_info_value_list = doc.getElementsByTagName("local_info_value_list").item(0)
								.getTextContent();
						String local_info_amount_list = doc.getElementsByTagName("local_info_amount_list").item(0)
								.getTextContent();

						_TransferToApi.setCountry(country);
						_TransferToApi.setCountryId(countryId);
						_TransferToApi.setOperator(operator);
						_TransferToApi.setOperatorId(operatorid);
						_TransferToApi.setMobileNumber(destination_msisdn);
						_TransferToApi.setDestinationCurrency(destination_currency);
						_TransferToApi.setAuthenticationKey(authentication_key);
						_TransferToApi.setTransfertToApiResponse(error_txt);
						_TransferToApi.setProductList(product_list);
						_TransferToApi.setRetailPriceList(retail_price_list);
						_TransferToApi.setWholesalePriceList(wholesale_price_list);
						_TransferToApi.setLocalInfoValueList(local_info_value_list);
						_TransferToApi.setLocalInfoAmountList(local_info_amount_list);
						_TransferToApi.setResult("Success");
						// System.out.println("country" + country);
					} catch (Exception e) {
						_TransferToApi.setResult("failed!");
						_TransferToApi.setError(e.getMessage());
					}

				} else {
					_TransferToApi.setResult("failed!");
					_TransferToApi.setError("Internal server error, please contact to system adminstrator!");
				}
			} else {
				_TransferToApi.setResult("failed!");
				_TransferToApi.setError("Please contact to system adminstrator for trsnaferto api setting enable!");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return _TransferToApi;
	}

	public TransferToApi TransferToreserverId() {
		TransferToApi _TransferToApi = new TransferToApi();
		try {
			Connection _Connection = MYSQLConnection.GetConnection();
			MYSQLHelper _MYSQLHelper = new MYSQLHelper();
			ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM transfertoApi where isdeleted=0",
					_Connection);
			if (_ResultSet.next()) {

				long unixTime = System.currentTimeMillis() / 1000L;

				String aapiUrl = _ResultSet.getString("api_url");
				String lLogin = _ResultSet.getString("login");
				String tToken = _ResultSet.getString("token");
				String md5_string = getKeyedDigest(lLogin, tToken, unixTime);
				String strSoapAction = aapiUrl;
				String sRequest = GetRequestReserverId(lLogin, unixTime, md5_string, "reserve_id");
				RequestEntity entity = new StringRequestEntity(sRequest);

				PostMethod post = new PostMethod(strSoapAction);
				post.setRequestEntity(entity);
				post.setRequestHeader("Content-Type", "text/xml; StandardCharsets.UTF_8");
				HttpClient httpclient = new HttpClient();
				int resultpay = 0;
				try {
					resultpay = httpclient.executeMethod(post);
				} catch (HttpException e) {
					_TransferToApi.setResult("failed!");
					_TransferToApi.setError(e.getMessage());
				}
				if (resultpay == 200) {
					try {

						DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
						InputSource src = new InputSource();
						src.setCharacterStream(new StringReader(post.getResponseBodyAsString()));
						Document doc = builder.parse(src);
						String reserved_id = doc.getElementsByTagName("reserved_id").item(0).getTextContent();
						String authentication_key = doc.getElementsByTagName("authentication_key").item(0)
								.getTextContent();
						String error_txt = doc.getElementsByTagName("error_txt").item(0).getTextContent();
						_TransferToApi.setReservedId(reserved_id);
						_TransferToApi.setTransfertToApiResponse(error_txt);
						_TransferToApi.setAuthenticationKey(authentication_key);
						_TransferToApi.setResult("Success!");
					} catch (Exception e) {
						_TransferToApi.setResult("failed!");
						_TransferToApi.setError(e.getMessage());
					}
				} else {
					_TransferToApi.setResult("failed!");
					_TransferToApi.setError("Internal server error, please contact system adminstrator!");
				}
			} else {
				_TransferToApi.setResult("failed!");
				_TransferToApi.setError("Please contact to system adminstrator for trsnaferto api setting enable!");
			}
		} catch (Exception e) {
			_TransferToApi.setResult("failed!");
			_TransferToApi.setError(e.getMessage());
		}
		return _TransferToApi;
	}

	public TransferToApi TransferToTopUp(String MobilNumber, int CompanyId, int CustomerId, String TransactionDetail,
			double sAmount, double Charges, double Fees, double Tax, int SendingCurrencyId, int ReceivingCurrencytId,
			int BeneficiaryId, int PaymentMethodId, int DestinationCountryId, int SourceCountryId, Boolean IsLive,
			String TransferPurpose, double ExchangeRate, String Sender, String CardNumber, String setExpirationDate,
			String cvv,double sFaceAmount) {
		TransferToApi _TransferToApi = new TransferToApi();
		try {
			Connection _Connection = MYSQLConnection.GetConnection();
			MYSQLHelper _MYSQLHelper = new MYSQLHelper();
			ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM transfertoApi where isdeleted=0",
					_Connection);
			if (_ResultSet.next()) {
				
				String DeliveryType = "Mobile Recharge";
				MagicPay _MagicPay = new MagicPay();
				_MagicPay.PaymentMethodId = PaymentMethodId;
				_MagicPay.CompanyId = CompanyId;
				_MagicPay.CustomerId = CustomerId;
				_MagicPay.TransactionDetail = TransactionDetail;
				_MagicPay.SendingAmount = sFaceAmount;
				_MagicPay.Charges = Charges;
				_MagicPay.Tax = Tax;
				_MagicPay.SendingCurrencyId = SendingCurrencyId;
				_MagicPay.ReceivingAmount = sAmount;
				_MagicPay.ReceivingCurrencytId = ReceivingCurrencytId;
				_MagicPay.BeneficiaryId = BeneficiaryId;
				_MagicPay.TransferPurpose = DeliveryType;
				_MagicPay.ExchangeRate = ExchangeRate;
				_MagicPay.DeliveryType = DeliveryType;
				_MagicPay.CardNumber = CardNumber;
				_MagicPay.setExpirationDate = setExpirationDate;
				_MagicPay.cvv = cvv;
				_MagicPay.SenderName = Sender;
				_MagicPay.addMagicPay(_MagicPay);
				if (_MagicPay.Result == "Success") {
					// _AuthrozieTranscation.TransactionId =
					// _MagicPay.TransactionId;
					String dPaymentGatewayTransactionId = _MagicPay.PaymentGatewayTransactionId.toString();

					_TransferToApi.setPaymentGatewayTransactionId(dPaymentGatewayTransactionId);

					int lastid = _MagicPay.TransactionId;

					long unixTime = System.currentTimeMillis() / 1000L;

					String aapiUrl = _ResultSet.getString("api_url");
					String lLogin = _ResultSet.getString("login");
					String tToken = _ResultSet.getString("token");
					String md5_string = getKeyedDigest(lLogin, tToken, unixTime);
					String strSoapAction = aapiUrl;

					String sSmsText = "Mobile Recharge from Sendingloop.com";
					String cid1 = "Sendingloop";
					String sender_sms = "yes";
					String sender_text = sSmsText;
					String return_timestamp = "1";
					String return_version = "1";
					double sreturn_service_fee = Fees;
					String saction = "topup";
					String sRequest = GetRequestTopUp(lLogin, unixTime, md5_string, MobilNumber, sSmsText, sAmount,
							cid1, sender_sms, sender_text, sAmount, return_timestamp, return_version,
							sreturn_service_fee, saction);
					RequestEntity entity = new StringRequestEntity(sRequest);

					PostMethod post = new PostMethod(strSoapAction);
					post.setRequestEntity(entity);
					post.setRequestHeader("Content-Type", "text/xml; StandardCharsets.UTF_8");
					HttpClient httpclient = new HttpClient();
					int resultpay = 0;
					try {
						resultpay = httpclient.executeMethod(post);
					} catch (HttpException e) {
						_TransferToApi.setResult("failed!");
						_TransferToApi.setError(e.getMessage());
					}
					if (resultpay == 200) {
						try {
							

							DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
							InputSource src = new InputSource();
							src.setCharacterStream(new StringReader(post.getResponseBodyAsString()));
							Document doc = builder.parse(src);
							String transactionid = doc.getElementsByTagName("transactionid").item(0).getTextContent();
							String msisdn = doc.getElementsByTagName("msisdn").item(0).getTextContent();

							String country = doc.getElementsByTagName("country").item(0).getTextContent();
							String countryid = doc.getElementsByTagName("countryid").item(0).getTextContent();
							String operator = doc.getElementsByTagName("operator").item(0).getTextContent();

							String destination_currency = doc.getElementsByTagName("destination_currency").item(0)
									.getTextContent();

							String authenticationkey = doc.getElementsByTagName("authentication_key").item(0)
									.getTextContent();
							String error_txt = doc.getElementsByTagName("error_txt").item(0).getTextContent();

							_TransferToApi.setMobileNumber(msisdn);
							_TransferToApi.setTransactionId(lastid);
							_TransferToApi.setCountry(country);
							_TransferToApi.setCountryId(countryid);
							_TransferToApi.setOperator(operator);

							_TransferToApi.setDestinationCurrency(destination_currency);
							_TransferToApi.setAuthenticationKey(authenticationkey);
							_TransferToApi.setTransfertToApiResponse(error_txt);

							_TransferToApi.setResult("Success");
							SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							Calendar cal = Calendar.getInstance();
							String date = format.format(cal.getTime());
							_TransferToApi.setTransactionDate(date);
							// AuthrozieTranscation _AuthrozieTranscation = new
							// AuthrozieTranscation();

							/*
							 * int lastid =
							 * _AuthrozieTranscation.saveDataTranscationDetails(
							 * CompanyId, CustomerId, TransactionDetail,
							 * sAmount, Charges, Fees, Tax,
							 * _TransferToApi.TransactionDate, "Success", "1",
							 * _TransferToApi.TransactionId, SendingCurrencyId,
							 * sAmount, ReceivingCurrencytId, BeneficiaryId,
							 * PaymentMethodId, DestinationCountryId,
							 * SourceCountryId, IsLive, TransferPurpose,
							 * ExchangeRate, DeliveryType,
							 * _TransferToApi.TransactionDate);
							 */
							_TransferToApi.setMobileNumber(MobilNumber);
							_TransferToApi.setAmount(sAmount);
							_TransferToApi.setSender(Sender);
							int iTransferttoTransid = addDataToTransfer(CompanyId, CustomerId, lastid,
									_TransferToApi.Sender, _TransferToApi.MobileNumber, _TransferToApi.Amount,
									transactionid);
							_TransferToApi.setCustomerId(CustomerId);
							_TransferToApi.setCompanyId(CompanyId);
							_TransferToApi.setSender(Sender);
							_TransferToApi.setTransferttoTransid(transactionid);

						} catch (Exception e) {
							_TransferToApi.setResult("failed!");
							_TransferToApi.setError(e.getMessage());
						}
					} else {
						_TransferToApi.setResult("failed!");
						_TransferToApi.setError("Internal server error, please contact system adminstrator!");
					}
				} else {
					_TransferToApi.setResult(_MagicPay.Result);
					_TransferToApi.setError(_MagicPay.Error);

				}

			} else {
				_TransferToApi.setResult("failed!");
				_TransferToApi.setError("Please contact to system adminstrator for trsnaferto api setting enable!");
			}
		} catch (Exception e) {
			_TransferToApi.setResult("failed!");
			_TransferToApi.setError(e.getMessage());
		}

		return _TransferToApi;
	}

	public static String GetRequest(String sLogin, long skey, String smd5, String sdestination_msisdn,
			String sdelivered_amount_info, String sreturn_service_fee, String saction) {
		String sRequest = "";
		sRequest += "<xml>";
		sRequest += "<login>" + sLogin + "</login>";
		sRequest += "<key>" + skey + "</key>";
		sRequest += "<md5>" + smd5 + "</md5>";
		sRequest += "<destination_msisdn>" + sdestination_msisdn + "</destination_msisdn>";
		sRequest += "<delivered_amount_info>" + sdelivered_amount_info + "</delivered_amount_info>";
		sRequest += "<return_service_fee>" + sreturn_service_fee + "</return_service_fee>";
		sRequest += "<action>" + saction + "</action>";
		sRequest += "</xml>";
		return sRequest;

	}

	public static String GetRequestReserverId(String sLogin, long skey, String smd5, String saction) {
		String sRequest = "";
		sRequest += "<xml>";
		sRequest += "<login>" + sLogin + "</login>";
		sRequest += "<key>" + skey + "</key>";
		sRequest += "<md5>" + smd5 + "</md5>";
		sRequest += "<action>" + saction + "</action>";
		sRequest += "</xml>";
		return sRequest;

	}

	public static String GetRequestTopUp(String sLogin, long skey, String smd5, String sdestination_msisdn,
			String sSmsText, Double product, String cid1, String sender_sms, String sender_text,
			Double sdelivered_amount_info, String return_timestamp, String return_version, Double sreturn_service_fee,
			String saction) {
		String sRequest = "";
		sRequest += "<xml>";
		sRequest += "<login>" + sLogin + "</login>";
		sRequest += "<key>" + skey + "</key>";
		sRequest += "<md5>" + smd5 + "</md5>";
		sRequest += "<msisdn>" + sdestination_msisdn + "</msisdn>";
		sRequest += "<sms>" + sSmsText + "</sms>";
		sRequest += "<destination_msisdn>" + sdestination_msisdn + "</destination_msisdn>";
		sRequest += "<product>" + product + "</product>";
		sRequest += "<cid1>" + cid1 + "</cid1>";
		sRequest += "<sender_sms>" + sender_sms + "</sender_sms>";
		sRequest += "<sender_text>" + sender_text + "</sender_text>";
		sRequest += "<delivered_amount_info>" + sdelivered_amount_info + "</delivered_amount_info>";
		sRequest += "<return_timestamp>" + return_timestamp + "</return_timestamp>";
		sRequest += "<return_version>" + return_version + "</return_version>";
		sRequest += "<return_service_fee>" + sreturn_service_fee + "</return_service_fee>";
		sRequest += "<action>" + saction + "</action>";
		sRequest += "</xml>";
		return sRequest;

	}

	public static String getKeyedDigest(String login, String token, long key) {
		try {
			String temp = login + token + key;
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] bytes = md5.digest(temp.getBytes());
			return byteToHex(bytes);
		} catch (Exception ex) {
			System.out.println("oops");
		}
		return null;
	}

	public static String byteToHex(byte[] bits) {
		if (bits == null) {
			return null;
		}
		StringBuffer hex = new StringBuffer(bits.length * 2);
		for (int i = 0; i < bits.length; i++) {
			if (((int) bits[i] & 0xff) < 0x10) {
				hex.append("0");
			}
			hex.append(Integer.toString((int) bits[i] & 0xff, 16));
		}
		return hex.toString();

	}

	public int addDataToTransfer(int companyid, int customerid, int transactionId, String senderName,
			String mobileNumber, double amount, String paymentGatewaytransactionid) {
		TransferToApi _TransferToApi = new TransferToApi();
		int ResultId = 0;
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		try {
			Connection _Connection = MYSQLConnection.GetConnection();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			String date = format.format(cal.getTime());
			_TransferToApi.setTransactionDate(date);
			if (_Connection != null) {
				PreparedStatement _PreparedStatement = null;
				String sInsertStatement = "INSERT INTO transfertotransactiondetails( companyid, customerid, transactionId,senderName,mobileNumber,amount,paymentGatewaytransactionid, transactionDate)";
				sInsertStatement = sInsertStatement + " VALUES(?, ?, ?,?, ?, ?,?, ?)";
				_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
				_PreparedStatement.setInt(1, companyid);
				_PreparedStatement.setInt(2, customerid);
				_PreparedStatement.setInt(3, transactionId);
				_PreparedStatement.setString(4, senderName);
				_PreparedStatement.setString(5, mobileNumber);
				_PreparedStatement.setDouble(6, amount);
				_PreparedStatement.setString(7, paymentGatewaytransactionid);
				_PreparedStatement.setString(8, _TransferToApi.TransactionDate);
				_PreparedStatement.executeUpdate();
				ResultSet _ResultSetld = _MYSQLHelper.GetResultSet(
						"SELECT MAX(transferttotransid) AS transferttotransid FROM transfertotransactiondetails",
						_Connection);
				if (_ResultSetld.next()) {
					int lastid = _ResultSetld.getInt("transferttotransid");
					ResultId = lastid;
				}

			}

			else {

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ResultId;
	}
}
