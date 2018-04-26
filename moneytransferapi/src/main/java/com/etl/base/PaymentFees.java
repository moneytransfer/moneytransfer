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

public class PaymentFees {
	public int PaymentFessId;
	public int PaymentMethodId;
	public int CompanyId;
	public double StartingAmount;
	public double EndAmount;
	public int FeesType;
	public double Fees;
	public int SourceCountry;
	public int DestinationCountry;
	public int FeesCategoryId;
	public int PayInAgentId;
	public boolean IsPayInAgent;
	public int PayOutAgentId;
	public boolean IsPayOutAgent;
	public String CreatedDate;
	public boolean ChargeSendingAmount;
	public String Code;
	public String GobalExchangeRateCode;
	public String TransactionFeeType;
	public boolean IsDeleted;
	public String DeletedDate;
	public String Result;
	public String Error;
	public String TransactionFeeSharingCode;
	private void setPaymentFessId(int PaymentFessId) {
		this.PaymentFessId = PaymentFessId;
	}

	private int getPaymentFessId() {
		return PaymentFessId;
	}

	private void setPaymentMethodId(int PaymentMethodId) {
		this.PaymentMethodId = PaymentMethodId;
	}

	private int getPaymentMethodId() {
		return PaymentMethodId;
	}

	private void setCompanyId(int CompanyId) {
		this.CompanyId = CompanyId;
	}

	private int getCompanyId() {
		return CompanyId;
	}

	private void setStartingAmount(double StartingAmount) {
		this.StartingAmount = StartingAmount;
	}

	private double getStartingAmount() {
		return StartingAmount;
	}

	private void setEndAmount(double EndAmount) {
		this.EndAmount = EndAmount;
	}

	private double getEndAmount() {
		return EndAmount;
	}

	private void setFeesType(int FeesType) {
		this.FeesType = FeesType;
	}

	private int getFeesType() {
		return FeesType;
	}

	private void setSourceCountry(int SourceCountry) {
		this.SourceCountry = SourceCountry;
	}

	private int getSourceCountry() {
		return SourceCountry;
	}

	private void setDestinationCountry(int DestinationCountry) {
		this.DestinationCountry = DestinationCountry;
	}

	private int getDestinationCountry() {
		return DestinationCountry;
	}

	private void setFeesCategoryId(int FeesCategoryId) {
		this.FeesCategoryId = FeesCategoryId;
	}

	private int getFeesCategoryId() {
		return FeesCategoryId;
	}

	private void setPayInAgentId(int PayInAgentId) {
		this.PayInAgentId = PayInAgentId;
	}

	private int getPayInAgentId() {
		return PayInAgentId;
	}

	private void setPayOutAgentId(int PayOutAgentId) {
		this.PayOutAgentId = PayOutAgentId;
	}

	private int getPayOutAgentId() {
		return PayOutAgentId;
	}

	private void setFees(double Fees) {
		this.Fees = Fees;
	}

	private double getFees() {
		return Fees;
	}
	
	
	private void setGobalExchangeRateCode(String GobalExchangeRateCode) {
		this.GobalExchangeRateCode = GobalExchangeRateCode;
	}

	private String getGobalExchangeRateCode() {
		return GobalExchangeRateCode;
	}
	private void setTransactionFeeType(String CreatedDate) {
		this.TransactionFeeType = TransactionFeeType;
	}

	private String getTransactionFeeType() {
		return TransactionFeeType;
	}

	private void setCreatedDate(String CreatedDate) {
		this.CreatedDate = CreatedDate;
	}

	private String getCreatedDate() {
		return CreatedDate;
	}

	private void setDeletedDate(String DeletedDate) {
		this.DeletedDate = DeletedDate;
	}

	private String getDeletedDate() {
		return DeletedDate;
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

	private void setIsDeleted(Boolean IsDeleted) {
		this.IsDeleted = IsDeleted;
	}

	private Boolean getIsDeleted() {
		return IsDeleted;
	}

	private void setChargeSendingAmount(Boolean ChargeSendingAmount) {
		this.ChargeSendingAmount = ChargeSendingAmount;
	}

	private Boolean getChargeSendingAmount() {
		return ChargeSendingAmount;
	}

	private void setIsPayInAgent(Boolean IsPayInAgent) {
		this.IsPayInAgent = IsPayInAgent;
	}

	private Boolean getIsPayInAgent() {
		return IsPayInAgent;
	}

	private void setIsPayOutAgent(Boolean IsPayOutAgent) {
		this.IsPayOutAgent = IsPayOutAgent;
	}

	private Boolean getIsPayOutAgent() {
		return IsPayOutAgent;
	}

	private void setCode(String Code) {
		this.Code = Code;
	}

	private String getCode() {
		return Code;
	}

	
	private void setTransactionFeeSharingCode(String TransactionFeeSharingCode) {
		this.TransactionFeeSharingCode = TransactionFeeSharingCode;
	}

	private String getTransactionFeeSharingCode() {
		return TransactionFeeSharingCode;
	}
	public PaymentFees addPaymentFees(PaymentFees _PaymentFees) {
		Connection _Connection = MYSQLConnection.GetConnection();
		PreparedStatement _PreparedStatement = null;
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		try {
			if (_Connection != null) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				String date = format.format(cal.getTime());
				_PaymentFees.setCreatedDate(date);
				
					ResultSet _Country = _MYSQLHelper.GetResultSet(
							"SELECT * FROM country where country_id='" + _PaymentFees.SourceCountry + "'", _Connection);
					if (_Country.next()) {
						ResultSet _destinationCountry = _MYSQLHelper.GetResultSet(
								"SELECT * FROM country where country_id='" + _PaymentFees.DestinationCountry + "'",
								_Connection);
						if (_destinationCountry.next()) {
							ResultSet _feesCategoryId = _MYSQLHelper
									.GetResultSet("SELECT * FROM feescategory where FeesCategoryId='"
											+ _PaymentFees.FeesCategoryId + "'", _Connection);
							if (_feesCategoryId.next()) {
								ResultSet _agentId = _MYSQLHelper.GetResultSet(
										"SELECT * FROM agent where AgentId='" + _PaymentFees.PayOutAgentId + "'",
										_Connection);
								if (_agentId.next()) {

									if (_PaymentFees.PaymentFessId <= 0) {

										/* 	ResultSet _ResultSetFeesCheck = _MYSQLHelper
												.GetResultSet("SELECT * FROM paymentfees WHERE SourceCountry ='"
														+ _PaymentFees.SourceCountry + "' and DestinationCountry='"
														+ _PaymentFees.DestinationCountry + "' and FeesCategoryId='"
														+ _PaymentFees.FeesCategoryId + "' and CompanyId='"
														+ _PaymentFees.CompanyId + "' and IsDeleted=0", _Connection);
										if (!_ResultSetFeesCheck.next()) {
										
										
										ResultSet _ResultSetFees = _MYSQLHelper
													.GetResultSet("SELECT * FROM `paymentfees` WHERE StartingAmount >='"
															+ _PaymentFees.StartingAmount + "' and EndAmount <='"
															+ _PaymentFees.EndAmount + "' and SourceCountry ='"
															+ _PaymentFees.SourceCountry + "' and DestinationCountry='"
															+ _PaymentFees.DestinationCountry + "' and FeesCategoryId='"
															+ _PaymentFees.FeesCategoryId + "' and CompanyId='"
															+ _PaymentFees.CompanyId + "' and PayInAgentId='"
															+ _PaymentFees.PayInAgentId + "' and PayOutAgentId='"
															+ _PaymentFees.PayOutAgentId + "' and FeesType='"
															+ _PaymentFees.FeesType + "' and PaymentMethod='"
															+ _PaymentFees.PaymentMethodId + "'", _Connection);
										*/
							
										
											ResultSet _ResultSetFees = _MYSQLHelper
													.GetResultSet("SELECT * FROM `paymentfees`"
															+ " WHERE ((`StartingAmount` <= '" + _PaymentFees.StartingAmount + "' and EndAmount >='"+ _PaymentFees.EndAmount + "') or (EndAmount BETWEEN '" + _PaymentFees.StartingAmount+"' and  '"+_PaymentFees.EndAmount + "'  or StartingAmount BETWEEN '" + _PaymentFees.StartingAmount+"' and  '"+_PaymentFees.EndAmount + "' and `StartingAmount` <= '" + _PaymentFees.StartingAmount + "' and EndAmount >='"+ _PaymentFees.EndAmount + "')) and SourceCountry ='"
															+ _PaymentFees.SourceCountry + "' and DestinationCountry='"
															+ _PaymentFees.DestinationCountry + "' and FeesCategoryId='"
															+ _PaymentFees.FeesCategoryId + "' and CompanyId='"
															+ _PaymentFees.CompanyId + "' and FeesType='"
															+ _PaymentFees.FeesType + "' and PaymentMethodId='"
															+ _PaymentFees.PaymentMethodId + "' and IsDeleted=0" , _Connection);
											if (!_ResultSetFees.next()) {
											

												String sInsertStatement = "INSERT INTO paymentfees( PaymentMethodId,CompanyId,SourceCountry,DestinationCountry,FeesCategoryId,PayInAgentId,IsPayInAgent,PayOutAgentId,IsPayOutAgent,StartingAmount,EndAmount,FeesType,Fees,ChargeSendingAmount,CreatedDate)";
												sInsertStatement = sInsertStatement
														+ " VALUES(?, ?, ?,?, ?, ?,?,?,?,?,?,?,?,?,?)";
												_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
												_PreparedStatement.setInt(1, _PaymentFees.PaymentMethodId);
												_PreparedStatement.setInt(2, _PaymentFees.CompanyId);
												_PreparedStatement.setInt(3, _PaymentFees.SourceCountry);
												_PreparedStatement.setInt(4, _PaymentFees.DestinationCountry);
												_PreparedStatement.setInt(5, _PaymentFees.FeesCategoryId);
												_PreparedStatement.setInt(6, _PaymentFees.PayInAgentId);
												_PreparedStatement.setBoolean(7, _PaymentFees.IsPayInAgent);
												_PreparedStatement.setInt(8, _PaymentFees.PayOutAgentId);
												_PreparedStatement.setBoolean(9, _PaymentFees.IsPayOutAgent);
												_PreparedStatement.setDouble(10, _PaymentFees.StartingAmount);
												_PreparedStatement.setDouble(11, _PaymentFees.EndAmount);
												_PreparedStatement.setInt(12, _PaymentFees.FeesType);
												_PreparedStatement.setDouble(13, _PaymentFees.Fees);
												_PreparedStatement.setBoolean(14, _PaymentFees.ChargeSendingAmount);
												_PreparedStatement.setString(15, _PaymentFees.CreatedDate);
												_PreparedStatement.executeUpdate();
												_PaymentFees.setResult("Sucess");
												ResultSet _ResultSetld = _MYSQLHelper.GetResultSet(
														"SELECT MAX(PaymentFessId) AS PaymentFessId FROM paymentfees",
														_Connection);
												if (_ResultSetld.next()) {
													int lastid = _ResultSetld.getInt("PaymentFessId");
													_PaymentFees.setPaymentFessId(lastid);
													String _code="";
													if(_PaymentFees.FeesCategoryId==1)
													{
														_code = "FLRTS" + lastid;
													}
													else if(_PaymentFees.FeesCategoryId==2)
													{
														_code = "FLATUPS" + lastid;
													}
													else if(_PaymentFees.FeesCategoryId==3)
													{
														_code = "FLUBPS" + lastid;
													}
													else if(_PaymentFees.FeesCategoryId==4)
													{
														_code = "FLMBP" + lastid;
													}
													else if(_PaymentFees.FeesCategoryId==20)
													{
														_code = "FLAMBP" + lastid;
													}
													else 
													{
														_code = "FLPTPD" + lastid;
													}
													 
													String sUpdateStatement = "UPDATE paymentfees SET Code = ?"
															+ " WHERE PaymentFessId = ?";
													_PreparedStatement = _Connection.prepareStatement(sUpdateStatement);
													_PreparedStatement.setString(1, _code);
													_PreparedStatement.setInt(2, _PaymentFees.PaymentFessId);
													_PaymentFees.setCode(_code);
													_PreparedStatement.executeUpdate();
												}
												clear(_PaymentFees);
										
									} else {
										String _Exitscode = _ResultSetFees.getString("Code");
										
										_PaymentFees.setResult("Failed");
										_PaymentFees.setError("Fees already exists under Code "+_Exitscode +" please edit Fee Code "+ _Exitscode +" for new requirements");
										clear(_PaymentFees);
											}

											/*		
									} else {
											
											String _Exitscode = _ResultSetFeesCheck.getString("Code");
											
											_PaymentFees.setResult("Failed");
											_PaymentFees.setError("Fees already exists under Code "+_Exitscode +" please edit Fee Code "+ _Exitscode +" for new requirements");
											clear(_PaymentFees);
										}
								
								*/

									} else {
										ResultSet _PaymentFess = _MYSQLHelper
												.GetResultSet("SELECT * FROM paymentfees where PaymentFessId='"
														+ _PaymentFees.PaymentFessId + "'", _Connection);
										if (_PaymentFess.next()) {
											String sInsertStatement = "UPDATE paymentfees SET PaymentMethodId = ?,CompanyId = ? ,SourceCountry = ?,DestinationCountry = ?,FeesCategoryId = ?,PayInAgentId = ?,IsPayInAgent = ?,PayOutAgentId = ?,IsPayOutAgent = ?,StartingAmount =?,EndAmount = ? ,FeesType =?,Fees = ?,ChargeSendingAmount = ?,CreatedDate=? "
													+ " WHERE PaymentFessId = ?";
											_PreparedStatement = _Connection.prepareStatement(sInsertStatement);

											_PreparedStatement.setInt(1, _PaymentFees.PaymentMethodId);
											_PreparedStatement.setInt(2, _PaymentFees.CompanyId);

											_PreparedStatement.setInt(3, _PaymentFees.SourceCountry);
											_PreparedStatement.setInt(4, _PaymentFees.DestinationCountry);
											_PreparedStatement.setInt(5, _PaymentFees.FeesCategoryId);
											_PreparedStatement.setInt(6, _PaymentFees.PayInAgentId);
											_PreparedStatement.setBoolean(7, _PaymentFees.IsPayInAgent);
											_PreparedStatement.setInt(8, _PaymentFees.PayOutAgentId);

											_PreparedStatement.setBoolean(9, _PaymentFees.IsPayOutAgent);
											_PreparedStatement.setDouble(10, _PaymentFees.StartingAmount);
											_PreparedStatement.setDouble(11, _PaymentFees.EndAmount);
											_PreparedStatement.setInt(12, _PaymentFees.FeesType);
											_PreparedStatement.setDouble(13, _PaymentFees.Fees);
											_PreparedStatement.setBoolean(14, _PaymentFees.ChargeSendingAmount);
											_PreparedStatement.setString(15, _PaymentFees.CreatedDate);
											_PreparedStatement.setInt(16, _PaymentFees.PaymentFessId);
											_PreparedStatement.executeUpdate();
											_PaymentFees.setResult("Sucess");
											clear(_PaymentFees);
										}

										else {
											_PaymentFees.setResult("Failed!");
											_PaymentFees.setError("Invalid Payment Fess Id!");
											clear(_PaymentFees);
										}
									}
								} else {
									_PaymentFees.setResult("Failed!");
									_PaymentFees.setError("Invalid Pay-Out Agent Id!");
									clear(_PaymentFees);
								}
							} else {
								_PaymentFees.setResult("Failed!");
								_PaymentFees.setError("Invalid Fees Category Id!");
								clear(_PaymentFees);
							}

						} else {
							_PaymentFees.setResult("Failed!");
							_PaymentFees.setError("Invalid Destination Country Id!");
							clear(_PaymentFees);
						}

					} else {
						_PaymentFees.setResult("Failed!");
						_PaymentFees.setError("Invalid source Country Id!");
						clear(_PaymentFees);
					}
				

			} else {
				_PaymentFees.setResult("Failed!");
				_PaymentFees.setError("Error in api backend connectivity !");
				clear(_PaymentFees);
			}

		} catch (Exception e) {
			_PaymentFees.setError(e.getMessage() + " Stack Trace: " + e.getStackTrace());
		}

		finally {
			if (_Connection != null) {
				try {
					_Connection.close();
					// clear(_PaymentFees);

				} catch (SQLException e) {
					clear(_PaymentFees);
				}
			}
		}
		return _PaymentFees;
	}

	public static ArrayList<PaymentFees> getPaymentFeesDetailsByCompany(int CompanyId) {
		Connection _Connection = MYSQLConnection.GetConnection();

		ArrayList<PaymentFees> _PaymentFeesDetaillist = new ArrayList<PaymentFees>();

		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		try {
			if (_Connection != null)

			{
				if (CompanyId == 0) {
					ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM paymentfees where IsDeleted=0",
							_Connection);

					while (_ResultSet.next()) {

						PaymentFees _PaymentFees = new PaymentFees();
						_PaymentFees.setPaymentFessId(_ResultSet.getInt("PaymentFessId"));
						_PaymentFees.setPaymentMethodId(_ResultSet.getInt("PaymentMethodId"));
						_PaymentFees.setCompanyId(_ResultSet.getInt("CompanyId"));
						_PaymentFees.setStartingAmount(_ResultSet.getDouble("StartingAmount"));
						_PaymentFees.setEndAmount(_ResultSet.getDouble("EndAmount"));
						_PaymentFees.setFees(_ResultSet.getDouble("Fees"));
						_PaymentFees.setFeesType(_ResultSet.getInt("FeesType"));

						_PaymentFees.setPayInAgentId(_ResultSet.getInt("PayInAgentId"));
						_PaymentFees.setIsPayInAgent(_ResultSet.getBoolean("IsPayInAgent"));
						_PaymentFees.setIsPayOutAgent(_ResultSet.getBoolean("IsPayOutAgent"));
						_PaymentFees.setCode(_ResultSet.getString("Code"));
						_PaymentFees.setGobalExchangeRateCode(_ResultSet.getString("GobalExchangeRateCode"));
						_PaymentFees.setTransactionFeeSharingCode(_ResultSet.getString("TransactionFeeSharingCode"));
						_PaymentFees.setSourceCountry(_ResultSet.getInt("SourceCountry"));
						_PaymentFees.setDestinationCountry(_ResultSet.getInt("DestinationCountry"));
						_PaymentFees.setFeesCategoryId(_ResultSet.getInt("FeesCategoryId"));
						_PaymentFees.setPayOutAgentId(_ResultSet.getInt("PayOutAgentId"));
						_PaymentFees.setChargeSendingAmount(_ResultSet.getBoolean("ChargeSendingAmount"));
						_PaymentFees.setCreatedDate(_ResultSet.getString("CreatedDate"));
						_PaymentFees.setIsDeleted(_ResultSet.getBoolean("IsDeleted"));
						_PaymentFees.setDeletedDate(_ResultSet.getString("DeletedDate"));
						_PaymentFees.setTransactionFeeType(_ResultSet.getString("TransactionFeeType"));
						_PaymentFees.setResult("Sucess");
						_PaymentFeesDetaillist.add(_PaymentFees);

					}
					_ResultSet.close();
				} else {
					ResultSet _ResultSet = _MYSQLHelper.GetResultSet(
							"SELECT * FROM paymentfees where IsDeleted=0 and CompanyId='" + CompanyId + "'",
							_Connection);

					while (_ResultSet.next()) {

						PaymentFees _PaymentFees = new PaymentFees();
						_PaymentFees.setPaymentFessId(_ResultSet.getInt("PaymentFessId"));
						_PaymentFees.setPaymentMethodId(_ResultSet.getInt("PaymentMethodId"));
						_PaymentFees.setCompanyId(_ResultSet.getInt("CompanyId"));
						_PaymentFees.setStartingAmount(_ResultSet.getDouble("StartingAmount"));
						_PaymentFees.setEndAmount(_ResultSet.getDouble("EndAmount"));
						_PaymentFees.setFees(_ResultSet.getDouble("Fees"));
						_PaymentFees.setFeesType(_ResultSet.getInt("FeesType"));
						_PaymentFees.setPayInAgentId(_ResultSet.getInt("PayInAgentId"));
						_PaymentFees.setIsPayInAgent(_ResultSet.getBoolean("IsPayInAgent"));
						_PaymentFees.setIsPayOutAgent(_ResultSet.getBoolean("IsPayOutAgent"));
						_PaymentFees.setCode(_ResultSet.getString("Code"));
						_PaymentFees.setGobalExchangeRateCode(_ResultSet.getString("GobalExchangeRateCode"));
						_PaymentFees.setSourceCountry(_ResultSet.getInt("SourceCountry"));
						_PaymentFees.setDestinationCountry(_ResultSet.getInt("DestinationCountry"));
						_PaymentFees.setFeesCategoryId(_ResultSet.getInt("FeesCategoryId"));
						_PaymentFees.setPayOutAgentId(_ResultSet.getInt("PayOutAgentId"));
						_PaymentFees.setChargeSendingAmount(_ResultSet.getBoolean("ChargeSendingAmount"));
						_PaymentFees.setCreatedDate(_ResultSet.getString("CreatedDate"));
						_PaymentFees.setIsDeleted(_ResultSet.getBoolean("IsDeleted"));
						_PaymentFees.setDeletedDate(_ResultSet.getString("DeletedDate"));
						_PaymentFees.setTransactionFeeType(_ResultSet.getString("TransactionFeeType"));
						_PaymentFees.setTransactionFeeSharingCode(_ResultSet.getString("TransactionFeeSharingCode"));
						_PaymentFees.setResult("Sucess");
						_PaymentFeesDetaillist.add(_PaymentFees);

					}
					_ResultSet.close();
				}

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

		return _PaymentFeesDetaillist;
	}

	public static ArrayList<PaymentFees> getPaymentFeesCompanyDestinationCountryDetails(int CompanyId,
			int DestinationCountry) {
		Connection _Connection = MYSQLConnection.GetConnection();

		ArrayList<PaymentFees> _PaymentFeesDetaillist = new ArrayList<PaymentFees>();

		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		try {
			if (_Connection != null)

			{
				ResultSet _ResultSet = _MYSQLHelper
						.GetResultSet("SELECT * FROM paymentfees where IsDeleted=0 and CompanyId='" + CompanyId
								+ "' and DestinationCountry='" + DestinationCountry + "'", _Connection);

				while (_ResultSet.next()) {

					PaymentFees _PaymentFees = new PaymentFees();
					_PaymentFees.setPaymentFessId(_ResultSet.getInt("PaymentFessId"));
					_PaymentFees.setPaymentMethodId(_ResultSet.getInt("PaymentMethodId"));
					_PaymentFees.setCompanyId(_ResultSet.getInt("CompanyId"));
					_PaymentFees.setStartingAmount(_ResultSet.getDouble("StartingAmount"));
					_PaymentFees.setEndAmount(_ResultSet.getDouble("EndAmount"));
					_PaymentFees.setFees(_ResultSet.getDouble("Fees"));
					_PaymentFees.setFeesType(_ResultSet.getInt("FeesType"));
					_PaymentFees.setPayInAgentId(_ResultSet.getInt("PayInAgentId"));
					_PaymentFees.setIsPayInAgent(_ResultSet.getBoolean("IsPayInAgent"));
					_PaymentFees.setIsPayOutAgent(_ResultSet.getBoolean("IsPayOutAgent"));
					_PaymentFees.setCode(_ResultSet.getString("Code"));
					_PaymentFees.setGobalExchangeRateCode(_ResultSet.getString("GobalExchangeRateCode"));
					_PaymentFees.setSourceCountry(_ResultSet.getInt("SourceCountry"));
					_PaymentFees.setDestinationCountry(_ResultSet.getInt("DestinationCountry"));
					_PaymentFees.setFeesCategoryId(_ResultSet.getInt("FeesCategoryId"));
					_PaymentFees.setPayOutAgentId(_ResultSet.getInt("PayOutAgentId"));
					_PaymentFees.setChargeSendingAmount(_ResultSet.getBoolean("ChargeSendingAmount"));
					_PaymentFees.setCreatedDate(_ResultSet.getString("CreatedDate"));
					_PaymentFees.setIsDeleted(_ResultSet.getBoolean("IsDeleted"));
					_PaymentFees.setDeletedDate(_ResultSet.getString("DeletedDate"));
					_PaymentFees.setTransactionFeeType(_ResultSet.getString("TransactionFeeType"));
					_PaymentFees.setTransactionFeeSharingCode(_ResultSet.getString("TransactionFeeSharingCode"));
					_PaymentFees.setResult("Sucess");
					_PaymentFeesDetaillist.add(_PaymentFees);

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

		return _PaymentFeesDetaillist;
	}

	
	public PaymentFees getPaymentFeesnewdetails(PaymentFees _PaymentFees) {
		Connection _Connection = MYSQLConnection.GetConnection();
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
	
		try {
			if (_Connection != null) {

				ResultSet _ResultSet = _MYSQLHelper
						.GetResultSet("SELECT * FROM paymentfees where  IsDeleted=0 and PaymentMethodId='"+_PaymentFees.PaymentMethodId+"'and SourceCountry='"+_PaymentFees.SourceCountry+"' and DestinationCountry='"+_PaymentFees.DestinationCountry+"' order by PaymentFessId desc", _Connection);
				if (_ResultSet.next()) {

				
					_PaymentFees.setPaymentFessId(_ResultSet.getInt("PaymentFessId"));
					_PaymentFees.setPaymentMethodId(_ResultSet.getInt("PaymentMethodId"));
					_PaymentFees.setCompanyId(_ResultSet.getInt("CompanyId"));
					_PaymentFees.setStartingAmount(_ResultSet.getDouble("StartingAmount"));
					_PaymentFees.setEndAmount(_ResultSet.getDouble("EndAmount"));
					_PaymentFees.setFees(_ResultSet.getDouble("Fees"));
					_PaymentFees.setFeesType(_ResultSet.getInt("FeesType"));
					_PaymentFees.setPayInAgentId(_ResultSet.getInt("PayInAgentId"));
					_PaymentFees.setIsPayInAgent(_ResultSet.getBoolean("IsPayInAgent"));
					_PaymentFees.setIsPayOutAgent(_ResultSet.getBoolean("IsPayOutAgent"));
					_PaymentFees.setCode(_ResultSet.getString("Code"));
					_PaymentFees.setGobalExchangeRateCode(_ResultSet.getString("GobalExchangeRateCode"));
					_PaymentFees.setSourceCountry(_ResultSet.getInt("SourceCountry"));
					_PaymentFees.setDestinationCountry(_ResultSet.getInt("DestinationCountry"));
					_PaymentFees.setFeesCategoryId(_ResultSet.getInt("FeesCategoryId"));
					_PaymentFees.setPayOutAgentId(_ResultSet.getInt("PayOutAgentId"));
					_PaymentFees.setChargeSendingAmount(_ResultSet.getBoolean("ChargeSendingAmount"));
					_PaymentFees.setCreatedDate(_ResultSet.getString("CreatedDate"));
					_PaymentFees.setIsDeleted(_ResultSet.getBoolean("IsDeleted"));
					_PaymentFees.setDeletedDate(_ResultSet.getString("DeletedDate"));
					_PaymentFees.setTransactionFeeType(_ResultSet.getString("TransactionFeeType"));
					_PaymentFees.setTransactionFeeSharingCode(_ResultSet.getString("TransactionFeeSharingCode"));
					_PaymentFees.setResult("Sucess");
				} else {
					_PaymentFees.setResult("Failed!");
					_PaymentFees.setError("No record found!");
					clear(_PaymentFees);
				}
			}
		} catch (Exception e) {
			clear(_PaymentFees);
		} finally {
			if (_Connection != null) {
				try {
					_Connection.close();
				} catch (SQLException e) {
					clear(_PaymentFees);
				}
			}
		}
		return _PaymentFees;
	}
	public PaymentFees deletePaymentFeesById(PaymentFees _PaymentFees) {

		Connection _Connection = MYSQLConnection.GetConnection();
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		PreparedStatement _PreparedStatement = null;
		try {
			if (_Connection != null) {
				ResultSet _PaymentFessId = _MYSQLHelper.GetResultSet(
						"SELECT * FROM paymentfees where PaymentFessId='" + _PaymentFees.PaymentFessId + "'",
						_Connection);
				if (_PaymentFessId.next()) {
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Calendar cal = Calendar.getInstance();
					String date = format.format(cal.getTime());
					_PaymentFees.setDeletedDate(date);
					_PaymentFees.setIsDeleted((true));
					String sInsertStatement = "UPDATE paymentfees SET 	IsDeleted = ? " + ",DeletedDate = ? "
							+ " WHERE PaymentFessId = ?";
					_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
					_PreparedStatement.setBoolean(1, _PaymentFees.IsDeleted);
					_PreparedStatement.setString(2, _PaymentFees.DeletedDate);
					_PreparedStatement.setInt(3, _PaymentFees.PaymentFessId);
					_PreparedStatement.executeUpdate();
					_PaymentFees.setResult("Sucess");
				} else {
					_PaymentFees.setResult("Failed!");
					_PaymentFees.setError("Invalid payment Fess Id !");
					clear(_PaymentFees);
				}

			} else {
				_PaymentFees.setResult("Failed!");
				_PaymentFees.setError("Error in api backend connectivity !");
				clear(_PaymentFees);
			}
		} catch (Exception e) {
			clear(_PaymentFees);
		} finally {
			if (_Connection != null) {
				try {
					_Connection.close();
					// clear(_PaymentFees);

				} catch (SQLException e) {
					clear(_PaymentFees);
				}
			}
		}
		return _PaymentFees;
	}

	public PaymentFees getPaymentFeesById(PaymentFees _PaymentFees) {
		Connection _Connection = MYSQLConnection.GetConnection();
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		try {
			if (_Connection != null) {
				ResultSet _PaymentFessId = _MYSQLHelper.GetResultSet(
						"SELECT * FROM paymentfees where PaymentFessId='" + _PaymentFees.PaymentFessId + "'",
						_Connection);
				if (_PaymentFessId.next()) {

					_PaymentFees.setPaymentFessId(_PaymentFessId.getInt("PaymentFessId"));
					_PaymentFees.setPaymentMethodId(_PaymentFessId.getInt("PaymentMethodId"));
					_PaymentFees.setCompanyId(_PaymentFessId.getInt("CompanyId"));
					_PaymentFees.setStartingAmount(_PaymentFessId.getDouble("StartingAmount"));
					_PaymentFees.setEndAmount(_PaymentFessId.getDouble("EndAmount"));
					_PaymentFees.setFees(_PaymentFessId.getDouble("Fees"));
					_PaymentFees.setPayInAgentId(_PaymentFessId.getInt("PayInAgentId"));
					_PaymentFees.setIsPayInAgent(_PaymentFessId.getBoolean("IsPayInAgent"));
					_PaymentFees.setIsPayOutAgent(_PaymentFessId.getBoolean("IsPayOutAgent"));
					_PaymentFees.setCode(_PaymentFessId.getString("Code"));
					_PaymentFees.setGobalExchangeRateCode(_PaymentFessId.getString("GobalExchangeRateCode"));
					_PaymentFees.setFeesType(_PaymentFessId.getInt("FeesType"));
					_PaymentFees.setSourceCountry(_PaymentFessId.getInt("SourceCountry"));
					_PaymentFees.setDestinationCountry(_PaymentFessId.getInt("DestinationCountry"));
					_PaymentFees.setFeesCategoryId(_PaymentFessId.getInt("FeesCategoryId"));
					_PaymentFees.setPayOutAgentId(_PaymentFessId.getInt("PayOutAgentId"));
					_PaymentFees.setChargeSendingAmount(_PaymentFessId.getBoolean("ChargeSendingAmount"));
					_PaymentFees.setCreatedDate(_PaymentFessId.getString("CreatedDate"));
					_PaymentFees.setIsDeleted(_PaymentFessId.getBoolean("IsDeleted"));
					_PaymentFees.setDeletedDate(_PaymentFessId.getString("DeletedDate"));
					_PaymentFees.setTransactionFeeType(_PaymentFessId.getString("TransactionFeeType"));
					_PaymentFees.setTransactionFeeSharingCode(_PaymentFessId.getString("TransactionFeeSharingCode"));
					_PaymentFees.setResult("Sucess");
				} else {
					_PaymentFees.setResult("Failed!");
					_PaymentFees.setError("Invalid Payment Fess Id!");
					clear(_PaymentFees);
				}

			} else {
				_PaymentFees.setResult("Failed!");
				_PaymentFees.setError("Error in api backend connectivity !");
				clear(_PaymentFees);
			}
		} catch (Exception e) {

		} finally {
			if (_Connection != null) {
				try {
					_Connection.close();
					// clear(_PaymentFees);

				} catch (SQLException e) {
					clear(_PaymentFees);
				}
			}
		}
		return _PaymentFees;
	}

	
	public static ArrayList<PaymentFees> getPaymentFeesDetailsByPaymentMethod(int PaymentMethodId, int FeesCategoryId) {
		Connection _Connection = MYSQLConnection.GetConnection();

		ArrayList<PaymentFees> _PaymentFeesDetaillist = new ArrayList<PaymentFees>();

		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		try {
			if (_Connection != null)

			{
				
					ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM paymentfees where IsDeleted=0 and PaymentMethodId='"+PaymentMethodId+"'and FeesCategoryId='"+FeesCategoryId+"'",
							_Connection);

					while (_ResultSet.next()) {

						PaymentFees _PaymentFees = new PaymentFees();
						_PaymentFees.setPaymentFessId(_ResultSet.getInt("PaymentFessId"));
						_PaymentFees.setPaymentMethodId(_ResultSet.getInt("PaymentMethodId"));
						_PaymentFees.setCompanyId(_ResultSet.getInt("CompanyId"));
						_PaymentFees.setStartingAmount(_ResultSet.getDouble("StartingAmount"));
						_PaymentFees.setEndAmount(_ResultSet.getDouble("EndAmount"));
						_PaymentFees.setFees(_ResultSet.getDouble("Fees"));
						_PaymentFees.setFeesType(_ResultSet.getInt("FeesType"));
						_PaymentFees.setPayInAgentId(_ResultSet.getInt("PayInAgentId"));
						_PaymentFees.setIsPayInAgent(_ResultSet.getBoolean("IsPayInAgent"));
						_PaymentFees.setIsPayOutAgent(_ResultSet.getBoolean("IsPayOutAgent"));
						_PaymentFees.setCode(_ResultSet.getString("Code"));
						_PaymentFees.setGobalExchangeRateCode(_ResultSet.getString("GobalExchangeRateCode"));
						_PaymentFees.setSourceCountry(_ResultSet.getInt("SourceCountry"));
						_PaymentFees.setDestinationCountry(_ResultSet.getInt("DestinationCountry"));
						_PaymentFees.setFeesCategoryId(_ResultSet.getInt("FeesCategoryId"));
						_PaymentFees.setPayOutAgentId(_ResultSet.getInt("PayOutAgentId"));
						_PaymentFees.setChargeSendingAmount(_ResultSet.getBoolean("ChargeSendingAmount"));
						_PaymentFees.setCreatedDate(_ResultSet.getString("CreatedDate"));
						_PaymentFees.setIsDeleted(_ResultSet.getBoolean("IsDeleted"));
						_PaymentFees.setDeletedDate(_ResultSet.getString("DeletedDate"));
						_PaymentFees.setTransactionFeeType(_ResultSet.getString("TransactionFeeType"));
						_PaymentFees.setTransactionFeeSharingCode(_ResultSet.getString("TransactionFeeSharingCode"));
						_PaymentFees.setResult("Sucess");
						_PaymentFeesDetaillist.add(_PaymentFees);

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

		return _PaymentFeesDetaillist;
	}

	public PaymentFees clear(PaymentFees _PaymentFees) {
		_PaymentFees.setSourceCountry(0);
		_PaymentFees.setDestinationCountry(0);
		_PaymentFees.setPaymentMethodId(0);
		_PaymentFees.setStartingAmount(0);
		_PaymentFees.setEndAmount(0);
		_PaymentFees.setFeesType(0);
		_PaymentFees.setFees(0);
		_PaymentFees.setPayOutAgentId(0);
		_PaymentFees.setTransactionFeeType("");
		_PaymentFees.setGobalExchangeRateCode("");
		_PaymentFees.setTransactionFeeSharingCode("");
		return _PaymentFees;

	}
}
