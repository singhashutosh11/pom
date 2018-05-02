/**
 * 
 */
package com.cfsa.qa.utils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author mmishra
 *
 */
public class FileHandeling {
	
	static FileInputStream fs;
	static String value = null;
	public static String getConfigValue(String key ){
		try{
		Properties config = new Properties();
		fs = new FileInputStream(System.getProperty("user.dir") + "/config/" + "config.properties");
		config.load(fs);
		value = config.getProperty(key);
		}catch(Exception e){
		Log.errorLog("error while reading the config property file :", e);
		}
		return value;
	}

}
