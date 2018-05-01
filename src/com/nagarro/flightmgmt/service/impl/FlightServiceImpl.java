package com.nagarro.flightmgmt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.flightmgmt.dao.FlightDao;
import com.nagarro.flightmgmt.model.Flight;
import com.nagarro.flightmgmt.model.FlightDetails;
import com.nagarro.flightmgmt.model.FlightSearch;
import com.nagarro.flightmgmt.service.FlightService;

/**
 * The class {@link FlightServiceImpl} is the class from which the user
 * interacts for getting the facilities of database services
 * 
 * @author Mehtab Anjum
 *
 * 
 */
@Service
@Transactional
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightDao flightDao;

	@Override
	public List<FlightDetails> returnMatchedFlights(FlightSearch parameters) {
		List<FlightDetails> matchedFlights = new ArrayList<FlightDetails>();
		if (parameters != null) {
			matchedFlights = flightDao.retrieve(parameters);
		}
		return matchedFlights;

	}

	@Override
	@Transactional
	public void addFlightDetails(FlightDetails flightDetails) {
		if (flightDetails != null && flightDao != null) {
			flightDao.addFlightDetails(flightDetails);
		}
	}

	@Override
	@Transactional
	public void addFlight(Flight flight) {
		if (flight != null && flightDao != null) {
			flightDao.addFlight(flight);
		}
	}

	@Override
	@Transactional
	public void delete(Flight flight) {

		if (flight != null) {
			flightDao.delete(flight);
		}
	}

	@Override
	@Transactional
	public void deleteAll() {
		flightDao.deleteAll();
	}

}
