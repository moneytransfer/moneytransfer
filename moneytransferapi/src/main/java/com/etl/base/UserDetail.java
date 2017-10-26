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

public class UserDetail {
	public int UserId;
	public int CompanyId;
	public String FirstName;
	public String LastName;
	public String Email;	
	public String Phone;
	public String Password;	
	public String CreatedDate;	
	public String ProfileImage;	
	public String CountryId;
	public boolean	IsActive;
	public boolean	IsDeleted;
	public String 	DeletedDate;
	public String Result;
	public String Error;
	
	

	private void setUserId(int UserId){
		this.UserId = UserId;
	}	
	private int getUserId(){
		return UserId;
	}
	
	private void setCompanyId(int CompanyId){
		this.CompanyId = CompanyId;
	}	
	private int getCompanyId(){
		return CompanyId;
	}
	private void setUserFirstName(String UserFirstName){
		this.FirstName = UserFirstName;
	}	
	private String getUserFirstName(){
		return FirstName;
	}
	private void setUserlastName(String UserlastName){
		this.LastName = UserlastName;
	}	
	private String getUserlastName(){
		return LastName;
	}

	private void setUserEmail(String UserEmail){
		this.Email = UserEmail;
	}	
	private String getUserEmail(){
		return Email;
	}
	private void setUserPhone(String UserPhone){
		this.Phone = UserPhone;
	}	
	private String getUserPhone(){
		return Phone;
	}
	private void setUserPassword(String UserPassword){
		this.Password = UserPassword;
	}	
	//public String getpassword(){
		//return password;UserProfileImage
	//}
	
	private void setCountry(String CountryId){
		this.CountryId = CountryId;
	}	
	private String getCountry(){
		return CountryId;
	}
	private void setUserCreatedDate(String UserCreatedDate){
		this.CreatedDate = UserCreatedDate;
	}	
	private String getUserCreatedDate(){
		return CreatedDate;
	}
	private void setUserProfileImage(String UserProfileImage){
		this.ProfileImage = UserProfileImage;
	}	
	private String getUserProfileImage(){
		return ProfileImage;
	}
	
	private void setUserIsActive(boolean UserIsActive){
		this.IsActive = UserIsActive;
	}	
	private boolean getUserIsActive(){
		return IsActive;
	}
	private void setUserIsDeleted(boolean UserIsDeleted){
		this.IsDeleted = UserIsDeleted;
	}	
	private boolean getUserIsDeleted(){
		return IsDeleted;
	}
	private void setUserDeletedDate(String UserDeletedDate){
		this.DeletedDate = UserDeletedDate;
	}	
	private String getUserDeletedDate(){
		return DeletedDate;
	}
	private void setUserResult(String UserResult){
		this.Result = UserResult;
	}	
	private String getUserResult(){
		return Result;
	}
	private void setUserError(String UserError){
		this.Error = UserError;
	}	
	private String getUserError(){
		return Error;
	}
	
	
	public UserDetail addUser(UserDetail _usersdetails) {
		Connection _Connection = MYSQLConnection.GetConnection();
		 PreparedStatement _PreparedStatement = null;
		
		 try
		 {
			 String _hashPassword = byteArrayToHexString(UserDetail.computeHash(_usersdetails.Password));
			 MYSQLHelper _MYSQLHelper = new MYSQLHelper();
			 _usersdetails.setUserPassword(_hashPassword);	
			 if(_Connection!=null)
			 {
				 ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT email FROM users where email='"+_usersdetails.Email+"'",_Connection);
					if (!_ResultSet.next())
					{
						String _query="SELECT country_id FROM country where country_id='"+_usersdetails.CountryId+"'";
						ResultSet _ResultSetcountry = _MYSQLHelper.GetResultSet(_query,_Connection);
						if (_ResultSetcountry.next())
							{
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Calendar cal = Calendar.getInstance();
						String date=format.format(cal.getTime());
						_usersdetails.setUserCreatedDate(date);	
						_usersdetails.setUserPassword(_hashPassword);
						
						String sInsertStatement = "INSERT INTO users(Company_Id,first_name,last_name,email,phone,password,country_id,profile_image,is_active,create_date)";
						 sInsertStatement = sInsertStatement + " VALUES(?, ?, ?, ?, ?, ?,?,?,?,?)";
						 
						   _PreparedStatement = _Connection.prepareStatement(sInsertStatement);
							_PreparedStatement.setInt(1, _usersdetails.CompanyId);							
							_PreparedStatement.setString(2, _usersdetails.FirstName);		
							_PreparedStatement.setString(3, _usersdetails.LastName);
							_PreparedStatement.setString(4, _usersdetails.Email);	
							_PreparedStatement.setString(5, _usersdetails.Phone);	
							_PreparedStatement.setString(6, _usersdetails.Password);
							_PreparedStatement.setString(7, _usersdetails.CountryId);
							_PreparedStatement.setString(8, _usersdetails.ProfileImage);	
							_PreparedStatement.setBoolean(9, _usersdetails.IsActive);
							_PreparedStatement.setString(10, _usersdetails.CreatedDate);
							_PreparedStatement.executeUpdate();
							_usersdetails.setUserPassword("xxxxxxxxxxxxxxxxxxxxxx");							
							_usersdetails.setUserResult("Sucess");
							ResultSet _ResultSetld = _MYSQLHelper.GetResultSet("SELECT MAX(user_id) AS user_id FROM users",_Connection);
							if (_ResultSetld.next()){
							int lastid = _ResultSetld.getInt("user_id");								
							_usersdetails.setUserId(lastid);}
						}
					else{
						_usersdetails.setUserResult("Failed");
						_usersdetails.setUserError("Invalid Country-Id!");
						//logger.error(_auth.errorstatus);
			 	}
					}
					else{
						_usersdetails.setUserResult("Failed");
						_usersdetails.setUserError("Email_id is already used!");
						//logger.error(_auth.errorstatus);
			    	}
			 }
			 else{
				 _usersdetails.setUserResult("Failed");
				 _usersdetails.setUserError("Error in api backend connectivity !");
					//logger.error(_auth.errorstatus);
		    	}
			 
		 }
		 catch (Exception e) {
			 e.printStackTrace();
			_usersdetails.setUserResult("Some error occurred!");
		}
		 finally {
			 if (_Connection != null) {
					try {
						_Connection.close();
						clearall(_usersdetails);
					} catch (SQLException e) {
						//logger.error(e.getMessage() + " Stack Trace: " + e.getStackTrace());
					}
				}
		}
         return _usersdetails;
   }
	
	public UserDetail loginUser(UserDetail usersdetails)
	{
		Connection _Connection = MYSQLConnection.GetConnection();	
		try
		{
			if(_Connection!=null)
			{
				String _hashPassword = byteArrayToHexString(CompanyDetail.computeHash(usersdetails.Password));			
				MYSQLHelper _MYSQLHelper = new MYSQLHelper();
				usersdetails.setUserPassword(_hashPassword);			
				ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM users where email='"+usersdetails.Email+"' and password ='"+usersdetails.Password+"'",_Connection);
					if (_ResultSet.next())
					{
						usersdetails.setUserId(_ResultSet.getInt("user_id"));
						usersdetails.setCompanyId(_ResultSet.getInt("Company_Id"));
						usersdetails.setUserFirstName(_ResultSet.getString("first_name"));
						usersdetails.setUserlastName(_ResultSet.getString("last_name"));
						usersdetails.setUserPhone(_ResultSet.getString("phone"));
						usersdetails.setUserCreatedDate(_ResultSet.getString("create_date"));
						usersdetails.setUserProfileImage(_ResultSet.getString("profile_image"));
						usersdetails.setCountry(_ResultSet.getString("country_id"));
						usersdetails.setUserIsActive(_ResultSet.getBoolean("is_active"));
						usersdetails.setUserIsDeleted(_ResultSet.getBoolean("is_deleted"));
						usersdetails.setUserDeletedDate(_ResultSet.getString("deleted_date"));
						usersdetails.setUserResult("Sucess");
						usersdetails.setUserPassword("xxxxxxxxxxxxxxxxxxxxxx");
					}
					
					else
					{
						usersdetails.setUserResult("Failed");
						usersdetails.setUserResult("Invalid Credentials!");
					}
			}
			else
			{
				usersdetails.setUserResult("Failed");
				usersdetails.setUserResult("Error in api backend connectivity !");
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
	
	
	public UserDetail deleteUser(UserDetail _usersdetails)
	{
		Connection _Connection = MYSQLConnection.GetConnection();
		
		try
		{
			if(_Connection!=null)
			{
				PreparedStatement _PreparedStatement = null;
				MYSQLHelper _MYSQLHelper = new MYSQLHelper();
				ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT user_id FROM users where user_id='"+_usersdetails.UserId+"'",_Connection);
					if (_ResultSet.next())
					{
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Calendar cal = Calendar.getInstance();
						String date=format.format(cal.getTime());
						_usersdetails.setUserDeletedDate(date);
						_usersdetails.setUserIsDeleted((true));
						String sInsertStatement ="UPDATE users SET 	is_deleted = ? "+ ",deleted_date = ? "+ " WHERE user_id = ?";
						_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
						_PreparedStatement.setBoolean(1, _usersdetails.IsDeleted);
						_PreparedStatement.setString(2,_usersdetails.DeletedDate);
						_PreparedStatement.setInt(3, _usersdetails.UserId);	
						_PreparedStatement.executeUpdate();
						_usersdetails.setUserResult("Sucess");
						_usersdetails.setUserPassword("xxxxxxxxxxxxxxx");
					}
					else{
						_usersdetails.setUserResult("Failed");
						_usersdetails.setUserError("Invalid User Id!");
						//logger.error(_auth.errorstatus);
			    	}
			}
			else{
				_usersdetails.setUserResult("Failed");
				_usersdetails.setUserError("Error in api backend connectivity !");
				//logger.error(_auth.errorstatus);
	    	}
		}
		catch (Exception e) {
			e.printStackTrace();
			_usersdetails.setUserResult("Failed!"+e.getStackTrace());
		}
		finally {
			if (_Connection != null) {
				try {
					_Connection.close();
					clearall(_usersdetails);
				} catch (SQLException e) {
					//logger.error(e.getMessage() + " Stack Trace: " + e.getStackTrace());
				}
			}
		}
		return _usersdetails;
	}
	
	public UserDetail updateUserDetail(UserDetail _usersdetails) {
		Connection _Connection = MYSQLConnection.GetConnection();
		 PreparedStatement _PreparedStatement = null;
		
		try
		{
			
			if(_Connection!=null)
			{
				
				String strpassword=_usersdetails.Password;
				if(strpassword != "" | strpassword.length() != 0)
				{
					
					String _hashPassword = byteArrayToHexString(CompanyDetail.computeHash(_usersdetails.Password));
					 _usersdetails.setUserPassword(_hashPassword);  
					 
				}
				
             
				
				MYSQLHelper _MYSQLHelper = new MYSQLHelper();
				ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT user_id FROM users where user_id='"+_usersdetails.UserId+"'",_Connection);
				if (_ResultSet.next())
				{
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Calendar cal = Calendar.getInstance();
					String date=format.format(cal.getTime());
					_usersdetails.setUserDeletedDate(date);	
					

					if(strpassword != "" | strpassword.length() != 0){					
						String sInsertStatement ="UPDATE users SET 	password = ? WHERE user_id = ?";
						_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
						_PreparedStatement.setString(1, _usersdetails.Password);
						_PreparedStatement.setInt(2, _usersdetails.UserId);
						_PreparedStatement.executeUpdate();
						 _usersdetails.setUserPassword("xxxxxxxxxxxxxxxxxxxxxx"); 	
					}
					
					String sInsertStatement ="UPDATE users SET 	Company_Id = ?,first_name = ? ,last_name = ? ,email = ? ,phone = ? "
							+ ",profile_image = ?,country_id = ?,is_active = ? "+ " WHERE user_id = ?";
					_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
					_PreparedStatement.setInt(1, _usersdetails.CompanyId);
					_PreparedStatement.setString(2, _usersdetails.FirstName);		
					_PreparedStatement.setString(3, _usersdetails.LastName);
					_PreparedStatement.setString(4, _usersdetails.Email);	
					_PreparedStatement.setString(5, _usersdetails.Phone);	
					_PreparedStatement.setString(6, _usersdetails.ProfileImage);
					_PreparedStatement.setString(7, _usersdetails.CountryId);
					_PreparedStatement.setBoolean(8, _usersdetails.IsActive);
					_PreparedStatement.setInt(9, _usersdetails.UserId);
					_PreparedStatement.executeUpdate();
					_usersdetails.setUserResult("Sucess");
				}
				else{
					_usersdetails.setUserResult("Failed");
					_usersdetails.setUserResult("Invalid User Id!");
					//logger.error(_auth.errorstatus);
		    	}
			}
			else{
				_usersdetails.setUserResult("Failed");
				_usersdetails.setUserResult("Error in api backend connectivity !");
				//logger.error(_auth.errorstatus);
	    	}
		}
		catch (Exception e) {
			e.printStackTrace();
			_usersdetails.setUserResult("Failed!"+e.getStackTrace());
		}
		finally {
			if (_Connection != null) {
				try {
					_Connection.close();
					clearall(_usersdetails);
				} catch (SQLException e) {
					//logger.error(e.getMessage() + " Stack Trace: " + e.getStackTrace());
				}
			}
		}
	return _usersdetails;
	}
	
	public UserDetail getUserDetail(UserDetail usersdetails) {
		
		
		Connection _Connection = MYSQLConnection.GetConnection();
		
		 try
			{
				
				if(_Connection!=null)
				{
					
					MYSQLHelper _MYSQLHelper = new MYSQLHelper();
					ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM users where user_id='"+usersdetails.UserId+"'",_Connection);
					if (_ResultSet.next())
					{
						
						
							usersdetails.setUserId(_ResultSet.getInt("user_id"));
							usersdetails.setCompanyId(_ResultSet.getInt("Company_Id"));
							usersdetails.setUserFirstName(_ResultSet.getString("first_name"));
							usersdetails.setUserlastName(_ResultSet.getString("last_name"));
							usersdetails.setUserPhone(_ResultSet.getString("phone"));
							usersdetails.setUserEmail(_ResultSet.getString("email"));
							usersdetails.setUserCreatedDate(_ResultSet.getString("create_date"));
							usersdetails.setUserProfileImage(_ResultSet.getString("profile_image"));
							usersdetails.setCountry(_ResultSet.getString("country_id"));
							usersdetails.setUserIsActive(_ResultSet.getBoolean("is_active"));
							usersdetails.setUserIsDeleted(_ResultSet.getBoolean("is_deleted"));
							usersdetails.setUserDeletedDate(_ResultSet.getString("deleted_date"));
							usersdetails.setUserResult("Sucess");
						
					}
					else{
						usersdetails.setUserResult("Failed");
						usersdetails.setUserResult("Invalid User Id!");
						//logger.error(_auth.errorstatus);
			    	}
					
				}
				else{
					usersdetails.setUserResult("Failed");
					usersdetails.setUserResult("Error in api backend connectivity !");
					//logger.error(_auth.errorstatus);
		    	}
			}
		 catch(Exception e)
		 {
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
		 return usersdetails; 
	  }
	
	public static ArrayList<UserDetail> getUserDetails(int CompanyId) {
		Connection _Connection = MYSQLConnection.GetConnection();
		
		ArrayList<UserDetail> _UserDetaillist = new ArrayList<UserDetail>();
		
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		
		 try
			{
			 if(CompanyId==0)
				{
				ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM users",_Connection);
				while  (_ResultSet.next())
				{
					
					UserDetail _UserDetail=new UserDetail();
					_UserDetail.setUserId(_ResultSet.getInt("user_id"));
					_UserDetail.setCompanyId(_ResultSet.getInt("Company_Id"));
					_UserDetail.setUserFirstName(_ResultSet.getString("first_name"));
					_UserDetail.setUserlastName(_ResultSet.getString("last_name"));
					_UserDetail.setUserPhone(_ResultSet.getString("phone"));
					_UserDetail.setUserEmail(_ResultSet.getString("email"));
					_UserDetail.setUserCreatedDate(_ResultSet.getString("create_date"));
					_UserDetail.setUserProfileImage(_ResultSet.getString("profile_image"));
					_UserDetail.setCountry(_ResultSet.getString("country_id"));
					_UserDetail.setUserIsActive(_ResultSet.getBoolean("is_active"));
					_UserDetail.setUserIsDeleted(_ResultSet.getBoolean("is_deleted"));
					_UserDetail.setUserDeletedDate(_ResultSet.getString("deleted_date"));
					_UserDetail.setUserResult("Success");
					_UserDetaillist.add(_UserDetail);
					
				}
				
				 _ResultSet.close();
		      }
			 else
			 {
				 ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM users where Company_Id='"+CompanyId+"'",_Connection);
					if (_ResultSet.next())
					{
						UserDetail _UserDetail=new UserDetail();
						_UserDetail.setUserId(_ResultSet.getInt("user_id"));
						_UserDetail.setCompanyId(_ResultSet.getInt("Company_Id"));
						_UserDetail.setUserFirstName(_ResultSet.getString("first_name"));
						_UserDetail.setUserlastName(_ResultSet.getString("last_name"));
						_UserDetail.setUserPhone(_ResultSet.getString("phone"));
						_UserDetail.setUserEmail(_ResultSet.getString("email"));
						_UserDetail.setUserCreatedDate(_ResultSet.getString("create_date"));
						_UserDetail.setUserProfileImage(_ResultSet.getString("profile_image"));
						_UserDetail.setCountry(_ResultSet.getString("country_id"));
						_UserDetail.setUserIsActive(_ResultSet.getBoolean("is_active"));
						_UserDetail.setUserIsDeleted(_ResultSet.getBoolean("is_deleted"));
						_UserDetail.setUserDeletedDate(_ResultSet.getString("deleted_date"));
						_UserDetail.setUserResult("Success");
						_UserDetaillist.add(_UserDetail);
						
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
	
		return _UserDetaillist;
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
			  
			  public UserDetail clearall(UserDetail _UserDetail)
			  {
				  
					_UserDetail.setUserFirstName("");
					_UserDetail.setUserlastName("");
					_UserDetail.setUserPhone("");
					_UserDetail.setUserEmail("");
					_UserDetail.setUserCreatedDate("");
					_UserDetail.setUserProfileImage("");
					_UserDetail.setCountry("");
				  
				  return _UserDetail;
			  }
}
