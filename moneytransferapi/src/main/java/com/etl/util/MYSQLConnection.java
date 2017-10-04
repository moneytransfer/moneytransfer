package com.etl.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.etl.provider.Configuration.*;



public class MYSQLConnection {
	final static Logger logger = Logger.getLogger(Connection.class);
	public static Connection GetConnection()
	{		
		Connection _Connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				_Connection = DriverManager.getConnection(MYSQLConfiguration.getHost()  + "?" + "user=" + MYSQLConfiguration.getDBUsername() + "&password=" + MYSQLConfiguration.getDBPassword());
			} catch (SQLException e) {
				logger.error(e.getMessage() + " Stack Trace: " + e.getStackTrace());
			}
		} catch (ClassNotFoundException e) {
			logger.error(e.getMessage() + " Stack Trace: " + e.getStackTrace());
		}
		
		return _Connection;
	}
}
