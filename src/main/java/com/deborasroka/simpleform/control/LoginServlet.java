package com.deborasroka.simpleform.control;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deborasroka.simpleform.model.Customer;
import com.deborasroka.simpleform.model.Password;
import com.deborasroka.simpleform.model.dao.AuthDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		
		Boolean authenticated = false;
		AuthDAO pass = new AuthDAO();
		Customer customer = new Customer();
		
		String email = request.getParameter("email");
		String password = Password.encrypt(request.getParameter("password"));
		
		try {
			customer = pass.Authenticate(email, password);
			
		} catch (SQLException e) {
			System.out.println("Failed authentication "+ e);
			authenticated = false;
		}
		
		if (customer == null || customer.getID() == 0) {
			
			authenticated = false;
			System.out.println("Login failed "+authenticated);
			
		} else authenticated = true; System.out.println("You are logged in, congrats! "+authenticated);
	}

}
