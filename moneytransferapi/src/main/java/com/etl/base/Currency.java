package com.etl.base;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.etl.util.MYSQLConnection;
import com.etl.util.MYSQLHelper;

public class Currency {

	public int CurrencyId;
	public String CurrencyTitle;
	public int CountryId;
	public String CurrencySymbol;
	public String Result;
	public String Error;
	
	private void setCurrencyId(int CurrencyId){
		this.CurrencyId = CurrencyId;
	}	
	private int getCurrencyId(){
		return CurrencyId;
	}
	private void setCurrencyTitle(String CurrencyTitle){
		this.CurrencyTitle = CurrencyTitle;
	}	
	private String getCurrencyTitle(){
		return CurrencyTitle;
	}
	
	private void setCountryId(int CountryId){
		this.CountryId = CountryId;
	}	
	private int getCountryId(){
		return CountryId;
	}
	
	private void setCurrencySymbol(String CurrencySymbol){
		this.CurrencySymbol = CurrencySymbol;
	}	
	private String getCurrencySymbol(){
		return CurrencySymbol;
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
	
	public static ArrayList<Currency> getCurrencyetails() {
		Connection _Connection = MYSQLConnection.GetConnection();
		
		ArrayList<Currency> _CurrencyDetaillist = new ArrayList<Currency>();
		
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		 try
			{
			
			 if(_Connection!=null)			
			
				{
				
				ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM currency",_Connection);
				
					while  (_ResultSet.next())
					{
						 Currency _Currency=new Currency();
						
						_Currency.setCurrencyId(_ResultSet.getInt("CurrencyId"));
						_Currency.setCountryId(_ResultSet.getInt("country_id"));
						_Currency.setCurrencyTitle(_ResultSet.getString("CurrencyTitle"));
						_Currency.setCurrencySymbol(_ResultSet.getString("CurrencySymbol"));
						_Currency.setResult("Sucess");						
						_CurrencyDetaillist.add(_Currency);
						
					}
					 _ResultSet.close();			
				 
				}
			
			
				
			}
		 catch(Exception e){
			
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
		
		return _CurrencyDetaillist;
	}
	
}
