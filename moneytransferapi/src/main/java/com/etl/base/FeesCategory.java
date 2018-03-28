package com.etl.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.etl.util.MYSQLConnection;
import com.etl.util.MYSQLHelper;

public class FeesCategory {

	public int FeesCategoryId;
	public String FeesCategoryName;
	public String Result;
	public String Error;

	private void setFeesCategoryId(int FeesCategoryId) {
		this.FeesCategoryId = FeesCategoryId;
	}

	private int getFeesCategoryId() {
		return FeesCategoryId;
	}

	private void setFeesCategoryName(String FeesCategoryName) {
		this.FeesCategoryName = FeesCategoryName;
	}

	private String getFeesCategoryName() {
		return FeesCategoryName;
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

	public FeesCategory _getFeesCategoryById(int FeesCategoryId) {
		Connection _Connection = MYSQLConnection.GetConnection();
		FeesCategory _FeesCategory = new FeesCategory();
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		try {
			if (_Connection != null) {

				ResultSet _ResultSet = _MYSQLHelper.GetResultSet(
						"SELECT * FROM feescategory where FeesCategoryId='" + FeesCategoryId + "'",
						_Connection);
				if (_ResultSet.next()) {

					_FeesCategory.setFeesCategoryId(_ResultSet.getInt("FeesCategoryId"));
					_FeesCategory.setFeesCategoryName(_ResultSet.getString("FeesCategoryName"));
					_FeesCategory.setResult("Sucess");
				} else {
					_FeesCategory.setResult("Failed!");
					_FeesCategory.setError("Invalid Fees Category Id !");
					 clear(_FeesCategory);
				}

			} else {
				_FeesCategory.setResult("Failed!");
				_FeesCategory.setError("Error in api backend connectivity !");
				 clear(_FeesCategory);
			}

		} catch (Exception e) {
			 clear(_FeesCategory);
		} finally {
			if (_Connection != null) {
				try {
					_Connection.close();
				} catch (SQLException e) {

				}
			}
		}
		return _FeesCategory;
	}

	public static ArrayList<FeesCategory> _getFeesCategoryDetails() {
		ArrayList<FeesCategory> _FeesCategoryDetaillist = new ArrayList<FeesCategory>();
		Connection _Connection = MYSQLConnection.GetConnection();

		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		try {
			ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM feescategory", _Connection);
			while (_ResultSet.next()) {
				FeesCategory _FeesCategory = new FeesCategory();
				_FeesCategory.setFeesCategoryId(_ResultSet.getInt("FeesCategoryId"));
				_FeesCategory.setFeesCategoryName(_ResultSet.getString("FeesCategoryName"));
				_FeesCategory.setResult("Sucess");
				_FeesCategoryDetaillist.add(_FeesCategory);
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
		return _FeesCategoryDetaillist;
	}

	public FeesCategory clear(FeesCategory _FeesCategory) {

		_FeesCategory.setFeesCategoryId(0);
		_FeesCategory.setFeesCategoryName("");
		return _FeesCategory;
	}
}
