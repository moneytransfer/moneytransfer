package com.etl.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.mysql.jdbc.Statement;



public class MYSQLHelper {
	final static Logger logger = Logger.getLogger(MYSQLHelper.class);
	public ResultSet GetResultSet(String sQuery,Connection _Connection)
	{
		ResultSet _ResultSet = null;
		PreparedStatement _PreparedStatement = null;
		if(_Connection !=null)
		{			
			try
			{
				_PreparedStatement = (PreparedStatement)_Connection.prepareStatement(sQuery);				
				_ResultSet = _PreparedStatement.executeQuery();
			}
			catch(Exception e)
			{
				logger.error(e.getMessage() + " Stack Trace: " + e.getStackTrace());
			}	
			
		}
		
		return _ResultSet;
	}
}
