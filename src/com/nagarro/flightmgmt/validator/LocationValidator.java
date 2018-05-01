package com.nagarro.flightmgmt.validator;

import com.nagarro.flightmgmt.constants.Constant;
import com.nagarro.flightmgmt.exception.FlightException;

public class LocationValidator implements Validator {

	@Override
	public void validate(Object object) throws FlightException {
		int locationLength = Constant.DEFAULT_DEPARTURE_LOCATION_LENGTH;
		String location = null;

		if (!(object instanceof String)) {
			throw new FlightException("Invalid Departure or Arrival Location!!");
		}

		location = (String) object;

		if (location.length() != locationLength) {
			throw new FlightException("Invalid Departure or Arrival Location!!");
		}
	}

	public void validateLocations(String departureLoc, String arrivalLoc) throws FlightException {
		validate(departureLoc);
		validate(arrivalLoc);
	}

}
