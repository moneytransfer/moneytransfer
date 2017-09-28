package com.etl.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.etl.util.MYSQLConnection;
import com.etl.util.MYSQLHelper;

public class usersdetails {
	int userid;
	int customerid;
	String firstname;
	String lastname;
	String 	email;	
	String phone;
	String password;	
	String createddate;	
	boolean	is_active;
	boolean	is_deleted;
	String 	deleteddate;
	String result;
	String error;
	
	
	
	public void setuserid(int userid){
		this.userid = userid;
	}	
	public int getuserid(){
		return userid;
	}
	
	public void setcustomerid(int customerid){
		this.customerid = customerid;
	}	
	public int getcustomerid(){
		return customerid;
	}
	public void setfirstname(String firstname){
		this.firstname = firstname;
	}	
	public String getfirstname(){
		return firstname;
	}
	public void setlastname(String lastname){
		this.lastname = lastname;
	}	
	public String getlastname(){
		return firstname;
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
	
	
	public usersdetails adduser(usersdetails _usersdetails) {
		Connection _Connection = MYSQLConnection.GetConnection();
		 PreparedStatement _PreparedStatement = null;
		
		 try
		 {
			 String _hashPassword = byteArrayToHexString(usersdetails.computeHash(_usersdetails.password));
			 MYSQLHelper _MYSQLHelper = new MYSQLHelper();
			 _usersdetails.setpassword(_hashPassword);	
			 if(_Connection!=null)
			 {
				 ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT email FROM users where email='"+_usersdetails.email+"'",_Connection);
					if (!_ResultSet.next())
					{
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Calendar cal = Calendar.getInstance();
						String date=format.format(cal.getTime());
						_usersdetails.setcreateddate(date);	
						_usersdetails.setpassword(_hashPassword);
						
						String sInsertStatement = "INSERT INTO users(customer_Id,first_name,last_name,email,phone,password,is_active,create_date)";
						 sInsertStatement = sInsertStatement + " VALUES(?, ?, ?, ?, ?, ?,?,?)";
						 
						   _PreparedStatement = _Connection.prepareStatement(sInsertStatement);
							_PreparedStatement.setInt(1, _usersdetails.customerid);							
							_PreparedStatement.setString(2, _usersdetails.firstname);		
							_PreparedStatement.setString(3, _usersdetails.lastname);
							_PreparedStatement.setString(4, _usersdetails.email);	
							_PreparedStatement.setString(5, _usersdetails.phone);	
							_PreparedStatement.setString(6, _usersdetails.password);	
							_PreparedStatement.setBoolean(7, _usersdetails.is_active);
							_PreparedStatement.setString(8, _usersdetails.createddate);
							_PreparedStatement.executeUpdate();
							_usersdetails.setresult("Sucess");
					}
					else{
						_usersdetails.setresult("Failed");
						_usersdetails.seterror("Email_id is already used!");
						//logger.error(_auth.errorstatus);
			    	}
			 }
			 else{
				 _usersdetails.setresult("Failed");
				 _usersdetails.seterror("Error in api backend connectivity !");
					//logger.error(_auth.errorstatus);
		    	}
			 
		 }
		 catch (Exception e) {
			_usersdetails.setresult("Invalid user email-Id, plesae try with valid email-Id!");
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
         return _usersdetails;
   }
	
	public usersdetails loginuser(usersdetails usersdetails)
	{
		Connection _Connection = MYSQLConnection.GetConnection();	
		try
		{
			if(_Connection!=null)
			{
				String _hashPassword = byteArrayToHexString(companydetails.computeHash(usersdetails.password));			
				MYSQLHelper _MYSQLHelper = new MYSQLHelper();
				usersdetails.setpassword(_hashPassword);			
				ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM users where email='"+usersdetails.email+"' and password ='"+usersdetails.password+"'",_Connection);
					if (_ResultSet.next())
					{
						usersdetails.setuserid(_ResultSet.getInt("user_id"));
						usersdetails.setcustomerid(_ResultSet.getInt("customer_Id"));
						usersdetails.setfirstname(_ResultSet.getString("first_name"));
						usersdetails.setlastname(_ResultSet.getString("last_name"));
						usersdetails.setphone(_ResultSet.getString("phone"));
						usersdetails.setcreateddate(_ResultSet.getString("create_date"));
						usersdetails.setis_active(_ResultSet.getBoolean("is_active"));
						usersdetails.setis_deleted(_ResultSet.getBoolean("is_deleted"));
						usersdetails.setdeleteddate(_ResultSet.getString("deleted_date"));
						usersdetails.setresult("Sucess");
					}
					else
					{
						usersdetails.setresult("Failed");
						usersdetails.seterror("Invalid Credentials!");
					}
			}
			else
			{
				usersdetails.setresult("Failed");
				usersdetails.seterror("Error in api backend connectivity !");
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
		return usersdetails;
	}	
	
	
	public usersdetails deleteusers(usersdetails _usersdetails)
	{
		Connection _Connection = MYSQLConnection.GetConnection();
		
		try
		{
			if(_Connection!=null)
			{
				PreparedStatement _PreparedStatement = null;
				MYSQLHelper _MYSQLHelper = new MYSQLHelper();
				ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT customer_Id FROM users where user_id='"+_usersdetails.userid+"'",_Connection);
					if (_ResultSet.next())
					{
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Calendar cal = Calendar.getInstance();
						String date=format.format(cal.getTime());
						_usersdetails.setdeleteddate(date);
						_usersdetails.setis_deleted((true));
						String sInsertStatement ="UPDATE users SET 	is_deleted = ? "+ ",deleted_date = ? "+ " WHERE user_id = ?";
						_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
						_PreparedStatement.setBoolean(1, _usersdetails.is_deleted);
						_PreparedStatement.setString(2,_usersdetails.deleteddate);
						_PreparedStatement.setInt(3, _usersdetails.userid);	
						_PreparedStatement.executeUpdate();
						_usersdetails.setresult("Sucess");
						
					}
					else{
						_usersdetails.setresult("Failed");
						_usersdetails.seterror("Invalid User Id!");
						//logger.error(_auth.errorstatus);
			    	}
			}
			else{
				_usersdetails.setresult("Failed");
				_usersdetails.seterror("Error in api backend connectivity !");
				//logger.error(_auth.errorstatus);
	    	}
		}
		catch (Exception e) {
			_usersdetails.setresult("Failed!"+e.getStackTrace());
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
		return _usersdetails;
	}
	
	public usersdetails updateusersdetails(usersdetails _usersdetails) {
		Connection _Connection = MYSQLConnection.GetConnection();
		 PreparedStatement _PreparedStatement = null;
		 
		try
		{
			
			if(_Connection!=null)
			{
               String _hashPassword = byteArrayToHexString(companydetails.computeHash(_usersdetails.password));
				
				MYSQLHelper _MYSQLHelper = new MYSQLHelper();
				ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT user_id FROM users where user_id='"+_usersdetails.userid+"'",_Connection);
				if (_ResultSet.next())
				{
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Calendar cal = Calendar.getInstance();
					String date=format.format(cal.getTime());
					_usersdetails.setcreateddate(date);	
					_usersdetails.setpassword(_hashPassword);
					
					String sInsertStatement ="UPDATE users SET 	customer_Id = ? "+ ",first_name = ? "+ ",last_name = ? "+ ",email = ? "+ ",phone = ? "+ ",password = ?,is_active = ? "+ " WHERE user_id = ?";
					_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
					_PreparedStatement.setInt(1, _usersdetails.customerid);
					_PreparedStatement.setString(2, _usersdetails.firstname);		
					_PreparedStatement.setString(3, _usersdetails.lastname);
					_PreparedStatement.setString(4, _usersdetails.email);	
					_PreparedStatement.setString(5, _usersdetails.phone);	
					_PreparedStatement.setString(6, _usersdetails.password);
					_PreparedStatement.setBoolean(7, _usersdetails.is_active);
					_PreparedStatement.setInt(8, _usersdetails.userid);
					_PreparedStatement.executeUpdate();
					_usersdetails.setresult("Sucess");
				}
				else{
					_usersdetails.setresult("Failed");
					_usersdetails.seterror("Invalid User Id!");
					//logger.error(_auth.errorstatus);
		    	}
			}
			else{
				_usersdetails.setresult("Failed");
				_usersdetails.seterror("Error in api backend connectivity !");
				//logger.error(_auth.errorstatus);
	    	}
		}
		catch (Exception e) {
			_usersdetails.setresult("Failed!"+e.getStackTrace());
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
	return _usersdetails;
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
