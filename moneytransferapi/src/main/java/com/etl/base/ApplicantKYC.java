package com.etl.base;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.imageio.ImageIO;

import org.apache.commons.httpclient.HttpVersion;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.etl.util.MYSQLConnection;
import com.etl.util.MYSQLHelper;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;



public class ApplicantKYC {
	public int CustomerApplicantKYCId;
	public int CustomerId;
	public int CompanyId;
	public String ApplicantId;
	public String Phone;
	public String Title;
	public String FirstName;
	public String LastName;
	public String Gender;
	public String DOB;
	public String Country;
	public String FlatNumber;
	public String BuildingName;
	public String BuildingNumber;
	public String Street;
	public String SubStreet;
	public String State;
	public String Town;
	public String PostalCode;

	public boolean IsDocumentUpload;
	public String CreatedDate;
	public String Result;
	public String Error;
	public String id;

	private void setCustomerApplicantKYCId(int CustomerApplicantKYCId) {
		this.CustomerApplicantKYCId = CustomerApplicantKYCId;
	}

	private int getCustomerApplicantKYCId() {
		return CustomerApplicantKYCId;
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

	private void setApplicantId(String ApplicantId) {
		this.ApplicantId = ApplicantId;
	}

	private String getApplicantId() {
		return ApplicantId;
	}

	private void setPhone(String Phone) {
		this.Phone = Phone;
	}

	private String getPhone() {
		return Phone;
	}

	private void setIsDocumentUpload(Boolean IsDocumentUpload) {
		this.IsDocumentUpload = IsDocumentUpload;
	}

	private Boolean getIsDocumentUpload() {
		return IsDocumentUpload;
	}

	private void setCreatedDate(String CreatedDate) {
		this.CreatedDate = CreatedDate;
	}

	private String getCreatedDate() {
		return CreatedDate;
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

	private void setTitle(String Title) {
		this.Title = Title;
	}

	private String getTitle() {
		return Title;
	}

	private void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	private String getFirstName() {
		return FirstName;
	}

	private void setLastName(String LastName) {
		this.LastName = LastName;
	}

	private String getLastName() {
		return LastName;
	}

	private void setGender(String Gender) {
		this.Gender = Gender;
	}

	private String getGender() {
		return Gender;
	}

	private void setDOB(String DOB) {
		this.DOB = DOB;
	}

	private String getDOB() {
		return DOB;
	}

	private void setCountry(String Country) {
		this.Country = Country;
	}

	private String getCountry() {
		return Country;
	}

	private void setFlatNumber(String FlatNumber) {
		this.FlatNumber = FlatNumber;
	}

	private String getFlatNumber() {
		return FlatNumber;
	}

	private void setBuildingName(String BuildingName) {
		this.BuildingName = BuildingName;
	}

	private String getBuildingName() {
		return BuildingName;
	}

	private void setBuildingNumber(String BuildingNumber) {
		this.BuildingNumber = BuildingNumber;
	}

	private String getBuildingNumber() {
		return BuildingNumber;
	}

	private void setStreet(String Street) {
		this.Street = Street;
	}

	private String getStreet() {
		return Street;
	}

	private void setSubStreet(String SubStreet) {
		this.SubStreet = SubStreet;
	}

	private String getSubStreet() {
		return SubStreet;
	}

	private void setState(String State) {
		this.State = State;
	}

	private String getState() {
		return State;
	}

	private void setTown(String Town) {
		this.Town = Town;
	}

	private String getTown() {
		return Town;
	}

	private void setPostalCode(String PostalCode) {
		this.PostalCode = PostalCode;
	}

	private String getPostalCode() {
		return PostalCode;
	}

	private void setid(String id) {
		this.id = id;
	}

	private String getid() {
		return id;
	}

	public ApplicantKYC addApplicantKYC(int CustomerId, int CompanyId, String Title, String FirstName, String LastName,
			String Gender, String DOB, String Country, String FlatNumber, String BuildingName, String BuildingNumber,
			String Street, String State, String Town, String PostalCode, String phone) {

		ApplicantKYC _ApplicantKYC = new ApplicantKYC();
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		Connection _Connection = MYSQLConnection.GetConnection();
		PreparedStatement _PreparedStatement = null;
		try {
			if (_Connection != null) {

				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				String date = format.format(cal.getTime());
				_ApplicantKYC.setCreatedDate(date);
				ResultSet _ResultSetCompany = _MYSQLHelper.GetResultSet(
						"SELECT * FROM customer_applicant_kyc where CustomerId='" + CustomerId + "'", _Connection);
				if (!_ResultSetCompany.next()) {

					String payload = "{\r\n  \r\n  \"title\":\"" + Title + "\",\r\n  \"first_name\": \"" + FirstName
							+ "\",\r\n  \"last_name\": \"" + LastName + "\",\r\n  \"gender\": \"" + Gender
							+ "\",\r\n  \"dob\": \"" + DOB + "\",\r\n  \"country\": \"" + Country
							+ "\",\r\n  \"addresses\": [\r\n    {\r\n      \"flat_number\": \"" + FlatNumber
							+ "\",\r\n      \"mobile\": \"" + phone + "\",\r\n      \"building_name\": \""
							+ BuildingName + "\",\r\n      \"building_number\": \"" + BuildingNumber
							+ "\",\r\n      \"street\": \"" + Street
							+ "\",\r\n      \"sub_street\": null,\r\n  \"state\":\"" + State
							+ "\",\r\n      \"town\": \"" + Town + "\",\r\n      \"postcode\": \"" + PostalCode
							+ "\",\r\n      \"country\": \"" + Country + "\",\r\n      \"start_date\":\""
							+ _ApplicantKYC.CreatedDate + "\",\r\n      \"end_date\": null\r\n    }\r\n  \r\n  ]\r\n}";
					String ss = payload;

					try {
						URL url = new URL("https://api.onfido.com/v2/applicants");
						HttpURLConnection connection = (HttpURLConnection) url.openConnection();

						connection.setDoInput(true);
						connection.setDoOutput(true);
						connection.setRequestMethod("POST");
						connection.setRequestProperty("Accept", "application/json");
						connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
						connection.setRequestProperty("Authorization",
								"Token token=test_w1dVbzyC-xb-4qWir_TqAVACKdeCspJc");
						OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
						writer.write(payload);
						writer.close();

						BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

						StringBuffer jsonString = new StringBuffer();
						String line;
						while ((line = br.readLine()) != null) {
							jsonString = jsonString.append(line);
							JSONObject jsonObject = new JSONObject(line);
							String ApplicantId = jsonObject.getString("id");
							_ApplicantKYC.setApplicantId(ApplicantId);
							_ApplicantKYC.setCustomerApplicantKYCId(CustomerId);
							_ApplicantKYC.setCompanyId(CompanyId);
							_ApplicantKYC.addupdateApplicantKYC(CustomerId, CompanyId, _ApplicantKYC.ApplicantId);
							_ApplicantKYC.setResult("Sucess");
						}
						br.close();
						connection.disconnect();
					} catch (Exception e) {
						/// System.out.println(e.getMessage());
						// throw new RuntimeException(e.getMessage());
						_ApplicantKYC.setResult("Failed");
						_ApplicantKYC.setError(e.getMessage());
						clear(_ApplicantKYC);
					}

				} else {

					// Update applicant

					String payload = "{\r\n  \r\n  \"title\":\"" + Title + "\",\r\n  \"first_name\": \"" + FirstName
							+ "\",\r\n  \"last_name\": \"" + LastName + "\",\r\n  \"gender\": \"" + Gender
							+ "\",\r\n  \"dob\": \"" + DOB + "\",\r\n  \"country\": \"" + Country
							+ "\",\r\n      \"mobile\": \"" + phone
							+ "\",\r\n  \"addresses\": [\r\n    {\r\n      \"flat_number\": \"" + FlatNumber
							+ "\",\r\n      \"building_name\": \"" + BuildingName
							+ "\",\r\n      \"building_number\": \"" + BuildingNumber + "\",\r\n      \"street\": \""
							+ Street + "\",\r\n      \"sub_street\": null,\r\n  \"state\":\"" + State
							+ "\",\r\n      \"town\": \"" + Town + "\",\r\n      \"postcode\": \"" + PostalCode
							+ "\",\r\n      \"country\": \"" + Country + "\",\r\n      \"start_date\":\""
							+ _ApplicantKYC.CreatedDate + "\",\r\n      \"end_date\": null\r\n    }\r\n  \r\n  ]\r\n}";
					String ss = payload;
					try {
						String applicantId = _ResultSetCompany.getString("ApplicantId");
						URL url = new URL("https://api.onfido.com/v2/applicants/" + applicantId);
						HttpURLConnection connection = (HttpURLConnection) url.openConnection();

						connection.setDoInput(true);
						connection.setDoOutput(true);
						connection.setRequestMethod("PUT");
						connection.setRequestProperty("Accept", "application/json");
						connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
						connection.setRequestProperty("Authorization",
								"Token token=test_w1dVbzyC-xb-4qWir_TqAVACKdeCspJc");
						OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
						writer.write(payload);
						writer.close();

						BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

						StringBuffer jsonString = new StringBuffer();
						String line;
						while ((line = br.readLine()) != null) {
							jsonString = jsonString.append(line);
							JSONObject jsonObject = new JSONObject(line);
							String ApplicantId = jsonObject.getString("id");
							_ApplicantKYC.setApplicantId(ApplicantId);
							_ApplicantKYC.setCustomerApplicantKYCId(CustomerId);
							_ApplicantKYC.setCompanyId(CompanyId);
							_ApplicantKYC.addupdateApplicantKYC(CustomerId, CompanyId, _ApplicantKYC.ApplicantId);
							_ApplicantKYC.setResult("Sucess");
						}
						br.close();
						connection.disconnect();

					} catch (Exception e) {
						_ApplicantKYC.setResult("Failed");
						_ApplicantKYC.setError(e.getMessage());
						clear(_ApplicantKYC);
					}

				}
			} else {
				_ApplicantKYC.setResult("Failed");
				_ApplicantKYC.setError("Error in api backend connectivity !");
				clear(_ApplicantKYC);
			}
		} catch (Exception e) {
			// System.out.println(e.getMessage());
			_ApplicantKYC.setResult("Failed");
			_ApplicantKYC.setError(e.getMessage());
			clear(_ApplicantKYC);
		} finally {

		}

		return _ApplicantKYC;
	}

	public ApplicantKYC test() {
		ApplicantKYC _ApplicantKYC = new ApplicantKYC();

		try {

			URL url = new URL("https://api.onfido.com/v2/applicants/d528925a-3034-49ad-80b0-fbef26391e75");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Authorization", "Token token=test_w1dVbzyC-xb-4qWir_TqAVACKdeCspJc");
			conn.setRequestProperty("Content-Type", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();
		} catch (Exception e) {
			_ApplicantKYC.setResult("Failed");
			_ApplicantKYC.setError(e.getMessage());
			clear(_ApplicantKYC);
		}

		return _ApplicantKYC;

	}

	public ApplicantKYC addupdateApplicantKYC(int CustomerId, int CompanyId, String ApplicantId) {
		ApplicantKYC _ApplicantKYC = new ApplicantKYC();
		Connection _Connection = MYSQLConnection.GetConnection();
		PreparedStatement _PreparedStatement = null;
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		try {
			if (_Connection != null) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				String date = format.format(cal.getTime());
				_ApplicantKYC.setCreatedDate(date);

				ResultSet _ResultSet = _MYSQLHelper
						.GetResultSet("SELECT email FROM company where Company_Id='" + CompanyId + "'", _Connection);
				if (_ResultSet.next()) {

					ResultSet _ResultSetCust = _MYSQLHelper.GetResultSet(
							"SELECT * FROM customer_applicant_kyc where CustomerId='" + CustomerId + "'", _Connection);
					if (!_ResultSetCust.next()) {
						String sInsertStatement = "INSERT INTO customer_applicant_kyc( ApplicantId, CustomerId, CompanyId, CreatedDate)";
						sInsertStatement = sInsertStatement + " VALUES(?, ?, ?, ?)";
						_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
						_PreparedStatement.setString(1, ApplicantId);
						_PreparedStatement.setInt(2, CustomerId);
						_PreparedStatement.setInt(3, CompanyId);
						_PreparedStatement.setString(4, _ApplicantKYC.CreatedDate);

						_PreparedStatement.executeUpdate();
						_ApplicantKYC.setResult("Sucess");
						ResultSet _ResultSetld = _MYSQLHelper.GetResultSet(
								"SELECT MAX(CustomerApplicantKYCId) AS CustomerApplicantKYCId FROM customer_applicant_kyc",
								_Connection);
						if (_ResultSetld.next()) {
							int lastid = _ResultSetld.getInt("CustomerApplicantKYCId");
							_ApplicantKYC.setCustomerApplicantKYCId(lastid);
							// clear(_ApplicantKYC);

						}
					} else {
						_ApplicantKYC.CustomerApplicantKYCId = _ResultSetCust.getInt("CustomerApplicantKYCId");
						String sInsertStatement = "UPDATE customer_applicant_kyc  SET ApplicantId = ?,CustomerId = ? ,CompanyId = ? ,CreatedDate = ?"
								+ " WHERE CustomerApplicantKYCId = ?";
						_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
						_PreparedStatement.setString(1, ApplicantId);
						_PreparedStatement.setInt(2, CustomerId);
						_PreparedStatement.setInt(3, CompanyId);
						_PreparedStatement.setString(4, _ApplicantKYC.CreatedDate);
						_PreparedStatement.setInt(5, _ApplicantKYC.CustomerApplicantKYCId);
						_PreparedStatement.executeUpdate();
						_ApplicantKYC.setResult("Sucess");
						// clear(_ApplicantKYC);
					}

				} else {
					_ApplicantKYC.setResult("Failed");
					_ApplicantKYC.setError("Invalid Company-Id!");
					clear(_ApplicantKYC);

				}
			} else {
				_ApplicantKYC.setResult("Failed");
				_ApplicantKYC.setError("Error in api backend connectivity !");
				clear(_ApplicantKYC);
			}
		} catch (Exception e) {
			// clear(_ApplicantKYC);
			_ApplicantKYC.setResult("Failed");
			_ApplicantKYC.setError(e.getMessage());

		}

		finally {
			if (_Connection != null) {
				try {
					_Connection.close();
				} catch (SQLException ex) {
					// _CustomerDetail.setResult(ex.getMessage() + " Stack
					// Trace: " + ex.getStackTrace());
					clear(_ApplicantKYC);
				}
			}
		}
		return _ApplicantKYC;

	}

	public ApplicantKYC getApplicantKYCId(int CustomerApplicantKYCId) {
		ApplicantKYC _ApplicantKYC = new ApplicantKYC();
		Connection _Connection = MYSQLConnection.GetConnection();
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		try {
			if (_Connection != null) {
				ResultSet _ResultSet = _MYSQLHelper
						.GetResultSet("SELECT * FROM customer_applicant_kyc where CustomerApplicantKYCId='"
								+ CustomerApplicantKYCId + "'", _Connection);
				if (_ResultSet.next()) {
					_ApplicantKYC.setCustomerId(_ResultSet.getInt("CustomerId"));
					_ApplicantKYC.setCompanyId(_ResultSet.getInt("CompanyId"));
					_ApplicantKYC.setApplicantId(_ResultSet.getString("ApplicantId"));
					_ApplicantKYC.setCustomerApplicantKYCId(_ResultSet.getInt("CustomerApplicantKYCId"));
					_ApplicantKYC.setCreatedDate(_ResultSet.getString("CreatedDate"));
					_ApplicantKYC.setIsDocumentUpload(_ResultSet.getBoolean("IsDocumentUpload"));
					_ApplicantKYC.setResult("Success");
				} else {
					_ApplicantKYC.setResult("Failed");
					_ApplicantKYC.setError("Invalid Customer ApplicantKYC Id!");
					clear(_ApplicantKYC);
				}
			} else {
				_ApplicantKYC.setResult("Failed");
				_ApplicantKYC.setError("Error in api backend connectivity !");
				clear(_ApplicantKYC);
			}
		} catch (Exception e) {

		}

		return _ApplicantKYC;

	}

	public static ArrayList<ApplicantKYC> getKYCDetilasApplicant(int CompanyId, int Customerid, String ApplicantId) {

		Connection _Connection = MYSQLConnection.GetConnection();
		ArrayList<ApplicantKYC> _ApplicantKYCDetaillist = new ArrayList<ApplicantKYC>();
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		try {
			if (_Connection != null) {
				if (CompanyId > 0) {
					ResultSet _ResultSet = _MYSQLHelper.GetResultSet(
							"SELECT * FROM customer_applicant_kyc where CompanyId	='" + CompanyId + "' ",
							_Connection);

					while (_ResultSet.next()) {
						ApplicantKYC _ApplicantKYC = new ApplicantKYC();

						_ApplicantKYC.setCustomerId(_ResultSet.getInt("CustomerId"));
						_ApplicantKYC.setCompanyId(_ResultSet.getInt("CompanyId"));
						_ApplicantKYC.setApplicantId(_ResultSet.getString("ApplicantId"));
						_ApplicantKYC.setCustomerApplicantKYCId(_ResultSet.getInt("CustomerApplicantKYCId"));
						_ApplicantKYC.setCreatedDate(_ResultSet.getString("CreatedDate"));
						_ApplicantKYC.setIsDocumentUpload(_ResultSet.getBoolean("IsDocumentUpload"));
						_ApplicantKYC.setResult("Success");
						_ApplicantKYCDetaillist.add(_ApplicantKYC);
					}
					_ResultSet.close();

				} else if (Customerid > 0) {
					ResultSet _ResultSet = _MYSQLHelper.GetResultSet(
							"SELECT * FROM customer_applicant_kyc where CustomerId='" + Customerid + "' ", _Connection);

					while (_ResultSet.next()) {
						ApplicantKYC _ApplicantKYC = new ApplicantKYC();
						_ApplicantKYC.setCustomerId(_ResultSet.getInt("CustomerId"));
						_ApplicantKYC.setCompanyId(_ResultSet.getInt("CompanyId"));
						_ApplicantKYC.setApplicantId(_ResultSet.getString("ApplicantId"));
						_ApplicantKYC.setCustomerApplicantKYCId(_ResultSet.getInt("CustomerApplicantKYCId"));
						_ApplicantKYC.setCreatedDate(_ResultSet.getString("CreatedDate"));
						_ApplicantKYC.setIsDocumentUpload(_ResultSet.getBoolean("IsDocumentUpload"));
						_ApplicantKYC.setResult("Success");
						_ApplicantKYCDetaillist.add(_ApplicantKYC);
					}
					_ResultSet.close();
				} else if (ApplicantId != "") {
					ResultSet _ResultSet = _MYSQLHelper.GetResultSet(
							"SELECT * FROM customer_applicant_kyc where ApplicantId='" + ApplicantId + "' ",
							_Connection);

					while (_ResultSet.next()) {
						ApplicantKYC _ApplicantKYC = new ApplicantKYC();
						_ApplicantKYC.setCustomerId(_ResultSet.getInt("CustomerId"));
						_ApplicantKYC.setCompanyId(_ResultSet.getInt("CompanyId"));
						_ApplicantKYC.setApplicantId(_ResultSet.getString("ApplicantId"));
						_ApplicantKYC.setCustomerApplicantKYCId(_ResultSet.getInt("CustomerApplicantKYCId"));
						_ApplicantKYC.setCreatedDate(_ResultSet.getString("CreatedDate"));
						_ApplicantKYC.setIsDocumentUpload(_ResultSet.getBoolean("IsDocumentUpload"));
						_ApplicantKYC.setResult("Success");
						_ApplicantKYCDetaillist.add(_ApplicantKYC);
					}
					_ResultSet.close();
				}

			}
		} catch (Exception e) {

		}

		return _ApplicantKYCDetaillist;
	}

	
	
	public ApplicantKYC TestBaba() {
		ApplicantKYC _ApplicantKYC = new ApplicantKYC();

		try {
			

			// File _File = new File("c:\t.jpg");
			
			// MultipartEntity multipartEntity = new
			// MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
			// multipartEntity.addPart("Image", new FileBody(_File));
			// httppost.setEntity(multipartEntity);

			// mHttpClient.execute(httppost, new PhotoUploadResponseHandler());

			
			
			
			HttpParams params = new BasicHttpParams();
			params.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
			HttpClient mHttpClient = new DefaultHttpClient(params);
			HttpPost httppost = new HttpPost("https://api.onfido.com/v2/applicants/22dd12a3-e4e0-4011-9605-5a96262fd293/documents"); 
			 File file = new File("D:/rajeev/Money_Transfer/src/Documents/Jellyfish.jpg");  
			OkHttpClient client = new OkHttpClient();
			MediaType mediaType = MediaType
					.parse("multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW");
			Request request = new Request.Builder()
					.url("https://api.onfido.com/v2/applicants/22dd12a3-e4e0-4011-9605-5a96262fd293/documents")

					.addHeader("file", "multipart/form-data,"+file)
					.addHeader("authorization", "Token token=test_w1dVbzyC-xb-4qWir_TqAVACKdeCspJc")
					.addHeader("type", "passport").addHeader("side", "front")
					// .addHeader("postman-token",
					// "41b645e3-790e-0f5e-b40a-7b185e0926c7")

					.build();

			Response response = client.newCall(request).execute();
			System.out.println("response: " + response.body().string());
			System.out.println("response: " + response);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return _ApplicantKYC;
	}

	public ApplicantKYC clear(ApplicantKYC _ApplicantKYC) {
		_ApplicantKYC.setCompanyId(0);
		_ApplicantKYC.setCustomerId(0);
		_ApplicantKYC.setCreatedDate("");
		_ApplicantKYC.setApplicantId("");
		return _ApplicantKYC;
	}

	String boundary = "*****";
	String crlf = "\r\n";
	String twoHyphens = "--";
	String side = "front";
	String type = "passport";
	String attachmentName = "------WebKitFormBoundary7MA4YWxkTrZu0gW";
	String attachmentFileName = "ishu";

	public ApplicantKYC uploaddoc() {
		ApplicantKYC _ApplicantKYC = new ApplicantKYC();
		try {
			HttpURLConnection httpUrlConnection = null;
			URL url = new URL("https://api.onfido.com/v2/applicants/19fe20cc-f3c5-473d-bb2c-2a92141d0abb/documents");
			httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setUseCaches(false);
			httpUrlConnection.setDoOutput(true);
			httpUrlConnection.setRequestProperty("Authorization", "Token token=test_w1dVbzyC-xb-4qWir_TqAVACKdeCspJc");
			httpUrlConnection.setRequestMethod("POST");
			httpUrlConnection.setRequestProperty("Connection", "Keep-Alive");
			httpUrlConnection.setRequestProperty("Cache-Control", "no-cache");
			httpUrlConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + this.boundary);

			DataOutputStream request = new DataOutputStream(httpUrlConnection.getOutputStream());

			request.writeBytes(this.twoHyphens + this.boundary + this.crlf);
			request.writeBytes("Content-Disposition: form-data; file=\"" + this.attachmentName + "\";filename=\""
					+ this.attachmentFileName + "\";type=\"" + type + "\";side=\"" + side + this.crlf);
			String ss = "Content-Disposition: form-data; file=\"" + this.attachmentName + "\";filename=\""
					+ this.attachmentFileName + "\";type=\"" + type + "\";side=\"" + side + this.crlf;

			request.writeBytes(this.crlf);

			// BufferedImage image = ImageIO.read(new File("c:\t.jpg"));
			// ByteArrayOutputStream baos = new ByteArrayOutputStream();
			// ImageIO.write(image, "jpg", baos);
			// byte[] res=baos.toByteArray();
			// String encodedImage = Base64.encode(baos.toByteArray());

			// File imgPath = new File("c:\t.jpg");
			BufferedImage bufferedImage = ImageIO
					.read(new File("D:/rajeev/Money_Transfer/src/Documents/Jellyfish.jpg"));

			// get DataBufferBytes from Raster
			WritableRaster raster = bufferedImage.getRaster();
			DataBufferByte data = (DataBufferByte) raster.getDataBuffer();

			request.write(data.getData());

			request.writeBytes(this.crlf);
			request.writeBytes(this.twoHyphens + this.boundary + this.twoHyphens + this.crlf);

			request.flush();
			request.close();

			InputStream responseStream = new BufferedInputStream(httpUrlConnection.getInputStream());

			BufferedReader responseStreamReader = new BufferedReader(new InputStreamReader(responseStream));

			String line = "";
			StringBuilder stringBuilder = new StringBuilder();
			while ((line = responseStreamReader.readLine()) != null) {
				stringBuilder.append(line).append("\n");
			}
			responseStreamReader.close();

			String response = stringBuilder.toString();
			responseStream.close();

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return _ApplicantKYC;
	}

	private static final String IMGUR_CLIENT_ID = "...";
	private static final MediaType MEDIA_TYPE_PNG = MediaType
			.parse("D:/rajeev/Money_Transfer/src/Documents/Jellyfish.jpg");
	private final OkHttpClient client = new OkHttpClient();

	public ApplicantKYC pub() {
		ApplicantKYC _ApplicantKYC = new ApplicantKYC();

		try {
			RequestBody requestBody = new MultipartBuilder().type(MultipartBuilder.FORM)
					.addPart(Headers.of("Content-Disposition", "form-data; name=\"type\""),
							RequestBody.create(MediaType.parse("text/plain"), "passport"))
					.addPart(Headers.of("Content-Disposition", "form-data; name=\"side\""),
							RequestBody.create(MediaType.parse("text/plain"), "front"))

					.addPart(Headers.of("Content-Disposition", "form-data; name=\"file\""), RequestBody
							.create(MEDIA_TYPE_PNG, new File("D:/rajeev/Money_Transfer/src/Documents/Jellyfish.jpg")))
					.build();

			
			Request request = new Request.Builder()
					.header("Authorization", "Token token=test_w1dVbzyC-xb-4qWir_TqAVACKdeCspJc")

					.url("https://api.onfido.com/v2/applicants/19fe20cc-f3c5-473d-bb2c-2a92141d0abb/documents")
					.post(requestBody).build();

			Response response = client.newCall(request).execute();
			// if (!response.isSuccessful()) throw new IOException("Unexpected
			// code " + response);

			System.out.println(response.body().string());
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}

		return _ApplicantKYC;
	}

	
	
	String fname = "ishu.jpg";
	public ApplicantKYC name() {

		ApplicantKYC _ApplicantKYC = new ApplicantKYC();

		try {	
			
			HttpURLConnection httpUrlConnection = null;
			URL url = new URL("https://api.onfido.com/v2/applicants/22dd12a3-e4e0-4011-9605-5a96262fd293/documents");
			httpUrlConnection = (HttpURLConnection) url.openConnection();  
			httpUrlConnection.setUseCaches(false);
			httpUrlConnection.setDoOutput(true);
			httpUrlConnection.setRequestProperty("Authorization", "Token token=test_w1dVbzyC-xb-4qWir_TqAVACKdeCspJc");
			httpUrlConnection.setRequestMethod("POST");
			httpUrlConnection.setRequestProperty("Connection", "Keep-Alive");
			httpUrlConnection.setRequestProperty("Cache-Control", "no-cache");
			httpUrlConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + this.boundary);
			 File imgPath = new File("D:/rajeev/Money_Transfer/src/Documents/Jellyfish.jpg");
			DataOutputStream request = new DataOutputStream(
				    httpUrlConnection.getOutputStream());
			String side = "front";
			String type = "passport";
				request.writeBytes(this.twoHyphens + this.boundary + this.crlf);
				request.writeBytes("Content-Disposition: form-data; filename=\"" + 
				    fname+ "\";side=\"" + 
				   side + "\";type\"" + 
				    type + "\";" + this.crlf);
				request.writeBytes(this.crlf);
			
				
				 BufferedImage bufferedImage = ImageIO.read(imgPath);
				
				 WritableRaster raster = bufferedImage .getRaster();
				 DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();
				 request.write(data.getData());
				 request.writeBytes(this.crlf);
				 request.writeBytes(this.twoHyphens + this.boundary + 
				     this.twoHyphens + this.crlf);
				 
				 request.flush();
				 request.close();
				
				InputStream responseStream = new 
					    BufferedInputStream(httpUrlConnection.getInputStream());

					BufferedReader responseStreamReader = 
					    new BufferedReader(new InputStreamReader(responseStream));

					String line = "";
					StringBuilder stringBuilder = new StringBuilder();

					while ((line = responseStreamReader.readLine()) != null) {
					    stringBuilder.append(line).append("\n");
					}
					responseStreamReader.close();

					String response = stringBuilder.toString();
					
					System.out.println(response);

		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
		return _ApplicantKYC;
	}

	
	
	
}

class PhotoUploadResponseHandler implements ResponseHandler<Object> {
	@Override
	public Object handleResponse(HttpResponse response) throws ClientProtocolException, IOException {

		HttpEntity r_entity = response.getEntity();
		String responseString = EntityUtils.toString(r_entity);

		return null;
	}
}
