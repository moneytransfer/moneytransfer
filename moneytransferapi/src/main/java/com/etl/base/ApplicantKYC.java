package com.etl.base;

import java.io.BufferedReader;
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

import org.json.JSONObject;

import com.etl.util.MYSQLConnection;
import com.etl.util.MYSQLHelper;
public class ApplicantKYC {
	public int CustomerApplicantKYCId;
	public int CustomerId;
	public int CompanyId;
	public String ApplicantId;

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

	public ApplicantKYC addApplicantKYC(int CustomerId, int CompanyId, String Title, String FirstName, String LastName, String Gender, String DOB, String Country, String FlatNumber, String BuildingName, String BuildingNumber, String Street, String State, String Town, String PostalCode) {
		
		
		ApplicantKYC _ApplicantKYC=new ApplicantKYC();
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		Connection _Connection = MYSQLConnection.GetConnection();
		PreparedStatement _PreparedStatement = null;
		try {
			if (_Connection != null) {

				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				String date=format.format(cal.getTime());
				_ApplicantKYC.setCreatedDate(date);
				ResultSet _ResultSetCompany = _MYSQLHelper.GetResultSet(
						"SELECT country_id FROM company where Company_Id='" + CompanyId + "'",
						_Connection);
				if (_ResultSetCompany.next()) {
					if (_ApplicantKYC.CustomerApplicantKYCId <= 0) {

						
						String payload = "{\r\n  \r\n  \"title\":\""+Title+"\",\r\n  \"first_name\": \""+FirstName+"\",\r\n  \"last_name\": \""+LastName+"\",\r\n  \"gender\": \""+Gender+"\",\r\n  \"dob\": \""+DOB+"\",\r\n  \"country\": \""+Country+"\",\r\n  \"addresses\": [\r\n    {\r\n      \"flat_number\": \""+FlatNumber+"\",\r\n      \"building_name\": \""+BuildingName+"\",\r\n      \"building_number\": \""+BuildingNumber+"\",\r\n      \"street\": \""+Street+"\",\r\n      \"sub_street\": null,\r\n  \"state\":\""+State+"\",\r\n      \"town\": \""+Town+"\",\r\n      \"postcode\": \""+PostalCode+"\",\r\n      \"country\": \""+Country+"\",\r\n      \"start_date\":\""+_ApplicantKYC.CreatedDate+"\",\r\n      \"end_date\": null\r\n    }\r\n  \r\n  ]\r\n}";
						String ss=payload;
					
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
								jsonString=	 jsonString.append(line);
								JSONObject jsonObject = new JSONObject(line);
								String ApplicantId=jsonObject.getString("id");
								_ApplicantKYC.setApplicantId(ApplicantId);
								_ApplicantKYC.setCustomerApplicantKYCId(CustomerId);
								_ApplicantKYC.setCompanyId(CompanyId);
								_ApplicantKYC.addupdateApplicantKYC(CustomerId,CompanyId,_ApplicantKYC.ApplicantId);
							}
							br.close();
							connection.disconnect();
						} catch (Exception e) {
							System.out.println(e.getMessage());
							throw new RuntimeException(e.getMessage());
						}
					} else {
						// Update applicant
					}
				} else {
					_ApplicantKYC.setResult("Failed");
					_ApplicantKYC.setError("Invalid Company Id!");
					// clear(_ApplicantKYC);
				}
			} else {
				_ApplicantKYC.setResult("Failed");
				_ApplicantKYC.setError("Error in api backend connectivity !");
				// clear(_ApplicantKYC);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
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

		}

		return _ApplicantKYC;

	}

	public ApplicantKYC addupdateApplicantKYC(int CustomerId, int CompanyId, String ApplicantId) {
		ApplicantKYC _ApplicantKYC =new ApplicantKYC();
		Connection _Connection = MYSQLConnection.GetConnection();
		PreparedStatement _PreparedStatement = null;
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		try {
			if (_Connection != null) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				String date = format.format(cal.getTime());
				_ApplicantKYC.setCreatedDate(date);

				ResultSet _ResultSet = _MYSQLHelper.GetResultSet(
						"SELECT email FROM company where Company_Id='" + CompanyId + "'", _Connection);
				if (_ResultSet.next()) {
					ResultSet _ResultSetCustomer = _MYSQLHelper.GetResultSet(
							"SELECT customer_Id FROM customer where customer_Id='" + CustomerId + "'",
							_Connection);
					if (_ResultSetCustomer.next()) {
						if (_ApplicantKYC.CustomerApplicantKYCId <= 0) {
							
							ResultSet _ResultSetCust= _MYSQLHelper.GetResultSet("SELECT * FROM customer_applicant_kyc where CustomerId='"
											+ CustomerId + "'", _Connection);
							if(!_ResultSetCust.next())
							{
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
									//clear(_ApplicantKYC);
									
								}
							}
							else {
								_ApplicantKYC.CustomerApplicantKYCId=_ResultSetCust.getInt("CustomerApplicantKYCId");
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
								//clear(_ApplicantKYC);
							}
							
						} else {
							String sInsertStatement = "UPDATE customer_applicant_kyc  SET ApplicantId = ?,CustomerId = ? ,CompanyId = ? ,CreatedDate = ?"
									+ " WHERE CustomerApplicantKYCId = ?";
							_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
							_PreparedStatement.setString(1, ApplicantId);
							_PreparedStatement.setInt(2, CustomerId);
							_PreparedStatement.setInt(3, CompanyId);
							_PreparedStatement.setString(4, _ApplicantKYC.CreatedDate);
							_PreparedStatement.setInt(5, CustomerApplicantKYCId);
							_PreparedStatement.executeUpdate();
							_ApplicantKYC.setResult("Sucess");
							clear(_ApplicantKYC);
						}

					} else {
						_ApplicantKYC.setResult("Failed");
						_ApplicantKYC.setError("Invalid Customer Id!");
						clear(_ApplicantKYC);
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
			//clear(_ApplicantKYC);
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

	public ApplicantKYC clear(ApplicantKYC _ApplicantKYC) {
		_ApplicantKYC.setCompanyId(0);
		_ApplicantKYC.setCustomerId(0);
		_ApplicantKYC.setCreatedDate("");
		_ApplicantKYC.setApplicantId("");
		return _ApplicantKYC;
	}
}
