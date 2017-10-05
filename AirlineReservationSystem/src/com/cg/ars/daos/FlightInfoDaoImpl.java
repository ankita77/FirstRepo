package com.cg.ars.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.cg.ars.beans.FlightInfoBean;
import com.cg.ars.exceptions.AirlineException;
import com.cg.ars.util.ConnectionUtil;

public class FlightInfoDaoImpl implements FlightInfoDao {

	
private Connection connect = null;
	
	public FlightInfoDaoImpl() throws AirlineException {
		
		ConnectionUtil conn = new ConnectionUtil();
		connect = conn.getConnection();
	}
	
	//create New Flight...admin service
	@Override
	public boolean createNewFlight(FlightInfoBean flightInfoBean)
			throws AirlineException {
		
		String qry = "insert into flightInfo values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		int recAffected = 0;
		
		try(PreparedStatement stmt=connect.prepareStatement(qry);
			){
				stmt.setInt(1, flightInfoBean.getFlightNo());
				stmt.setString(2, flightInfoBean.getAirline());
				stmt.setString(3, flightInfoBean.getDepCity());
				stmt.setString(4, flightInfoBean.getArrCity());
				stmt.setDate(5, Date.valueOf(flightInfoBean.getDepDate()));
				stmt.setDate(6, Date.valueOf(flightInfoBean.getArrDate()));
				stmt.setString(7, flightInfoBean.getDepTime());
				stmt.setString(8, flightInfoBean.getArrTime());
				stmt.setInt(9, flightInfoBean.getFirstSeats());
				stmt.setFloat(10, flightInfoBean.getFirstSeatFare());
				stmt.setInt(11, flightInfoBean.getFirstSeatsAvailable());
				stmt.setInt(12, flightInfoBean.getBussSeats());
				stmt.setFloat(13, flightInfoBean.getBussSeatFare());
				stmt.setInt(14, flightInfoBean.getBussSeatsAvailable());
				
				recAffected = stmt.executeUpdate();	
	} catch(Exception e){
		throw new AirlineException("Problem in inserting Flight Details", e);
	}
		return recAffected > 0 ? true : false;
	}

	
	
	//retrieve flight details...users service
	@Override
	public ArrayList<FlightInfoBean> getFlightList(String depCity,
			String arrCity, LocalDate depDate) throws AirlineException {
	
		ArrayList<FlightInfoBean> flightInfoList = new ArrayList<>();
		FlightInfoBean flightInfoBean = null;
		
		String qry = "select * from flightInfo where depCity=? AND arrCity=? AND depDate=?";
		
		ResultSet rs = null;
		
		try(PreparedStatement stmt = connect.prepareStatement(qry);
			){
				stmt.setString(1, depCity);
				stmt.setString(2, arrCity);
				stmt.setDate(3, Date.valueOf(depDate));
			
				rs = stmt.executeQuery();
					while(rs.next())
					{
						int flightNo = rs.getInt("flightNo");
						String airline = rs.getString("airline");
						LocalDate arrDate = rs.getDate("arrDate").toLocalDate();
						String depTime = rs.getString("depTime");
						String arrTime = rs.getString("arrTime");
						int firstSeats = rs.getInt("firstSeats"); 
						int firstSeatsAvailable = rs.getInt("firstSeatsAvailable");
						float firstSeatFare = rs.getFloat("firstSeatFare");
						int bussSeats = rs.getInt("bussSeats");
						float bussSeatFare = rs.getFloat("bussSeatFare");
						int bussSeatsAvailable = rs.getInt("bussSeatsAvailable");
						
						flightInfoBean = new FlightInfoBean(flightNo, airline, depCity,
								arrCity, depDate, arrDate, depTime, arrTime, firstSeats,
								firstSeatsAvailable, firstSeatFare, bussSeats,
								bussSeatsAvailable, bussSeatFare);
						flightInfoList.add(flightInfoBean);
					}
				}
			catch (SQLException e) {
				
				throw new AirlineException("Problem in fetching flight details",e);
		} finally {
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					throw new AirlineException("Problem in closing Result Set", e);
				}
			}
		}
		return flightInfoList;
	}

	
	//update seats on successful booking...user service
	@Override
	public boolean updateSeatsOnBooking(int flightNo, String classType,
			 int noOfPassengers) throws AirlineException {
		
		int recAffected = 0;
		
		String qry="update flightInfo set ? = ?-? where flightNo=?";
		
		try(PreparedStatement stmt=connect.prepareStatement(qry);)
				{
					if("BUSINESS".equals(classType)){
						stmt.setString(1, "bussSeatsAvailable");
						stmt.setString(2, "bussSeatsAvailable");
					} 
					else if("FIRST".equals(classType)){
						stmt.setString(1, "firstSeatsAvailable");
						stmt.setString(2, "firstSeatsAvailable");
					}
						stmt.setInt(3, noOfPassengers);
						stmt.setInt(4, flightNo);
					
					recAffected = stmt.executeUpdate();
				}
			catch (SQLException e) {	
				throw new AirlineException("Problem in updating the no of seats!!!", e);
		}
			return recAffected > 0 ? true : false;
	}
	

	
	//get flight details on Id...used by executive/ admin
	@Override
	public FlightInfoBean getFlightDetailsOnId(int flightNo)
			throws AirlineException {
		
		FlightInfoBean flightInfoBean = null;
		
		String qry="SELECT * FROM flightInfo WHERE flightNo=?";
		ResultSet rs = null;
		
		try(PreparedStatement stmt = connect.prepareStatement(qry);
			) {
				stmt.setInt(1, flightNo);
				rs = stmt.executeQuery();
					
				while(rs.next()){
					
					String airline = rs.getString("airline");
					String depCity = rs.getString("depCity"); 
					String arrCity = rs.getString("arrCity");
					LocalDate depDate = rs.getDate("depDate").toLocalDate();
					LocalDate arrDate = rs.getDate("arrDate").toLocalDate();
					String depTime = rs.getString("depTime");
					String arrTime = rs.getString("arrTime");
					int firstSeats = rs.getInt("firstSeats"); 
					int firstSeatsAvailable = rs.getInt("firstSeatsAvailable");
					float firstSeatFare = rs.getFloat("firstSeatFare");
					int bussSeats = rs.getInt("bussSeats");
					float bussSeatFare = rs.getFloat("bussSeatFare");
					int bussSeatsAvailable  = rs.getInt("bussSeatsAvailable ");
					
					flightInfoBean = new FlightInfoBean(flightNo, airline, depCity, arrCity,
							depDate, arrDate, depTime, arrTime, firstSeats, firstSeatsAvailable,
							firstSeatFare, bussSeats, bussSeatsAvailable, bussSeatFare);
				}
				} catch (SQLException e) {
				throw new AirlineException("Problem in fetching flight details",e);
		} finally {
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					throw new AirlineException("Problem in closing Result Set", e);
				}
			}
		}
		return flightInfoBean;
	}

	
	//get flight list on Date...executive service
	@Override
	public ArrayList<FlightInfoBean> getFlightList(LocalDate startDepDate,
			LocalDate endDepDate) throws AirlineException {
		
		ArrayList<FlightInfoBean> flightInfoList = new ArrayList<>();
		FlightInfoBean flightInfoBean=null;
		
		String qry="SELECT * FROM flight_info WHERE dep_date BETWEEN ? AND ?";
		
		ResultSet rs = null;
		
		try(PreparedStatement stmt = connect.prepareStatement(qry);
			){
					stmt.setDate(1, Date.valueOf(startDepDate));
					stmt.setDate(2, Date.valueOf(endDepDate));
					
					rs = stmt.executeQuery();
					
					while(rs.next()){
						
						int flightNo = rs.getInt("flightNo");
						String airline  = rs.getString("airline");
						String depCity = rs.getString("depCity"); 
						String arrCity = rs.getString("arrCity");
						LocalDate depDate = rs.getDate("depDate").toLocalDate();
						LocalDate arrDate = rs.getDate("arrDate").toLocalDate();
						String depTime = rs.getString("depTime");
						String arrTime = rs.getString("arrTime");
						int firstSeats = rs.getInt("firstSeats"); 
						int firstSeatsAvailable = rs.getInt("firstSeatsAvailable");
						float firstSeatFare = rs.getFloat("firstSeatFare");
						int bussSeats = rs.getInt("bussSeats");
						float bussSeatFare = rs.getFloat("bussSeatFare");
						int bussSeatsAvailable = rs.getInt("bussSeatsAvailable");
						
						flightInfoBean = new FlightInfoBean(flightNo, airline, depCity, arrCity,
								depDate, arrDate, depTime, arrTime, firstSeats, firstSeatsAvailable,
								firstSeatFare, bussSeats, bussSeatsAvailable, bussSeatFare);
						
						flightInfoList.add(flightInfoBean);
					}
				} catch (SQLException e) {
					throw new AirlineException("Problem in fetching flight details on Departure Dates",e);
				} finally {
					if(rs!=null){
						try {
							rs.close();
						} catch (SQLException e) {
							throw new AirlineException("Problem in closing Result Set", e);
						}
					}
				}
					return flightInfoList;
		}

	
	//remove flight on id...admin service
	@Override
	public boolean removeFlight(int flightNo) throws AirlineException {
		
		String qry = "delete from flightInfo where flightNo=?";
		
		int recAffected = 0;
		
		try(PreparedStatement stmt = connect.prepareStatement(qry);
			){
				stmt.setInt(1, flightNo);
				recAffected = stmt.executeUpdate();
				
			} catch(Exception e){
				throw new AirlineException("Problem in removing Flight", e);
			}
			return recAffected > 0 ? true : false;
	}

}
