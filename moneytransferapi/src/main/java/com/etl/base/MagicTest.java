package com.etl.base;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import com.etl.util.MYSQLConnection;
import com.etl.util.MYSQLHelper;

public class MagicTest {
	public int TransactionId;
	public Object PaymentGatewayTransactionId;
	public int MagicPayId;
	public int CompanyId;
	public int CustomerId;
	public String SenderName;
	public boolean IsLive;	
	public String Server;
	public String Port;
	public String Path;
	public String Username;
	public String Password;
	public String TransactionDetail;
	public double Charges;
	public double Fees;
	public double Tax;
	public int SendingCurrencyId;
	public double ReceivingAmount;
	public int ReceivingCurrencytId;
	public int BeneficiaryId;
	public int SourceCountryId;
	public int DestinationCountryId;
	public String TransferPurpose;
	public double ExchangeRate;
	public String DeliveryType;
	public String PaymentGatewayResponse;
	public double SendingAmount;
	public String CardNumber;
	public String setExpirationDate;
	public String cvv;
	public String CreatedDate;
	public int PaymentMethodId;
	public String Status;
	public String Result;
	public String Error;

	private void setTransactionId(int TransactionId) {
		this.TransactionId = TransactionId;
	}

	private int getTransactionId() {
		return TransactionId;
	}

	private void setMagicPayId(int MagicPayId) {
		this.MagicPayId = MagicPayId;
	}

	private int getMagicPayId() {
		return MagicPayId;
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

	private void setserver(String Server) {
		this.Server = Server;
	}

	private String getserver() {
		return Server;
	}

	private void setport(String Port) {
		this.Port = Port;
	}

	private String getport() {
		return Port;
	}
	
	
	private void setpath(String Path) {
		this.Path = Path;
	}

	private String getpath() {
		return Path;
	}

	private void setusername(String Username) {
		this.Username = Username;
	}

	private String getusername() {
		return Username;
	}

	private void setpassword(String Password) {
		this.Password = Password;
	}

	private String getpassword() {
		return Password;
	}

	private void setPaymentGatewayTransactionId(Object PaymentGatewayTransactionId) {
		this.PaymentGatewayTransactionId = PaymentGatewayTransactionId;
	}

	private Object getPaymentGatewayTransactionId() {
		return PaymentGatewayTransactionId;
	}

	private void setSendingAmount(double SendingAmount) {
		this.SendingAmount = SendingAmount;
	}

	private double getSendingAmount() {
		return SendingAmount;
	}

	private void setCreatedDate(String CreatedDate) {
		this.CreatedDate = CreatedDate;
	}

	private String getCreatedDate() {
		return CreatedDate;
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

	private void setResult(String Result) {
		this.Result = Result;
	}

	private String getResult() {
		return Result;
	}

	private void setStatus(String Status) {
		this.Status = Status;
	}

	private String getStatus() {
		return Status;
	}

	private void setError(String Error) {
		this.Error = Error;
	}

	private String getError() {
		return Error;
	}

	private void setPaymentMethodId(int PaymentMethodId) {
		this.PaymentMethodId = PaymentMethodId;
	}

	private int getPaymentMethodId() {
		return PaymentMethodId;
	}

	private void setCharges(double Charges) {
		this.Charges = Charges;
	}

	private double getCharges() {
		return Charges;
	}

	private void setFees(double Fees) {
		this.Fees = Fees;
	}

	private double getFees() {
		return Fees;
	}

	private void setTax(double Tax) {
		this.Tax = Tax;
	}

	private double getTax() {
		return Tax;
	}

	private void setSendingCurrencyId(int SendingCurrencyId) {
		this.SendingCurrencyId = SendingCurrencyId;
	}

	private int getSendingCurrencyId() {
		return SendingCurrencyId;
	}

	private void setReceivingCurrencytId(int ReceivingCurrencytId) {
		this.ReceivingCurrencytId = ReceivingCurrencytId;
	}

	private int getReceivingCurrencytId() {
		return ReceivingCurrencytId;
	}

	private void setBeneficiaryId(int BeneficiaryId) {
		this.BeneficiaryId = BeneficiaryId;
	}

	private int getBeneficiaryId() {
		return BeneficiaryId;
	}

	private void setSourceCountryId(int SourceCountryId) {
		this.SourceCountryId = SourceCountryId;
	}

	private int getSourceCountryId() {
		return SourceCountryId;
	}

	private void setDestinationCountryId(int DestinationCountryId) {
		this.DestinationCountryId = DestinationCountryId;
	}

	private int getDestinationCountryId() {
		return DestinationCountryId;
	}

	private void setTransferPurpose(String TransferPurpose) {
		this.TransferPurpose = TransferPurpose;
	}

	private String getTransferPurpose() {
		return TransferPurpose;
	}

	private void setExchangeRate(double ExchangeRate) {
		this.ExchangeRate = ExchangeRate;
	}

	private double getExchangeRate() {
		return ExchangeRate;
	}

	private void setDeliveryType(String DeliveryType) {
		this.DeliveryType = DeliveryType;
	}

	private String getDeliveryType() {
		return DeliveryType;
	}

	private void setPaymentGatewayResponse(String PaymentGatewayResponse) {
		this.PaymentGatewayResponse = PaymentGatewayResponse;
	}

	private String getPaymentGatewayResponse() {
		return PaymentGatewayResponse;
	}

	
	private void setTransactionDetail(String TransactionDetail) {
		this.TransactionDetail = TransactionDetail;
	}

	private String getTransactionDetail() {
		return TransactionDetail;
	}
	
	
	
	
	
	public MagicTest atest(MagicTest __MagicPay) {
		HashMap retval = new HashMap();
		Connection _Connection = MYSQLConnection.GetConnection();
		PreparedStatement _PreparedStatement = null;
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		if (_Connection != null) {
			try {
				// retval = __MagicPay.doSale(10.30,
				// "6011111111111117","0130","852");

				ResultSet _ResultSetcompany = _MYSQLHelper.GetResultSet(
						"SELECT * FROM company where Company_Id='" + __MagicPay.CompanyId + "'", _Connection);
				if (_ResultSetcompany.next()) {
					ResultSet _ResultSetcustomer = _MYSQLHelper.GetResultSet(
							"SELECT * FROM customer where customer_Id='" + __MagicPay.CustomerId + "'", _Connection);
					if (_ResultSetcustomer.next()) {
						ResultSet _ResultSet = _MYSQLHelper
								.GetResultSet("SELECT PaymentMethodId FROM paymentmethod where PaymentMethodId='"
										+ __MagicPay.PaymentMethodId + "'", _Connection);
						if (_ResultSet.next()) {
							ResultSet _ResultSetPaymentSettingDetails = _MYSQLHelper
									.GetResultSet("SELECT * FROM authorizepaymentsettings where PaymentMethodId='"
											+ __MagicPay.PaymentMethodId + "'", _Connection);
							if (_ResultSetPaymentSettingDetails.next()) {

								ResultSet _ResultSetSourceCountry = _MYSQLHelper
										.GetResultSet("SELECT * FROM currency where CurrencyId='"
												+ __MagicPay.SendingCurrencyId + "'", _Connection);
								if (_ResultSetSourceCountry.next()) {

									int SourceCountryId = (_ResultSetSourceCountry.getInt("country_id"));
									__MagicPay.setSourceCountryId(SourceCountryId);

									ResultSet _ResultSetDestinationCountry = _MYSQLHelper
											.GetResultSet("SELECT * FROM currency where CurrencyId='"
													+ __MagicPay.ReceivingCurrencytId + "'", _Connection);
									if (_ResultSetDestinationCountry.next()) {
										int DestinationCountryId = (_ResultSetDestinationCountry.getInt("country_id"));
										__MagicPay.setDestinationCountryId(DestinationCountryId);

										SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
										Calendar cal = Calendar.getInstance();
										String date = format.format(cal.getTime());
										__MagicPay.setCreatedDate(date);
										__MagicPay.setserver(_ResultSetPaymentSettingDetails.getString("Server"));
										__MagicPay.setport(_ResultSetPaymentSettingDetails.getString("Port"));
										__MagicPay.setusername(
												_ResultSetPaymentSettingDetails.getString("MerchantLoginId"));
										__MagicPay.setpassword(
												_ResultSetPaymentSettingDetails.getString("MerchantTransactionKey"));
										__MagicPay.setpath(_ResultSetPaymentSettingDetails.getString("PaymentUrl"));
										retval = __MagicPay.paymentProcess(__MagicPay.SendingAmount, __MagicPay.CardNumber,
												__MagicPay.setExpirationDate, __MagicPay.cvv, __MagicPay.Server,
												__MagicPay.Port, __MagicPay.Username, __MagicPay.Password,
												__MagicPay.Path);
										System.out.println("Success\nTransId: " + retval.get("transactionid") + "\n");

										
										
										
									} else {
										// System.out.println("Null Response.");
										__MagicPay.setResult("failed");
										__MagicPay.setError("Invalid Destination Country Id!");
										
									}

								} else {
									// System.out.println("Null Response.");
									__MagicPay.setResult("failed");
									__MagicPay.setError("Invalid Source Country Id!");
									
								}

							}

							else {
								__MagicPay.setResult("Failed");
								__MagicPay.setError("Invalid Payment Setting Id!");
								
							}

						} else {
							__MagicPay.setResult("Failed");
							__MagicPay.setError("Invalid Payment Method Id!");
							
						}
					} else {
						__MagicPay.setResult("Failed");
						__MagicPay.setError("Invalid Customer Id!");
					}
				} else {
					__MagicPay.setResult("Failed");
					__MagicPay.setError("Invalid Company Id!");
				
				}

			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				__MagicPay.setResult("Failed");
				__MagicPay.setError(e.getMessage());
				
			}
		}

		return __MagicPay;

	}

	public HashMap paymentProcess(double amount, String ccNumber, String ccExp, String cvv, String server, String port,
			String username, String password, String path) throws Exception {
		HashMap result = new HashMap();
		HashMap request = new HashMap();
		MagicTest __MagicPay=new MagicTest();
		DecimalFormat form = new DecimalFormat("#.00");

		request.put("amount", form.format(amount));
		request.put("Action", "add");
		request.put("ccnumber", ccNumber);
		request.put("ccexp", ccExp);
		request.put("cvv", cvv);
		request.put("firstname", "ishu");
		String data_out = prepareRequest(request, username, password);

		String error = "";
		String data_in = "";
		boolean success = true;
		try {
			path="https://secure.magicpaygateway.com/merchants/customervault.php";
			HashMap retval = postRequestForm(data_out, server, port, path);
			data_in = (String) retval.get("response");
			System.out.println("Success\nTransId: " + retval.get("customer_vault_id") + "\n");
			result.put("customer_vault_id", retval.get("customer_vault_id"));
			__MagicPay.setPaymentGatewayTransactionId(retval.get("customer_vault_id"));
			__MagicPay.setResult("Success");
		} catch (Exception ex) {
			success = false;
			error = ex.getMessage();
			 System.out.println("Error: " + ex.getMessage());
			 __MagicPay.setError(ex.getMessage());
		}
		if (!success) {
			throw new Exception(error);
		}

		return result;
	}

	public MagicTest voidtt(MagicTest __MagicPay) {
		String server = "secure.magicpaygateway.com";
		String port = "443";
		String path = "https://secure.magicpaygateway.com/api/transact.php";
		String username = "falconengineer";
		String password = "falcon@999";
		HashMap retval = new HashMap();
		try{
		retval = __MagicPay.voidpaymentProcess(__MagicPay.PaymentGatewayTransactionId, __MagicPay.ReceivingAmount, server, port, username, password, path);
		System.out.println("Success\nTransId: " + retval.get("transactionid") + "\n");
		System.out.println("Success\nTransIdResponse: " + retval.get("responsetext") + "\n");
		}
		catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		}
		return __MagicPay;
	}
	
	
	
	
	
	public HashMap voidpaymentProcess(Object transactionid,double amount, String server, String port,
			String username, String password, String path) throws Exception {
		HashMap result = new HashMap();
		HashMap request = new HashMap();
		MagicTest __MagicPay=new MagicTest();
		DecimalFormat form = new DecimalFormat("#.00");

		request.put("amount", form.format(amount));
		request.put("type", "refund");			
		request.put("transactionid", transactionid);
		String data_out = prepareRequest(request, username, password);

		String error = "";
		String data_in = "";
		boolean success = true;
		try {
			//path="https://secure.magicpaygateway.com/merchants/customervault.php";
			HashMap retval = postRequestForm(data_out, server, port, path);
			data_in = (String) retval.get("response");
			System.out.println("Success\nTransId: " + retval.get("customer_vault_id") + "\n");
			result.put("customer_vault_id", retval.get("customer_vault_id"));
			__MagicPay.setPaymentGatewayTransactionId(retval.get("customer_vault_id"));
			__MagicPay.setResult("Success");
		} catch (Exception ex) {
			success = false;
			error = ex.getMessage();
			 System.out.println("Error: " + ex.getMessage());
			 __MagicPay.setError(ex.getMessage());
		}
		if (!success) {
			throw new Exception(error);
		}

		return result;
	}
	public String prepareRequest(HashMap request, String username, String password) {

		// server = "secure.magicpaygateway.com";
		// port = "443";
		// path = "https://secure.magicpaygateway.com/api/transact.php";
		// username = "magicpay";
		// password = "magicpay123";

		if (request.size() == 0) {
			return "";
		}

		request.put("username", username);
		request.put("password", password);

		Set s = request.keySet();
		Iterator i = s.iterator();
		Object key = i.next();
		StringBuffer buffer = new StringBuffer();

		buffer.append(key).append("=").append(URLEncoder.encode((String) request.get(key)));

		while (i.hasNext()) {
			key = i.next();
			buffer.append("&").append(key).append("=").append(URLEncoder.encode((String) request.get(key)));
		}

		return buffer.toString();

	}

	protected HashMap postRequestForm(String data, String server, String port, String path) throws Exception {

		HashMap result = new HashMap();

		HttpURLConnection postConn;

		HostnameVerifier hv = new HostnameVerifier() {
			public boolean verify(String urlHostName, SSLSession session) {
				return true;
			}
		};

		HttpsURLConnection.setDefaultHostnameVerifier(hv);

		URL post = new URL("https", server, Integer.parseInt(port), path);
		postConn = (HttpURLConnection) post.openConnection();

		postConn.setRequestMethod("POST");
		postConn.setDoOutput(true);

		PrintWriter out = new PrintWriter(postConn.getOutputStream());
		out.print(data);
		out.close();

		BufferedReader in = new BufferedReader(new InputStreamReader(postConn.getInputStream()));

		String inputLine;
		StringBuffer buffer = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			buffer.append(inputLine);
		}
		in.close();

		String response = buffer.toString();

		result.put("response", response);

		// Parse Result
		StringTokenizer st = new StringTokenizer(response, "&");
		while (st.hasMoreTokens()) {
			String varString = st.nextToken();
			StringTokenizer varSt = new StringTokenizer(varString, "=");
			if (varSt.countTokens() > 2 || varSt.countTokens() < 1) {
				throw new Exception("Bad variable from processor center: " + varString);
			}
			if (varSt.countTokens() == 1) {
				result.put(varSt.nextToken(), "");
			} else {
				result.put(varSt.nextToken(), varSt.nextToken());
			}
		}

		if (result.get("response") == "") {
			throw new Exception("Bad response from processor center" + response);
		}

		if (!result.get("response").toString().equals("1")) {
			throw new Exception(result.get("responsetext").toString());

		}

		return result;
	}

	
}
