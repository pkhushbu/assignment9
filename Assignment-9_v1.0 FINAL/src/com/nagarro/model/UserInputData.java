package com.nagarro.model;

import java.util.Date;


/**
 * This Class contains User input flight detail attributes and its getter setter methods.
 * @author khushbupatel
 *
 */
public class UserInputData {

    private String source, destination, flightClass, outputPreference;
    private Date flightDate;

    public UserInputData() {

    }

    public UserInputData(String source, String destination, String flightClass, Date flightDate,
	    String outputPreference) {
	this.source = source;
	this.destination = destination;
	this.flightClass = flightClass;
	this.flightDate = flightDate;
	this.outputPreference = outputPreference;

    }

    public String getSource() {
	return source;
    }

    public String getDestination() {
	return destination;
    }

    public String getFlightClass() {
	return flightClass;
    }

    public Date getFlightDate() {
	return flightDate;
    }

    public String getOutputPreference() {
	return outputPreference;
    }

}
