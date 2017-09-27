package com.bjss.traffic.tests.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Property {

	public static String get(String propertyFile, String propertyName)
	{
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();           
		InputStream stream = loader.getResourceAsStream(propertyFile);
		
		try {
			prop.load(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop.getProperty(propertyName);
	}
}
