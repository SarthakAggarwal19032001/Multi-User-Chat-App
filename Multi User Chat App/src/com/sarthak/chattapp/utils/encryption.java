package com.sarthak.chattapp.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface encryption {
	public static String passwordEncrpt(String plainPassword) throws NoSuchAlgorithmException {
		String encrptedPassword=null;
		MessageDigest messageDigest=MessageDigest.getInstance("MD5");     //MD5 is a algorithm 
		messageDigest.update(plainPassword.getBytes());
		byte [] encrpt=messageDigest.digest();
		StringBuffer sb=new StringBuffer();
		for(byte b:encrpt) {
			sb.append(b);
		}
		encrptedPassword=sb.toString();
		return encrptedPassword;
	}

}
