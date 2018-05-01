package com.nagarro.flightmgmt.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.flightmgmt.constants.Constant;
import com.nagarro.flightmgmt.exception.FlightException;
import com.nagarro.flightmgmt.exception.InvalidArgumentException;
import com.nagarro.flightmgmt.model.FlightDetails;
import com.nagarro.flightmgmt.model.FlightSearch;
import com.nagarro.flightmgmt.service.FlightService;
import com.nagarro.flightmgmt.validator.FlightValidator;

/**
 * The class {@link FlightController} handles the requests that are concerns for
 * the flight operations such as adding a new flight, searching,listing. <br>
 * This class is a spring controller class. <br>
 * <br>
 * Since, this class is a Spring Controller class.This class must not be used as
 * any ordinary class.Spring uses this class for mapping the requests to and
 * from the user. <br>
 * <br>
 * 
 * The user should not create the instance of this class as the Spring container
 * automatically registers this class as bean in the application context.
 * 
 * @author Mehtab Anjum
 */

@Controller
public class FlightController {

	private static final Logger LOGGER = Logger.getLogger(FlightController.class);

	@Autowired
	protected FlightService flightService;

	/**
	 * method that performs the searching of flights.
	 * 
	 * @param flightSearch
	 * @param result
	 *            : used to store the errors that may have arise while validating
	 *            the search parameters
	 * @return{@link ModelAndView} object that contains view name and the flights
	 *               that matched the criteria
	 */
	@RequestMapping(value = { Constant.REQUEST_SEARCH_FLIGHT }, method = RequestMethod.POST)
	public ModelAndView searchFlight(@Valid @ModelAttribute(Constant.FLIGHT_SEARCH_MODEL) FlightSearch flightSearch,
			BindingResult result) {
		List<FlightDetails> matchedFlights = null;

		if (result.hasErrors()) {
			LOGGER.error("Error in flight Search :");
			return new ModelAndView(Constant.HOME_VIEW, "message", "Error in searching flight");
		} else {
			try {
				if (FlightValidator.isSearchDetailsValid(flightSearch)) {
					matchedFlights = flightService.returnMatchedFlights(flightSearch);
				}
			} catch (InvalidArgumentException | FlightException e) {
				LOGGER.error("Inputs for searching flights are not valid");
				return new ModelAndView(Constant.HOME_VIEW, "message", e.getMessage());

			}

			return new ModelAndView(Constant.FLIGHT_RESULT_VIEW, Constant.MATCHED_FLIGHT_MODEL, matchedFlights);
		}
	}

}