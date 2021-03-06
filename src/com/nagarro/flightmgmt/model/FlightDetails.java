package com.nagarro.flightmgmt.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class FlightDetails {
	private static final Logger LOGGER = Logger.getLogger(FlightDetails.class);

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String flightNumber;

	private String departureLocation;

	private String arrivalLocation;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date validTill;

	private String flightTime;

	private Double flightDuration;

	private Double fare;

	private String seatAvailable;

	private String flightClass;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "flight_Details_mapping")
	private Flight flight;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDepartureLocation() {
		return departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public String getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public Date getValidTill() {
		return validTill;
	}

	/**
	 * @param validTill
	 *            the validTill to set
	 */
	public void setValidTill(String validTill) {
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("dd-MM-yyyy").parse(validTill);
		} catch (ParseException e) {
			LOGGER.error("Cannot parse date: ");
		}
		this.validTill = date1;
	}

	/**
	 * @param flightTime
	 *            the flightTime to set
	 */
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

	public String getFlightTime() {
		return flightTime;
	}

	public Double getFlightDuration() {
		return flightDuration;
	}

	public void setFlightDuration(Double flightDuration) {
		this.flightDuration = flightDuration;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

	public String getSeatAvailable() {
		return seatAvailable;
	}

	public void setSeatAvailable(String seatAvailable) {
		this.seatAvailable = seatAvailable;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {

		this.flightClass = flightClass.toUpperCase();
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightNumber=" + flightNumber + ", departureLocation=" + departureLocation
				+ ", arrivalLocation=" + arrivalLocation + ", validTill=" + validTill + ", flightTime=" + flightTime
				+ ", flightDuration=" + flightDuration + ", fare=" + fare + ", seatAvailable=" + seatAvailable
				+ ", flightClass=" + flightClass + "]";
	}

}
