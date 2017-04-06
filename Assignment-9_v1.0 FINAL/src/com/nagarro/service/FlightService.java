package com.nagarro.service;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.nagarro.hibernate.HibernateConfig;
import com.nagarro.model.Flight;
import com.nagarro.model.UserInputData;
import com.nagarro.util.Constant;

/**
 * This class contains services/methods related to flights like update data and
 * search data in Database
 * 
 * @author khushbupatel
 *
 */
public class FlightService {

    private static final FlightService service = new FlightService();

    /**
     * Update data in mySQL
     * 
     * @param flightDataSet
     */
    private void updateDB(Set<Flight> flightDataSet) {

	Session session = HibernateConfig.getSessionFactory().openSession();
	Transaction tx = session.beginTransaction();

	try {
	    for (Flight s : flightDataSet) {
		session.save(s);
	    }

	} catch (Exception e) {
	    System.out.println(Constant.ERROR_UPDATE_DATA + e);

	} finally {
	    tx.commit();
	    session.close();
	}

    }

    /**
     * Search user-expected flights
     * 
     * @param userData
     * @return List of flights
     */
    @SuppressWarnings({ "deprecation" })
    private List<Flight> searchFlight(UserInputData userData) {

	Flight flight = new Flight();
	List<Flight> searchList = null;

	Session session = HibernateConfig.getSessionFactory().openSession();
	Transaction tx = session.beginTransaction();
	Criteria criteria = session.createCriteria(Flight.class);

	try {

	    criteria.add(Restrictions.and(Restrictions.eq("arrLoc", userData.getDestination()),
		    Restrictions.eq("depLoc", userData.getSource())));
	    criteria.add(Restrictions.eq("flightClass", userData.getFlightClass()));
	    criteria.add(Restrictions.ge("validTill", userData.getFlightDate()));
	    criteria.add(Restrictions.eq("seatAvailability", flight.isSeatAvailability()));

	    if (userData.getOutputPreference().equalsIgnoreCase(Constant.FLIGHT_PREFERENCE_FARE)) { 
		criteria.addOrder(Order.asc("flightFare"));
	    } else {
		criteria.addOrder(Order.asc("flightDuration"));
		criteria.addOrder(Order.asc("flightFare"));
	    }

	    searchList = criteria.list();
	} catch (Exception e) {
	    System.out.println(Constant.ERROR_QUERY_SEARCH_FLIGHT);
	} finally {
	    tx.commit();
	    session.close();
	}

	return searchList;

    }

    /**
     * Search user-expected flight data in Database
     */
    public static List<Flight> getSearchList(UserInputData data) {
	return service.searchFlight(data);
    }

    /**
     * Insert/update data in Database
     */
    public static void setFlightData(Set<Flight> flightDataSet) {
	service.updateDB(flightDataSet);
    }
}
