package com.nagarro.model;

import java.util.Date;

/**
 * This Class contains Flight attributes and its getter setter methods.
 * @author khushbupatel
 *
 */
public class Flight {

    private int id;
    private String flightNo, depLoc, arrLoc, flightTime, flightClass;
    private Date validTill;
    private double flightDuration;
    private int flightFare;
    private boolean seatAvailability;

    public Flight() {

    }

    public Flight(int id, String flightNo, String depLoc, String arrLoc, int flightFare, Date validTill,
	    String flightTime, double flightDuration, boolean seatAvailability, String flightClass) {

	this.id = id;
	this.flightNo = flightNo;
	this.depLoc = depLoc;
	this.arrLoc = arrLoc;
	this.validTill = validTill;
	this.flightTime = flightTime;
	this.flightDuration = flightDuration;
	this.seatAvailability = seatAvailability;
	this.flightClass = flightClass;
	this.flightFare = flightFare;
    }

    public int getId() {
	return id;
    }

    public String getFlightNo() {
	return flightNo;
    }

    public String getDepartureLocation() {
	return depLoc;
    }

    public String getArrivalLocation() {
	return arrLoc;
    }

    public Date getValidTill() {
	return validTill;
    }

    public String getFlightTime() {
	return flightTime;
    }

    public Double getFlightDuration() {
	return flightDuration;
    }

    public int getFlightFare() {
	return flightFare;
    }

    public boolean isSeatAvailability() {
	return seatAvailability;
    }

    public String getFlightClass() {
	return flightClass;
    }

}
