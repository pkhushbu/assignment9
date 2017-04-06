package com.nagarro.io;

import java.util.List;

import com.nagarro.model.Flight;

/**
 * This class contains method like display search result on console.
 * 
 * @author khushbupatel
 *
 */
public class UserOutput {

    /**
     * Prints expected search result on console
     * 
     * @param searchList
     */
    public void displayFlightSearchResult(List<Flight> searchList) {

	if (searchList.isEmpty()) {
	    System.out.println("\n\n\n\nNo result found.\n\n\n\n");
	} else {
	    System.out.println("\n\n\n\nSearch result:\n\n");
	    System.out.println("FNo\tArrLoc\tDepLoc\tFare\tTime\tDuration\tClass\tDate(yyyy-MM-dd)");
	    for (Flight flight : searchList) {
		System.out.println(flight.getFlightNo() + "\t" + flight.getArrivalLocation() + "\t"
			+ flight.getDepartureLocation() + "\t" + flight.getFlightFare() + "\t"
			+ flight.getFlightTime().substring(0, 2) + ":" + flight.getFlightTime().substring(2, 4) + "\t"
			+ String.format("%.2f", flight.getFlightDuration()) + "\t\t" + flight.getFlightClass() + "\t"
			+ flight.getValidTill().toString().substring(0, 10));
	    }

	    System.out.println("\n\n\nThank you.\n\n\n\n");

	}
    }

}
