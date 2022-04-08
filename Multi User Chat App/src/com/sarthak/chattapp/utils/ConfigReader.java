package com.sarthak.chattapp.utils;

import java.util.ResourceBundle;

public class ConfigReader {
	ConfigReader() {}
	private static ResourceBundle rb=ResourceBundle.getBundle("configuration2");
	public static String getValue(String key) {
		return rb.getString(key);
	}

}
