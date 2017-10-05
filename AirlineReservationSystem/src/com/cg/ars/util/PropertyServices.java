package com.cg.ars.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import com.cg.ars.exceptions.AirlineException;

public class PropertyServices {

	
	private Properties props;
	
	public PropertyServices() throws AirlineException{
		
		props = new Properties();
		
		try(FileInputStream fis = new FileInputStream("ProjectDB.properties");)
		{
		 props.load(fis);
		} catch (FileNotFoundException e){
			throw new AirlineException("Property file missing",e);
		} catch (IOException e) {
			throw new AirlineException("Property file missing",e);
		}
		
	}
	/*
	 * create methods in PropertyServices class
	 * to give the key and obtain the value pair
	 * 
	 */
		
	public String getPropertyValue(String propKey){
		return props.getProperty(propKey);
		  }
	
	
	
}
