package com.cg.ars.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.cg.ars.beans.UsersBean;
import com.cg.ars.exceptions.AirlineException;
import com.cg.ars.util.ConnectionUtil;

public class UsersDaoImpl implements UsersDao {

private Connection connect = null;
	
	public UsersDaoImpl() throws AirlineException {
		
		ConnectionUtil conn = new ConnectionUtil();
		connect = conn.getConnection();
	}

	//get Users List...called by users validation method
	@Override
	public ArrayList<UsersBean> getUsersList() throws AirlineException {
		
		UsersBean usersBean = null;
		ArrayList<UsersBean> usersList = new ArrayList<>();
		
		String qry = "select * from USERS";
		
		try(PreparedStatement stmt = connect.prepareStatement(qry);
				ResultSet rs = stmt.executeQuery();
			){
				while(rs.next()){
				String userName = rs.getString(1);
				String password = rs.getString(2);
				String role = rs.getString(3);
				
				usersBean = new UsersBean(userName, password, role);
				usersList.add(usersBean);
				}
				} catch (SQLException e) {
					throw new AirlineException("Probelm in getting the movie details!!!",e);
				}
			return usersList;
		}

	
	
}
