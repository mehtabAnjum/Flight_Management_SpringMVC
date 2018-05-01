package com.nagarro.flightmgmt.validator;

import com.nagarro.flightmgmt.exception.FlightException;

public interface Validator {
	void validate(Object object) throws FlightException;
}
