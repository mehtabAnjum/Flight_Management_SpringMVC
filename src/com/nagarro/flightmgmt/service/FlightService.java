package com.nagarro.flightmgmt.service;

import java.util.List;

import com.nagarro.flightmgmt.model.Flight;
import com.nagarro.flightmgmt.model.FlightDetails;
import com.nagarro.flightmgmt.model.FlightSearch;

public interface FlightService {

	void addFlightDetails(FlightDetails flightDetails);

	void delete(Flight flight);

	List<FlightDetails> returnMatchedFlights(FlightSearch parameters);

	void addFlight(Flight flight);

	void deleteAll();

}
