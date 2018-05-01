package com.nagarro.flightmgmt.model;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;

public class FlightSearch {
	private String departureLocation;

	private String arrivalLocation;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date flightDate;

	private String flightClass;

	private String outputPreference;

	private static final Logger LOGGER = Logger.getLogger(FlightSearch.class);

	/**
	 * @return the departureLocation
	 */
	public String getDepartureLocation() {
		return departureLocation;
	}

	/**
	 * @param departureLocation
	 *            the departureLocation to set
	 */
	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	/**
	 * @return the arrivalLocation
	 */
	public String getArrivalLocation() {
		return arrivalLocation;
	}

	/**
	 * @param arrivalLocation
	 *            the arrivalLocation to set
	 */
	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	/**
	 * @return the flightDate
	 */
	public Date getFlightDate() {

		return flightDate;
	}

	/**
	 * @param flightDate
	 *            the flightDate to set
	 */
	public void setFlightDate(Date flightDate) {

		this.flightDate = flightDate;
	}

	/**
	 * @return the flightClass
	 */
	public String getFlightClass() {
		return flightClass;
	}

	/**
	 * @param flightClass
	 *            the flightClass to set
	 */
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass.toUpperCase();
	}

	/**
	 * @return the outputPreference
	 */
	public String getOutputPreference() {
		return outputPreference;
	}

	/**
	 * @param outputPreference
	 *            the outputPreference to set
	 */
	public void setOutputPreference(String outputPreference) {
		this.outputPreference = outputPreference;
	}

}
