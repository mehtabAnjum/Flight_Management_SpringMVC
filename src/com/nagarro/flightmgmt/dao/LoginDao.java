package com.nagarro.flightmgmt.dao;

import com.nagarro.flightmgmt.model.Login;

public interface LoginDao {
	public boolean checkLogin(Login loginParameters);
}
