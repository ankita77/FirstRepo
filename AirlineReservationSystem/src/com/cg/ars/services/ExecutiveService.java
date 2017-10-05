package com.cg.ars.services;

import java.util.Date;

import com.cg.ars.beans.FlightInfoBean;
import com.cg.ars.beans.UsersBean;
import com.cg.ars.exceptions.AirlineException;

public interface ExecutiveService {

	//usersDao
	public boolean validateUser(UsersBean usersBean) throws AirlineException;
	
	//flightInfoDao
	public FlightInfoBean viewFlightOccupancyOnId(String flightNo) 
									throws AirlineException;
	
	//flightInfodao
	public FlightInfoBean viewFlightOccupancyOnDate(Date depDate, Date arrDate) 
									throws AirlineException;
	
}
