package com.etl.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.etl.util.MYSQLConnection;
import com.etl.util.MYSQLHelper;
public class companydetails {
int customerid;
String companyname;
String 	email;	
String phone;
String password;	
String createddate;	
boolean	is_active;
boolean	is_deleted;
String 	deleteddate;
String result;
String error;


public void setcustomerid(int customerid){
	this.customerid = customerid;
}	
public int getcustomerid(){
	return customerid;
}
public void setcompanyname(String companyname){
	this.companyname = companyname;
}	
public String getcompanyname(){
	return companyname;
}

public void setemail(String email){
	this.email = email;
}	
public String getemail(){
	return email;
}
public void setphone(String phone){
	this.phone = phone;
}	
public String getphone(){
	return phone;
}
public void setpassword(String password){
	this.password = password;
}	
//public String getpassword(){
	//return password;
//}
public void setcreateddate(String createddate){
	this.createddate = createddate;
}	
public String getcreateddate(){
	return createddate;
}
public void setis_active(boolean is_active){
	this.is_active = is_active;
}	
public boolean getis_active(){
	return is_active;
}

public void setis_deleted(boolean is_deleted){
	this.is_deleted = is_deleted;
}	
public boolean getis_deleted(){
	return is_deleted;
}
public void setdeleteddate(String deleteddate){
	this.deleteddate = deleteddate;
}	
public String getdeleteddate(){
	return deleteddate;
}
public void setresult(String result){
	this.result = result;
}	
public String getresult(){
	return result;
}
public void seterror(String error){
	this.error = error;
}	
public String geterror(){
	return error;
}

//final static Logger logger = Logger.getLogger(companydetails.class);
public companydetails addcompany(companydetails _companydetails) {
	Connection _Connection = MYSQLConnection.GetConnection();
	 PreparedStatement _PreparedStatement = null;
	try
	{
		String _hashPassword = byteArrayToHexString(companydetails.computeHash(_companydetails.password));
					if(_Connection!=null)
					{
						MYSQLHelper _MYSQLHelper = new MYSQLHelper();
						ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT email FROM customer where email='"+_companydetails.email+"'",_Connection);
						if (!_ResultSet.next())
						{			
							SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							Calendar cal = Calendar.getInstance();
							String date=format.format(cal.getTime());
							_companydetails.setcreateddate(date);	
							_companydetails.setpassword(_hashPassword);
							String sInsertStatement = "INSERT INTO customer(company_name,email,phone,password,created_date,is_active)";
							 sInsertStatement = sInsertStatement + " VALUES(?, ?, ?, ?, ?, ?)";
							_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
							_PreparedStatement.setString(1, _companydetails.companyname);							
							_PreparedStatement.setString(2, _companydetails.email);		
							_PreparedStatement.setString(3, _companydetails.phone);
							_PreparedStatement.setString(4, _companydetails.password);	
							_PreparedStatement.setString(5, _companydetails.createddate);	
							_PreparedStatement.setBoolean(6, _companydetails.is_active);	
							_PreparedStatement.executeUpdate();
							_companydetails.setresult("Sucess");
					}
					else{
						_companydetails.setresult("Failed");
						_companydetails.seterror("Email_id is already used!");
						//logger.error(_auth.errorstatus);
			    	}
				}
		
			else{
					_companydetails.setresult("Failed");
					_companydetails.seterror("Error in api backend connectivity !");
					//logger.error(_auth.errorstatus);
		    	}
	  }	
	
	catch (Exception e) {
		_companydetails.setresult("Invalid Customer email-Id, plesae try with valid email-Id!");
	}
	finally
	{
		if (_Connection != null) {
			try {
				_Connection.close();
			} catch (SQLException e) {
				//logger.error(e.getMessage() + " Stack Trace: " + e.getStackTrace());
			}
		}
	}	
	
	return _companydetails;
	
}

public companydetails updatecompany(companydetails _companydetails) {
	Connection _Connection = MYSQLConnection.GetConnection();
	 PreparedStatement _PreparedStatement = null;
	 
	try
	{
		if(_Connection!=null)
		{
				String _hashPassword = byteArrayToHexString(companydetails.computeHash(_companydetails.password));
				
				MYSQLHelper _MYSQLHelper = new MYSQLHelper();
				ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT customer_Id FROM customer where customer_Id='"+_companydetails.customerid+"'",_Connection);
				if (_ResultSet.next())
				{	
				//	ResultSet _ResultSetemail = _MYSQLHelper.GetResultSet("SELECT email FROM customer where email='"+_companydetails.email+"'",_Connection);
					//if (!_ResultSetemail.next())
				//	{	
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Calendar cal = Calendar.getInstance();
					String date=format.format(cal.getTime());
					_companydetails.setcreateddate(date);	
					_companydetails.setpassword(_hashPassword);
					String sInsertStatement ="UPDATE customer SET company_name = ? "+ ",email = ? "+ ",phone = ? "+ ",password = ? "+ ",created_date = ? "+ ",is_active = ? "+ " WHERE customer_Id = ?";
					_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
					_PreparedStatement.setString(1, _companydetails.companyname);
					_PreparedStatement.setString(2, _companydetails.email);		
					_PreparedStatement.setString(3, _companydetails.phone);
					_PreparedStatement.setString(4, _companydetails.password);	
					_PreparedStatement.setString(5, _companydetails.createddate);	
					_PreparedStatement.setBoolean(6, _companydetails.is_active);
					_PreparedStatement.setInt(7, _companydetails.customerid);
					_PreparedStatement.executeUpdate();
					_companydetails.setresult("Sucess");
				//	}
				//	else{
					//	_companydetails.setresult("Failed");
					//	_companydetails.seterror("Email_id is already used!");
						//logger.error(_auth.errorstatus);
			    	//}
				}
				else{
					_companydetails.setresult("Failed");
					_companydetails.seterror("Invalid Customer Id!");
					//logger.error(_auth.errorstatus);
		    	}
			}
			else{
				_companydetails.setresult("Failed");
				_companydetails.seterror("Error in api backend connectivity !");
				//logger.error(_auth.errorstatus);
	    	}
	}
	catch (Exception e) {
		_companydetails.setresult("Failed!"+e.getStackTrace());
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
	return _companydetails;
}


public companydetails deletecompany(companydetails _companydetails)
{
	Connection _Connection = MYSQLConnection.GetConnection();
	
	try
	{
		if(_Connection!=null)
		{
		PreparedStatement _PreparedStatement = null;
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT customer_Id FROM customer where customer_Id='"+_companydetails.customerid+"'",_Connection);
			if (_ResultSet.next())
			{
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				String date=format.format(cal.getTime());
				_companydetails.setdeleteddate(date);
				
				_companydetails.setis_deleted((true));
				String sInsertStatement ="UPDATE customer SET 	is_deleted = ? "+ ",deleted_date = ? "+ " WHERE customer_Id = ?";
				_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
				_PreparedStatement.setBoolean(1, _companydetails.is_deleted);
				_PreparedStatement.setString(2,_companydetails.deleteddate);
				_PreparedStatement.setInt(3, _companydetails.customerid);	
				_PreparedStatement.executeUpdate();
				_companydetails.setresult("Sucess");
			}
			else{
				_companydetails.setresult("Failed");
				_companydetails.seterror("Invalid Customer Id!");
				//logger.error(_auth.errorstatus);
	    	}
	}
		else{
			_companydetails.setresult("Failed");
			_companydetails.seterror("Error in api backend connectivity !");
			//logger.error(_auth.errorstatus);
    	}
	
	}
	catch (Exception e) {
		_companydetails.setresult("Failed!"+e.getStackTrace());
	}
	finally
	{
		if (_Connection != null) {
			try {
				_Connection.close();
			} catch (SQLException e) {
				//logger.error(e.getMessage() + " Stack Trace: " + e.getStackTrace());
			}
		}
	}
	return _companydetails;
}

public companydetails logincompany(companydetails _companydetails)
{
	Connection _Connection = MYSQLConnection.GetConnection();	
	try
	{
		if(_Connection!=null)
		{
			String _hashPassword = byteArrayToHexString(companydetails.computeHash(_companydetails.password));			
			MYSQLHelper _MYSQLHelper = new MYSQLHelper();
			_companydetails.setpassword(_hashPassword);			
			ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM customer where email='"+_companydetails.email+"' and password ='"+_companydetails.password+"'",_Connection);
				if (_ResultSet.next())
				{
					ResultSet _ResultSetdata = _MYSQLHelper.GetResultSet("SELECT * FROM customer where email='"+_companydetails.email+"'",_Connection);
					if (_ResultSetdata.next())
					{	
					_companydetails.setcustomerid(_ResultSet.getInt("customer_Id"));
					_companydetails.setcompanyname(_ResultSet.getString("company_name"));
					_companydetails.setphone(_ResultSet.getString("phone"));
					_companydetails.setcreateddate(_ResultSet.getString("created_date"));
					_companydetails.setis_active(_ResultSet.getBoolean("is_active"));
					_companydetails.setis_deleted(_ResultSet.getBoolean("is_deleted"));
					_companydetails.setdeleteddate(_ResultSet.getString("deleted_date"));
					_companydetails.setresult("Sucess");
					}
				}
				else
				{
					_companydetails.setresult("Failed");
					_companydetails.seterror("Invalid Credentials!");
				}
		}
		else{
			_companydetails.setresult("Failed");
			_companydetails.seterror("Error in api backend connectivity !");
			//logger.error(_auth.errorstatus);
    	}
		
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
	
	
	return _companydetails;
}

       public static byte[] computeHash(String x)
		  throws Exception
		  {
		     java.security.MessageDigest d =null;
		     d = java.security.MessageDigest.getInstance("SHA-1");
		     d.reset();
		     d.update(x.getBytes());
		     return  d.digest();
		  }

		  public static String byteArrayToHexString(byte[] b){
		     StringBuffer sb = new StringBuffer(b.length * 2);
		     for (int i = 0; i < b.length; i++){
		       int v = b[i] & 0xff;
		       if (v < 16) {
		         sb.append('0');
		       }
		       sb.append(Integer.toHexString(v));
		     }
		     return sb.toString().toUpperCase();
		  }
}
