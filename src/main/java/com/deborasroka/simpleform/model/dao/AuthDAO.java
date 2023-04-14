package com.deborasroka.simpleform.model.dao;

import java.sql.SQLException;

import com.deborasroka.simpleform.model.Customer;
import com.deborasroka.simpleform.model.User;



public class AuthDAO {
	
	
	
	public User Authenticate(String email, String password) throws SQLException {
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = new Customer();
		User user = new User();
		UserDAO userDAO = new UserDAO();
		
		try {
			user = userDAO.searchByEmail(email);
		
		} catch(SQLException e) {

			return null;
		}
		if (user == null || user.getID() == 0) {
			return null;
		} else

			if (user.getPassword().equals(password)){
				
				return user;
			
			} else 
				return null;
	}

}

// enter as a customer get out as an authenticated user, return USER instead of customer.
