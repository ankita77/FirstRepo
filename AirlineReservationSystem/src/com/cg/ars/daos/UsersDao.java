package com.cg.ars.daos;

import java.util.ArrayList;

import com.cg.ars.beans.UsersBean;
import com.cg.ars.exceptions.AirlineException;

public interface UsersDao {

	//all the services will access this method.
	public ArrayList<UsersBean> getUsersList() throws AirlineException;
	
	
}
