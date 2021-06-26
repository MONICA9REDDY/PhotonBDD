package com.photon.generic;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {

	public static ThreadLocal<Properties> prop = new ThreadLocal<Properties>();
	public static Properties properties;
	public static void initializeProp() throws Throwable {
		FileInputStream fis=new FileInputStream(".\\CommonData.properties");
		properties=new Properties();
		properties.load(fis);
		prop.set(properties);
	}
	
	
	
	public static String getKeyValue(String key) {
		
		return prop.get().getProperty(key);
	}
}
