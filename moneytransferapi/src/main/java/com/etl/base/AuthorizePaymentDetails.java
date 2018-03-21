package com.etl.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.etl.util.MYSQLConnection;
import com.etl.util.MYSQLHelper;

public class AuthorizePaymentDetails {

	public int AuthorizePaymentSettingsId;
	public int PaymentMethodId;
	public String Mode;
	public String PaymentUrl;
	public String MerchantLoginId;
	public String MerchantTransactionKey;
	public String Server;
	public String Port;
	public boolean IsActive;
	public boolean IsDeleted;
	public String CreatedDate;
	public String DeletedDate;
	public String Result;
	public String Error;
	public int PaymentTypeId;
	
	
	
	private void setAuthorizePaymentSettingsId(int AuthorizePaymentSettingsId){
		this.AuthorizePaymentSettingsId = AuthorizePaymentSettingsId;
	}	
	private int getAuthorizePaymentSettingsId(){
		return AuthorizePaymentSettingsId;
	}
	private void setPaymentMethodId(int PaymentMethodId){
		this.PaymentMethodId = PaymentMethodId;
	}	
	private int getPaymentMethodId(){
		return PaymentMethodId;
	}
	private void setMode(String Mode){
		this.Mode = Mode;
	}	
	private String getMode(){
		return Mode;
	}
	
	private void setPaymentUrl(String PaymentUrl){
		this.PaymentUrl = PaymentUrl;
	}	
	private String getPaymentUrl(){
		return PaymentUrl;
	}
	private void setMerchantLoginId(String MerchantLoginId){
		this.MerchantLoginId = MerchantLoginId;
	}	
	private String getMerchantLoginId(){
		return MerchantLoginId;
	}
	
	private void setMerchantTransactionKey(String MerchantTransactionKey){
		this.MerchantTransactionKey = MerchantTransactionKey;
	}	
	private String getMerchantTransactionKey(){
		return MerchantTransactionKey;
	}
	
	private void setIsActive(boolean IsActive){
		this.IsActive = IsActive;
	}	
	private boolean getIsActive(){
		return IsActive;
	}
	private void setIsDeleted(boolean IsDeleted){
		this.IsDeleted = IsDeleted;
	}	
	private boolean getIsDeleted(){
		return IsDeleted;
	}
	
	private void setCreatedDate(String CreatedDate){
		this.CreatedDate = CreatedDate;
	}	
	private String getCreatedDate(){
		return CreatedDate;
	}
	private void setDeletedDate(String DeletedDate){
		this.DeletedDate = DeletedDate;
	}	
	private String getDeletedDate(){
		return DeletedDate;
	}
	private void setResult(String Result){
		this.Result = Result;
	}	
	private String getResult(){
		return Result;
	}
	private void setError(String Error){
		this.Error = Error;
	}	
	private String getError(){
		return Error;
	}
	
	private void setServer(String Server){
		this.Server = Server;
	}	
	private String getServer(){
		return Server;
	}
	private void setPort(String Port){
		this.Port = Port;
	}	
	private String getPort(){
		return Port;
	}
	
	
	private void setPaymentTypeId(int PaymentTypeId){
		this.PaymentTypeId = PaymentTypeId;
	}	
	private int getPaymentTypeId(){
		return PaymentTypeId;
	}
public AuthorizePaymentDetails addAuthorizePayment(AuthorizePaymentDetails _AuthorizePaymentDetails) {
		
		Connection _Connection = MYSQLConnection.GetConnection();
		 PreparedStatement _PreparedStatement = null;
			try
			{
				MYSQLHelper _MYSQLHelper = new MYSQLHelper();
				if(_Connection!=null)
				{
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Calendar cal = Calendar.getInstance();
					String date=format.format(cal.getTime());
					_AuthorizePaymentDetails.setCreatedDate(date);
					if(_AuthorizePaymentDetails.AuthorizePaymentSettingsId <=0)
					{
						String ss=("SELECT PaymentMethodId FROM paymentmethod where PaymentMethodId='"+_AuthorizePaymentDetails.PaymentMethodId+"'");
						ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT PaymentMethodId FROM paymentmethod where PaymentMethodId='"+_AuthorizePaymentDetails.PaymentMethodId+"'",_Connection);
						if (_ResultSet.next())
						{
							String sInsertStatement = "INSERT INTO authorizepaymentsettings( PaymentMethodId, Mode, PaymentUrl,MerchantLoginId,MerchantTransactionKey,Server,Port,IsActive,CreatedDate)";
							 sInsertStatement = sInsertStatement + " VALUES(?, ?, ?,?, ?, ?,?,?,?)";
							  _PreparedStatement = _Connection.prepareStatement(sInsertStatement);
								_PreparedStatement.setInt(1, _AuthorizePaymentDetails.PaymentMethodId);							
								_PreparedStatement.setString(2, _AuthorizePaymentDetails.Mode); 
								_PreparedStatement.setString(3, _AuthorizePaymentDetails.PaymentUrl); 
								_PreparedStatement.setString(4, _AuthorizePaymentDetails.MerchantLoginId); 
								_PreparedStatement.setString(5, _AuthorizePaymentDetails.MerchantTransactionKey); 
								_PreparedStatement.setString(6, _AuthorizePaymentDetails.Server); 
								_PreparedStatement.setString(7, _AuthorizePaymentDetails.Port); 
								
								_PreparedStatement.setBoolean(8, _AuthorizePaymentDetails.IsActive); 
								_PreparedStatement.setString(9, _AuthorizePaymentDetails.CreatedDate); 
								_PreparedStatement.executeUpdate();
								_AuthorizePaymentDetails.setResult("Sucess");
								ResultSet _ResultSetld = _MYSQLHelper.GetResultSet("SELECT MAX(AuthorizePaymentSettingsId) AS AuthorizePaymentSettingsId FROM authorizepaymentsettings",_Connection);
								if (_ResultSetld.next()){
								int lastid = _ResultSetld.getInt("AuthorizePaymentSettingsId");								
								_AuthorizePaymentDetails.setAuthorizePaymentSettingsId(lastid);}						
							 
						}
						else
						{
							_AuthorizePaymentDetails.setResult("Failed!");
							_AuthorizePaymentDetails.setError("Invalid Payment Method Id!");
						}
					}
					else
					{
						
						ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT AuthorizePaymentSettingsId FROM authorizepaymentsettings where AuthorizePaymentSettingsId='"+_AuthorizePaymentDetails.AuthorizePaymentSettingsId+"'",_Connection);
						if (_ResultSet.next())
						{
							ResultSet _ResultSetPaymentMethod = _MYSQLHelper.GetResultSet("SELECT PaymentMethodId FROM paymentmethod where PaymentMethodId='"+_AuthorizePaymentDetails.PaymentMethodId+"'",_Connection);
							if (_ResultSetPaymentMethod.next())
							{
								String sInsertStatement ="UPDATE authorizepaymentsettings SET 	PaymentMethodId = ?,Mode = ? ,PaymentUrl =?,MerchantLoginId = ? ,MerchantTransactionKey =?,Server =?,Port =?,IsActive = ?,CreatedDate = ? "+ " WHERE AuthorizePaymentSettingsId = ?";
								_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
								_PreparedStatement.setInt(1, _AuthorizePaymentDetails.PaymentMethodId);							
								_PreparedStatement.setString(2, _AuthorizePaymentDetails.Mode);
								_PreparedStatement.setString(3, _AuthorizePaymentDetails.PaymentUrl);
								_PreparedStatement.setString(4, _AuthorizePaymentDetails.MerchantLoginId);
								_PreparedStatement.setString(5, _AuthorizePaymentDetails.MerchantTransactionKey);
								
								_PreparedStatement.setString(6, _AuthorizePaymentDetails.Server);
								_PreparedStatement.setString(7, _AuthorizePaymentDetails.Port);
								_PreparedStatement.setBoolean(8, _AuthorizePaymentDetails.IsActive);
								_PreparedStatement.setString(9, _AuthorizePaymentDetails.CreatedDate);
								_PreparedStatement.setInt(10, _AuthorizePaymentDetails.AuthorizePaymentSettingsId);
								_PreparedStatement.executeUpdate();
								_AuthorizePaymentDetails.setResult("Sucess");
						         clear(_AuthorizePaymentDetails);
							}
							else
							{
								_AuthorizePaymentDetails.setResult("Failed!");
								_AuthorizePaymentDetails.setError("Invalid Payment Method Id!");
							}
							
						}
						else
						{
							_AuthorizePaymentDetails.setResult("Failed!");
							_AuthorizePaymentDetails.setError("Invalid Authorize Payment Settings Id!");
						}
					}
					
				}
				else{
					_AuthorizePaymentDetails.setResult("Failed!");
					_AuthorizePaymentDetails.setError("Error in api backend connectivity !");
					clear(_AuthorizePaymentDetails);
				}
			}
			catch (Exception e) {
				clear(_AuthorizePaymentDetails);
			}
			finally {
				if (_Connection != null) {
					try {
						_Connection.close();
						clear(_AuthorizePaymentDetails);
						
					} catch (SQLException e) {
						clear(_AuthorizePaymentDetails);
					}
				}
			}
			
       return _AuthorizePaymentDetails;
}


public AuthorizePaymentDetails getAuthorizePaymentById(AuthorizePaymentDetails _AuthorizePaymentDetails) {
	
	Connection _Connection = MYSQLConnection.GetConnection();	
		try
		{
			MYSQLHelper _MYSQLHelper = new MYSQLHelper();
			if(_Connection!=null)
			{
				ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM authorizepaymentsettings where AuthorizePaymentSettingsId='"+_AuthorizePaymentDetails.AuthorizePaymentSettingsId+"'",_Connection);
				if (_ResultSet.next())
				{
					
					_AuthorizePaymentDetails.setAuthorizePaymentSettingsId(_ResultSet.getInt("AuthorizePaymentSettingsId"));
					_AuthorizePaymentDetails.setPaymentMethodId(_ResultSet.getInt("PaymentMethodId"));
					_AuthorizePaymentDetails.setMode(_ResultSet.getString("Mode"));
					_AuthorizePaymentDetails.setPaymentUrl(_ResultSet.getString("PaymentUrl"));
					_AuthorizePaymentDetails.setMerchantLoginId(_ResultSet.getString("MerchantLoginId"));
					_AuthorizePaymentDetails.setMerchantTransactionKey(_ResultSet.getString("MerchantTransactionKey"));
					_AuthorizePaymentDetails.setServer(_ResultSet.getString("Server"));
					_AuthorizePaymentDetails.setPort(_ResultSet.getString("Port"));
					_AuthorizePaymentDetails.setIsActive(_ResultSet.getBoolean("IsActive"));
					_AuthorizePaymentDetails.setIsDeleted(_ResultSet.getBoolean("IsDeleted"));
					_AuthorizePaymentDetails.setCreatedDate(_ResultSet.getString("CreatedDate"));
					_AuthorizePaymentDetails.setDeletedDate(_ResultSet.getString("DeletedDate"));
					_AuthorizePaymentDetails.setResult("Sucess");
				}
				else
				{
					_AuthorizePaymentDetails.setResult("Failed!");
					_AuthorizePaymentDetails.setError("Invalid Authorize Payment Settings Id!");
					clear(_AuthorizePaymentDetails);
				}
			}
			else{
				_AuthorizePaymentDetails.setResult("Failed!");
				_AuthorizePaymentDetails.setError("Error in api backend connectivity !");
				clear(_AuthorizePaymentDetails);
			}
		}
		catch (Exception e) {
			clear(_AuthorizePaymentDetails);
		}
		finally {
			if (_Connection != null) {
				try {
					_Connection.close();
					
					
				} catch (SQLException e) {
					
				}
			}
		}
		return _AuthorizePaymentDetails;
}

public AuthorizePaymentDetails deleteAuthorizePaymentById(AuthorizePaymentDetails _AuthorizePaymentDetails) {
	
	Connection _Connection = MYSQLConnection.GetConnection();	
		try
		{
			MYSQLHelper _MYSQLHelper = new MYSQLHelper();			
			PreparedStatement _PreparedStatement = null;
			if(_Connection!=null)
			{
				ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM authorizepaymentsettings where AuthorizePaymentSettingsId='"+_AuthorizePaymentDetails.AuthorizePaymentSettingsId+"'",_Connection);
				if (_ResultSet.next())
				{
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Calendar cal = Calendar.getInstance();
					String date=format.format(cal.getTime());
					_AuthorizePaymentDetails.setDeletedDate(date);
					_AuthorizePaymentDetails.setIsDeleted((true));
					String sInsertStatement ="UPDATE authorizepaymentsettings SET 	IsDeleted = ? "+ ",DeletedDate = ? "+ " WHERE AuthorizePaymentSettingsId = ?";
					_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
					_PreparedStatement.setBoolean(1, _AuthorizePaymentDetails.IsDeleted);
					_PreparedStatement.setString(2,_AuthorizePaymentDetails.DeletedDate);
					_PreparedStatement.setInt(3, _AuthorizePaymentDetails.AuthorizePaymentSettingsId);	
					_PreparedStatement.executeUpdate();
					_AuthorizePaymentDetails.setResult("Sucess");
				}
				else
				{
					_AuthorizePaymentDetails.setResult("Failed!");
					_AuthorizePaymentDetails.setError("Invalid Authorize Payment Settings Id!");
					clear(_AuthorizePaymentDetails);
				}
			}
			else{
				_AuthorizePaymentDetails.setResult("Failed!");
				_AuthorizePaymentDetails.setError("Error in api backend connectivity !");
				clear(_AuthorizePaymentDetails);
			}
		}
		catch (Exception e) {
			clear(_AuthorizePaymentDetails);
		}
		finally {
			if (_Connection != null) {
				try {
					_Connection.close();
					
					
				} catch (SQLException e) {
					clear(_AuthorizePaymentDetails);
				}
			}
		}
		return _AuthorizePaymentDetails;
}

public AuthorizePaymentDetails getAuthorizePaymentDetailsbyPaymentMethodId(AuthorizePaymentDetails _AuthorizePaymentDetails) {
	Connection _Connection = MYSQLConnection.GetConnection();	
	try
	{
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();		
		
		if(_Connection!=null)
		{
			ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM paymentmethod where PaymentMethodId='"+_AuthorizePaymentDetails.PaymentMethodId+"'",_Connection);
			if (_ResultSet.next())
			{
				_AuthorizePaymentDetails.setPaymentTypeId(_ResultSet.getInt("PaymentTypeId"));
				ResultSet _ResultSetPaymentSettingDetails = _MYSQLHelper.GetResultSet("SELECT * FROM authorizepaymentsettings where PaymentMethodId='"+_AuthorizePaymentDetails.PaymentMethodId+"'",_Connection);
				if (_ResultSetPaymentSettingDetails.next())
				{
					_AuthorizePaymentDetails.setAuthorizePaymentSettingsId(_ResultSetPaymentSettingDetails.getInt("AuthorizePaymentSettingsId"));
					_AuthorizePaymentDetails.setPaymentMethodId(_ResultSetPaymentSettingDetails.getInt("PaymentMethodId"));
					_AuthorizePaymentDetails.setMode(_ResultSetPaymentSettingDetails.getString("Mode"));
					_AuthorizePaymentDetails.setPaymentUrl(_ResultSetPaymentSettingDetails.getString("PaymentUrl"));
					_AuthorizePaymentDetails.setMerchantLoginId(_ResultSetPaymentSettingDetails.getString("MerchantLoginId"));
					_AuthorizePaymentDetails.setMerchantTransactionKey(_ResultSetPaymentSettingDetails.getString("MerchantTransactionKey"));
					_AuthorizePaymentDetails.setServer(_ResultSetPaymentSettingDetails.getString("Server"));
					_AuthorizePaymentDetails.setPort(_ResultSetPaymentSettingDetails.getString("Port"));
					_AuthorizePaymentDetails.setIsActive(_ResultSetPaymentSettingDetails.getBoolean("IsActive"));
					_AuthorizePaymentDetails.setIsDeleted(_ResultSetPaymentSettingDetails.getBoolean("IsDeleted"));
					_AuthorizePaymentDetails.setCreatedDate(_ResultSetPaymentSettingDetails.getString("CreatedDate"));
					_AuthorizePaymentDetails.setDeletedDate(_ResultSetPaymentSettingDetails.getString("DeletedDate"));
					
					
					_AuthorizePaymentDetails.setResult("Sucess");
				}
				else
				{
					_AuthorizePaymentDetails.setResult("Failed!");
					_AuthorizePaymentDetails.setError("No payment setting found for this Payment Method Id!");
					clear(_AuthorizePaymentDetails);
				}
			}
			else
			{
				_AuthorizePaymentDetails.setResult("Failed!");
				_AuthorizePaymentDetails.setError("Invalid Payment method Id!");
				clear(_AuthorizePaymentDetails);
			}
		}
		else{
			_AuthorizePaymentDetails.setResult("Failed!");
			_AuthorizePaymentDetails.setError("Error in api backend connectivity !");
			clear(_AuthorizePaymentDetails);
		}
	}
	catch (Exception e) {
		_AuthorizePaymentDetails.setError(e.getMessage() + " Stack Trace: " + e.getStackTrace());
	}
	finally {
		if (_Connection != null) {
			try {
				_Connection.close();
				
				
			} catch (SQLException e) {
				clear(_AuthorizePaymentDetails);
			}
		}
	}
	return _AuthorizePaymentDetails;
}

public AuthorizePaymentDetails clear(AuthorizePaymentDetails _AuthorizePaymentDetails) {
	_AuthorizePaymentDetails.setMerchantLoginId("");
	_AuthorizePaymentDetails.setMode("");
	_AuthorizePaymentDetails.setPaymentMethodId(0);
	_AuthorizePaymentDetails.setPaymentUrl("");	
	_AuthorizePaymentDetails.setMerchantTransactionKey("");	
	//_AuthorizePaymentDetails.setServer("");
	//_AuthorizePaymentDetails.setPort("");
	return _AuthorizePaymentDetails;
	
}
}
