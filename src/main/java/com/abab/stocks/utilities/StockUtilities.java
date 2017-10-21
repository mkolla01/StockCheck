package com.abab.stocks.utilities;

import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

public class StockUtilities {

	private static Properties dataBaseProperties = readProperties("database");
	public static Properties readProperties(String fileName) {
		Properties prop = new Properties();
		ResourceBundle rb =  ResourceBundle.getBundle(fileName);
		String key=null, val=null;
		Enumeration<String> keys = rb.getKeys();
		while ( keys.hasMoreElements()) {
			key = keys.nextElement();
			val = rb.getString(key);
			prop.put(key, val);
			
		}
		
		return prop;
		
	}
}
