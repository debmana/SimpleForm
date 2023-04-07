package com.deborasroka.simpleform.model.dao;

import java.sql.SQLException;

import com.deborasroka.simpleform.model.Customer;

public class AuthDAO {
	
	
	
	public Customer Authenticate(String email, String password) throws SQLException {
		
		
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = new Customer();
		
		try {
			customer = customerDAO.searchByEmail(email);
		
		} catch(SQLException e) {

			return null;
		}
		
		
		if (customer == null || customer.getID() == 0) {
			return null;
		} else

			if (customer.getPassword().equals(password)){
				
				return customer;
			
			} else 
				return null;
	}

}
