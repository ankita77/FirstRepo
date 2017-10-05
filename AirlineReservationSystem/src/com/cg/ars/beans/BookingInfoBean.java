package com.cg.ars.beans;

public class BookingInfoBean {

	int bookingId;
	String custEmail;
	int noOfPassengers;
	String classType;
	float totalFare;
	String creditCardInfo;
	String srcCity;
	String destCity;
	
	//getters-setters
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public int getNoOfPassengers() {
		return noOfPassengers;
	}
	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	public float getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(float totalFare) {
		this.totalFare = totalFare;
	}
	public String getCreditCardInfo() {
		return creditCardInfo;
	}
	public void setCreditCardInfo(String creditCardInfo) {
		this.creditCardInfo = creditCardInfo;
	}
	public String getSrcCity() {
		return srcCity;
	}
	public void setSrcCity(String srcCity) {
		this.srcCity = srcCity;
	}
	public String getDestCity() {
		return destCity;
	}
	public void setDestCity(String destCity) {
		this.destCity = destCity;
	}
	
	
	//parameterized constructor
	public BookingInfoBean(int bookingId, String custEmail, int noOfPassengers,
			String classType, float totalFare, String creditCardInfo,
			String srcCity, String destCity) {
		super();
		this.bookingId = bookingId;
		this.custEmail = custEmail;
		this.noOfPassengers = noOfPassengers;
		this.classType = classType;
		this.totalFare = totalFare;
		this.creditCardInfo = creditCardInfo;
		this.srcCity = srcCity;
		this.destCity = destCity;
	}
	
	//default constructor
	public BookingInfoBean() {
		super();
	}
	
	//to String method
	@Override
	public String toString() {
		return "BookingInfoBean [bookingId=" + bookingId + ", custEmail="
				+ custEmail + ", noOfPassengers=" + noOfPassengers
				+ ", classType=" + classType + ", totalFare=" + totalFare
				+ ", creditCardInfo=" + creditCardInfo + ", srcCity=" + srcCity
				+ ", destCity=" + destCity + "]";
	}
	
	
	
	
}
