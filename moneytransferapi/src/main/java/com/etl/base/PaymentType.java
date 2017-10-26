package com.etl.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.etl.util.MYSQLConnection;
import com.etl.util.MYSQLHelper;

public class PaymentType {
	
	public int PaymentTypeId;
	public String PaymentType;
	public String Description;
	public String PaymentTypeLogo;
	public String Result;
	public String Error;
	
	
	private void setPaymentTypeId(int PaymentTypeId){
		this.PaymentTypeId = PaymentTypeId;
	}	
	private int getPaymentTypeId(){
		return PaymentTypeId;
	}

	
	private void setPaymentType(String PaymentType){
		this.PaymentType = PaymentType;
	}	
	private String getPaymentType(){
		return PaymentType;
	}
	
	
	private void setDescription(String Description){
		this.Description = Description;
	}	
	private String getDescription(){
		return Description;
	}
	
	private void setPaymentTypeLogo(String PaymentTypeLogo){
		this.PaymentTypeLogo = PaymentTypeLogo;
	}	
	private String getPaymentTypeLogo(){
		return PaymentTypeLogo;
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
	public PaymentType savepaymenttype(PaymentType _PaymentType)
	{
		Connection _Connection = MYSQLConnection.GetConnection();
		 PreparedStatement _PreparedStatement = null;
			try
			{
				if(_Connection!=null)
				{
					 MYSQLHelper _MYSQLHelper = new MYSQLHelper();
					if(_PaymentType.PaymentTypeId <=0)
					{
						ResultSet _ResultSetl = _MYSQLHelper.GetResultSet("SELECT PaymentType FROM paymenttype where PaymentType='"+_PaymentType.PaymentType+"'",_Connection);
						if (!_ResultSetl.next())
						{
							String sInsertStatement = "INSERT INTO paymenttype( PaymentType, Description, PaymentTypeLogo)";
							 sInsertStatement = sInsertStatement + " VALUES(?, ?, ?)";
							 _PreparedStatement = _Connection.prepareStatement(sInsertStatement);
								_PreparedStatement.setString(1, _PaymentType.PaymentType);							
								_PreparedStatement.setString(2, _PaymentType.Description);		
								if(_PaymentType.PaymentTypeLogo !=null)
								{
									_PreparedStatement.setString(3, _PaymentType.PaymentTypeLogo);
								}else{
									_PreparedStatement.setString(3, "");
								}
								_PreparedStatement.executeUpdate();	
								_PaymentType.setResult("Sucess");
								ResultSet _ResultSetld = _MYSQLHelper.GetResultSet("SELECT MAX(PaymentTypeId) AS PaymentTypeId FROM paymenttype",_Connection);
								if (_ResultSetld.next()){
								int lastid = _ResultSetld.getInt("PaymentTypeId");								
								_PaymentType.setPaymentTypeId(lastid);}
								clear(_PaymentType);
						}
						else{
							_PaymentType.setResult("Failed!");
							_PaymentType.setError("Payment Method already exist!");
							clear(_PaymentType);
						}
					}
					else
					{
						ResultSet _ResultSetl = _MYSQLHelper.GetResultSet("SELECT PaymentTypeId FROM paymenttype where PaymentTypeId='"+_PaymentType.PaymentTypeId+"'",_Connection);
						if (_ResultSetl.next())
						{
							String sInsertStatement ="UPDATE paymenttype SET 	PaymentType = ?,Description = ? ,PaymentTypeLogo = ? "+ " WHERE PaymentTypeId = ?";
							_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
							_PreparedStatement.setString(1, _PaymentType.PaymentType);							
							_PreparedStatement.setString(2, _PaymentType.Description);	
							if(_PaymentType.PaymentTypeLogo !=null)
							{
								_PreparedStatement.setString(3, _PaymentType.PaymentTypeLogo);
							}else{
								_PreparedStatement.setString(3, "");
							}
							_PreparedStatement.setString(3, _PaymentType.PaymentTypeLogo);
							_PreparedStatement.setInt(4, _PaymentType.PaymentTypeId);	
							_PreparedStatement.executeUpdate();
							_PaymentType.setResult("Sucess");
							clear(_PaymentType);
						}
						else
						{
							_PaymentType.setResult("Failed!");
							_PaymentType.setError("Invalid Payment Type Id!");
							clear(_PaymentType);
						}
						
					}
					
					
				}
				else{
					_PaymentType.setResult("Failed!");
					_PaymentType.setError("Error in api backend connectivity !");
					clear(_PaymentType);
				}
			}
		catch (Exception e) {
			clear(_PaymentType);
		}
		return _PaymentType;
	}
	
	public static ArrayList<PaymentType> getPaymentTypeDetails() {
		Connection _Connection = MYSQLConnection.GetConnection();
		
		ArrayList<PaymentType> _PaymentTypelist = new ArrayList<PaymentType>();
		
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM  paymenttype",_Connection);
		 try
			{
			 while  (_ResultSet.next())
				{
					
				 PaymentType _PaymentType=new PaymentType();
				 _PaymentType.setPaymentTypeId(_ResultSet.getInt("PaymentTypeId"));
				 _PaymentType.setPaymentType(_ResultSet.getString("PaymentType"));
				 _PaymentType.setDescription(_ResultSet.getString("Description"));
				 _PaymentType.setPaymentTypeLogo(_ResultSet.getString("PaymentTypeLogo"));
				 _PaymentType.setResult("Success");
				 _PaymentTypelist.add(_PaymentType);
					
				}
			 _ResultSet.close();
			}
		 catch (Exception e) {
			
		}
		 finally {
			 if (_Connection != null) {
					try {
						_Connection.close();
					} catch (SQLException e) {
						//logger.error(e.getMessage() + " Stack Trace: " + e.getStackTrace());
					}
				}
		}
		 return _PaymentTypelist;
	}
	
	
	
	
	
	
	public PaymentType clear(PaymentType _PaymentType)
	{
		_PaymentType.setPaymentType("");
		_PaymentType.setDescription("");
		_PaymentType.setPaymentTypeLogo("");		
		return _PaymentType;
	}
	
}
