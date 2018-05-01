package com.nagarro.flightmgmt.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.flightmgmt.constants.Constant;
import com.nagarro.flightmgmt.controller.LoginController;
import com.nagarro.flightmgmt.dao.FlightDao;
import com.nagarro.flightmgmt.model.Flight;
import com.nagarro.flightmgmt.model.FlightDetails;
import com.nagarro.flightmgmt.model.FlightSearch;

/**
 * The class {@link FlightDaoImpl} provides the actual implementation of the
 * operations that interacts with data store. <br>
 * <br>
 * The user of the application should not directly use this class,instead use
 * {@link FlightServiceImpl} class for performing data store operations.
 * 
 * 
 * @author Mehtab Anjum
 * @see FlightServiceImpl
 *
 */
@Repository
public class FlightDaoImpl implements FlightDao {

	private static final Logger LOGGER = Logger.getLogger(LoginController.class);

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FlightDetails> retrieve(FlightSearch parameters) {

		LOGGER.info("In FlightDaoImpl: retrieve ");

		List<FlightDetails> list = null;

		Criteria criteria = createCriteriaForSearch(parameters);
		list = criteria.list();

		return list;
	}

	@SuppressWarnings("deprecation")
	private Criteria createCriteriaForSearch(FlightSearch parameter) {
		Criteria searchCriteria = null;
		String flightClass = null;
		String sortPreference = null;

		// equal to %e% for economic class,this means if the flight class contains e
		// then include it
		flightClass = "%" + parameter.getFlightClass() + "%";

		searchCriteria = getCurrentSession().createCriteria(FlightDetails.class);
		Criterion depLocCriteria = Restrictions.eq(Constant.FIELD_DEPARTURE_LOCATION, parameter.getDepartureLocation());
		Criterion arrLocCriteria = Restrictions.eq(Constant.FIELD_ARRIVAL_LOCATION, parameter.getArrivalLocation());
		Criterion validTillCriteria = Restrictions.ge(Constant.FIELD_VALID_TILL, parameter.getFlightDate());
		Criterion flightClassCriteria = Restrictions.like(Constant.FIELD_FLIGHT_CLASS, flightClass);

		// include all the above criterias
		Conjunction andExpr = Restrictions.and(depLocCriteria, arrLocCriteria, flightClassCriteria, validTillCriteria);
		searchCriteria.add(andExpr);

		sortPreference = parameter.getOutputPreference();
		addSortToCriteria(searchCriteria, sortPreference);

		return searchCriteria;
	}

	private void addSortToCriteria(Criteria searchCriteria, String outputPreference) {

		if (Constant.SORT_BY_FARE.equalsIgnoreCase(outputPreference)) {
			searchCriteria.addOrder(Order.asc(Constant.FIELD_FARE));
		} else {
			searchCriteria.addOrder(Order.asc(Constant.FIELD_FLIGHT_DURATION));
			searchCriteria.addOrder(Order.asc(Constant.FIELD_FARE));
		}
	}

	@Override
	public void addFlightDetails(FlightDetails flightDetails) {
		LOGGER.info("flightDetails added:");
		getCurrentSession().saveOrUpdate(flightDetails);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Flight> getFlights() {
		List<Flight> list = null;
		list = getCurrentSession().createQuery(Constant.QUERY_SELECT_ALL).list();
		LOGGER.info("Flight details retrieved:");
		return list;
	}

	@Override
	public void addFlight(Flight flight) {
		getCurrentSession().saveOrUpdate(flight);
	}

	@Override
	public void delete(Flight flight) {
		getCurrentSession().delete(flight);
	}

	@Override
	public void truncate() {
		getCurrentSession().createQuery(Constant.TRUNCATE_FLIGHT).executeUpdate();

	}

	@Override
	public void deleteAll() {
		getCurrentSession().createQuery(Constant.TRUNCATE_FLIGHTDETAILS).executeUpdate();
	}

}
