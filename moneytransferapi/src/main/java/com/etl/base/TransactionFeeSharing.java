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

public class TransactionFeeSharing {

	public int TransactionFeeSharingId;
	public int CompanyId;
	public int PaymentMethodId;
	public int SourceCountryId;
	public int DestinationCountryId;
	public String TransactionFeeType;
	public String YourShare;
	public int PayInAgent;
	public String PayInAgentPer;
	public int PayOutAgent;
	public String PayOutAgentPer;
	public String Code;
	public String CreatedDate;
	public boolean IsSpecific;
	public boolean IsDeleted;
	public String DeletedDate;
	public String Result;
	public String Error;
	public String AutoFees;
	public int PaymentFeesId;
	
	private void setTransactionFeeSharingId(int TransactionFeeSharingId) {
		this.TransactionFeeSharingId = TransactionFeeSharingId;
	}

	private int getTransactionFeeSharingId() {
		return TransactionFeeSharingId;
	}

	private void setCompanyId(int CompanyId) {
		this.CompanyId = CompanyId;
	}

	private int getCompanyId() {
		return CompanyId;
	}

	private void setPaymentMethodId(int PaymentMethodId) {
		this.PaymentMethodId = PaymentMethodId;
	}

	private int getPaymentMethodId() {
		return PaymentMethodId;
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

	private void setTransactionFeeType(String TransactionFeeType) {
		this.TransactionFeeType = TransactionFeeType;
	}

	private String getTransactionFeeType() {
		return TransactionFeeType;
	}

	private void setYourShare(String YourShare) {
		this.YourShare = YourShare;
	}

	private String getYourShare() {
		return YourShare;
	}

	private void setPayInAgent(int PayInAgent) {
		this.PayInAgent = PayInAgent;
	}

	private int getPayInAgent() {
		return PayInAgent;
	}

	private void setPayOutAgent(int PayOutAgent) {
		this.PayOutAgent = PayOutAgent;
	}

	private int getPayOutAgent() {
		return PayOutAgent;
	}

	private void setPayInAgentPer(String PayInAgentPer) {
		this.PayInAgentPer = PayInAgentPer;
	}

	private String getPayInAgentPer() {
		return PayInAgentPer;
	}

	private void setPayOutAgentPer(String PayOutAgentPer) {
		this.PayOutAgentPer = PayOutAgentPer;
	}

	private String getPayOutAgentPer() {
		return PayOutAgentPer;
	}

	private void setCreatedDate(String CreatedDate) {
		this.CreatedDate = CreatedDate;
	}

	private String getCreatedDate() {
		return CreatedDate;
	}

	private void setCode(String Code) {
		this.Code = Code;
	}

	private String getCode() {
		return Code;
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

	private void setIsSpecific(Boolean IsSpecific) {
		this.IsSpecific = IsSpecific;
	}

	private Boolean getIsSpecific() {
		return IsSpecific;
	}

	private void setIsDeleted(Boolean IsDeleted) {
		this.IsDeleted = IsDeleted;
	}

	private Boolean getIsDeleted() {
		return IsDeleted;
	}
	private void setPaymentFeesId(int PaymentFeesId) {
		this.PaymentFeesId = PaymentFeesId;
	}

	private int getPaymentFeesId() {
		return PaymentFeesId;
	}
	private void setAutoFees(String AutoFees) {
		this.AutoFees = AutoFees;
	}

	private String getAutoFees() {
		return AutoFees;
	}
	public TransactionFeeSharing addupdateTransactionFeeSharing(TransactionFeeSharing _TransactionFeeSharing) {

		Connection _Connection = MYSQLConnection.GetConnection();
		PreparedStatement _PreparedStatement = null;
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		try {

			if (_Connection != null) {

				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				String date = format.format(cal.getTime());
				_TransactionFeeSharing.setCreatedDate(date);

				ResultSet _Company = _MYSQLHelper.GetResultSet(
						"SELECT * FROM company where Company_Id='" + _TransactionFeeSharing.CompanyId + "'",
						_Connection);
				if (_Company.next()) {

					ResultSet _PayInAgent = _MYSQLHelper.GetResultSet(
							"SELECT * FROM agent where AgentId='" + _TransactionFeeSharing.PayInAgent + "'",
							_Connection);
					if (_PayInAgent.next()) {

						ResultSet _PayOutAgent = _MYSQLHelper.GetResultSet(
								"SELECT * FROM agent where AgentId='" + _TransactionFeeSharing.PayOutAgent + "'",
								_Connection);
						if (_PayOutAgent.next()) {

							ResultSet _SourceCountry = _MYSQLHelper
									.GetResultSet("SELECT * FROM country where country_id='"
											+ _TransactionFeeSharing.SourceCountryId + "'", _Connection);
							if (_SourceCountry.next()) {

								ResultSet _DestinationCountry = _MYSQLHelper
										.GetResultSet("SELECT * FROM country where country_id='"
												+ _TransactionFeeSharing.DestinationCountryId + "'", _Connection);
								if (_DestinationCountry.next()) {

									if (_TransactionFeeSharing.TransactionFeeSharingId <= 0) {

										ResultSet _checkExist = _MYSQLHelper.GetResultSet(

												"SELECT * FROM transactionfeesharing where CompanyId='"
														+ _TransactionFeeSharing.CompanyId + "' and PaymentMethodId='"
														+ _TransactionFeeSharing.PaymentMethodId + "' and YourShare='"
														+ _TransactionFeeSharing.YourShare + "' and PayInAgentPer='"
														+ _TransactionFeeSharing.PayInAgentPer
														+ "' and  PayOutAgentPer='"
														+ _TransactionFeeSharing.PayOutAgentPer
														+ "' and SourceCountryId='"
														+ _TransactionFeeSharing.SourceCountryId + "' and PayInAgent='"
														+ _TransactionFeeSharing.PayInAgent
														+ "' and DestinationCountryId='"
														+ _TransactionFeeSharing.DestinationCountryId
														+ "' and PayOutAgent='" + _TransactionFeeSharing.PayOutAgent
														+ "' and IsDeleted=0",
												_Connection);
										if (!_checkExist.next()) {
											int Resultlastid = _addTransactionFeeSharing(
													_TransactionFeeSharing.CompanyId,
													_TransactionFeeSharing.TransactionFeeType,
													_TransactionFeeSharing.PaymentMethodId,
													_TransactionFeeSharing.YourShare, _TransactionFeeSharing.PayInAgent,
													_TransactionFeeSharing.PayInAgentPer,
													_TransactionFeeSharing.PayOutAgent,
													_TransactionFeeSharing.PayOutAgentPer,
													_TransactionFeeSharing.CreatedDate,
													_TransactionFeeSharing.IsSpecific,
													_TransactionFeeSharing.SourceCountryId,
													_TransactionFeeSharing.DestinationCountryId);
											_TransactionFeeSharing.setTransactionFeeSharingId(Resultlastid);
											_TransactionFeeSharing.setResult("Success");

											String _code = "FLUTSF" + Resultlastid;
											String sUpdateStatement = "UPDATE transactionfeesharing SET Code = ?"
													+ " WHERE TransactionFeeSharingId = ?";
											_PreparedStatement = _Connection.prepareStatement(sUpdateStatement);
											_PreparedStatement.setString(1, _code);
											_PreparedStatement.setInt(2,
													_TransactionFeeSharing.TransactionFeeSharingId);
											_TransactionFeeSharing.setCode(_code);
											_PreparedStatement.executeUpdate();
											clear(_TransactionFeeSharing);
										} else {

											String _Exitscode = _checkExist.getString("Code");
											String _TransactionFeeType = _checkExist.getString("TransactionFeeType");
											_TransactionFeeSharing.setResult("Failed!");
											_TransactionFeeSharing.setError(_TransactionFeeType
													+ " Fee Sharing already under Code " + _Exitscode + " please edit "
													+ _TransactionFeeType + " Fee Sharing Code " + _Exitscode
													+ " for new requirements");
											clear(_TransactionFeeSharing);
										}

									} else {
										ResultSet TransactionFeeSharingId = _MYSQLHelper.GetResultSet(
												"SELECT * FROM transactionfeesharing where TransactionFeeSharingId='"
														+ _TransactionFeeSharing.TransactionFeeSharingId + "'",
												_Connection);
										if (TransactionFeeSharingId.next()) {
											_updateTransactionFeeSharing(_TransactionFeeSharing.TransactionFeeSharingId,
													_TransactionFeeSharing.CompanyId,
													_TransactionFeeSharing.TransactionFeeType,
													_TransactionFeeSharing.PaymentMethodId,
													_TransactionFeeSharing.YourShare, _TransactionFeeSharing.PayInAgent,
													_TransactionFeeSharing.PayInAgentPer,
													_TransactionFeeSharing.PayOutAgent,
													_TransactionFeeSharing.PayOutAgentPer,
													_TransactionFeeSharing.CreatedDate,
													_TransactionFeeSharing.IsSpecific,
													_TransactionFeeSharing.SourceCountryId,
													_TransactionFeeSharing.DestinationCountryId);
											_TransactionFeeSharing.setResult("Success");
											clear(_TransactionFeeSharing);
										} else {
											_TransactionFeeSharing.setResult("Failed!");
											_TransactionFeeSharing.setError("Invalid Transaction Fee SharingId Id!");
											clear(_TransactionFeeSharing);
										}

									}
								}
								else {
									_TransactionFeeSharing.setResult("Failed!");
									_TransactionFeeSharing.setError("Invalid Destination Country Id!");
									clear(_TransactionFeeSharing);
								}


							} else {
								_TransactionFeeSharing.setResult("Failed!");
								_TransactionFeeSharing.setError("Invalid Source Country Id!");
								clear(_TransactionFeeSharing);
							}

						} else {
							_TransactionFeeSharing.setResult("Failed!");
							_TransactionFeeSharing.setError("Invalid PayOutAgent Id!");
							clear(_TransactionFeeSharing);
						}

					} else {
						_TransactionFeeSharing.setResult("Failed!");
						_TransactionFeeSharing.setError("Invalid PayInAgent Id!");
						clear(_TransactionFeeSharing);
					}

				} else {
					_TransactionFeeSharing.setResult("Failed!");
					_TransactionFeeSharing.setError("Invalid Company Id!");
					clear(_TransactionFeeSharing);
				}

			} else {
				_TransactionFeeSharing.setResult("Failed!");
				_TransactionFeeSharing.setError("Error in api backend connectivity !");
				clear(_TransactionFeeSharing);
			}
		} catch (Exception e) {
			_TransactionFeeSharing.setResult("Failed!");
			_TransactionFeeSharing.setError(e.getMessage());
			clear(_TransactionFeeSharing);

		} finally {

		}

		return _TransactionFeeSharing;
	}

	private int _addTransactionFeeSharing(int CompanyId, String TransactionFeeType, int PaymentMethodId,
			String YourShare, int PayInAgent, String PayInAgentPer, int PayOutAgent, String PayOutAgentPer,
			String CreateDate, boolean IsSpecific, int SourceCountryId, int DestinationCountryId) {

		int _result = 0;
		Connection _Connection = MYSQLConnection.GetConnection();
		PreparedStatement _PreparedStatement = null;
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		try {
			String sInsertStatement = "INSERT INTO transactionfeesharing(CompanyId,TransactionFeeType,PaymentMethodId,YourShare,PayInAgent,PayInAgentPer,PayOutAgent,PayOutAgentPer,CreatedDate,IsSpecific,SourceCountryId,DestinationCountryId)";
			sInsertStatement = sInsertStatement + " VALUES(?, ?, ?,?, ?, ?,?,?,?,?,?,?)";
			_PreparedStatement = _Connection.prepareStatement(sInsertStatement);

			_PreparedStatement.setInt(1, CompanyId);
			_PreparedStatement.setString(2, TransactionFeeType);
			_PreparedStatement.setInt(3, PaymentMethodId);
			_PreparedStatement.setString(4, YourShare);
			_PreparedStatement.setInt(5, PayInAgent);
			_PreparedStatement.setString(6, PayInAgentPer);
			_PreparedStatement.setInt(7, PayOutAgent);
			_PreparedStatement.setString(8, PayOutAgentPer);
			_PreparedStatement.setString(9, CreateDate);
			_PreparedStatement.setBoolean(10, IsSpecific);
			_PreparedStatement.setInt(11, SourceCountryId);
			_PreparedStatement.setInt(12, DestinationCountryId);
			_PreparedStatement.executeUpdate();
			ResultSet _TransactionFeeSharingId = _MYSQLHelper.GetResultSet(
					"SELECT MAX(TransactionFeeSharingId) AS TransactionFeeSharingId FROM transactionfeesharing",
					_Connection);
			if (_TransactionFeeSharingId.next()) {
				int lastid = _TransactionFeeSharingId.getInt("TransactionFeeSharingId");
				_result = lastid;

				ResultSet _ResultSet = _MYSQLHelper
						.GetResultSet("SELECT * FROM paymentfees where IsDeleted=0 and CompanyId='" + CompanyId
								+ "' and PaymentMethodId='" + PaymentMethodId + "' and PayInAgentId='" + PayInAgent
								+ "' and PayOutAgentId='" + PayOutAgent + "'", _Connection);
				while (_ResultSet.next()) {
					String sUpdateStatement = "UPDATE paymentfees SET TransactionFeeType = ?"
							+ " WHERE CompanyId = ? and PayInAgentId=? and PayOutAgentId=? and PaymentMethod=?";
					_PreparedStatement = _Connection.prepareStatement(sUpdateStatement);
					_PreparedStatement.setString(1, TransactionFeeType);
					_PreparedStatement.setInt(2, CompanyId);
					_PreparedStatement.setInt(3, PayInAgent);
					_PreparedStatement.setInt(4, PayOutAgent);
					_PreparedStatement.setInt(5, PaymentMethodId);
					_PreparedStatement.executeUpdate();
				}
				_ResultSet.close();

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {

		}

		return _result;
	}

	private int _updateTransactionFeeSharing(int TransactionFeeSharingId, int CompanyId, String TransactionFeeType,
			int PaymentMethodId, String YourShare, int PayInAgent, String PayInAgentPer, int PayOutAgent,
			String PayOutAgentPer, String CreateDate, boolean IsSpecific, int SourceCountryId,
			int DestinationCountryId) {
		int _result = 0;

		Connection _Connection = MYSQLConnection.GetConnection();
		PreparedStatement _PreparedStatement = null;
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();

		try {
			String sInsertStatement = "UPDATE transactionfeesharing SET CompanyId = ?,TransactionFeeType = ? ,PaymentMethodId = ?,YourShare = ?,PayInAgent = ?,PayInAgentPer = ?,PayOutAgent = ?,PayOutAgentPer = ?,CreatedDate=?,IsSpecific=?,SourceCountryId=?,DestinationCountryId=?"
					+ " WHERE TransactionFeeSharingId = ?";
			_PreparedStatement = _Connection.prepareStatement(sInsertStatement);

			_PreparedStatement.setInt(1, CompanyId);
			_PreparedStatement.setString(2, TransactionFeeType);
			_PreparedStatement.setInt(3, PaymentMethodId);
			_PreparedStatement.setString(4, YourShare);
			_PreparedStatement.setInt(5, PayInAgent);
			_PreparedStatement.setString(6, PayInAgentPer);
			_PreparedStatement.setInt(7, PayOutAgent);
			_PreparedStatement.setString(8, PayOutAgentPer);
			_PreparedStatement.setString(9, CreateDate);
			_PreparedStatement.setBoolean(10, IsSpecific);
			_PreparedStatement.setInt(11, SourceCountryId);
			_PreparedStatement.setInt(12, DestinationCountryId);
			_PreparedStatement.setInt(13, TransactionFeeSharingId);
			_PreparedStatement.executeUpdate();

			ResultSet _ResultSet = _MYSQLHelper
					.GetResultSet("SELECT * FROM paymentfees where IsDeleted=0 and CompanyId='" + CompanyId
							+ "' and PaymentMethodId='" + PaymentMethodId + "' and PayInAgentId='" + PayInAgent
							+ "' and PayOutAgentId='" + PayOutAgent + "'", _Connection);
			while (_ResultSet.next()) {
				String sUpdateStatement = "UPDATE paymentfees SET TransactionFeeType = ?"
						+ " WHERE CompanyId = ? and PayInAgentId=? and PayOutAgentId=? and PaymentMethodId=?";
				_PreparedStatement = _Connection.prepareStatement(sUpdateStatement);
				_PreparedStatement.setString(1, TransactionFeeType);
				_PreparedStatement.setInt(2, CompanyId);
				_PreparedStatement.setInt(3, PayInAgent);
				_PreparedStatement.setInt(4, PayOutAgent);
				_PreparedStatement.setInt(5, PaymentMethodId);
				_PreparedStatement.executeUpdate();
			}
			_ResultSet.close();
		} catch (Exception e) {

		} finally {

		}
		return _result;
	}

	public static ArrayList<TransactionFeeSharing> getTransactionFeeSharingDetailsByCompany(int CompanyId) {
		Connection _Connection = MYSQLConnection.GetConnection();

		ArrayList<TransactionFeeSharing> _TransactionFeeSharingDetaillist = new ArrayList<TransactionFeeSharing>();

		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		try {
			if (_Connection != null)

			{
				if (CompanyId == 0) {
					ResultSet _ResultSet = _MYSQLHelper
							.GetResultSet("SELECT * FROM transactionfeesharing where IsDeleted=0", _Connection);

					while (_ResultSet.next()) {

						TransactionFeeSharing _TransactionFeeSharing = new TransactionFeeSharing();
						_TransactionFeeSharing.setTransactionFeeSharingId(_ResultSet.getInt("TransactionFeeSharingId"));
						_TransactionFeeSharing.setPaymentMethodId(_ResultSet.getInt("PaymentMethodId"));

						_TransactionFeeSharing.setSourceCountryId(_ResultSet.getInt("SourceCountryId"));
						_TransactionFeeSharing.setDestinationCountryId(_ResultSet.getInt("DestinationCountryId"));

						_TransactionFeeSharing.setCompanyId(_ResultSet.getInt("CompanyId"));
						_TransactionFeeSharing.setTransactionFeeType(_ResultSet.getString("TransactionFeeType"));
						_TransactionFeeSharing.setYourShare(_ResultSet.getString("YourShare"));
						_TransactionFeeSharing.setPayInAgent(_ResultSet.getInt("PayInAgent"));
						_TransactionFeeSharing.setPayInAgentPer(_ResultSet.getString("PayInAgentPer"));
						_TransactionFeeSharing.setPayOutAgent(_ResultSet.getInt("PayOutAgent"));
						_TransactionFeeSharing.setPayOutAgentPer(_ResultSet.getString("PayOutAgentPer"));
						_TransactionFeeSharing.setCreatedDate(_ResultSet.getString("CreatedDate"));
						_TransactionFeeSharing.setIsDeleted(_ResultSet.getBoolean("IsDeleted"));
						_TransactionFeeSharing.setDeletedDate(_ResultSet.getString("DeletedDate"));
						_TransactionFeeSharing.setIsSpecific(_ResultSet.getBoolean("IsSpecific"));
						_TransactionFeeSharing.setCode(_ResultSet.getString("Code"));
						_TransactionFeeSharing.setAutoFees(_ResultSet.getString("AutoFees"));
						_TransactionFeeSharing.setResult("Sucess");
						_TransactionFeeSharingDetaillist.add(_TransactionFeeSharing);

					}
					_ResultSet.close();
				} else {
					ResultSet _ResultSet = _MYSQLHelper.GetResultSet(
							"SELECT * FROM transactionfeesharing where IsDeleted=0 and CompanyId='" + CompanyId + "'",
							_Connection);

					while (_ResultSet.next()) {

						TransactionFeeSharing _TransactionFeeSharing = new TransactionFeeSharing();
						_TransactionFeeSharing.setTransactionFeeSharingId(_ResultSet.getInt("TransactionFeeSharingId"));
						_TransactionFeeSharing.setPaymentMethodId(_ResultSet.getInt("PaymentMethodId"));
						_TransactionFeeSharing.setSourceCountryId(_ResultSet.getInt("SourceCountryId"));
						_TransactionFeeSharing.setDestinationCountryId(_ResultSet.getInt("DestinationCountryId"));
						_TransactionFeeSharing.setCompanyId(_ResultSet.getInt("CompanyId"));
						_TransactionFeeSharing.setTransactionFeeType(_ResultSet.getString("TransactionFeeType"));
						_TransactionFeeSharing.setYourShare(_ResultSet.getString("YourShare"));
						_TransactionFeeSharing.setPayInAgent(_ResultSet.getInt("PayInAgent"));
						_TransactionFeeSharing.setPayInAgentPer(_ResultSet.getString("PayInAgentPer"));
						_TransactionFeeSharing.setPayOutAgent(_ResultSet.getInt("PayOutAgent"));
						_TransactionFeeSharing.setPayOutAgentPer(_ResultSet.getString("PayOutAgentPer"));
						_TransactionFeeSharing.setCreatedDate(_ResultSet.getString("CreatedDate"));
						_TransactionFeeSharing.setIsDeleted(_ResultSet.getBoolean("IsDeleted"));
						_TransactionFeeSharing.setDeletedDate(_ResultSet.getString("DeletedDate"));
						_TransactionFeeSharing.setIsSpecific(_ResultSet.getBoolean("IsSpecific"));
						_TransactionFeeSharing.setCode(_ResultSet.getString("Code"));
						_TransactionFeeSharing.setAutoFees(_ResultSet.getString("AutoFees"));
						_TransactionFeeSharing.setResult("Sucess");
						_TransactionFeeSharingDetaillist.add(_TransactionFeeSharing);

					}
					_ResultSet.close();
				}

			}

		} catch (Exception e) {
			// System.out.println(e.getMessage());
		} finally {

			if (_Connection != null) {
				try {
					_Connection.close();
				} catch (SQLException e) {

				}
			}
		}

		return _TransactionFeeSharingDetaillist;
	}

	public TransactionFeeSharing gettransactionFeeSharing(int TransactionFeeSharingId) {
		Connection _Connection = MYSQLConnection.GetConnection();
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		TransactionFeeSharing _TransactionFeeSharing = new TransactionFeeSharing();
		try {
			if (_Connection != null) {
				ResultSet _Transaction = _MYSQLHelper
						.GetResultSet("SELECT * FROM transactionfeesharing where TransactionFeeSharingId='"
								+ TransactionFeeSharingId + "'", _Connection);
				if (_Transaction.next()) {

					_TransactionFeeSharing.setTransactionFeeSharingId(_Transaction.getInt("TransactionFeeSharingId"));
					_TransactionFeeSharing.setPaymentMethodId(_Transaction.getInt("PaymentMethodId"));
					_TransactionFeeSharing.setCompanyId(_Transaction.getInt("CompanyId"));
					_TransactionFeeSharing.setTransactionFeeType(_Transaction.getString("TransactionFeeType"));
					_TransactionFeeSharing.setYourShare(_Transaction.getString("YourShare"));
					_TransactionFeeSharing.setPayInAgent(_Transaction.getInt("PayInAgent"));
					_TransactionFeeSharing.setPayInAgentPer(_Transaction.getString("PayInAgentPer"));
					_TransactionFeeSharing.setPayOutAgent(_Transaction.getInt("PayOutAgent"));
					_TransactionFeeSharing.setPayOutAgentPer(_Transaction.getString("PayOutAgentPer"));
					_TransactionFeeSharing.setCreatedDate(_Transaction.getString("CreatedDate"));
					_TransactionFeeSharing.setIsDeleted(_Transaction.getBoolean("IsDeleted"));
					_TransactionFeeSharing.setDeletedDate(_Transaction.getString("DeletedDate"));
					_TransactionFeeSharing.setIsSpecific(_Transaction.getBoolean("IsSpecific"));
					_TransactionFeeSharing.setSourceCountryId(_Transaction.getInt("SourceCountryId"));
					_TransactionFeeSharing.setDestinationCountryId(_Transaction.getInt("DestinationCountryId"));
					_TransactionFeeSharing.setCode(_Transaction.getString("Code"));
					_TransactionFeeSharing.setAutoFees(_Transaction.getString("AutoFees"));

					_TransactionFeeSharing.setResult("Sucess");
				} else {
					_TransactionFeeSharing.setResult("Failed!");
					_TransactionFeeSharing.setError("Invalid Transaction Fee Sharing Id!");
					clear(_TransactionFeeSharing);
				}

			} else {
				_TransactionFeeSharing.setResult("Failed!");
				_TransactionFeeSharing.setError("Error in api backend connectivity !");
				clear(_TransactionFeeSharing);
			}
		} catch (Exception e) {

		} finally {
			if (_Connection != null) {
				try {
					_Connection.close();
					// clear(_PaymentFees);

				} catch (SQLException e) {
					clear(_TransactionFeeSharing);
				}
			}
		}
		return _TransactionFeeSharing;
	}

	public TransactionFeeSharing _updateTransactionFeeSharingEnableDisable(int TransactionFeeSharingId,
			boolean IsSpecific) {
		TransactionFeeSharing _TransactionFeeSharing = new TransactionFeeSharing();

		Connection _Connection = MYSQLConnection.GetConnection();
		PreparedStatement _PreparedStatement = null;
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String date = format.format(cal.getTime());
		_TransactionFeeSharing.setCreatedDate(date);
		try {
			ResultSet _ResultSet = _MYSQLHelper
					.GetResultSet("SELECT * FROM transactionfeesharing where IsDeleted=0 and TransactionFeeSharingId='"
							+ TransactionFeeSharingId + "'", _Connection);
			if (_ResultSet.next()) {
				String sInsertStatement = "UPDATE transactionfeesharing SET CreatedDate=?,IsSpecific=?"
						+ " WHERE TransactionFeeSharingId = ?";
				_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
				_PreparedStatement.setString(1, date);
				_PreparedStatement.setBoolean(2, IsSpecific);
				_PreparedStatement.setInt(3, TransactionFeeSharingId);
				_PreparedStatement.executeUpdate();
				_TransactionFeeSharing.setResult("Success");
				_TransactionFeeSharing.setTransactionFeeSharingId(TransactionFeeSharingId);
				_TransactionFeeSharing.setIsSpecific(IsSpecific);
				clear(_TransactionFeeSharing);
			} else {
				_TransactionFeeSharing.setResult("Failed");
				_TransactionFeeSharing.setError("Invalid Transaction Fee Sharing Id!");
			}

		} catch (Exception e) {
			clear(_TransactionFeeSharing);
		} finally {
			clear(_TransactionFeeSharing);
		}
		return _TransactionFeeSharing;
	}

	public TransactionFeeSharing deletetransactionFeeSharingById(TransactionFeeSharing _TransactionFeeSharing) {

		Connection _Connection = MYSQLConnection.GetConnection();
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		PreparedStatement _PreparedStatement = null;
		try {
			if (_Connection != null) {
				ResultSet _PaymentFessId = _MYSQLHelper
						.GetResultSet("SELECT * FROM transactionfeesharing where TransactionFeeSharingId='"
								+ _TransactionFeeSharing.TransactionFeeSharingId + "'", _Connection);
				if (_PaymentFessId.next()) {
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Calendar cal = Calendar.getInstance();
					String date = format.format(cal.getTime());
					_TransactionFeeSharing.setDeletedDate(date);
					_TransactionFeeSharing.setIsDeleted((true));
					String sInsertStatement = "UPDATE transactionfeesharing SET IsDeleted = ? " + ",DeletedDate = ? "
							+ " WHERE TransactionFeeSharingId = ?";
					_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
					_PreparedStatement.setBoolean(1, _TransactionFeeSharing.IsDeleted);
					_PreparedStatement.setString(2, _TransactionFeeSharing.DeletedDate);
					_PreparedStatement.setInt(3, _TransactionFeeSharing.TransactionFeeSharingId);
					_PreparedStatement.executeUpdate();
					_TransactionFeeSharing.setResult("Sucess");
				} else {
					_TransactionFeeSharing.setResult("Failed!");
					_TransactionFeeSharing.setError("Invalid Transaction Fee Sharing Id!");
					clear(_TransactionFeeSharing);
				}

			} else {
				_TransactionFeeSharing.setResult("Failed!");
				_TransactionFeeSharing.setError("Error in api backend connectivity !");
				clear(_TransactionFeeSharing);
			}
		} catch (Exception e) {
			clear(_TransactionFeeSharing);
		} finally {
			if (_Connection != null) {
				try {
					_Connection.close();
					// clear(_PaymentFees);

				} catch (SQLException e) {
					clear(_TransactionFeeSharing);
				}
			}
		}
		return _TransactionFeeSharing;
	}

	
	public TransactionFeeSharing _updateTransactionFeeSharing(int TransactionFeeSharingId, String AutoFees, int PaymentFessId) {
		TransactionFeeSharing _TransactionFeeSharing = new TransactionFeeSharing();
		Connection _Connection = MYSQLConnection.GetConnection();
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		PreparedStatement _PreparedStatement = null;
		try {
			
			if (_Connection != null) {
				ResultSet _transactionfeesharing = _MYSQLHelper
						.GetResultSet("SELECT * FROM transactionfeesharing where TransactionFeeSharingId='" + TransactionFeeSharingId
								+ "' and IsDeleted=0", _Connection);
				if (_transactionfeesharing.next()) {
					String supdateStatement = "UPDATE transactionfeesharing SET AutoFees = ? " + " WHERE TransactionFeeSharingId = ?";
					_PreparedStatement = _Connection.prepareStatement(supdateStatement);
					_PreparedStatement.setString(1, AutoFees);					
					_PreparedStatement.setInt(2, TransactionFeeSharingId);
					_PreparedStatement.executeUpdate();
					_TransactionFeeSharing.setResult("Sucess");
					_TransactionFeeSharing.setTransactionFeeSharingId(TransactionFeeSharingId);
					
					//Update Fees Sharing Code into paymnet fees table
					String supdateStatementpaymentfees = "UPDATE paymentfees SET TransactionFeeSharingCode= ? " + " WHERE PaymentFessId = ?";
					_PreparedStatement = _Connection.prepareStatement(supdateStatementpaymentfees);
					_PreparedStatement.setString(1, _transactionfeesharing.getString("Code"));					
					_PreparedStatement.setInt(2, PaymentFessId);
					_PreparedStatement.executeUpdate();					
					clear(_TransactionFeeSharing);
				}
				else{
					_TransactionFeeSharing.setResult("Failed!");
					_TransactionFeeSharing.setError("Invalid Transaction Fee Sharing Id !");
					clear(_TransactionFeeSharing);
				}
			}
			else
			{
				
			}
			

		} catch (Exception e) {

		} finally {
			if (_Connection != null) {
				try {
					_Connection.close();
				} catch (SQLException e) {
					clear(_TransactionFeeSharing);
				}
			}
		}
		return _TransactionFeeSharing;
	}

	private TransactionFeeSharing clear(TransactionFeeSharing _TransactionFeeSharing) {
		_TransactionFeeSharing.setCompanyId(0);
		_TransactionFeeSharing.setPaymentMethodId(0);
		_TransactionFeeSharing.setPayInAgent(0);
		_TransactionFeeSharing.setPayInAgentPer("");
		_TransactionFeeSharing.setPayOutAgent(0);
		_TransactionFeeSharing.setPayOutAgentPer("");
		_TransactionFeeSharing.setTransactionFeeType("");
		_TransactionFeeSharing.setYourShare("");
		_TransactionFeeSharing.setCode("");
		_TransactionFeeSharing.setSourceCountryId(0);
		_TransactionFeeSharing.setDestinationCountryId(0);
		_TransactionFeeSharing.setAutoFees("");
		return _TransactionFeeSharing;
	}
}
