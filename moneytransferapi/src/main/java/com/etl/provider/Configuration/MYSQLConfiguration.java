package com.etl.provider.Configuration;

import com.etl.base.*;

public class MYSQLConfiguration {
	public static String getHost()
	{
		return ProviderBase.readConfigurationFile().getProperty("jdbc.url").toString();
	}
	
	public static String getDBUsername()
	{
		return ProviderBase.readConfigurationFile().getProperty("jdbc.username").toString();
	}
	
	public static String getDBPassword()
	{
		return ProviderBase.readConfigurationFile().getProperty("jdbc.password").toString();
	}
	
	public static String getsmtpuser()
	{
		return ProviderBase.readConfigurationFile().getProperty("jdbc.smtpUserName").toString();
	}
	public static String getsmtppwd()
	{
		return ProviderBase.readConfigurationFile().getProperty("jdbc.smtppassword").toString();
	}
}
