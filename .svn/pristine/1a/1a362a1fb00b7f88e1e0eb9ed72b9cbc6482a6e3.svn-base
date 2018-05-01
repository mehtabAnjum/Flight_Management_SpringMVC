/**
 * 
 */
package com.nagarro.flightmgmt.validator;

import java.util.Date;

import com.nagarro.flightmgmt.exception.FlightException;

/**
 * @author Mehtab Anjum
 * 
 */
public class DateValidator implements Validator {

	/**
	 * validates date for the flight details when the flight are importing
	 * 
	 * @param flightDate
	 *            the date to validate
	 * @throws FlightException
	 */
	@Override
	public void validate(Object object) throws FlightException {

		if (!(object instanceof Date)) {
			throw new FlightException("Invalid parameter: Expected String object!! ");
		}

	}

}
