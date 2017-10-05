package com.cg.ars.services;

import com.cg.ars.beans.FlightInfoBean;
import com.cg.ars.beans.UsersBean;
import com.cg.ars.exceptions.AirlineException;

public interface AdminService {

	public boolean validateUser(UsersBean usersBean) throws AirlineException;
	
	public boolean createNewFlight(FlightInfoBean flightInfoBean) throws AirlineException;
	
	public boolean removeFlight(int flightNo) throws AirlineException;
	
}
