package com.etl.base;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.etl.util.MYSQLConnection;
import com.etl.util.MYSQLHelper;

public class CountryDeatils {
	public int CountryId;
	public String CountryCode;
	public String CountryName;
	public String Result;
	public String Error;
	
	
	private void setcountry_id(int CountryId){
		this.CountryId = CountryId;
	}	
	private int getcountry_id(){
		return CountryId;
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
	
}
