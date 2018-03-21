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

public class MagicPay {

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
	
	
	public MagicPay addMagicPay(MagicPay __MagicPay) {
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

										__MagicPay.setPaymentGatewayTransactionId(retval.get("transactionid"));
										__MagicPay.setResult("Success");
										__MagicPay.setStatus("Success");
										__MagicPay.setIsLive(false);
										__MagicPay.setPaymentGatewayResponse("1");

										AuthrozieTranscation _AuthrozieTranscation = new AuthrozieTranscation();

										int lastid = _AuthrozieTranscation.saveDataTranscationDetails(
												__MagicPay.CompanyId, __MagicPay.CustomerId, __MagicPay.SenderName,
												__MagicPay.SendingAmount, __MagicPay.Charges, __MagicPay.Fees, __MagicPay.Tax,
												__MagicPay.CreatedDate, __MagicPay.Status,
												__MagicPay.PaymentGatewayResponse,
												__MagicPay.PaymentGatewayTransactionId.toString(),
												__MagicPay.SendingCurrencyId, __MagicPay.ReceivingAmount,
												__MagicPay.ReceivingCurrencytId, __MagicPay.BeneficiaryId,
												__MagicPay.PaymentMethodId, __MagicPay.DestinationCountryId,
												__MagicPay.SourceCountryId, __MagicPay.IsLive,
												__MagicPay.TransferPurpose, __MagicPay.ExchangeRate,
												__MagicPay.DeliveryType, __MagicPay.CreatedDate);
										__MagicPay.setTransactionId(lastid);

										__MagicPay.addMagicPayDetails(__MagicPay.CompanyId, __MagicPay.CustomerId,
												__MagicPay.TransactionId, __MagicPay.PaymentGatewayTransactionId,
												__MagicPay.SenderName, __MagicPay.SendingAmount,__MagicPay.TransactionDetail, __MagicPay.CreatedDate,
												__MagicPay.Status);
										__MagicPay.setserver("");
										__MagicPay.setport("");
										__MagicPay.setusername("");
										__MagicPay.setpassword("");
										__MagicPay.setpath("");
										//clear(__MagicPay);
									} else {
										// System.out.println("Null Response.");
										__MagicPay.setResult("failed");
										__MagicPay.setError("Invalid Destination Country Id!");
										clear(__MagicPay);
									}

								} else {
									// System.out.println("Null Response.");
									__MagicPay.setResult("failed");
									__MagicPay.setError("Invalid Source Country Id!");
									clear(__MagicPay);
								}

							}

							else {
								__MagicPay.setResult("Failed");
								__MagicPay.setError("Invalid Payment Setting Id!");
								clear(__MagicPay);
							}

						} else {
							__MagicPay.setResult("Failed");
							__MagicPay.setError("Invalid Payment Method Id!");
							clear(__MagicPay);
						}
					} else {
						__MagicPay.setResult("Failed");
						__MagicPay.setError("Invalid Customer Id!");
						clear(__MagicPay);
					}
				} else {
					__MagicPay.setResult("Failed");
					__MagicPay.setError("Invalid Company Id!");
					clear(__MagicPay);
				}

			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				__MagicPay.setResult("Failed");
				__MagicPay.setError(e.getMessage());
				clear(__MagicPay);
			}
		}

		return __MagicPay;

	}

	public HashMap paymentProcess(double amount, String ccNumber, String ccExp, String cvv, String server, String port,
			String username, String password, String path) throws Exception {
		HashMap result = new HashMap();
		HashMap request = new HashMap();

		DecimalFormat form = new DecimalFormat("#.00");

		request.put("amount", form.format(amount));
		request.put("type", "sale");
		request.put("ccnumber", ccNumber);
		request.put("ccexp", ccExp);
		request.put("cvv", cvv);
		String data_out = prepareRequest(request, username, password);

		String error = "";
		String data_in = "";
		boolean success = true;
		try {
			HashMap retval = postRequestForm(data_out, server, port, path);
			data_in = (String) retval.get("response");
			result.put("transactionid", retval.get("transactionid"));
		} catch (Exception ex) {
			success = false;
			error = ex.getMessage();

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

	public void addMagicPayDetails(int CompanyId, int CustomerId, int TransactionId, Object PaymentGatewayTransactionId,
			String SenderName, double Amount,String TransactionDetail, String CreatedDate, String Status) {
		Connection _Connection = MYSQLConnection.GetConnection();
		PreparedStatement _PreparedStatement = null;
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		try {
			
			DecimalFormat _decimalFormat = new DecimalFormat("##.00");
			String _Amountformate = _decimalFormat.format(Amount);
			double _Amount = (Double)_decimalFormat.parse(_Amountformate) ;
			
			
			String sInsertStatementMagicTranscation = "INSERT INTO magicpaydetails( CompanyId, CustomerId, TransactionId,PaymentGatewayTransactionId,SenderName,Amount,TransactionDetail,TransactionDate,ResponseCode)";
			sInsertStatementMagicTranscation = sInsertStatementMagicTranscation + " VALUES(?, ?, ?,?, ?, ?,?,?,?)";

			_PreparedStatement = _Connection.prepareStatement(sInsertStatementMagicTranscation);
			_PreparedStatement.setInt(1, CompanyId);
			_PreparedStatement.setInt(2, CustomerId);
			_PreparedStatement.setInt(3, TransactionId);
			_PreparedStatement.setObject(4, PaymentGatewayTransactionId);
			_PreparedStatement.setString(5, SenderName);
			_PreparedStatement.setDouble(6, _Amount);
			_PreparedStatement.setString(7, TransactionDetail);
			_PreparedStatement.setString(8, CreatedDate);
			_PreparedStatement.setString(9, Status);
			_PreparedStatement.executeUpdate();
		} catch (Exception e) {

		}

	}

	public static ArrayList<MagicPay> getMagicPayDetails(int CustomerId) {
		Connection _Connection = MYSQLConnection.GetConnection();
		ArrayList<MagicPay> _MagicPayDetaillist = new ArrayList<MagicPay>();
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		try {
			if (_Connection != null) {

				ResultSet _ResultSet = _MYSQLHelper.GetResultSet(
						"SELECT * FROM magicpaydetails where CustomerId='" + CustomerId + "'", _Connection);

				while (_ResultSet.next()) {
					MagicPay _MagicPay = new MagicPay();
					Object dd = _ResultSet.getString("PaymentGatewayTransactionId");
					_MagicPay.setMagicPayId(_ResultSet.getInt("MagicPayId"));
					_MagicPay.setCompanyId(_ResultSet.getInt("CompanyId"));
					_MagicPay.setCustomerId(_ResultSet.getInt("CustomerId"));
					_MagicPay.setTransactionId(_ResultSet.getInt("TransactionId"));
					_MagicPay.setPaymentGatewayTransactionId(dd.toString());
					_MagicPay.setSenderName(_ResultSet.getString("SenderName"));					
					_MagicPay.setSendingAmount(_ResultSet.getDouble("Amount"));
					_MagicPay.setTransactionDetail(_ResultSet.getString("TransactionDetail"));
					_MagicPay.setCreatedDate(_ResultSet.getString("TransactionDate"));
					_MagicPay.setStatus(_ResultSet.getString("ResponseCode"));
					_MagicPay.setResult("Success");
					_MagicPayDetaillist.add(_MagicPay);
				}
				_ResultSet.close();
			}

		} catch (Exception ex) {

		} finally {

			if (_Connection != null) {
				try {
					_Connection.close();
				} catch (SQLException e) {

				}
			}
		}

		return _MagicPayDetaillist;
	}

	public static ArrayList<MagicPay> getMagicPayDetailsByCompanyId(int CompanyId) {
		Connection _Connection = MYSQLConnection.GetConnection();
		ArrayList<MagicPay> _MagicPayDetaillist = new ArrayList<MagicPay>();
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		try {
			if (_Connection != null) {

				ResultSet _ResultSet = _MYSQLHelper
						.GetResultSet("SELECT * FROM magicpaydetails where CompanyId='" + CompanyId + "'", _Connection);

				while (_ResultSet.next()) {
					MagicPay _MagicPay = new MagicPay();
					Object dd = _ResultSet.getString("PaymentGatewayTransactionId");
					_MagicPay.setMagicPayId(_ResultSet.getInt("MagicPayId"));
					_MagicPay.setCompanyId(_ResultSet.getInt("CompanyId"));
					_MagicPay.setCustomerId(_ResultSet.getInt("CustomerId"));
					_MagicPay.setTransactionId(_ResultSet.getInt("TransactionId"));
					_MagicPay.setPaymentGatewayTransactionId(dd.toString());
					_MagicPay.setSenderName(_ResultSet.getString("SenderName"));
					_MagicPay.setSendingAmount(_ResultSet.getDouble("Amount"));
					_MagicPay.setTransactionDetail(_ResultSet.getString("TransactionDetail"));
					_MagicPay.setCreatedDate(_ResultSet.getString("TransactionDate"));
					_MagicPay.setStatus(_ResultSet.getString("ResponseCode"));
					_MagicPay.setResult("Success");
					_MagicPayDetaillist.add(_MagicPay);
				}
				_ResultSet.close();
			}

		} catch (Exception ex) {

		} finally {

			if (_Connection != null) {
				try {
					_Connection.close();
				} catch (SQLException e) {

				}
			}
		}

		return _MagicPayDetaillist;
	}

	public MagicPay clear(MagicPay _MagicPay) {
		_MagicPay.setSendingAmount(0);
		_MagicPay.setCardNumber("");
		_MagicPay.setExpirationDate("");
		_MagicPay.setcvv("");
		_MagicPay.setTransactionDetail("");
		_MagicPay.setPaymentMethodId(0);
		_MagicPay.setpassword("");
		_MagicPay.setusername("");
		_MagicPay.setpath("");
		_MagicPay.setserver("");
		_MagicPay.setport("");
		_MagicPay.setSenderName("");
		_MagicPay.setCompanyId(0);
		_MagicPay.setCustomerId(0);

		return _MagicPay;

	}

}
