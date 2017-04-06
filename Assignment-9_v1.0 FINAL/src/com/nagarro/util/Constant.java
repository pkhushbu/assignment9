package com.nagarro.util;

public class Constant {

    /**
     *  CSV files folder path
     */
    public static final String CSV_FILES_FOLDER_PATH = "C:\\Users\\khushbupatel\\neon\\workspace\\Assignment-3_v2.0 FINAL\\bin\\resources";

    /**
     * Date formate --> "dd-MM-yyyy"
     */
    public static final String DATE_FORMATE = "dd-MM-yyyy";
    
    /**
     * Hibernate cfg xml file name
     */
    public static final String HIBERNATE_CFG_XML = "hibernate.cfg.xml";
    
    /**
     * Error message for csv file reader
     */
    public static final String ERROR_READING_CSV = "Error while reading CSV file.";

    /**
     * Error message for wrong date formate
     */
    public static final String ERROR_DATE_FORMATE = "Error in date formate";

    /**
     * Error message for buffer reader exception
     */
    public static final String ERROR_BUFFER_READER = "Error occured in buffer reader while accepting user inputs.";

    /**
     * Error message for updating mySQL exception
     */
    public static final String ERROR_UPDATE_DATA = "Error in updating data in MySQL";

    /**
     * Error message for session factory build-fail
     */
    public static final String ERROR_HIBERNATE_SESSION_FACTORY = "Error while building sessionFactory.";
   
    /**
     * Error message for query execute exception
     */
    public static final String ERROR_QUERY_SEARCH_FLIGHT = "Error in search flight query.";

    /**
     * Message for wrong departure input
     */
    public static final String MESSAGE_INPUT_DEPARTURE = "\nFlights with this departure location is not found.Try Again.\n[ Valid Input : DEL ]\n\nDeparture location: ";

    /**
     * Message for wrong arrival input
     */
    public static final String MESSAGE_INPUT_ARRIVAL = "\nFlights with this arrival location is not found.Try Again.\n[ Valid Input : MUB/BGR ]\n\nArrival location: ";

    /**
     * Message for wrong flight class input
     */
    public static final String MESSAGE_INPUT_CLASS = "\nFlight Class is invalide.Try Again.\n[ Valid Input : E / B / EB ]\n\nFlight Class: ";

    /**
     * Message for wrong input date
     */
    public static final String MESSAGE_INPUT_DATE = "\nDate of travel is invalide.Try Again.\n[ Valid Input : DD-MM-YYYY ]\n\nDate Of Travel(DD-MM-YYYY): ";

    /**
     * Message for wrong input preference
     */
    public static final String MESSAGE_INPUT_PREFERENCE = "\nFlight Preference is invalide.Try Again.\n[ Valid Input : 1 / 2 ]\n\nOutput preference for flight-sort [enter 1 for Fare/ 2 for Duration]: ";

    /**
     * preference 1 is flight fare while 2 is duration
     */
    public static final String FLIGHT_PREFERENCE_FARE = "1";

    /**
     * preference 1 is flight fare while 2 is duration
     */
    public static final String FLIGHT_PREFERENCE_DURATION = "2";
}
