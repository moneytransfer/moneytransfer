package com.etl.base;

import java.security.MessageDigest;

public class MD5 {

	public MD5 testMD5() {
		MD5 _MD5 = new MD5();

		String your_login="falconloop";
		String your_token="818643611710";
		String your_key="1530780517";
		
		try{
			String md5_string = getKeyedDigest(your_login, your_token, your_key);
			System.out.println(md5_string);
		}
		catch (Exception ex) {
			System.out.println("error:"+ex.getMessage());
		}
		
		return _MD5;
	}

	public static String getKeyedDigest(String login, String token, String key) {
		try {
			String temp = login + token + key;
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] bytes = md5.digest(temp.getBytes());
			return byteToHex(bytes);
		} catch (Exception ex) {
			System.out.println("oops");
		}
		return null;
	}

	public static String byteToHex(byte[] bits) {
		if (bits == null) {
			return null;
		}
		StringBuffer hex = new StringBuffer(bits.length * 2);
		for (int i = 0; i < bits.length; i++) {
			if (((int) bits[i] & 0xff) < 0x10) {
				hex.append("0");
			}
			hex.append(Integer.toString((int) bits[i] & 0xff, 16));
		}
		return hex.toString();
	
	}

}
