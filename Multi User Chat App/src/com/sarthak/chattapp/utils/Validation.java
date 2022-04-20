package com.sarthak.chattapp.utils;

public class Validation {
	public static  boolean isValidEmail(String email){
		if(email!=null && email.length()>0) {
			if(email.contains("@") && (email.endsWith(".com") || email.endsWith(".org"))) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
}

}
