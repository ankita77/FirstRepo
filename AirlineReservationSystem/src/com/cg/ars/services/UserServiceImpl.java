package com.cg.ars.services;

import java.time.LocalDate;
import java.util.ArrayList;

import com.cg.ars.beans.BookingInfoBean;
import com.cg.ars.beans.FlightInfoBean;
import com.cg.ars.beans.UsersBean;
import com.cg.ars.daos.BookingInfoDao;
import com.cg.ars.daos.BookingInfoDaoImpl;
import com.cg.ars.daos.FlightInfoDao;
import com.cg.ars.daos.FlightInfoDaoImpl;
import com.cg.ars.daos.UsersDao;
import com.cg.ars.daos.UsersDaoImpl;
import com.cg.ars.exceptions.AirlineException;

public class UserServiceImpl implements UserService{
	
	private UsersDao usersDao;
	private FlightInfoDao flightInfoDao;
	private BookingInfoDao bookingInfoDao;
	
	public UserServiceImpl() throws AirlineException{
		
		usersDao = new UsersDaoImpl();
		flightInfoDao = new FlightInfoDaoImpl();
		bookingInfoDao = new BookingInfoDaoImpl();
	}

	
	//validate User...usersDao
	@Override
	public boolean validateUser(UsersBean usersBean) throws AirlineException {
		
		return false;
	}

	
	//validateDepCity...flightInfoDao
	@Override
	public boolean validateDepCity(String depCity) throws AirlineException {
		// TODO Auto-generated method stub
		return false;
	}

	
	//validateArrCity...flightInfoDao
	@Override
	public boolean validateArrCity(String arrCity) throws AirlineException {
		// TODO Auto-generated method stub
		return false;
	}

	
	//validateDepDate...flightInfoDao
	@Override
	public boolean validateDepDate(LocalDate depDate) throws AirlineException {
		// TODO Auto-generated method stub
		return false;
	}

	
	//view Flight List...flightInfoDao
	@Override
	public ArrayList<FlightInfoBean> viewFlightList(String depCity,
			String arrCity, LocalDate depDate) throws AirlineException {

		return flightInfoDao.getFlightList(depCity, arrCity, depDate);
	}

	
	
	//validate FlightNo...flightInfoDao
	@Override
	public boolean validateFlightNo(int flightNo) throws AirlineException {
		
		return false;
	}


	//validate ClassType...flightInfoDao
	@Override
	public boolean validateClassType(String classType) throws AirlineException {
		
		return false;
	}

	
	//validate NoOfPassengers...flightInfoDao
	@Override
	public boolean validateNoOfPassengers(int noOfPassengers)
			throws AirlineException {
		
		return false;
	}

	
	//generate Total Fare...userService
	@Override
	public float generateTotalFare(int flightNo, String classType,
			int noOfPassengers) throws AirlineException {
		
		float baseFare = 0;
		float totalFare = 0;
		FlightInfoBean flightInfoBean = new FlightInfoBean();
		
		try {
			flightInfoBean = flightInfoDao.getFlightDetailsOnId(flightNo);
			
			if("FIRST".equals(classType)){
				baseFare = flightInfoBean.getFirstSeatFare();
			}
			else if("BUSINESS".equals(classType)){
				baseFare = flightInfoBean.getBussSeatFare();
			}
			else{
				throw new AirlineException("Not a correct class type.");
			}
			totalFare = baseFare * noOfPassengers;
			
		} catch (AirlineException e) {
			throw new AirlineException("Problem in generating fare", e);
		}
		return totalFare;
	
	}

	//validate custEmail via pattern matching...client side validation
	@Override
	public boolean validateCustEmail(String custEmail) throws AirlineException {
		
		return false;
	}

	//validate creditCardInfo via pattern matching...client side validation
	@Override
	public boolean validateCreditCardInfo(String creditCardInfo)
			throws AirlineException {
		
		return false;
	}
	
	
	//bookFlight...insert into BookingInfodao and update FlightInfoDao
	@Override
	public int bookFlight(int flightNo, BookingInfoBean bookingInfoBean) throws AirlineException {
		
		//insert
		int bookingId = bookingInfoDao.createNewBooking(bookingInfoBean);
		
		//update
		String classType = bookingInfoBean.getClassType();
		int noOfPassengers = bookingInfoBean.getNoOfPassengers();
		boolean isUpdateSucc = flightInfoDao.updateSeatsOnBooking(flightNo, classType, noOfPassengers);
		
		if(isUpdateSucc == true){
			return bookingId;
			}
		else{
			throw new AirlineException("Probelm in booking ticket");
		}
		}

	//validate bookingId...BookingInfoDao
	@Override
	public boolean validateBookingId(int bookingId) throws AirlineException {
		
		return false;
	}

	
	//getBookingOnId...BookingInfoDao
	@Override
	public BookingInfoBean viewBookingOnId(int bookingId)
			throws AirlineException {
		
		BookingInfoBean bookingInfoBean =bookingInfoDao.getBookingOnId(bookingId);
				return bookingInfoBean;
	}

	//updateBookingOnId...BookingInfoDao
	@Override
	public boolean updateBookingOnId(int bookingId) throws AirlineException {
		
		return false;
	}

	//cancelBookingOnId...BookingInfoDao
	@Override
	public boolean cancelBookingOnId(int bookingId) throws AirlineException {
		
		boolean isBookingCancelled = bookingInfoDao.removeBookingOnId(bookingId);
			return isBookingCancelled;
	}


	

	


	
}
