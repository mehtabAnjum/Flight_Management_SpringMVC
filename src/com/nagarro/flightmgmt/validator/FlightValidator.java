package com.nagarro.flightmgmt.validator;

import com.nagarro.flightmgmt.exception.FlightException;
import com.nagarro.flightmgmt.exception.InvalidArgumentException;
import com.nagarro.flightmgmt.model.FlightSearch;

/**
 * The class Validator is used to validate inputs that are entered by user to
 * search for flight
 * 
 * @author Mehtab Anjum
 * 
 */
public class FlightValidator {

	private FlightValidator() {

	}

	/**
	 * validates all the flight details.
	 * 
	 * @param flightSearch
	 *            {@link FlightSearch} the flight search details
	 * @return true if all fields are validated successfully,otherwise either throws
	 *         an {@link Exception} or return false
	 * @throws NULLReferenceException
	 * @throws FlightException
	 * @throws InvalidArgumentException
	 */

	public static boolean isSearchDetailsValid(FlightSearch flightSearch)
			throws FlightException, InvalidArgumentException {
		LocationValidator locationValidator = new LocationValidator();
		DateValidator dateValidator = new DateValidator();

		if (flightSearch == null) {
			throw new InvalidArgumentException("argument flightDetails is found null!!");
		}

		locationValidator.validateLocations(flightSearch.getArrivalLocation(), flightSearch.getDepartureLocation());
		dateValidator.validate(flightSearch.getFlightDate());

		return (isValidClass(flightSearch.getFlightClass()) && isValidPreference(flightSearch.getOutputPreference()));
	}

	private static boolean isValidClass(final String flightClass) throws InvalidArgumentException {
		if (!flightClass.equalsIgnoreCase("e") && !flightClass.equalsIgnoreCase("b")) {
			throw new InvalidArgumentException("Enter correct flight class: 'E' or 'B' ");
		}
		return (flightClass.equalsIgnoreCase("e") || flightClass.equalsIgnoreCase("b"));

	}

	private static boolean isValidPreference(final String outputPrefrence) throws InvalidArgumentException {
		if (!outputPrefrence.equals("0") && !outputPrefrence.equals("1")) {
			throw new InvalidArgumentException("Enter correct output preference: '0' or '1' ");
		}
		return (outputPrefrence.equals("0") || outputPrefrence.equals("1"));
	}

}
