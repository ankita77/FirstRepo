package com.cg.ars.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.ars.beans.BookingInfoBean;
import com.cg.ars.beans.FlightInfoBean;
import com.cg.ars.exceptions.AirlineException;
import com.cg.ars.services.UserService;
import com.cg.ars.services.UserServiceImpl;

public class UserInterface {

	public static void main(String[] args){
		
		try {
		//creating service objects
		UserService userService = new UserServiceImpl();
		
		//BookingInfoBean object
		BookingInfoBean bookingInfoBean = new BookingInfoBean();

		Scanner kbdInput = new Scanner(System.in);
		
		//declare all variables globally here
		int choice = 0;
		String depCity = null;
		String arrCity = null;
		DateTimeFormatter format = null;
		LocalDate depDate = null;
		boolean depCityValid = false;
		boolean arrCityValid = false;
		boolean depDateValid = false;
		ArrayList<FlightInfoBean> flightInfoBean = null;
		int flightNo = 0;
		String classType = null;
		int noOfPassengers = 0;
		float totalFare = 0.0f;
		String creditCardInfo = null;
		String custEmail = null;
		boolean flightNoValid = false;
		boolean classTypeValid = false;
		boolean noOfPassengersValid = false;
		boolean custEmailValid = false;
		boolean creditCardInfoValid = false;
		int bookingId = 0;
		boolean bookingIdValid = false;
		boolean isBookingUpdated = false;
		boolean isBookingCancelled = false;
		
		
		
				do {    
					System.out.println("Welcome to Airline Reservation System.");
					System.out.println("Menu...");
					System.out.println("1. Book a flight.");
					System.out.println("2. View booking details.");
					System.out.println("3. Update booking details.");
					System.out.println("4. Cancel booking.");
					System.out.println("5. Exit.");
					
					System.out.println("Enter a choice");
					choice = kbdInput.nextInt();
					
					switch(choice){
					
					case 1: {
						//1. Book a flight
						//Enter valid depCity arrCity and depDate 
					do{
						System.out.println("Enter source city.");
						depCity = kbdInput.next();
						depCityValid = userService.validateDepCity(depCity);
					} while(!depCityValid);
					
					do{
						System.out.println("Enter arrival city.");
						arrCity = kbdInput.next();
						arrCityValid = userService.validateArrCity(arrCity);
					} while(!arrCityValid);
					
					do{
						System.out.println("Enter the date of departure.");
						String strDepDate = kbdInput.next();
						format = DateTimeFormatter.ofPattern("yyyy-mm-dd");
						depDate = LocalDate.parse(strDepDate, format);
						depDateValid = userService.validateDepDate(depDate);
					} while(!depDateValid);
						
					// Retrieve flight details
					flightInfoBean = userService.viewFlightList(depCity, arrCity, depDate);
					
					System.out.println("Do you wish to book a flight?");
					System.out.println("1. Yes.");
					System.out.println("2. No.");
					
					System.out.println("Enter a choice");
					choice = kbdInput.nextInt();
					
					switch(choice){
					
					case 1: {
						//I wish to book a flight.
						do{
						System.out.println("Enter flight number.");
						flightNo = kbdInput.nextInt();
						flightNoValid = userService.validateFlightNo(flightNo);
						} while(!flightNoValid);
						
						do{
						System.out.println("Enter class type.");
						classType = kbdInput.next();
						classTypeValid = userService.validateClassType(classType);
						} while(!classTypeValid);
						
						do{
						System.out.println("Enter number of passengers.");
						noOfPassengers = kbdInput.nextInt();
						noOfPassengersValid = userService.validateNoOfPassengers(noOfPassengers);
						} while(!noOfPassengersValid);
						
						totalFare = userService.generateTotalFare(flightNo, classType, noOfPassengers);
						System.out.println("Your total fare is: "+ totalFare);
						
						System.out.println("Do you wish to continue?");
						System.out.println("1. Yes.");
						System.out.println("2. No.");
						
						System.out.println("Enter a choice");
						choice = kbdInput.nextInt();
						
						switch(choice){
						
						case 1: {
							//I wish to continue and pay the fare.
							do{
							System.out.println("Enter your email.");
							custEmail = kbdInput.next();
							custEmailValid = userService.validateCustEmail(custEmail);
							} while(!custEmailValid);
							
							do{
							System.out.println("Enter your credit card number");
							creditCardInfo = kbdInput.next();
							creditCardInfoValid = userService.validateCreditCardInfo(creditCardInfo);
							} while(!creditCardInfoValid);
							
							bookingId = userService.bookFlight(flightNo, bookingInfoBean);
							System.out.println("Thank You for booking with Airline Resevation System.");
							System.out.println("Your booking Id is: " + bookingId);
							System.out.println("We hope to see you again.");
							
							break;
						}// End of case 1, switch 3
						
						case 2: {
							//I do not wish to pay the fare.
							
							System.out.println("Thanks and visit again.");
							
							break;
						}// End of case 2, switch 3
						
						}// End of switch 3
					
						break;	
						}// End of case 1, switch 2
						
						case 2: {
							//I do not wish to book a flight.
							
							System.out.println("Thanks and visit again.");
							
							break;
						}// End of case 2, switch 2
						
						
						}// End of switch 2
						
						
							break;
						}// End of case 1, switch 1
     
						
						case 2: {
							//2. View booking details.
							
							do{
							System.out.println("Enter your booking Id.");
							bookingId = kbdInput.nextInt();
							bookingIdValid = userService.validateBookingId(bookingId);
							} while(!bookingIdValid);
							
							bookingInfoBean = userService.viewBookingOnId(bookingId);
							System.out.println("Your booking details are: \n");
							System.out.println(bookingInfoBean);
							
							break;
						}// End of case 2, switch 1
						
						case 3: {
							//3. Update booking details.
							 
							do{
								System.out.println("Enter your booking Id.");
								bookingId = kbdInput.nextInt();
								bookingIdValid = userService.validateBookingId(bookingId);
								} while(!bookingIdValid);
							 
							isBookingUpdated = userService.updateBookingOnId(bookingId);
							if(isBookingUpdated){
								System.out.println("Your details have been successfully updated.");
								
								bookingInfoBean =userService.viewBookingOnId(bookingId);
								System.out.println("Your updated booking details are: \n");
								System.out.println(bookingInfoBean);
							}
							
							break;
						}// End of case 3, switch 1
						
						case 4: {
							//4. Cancel booking.
							
							do{
								System.out.println("Enter your booking Id.");
								bookingId = kbdInput.nextInt();
								bookingIdValid = userService.validateBookingId(bookingId);
								} while(!bookingIdValid);
							
							isBookingCancelled = userService.cancelBookingOnId(bookingId);
							if(isBookingCancelled){
								System.out.println("Your booking has been successfully cancelled.");								
							}
							
							break;
						}// End of case 4, switch 1
						
						case 5: {
							//5. Exit.
						
							System.out.println("Thanks and visit again.");
							  
							break;
						}// End of case 5, switch 1
						
						
						}// End of switch 1
				
					
					}// End of do
			 			while(choice != 5);
				
				}//end of Try Block
					catch (AirlineException e) {
						e.printStackTrace();
			}//End of catch block

	}// End of main

}// End of class
