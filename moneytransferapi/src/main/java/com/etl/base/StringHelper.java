package com.etl.base;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
public class StringHelper {

	public static String getStringFromInputStream(InputStream _InputStream) 
	{
		BufferedReader _BufferedReader = null;
		StringBuilder _StringBuilder = new StringBuilder();

		String sLine = "";
		try {

			_BufferedReader = new BufferedReader(new InputStreamReader(_InputStream));
			while ((sLine = _BufferedReader.readLine()) != null) {
				_StringBuilder.append(sLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (_BufferedReader != null) {
				try {
					_BufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return _StringBuilder.toString();

	}
	
	public static String removeComma(String sValue)
	{
		return sValue.replaceAll(",", "");
		
	}
}
