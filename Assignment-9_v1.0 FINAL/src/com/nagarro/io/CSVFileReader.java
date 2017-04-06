package com.nagarro.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.logging.Level;

import com.nagarro.FlightLauncher;
import com.nagarro.model.Flight;
import com.nagarro.util.Constant;

/**
 * This class contains methods like CSV file reader and flight data extraction.
 * @author khushbupatel
 *
 */
public final class CSVFileReader {

    private int finalId = 1;

    
    /**
     * Read CSV files from folder one by one and return a set of flight data
     * @param file
     * @return set of flight object
     */
    public Set<Flight> readFiles(File file) {
	Set<Flight> flightSet = new HashSet<>();

	try (FileReader fileReader = new FileReader(file);) {
	    
	    BufferedReader bufferedReader = new BufferedReader(fileReader);

	    // skip first row
	    bufferedReader.readLine();

	    String line = null;
	    while ((line = bufferedReader.readLine()) != null) {
		flightSet.add(getFlightData(line));
	    }

	} catch (Exception e) {
	    FlightLauncher.logger.log(Level.SEVERE, Constant.ERROR_READING_CSV, e);
	    System.exit(0);
	}

	return flightSet;
    }

   
    /**
     * Extract data from CSV file
     * @param line 
     * @return
     */
    private Flight getFlightData(String line) {
	StringTokenizer st = new StringTokenizer(line, "|");

	// extract data from line
	String flightNo = st.nextToken();
	String depLoc = st.nextToken();
	String arrLoc = st.nextToken();
	String date = st.nextToken();
	String flightTime = st.nextToken();
	Double flightDuration = Double.parseDouble(st.nextToken());
	int fare = Integer.parseInt(st.nextToken());
	String available = st.nextToken();
	String flightClass = st.nextToken();

	//check date formate
	Date validTillDate = null;
	try {
	    validTillDate = new SimpleDateFormat(Constant.DATE_FORMATE).parse(date);
	} catch (ParseException e) {
	    FlightLauncher.logger.log(Level.SEVERE, Constant.ERROR_DATE_FORMATE, e);
	    System.exit(0);
	}

	//set boolean values for seat availability
	boolean seatAvailability = false;
	if (available.charAt(0) == 'Y' || available.charAt(0) == 'y')
	    seatAvailability = true;

	// set all extracted data in flight class
	return new Flight(
		finalId++, 
		flightNo, 
		depLoc, 
		arrLoc, 
		fare, 
		validTillDate, 
		flightTime, 
		flightDuration,
		seatAvailability, 
		flightClass);
    }
}
