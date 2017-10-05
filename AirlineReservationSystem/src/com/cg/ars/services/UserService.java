package com.cg.ars.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import com.cg.ars.beans.BookingInfoBean;
import com.cg.ars.beans.FlightInfoBean;
import com.cg.ars.beans.UsersBean;
import com.cg.ars.exceptions.AirlineException;

public interface UserService {

	//UsersDao
	public boolean validateUser(UsersBean usersBean) throws AirlineException;
	
	//FlightInfoDao
	public boolean validateDepCity(String depCity) throws AirlineException;
	
	//FlightInfoDao
	public boolean validateArrCity(String arrCity) throws AirlineException;
	
	//FlightInfoDao
	public boolean validateDepDate(LocalDate depDate) throws AirlineException;
	
	//FlightInfoDao
	public ArrayList<FlightInfoBean> 
		viewFlightList(String depCity,String arrCity, LocalDate depDate) 
						throws AirlineException;
	
	//FlightInfoDao
	public boolean validateFlightNo(int flightNo) throws AirlineException;
		
	//FlightInfoDao
	public boolean validateClassType(String classType) throws AirlineException;
	
	//FlightInfoDao
	public boolean validateNoOfPassengers(int noOfPassengers) throws AirlineException;
	
	//FlightInfoDao
	public float generateTotalFare(int flightNo, String classType, int noOfPassengers)
						throws AirlineException;
	
	//pattern matching
	public boolean validateCustEmail(String custEmail) throws AirlineException;
	
	//pattern matching
	public boolean validateCreditCardInfo(String creditCardInfo) throws AirlineException;
	
	//FlightInfoDao and BookingInfoDao
	public int bookFlight(int flightNo, BookingInfoBean bookingInfoBean) throws AirlineException;
	
	//BookingInfoDao
	public boolean validateBookingId(int bookingId) throws AirlineException;
	
	//BookingInfoDao
	public BookingInfoBean viewBookingOnId(int bookingId) throws AirlineException;
	
	//BookingInfoDao
	public boolean updateBookingOnId(int bookingId) throws AirlineException;

	//BookingInfoDao
	public boolean cancelBookingOnId(int bookingId) throws AirlineException;
	
	
}
