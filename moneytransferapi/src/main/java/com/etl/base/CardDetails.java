package com.etl.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.etl.util.MYSQLConnection;
import com.etl.util.MYSQLHelper;

public class CardDetails {

	public int CardId;
	public int CustomerId;
	public int CompanyId;
	public String CardNumber;
	public String ExpMonthYear;
	public String CardType;
	public String CreatedDate;
	public String Result;
	public String Error;
	
	private void setCardId(int CardId) {
		this.CardId = CardId;
	}

	private int getCardId() {
		return CardId;
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
	
	private void setCardNumber(String CardNumber) {
		this.CardNumber = CardNumber;
	}

	private String getCardNumber() {
		return CardNumber;
	}
	private void setExpMonthYear(String ExpMonthYear) {
		this.ExpMonthYear = ExpMonthYear;
	}

	private String getExpMonthYear() {
		return ExpMonthYear;
	}
	private void setCardType(String CardType) {
		this.CardType = CardType;
	}

	private String getCardType() {
		return CardType;
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
	
	
	public CardDetails Addcard(CardDetails _CardDetails) {
		
		Connection _Connection = MYSQLConnection.GetConnection();
	
		try {
			MYSQLHelper _MYSQLHelper = new MYSQLHelper();
			if (_Connection != null) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				String date = format.format(cal.getTime());
				_CardDetails.setCreatedDate(date);
				if (_CardDetails.CardId <= 0) {
					
					int Cardlastid = addcard(_CardDetails);
					_CardDetails.setResult("Success");
					_CardDetails.setCardId(Cardlastid);
				}
				else{
					ResultSet _ResultCard = _MYSQLHelper.GetResultSet(
							"SELECT CardId FROM cardsdetails where CardId='" + _CardDetails.CardId + "'",
							_Connection);
					if (_ResultCard.next()) {
						updateCard(_CardDetails);
						_CardDetails.setResult("Success");
					}
					else{
						_CardDetails.setResult("Failed!");
						_CardDetails.setError("Invalid CardId!");
					}
					
				}
			}
			else {
				_CardDetails.setResult("Failed!");
				_CardDetails.setError("Error in api backend connectivity !");

			}	
		}
		catch (Exception e) {
			
		}
		finally {
			
		}
		return _CardDetails;
	}
	
	
	public int addcard(CardDetails _CardDetails) {
		int Result = 0;

		Connection _Connection = MYSQLConnection.GetConnection();
		try {
			
			PreparedStatement _PreparedStatement = null;
			MYSQLHelper _MYSQLHelper = new MYSQLHelper();
			String sInsertStatement = "INSERT INTO cardsdetails( CustomerId,CompanyId,CardNumber,ExpMonthYear, CardType,CreatedDate)";
			sInsertStatement = sInsertStatement + " VALUES(?, ?, ?,?, ?,?)";
			_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
			_PreparedStatement.setInt(1, _CardDetails.CustomerId);
			_PreparedStatement.setInt(2, _CardDetails.CompanyId);
			
			_PreparedStatement.setString(3, _CardDetails.CardNumber);
			_PreparedStatement.setString(4, _CardDetails.ExpMonthYear);
			_PreparedStatement.setString(5, _CardDetails.CardType);
			_PreparedStatement.setString(6, _CardDetails.CreatedDate);
			_PreparedStatement.executeUpdate();
			ResultSet _ResultSetbillpayld = _MYSQLHelper.GetResultSet("SELECT MAX(CardId) AS CardId FROM cardsdetails",
					_Connection);
			if (_ResultSetbillpayld.next()) {
				int lastid = _ResultSetbillpayld.getInt("CardId");
				Result = lastid;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			
		}
		return Result;
	}
	
	public void updateCard(CardDetails _CardDetails) {

		Connection _Connection = MYSQLConnection.GetConnection();
		try {
			PreparedStatement _PreparedStatement = null;

			String sInsertStatement = "UPDATE cardsdetails SET CustomerId = ?,CompanyId = ?,CardNumber = ?,ExpMonthYear = ?,CardType = ? ,CreatedDate =?"
					+ " WHERE CardId = ?";
			_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
			_PreparedStatement.setInt(1, _CardDetails.CustomerId);
			_PreparedStatement.setInt(2, _CardDetails.CompanyId);	
			_PreparedStatement.setString(3, _CardDetails.CardNumber);
			_PreparedStatement.setString(4, _CardDetails.ExpMonthYear);
			_PreparedStatement.setString(5, _CardDetails.CardType);
			_PreparedStatement.setString(6, _CardDetails.CreatedDate);
			_PreparedStatement.setInt(7, _CardDetails.CardId);
			_PreparedStatement.executeUpdate();
			_CardDetails.setResult("Sucess");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static String cardtype(String CardNo)
	{
		String _cardType="";
		
		
		return _cardType;
	
	}
}
