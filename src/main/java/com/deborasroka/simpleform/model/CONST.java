package com.deborasroka.simpleform.model;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public final class CONST {
	
	public static String DB_USER = getConst("USER");
	public static  String DB_PASS = getConst("PASS");
		
	public static String CAPKEY = getConst("SITEKEY");
	public static String CAPSEC = getConst("SITESEC");
	
	private static String getConst (String key) {
		
	Properties constants = new Properties();
		try (FileReader in = new FileReader("/Users/deborasroka/const.properties")) {
		    constants.load(in);
		} catch(IOException e) {
			System.out.println("Error retrieving const file: "+e);
		}
		
		return constants.getProperty(key);
	}
	

	
	
	
	
	

}
