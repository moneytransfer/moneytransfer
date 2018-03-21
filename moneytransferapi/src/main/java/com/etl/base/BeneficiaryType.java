package com.etl.base;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.etl.util.MYSQLConnection;
import com.etl.util.MYSQLHelper;

public class BeneficiaryType {

	public int BeneficiaryTypeId;
	public String BeneficiaryDescription;
	
	public String Result;
	public String Error;
	
	
	private void setBeneficiaryTypeId(int BeneficiaryTypeId){
		this.BeneficiaryTypeId = BeneficiaryTypeId;
	}	
	private int getBeneficiaryTypeId(){
		return BeneficiaryTypeId;
	}
	private void setBeneficiaryDescription(String BeneficiaryDescription){
		this.BeneficiaryDescription = BeneficiaryDescription;
	}	
	private String getBeneficiaryDescription(){
		return BeneficiaryDescription;
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
	
	
	public static ArrayList<BeneficiaryType> getBeneficiaryTypeDetails() {
		Connection _Connection = MYSQLConnection.GetConnection();
		
		ArrayList<BeneficiaryType> _BeneficiaryTypeDetaillist = new ArrayList<BeneficiaryType>();
		
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		 try
			{
			
			 if(_Connection!=null)			
			
				{
				
				ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM beneficiarytype",_Connection);
				
					while  (_ResultSet.next())
					{
						 BeneficiaryType _BeneficiaryType=new BeneficiaryType();
						
						_BeneficiaryType.setBeneficiaryTypeId(_ResultSet.getInt("BeneficiaryTypeId"));					
						_BeneficiaryType.setBeneficiaryDescription(_ResultSet.getString("BeneficiaryDescription"));					
						_BeneficiaryType.setResult("Sucess");						
						_BeneficiaryTypeDetaillist.add(_BeneficiaryType);
						
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
		
		return _BeneficiaryTypeDetaillist;
	}
	
}
