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

public class PaymentMethod {
	public int PaymentMethodId;
	public int PaymentTypeId;
	public int CompanyId;
	public String Title;
	public String Description;
	public boolean IsActive;
	public boolean IsDeleted;
	public String CreatedDate;
	public String DeletedDate;
	public String Result;
	public String Error;
	
	private void setPaymentMethodId(int PaymentMethodId){
		this.PaymentMethodId = PaymentMethodId;
	}	
	private int getPaymentMethodId(){
		return PaymentMethodId;
	}
	private void setPaymentTypeId(int PaymentTypeId){
		this.PaymentTypeId = PaymentTypeId;
	}	
	private int getPaymentTypeId(){
		return PaymentTypeId;
	}
	private void setCompanyId(int CompanyId){
		this.CompanyId = CompanyId;
	}	
	private int getCompanyId(){
		return CompanyId;
	}
	
	private void setTitle(String Title){
		this.Title = Title;
	}	
	private String getTitle(){
		return Title;
	}
	private void setDescription(String Description){
		this.Description = Description;
	}	
	private String getDescription(){
		return Description;
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
	
	public PaymentMethod addPaymentMethod(PaymentMethod _PaymentMethod) {
		
		Connection _Connection = MYSQLConnection.GetConnection();
		 PreparedStatement _PreparedStatement = null;
			try
			{
				if(_Connection!=null)
				{
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Calendar cal = Calendar.getInstance();
					String date=format.format(cal.getTime());
					_PaymentMethod.setCreatedDate(date);	
					MYSQLHelper _MYSQLHelper = new MYSQLHelper();
					if(_PaymentMethod.PaymentMethodId <=0)
					{
						
						ResultSet _ResultSetPaymentType = _MYSQLHelper.GetResultSet("SELECT PaymentTypeId FROM paymenttype where PaymentTypeId='"+_PaymentMethod.PaymentTypeId+"'",_Connection);
						if (_ResultSetPaymentType.next())
						{
							ResultSet _ResultSetl = _MYSQLHelper.GetResultSet("SELECT Company_Id FROM company where Company_Id='"+_PaymentMethod.CompanyId+"'",_Connection);
							if (_ResultSetl.next())
							{
								String sInsertStatement = "INSERT INTO paymentmethod( PaymentTypeId, CompanyId, Title,Description,IsActive,CreatedDate)";
								 sInsertStatement = sInsertStatement + " VALUES(?, ?, ?,?, ?, ?)";
								   _PreparedStatement = _Connection.prepareStatement(sInsertStatement);
									_PreparedStatement.setInt(1, _PaymentMethod.PaymentTypeId);							
									_PreparedStatement.setInt(2, _PaymentMethod.CompanyId); 
									if(_PaymentMethod.Title!="" && _PaymentMethod.Title!=null)
									{
										_PreparedStatement.setString(3, _PaymentMethod.Title);
									}
									else{
										_PreparedStatement.setString(3, "");
									}
									if(_PaymentMethod.Description!="" && _PaymentMethod.Description!=null)
									{
										_PreparedStatement.setString(4, _PaymentMethod.Description);
									}
									else{
										_PreparedStatement.setString(4, "");
									}						
									
									_PreparedStatement.setBoolean(5, _PaymentMethod.IsActive);							
									_PreparedStatement.setString(6, _PaymentMethod.CreatedDate); 
									_PreparedStatement.executeUpdate();
									_PaymentMethod.setResult("Sucess");
									ResultSet _ResultSetld = _MYSQLHelper.GetResultSet("SELECT MAX(PaymentMethodId) AS PaymentMethodId FROM paymentmethod",_Connection);
									if (_ResultSetld.next()){
									int lastid = _ResultSetld.getInt("PaymentMethodId");								
									_PaymentMethod.setPaymentMethodId(lastid);}
							}
							else{
								_PaymentMethod.setResult("Failed!");
								_PaymentMethod.setError("Invalid Company Id!");
							     clear(_PaymentMethod);
							}
							
						}
						else{
							_PaymentMethod.setResult("Failed!");
							_PaymentMethod.setError("Invalid Payment Type Id!");
							clear(_PaymentMethod);
						}
					}
					else{
						ResultSet _ResultSetPaymentMethodId = _MYSQLHelper.GetResultSet("SELECT PaymentMethodId FROM paymentmethod where PaymentMethodId='"+_PaymentMethod.PaymentMethodId+"'",_Connection);
						if (_ResultSetPaymentMethodId.next())
						{
							ResultSet _ResultSetPaymentType = _MYSQLHelper.GetResultSet("SELECT PaymentTypeId FROM paymenttype where PaymentTypeId='"+_PaymentMethod.PaymentTypeId+"'",_Connection);
							if (_ResultSetPaymentType.next())
							{
								ResultSet _ResultSetl = _MYSQLHelper.GetResultSet("SELECT Company_Id FROM company where Company_Id='"+_PaymentMethod.CompanyId+"'",_Connection);
								if (_ResultSetl.next())
								{
									String sInsertStatement ="UPDATE paymentmethod SET 	PaymentTypeId = ?,CompanyId = ? ,Title =?,Description = ? ,IsActive =?,CreatedDate = ? "+ " WHERE PaymentMethodId = ?";
									_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
									_PreparedStatement.setInt(1, _PaymentMethod.PaymentTypeId);							
									_PreparedStatement.setInt(2, _PaymentMethod.CompanyId);	
									if(_PaymentMethod.Title!="" && _PaymentMethod.Title!=null)
									{
										_PreparedStatement.setString(3, _PaymentMethod.Title);
									}
									else{
										_PreparedStatement.setString(3, "");
									}
									if(_PaymentMethod.Description!="" && _PaymentMethod.Description!=null)
									{
										_PreparedStatement.setString(4, _PaymentMethod.Description);
									}
									else{
										_PreparedStatement.setString(4, "");
									}						
									
									_PreparedStatement.setBoolean(5, _PaymentMethod.IsActive);							
									_PreparedStatement.setString(6, _PaymentMethod.CreatedDate);
									_PreparedStatement.setInt(7, _PaymentMethod.PaymentMethodId);	
									_PreparedStatement.executeUpdate();
									_PaymentMethod.setResult("Sucess");
									clear(_PaymentMethod);
								}
								else{
									_PaymentMethod.setResult("Failed!");
									_PaymentMethod.setError("Invalid Company Id!");
									clear(_PaymentMethod);
								}
							}
							else{
								_PaymentMethod.setResult("Failed!");
								_PaymentMethod.setError("Invalid Payment Type Id!");
								clear(_PaymentMethod);
							}
						}
						
						else{
							_PaymentMethod.setResult("Failed!");
							_PaymentMethod.setError("Invalid Payment Method Id!");
							clear(_PaymentMethod);
						}
					
					}
				}
				else{
					_PaymentMethod.setResult("Failed!");
					_PaymentMethod.setError("Error in api backend connectivity !");
					clear(_PaymentMethod);
				}
			}
			catch (Exception e) {
				_PaymentMethod.setError(e.getMessage() + " Stack Trace: " + e.getStackTrace());
			}
			finally {
				if (_Connection != null) {
					try {
						_Connection.close();
						clear(_PaymentMethod);
						
					} catch (SQLException e) {
						clear(_PaymentMethod);
					}
				}
			}
		return _PaymentMethod;
	}
	
	public PaymentMethod getPaymentMethodById(PaymentMethod _PaymentMethod) {
		Connection _Connection = MYSQLConnection.GetConnection();
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		if(_Connection!=null)
		{
			try{
				ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM paymentmethod where PaymentMethodId='"+_PaymentMethod.PaymentMethodId+"'",_Connection);
				if(_ResultSet.next())
				{
			        _PaymentMethod.setPaymentMethodId(_ResultSet.getInt("PaymentMethodId"));
			        _PaymentMethod.setPaymentTypeId(_ResultSet.getInt("PaymentTypeId"));
			        _PaymentMethod.setCompanyId(_ResultSet.getInt("CompanyId"));
			        _PaymentMethod.setTitle(_ResultSet.getString("Title"));
			        _PaymentMethod.setDescription(_ResultSet.getString("Description"));
			        _PaymentMethod.setIsActive(_ResultSet.getBoolean("IsActive"));
			        _PaymentMethod.setIsDeleted(_ResultSet.getBoolean("IsDeleted"));
			        _PaymentMethod.setCreatedDate(_ResultSet.getString("CreatedDate"));
			        _PaymentMethod.setDeletedDate(_ResultSet.getString("DeletedDate"));
			        _PaymentMethod.setResult("Sucess");
				}
				else{
					_PaymentMethod.setResult("Failed!");
					_PaymentMethod.setError("Invalid Payment Method Id!");
					clear(_PaymentMethod);
				}
				
			}
			catch (Exception e) {
				clear(_PaymentMethod);
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
		}
		else{
			_PaymentMethod.setResult("Failed!");
			_PaymentMethod.setError("Error in api backend connectivity !");			
		}
		
		
		return _PaymentMethod;
	}
	
	
	
	public PaymentMethod deletePaymentMethod(PaymentMethod _PaymentMethod) {
		Connection _Connection = MYSQLConnection.GetConnection();
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		PreparedStatement _PreparedStatement = null;
		try
		{
		 if(_Connection!=null)
			{
			 
			 ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM paymentmethod where PaymentMethodId='"+_PaymentMethod.PaymentMethodId+"'",_Connection);
				if(_ResultSet.next())
				{
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Calendar cal = Calendar.getInstance();
					String date=format.format(cal.getTime());
					_PaymentMethod.setDeletedDate(date);
					_PaymentMethod.setIsDeleted((true));
					String sInsertStatement ="UPDATE paymentmethod SET 	IsDeleted = ? "+ ",DeletedDate = ? "+ " WHERE PaymentMethodId = ?";
					_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
					_PreparedStatement.setBoolean(1, _PaymentMethod.IsDeleted);
					_PreparedStatement.setString(2,_PaymentMethod.DeletedDate);
					_PreparedStatement.setInt(3, _PaymentMethod.PaymentMethodId);	
					_PreparedStatement.executeUpdate();
					_PaymentMethod.setResult("Sucess");
					
				}
				else{
					_PaymentMethod.setResult("Failed!");
					_PaymentMethod.setError("Invalid payment Method Id !");	
					clear(_PaymentMethod);
				}
			}
		 else{
				_PaymentMethod.setResult("Failed!");
				_PaymentMethod.setError("Error in api backend connectivity !");		
				clear(_PaymentMethod);
			}
		}
		catch (Exception e) {
			clear(_PaymentMethod);
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
		return _PaymentMethod;
				
	}
	
	
	
	public static ArrayList<PaymentMethod> getPaymentMethodDetails(int CompanyId) {
		Connection _Connection = MYSQLConnection.GetConnection();
		
		ArrayList<PaymentMethod> _PaymentMethodDetaillist = new ArrayList<PaymentMethod>();
		
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		 try
			{
			 if(_Connection!=null)			
			
				{
				 if(CompanyId!=0)
				 {
				ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM paymentmethod where CompanyId='"+CompanyId+"' and IsDeleted=0 and IsActive=1",_Connection);
				
					while  (_ResultSet.next())
					{
						
						 PaymentMethod _PaymentMethod=new PaymentMethod();
						_PaymentMethod.setPaymentMethodId(_ResultSet.getInt("PaymentMethodId"));
						_PaymentMethod.setCompanyId(_ResultSet.getInt("CompanyId"));
						_PaymentMethod.setPaymentTypeId(_ResultSet.getInt("PaymentTypeId"));
						_PaymentMethod.setTitle(_ResultSet.getString("Title"));
						_PaymentMethod.setDescription(_ResultSet.getString("Description"));						
						_PaymentMethod.setIsActive(_ResultSet.getBoolean("IsActive"));
						_PaymentMethod.setIsDeleted(_ResultSet.getBoolean("IsDeleted"));
						_PaymentMethod.setCreatedDate(_ResultSet.getString("CreatedDate"));
						_PaymentMethod.setDeletedDate(_ResultSet.getString("DeletedDate"));
						
						_PaymentMethodDetaillist.add(_PaymentMethod);
						
					}
					 _ResultSet.close();
				
				 }
				 else
				 {
					 ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM paymentmethod where IsDeleted=0",_Connection);
						
						while  (_ResultSet.next())
						{
							
							 PaymentMethod _PaymentMethod=new PaymentMethod();
							_PaymentMethod.setPaymentMethodId(_ResultSet.getInt("PaymentMethodId"));
							_PaymentMethod.setCompanyId(_ResultSet.getInt("CompanyId"));
							_PaymentMethod.setPaymentTypeId(_ResultSet.getInt("PaymentTypeId"));
							_PaymentMethod.setTitle(_ResultSet.getString("Title"));
							_PaymentMethod.setDescription(_ResultSet.getString("Description"));						
							_PaymentMethod.setIsActive(_ResultSet.getBoolean("IsActive"));
							_PaymentMethod.setIsDeleted(_ResultSet.getBoolean("IsDeleted"));
							_PaymentMethod.setCreatedDate(_ResultSet.getString("CreatedDate"));
							_PaymentMethod.setDeletedDate(_ResultSet.getString("DeletedDate"));
							
							_PaymentMethodDetaillist.add(_PaymentMethod);
							
						}
						 _ResultSet.close();
				 }
				}
			
				
			}
		 catch(Exception e){
			 e.printStackTrace();
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
		
		return _PaymentMethodDetaillist;
	}
	
	public static ArrayList<PaymentMethod> getPaymentMethodDetailsforAdmin(int CompanyId) {
		Connection _Connection = MYSQLConnection.GetConnection();
		
		ArrayList<PaymentMethod> _PaymentMethodDetaillist = new ArrayList<PaymentMethod>();
		
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		 try
			{
			 if(_Connection!=null)			
			
				{
				 if(CompanyId!=0)
				 {
				ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM paymentmethod where CompanyId='"+CompanyId+"' and IsDeleted=0",_Connection);
				
					while  (_ResultSet.next())
					{
						
						 PaymentMethod _PaymentMethod=new PaymentMethod();
						_PaymentMethod.setPaymentMethodId(_ResultSet.getInt("PaymentMethodId"));
						_PaymentMethod.setCompanyId(_ResultSet.getInt("CompanyId"));
						_PaymentMethod.setPaymentTypeId(_ResultSet.getInt("PaymentTypeId"));
						_PaymentMethod.setTitle(_ResultSet.getString("Title"));
						_PaymentMethod.setDescription(_ResultSet.getString("Description"));						
						_PaymentMethod.setIsActive(_ResultSet.getBoolean("IsActive"));
						_PaymentMethod.setIsDeleted(_ResultSet.getBoolean("IsDeleted"));
						_PaymentMethod.setCreatedDate(_ResultSet.getString("CreatedDate"));
						_PaymentMethod.setDeletedDate(_ResultSet.getString("DeletedDate"));
						
						_PaymentMethodDetaillist.add(_PaymentMethod);
						
					}
					 _ResultSet.close();
				
				 }
				 else
				 {
					 ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM paymentmethod where IsDeleted=0",_Connection);
						
						while  (_ResultSet.next())
						{
							
							 PaymentMethod _PaymentMethod=new PaymentMethod();
							_PaymentMethod.setPaymentMethodId(_ResultSet.getInt("PaymentMethodId"));
							_PaymentMethod.setCompanyId(_ResultSet.getInt("CompanyId"));
							_PaymentMethod.setPaymentTypeId(_ResultSet.getInt("PaymentTypeId"));
							_PaymentMethod.setTitle(_ResultSet.getString("Title"));
							_PaymentMethod.setDescription(_ResultSet.getString("Description"));						
							_PaymentMethod.setIsActive(_ResultSet.getBoolean("IsActive"));
							_PaymentMethod.setIsDeleted(_ResultSet.getBoolean("IsDeleted"));
							_PaymentMethod.setCreatedDate(_ResultSet.getString("CreatedDate"));
							_PaymentMethod.setDeletedDate(_ResultSet.getString("DeletedDate"));
							
							_PaymentMethodDetaillist.add(_PaymentMethod);
							
						}
						 _ResultSet.close();
				 }
				}
			
				
			}
		 catch(Exception e){
			 e.printStackTrace();
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
		
		return _PaymentMethodDetaillist;
	}
	
	
	
	public PaymentMethod clear(PaymentMethod _PaymentMethod) {
		
		_PaymentMethod.setTitle("");
		_PaymentMethod.setDescription("");
		_PaymentMethod.setCreatedDate("");
		_PaymentMethod.setCompanyId(0);
		_PaymentMethod.setPaymentTypeId(0);
		
		
		return _PaymentMethod;
	}
}
