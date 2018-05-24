package com.etl.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class minepay {
	public Object TransactionId;
	public String CardNumber;
	public String cvv;
	public String exp;
	public String Result;
	public String Error;

	private void setCardNumber(String CardNumber) {
		this.CardNumber = CardNumber;
	}

	private String getCardNumber() {
		return CardNumber;
	}
	private void setTransactionId(Object TransactionId) {
		this.TransactionId = TransactionId;
	}

	private Object getTransactionId() {
		return TransactionId;
	}

	private void setcvv(String cvv) {
		this.cvv = cvv;
	}

	private String getcvv() {
		return cvv;
	}

	private void setexp(String exp) {
		this.exp = exp;
	}

	private String getexp() {
		return exp;
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

	String server = "secure.magicpaygateway.com";
	String port = "443";
	String path = "https://secure.magicpaygateway.com/api/transact.php";
	String username = "falconengineer";
	String password = "falcon@999";

	String firstname = "ishu";
	String lastname = "kumar";
	String address1 = "rajouri.";
	String city = "delhi";
	String state = "Delhi";
	String zip = "110027";

	public minepay addpay(String ccNumber, String ccExp, String cvv) {
		minepay _minepay = new minepay();
		try {
			HashMap retval = new HashMap();
			retval=	doSale(1, ccNumber, ccExp, cvv, address1, city, state, zip, "USA", firstname, lastname,server, port,
					username, password, path);
			System.out.println("Success\nTransId: " + retval.get("transactionid") + "\n");
			_minepay.setResult("Success");
			_minepay.setTransactionId(retval.get("transactionid"));
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			_minepay.setResult("failed");
			_minepay.setError(e.getMessage());
		}
		return _minepay;
	}

	public HashMap doSale(double amount, String ccNumber, String ccExp, String cvv, String address1, String city,
			String state, String zip, String country, String firstname, String lastname,String server, String port,
			String username, String password, String path) throws Exception {
		HashMap result = new HashMap();
		HashMap request = new HashMap();

		DecimalFormat form = new DecimalFormat("#.00");

		request.put("amount", form.format(amount));
		request.put("type", "sale");
		request.put("ccnumber", ccNumber);
		request.put("ccexp", ccExp);
		request.put("cvv", cvv);
		request.put("address1", address1);
		request.put("city", city);
		request.put("state", state);
		request.put("zip", zip);
		request.put("country", country);
		request.put("firstname", firstname);
		request.put("lastname", lastname);
		String data_out = prepareRequest(request);

		String error = "";
		String data_in = "";
		boolean success = true;
		try {
			HashMap retval = postForm(data_out);
			data_in = (String) retval.get("response");
			result.put("transactionid", retval.get("transactionid"));
		} catch (IOException e) {
			success = false;
			error = "Connect error, " + e.getMessage();
		} catch (Exception e) {
			success = false;
			error = e.getMessage();
			System.out.println("response: " + e);
		}
		if (!success) {
			throw new Exception(error);

		}

		return result;
	}

	public String prepareRequest(HashMap request) {

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

	protected HashMap postForm(String data) throws Exception {

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
			System.out.println("response: " + inputLine);
		}
		in.close();

		String response = buffer.toString();
		System.out.println("my response: " + response);
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
