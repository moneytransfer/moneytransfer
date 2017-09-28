package com.etl.base;

import java.io.IOException;
import java.util.Properties;



public class ProviderBase {

	
	
	public static Properties readConfigurationFile()
	{
		Properties _Properties = new Properties();
		try {
			
			_Properties.load(ProviderBase.class.getClassLoader().getResourceAsStream("db_connection.properties"));
		} 
		catch (IOException e) {
			e.printStackTrace();
			//logger.error(e.getMessage() + " Stack Trace: " + e.getStackTrace());
		}
		return _Properties;		
	}
}
