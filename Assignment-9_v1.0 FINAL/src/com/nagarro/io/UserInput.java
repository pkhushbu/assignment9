package com.nagarro.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

import com.nagarro.FlightLauncher;
import com.nagarro.model.UserInputData;
import com.nagarro.util.Constant;

/**
 * This class contains user input acceptor method.
 * 
 * @author khushbupatel
 *
 */
public class UserInput {

    private static final InputValidator input = new InputValidator();
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Takes inputs from user
     * 
     * @return object of userInputData
     */
    public UserInputData acceptUserInput() {

	String source = "", destination = "", flightClass = "", outputPreference = "", date = null;
	Date flightDate = null;

	try {

	    System.out.print("\n\n\n\n\nDeparture location: ");

	    while ((source = input.validateSource(br.readLine())) == null) {
		System.out.print(Constant.MESSAGE_INPUT_DEPARTURE);
		continue;
	    }

	    System.out.print("Arrival location: ");

	    while ((destination = input.validateDestination(br.readLine())) == null) {
		System.out.print(Constant.MESSAGE_INPUT_ARRIVAL);
		continue;
	    }

	    System.out.print("Flight Class: ");

	    while ((flightClass = input.validateFlightClass(br.readLine())) == null) {
		System.out.print(Constant.MESSAGE_INPUT_CLASS);
		continue;
	    }

	    System.out.print("Date Of Travel(DD-MM-YYYY): ");

	    while ((date = input.validateDate(br.readLine())) == null) {
		System.out.print(Constant.MESSAGE_INPUT_DATE);
		continue;
	    }
	    flightDate = new SimpleDateFormat(Constant.DATE_FORMATE).parse(date);

	    System.out.print("Output preference for flight-sort [enter 1 for Fare/ 2 for Duration]: ");

	    while ((outputPreference = input.validateOutputPreference(br.readLine())) == null) {
		System.out.print(Constant.MESSAGE_INPUT_PREFERENCE);
		continue;
	    }

	} catch (Exception e) {
	    FlightLauncher.logger.log(Level.SEVERE, Constant.ERROR_BUFFER_READER, e);
	    System.exit(0);
	}

	return new UserInputData(source, destination, flightClass, flightDate, outputPreference);

    }
}
