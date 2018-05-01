package com.nagarro.flightmgmt.controller;

import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.flightmgmt.constants.Constant;
import com.nagarro.flightmgmt.model.FlightSearch;
import com.nagarro.flightmgmt.model.Login;
import com.nagarro.flightmgmt.service.LoginService;

/**
 * The class {@link LoginController} is a spring controller.<br>
 * This class is responsible for handling all the requests related to login.
 * 
 * 
 * The user should not create the instance of this class as the Spring container
 * automatically registers this class as bean in the application context.
 * 
 * @author Mehtab Anjum
 * 
 */

@Controller
@RequestMapping(Constant.REQUEST_DEFAULT_PAGE)
@SessionAttributes("loggedinUser")
public class LoginController {

	// log4j logger
	private static final Logger LOGGER = Logger.getLogger(LoginController.class);

	// object used to interact with database
	@Autowired
	public LoginService loginService;

	/**
	 * method that handles request for login
	 * 
	 * @return View of login page
	 */
	@RequestMapping(value = { Constant.REQUEST_DEFAULT_PAGE, Constant.REQUEST_LOGIN_PAGE }, method = RequestMethod.GET)
	public String showLoginPage() {

		return Constant.REQUEST_LOGIN_PAGE;
	}

	/**
	 * method that authenticates the login credentials entered by the end-user.
	 * 
	 * @param login
	 *            the {@link Login} object
	 * @param result
	 *            contains errors if any
	 * @return {@link ModelAndView} object
	 */

	@RequestMapping(value = { Constant.REQUEST_VERIFY_LOGIN }, method = RequestMethod.POST)
	public ModelAndView verifyLogin(@Valid @ModelAttribute(Constant.LOGIN_MODEL) Login login, BindingResult result) {
		ModelAndView mav = null;
		if (result.hasErrors()) {
			return new ModelAndView(Constant.REQUEST_LOGIN_PAGE);
		}
		boolean userExist = loginService.checkLogin(login);
		if (userExist) {
			LOGGER.info("Login Successfull for: " + login.getUserName());
			mav = new ModelAndView(Constant.HOME_VIEW, Constant.FLIGHT_SEARCH_MODEL, new FlightSearch());
			// saving the session for this user by adding the username to model
			mav.addObject("loggedinUser", login.getUserName());
		} else {
			mav = new ModelAndView(Constant.REQUEST_LOGIN_PAGE, "message", "Username or Password is wrong!!");
		}
		return mav;
	}

	/**
	 * 
	 * method that handles request for home page.
	 * 
	 * @param model
	 *            the model object
	 * @return {@link ModelAndView} object
	 */
	@RequestMapping(value = { Constant.REQUEST_HOME_PAGE })
	public ModelAndView showHomePage(Map<String, Object> model) {
		model.put(Constant.FLIGHT_SEARCH_MODEL, new FlightSearch());
		return new ModelAndView(Constant.HOME_VIEW, model);
	}

	/**
	 * 
	 * method that handles request for logout.
	 * 
	 * @param model
	 *            the model object
	 * @return {@link ModelAndView} object
	 */

	@RequestMapping(value = { Constant.LOGOUT_PAGE })
	public ModelAndView processLogout(Map<String, Object> model) {

		// inserting empty for user,so that it can no more display the username with
		// welcome message
		model.put("loggedinUser", "");
		model.put(Constant.LOGIN_MODEL, new Login());
		return new ModelAndView(Constant.LOGIN_VIEW, model);
	}
}
