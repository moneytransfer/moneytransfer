package com.etl.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.etl.util.MYSQLConnection;
import com.etl.util.MYSQLHelper;

public class ApplicantKYC {
	public int CustomerApplicantKYCId;
	public int CustomerId;
	public int CompanyId;
	public String ApplicantId;
	public boolean IsDocumentUpload;
	public String CreatedDate;
	public String Result;
	public String Error;

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

	public ApplicantKYC addupdateApplicantKYC(ApplicantKYC _ApplicantKYC) {

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
						"SELECT email FROM company where Company_Id='" + _ApplicantKYC.CompanyId + "'", _Connection);
				if (_ResultSet.next()) {
					ResultSet _ResultSetCustomer = _MYSQLHelper.GetResultSet(
							"SELECT customer_Id FROM customer where customer_Id='" + _ApplicantKYC.CustomerId + "'",
							_Connection);
					if (_ResultSetCustomer.next()) {
						if (_ApplicantKYC.CustomerApplicantKYCId <= 0) {
							String sInsertStatement = "INSERT INTO customer_applicant_kyc( ApplicantId, CustomerId, CompanyId, CreatedDate)";
							sInsertStatement = sInsertStatement + " VALUES(?, ?, ?, ?)";
							_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
							_PreparedStatement.setString(1, _ApplicantKYC.ApplicantId);
							_PreparedStatement.setInt(2, _ApplicantKYC.CustomerId);
							_PreparedStatement.setInt(3, _ApplicantKYC.CompanyId);
							_PreparedStatement.setString(4, _ApplicantKYC.CreatedDate);

							_PreparedStatement.executeUpdate();
							_ApplicantKYC.setResult("Sucess");
							ResultSet _ResultSetld = _MYSQLHelper.GetResultSet(
									"SELECT MAX(CustomerApplicantKYCId) AS CustomerApplicantKYCId FROM customer_applicant_kyc",
									_Connection);
							if (_ResultSetld.next()) {
								int lastid = _ResultSetld.getInt("CustomerApplicantKYCId");
								_ApplicantKYC.setCustomerApplicantKYCId(lastid);
								clear(_ApplicantKYC);
							}
						} else {
							String sInsertStatement = "UPDATE customer_applicant_kyc  SET ApplicantId = ?,CustomerId = ? ,CompanyId = ? ,CreatedDate = ?"
									+ " WHERE CustomerApplicantKYCId = ?";
							_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
							_PreparedStatement.setString(1, _ApplicantKYC.ApplicantId);
							_PreparedStatement.setInt(2, _ApplicantKYC.CustomerId);
							_PreparedStatement.setInt(3, _ApplicantKYC.CompanyId);
							_PreparedStatement.setString(4, _ApplicantKYC.CreatedDate);
							_PreparedStatement.setInt(5, _ApplicantKYC.CustomerApplicantKYCId);
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
			clear(_ApplicantKYC);
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
				ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM customer_applicant_kyc where CustomerApplicantKYCId='"+CustomerApplicantKYCId+"'",_Connection);
				if (_ResultSet.next())
				{
					_ApplicantKYC.setCustomerId(_ResultSet.getInt("CustomerId"));
					_ApplicantKYC.setCompanyId(_ResultSet.getInt("CompanyId"));
					_ApplicantKYC.setApplicantId(_ResultSet.getString("ApplicantId"));
					_ApplicantKYC.setCustomerApplicantKYCId(_ResultSet.getInt("CustomerApplicantKYCId"));
					_ApplicantKYC.setCreatedDate(_ResultSet.getString("CreatedDate"));
					_ApplicantKYC.setIsDocumentUpload(_ResultSet.getBoolean("IsDocumentUpload"));
					_ApplicantKYC.setResult("Success");
				}
				else{
					_ApplicantKYC.setResult("Failed");
					_ApplicantKYC.setError("Invalid Customer ApplicantKYC Id!");
					clear(_ApplicantKYC);
		    	}
			}
			else{
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
