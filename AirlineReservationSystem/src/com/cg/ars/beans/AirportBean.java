package com.cg.ars.beans;

public class AirportBean {

	String airportName;
	String abbreviation;
	String location;
	
	//getters-setters
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	//parameterized constructor
	public AirportBean(String airportName, String abbreviation, String location) {
		super();
		this.airportName = airportName;
		this.abbreviation = abbreviation;
		this.location = location;
	}
	
	//default constructor
	public AirportBean() {
		super();
	}
	
	
	
	
}
