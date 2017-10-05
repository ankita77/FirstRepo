package com.cg.ars.daos;

import com.cg.ars.beans.BookingInfoBean;
import com.cg.ars.exceptions.AirlineException;

public interface BookingInfoDao {

//userService	
public int createNewBooking(BookingInfoBean bookingInfoBean) throws AirlineException;

//userService
public BookingInfoBean getBookingOnId(int bookingId) throws AirlineException; 

//userService
public boolean updateBookingOnId(int bookingId) throws AirlineException;

//userService
public boolean removeBookingOnId(int bookingId) throws AirlineException;

	
}
