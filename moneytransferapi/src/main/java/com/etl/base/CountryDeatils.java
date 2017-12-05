package com.etl.base;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.etl.util.MYSQLConnection;
import com.etl.util.MYSQLHelper;

public class CountryDeatils {
	public int CountryId;
	public String iso;
	public String CountryName;
	public String CountryNiceName;
	public String iso3;
	public String CountryCode;	
	public int phonecode;
	public String Result;
	public String Error;
	
	
	private void setcountry_id(int CountryId){
		this.CountryId = CountryId;
	}	
	private int getcountry_id(){
		return CountryId;
	}
	
	private void setiso(String iso){
		this.iso = iso;
	}	
	private String getiso(){
		return iso;
	}
	
	private void setcountry_code(String CountryCode){
		this.CountryCode = CountryCode;
	}	
	private String getcountry_code(){
		return CountryCode;
	}
	
	private void setcountry_name(String CountryName){
		this.CountryName = CountryName;
	}	
	private String getcountry_name(){
		return CountryName;
	}
	
	private void setCountryNiceName(String CountryNiceName){
		this.CountryNiceName = CountryNiceName;
	}	
	private String getCountryNiceName(){
		return CountryNiceName;
	}
	private void setiso3(String iso3){
		this.iso3 = iso3;
	}	
	private String getiso3(){
		return iso3;
	}
	
	private void setphonecode(int phonecode){
		this.phonecode = phonecode;
	}	
	private int getphonecode(){
		return phonecode;
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
	
	
	public CountryDeatils getCountry(CountryDeatils _CountryDeatils) {
		Connection _Connection = MYSQLConnection.GetConnection();	
		try
		{
			if(_Connection!=null)
			{
			MYSQLHelper _MYSQLHelper = new MYSQLHelper();
			ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM country where country_id='"+_CountryDeatils.CountryId+"'",_Connection);
			if (_ResultSet.next())
			{
				_CountryDeatils.setcountry_id(_ResultSet.getInt("country_id"));
				_CountryDeatils.setcountry_code(_ResultSet.getString("country_code"));
				_CountryDeatils.setcountry_name(_ResultSet.getString("country_name"));				
				_CountryDeatils.setiso(_ResultSet.getString("iso"));
				_CountryDeatils.setCountryNiceName(_ResultSet.getString("country_nicename"));
				_CountryDeatils.setiso3(_ResultSet.getString("iso3"));
				_CountryDeatils.setphonecode(_ResultSet.getInt("phonecode"));
				_CountryDeatils.setResult("Sucess");
			}
			else{
				_CountryDeatils.setResult("Failed");
				_CountryDeatils.setError("Invalid country Id!");
				//logger.error(_auth.errorstatus);
	    	}
			}
			else{
				_CountryDeatils.setResult("Failed");
				_CountryDeatils.setError("Error in api backend connectivity !");
				//logger.error(_auth.errorstatus);
	    	}
			
		}
		catch (Exception e) {
			 e.printStackTrace();
		}
		finally {
			
		}
		return _CountryDeatils;
	}

	public static ArrayList<CountryDeatils> getCountryDetails() {
		Connection _Connection = MYSQLConnection.GetConnection();
		
		ArrayList<CountryDeatils> _CountryDetaillist = new ArrayList<CountryDeatils>();
		
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM  country",_Connection);
		 try
			{
			 while  (_ResultSet.next())
				{
					
				 CountryDeatils _CountryDeatils=new CountryDeatils();
				 _CountryDeatils.setcountry_id(_ResultSet.getInt("country_id"));
				 _CountryDeatils.setcountry_code(_ResultSet.getString("country_code"));
				 _CountryDeatils.setcountry_name(_ResultSet.getString("country_name"));				
				 _CountryDeatils.setiso(_ResultSet.getString("iso"));
					_CountryDeatils.setCountryNiceName(_ResultSet.getString("country_nicename"));
					_CountryDeatils.setiso3(_ResultSet.getString("iso3"));
					_CountryDeatils.setphonecode(_ResultSet.getInt("phonecode"));
					_CountryDeatils.setResult("Success");
				 _CountryDetaillist.add(_CountryDeatils);
					
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
		 return _CountryDetaillist;
	}
	
	
	
	public CountryDeatils getCountryDetailsIso(int phoneCode) {
		CountryDeatils _CountryDeatils=new CountryDeatils();
		Connection _Connection = MYSQLConnection.GetConnection();	
		try
		{
			
			if(_Connection!=null)
			{
				
			MYSQLHelper _MYSQLHelper = new MYSQLHelper();
			ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM country where phonecode='"+phoneCode+"'",_Connection);
			if (_ResultSet.next())
			{
				_CountryDeatils.setcountry_id(_ResultSet.getInt("country_id"));
				_CountryDeatils.setcountry_code(_ResultSet.getString("country_code"));
				_CountryDeatils.setcountry_name(_ResultSet.getString("country_name"));				
				_CountryDeatils.setiso(_ResultSet.getString("iso"));
				_CountryDeatils.setCountryNiceName(_ResultSet.getString("country_nicename"));
				_CountryDeatils.setiso3(_ResultSet.getString("iso3"));
				_CountryDeatils.setphonecode(_ResultSet.getInt("phonecode"));
				_CountryDeatils.setResult("Sucess");
			}
			else{
				_CountryDeatils.setResult("Failed");
				_CountryDeatils.setError("Invalid country Phone Code Id!");
				//logger.error(_auth.errorstatus);
	    	}
			}
			else{
				_CountryDeatils.setResult("Failed");
				_CountryDeatils.setError("Error in api backend connectivity !");
				//logger.error(_auth.errorstatus);
	    	}
			
		}
		catch (Exception e) {
			 e.printStackTrace();
		}
		finally {
			
		}
		return _CountryDeatils;
	}
	
}
