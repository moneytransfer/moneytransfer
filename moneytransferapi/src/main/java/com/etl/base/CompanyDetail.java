package com.etl.base;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.etl.util.MYSQLConnection;
import com.etl.util.MYSQLHelper;

public class CompanyDetail {
	public int CompanyId;
	public String CompanyName;
	public String Address1;
	public String Address2;
	public String City;
	public String State;
	public String ZipCode;
	public String CountryId;
	public String Email;	
	public String Phone;
	public String BusinessFax;
	public String ContactPerson;
	public String ContactTitle;
	public String NumberofEmployees;
	public String AnnualRevenue;
	public String Industry;
	public String SubIndustry;
	public String SICCode;
	public String SICDescription;
	public String Website;
	public String CompanyNumber;
	public String BusinessID;
	public String CompanyType;
	
	
	
	public String IncorporationDate;
	public String ListofOfficersDueDate;
	public String BusinessLicenseExpDate;
	
	public String CreatedDate;	
	public boolean	IsActive;
	public boolean	IsDeleted;
	public String 	DeletedDate;
	public String Result;
	public String Error;


	private void setCompanyId(int CompanyId){
		this.CompanyId = CompanyId;
	}	
	private int getCompanyId(){
		return CompanyId;
	}
	
	private void setCompanyName(String CompanyName){
		this.CompanyName = CompanyName;
	}	
	private String getCompanyName(){
		return CompanyName;
	}
	
	private void setEmail(String Email){
		this.Email = Email;
	}	
	private String getmEmail(){
		return Email;
	}
	private void setPhone(String Phone){
		this.Phone = Phone;
	}	
	private String getPhone(){
		return Phone;
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
	
	private void setCountry(String CountryId){
		this.CountryId = CountryId;
	}	
	private String getCountry(){
		return CountryId;
	}
	
	
	private void setBusinessFax(String BusinessFax){
		this.BusinessFax = BusinessFax;
	}	
	private String getBusinessFax(){
		return BusinessFax;
	}
	private void setContactPerson(String ContactPerson){
		this.ContactPerson = ContactPerson;
	}	
	private String getContactPerson(){
		return ContactPerson;
	}
	private void setContactTitle(String ContactTitle){
		this.ContactTitle = ContactTitle;
	}	
	private String getContactTitle(){
		return ContactTitle;
	}
	
	
	
	private void setNumberofEmployees(String NumberofEmployees){
		this.NumberofEmployees = NumberofEmployees;
	}	
	private String getNumberofEmployees(){
		return NumberofEmployees;
	}
	private void setAnnualRevenue(String AnnualRevenue){
		this.AnnualRevenue = AnnualRevenue;
	}	
	private String getAnnualRevenue(){
		return AnnualRevenue;
	}
	private void setIndustry(String Industry){
		this.Industry = Industry;
	}	
	private String getIndustry(){
		return Industry;
	}
	private void setSubIndustry(String SubIndustry){
		this.SubIndustry = SubIndustry;
	}	
	private String getSubIndustry(){
		return SubIndustry;
	}
	private void setSICCode(String SICCode){
		this.SICCode = SICCode;
	}	
	private String getSICCode(){
		return SICCode;
	}
	private void setSICDescription(String SICDescription){
		this.SICDescription = SICDescription;
	}	
	private String getSICDescription(){
		return SICDescription;
	}
	private void setWebsite(String Website){
		this.Website = Website;
	}	
	private String getWebsite(){
		return Website;
	}
	private void setCompanyNumber(String CompanyNumber){
		this.CompanyNumber = CompanyNumber;
	}	
	private String getCompanyNumber(){
		return CompanyNumber;
	}
	private void setBusinessID(String BusinessID){
		this.BusinessID = BusinessID;
	}	
	private String getBusinessID(){
		return BusinessID;
	}
	
	private void setCompanyType(String CompanyType){
		this.CompanyType = CompanyType;
	}	
	private String getCompanyType(){
		return CompanyType;
	}
	
	private void setIncorporationDate(String IncorporationDate){
		this.IncorporationDate = IncorporationDate;
	}	
	private String getIncorporationDate(){
		return IncorporationDate;
	}	
	private void setListofOfficersDueDate(String ListofOfficersDueDate){
		this.ListofOfficersDueDate = ListofOfficersDueDate;
	}	
	private String getListofOfficersDueDate(){
		return ListofOfficersDueDate;
	}
	private void setBusinessLicenseExpDate(String BusinessLicenseExpDate){
		this.BusinessLicenseExpDate = BusinessLicenseExpDate;
	}	
	private String getBusinessLicenseExpDate(){
		return BusinessLicenseExpDate;
	}
	
	
	
	private void setCreatedDate(String CreatedDate){
		this.CreatedDate = CreatedDate;
	}	
	private String getCreatedDate(){
		return CreatedDate;
	}
	private void setbIsActive(boolean bIsActive){
		this.IsActive = bIsActive;
	}	
	private boolean getbIsActive(){
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

//final static Logger logger = Logger.getLogger(CompanyDetail.class);
public CompanyDetail addCompany(CompanyDetail _CompanyDetail) {
	Connection _Connection = MYSQLConnection.GetConnection();
	 PreparedStatement _PreparedStatement = null;
	try
	{
		Date _optionaldate = null;
		
					if(_Connection!=null)
					{
						MYSQLHelper _MYSQLHelper = new MYSQLHelper();
						ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT email FROM company where email='"+_CompanyDetail.Email+"'",_Connection);
						if (!_ResultSet.next())
						{	
							String _query="SELECT country_id FROM country where country_id='"+_CompanyDetail.CountryId+"'";
							ResultSet _ResultSetcountry = _MYSQLHelper.GetResultSet(_query,_Connection);
						if (_ResultSetcountry.next())
							{
							SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							Calendar cal = Calendar.getInstance();
							String date=format.format(cal.getTime());
							_CompanyDetail.setCreatedDate(date);	
						
							String sInsertStatement = "INSERT INTO company(name,address1,address2,city,state,country_id,zip_code,email,phone,business_fax, contact_person, contact_title, number_employees, annual_revenue, industry, sub_industry, sic_code, sic_description, website, company_number, business_id, company_type, incorporation_date, listofficers_duedate, businesslicense_expdate,created_date,is_active)";
							 sInsertStatement = sInsertStatement + " VALUES(?, ?, ?, ?, ?, ?,?,?,?,?,?,?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?)";
							_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
							_PreparedStatement.setString(1, _CompanyDetail.CompanyName);							
							_PreparedStatement.setString(2, _CompanyDetail.Address1);		
							_PreparedStatement.setString(3, _CompanyDetail.Address2);
							_PreparedStatement.setString(4, _CompanyDetail.City);	
							_PreparedStatement.setString(5, _CompanyDetail.State);
							_PreparedStatement.setString(6, _CompanyDetail.CountryId);
							_PreparedStatement.setString(7, _CompanyDetail.ZipCode);
							_PreparedStatement.setString(8, _CompanyDetail.Email);
							_PreparedStatement.setString(9, _CompanyDetail.Phone);
							_PreparedStatement.setString(10, _CompanyDetail.BusinessFax);
							_PreparedStatement.setString(11, _CompanyDetail.ContactPerson);
							_PreparedStatement.setString(12, _CompanyDetail.ContactTitle);
							_PreparedStatement.setString(13, _CompanyDetail.NumberofEmployees);
							_PreparedStatement.setString(14, _CompanyDetail.AnnualRevenue);
							_PreparedStatement.setString(15, _CompanyDetail.Industry);
							_PreparedStatement.setString(16, _CompanyDetail.SubIndustry);
							_PreparedStatement.setString(17, _CompanyDetail.SICCode);
							_PreparedStatement.setString(18, _CompanyDetail.SICDescription);
							_PreparedStatement.setString(19, _CompanyDetail.Website);
							_PreparedStatement.setString(20, _CompanyDetail.CompanyNumber);
							_PreparedStatement.setString(21, _CompanyDetail.BusinessID);
							_PreparedStatement.setString(22, _CompanyDetail.CompanyType);
							if(_CompanyDetail.IncorporationDate!="")
							{
								_PreparedStatement.setString(23, _CompanyDetail.IncorporationDate);
							}
							else{
								_PreparedStatement.setDate(23, _optionaldate);
							}
							
							if(_CompanyDetail.ListofOfficersDueDate!="")
							{
								_PreparedStatement.setString(24, _CompanyDetail.ListofOfficersDueDate);
							}
							else{
								_PreparedStatement.setDate(24, _optionaldate);
							}
							
							if(_CompanyDetail.BusinessLicenseExpDate!="")
							{
								_PreparedStatement.setString(25, _CompanyDetail.BusinessLicenseExpDate);
							}
							else{
								
								_PreparedStatement.setDate(25, _optionaldate);
							}
							
							
							_PreparedStatement.setString(26, _CompanyDetail.CreatedDate);							
							_PreparedStatement.setBoolean(27, _CompanyDetail.IsActive);	
							_PreparedStatement.executeUpdate();					
						
							_CompanyDetail.setResult("Sucess");
							ResultSet _ResultSetld = _MYSQLHelper.GetResultSet("SELECT MAX(Company_Id) AS Company_Id FROM company",_Connection);
							if (_ResultSetld.next()){
							int lastid = _ResultSetld.getInt("Company_Id");								
							_CompanyDetail.setCompanyId(lastid);}
							
							clearall(_CompanyDetail);
						}
							else{
							_CompanyDetail.setResult("Failed");
							_CompanyDetail.setResult("Invalid Country-Id!");
								//logger.error(_auth.errorstatus);
					 	}
					}
					else{
						_CompanyDetail.setResult("Failed");
						_CompanyDetail.setResult("Email_id is already used!");
						//logger.error(_auth.errorstatus);
			    	}
				}
		
			else{
					_CompanyDetail.setResult("Failed");
					_CompanyDetail.setError("Error in api backend connectivity !");
					//logger.error(_auth.errorstatus);
		    	}
	  }	
	
	catch (Exception e) {
		_CompanyDetail.setResult("Invalid Customer email-Id, plesae try with valid email-Id!");
	}
	finally
	{
		if (_Connection != null) {
			try {
				_Connection.close();
				clearall(_CompanyDetail);
			} catch (SQLException e) {
				//logger.error(e.getMessage() + " Stack Trace: " + e.getStackTrace());
			}
		}
	}	
	
	return _CompanyDetail;
	
}

public CompanyDetail updateCompany(CompanyDetail _CompanyDetail) {
	Connection _Connection = MYSQLConnection.GetConnection();
	 PreparedStatement _PreparedStatement = null;
	
	try
	{
		if(_Connection!=null)
		{
			Date _optionaldate = null;
				
				MYSQLHelper _MYSQLHelper = new MYSQLHelper();
				ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT Company_Id FROM company where Company_Id='"+_CompanyDetail.CompanyId+"'",_Connection);
				if (_ResultSet.next())
				{	
					ResultSet _ResultSetcountry = _MYSQLHelper.GetResultSet("SELECT country_id FROM country where country_id='"+_CompanyDetail.CountryId+"'",_Connection);
					if (_ResultSetcountry.next())
					{
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Calendar cal = Calendar.getInstance();
					String date=format.format(cal.getTime());
					_CompanyDetail.setCreatedDate(date);					
					String sInsertStatement ="UPDATE company SET name = ? "+ ",address1 = ? "+ ",address2 = ? "+ ",city = ? "+ ",	state = ? "+ ",	zip_code = ? "+ ",country_id = ? "+ ",email = ? "+ ",phone = ? "+ ",business_fax = ? "+ ",contact_person = ? "+ ",contact_title = ? "+ ",number_employees = ? "+ ",annual_revenue = ? "+ ",industry = ? "+ ",sub_industry = ? "+ ",sic_code = ? "+ ",sic_description = ? "+ ",website = ? "+ ",company_number = ? "+ ",business_id = ? "+ ",company_type = ? "+ ",incorporation_date = ? "+ ",listofficers_duedate = ? "+ ",businesslicense_expdate = ? "+ ","+ "created_date = ? "+ ",is_active = ? "+ " WHERE Company_Id = ?";
					_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
					_PreparedStatement.setString(1, _CompanyDetail.CompanyName);
					_PreparedStatement.setString(2, _CompanyDetail.Address1);		
					_PreparedStatement.setString(3, _CompanyDetail.Address2);
					_PreparedStatement.setString(4, _CompanyDetail.City);	
					_PreparedStatement.setString(5, _CompanyDetail.State);	
					_PreparedStatement.setString(6, _CompanyDetail.ZipCode);
					_PreparedStatement.setString(7, _CompanyDetail.CountryId);
					_PreparedStatement.setString(8, _CompanyDetail.Email);
					_PreparedStatement.setString(9, _CompanyDetail.Phone);
					_PreparedStatement.setString(10, _CompanyDetail.BusinessFax);
					_PreparedStatement.setString(11, _CompanyDetail.ContactPerson);		
					_PreparedStatement.setString(12, _CompanyDetail.ContactTitle);
					_PreparedStatement.setString(13, _CompanyDetail.NumberofEmployees);	
					_PreparedStatement.setString(14, _CompanyDetail.AnnualRevenue);	
					_PreparedStatement.setString(15, _CompanyDetail.Industry);
					_PreparedStatement.setString(16, _CompanyDetail.SubIndustry);
					_PreparedStatement.setString(17, _CompanyDetail.SICCode);
					_PreparedStatement.setString(18, _CompanyDetail.SICDescription);
					_PreparedStatement.setString(19, _CompanyDetail.Website);		
					_PreparedStatement.setString(20, _CompanyDetail.CompanyNumber);
					_PreparedStatement.setString(21, _CompanyDetail.BusinessID);	
					_PreparedStatement.setString(22, _CompanyDetail.CompanyType);	
					if(_CompanyDetail.IncorporationDate!="")
					{
						_PreparedStatement.setString(23, _CompanyDetail.IncorporationDate);
					}
					else{
						_PreparedStatement.setDate(23, _optionaldate);
					}
					
					if(_CompanyDetail.ListofOfficersDueDate!="")
					{
						_PreparedStatement.setString(24, _CompanyDetail.ListofOfficersDueDate);
					}
					else{
						_PreparedStatement.setDate(24, _optionaldate);
					}
					if(_CompanyDetail.BusinessLicenseExpDate!="")
					{
						_PreparedStatement.setString(25, _CompanyDetail.BusinessLicenseExpDate);
					}
					else{
						_PreparedStatement.setDate(25, _optionaldate);
					}
					
					
					_PreparedStatement.setString(26, _CompanyDetail.CreatedDate);
					
					
					_PreparedStatement.setBoolean(27, _CompanyDetail.IsActive);
					_PreparedStatement.setInt(28, _CompanyDetail.CompanyId);
					_PreparedStatement.executeUpdate();
					_CompanyDetail.setResult("Sucess");
					clearall(_CompanyDetail);
					}
					else{
						_CompanyDetail.setResult("Failed");
						_CompanyDetail.setResult("Invalid Country-Id!");
						clearall(_CompanyDetail);
						//logger.error(_auth.errorstatus);
			     }
				}
				else{
					_CompanyDetail.setResult("Failed");
					_CompanyDetail.setError("Invalid Customer Id!");
					clearall(_CompanyDetail);
					//logger.error(_auth.errorstatus);
		    	}
			}
			else{
				_CompanyDetail.setResult("Failed");
				_CompanyDetail.setError("Error in api backend connectivity !");
				clearall(_CompanyDetail);
				//logger.error(_auth.errorstatus);
	    	}
	}
	catch (Exception e) {
		e.printStackTrace();
		_CompanyDetail.setResult("Failed!"+e.getStackTrace());
		clearall(_CompanyDetail);
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
	return _CompanyDetail;
}


public CompanyDetail deleteCompany(CompanyDetail _CompanyDetail)
{
	Connection _Connection = MYSQLConnection.GetConnection();
	
	try
	{
		if(_Connection!=null)
		{
		PreparedStatement _PreparedStatement = null;
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT Company_Id FROM company where 	Company_Id='"+_CompanyDetail.CompanyId+"'",_Connection);
			if (_ResultSet.next())
			{
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				String date=format.format(cal.getTime());
				_CompanyDetail.setDeletedDate(date);
				
				_CompanyDetail.setIsDeleted(true);
				String sInsertStatement ="UPDATE company SET 	is_deleted = ? "+ ",deleted_date = ? "+ " WHERE Company_Id = ?";
				_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
				_PreparedStatement.setBoolean(1, _CompanyDetail.IsDeleted);
				_PreparedStatement.setString(2,_CompanyDetail.DeletedDate);
				_PreparedStatement.setInt(3, _CompanyDetail.CompanyId);	
				_PreparedStatement.executeUpdate();
				_CompanyDetail.setResult("Sucess");
			}
			else{
				_CompanyDetail.setResult("Failed");
				_CompanyDetail.setError("Invalid Company Id!");
				//logger.error(_auth.errorstatus);
	    	}
	}
		else{
			_CompanyDetail.setResult("Failed");
			_CompanyDetail.setError("Error in api backend connectivity !");
			//logger.error(_auth.errorstatus);
    	}
	
	}
	catch (Exception e) {
		_CompanyDetail.setResult("Failed!"+e.getStackTrace());
	}
	finally
	{
		if (_Connection != null) {
			try {
				_Connection.close();
				clearall(_CompanyDetail);
			} catch (SQLException e) {
				//logger.error(e.getMessage() + " Stack Trace: " + e.getStackTrace());
			}
		}
	}
	return _CompanyDetail;
}


public CompanyDetail getCompany(CompanyDetail _CompanyDetail) {
	Connection _Connection = MYSQLConnection.GetConnection();	
	try
	{
		if(_Connection!=null)
		{
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM company where Company_Id='"+_CompanyDetail.CompanyId+"'",_Connection);
		if (_ResultSet.next())
		{
			_CompanyDetail.setCompanyId(_ResultSet.getInt("Company_Id"));
			_CompanyDetail.setCompanyName(_ResultSet.getString("name"));
			_CompanyDetail.setAddress1(_ResultSet.getString("address1"));
			_CompanyDetail.setAddress2(_ResultSet.getString("address2"));
			_CompanyDetail.setCity(_ResultSet.getString("city"));
			_CompanyDetail.setState(_ResultSet.getString("state"));
			
			_CompanyDetail.setZipCode(_ResultSet.getString("zip_code"));
			_CompanyDetail.setCountry(_ResultSet.getString("country_id"));
			_CompanyDetail.setEmail(_ResultSet.getString("email"));
			_CompanyDetail.setPhone(_ResultSet.getString("phone"));
			_CompanyDetail.setBusinessFax(_ResultSet.getString("business_fax"));
			_CompanyDetail.setContactPerson(_ResultSet.getString("contact_person"));
			_CompanyDetail.setContactTitle(_ResultSet.getString("contact_title"));
			_CompanyDetail.setNumberofEmployees(_ResultSet.getString("number_employees"));
			_CompanyDetail.setAnnualRevenue(_ResultSet.getString("annual_revenue"));
			_CompanyDetail.setIndustry(_ResultSet.getString("industry"));
			_CompanyDetail.setSubIndustry(_ResultSet.getString("sub_industry"));
			_CompanyDetail.setSICCode(_ResultSet.getString("sic_code"));
			_CompanyDetail.setSICDescription(_ResultSet.getString("sic_description"));
			_CompanyDetail.setWebsite(_ResultSet.getString("website"));
			_CompanyDetail.setCompanyNumber(_ResultSet.getString("company_number"));
			_CompanyDetail.setBusinessID(_ResultSet.getString("business_id"));
			_CompanyDetail.setCompanyType(_ResultSet.getString("company_type"));
		
			_CompanyDetail.setIncorporationDate(_ResultSet.getString("incorporation_date"));
			_CompanyDetail.setListofOfficersDueDate(_ResultSet.getString("listofficers_duedate"));			
			_CompanyDetail.setBusinessLicenseExpDate(_ResultSet.getString("businesslicense_expdate"));			
			_CompanyDetail.setCreatedDate(_ResultSet.getString("created_date"));
			_CompanyDetail.setbIsActive(_ResultSet.getBoolean("is_active"));
			_CompanyDetail.setIsDeleted(_ResultSet.getBoolean("is_deleted"));
			_CompanyDetail.setDeletedDate(_ResultSet.getString("deleted_date"));
			_CompanyDetail.setResult("Sucess");
		}
		else{
			_CompanyDetail.setResult("Failed");
			_CompanyDetail.setError("Invalid Company Id!");
			//logger.error(_auth.errorstatus);
    	}
		}
		else{
			_CompanyDetail.setResult("Failed");
			_CompanyDetail.setError("Error in api backend connectivity !");
			//logger.error(_auth.errorstatus);
    	}
		
	}
	catch (Exception e) {
		 e.printStackTrace();
	}
	finally {
		
	}
	return _CompanyDetail;
}

public static ArrayList<CompanyDetail> getCompanyDetails() {
	Connection _Connection = MYSQLConnection.GetConnection();
	
	ArrayList<CompanyDetail> _CompanyDetaillist = new ArrayList<CompanyDetail>();
	
	MYSQLHelper _MYSQLHelper = new MYSQLHelper();
	ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM  company where is_deleted=0",_Connection);
	 try
		{
		 while  (_ResultSet.next())
			{
				
			 CompanyDetail _CompanyDetail=new CompanyDetail();
			    _CompanyDetail.setCompanyId(_ResultSet.getInt("Company_Id"));
				_CompanyDetail.setCompanyName(_ResultSet.getString("name"));
				_CompanyDetail.setAddress1(_ResultSet.getString("address1"));
				_CompanyDetail.setAddress2(_ResultSet.getString("address2"));
				_CompanyDetail.setCity(_ResultSet.getString("city"));
				_CompanyDetail.setState(_ResultSet.getString("state"));
				
				_CompanyDetail.setZipCode(_ResultSet.getString("zip_code"));
				_CompanyDetail.setCountry(_ResultSet.getString("country_id"));
				_CompanyDetail.setEmail(_ResultSet.getString("email"));
				_CompanyDetail.setPhone(_ResultSet.getString("phone"));
				_CompanyDetail.setContactPerson(_ResultSet.getString("contact_person"));
				_CompanyDetail.setContactTitle(_ResultSet.getString("contact_title"));
				_CompanyDetail.setNumberofEmployees(_ResultSet.getString("number_employees"));
				_CompanyDetail.setAnnualRevenue(_ResultSet.getString("annual_revenue"));
				_CompanyDetail.setIndustry(_ResultSet.getString("industry"));
				_CompanyDetail.setSubIndustry(_ResultSet.getString("sub_industry"));
				_CompanyDetail.setSICCode(_ResultSet.getString("sic_code"));
				_CompanyDetail.setSICDescription(_ResultSet.getString("sic_description"));
				_CompanyDetail.setWebsite(_ResultSet.getString("website"));
				_CompanyDetail.setCompanyNumber(_ResultSet.getString("company_number"));
				_CompanyDetail.setBusinessID(_ResultSet.getString("business_id"));
				_CompanyDetail.setCompanyType(_ResultSet.getString("company_type"));
			
				_CompanyDetail.setIncorporationDate(_ResultSet.getString("incorporation_date"));
				_CompanyDetail.setListofOfficersDueDate(_ResultSet.getString("listofficers_duedate"));			
				_CompanyDetail.setBusinessLicenseExpDate(_ResultSet.getString("businesslicense_expdate"));
				
				_CompanyDetail.setCreatedDate(_ResultSet.getString("created_date"));
				_CompanyDetail.setbIsActive(_ResultSet.getBoolean("is_active"));
				_CompanyDetail.setIsDeleted(_ResultSet.getBoolean("is_deleted"));
				_CompanyDetail.setDeletedDate(_ResultSet.getString("deleted_date"));
				_CompanyDetail.setResult("Sucess");
				_CompanyDetaillist.add(_CompanyDetail);
				
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
	 return _CompanyDetaillist;
}




//public CompanyDetail logincompany(CompanyDetail _CompanyDetail)
//{
	//Connection _Connection = MYSQLConnection.GetConnection();	
	//try
	//{
	//	if(_Connection!=null)
	//	{
		//	String _hashPassword = byteArrayToHexString(CompanyDetail.computeHash(_CompanyDetail.password));			
		//	MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		//	_CompanyDetail.setpassword(_hashPassword);			
		//	ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM customer where email='"+_CompanyDetail.email+"' and password ='"+_CompanyDetail.password+"'",_Connection);
		//		if (_ResultSet.next())
		//		{
			////		ResultSet _ResultSetdata = _MYSQLHelper.GetResultSet("SELECT * FROM customer where email='"+_CompanyDetail.email+"'",_Connection);
			//		if (_ResultSetdata.next())
			//		{	
			//		_CompanyDetail.setcustomerid(_ResultSet.getInt("customer_Id"));
			//		_CompanyDetail.setcompanyname(_ResultSet.getString("company_name"));
			//		_CompanyDetail.setphone(_ResultSet.getString("phone"));
			//		_CompanyDetail.setcreateddate(_ResultSet.getString("created_date"));
			//		_CompanyDetail.setis_active(_ResultSet.getBoolean("is_active"));
			//		_CompanyDetail.setis_deleted(_ResultSet.getBoolean("is_deleted"));
			//		_CompanyDetail.setdeleteddate(_ResultSet.getString("deleted_date"));
			//		_CompanyDetail.setresult("Sucess");
			//		}
			//	}
			//	else
			//	{
			//		_CompanyDetail.setresult("Failed");
			//		_CompanyDetail.seterror("Invalid Credentials!");
			//	}
	//	}
	//	else{
	//		_CompanyDetail.setresult("Failed");
		//	_CompanyDetail.seterror("Error in api backend connectivity !");
	//		//logger.error(_auth.errorstatus);
    //	}
		
	//}
//	catch (Exception e) {
//		
	//}
	//finally {		
	//	if (_Connection != null) {
	//		try {
		//		_Connection.close();
		//	} catch (SQLException e) {
				//logger.error(e.getMessage() + " Stack Trace: " + e.getStackTrace());
		//	}
	//	}
	//}
	
	
	///return _CompanyDetail;
//}




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
		  
		  public CompanyDetail clearall(CompanyDetail _CompanyDetail)
		  {
			  //_usersdetails.setUserResult("Sucess");
				_CompanyDetail.setCompanyName("");
				_CompanyDetail.setAddress1("");
				_CompanyDetail.setAddress2("");
				_CompanyDetail.setCity("");
				_CompanyDetail.setState("");
				_CompanyDetail.setZipCode("");
				_CompanyDetail.setCountry("");
				_CompanyDetail.setEmail("");
				_CompanyDetail.setPhone("");
				_CompanyDetail.setContactPerson("");
				_CompanyDetail.setContactTitle("");
				_CompanyDetail.setNumberofEmployees("");
				_CompanyDetail.setAnnualRevenue("");
				_CompanyDetail.setIndustry("");
				_CompanyDetail.setSubIndustry("");
				_CompanyDetail.setCity("");
				_CompanyDetail.setState("");
				_CompanyDetail.setBusinessFax("");
				_CompanyDetail.setZipCode("");
				_CompanyDetail.setCountry("");
				_CompanyDetail.setEmail("");
				_CompanyDetail.setPhone("");
				_CompanyDetail.setContactPerson("");
				_CompanyDetail.setContactTitle("");
				
				_CompanyDetail.setAnnualRevenue("");
				_CompanyDetail.setIndustry("");
				_CompanyDetail.setSubIndustry("");
				_CompanyDetail.setSICCode("");
				_CompanyDetail.setSICDescription("");
				_CompanyDetail.setWebsite("");
				_CompanyDetail.setCompanyNumber("");
				_CompanyDetail.setBusinessID("");
				_CompanyDetail.setCompanyType("");
			
				_CompanyDetail.setIncorporationDate("");
				_CompanyDetail.setListofOfficersDueDate("");			
				_CompanyDetail.setBusinessLicenseExpDate("");
				
				_CompanyDetail.setCreatedDate("");
				
				_CompanyDetail.setDeletedDate("");
		  return _CompanyDetail;
		  }
}
