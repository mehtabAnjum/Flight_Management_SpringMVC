package com.nagarro.flightmgmt.constants;

public class Constant {
	private Constant() {
		
	}
	
	public static final String REQUEST_DEFAULT_PAGE = "/";
	public static final String REQUEST_LOGIN_PAGE = "/login";
	public static final String REQUEST_VERIFY_LOGIN = "/verify-login";
	public static final String QUERY_SELECT_ALL = "from Login";
	public static final String TRUNCATE_FLIGHT = "delete from Flight";
	public static final String TRUNCATE_FLIGHTDETAILS = "delete from FlightDetails";
	public static final String DIRECTORY = "C:\\Users\\mehtabanjum\\Documents\\Plan_Advanced_java\\JSAG Files";
	public static final String DATA_PATH = "C:\\Users\\mehtabanjum\\Documents\\Plan_Advanced_java\\JSAG Files\\assignment\\";
	public static final String LOGIN_MODEL = "login";
	public static final String FLIGHT_SEARCH_MODEL = "flightSearch";
	public static final String REQUEST_HOME_PAGE = "/home";
	public static final String HOME_VIEW = "home";
	public static final String LOGOUT_PAGE = "/logout";
	public static final String LOGIN_VIEW = "login";
	public static final String REQUEST_SEARCH_FLIGHT = "/search-flight";
	public static final String FLIGHT_RESULT_VIEW = "flightresult";
	public static final String MATCHED_FLIGHT_MODEL = "matchedFlights";
	public static final String SORT_BY_FARE = "0";
	public static final String FIELD_FARE = "fare";
	public static final String FIELD_FLIGHT_DURATION = "flightDuration";
	public static final String FIELD_DEPARTURE_LOCATION = "departureLocation";
	public static final String FIELD_ARRIVAL_LOCATION = "arrivalLocation";
	public static final String FIELD_VALID_TILL = "validTill";
	public static final String FIELD_FLIGHT_CLASS = "flightClass";
	public static final String FIELD_USERNAME = "userName";
	public static final String FIELD_PASSWORD = "password";
	public static final String DEFAULT_DATE_FORMAT = "dd-MM-yyyy";
	public static final int DEFAULT_DEPARTURE_LOCATION_LENGTH = 3;
	public static final int FLIGHT_CODE_LENGTH = 2;
}
