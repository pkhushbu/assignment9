package com.nagarro.io;

import java.util.regex.Pattern;

public class InputValidator {

    /**
     * checks input is alphabetic string size of 3
     * 
     * @param source
     * @return valid string else null
     */

    public String validateSource(String source) {

	if (Pattern.matches("[A-Z a-z]{3}", source) == true) {
	    return source.toUpperCase();
	}
	return null;

    }

    /**
     * checks input is alphabetic string size of 3
     * 
     * @param destination
     * @return valid string else null
     */
    public String validateDestination(String destination) {

	if (Pattern.matches("[A-Z a-z]{3}", destination) == true) {
	    return destination.toUpperCase();
	}
	return null;
    }

    /**
     * checks input is valid class
     * 
     * @param flightClass
     * @return valid string else null
     */
    public String validateFlightClass(String flightClass) {

	if (flightClass.equalsIgnoreCase("EB") || flightClass.equalsIgnoreCase("E")) {
	    return flightClass.toUpperCase();
	}
	if (flightClass.equalsIgnoreCase("B")) {
	    return "EB";
	}
	return null;
    }

    /**
     * check flight date formate
     * 
     * @param flightDate
     * @return valid string else null
     */
    public String validateDate(String flightDate) {

	if (Pattern.matches("[0-9]{1,2}[-]{1}[0-9]{1,2}[-]{1}[0-9]{4}", flightDate) == true) {
	    return flightDate;
	}

	return null;
    }

    /**
     * check valid output preference
     * 
     * @param preference
     * @return valid string else null
     */
    public String validateOutputPreference(String preference) {

	if (Pattern.matches("[1-2]{1}", preference)) {
	    return preference;
	}
	return null;
    }

}
