package com.etl.base;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.etl.util.MYSQLConnection;
import com.etl.util.MYSQLHelper;

public class CountryDeatils {
	public int CountryId;
	public String CountryName;
	public String iso;
	public int phonecode;
	public String CurrencyName;
	public String CurrencySymbol;	
	public String CurrencyCode;		
	
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
	
	
	private void setcountry_name(String CountryName){
		this.CountryName = CountryName;
	}	
	private String getcountry_name(){
		return CountryName;
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

	private void setCurrencyCode(String CurrencyCode){
		this.CurrencyCode = CurrencyCode;
	}	
	private String getCurrencyCoder(){
		return CurrencyCode;
	}
	
	private void setCurrencySymbol(String CurrencySymbol){
		this.CurrencySymbol = CurrencySymbol;
	}	
	private String getCurrencySymbol(){
		return CurrencySymbol;
	}
	
	
	private void setCurrencyName(String CurrencyName){
		this.CurrencyName = CurrencyName;
	}	
	private String getCurrencyName(){
		return CurrencyName;
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
				
				_CountryDeatils.setcountry_name(_ResultSet.getString("country_name"));				
				_CountryDeatils.setiso(_ResultSet.getString("iso"));
				
				_CountryDeatils.setCurrencyName(_ResultSet.getString("currency_name"));
				_CountryDeatils.setCurrencyCode(_ResultSet.getString("currency_code"));
				_CountryDeatils.setCurrencySymbol(_ResultSet.getString("currency_symbol"));
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
				 _CountryDeatils.setCurrencyName(_ResultSet.getString("currency_name"));
				 _CountryDeatils.setcountry_name(_ResultSet.getString("country_name"));				
				 _CountryDeatils.setiso(_ResultSet.getString("iso"));
					
					_CountryDeatils.setphonecode(_ResultSet.getInt("phonecode"));
					_CountryDeatils.setCurrencyCode(_ResultSet.getString("currency_code"));
					_CountryDeatils.setCurrencySymbol(_ResultSet.getString("currency_symbol"));
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
	
	
	
	public CountryDeatils getCountryDetailsIso(int phoneCode, String countryName) {
		CountryDeatils _CountryDeatils=new CountryDeatils();
		Connection _Connection = MYSQLConnection.GetConnection();	
		try
		{
			
			if(_Connection!=null)
			{
				
			MYSQLHelper _MYSQLHelper = new MYSQLHelper();
			ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM country where phonecode='"+phoneCode+"' and country_name='"+countryName+"'",_Connection);
			if (_ResultSet.next())
			{
				_CountryDeatils.setcountry_id(_ResultSet.getInt("country_id"));
				_CountryDeatils.setCurrencyName(_ResultSet.getString("currency_name"));
				_CountryDeatils.setcountry_name(_ResultSet.getString("country_name"));				
				_CountryDeatils.setiso(_ResultSet.getString("iso"));
				
				_CountryDeatils.setphonecode(_ResultSet.getInt("phonecode"));
				_CountryDeatils.setCurrencyCode(_ResultSet.getString("currency_code"));
				_CountryDeatils.setCurrencySymbol(_ResultSet.getString("currency_symbol"));
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
