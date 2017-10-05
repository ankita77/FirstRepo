package com.cg.ars.beans;

import java.time.LocalDate;

public class FlightInfoBean {

	int flightNo;
	String airline;
	String depCity;
	String arrCity;
	LocalDate depDate;
	LocalDate arrDate;
	String depTime;
	String arrTime;
	int firstSeats;
	int firstSeatsAvailable;
	float firstSeatFare;
	int bussSeats;
	int bussSeatsAvailable;
	float bussSeatFare;
	
	//getters-setters
	public int getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getDepCity() {
		return depCity;
	}
	public void setDepCity(String depCity) {
		this.depCity = depCity;
	}
	public String getArrCity() {
		return arrCity;
	}
	public void setArrCity(String arrCity) {
		this.arrCity = arrCity;
	}
	public LocalDate getDepDate() {
		return depDate;
	}
	public void setDepDate(LocalDate depDate) {
		this.depDate = depDate;
	}
	public LocalDate getArrDate() {
		return arrDate;
	}
	public void setArrDate(LocalDate arrDate) {
		this.arrDate = arrDate;
	}
	public String getDepTime() {
		return depTime;
	}
	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}
	public String getArrTime() {
		return arrTime;
	}
	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}
	public int getFirstSeats() {
		return firstSeats;
	}
	public void setFirstSeats(int firstSeats) {
		this.firstSeats = firstSeats;
	}
	public int getFirstSeatsAvailable() {
		return firstSeatsAvailable;
	}
	public void setFirstSeatsAvailable(int firstSeatsAvailable) {
		this.firstSeatsAvailable = firstSeatsAvailable;
	}
	public float getFirstSeatFare() {
		return firstSeatFare;
	}
	public void setFirstSeatFare(float firstSeatFare) {
		this.firstSeatFare = firstSeatFare;
	}
	public int getBussSeats() {
		return bussSeats;
	}
	public void setBussSeats(int bussSeats) {
		this.bussSeats = bussSeats;
	}
	public int getBussSeatsAvailable() {
		return bussSeatsAvailable;
	}
	public void setBussSeatsAvailable(int bussSeatsAvailable) {
		this.bussSeatsAvailable = bussSeatsAvailable;
	}
	public float getBussSeatFare() {
		return bussSeatFare;
	}
	public void setBussSeatFare(float bussSeatFare) {
		this.bussSeatFare = bussSeatFare;
	}
	
	//parameterized constructor
	public FlightInfoBean(int flightNo, String airline, String depCity,
			String arrCity, LocalDate depDate, LocalDate arrDate,
			String depTime, String arrTime, int firstSeats,
			int firstSeatsAvailable, float firstSeatFare, int bussSeats,
			int bussSeatsAvailable, float bussSeatFare) {
		super();
		this.flightNo = flightNo;
		this.airline = airline;
		this.depCity = depCity;
		this.arrCity = arrCity;
		this.depDate = depDate;
		this.arrDate = arrDate;
		this.depTime = depTime;
		this.arrTime = arrTime;
		this.firstSeats = firstSeats;
		this.firstSeatsAvailable = firstSeatsAvailable;
		this.firstSeatFare = firstSeatFare;
		this.bussSeats = bussSeats;
		this.bussSeatsAvailable = bussSeatsAvailable;
		this.bussSeatFare = bussSeatFare;
	}
	
	//default constructor
	public FlightInfoBean() {
		super();
	}

	//To string method
	@Override
	public String toString() {
		return "FlightInfoBean [flightNo=" + flightNo + ", airline=" + airline
				+ ", depCity=" + depCity + ", arrCity=" + arrCity
				+ ", depDate=" + depDate + ", arrDate=" + arrDate
				+ ", depTime=" + depTime + ", arrTime=" + arrTime
				+ ", firstSeats=" + firstSeats + ", firstSeatsAvailable="
				+ firstSeatsAvailable + ", firstSeatFare=" + firstSeatFare
				+ ", bussSeats=" + bussSeats + ", bussSeatsAvailable="
				+ bussSeatsAvailable + ", bussSeatFare=" + bussSeatFare + "]";
	}
	
	
	
	
	
	
	
}
