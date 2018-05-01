package com.nagarro.flightmgmt.dao;

import java.util.List;

import com.nagarro.flightmgmt.model.Flight;
import com.nagarro.flightmgmt.model.FlightDetails;
import com.nagarro.flightmgmt.model.FlightSearch;

/**
 * 
 * Interface FlightDao specifies basic operations to perform on Flight.
 * 
 * @author Mehtab Anjum
 */

public interface FlightDao {
	void addFlightDetails(FlightDetails flight);

	/**
	 * retrieves the flight(s) that matches the specified flight parameters
	 * 
	 * @param parameter
	 *            {@link parameters} the flight parameters
	 * @return flights {@link List} the list of flight
	 */
	List<FlightDetails> retrieve(FlightSearch parameter);

	/**
	 * adds a {@link Flight} object to data store
	 * 
	 * @param flight
	 *            the flight to add
	 */
	void addFlight(Flight flight);

	/**
	 * retrieves all the flight records that are present in the data store.
	 * 
	 * @return List of type {@link Flight}
	 */
	List<Flight> getFlights();

	/**
	 * deletes flight record specified in the argument
	 * 
	 * @param flight
	 *            the flight to delete
	 * @return void
	 */
	void delete(Flight flight);

	void deleteAll();

	void truncate();

}
