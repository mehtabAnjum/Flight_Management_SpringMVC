package com.nagarro.flightmgmt.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.flightmgmt.controller.LoginController;
import com.nagarro.flightmgmt.dao.LoginDao;
import com.nagarro.flightmgmt.model.Login;
import com.nagarro.flightmgmt.service.LoginService;

/**
 * The Class {@link LoginServiceImpl} cab be used to perform operations related
 * to databases such as add, delete, list all records.
 * 
 * @author Mehtab Anjum
 * 
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	private static final Logger LOGGER = Logger.getLogger(LoginController.class);

	@Autowired
	private LoginDao loginDao;

	@Override
	@Transactional
	public boolean checkLogin(Login loginParameters) {
		LOGGER.info("In Service class...Check Login");
		return loginDao.checkLogin(loginParameters);
	}
}
