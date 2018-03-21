package com.etl.base;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CurrencyConversion {
	public int TokenId;
	public String FromCountry;
	public String ToCountry;
	public double Amount;
	public String Status;
	public String Result;
	public String Error;

	
	private void setTokenId(int TokenId){
		this.TokenId = TokenId;
	}	
	private int getTokenId(){
		return TokenId;
	}
	
	private void setFromCountry(String FromCountry){
		this.FromCountry = FromCountry;
	}	
	private String getFromCountry(){
		return FromCountry;
	}
	
	private void setToCountry(String ToCountry){
		this.ToCountry = ToCountry;
	}	
	private String getToCountry(){
		return ToCountry;
	}
	private void setAmount(Double Amount){
		this.Amount = Amount;
	}	
	private Double getAmount(){
		return Amount;
	}
	
	private void setStatus(String Status){
		this.Status = Status;
	}	
	private String getStatus(){
		return Status;
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
	
	
	public CurrencyConversion getCurrencyConversion(CurrencyConversion _CurrencyConversion) {
		
		
		String muurl="https://currencydatafeed.com/api/converter.php?token=rxv51rk8b4y1kjhasvww&from=USD&to=JPY&amount=20";
		
			try
			{
			//	URL _ReportURL = new URL(MISOConfiguration.getReportUrl() + "?entity=" + this.getMarketType() + "&date=" +  sReportDate + "&type=CA&format=xml");
				URL _ReportURL= new URL(muurl);
				 HttpsURLConnection _HttpsReportUrlConnection = (HttpsURLConnection) _ReportURL.openConnection();

		         _HttpsReportUrlConnection.setRequestMethod("POST");
		         _HttpsReportUrlConnection.setConnectTimeout(200000);
		         _HttpsReportUrlConnection.setRequestProperty("Content-type", "text/html; charset=utf-8");
		         _HttpsReportUrlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");

		         _HttpsReportUrlConnection.setDoOutput(true);
		 
		         InputStream _XMLInputStream = _HttpsReportUrlConnection.getInputStream();
		 
		         BufferedReader _BufferedReader = new BufferedReader(new InputStreamReader(_XMLInputStream));
		 
		 
		   String sCurrentLine;
		   StringBuilder _StringBuilder = new StringBuilder();
		   while ((sCurrentLine = _BufferedReader.readLine()) != null) {
		    _StringBuilder.append(sCurrentLine);
		   }

				
			}
			catch (Exception e) {
				System.out.println("error code11: " + e.getMessage());
			}
		return _CurrencyConversion;
	}	
	
	
	
}
