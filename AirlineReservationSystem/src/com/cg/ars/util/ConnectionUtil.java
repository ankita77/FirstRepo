package com.cg.ars.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.ars.exceptions.AirlineException;

public class ConnectionUtil {

	private Connection connect;
	
	public ConnectionUtil() throws AirlineException {
		
		PropertyServices propServices = new PropertyServices();
		String url = propServices.getPropertyValue("url");
		String userName = propServices.getPropertyValue("userName");
		String password = propServices.getPropertyValue("password");
	
		try {
			connect = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	//a getConnection method that'll establish connection in daoimpl class
	public Connection getConnection(){
		return connect;
	}

	
	
	
}
