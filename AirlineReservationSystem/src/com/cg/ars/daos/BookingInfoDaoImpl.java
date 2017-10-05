package com.cg.ars.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.cg.ars.beans.BookingInfoBean;
import com.cg.ars.exceptions.AirlineException;
import com.cg.ars.util.ConnectionUtil;

public class BookingInfoDaoImpl implements BookingInfoDao {

private Connection connect = null;
	
	public BookingInfoDaoImpl() throws AirlineException {
		
		ConnectionUtil conn = new ConnectionUtil();
		connect = conn.getConnection();
	}

	
	//create new booking...userService
	@Override
	public int createNewBooking(BookingInfoBean bookingInfoBean)
			throws AirlineException {
		
		String sequenceQry = "select autoBookingId.nextval from DUAL";
		
		int recsAffected = 0;
        int bookingId = 0;
		
		try(PreparedStatement stmt = connect.prepareStatement(sequenceQry);
				ResultSet rs = stmt.executeQuery();	)
				{
				 while(rs.next()){
				 bookingId = rs.getInt(1);
				}
		
			} catch (SQLException e) {
				throw new AirlineException("Problem in generating booking Id", e);
			}
		
		String qry = "insert into bookingInfo values(?,?,?,?,?,?,?,?)";
		
		try(PreparedStatement stmt = connect.prepareStatement(qry);
			){
				stmt.setInt(1, bookingId);
				stmt.setString(2, bookingInfoBean.getCustEmail());
				stmt.setInt(3, bookingInfoBean.getNoOfPassengers());
				stmt.setString(4, bookingInfoBean.getClassType());
				stmt.setFloat(5, bookingInfoBean.getTotalFare());
				stmt.setString(6, bookingInfoBean.getCreditCardInfo());
				stmt.setString(7, bookingInfoBean.getSrcCity());
				stmt.setString(8, bookingInfoBean.getDestCity());
				
				recsAffected = stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new AirlineException("Problem in inserting booking details",e);
		}
			return bookingId;
	}

	
	//get Booking On Id...userService
	@Override
	public BookingInfoBean getBookingOnId(int bookingId)
			throws AirlineException {
		
		BookingInfoBean bookingInfoBean =null;
		ResultSet rs = null;
		
		String qry="SELECT * FROM bookingInfo WHERE bookingId=?";
		
		try(
			PreparedStatement stmt = connect.prepareStatement(qry);
			){
				stmt.setInt(1, bookingId);
				rs = stmt.executeQuery();
					
				while(rs.next()){
				
				String custEmail = rs.getString("custEmail");
				int noOfPassengers = rs.getInt("noOfPassengers");
				String classType = rs.getString("classType");
				float totalFare = rs.getFloat("totalFare");
				String creditCardInfo = rs.getString("creditCardInfo");
				String srcCity = rs.getString("srcCity");
				String destCity = rs.getString("destCity");
				
				bookingInfoBean = new BookingInfoBean(bookingId, custEmail, noOfPassengers,
						classType, totalFare, creditCardInfo, srcCity, destCity);
				}
			}
			catch (SQLException e) {
				throw new AirlineException("Problem in fetching booking details on bookingId",e);
		} 
			finally {
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					throw new AirlineException("Problem in closing Result Set", e);
				}
			}
		}
		return bookingInfoBean;
	}

	
	//update Booking on Id...userService...??
	@Override
	public boolean updateBookingOnId(int bookingId) throws AirlineException {
		
		
		return false;
	}

	
	//remove booking on id...userService
	@Override
	public boolean removeBookingOnId(int bookingId) throws AirlineException {
		
		String qry = "delete from bookingInfo where bookingId=?";
		int recAffected = 0;
		
		try(PreparedStatement stmt = connect.prepareStatement(qry);
			){
			stmt.setInt(1, bookingId);
			recAffected = stmt.executeUpdate();
			}
		      catch(Exception e){
			throw new AirlineException("Problem in removing booking on id", e);
			}

		return recAffected>0?true:false;
	}
	
	
}
