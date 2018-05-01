package com.nagarro.flightmgmt.dao.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.flightmgmt.constants.Constant;
import com.nagarro.flightmgmt.controller.LoginController;
import com.nagarro.flightmgmt.dao.LoginDao;
import com.nagarro.flightmgmt.model.FlightDetails;
import com.nagarro.flightmgmt.model.Login;
import com.nagarro.flightmgmt.model.User;

/**
 * The class {@link LoginDaoImpl} provides implementation for the
 * {@link LoginDao} methods. <br>
 * This class performs the actual interaction with the data source. <br>
 * <br>
 * The user of the application should not directly use this class,instead use
 * {@link LoginServiceImpl} class for performing data store operations.
 * 
 * @author Mehtab Anjum
 */
@Repository("loginDAO")
public class LoginDaoIpml implements LoginDao {
	private static final Logger LOGGER = Logger.getLogger(LoginController.class);

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public boolean checkLogin(Login loginParameters) {
		LOGGER.info("In Check login");

		List<FlightDetails> list = null;

		Criteria criteria = createCriteriaForLogin(loginParameters);
		list = criteria.list();

		return (!list.isEmpty());

	}

	@SuppressWarnings("deprecation")
	private Criteria createCriteriaForLogin(Login loginParameter) {
		Criteria searchCriteria = null;

		searchCriteria = getCurrentSession().createCriteria(User.class);
		Criterion userNameCriteria = Restrictions.eq(Constant.FIELD_USERNAME, loginParameter.getUserName());

		Criterion passwordCriteria = Restrictions.eq(Constant.FIELD_PASSWORD, loginParameter.getPassword());

		// include all the above criterias
		LogicalExpression andExpr = Restrictions.and(userNameCriteria, passwordCriteria);
		searchCriteria.add(andExpr);

		return searchCriteria;
	}

}
