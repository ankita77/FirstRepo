package com.cg.ars.daos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import com.cg.ars.beans.FlightInfoBean;
import com.cg.ars.exceptions.AirlineException;

public interface FlightInfoDao {

	
	//adminService
	public boolean createNewFlight(FlightInfoBean flightInfoBean) throws AirlineException;
	
	//userService
	public ArrayList<FlightInfoBean> 
	getFlightList(String depCity,String arrCity, LocalDate depDate) throws AirlineException;
	
	
	//executiveService and userService
	public FlightInfoBean getFlightDetailsOnId(int flightNo)
			throws AirlineException;
	
	
	//executiveService
	public ArrayList<FlightInfoBean> getFlightList(LocalDate startDepDate, LocalDate endDepDate)
			throws AirlineException;
	
	//userService
	public boolean updateSeatsOnBooking(int flightNo, String classType, int noOfPassengers) 
			throws AirlineException;
	
	//adminService
	public boolean removeFlight(int flightNo) throws AirlineException;
	
}
