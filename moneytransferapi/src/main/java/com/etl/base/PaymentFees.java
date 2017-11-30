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
	public int CountryId;
	public double StartingAmount;
	public double EndAmount;
	public int FeesType;
	public double Fees;
	
	public int DestinationCountry;
	public int FeesCategoryId;
	public int AgentId;	
	public String CreatedDate;
	public boolean ChargeSendingAmount;
	
	public boolean IsDeleted;
	public String DeletedDate;
	public String Result;
	public String Error;
	
	private void setPaymentFessId(int PaymentFessId){
		this.PaymentFessId = PaymentFessId;
	}	
	private int getPaymentFessId(){
		return PaymentFessId;
	}
	private void setPaymentMethodId(int PaymentMethodId){
		this.PaymentMethodId = PaymentMethodId;
	}	
	private int getPaymentMethodId(){
		return PaymentMethodId;
	}
	private void setCountryId(int CountryId){
		this.CountryId = CountryId;
	}	
	private int getCountryId(){
		return CountryId;
	}
	
	private void setStartingAmount(double StartingAmount){
		this.StartingAmount = StartingAmount;
	}	
	private double getStartingAmount(){
		return StartingAmount;
	}
	
	private void setEndAmount(double EndAmount){
		this.EndAmount = EndAmount;
	}	
	private double getEndAmount(){
		return EndAmount;
	}
	
	private void setFeesType(int FeesType){
		this.FeesType = FeesType;
	}	
	private int getFeesType(){
		return FeesType;
	}
	
	
	private void setDestinationCountry(int DestinationCountry){
		this.DestinationCountry = DestinationCountry;
	}	
	private int getDestinationCountry(){
		return DestinationCountry;
	}
	private void setFeesCategoryId(int FeesCategoryId){
		this.FeesCategoryId = FeesCategoryId;
	}	
	private int getFeesCategoryId(){
		return FeesCategoryId;
	}
	private void setAgentId(int AgentId){
		this.AgentId = AgentId;
	}	
	private int getAgentId(){
		return AgentId;
	}
	
	private void setFees(double Fees){
		this.Fees = Fees;
	}	
	private double getFees(){
		return Fees;
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
	
	private void setIsDeleted(Boolean IsDeleted){
		this.IsDeleted = IsDeleted;
	}	
	private Boolean getIsDeleted(){
		return IsDeleted;
	}
	
	private void setChargeSendingAmount(Boolean ChargeSendingAmount){
		this.ChargeSendingAmount = ChargeSendingAmount;
	}	
	private Boolean getChargeSendingAmount(){
		return ChargeSendingAmount;
	}
	
	public PaymentFees addPaymentFees(PaymentFees _PaymentFees) {
		Connection _Connection = MYSQLConnection.GetConnection();
		 PreparedStatement _PreparedStatement = null;
		 MYSQLHelper _MYSQLHelper = new MYSQLHelper();
			try
			{
				if(_Connection!=null)
				{
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Calendar cal = Calendar.getInstance();
					String date=format.format(cal.getTime());
					_PaymentFees.setCreatedDate(date);
					ResultSet _ResultSetPaymentMethod = _MYSQLHelper.GetResultSet("SELECT * FROM paymentmethod where PaymentMethodId='"+_PaymentFees.PaymentMethodId+"'",_Connection);
					if (_ResultSetPaymentMethod.next())
					{
						ResultSet _Country = _MYSQLHelper.GetResultSet("SELECT * FROM currency where country_id='"+_PaymentFees.CountryId+"'",_Connection);
						if (_Country.next())
						{
							ResultSet _destinationCountry = _MYSQLHelper.GetResultSet("SELECT * FROM currency where country_id='"+_PaymentFees.DestinationCountry+"'",_Connection);
							if (_destinationCountry.next())
							{
								ResultSet _feesCategoryId = _MYSQLHelper.GetResultSet("SELECT * FROM feescategory where FeesCategoryId='"+_PaymentFees.FeesCategoryId+"'",_Connection);
								if (_feesCategoryId.next())
								{
									ResultSet _agentId = _MYSQLHelper.GetResultSet("SELECT * FROM agent where AgentId='"+_PaymentFees.AgentId+"'",_Connection);
									if (_agentId.next())
									{
										
										if(_PaymentFees.PaymentFessId <=0)
										{
											
																String sInsertStatement = "INSERT INTO paymentfees( PaymentMethodId, country_id,DestinationCountry,FeesCategoryId,AgentId,StartingAmount,EndAmount,FeesType,Fees,ChargeSendingAmount,CreatedDate)";
																 sInsertStatement = sInsertStatement + " VALUES(?, ?, ?,?, ?, ?,?,?,?,?,?)";
																  _PreparedStatement = _Connection.prepareStatement(sInsertStatement);
																	_PreparedStatement.setInt(1, _PaymentFees.PaymentMethodId);							
																	_PreparedStatement.setInt(2, _PaymentFees.CountryId);
																	_PreparedStatement.setInt(3, _PaymentFees.DestinationCountry);
																	_PreparedStatement.setInt(4, _PaymentFees.FeesCategoryId);
																	_PreparedStatement.setInt(5, _PaymentFees.AgentId);
																	_PreparedStatement.setDouble(6, _PaymentFees.StartingAmount);
																	_PreparedStatement.setDouble(7, _PaymentFees.EndAmount);
																	_PreparedStatement.setInt(8, _PaymentFees.FeesType);
																	_PreparedStatement.setDouble(9, _PaymentFees.Fees);
																	_PreparedStatement.setBoolean(10, _PaymentFees.ChargeSendingAmount);
																	_PreparedStatement.setString(11, _PaymentFees.CreatedDate);
																	_PreparedStatement.executeUpdate();
																	_PaymentFees.setResult("Sucess");
																	ResultSet _ResultSetld = _MYSQLHelper.GetResultSet("SELECT MAX(PaymentFessId) AS PaymentFessId FROM paymentfees",_Connection);
																	if (_ResultSetld.next()){
																	int lastid = _ResultSetld.getInt("PaymentFessId");								
																	_PaymentFees.setPaymentFessId(lastid);}
																	 clear(_PaymentFees);
															
										}
										else{
											ResultSet _PaymentFess = _MYSQLHelper.GetResultSet("SELECT * FROM paymentfees where PaymentFessId='"+_PaymentFees.PaymentFessId+"'",_Connection);
											if (_PaymentFess.next())
											{
												String sInsertStatement ="UPDATE paymentfees SET PaymentMethodId = ?,country_id = ? ,DestinationCountry = ?,FeesCategoryId = ?,AgentId = ?,StartingAmount =?,EndAmount = ? ,FeesType =?,Fees = ?,ChargeSendingAmount = ?,CreatedDate=? "+ " WHERE PaymentFessId = ?";
												_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
												
												_PreparedStatement.setInt(1, _PaymentFees.PaymentMethodId);							
												_PreparedStatement.setInt(2, _PaymentFees.CountryId);
												_PreparedStatement.setInt(3, _PaymentFees.DestinationCountry);
												_PreparedStatement.setInt(4, _PaymentFees.FeesCategoryId);
												_PreparedStatement.setInt(5, _PaymentFees.AgentId);
												_PreparedStatement.setDouble(6, _PaymentFees.StartingAmount);
												_PreparedStatement.setDouble(7, _PaymentFees.EndAmount);
												_PreparedStatement.setInt(8, _PaymentFees.FeesType);
												_PreparedStatement.setDouble(9, _PaymentFees.Fees);
												_PreparedStatement.setBoolean(10, _PaymentFees.ChargeSendingAmount);
												_PreparedStatement.setString(11, _PaymentFees.CreatedDate);
												_PreparedStatement.setInt(12, _PaymentFees.PaymentFessId);
												_PreparedStatement.executeUpdate();
												_PaymentFees.setResult("Sucess");
												clear(_PaymentFees);
											}
											
											else{
												_PaymentFees.setResult("Failed!");
												_PaymentFees.setError("Invalid Payment Fess Id!");
												clear(_PaymentFees);
											}
										}
									}
									else{
										_PaymentFees.setResult("Failed!");
										_PaymentFees.setError("Invalid Agent Id!");
									     clear(_PaymentFees);
									}
								}
								else{
									_PaymentFees.setResult("Failed!");
									_PaymentFees.setError("Invalid Fees Category Id!");
								     clear(_PaymentFees);
								}
								
							}
							else{
								_PaymentFees.setResult("Failed!");
								_PaymentFees.setError("Invalid Destination Country Id!");
							     clear(_PaymentFees);
							}
							
						}
						else{
							_PaymentFees.setResult("Failed!");
							_PaymentFees.setError("Invalid source Country Id!");
						     clear(_PaymentFees);
						}
					}
					else{
						_PaymentFees.setResult("Failed!");
						_PaymentFees.setError("Invalid Payment Method Id!");
					     clear(_PaymentFees);
					}
					
					
					
				}
				else{
					_PaymentFees.setResult("Failed!");
					_PaymentFees.setError("Error in api backend connectivity !");
					clear(_PaymentFees);
				}
				
			}
			catch (Exception e) {
				_PaymentFees.setError(e.getMessage() + " Stack Trace: " + e.getStackTrace());
			}
			
			finally {
				if (_Connection != null) {
					try {
						_Connection.close();
						//clear(_PaymentFees);
						
					} catch (SQLException e) {
						clear(_PaymentFees);
					}
				}
			}
		return _PaymentFees;
	}
	
	public static ArrayList<PaymentFees> getPaymentFeesDetails() {
		Connection _Connection = MYSQLConnection.GetConnection();
		
		ArrayList<PaymentFees> _PaymentFeesDetaillist = new ArrayList<PaymentFees>();
		
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		 try
			{
			 if(_Connection!=null)			
			
				{
				
				 ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM paymentfees where IsDeleted=0",_Connection);
				
					while  (_ResultSet.next())
					{
						
						PaymentFees _PaymentFees=new PaymentFees();
						_PaymentFees.setPaymentFessId(_ResultSet.getInt("PaymentFessId"));
						_PaymentFees.setPaymentMethodId(_ResultSet.getInt("PaymentMethodId"));
						_PaymentFees.setCountryId(_ResultSet.getInt("country_id"));
						_PaymentFees.setStartingAmount(_ResultSet.getDouble("StartingAmount"));
						_PaymentFees.setEndAmount(_ResultSet.getDouble("EndAmount"));
						_PaymentFees.setFees(_ResultSet.getDouble("Fees"));
						_PaymentFees.setFeesType(_ResultSet.getInt("FeesType"));
						_PaymentFees.setDestinationCountry(_ResultSet.getInt("DestinationCountry"));
						_PaymentFees.setFeesCategoryId(_ResultSet.getInt("FeesCategoryId"));
						_PaymentFees.setAgentId(_ResultSet.getInt("AgentId"));
						_PaymentFees.setChargeSendingAmount(_ResultSet.getBoolean("ChargeSendingAmount"));
						_PaymentFees.setCreatedDate(_ResultSet.getString("CreatedDate"));
						_PaymentFees.setIsDeleted(_ResultSet.getBoolean("IsDeleted"));
						_PaymentFees.setDeletedDate(_ResultSet.getString("DeletedDate"));
						_PaymentFees.setResult("Sucess");						
						_PaymentFeesDetaillist.add(_PaymentFees);
						
					}
					 _ResultSet.close();
				
				 }
				 
				
			}
		 catch(Exception e){
			
		 }
		 finally {
			
				if (_Connection != null) {
					try {
						_Connection.close();
					} catch (SQLException e) {
						
					}
				}
			}	
		
		return _PaymentFeesDetaillist;
	}
	
	
	public PaymentFees deletePaymentFeesById(PaymentFees _PaymentFees)
	{
		
		Connection _Connection = MYSQLConnection.GetConnection();		
		 MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		 PreparedStatement _PreparedStatement = null;
			try
			{
				if(_Connection!=null)
				{
					ResultSet _PaymentFessId = _MYSQLHelper.GetResultSet("SELECT * FROM paymentfees where PaymentFessId='"+_PaymentFees.PaymentFessId+"'",_Connection);
					if (_PaymentFessId.next())
					{
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Calendar cal = Calendar.getInstance();
						String date=format.format(cal.getTime());
						_PaymentFees.setDeletedDate(date);
						_PaymentFees.setIsDeleted((true));
						String sInsertStatement ="UPDATE paymentfees SET 	IsDeleted = ? "+ ",DeletedDate = ? "+ " WHERE PaymentFessId = ?";
						_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
						_PreparedStatement.setBoolean(1, _PaymentFees.IsDeleted);
						_PreparedStatement.setString(2,_PaymentFees.DeletedDate);
						_PreparedStatement.setInt(3, _PaymentFees.PaymentFessId);	
						_PreparedStatement.executeUpdate();
						_PaymentFees.setResult("Sucess");
					}
					else
					{
						_PaymentFees.setResult("Failed!");
						_PaymentFees.setError("Invalid payment Fess Id !");	
						clear(_PaymentFees);
					}
		
				}
				else{
					_PaymentFees.setResult("Failed!");
					_PaymentFees.setError("Error in api backend connectivity !");		
					clear(_PaymentFees);
				}
			}
				catch (Exception e) {
					clear(_PaymentFees);
				}
		finally {
			if (_Connection != null) {
				try {
					_Connection.close();
					//clear(_PaymentFees);
					
				} catch (SQLException e) {
					clear(_PaymentFees);
				}
			}
		}
		return _PaymentFees;
	}
	
	
	
	
	
	
	public PaymentFees getPaymentFeesById(PaymentFees _PaymentFees)
	{
		Connection _Connection = MYSQLConnection.GetConnection();		
		 MYSQLHelper _MYSQLHelper = new MYSQLHelper();
			try
			{
				if(_Connection!=null)
				{
					ResultSet _PaymentFessId = _MYSQLHelper.GetResultSet("SELECT * FROM paymentfees where PaymentFessId='"+_PaymentFees.PaymentFessId+"'",_Connection);
					if (_PaymentFessId.next())
					{
						
						_PaymentFees.setPaymentFessId(_PaymentFessId.getInt("PaymentFessId"));
						_PaymentFees.setPaymentMethodId(_PaymentFessId.getInt("PaymentMethodId"));
						_PaymentFees.setCountryId(_PaymentFessId.getInt("country_id"));
						_PaymentFees.setStartingAmount(_PaymentFessId.getDouble("StartingAmount"));
						_PaymentFees.setEndAmount(_PaymentFessId.getDouble("EndAmount"));
						_PaymentFees.setFees(_PaymentFessId.getDouble("Fees"));
						_PaymentFees.setFeesType(_PaymentFessId.getInt("FeesType"));
						_PaymentFees.setDestinationCountry(_PaymentFessId.getInt("DestinationCountry"));
						_PaymentFees.setFeesCategoryId(_PaymentFessId.getInt("FeesCategoryId"));
						_PaymentFees.setAgentId(_PaymentFessId.getInt("AgentId"));
						_PaymentFees.setChargeSendingAmount(_PaymentFessId.getBoolean("ChargeSendingAmount"));
						_PaymentFees.setCreatedDate(_PaymentFessId.getString("CreatedDate"));
						_PaymentFees.setIsDeleted(_PaymentFessId.getBoolean("IsDeleted"));
						_PaymentFees.setDeletedDate(_PaymentFessId.getString("DeletedDate"));
						_PaymentFees.setResult("Sucess");
					}
					else{
						_PaymentFees.setResult("Failed!");
						_PaymentFees.setError("Invalid Payment Fess Id!");
						clear(_PaymentFees);
					}
					
				}
				else{
					_PaymentFees.setResult("Failed!");
					_PaymentFees.setError("Error in api backend connectivity !");
					clear(_PaymentFees);
				}
			}
			catch (Exception e) {
			
			}
			finally {
				if (_Connection != null) {
					try {
						_Connection.close();
						//clear(_PaymentFees);
						
					} catch (SQLException e) {
						clear(_PaymentFees);
					}
				}
			}
		return _PaymentFees;
	}
	
	
	public PaymentFees clear(PaymentFees _PaymentFees) {
		_PaymentFees.setCountryId(0);
		_PaymentFees.setPaymentMethodId(0);
		_PaymentFees.setStartingAmount(0);
		_PaymentFees.setEndAmount(0);
		_PaymentFees.setFeesType(0);
		_PaymentFees.setFees(0);
		return _PaymentFees;
		
	}
}
