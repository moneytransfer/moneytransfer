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

public class BeneficiaryDetails {

	
	public int BeneficiaryId;
	public int CompanyId;
	public int BeneficiaryTypeId;	
	public int CustomerId;
	public String FirstName;	
	public String LastName;	
	public String Phone;
	public String Email;
	public String Address1;
	public String Address2;
	public String City;
	public String State;
	public String ZipCode;
	public int CountryId;
	public String DOB;
	public boolean IsActive;
	public String BankName;
	public String AccountNumber;
	public String RoutingNumber;
	public String BICCode;
	public boolean IsDeleted;
	public String CreatedDate;
	public String DeletedDate;
	public String Result;
	public String Error;
	
	
	private void setBeneficiaryId(int BeneficiaryId){
		this.BeneficiaryId = BeneficiaryId;
	}	
	private int getBeneficiaryId(){
		return BeneficiaryId;
	}
	
	private void setCompanyId(int CompanyId){
		this.CompanyId = CompanyId;
	}	
	private int getCompanyId(){
		return CompanyId;
	}
	private void setBeneficiaryTypeId(int BeneficiaryTypeId){
		this.BeneficiaryTypeId = BeneficiaryTypeId;
	}	
	private int getBeneficiaryTypeId(){
		return BeneficiaryTypeId;
	}
	private void setCustomerId(int CustomerId){
		this.CustomerId = CustomerId;
	}	
	private int getCustomerId(){
		return CustomerId;
	}
	
	private void setFirstName(String FirstName){
		this.FirstName = FirstName;
	}	
	private String getFirstName(){
		return FirstName;
	}
	private void setLastName(String LastName){
		this.LastName = LastName;
	}	
	private String getLastName(){
		return LastName;
	}
	
	private void setPhone(String Phone){
		this.Phone = Phone;
	}	
	private String getPhone(){
		return Phone;
	}
	private void setEmail(String Email){
		this.Email = Email;
	}	
	private String getEmail(){
		return Email;
	}
	private void setAddress1(String Address1){
		this.Address1 = Address1;
	}	
	private String getAddress1(){
		return Address1;
	}
	private void setAddress2(String Address2){
		this.Address2 = Address2;
	}	
	private String getAddress2(){
		return Address2;
	}
	private void setCity(String City){
		this.City = City;
	}	
	private String getCity(){
		return City;
	}
	private void setState(String State){
		this.State = State;
	}	
	private String getState(){
		return State;
	}
	private void setZipCode(String ZipCode){
		this.ZipCode = ZipCode;
	}	
	private String getZipCode(){
		return ZipCode;
	}
	private void setCountryId(int CountryId){
		this.CountryId = CountryId;
	}	
	private int getCountryId(){
		return CountryId;
	}
	
	private void setDOB(String DOB){
		this.DOB = DOB;
	}	
	private String getDOB(){
		return DOB;
	}
	private void setCreatedDate(String CreatedDate){
		this.CreatedDate = CreatedDate;
	}	
	private String getCreatedDate(){
		return CreatedDate;
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
	private void setBankName(String BankName){
		this.BankName = BankName;
	}	
	private String getBankName(){
		return BankName;
	}
	
	private void setAccountNumber(String AccountNumber){
		this.AccountNumber = AccountNumber;
	}	
	private String getAccountNumber(){
		return AccountNumber;
	}
	
	private void setRoutingNumber(String RoutingNumber){
		this.RoutingNumber = RoutingNumber;
	}	
	private String getRoutingNumber(){
		return RoutingNumber;
	}
	
	private void setBICCode(String BICCode){
		this.BICCode = BICCode;
	}	
	private String getBICCode(){
		return BICCode;
	}
	
	public BeneficiaryDetails addBeneficiaryDetails(BeneficiaryDetails _BeneficiaryDetails) {	
		Connection _Connection = MYSQLConnection.GetConnection();
		 PreparedStatement _PreparedStatement = null;
			try
			{
				if(_Connection!=null)
				{
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Calendar cal = Calendar.getInstance();
					String date=format.format(cal.getTime());
					_BeneficiaryDetails.setCreatedDate(date);	
					MYSQLHelper _MYSQLHelper = new MYSQLHelper();
					
					ResultSet _ResultSetcompany = _MYSQLHelper.GetResultSet("SELECT * FROM company where Company_Id='"+_BeneficiaryDetails.CompanyId+"'",_Connection);
					if (_ResultSetcompany.next())
					{
						
						ResultSet _ResultSetBeneficiaryType = _MYSQLHelper.GetResultSet("SELECT * FROM beneficiarytype where BeneficiaryTypeId='"+_BeneficiaryDetails.BeneficiaryTypeId+"'",_Connection);
						if (_ResultSetBeneficiaryType.next())
						{
							//ResultSet _ResultSetCustomer = _MYSQLHelper.GetResultSet("SELECT * FROM Customer where customer_Id='"+_BeneficiaryDetails.CustomerId+"'",_Connection);
							//if (_ResultSetCustomer.next())
						//	{
								ResultSet _ResultSetCountry = _MYSQLHelper.GetResultSet("SELECT * FROM country where country_id='"+_BeneficiaryDetails.CountryId+"'",_Connection);
								if (_ResultSetCountry.next())
								{
									
									if(_BeneficiaryDetails.BeneficiaryId<=0)
									{
										String sInsertStatement = "INSERT INTO beneficiary( CompanyId, BeneficiaryTypeId, CustomerId,FirstName,LastName,Phone,Email,Address1,Address2,City,State,ZipCode,CountryId,DOB,IsActive,BankName,AccountNumber,RoutingNumber,BICCode,CreatedDate)";
										 sInsertStatement = sInsertStatement + " VALUES(?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?,?,?,?,?)";
										   _PreparedStatement = _Connection.prepareStatement(sInsertStatement);
											_PreparedStatement.setInt(1, _BeneficiaryDetails.CompanyId);							
											_PreparedStatement.setInt(2, _BeneficiaryDetails.BeneficiaryTypeId); 
											_PreparedStatement.setInt(3, _BeneficiaryDetails.CustomerId); 
											_PreparedStatement.setString(4, _BeneficiaryDetails.FirstName); 
											_PreparedStatement.setString(5, _BeneficiaryDetails.LastName); 
											_PreparedStatement.setString(6, _BeneficiaryDetails.Phone); 
											_PreparedStatement.setString(7, _BeneficiaryDetails.Email); 
											_PreparedStatement.setString(8, _BeneficiaryDetails.Address1);
											_PreparedStatement.setString(9, _BeneficiaryDetails.Address2); 										
											
											_PreparedStatement.setString(10, _BeneficiaryDetails.City);							
											_PreparedStatement.setString(11, _BeneficiaryDetails.State); 
											_PreparedStatement.setString(12, _BeneficiaryDetails.ZipCode); 
											_PreparedStatement.setInt(13, _BeneficiaryDetails.CountryId); 
											_PreparedStatement.setString(14, _BeneficiaryDetails.DOB); 
											_PreparedStatement.setBoolean(15, _BeneficiaryDetails.IsActive); 
											_PreparedStatement.setString(16, _BeneficiaryDetails.BankName);
											_PreparedStatement.setString(17, _BeneficiaryDetails.AccountNumber);
											_PreparedStatement.setString(18, _BeneficiaryDetails.RoutingNumber);
											_PreparedStatement.setString(19, _BeneficiaryDetails.BICCode);
											
											_PreparedStatement.setString(20, _BeneficiaryDetails.CreatedDate); 
											_PreparedStatement.executeUpdate();
											_BeneficiaryDetails.setResult("Sucess");
											ResultSet _ResultSetld = _MYSQLHelper.GetResultSet("SELECT MAX(BeneficiaryId) AS BeneficiaryId FROM beneficiary",_Connection);
											if (_ResultSetld.next()){
											int lastid = _ResultSetld.getInt("BeneficiaryId");								
											_BeneficiaryDetails.setBeneficiaryId(lastid);
											clear(_BeneficiaryDetails);
											}
										
									}
									else
									{
										ResultSet _ResultSetBeneficiary = _MYSQLHelper.GetResultSet("SELECT BeneficiaryId FROM beneficiary where BeneficiaryId='"+_BeneficiaryDetails.BeneficiaryId+"'",_Connection);
										if (_ResultSetBeneficiary.next())
										{
											String sInsertStatement ="UPDATE beneficiary SET CompanyId = ?,BeneficiaryTypeId = ? ,CustomerId =?,FirstName = ? ,LastName =?,Phone = ?,Email = ?,Address1 = ?,Address2 = ?,City = ?,State = ?,ZipCode = ?,CountryId = ?,DOB = ?,IsActive = ?,BankName = ?,AccountNumber = ?,RoutingNumber = ?,BICCode = ? "+ " WHERE BeneficiaryId = ?";
											_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
											_PreparedStatement.setInt(1, _BeneficiaryDetails.CompanyId);							
											_PreparedStatement.setInt(2, _BeneficiaryDetails.BeneficiaryTypeId);
											_PreparedStatement.setInt(3, _BeneficiaryDetails.CustomerId);
											_PreparedStatement.setString(4, _BeneficiaryDetails.FirstName);
											_PreparedStatement.setString(5, _BeneficiaryDetails.LastName);
											_PreparedStatement.setString(6, _BeneficiaryDetails.Phone);
											_PreparedStatement.setString(7, _BeneficiaryDetails.Email);
											_PreparedStatement.setString(8, _BeneficiaryDetails.Address1);
											_PreparedStatement.setString(9, _BeneficiaryDetails.Address2);
											_PreparedStatement.setString(10, _BeneficiaryDetails.City);
											_PreparedStatement.setString(11, _BeneficiaryDetails.State);
											_PreparedStatement.setString(12, _BeneficiaryDetails.ZipCode);
											_PreparedStatement.setInt(13, _BeneficiaryDetails.CountryId);
											_PreparedStatement.setString(14, _BeneficiaryDetails.DOB);
											_PreparedStatement.setBoolean(15, _BeneficiaryDetails.IsActive);
											_PreparedStatement.setString(16, _BeneficiaryDetails.BankName);
											_PreparedStatement.setString(17, _BeneficiaryDetails.AccountNumber);
											_PreparedStatement.setString(18, _BeneficiaryDetails.RoutingNumber);
											_PreparedStatement.setString(19, _BeneficiaryDetails.BICCode);
											_PreparedStatement.setInt(20, _BeneficiaryDetails.BeneficiaryId);
										    _PreparedStatement.executeUpdate();
											_BeneficiaryDetails.setResult("Sucess");
											clear(_BeneficiaryDetails);
											
										}
										else{
											_BeneficiaryDetails.setResult("Failed!");
											_BeneficiaryDetails.setError("Invalid Beneficiary Id !");
											clear(_BeneficiaryDetails);
									  }
									}
								}
								else{
									_BeneficiaryDetails.setResult("Failed!");
									_BeneficiaryDetails.setError("Invalid Country Id !");
									clear(_BeneficiaryDetails);
								}
						//	}
						//	else{
							//	_BeneficiaryDetails.setResult("Failed!");
							////	_BeneficiaryDetails.setError("Invalid Customer Id !");
							//	clear(_BeneficiaryDetails);
							//}
						}
						else{
							_BeneficiaryDetails.setResult("Failed!");
							_BeneficiaryDetails.setError("Invalid beneficiary Type Id !");
							clear(_BeneficiaryDetails);
						}
						
					}
					else{
						_BeneficiaryDetails.setResult("Failed!");
						_BeneficiaryDetails.setError("Invalid Compay Id !");
						clear(_BeneficiaryDetails);
					}
				}
				else{
					_BeneficiaryDetails.setResult("Failed!");
					_BeneficiaryDetails.setError("Error in api backend connectivity !");
					clear(_BeneficiaryDetails);
				}
			}
			
			catch (Exception e) {
				_BeneficiaryDetails.setResult("Failed!");
				//_BeneficiaryDetails.setError(e.getMessage() + " Stack Trace: " + e.getStackTrace());
				clear(_BeneficiaryDetails);
			}
		return _BeneficiaryDetails;
	}
	
	
	public BeneficiaryDetails deleteBeneficiaryDetails(BeneficiaryDetails _BeneficiaryDetails) {
		Connection _Connection = MYSQLConnection.GetConnection();
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		 PreparedStatement _PreparedStatement = null;
			try
			{
				if(_Connection!=null)
				{
					ResultSet _ResultSetBeneficiary = _MYSQLHelper.GetResultSet("SELECT BeneficiaryId FROM beneficiary where BeneficiaryId='"+_BeneficiaryDetails.BeneficiaryId+"'",_Connection);
					if (_ResultSetBeneficiary.next())
					{
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Calendar cal = Calendar.getInstance();
						String date=format.format(cal.getTime());
						_BeneficiaryDetails.setDeletedDate(date);
						_BeneficiaryDetails.setIsDeleted((true));
						
						String sInsertStatement ="UPDATE beneficiary SET IsDeleted = ? "+ ",DeletedDate = ? "+ " WHERE BeneficiaryId = ?";
						_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
						_PreparedStatement.setBoolean(1, _BeneficiaryDetails.IsDeleted);
						_PreparedStatement.setString(2,_BeneficiaryDetails.DeletedDate);
						_PreparedStatement.setInt(3, _BeneficiaryDetails.BeneficiaryId);	
						_PreparedStatement.executeUpdate();
						_BeneficiaryDetails.setResult("Sucess");
					}
					else
					{
						_BeneficiaryDetails.setResult("Failed!");
						_BeneficiaryDetails.setError("Invalid Beneficiary Id !");
						clear(_BeneficiaryDetails);
					}
				}
				else{
					_BeneficiaryDetails.setResult("Failed!");
					_BeneficiaryDetails.setError("Error in api backend connectivity !");
					clear(_BeneficiaryDetails);
				}
			}
			catch (Exception e) {
				clear(_BeneficiaryDetails);
			}
		
		return _BeneficiaryDetails;
	}
	
	
	public static ArrayList<BeneficiaryDetails> getBeneficiaryDetails( int Id) {
		Connection _Connection = MYSQLConnection.GetConnection();
		
		ArrayList<BeneficiaryDetails> _BeneficiaryDetailsDetaillist = new ArrayList<BeneficiaryDetails>();
		
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		 try
			{
			
			 if(_Connection!=null)			
			
				{
				
				ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM beneficiary where CustomerId='"+Id+"' and IsDeleted=0",_Connection);
				
					while  (_ResultSet.next())
					{
						 BeneficiaryDetails _BeneficiaryDetails=new BeneficiaryDetails();
						
						_BeneficiaryDetails.setBeneficiaryId(_ResultSet.getInt("BeneficiaryId"));					
						_BeneficiaryDetails.setCompanyId(_ResultSet.getInt("CompanyId"));
						_BeneficiaryDetails.setBeneficiaryTypeId(_ResultSet.getInt("BeneficiaryTypeId"));					
					
						_BeneficiaryDetails.setCustomerId(_ResultSet.getInt("CustomerId"));					
						_BeneficiaryDetails.setFirstName(_ResultSet.getString("FirstName"));
						_BeneficiaryDetails.setLastName(_ResultSet.getString("LastName"));					
						_BeneficiaryDetails.setPhone(_ResultSet.getString("Phone"));
						_BeneficiaryDetails.setEmail(_ResultSet.getString("Email"));					
						_BeneficiaryDetails.setAddress1(_ResultSet.getString("Address1"));
						_BeneficiaryDetails.setAddress2(_ResultSet.getString("Address2"));					
						_BeneficiaryDetails.setCity(_ResultSet.getString("City"));
						_BeneficiaryDetails.setState(_ResultSet.getString("State"));					
						_BeneficiaryDetails.setZipCode(_ResultSet.getString("ZipCode"));						
						_BeneficiaryDetails.setCountryId(_ResultSet.getInt("CountryId"));					
						_BeneficiaryDetails.setDOB(_ResultSet.getString("DOB"));
						_BeneficiaryDetails.setIsActive(_ResultSet.getBoolean("IsActive"));
						_BeneficiaryDetails.setIsDeleted(_ResultSet.getBoolean("IsDeleted"));
						_BeneficiaryDetails.setCreatedDate(_ResultSet.getString("CreatedDate"));
						_BeneficiaryDetails.setDeletedDate(_ResultSet.getString("DeletedDate"));	
						
						_BeneficiaryDetails.setBankName(_ResultSet.getString("BankName"));
						_BeneficiaryDetails.setAccountNumber(_ResultSet.getString("AccountNumber"));
						_BeneficiaryDetails.setRoutingNumber(_ResultSet.getString("RoutingNumber"));
						_BeneficiaryDetails.setBICCode(_ResultSet.getString("BICCode"));
						_BeneficiaryDetails.setResult("Sucess");						
						_BeneficiaryDetailsDetaillist.add(_BeneficiaryDetails);
						
					}
					 _ResultSet.close();			
				 
				}
			
			}
		 catch(Exception e){
			// clear(_BeneficiaryDetails);
		 }
		 finally {
			
				if (_Connection != null) {
					try {
						_Connection.close();
					} catch (SQLException e) {
					//	clear(_BeneficiaryDetails);
					}
				}
			}	
		
		return _BeneficiaryDetailsDetaillist;
	}
	
	public BeneficiaryDetails getBeneficiaryDetailsById(BeneficiaryDetails _BeneficiaryDetails)
	{
	
		Connection _Connection = MYSQLConnection.GetConnection();
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		if(_Connection!=null)
		{
			try{
				ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM beneficiary where BeneficiaryId='"+_BeneficiaryDetails.BeneficiaryId+"'",_Connection);
				if(_ResultSet.next())
				{
					_BeneficiaryDetails.setBeneficiaryId(_ResultSet.getInt("BeneficiaryId"));					
					_BeneficiaryDetails.setCompanyId(_ResultSet.getInt("CompanyId"));
					_BeneficiaryDetails.setBeneficiaryTypeId(_ResultSet.getInt("BeneficiaryTypeId"));				
					_BeneficiaryDetails.setCustomerId(_ResultSet.getInt("CustomerId"));					
					_BeneficiaryDetails.setFirstName(_ResultSet.getString("FirstName"));
					_BeneficiaryDetails.setLastName(_ResultSet.getString("LastName"));					
					_BeneficiaryDetails.setPhone(_ResultSet.getString("Phone"));
					_BeneficiaryDetails.setEmail(_ResultSet.getString("Email"));					
					_BeneficiaryDetails.setAddress1(_ResultSet.getString("Address1"));
					_BeneficiaryDetails.setAddress2(_ResultSet.getString("Address2"));					
					_BeneficiaryDetails.setCity(_ResultSet.getString("City"));
					_BeneficiaryDetails.setState(_ResultSet.getString("State"));					
					_BeneficiaryDetails.setZipCode(_ResultSet.getString("ZipCode"));						
					_BeneficiaryDetails.setCountryId(_ResultSet.getInt("CountryId"));					
					_BeneficiaryDetails.setDOB(_ResultSet.getString("DOB"));
					_BeneficiaryDetails.setIsActive(_ResultSet.getBoolean("IsActive"));
					_BeneficiaryDetails.setIsDeleted(_ResultSet.getBoolean("IsDeleted"));
					_BeneficiaryDetails.setCreatedDate(_ResultSet.getString("CreatedDate"));
					_BeneficiaryDetails.setDeletedDate(_ResultSet.getString("DeletedDate"));
					_BeneficiaryDetails.setBankName(_ResultSet.getString("BankName"));
					_BeneficiaryDetails.setAccountNumber(_ResultSet.getString("AccountNumber"));
					_BeneficiaryDetails.setRoutingNumber(_ResultSet.getString("RoutingNumber"));
					_BeneficiaryDetails.setBICCode(_ResultSet.getString("BICCode"));
					_BeneficiaryDetails.setResult("Sucess");					
				}
				else{
					_BeneficiaryDetails.setResult("Failed!");
					_BeneficiaryDetails.setError("Invalid beneficiary Id !");
					clear(_BeneficiaryDetails);
				}
			}
			catch (Exception e) {
				clear(_BeneficiaryDetails);
			}
			finally {
				if (_Connection != null) {
					try {
						_Connection.close();
					} catch (SQLException e) {					
					}
				}
			}
		}
		else{
			_BeneficiaryDetails.setResult("Failed!");
			_BeneficiaryDetails.setError("Error in api backend connectivity !");
			clear(_BeneficiaryDetails);
		}
		return _BeneficiaryDetails;
	}
	
	
	
	
	public BeneficiaryDetails clear(BeneficiaryDetails _BeneficiaryDetails) {
		
		_BeneficiaryDetails.setCompanyId(0);
		_BeneficiaryDetails.setBeneficiaryTypeId(0);		
		_BeneficiaryDetails.setCustomerId(0);
		_BeneficiaryDetails.setFirstName("");
		_BeneficiaryDetails.setLastName("");
		_BeneficiaryDetails.setPhone("");
		_BeneficiaryDetails.setEmail("");
		_BeneficiaryDetails.setAddress1("");
		_BeneficiaryDetails.setAddress2("");
		_BeneficiaryDetails.setCity("");
		_BeneficiaryDetails.setState("");
		_BeneficiaryDetails.setZipCode("");
		_BeneficiaryDetails.setCountryId(0);
		_BeneficiaryDetails.setDOB("");
		_BeneficiaryDetails.setBankName("");
		_BeneficiaryDetails.setAccountNumber("");
		_BeneficiaryDetails.setRoutingNumber("");
		_BeneficiaryDetails.setBICCode("");
		return _BeneficiaryDetails;
		
	}
}
