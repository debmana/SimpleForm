package com.deborasroka.simpleform.control;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deborasroka.simpleform.model.Password;
import com.deborasroka.simpleform.model.User;
import com.deborasroka.simpleform.model.dao.AuthDAO;

import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//doGet(request, response);
		
		Boolean authenticated = false;
		AuthDAO pass = new AuthDAO();
		User user = new User();
		
		HttpSession session = request.getSession();

		
		String email = request.getParameter("email");
		String password = Password.encrypt(request.getParameter("password"));

		
		try {
			user = pass.Authenticate(email, password);
			
		} catch (SQLException e) {
			//System.out.println("Failed authentication "+ e);
			authenticated = false;
		}
		
		if (user == null || user.getID() == 0) {
			
			authenticated = false;
			session.setAttribute("isAuthenticated", false);
			//System.out.println("Login failed "+0);
			request.setAttribute("failedLogin", "Invalid Credentials.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
			
			
		} else {
			authenticated = true; 
			//System.out.println("You are logged in, congrats! "+authenticated);
			if (user.getIsAdmin()) {
				session.setAttribute("name", user.getFirstName());
				session.setAttribute("lastname", user.getLastName());
				session.setAttribute("phone", user.getPhone());
				session.setAttribute("address", user.getAddress());
				session.setAttribute("zipcode", user.getZipcode());
				session.setAttribute("city", user.getCity());
				session.setAttribute("country", user.getCountry());
				session.setAttribute("website", user.getWebsite());
				session.setAttribute("gender", user.getGender());
				session.setAttribute("bday", user.getBday());
				session.setAttribute("year", user.getYday());
				session.setAttribute("month", user.getMday());
				session.setAttribute("email", user.getEmail());
				session.setAttribute("agreement", user.isPrivacyagr());
				session.setAttribute("offerEmail", user.isOffers());
				
				
				session.setAttribute("isAdmin", user.getIsAdmin());
				session.setAttribute("isAuthenticated", true);
				
				//System.out.println("This is the session inside the login class"+ session.getAttribute("isAuthenticated"));
				
				request.getRequestDispatcher("/AdminLanding.jsp").forward(request, response);


			} else 
				
				session.setAttribute("name", user.getFirstName());
				session.setAttribute("lastname", user.getLastName());
				session.setAttribute("phone", user.getPhone());
				session.setAttribute("address", user.getAddress());
				session.setAttribute("zipcode", user.getZipcode());
				session.setAttribute("city", user.getCity());
				session.setAttribute("country", user.getCountry());
				session.setAttribute("website", user.getWebsite());
				
				if (user.getGender().contains("F") || user.getGender().contains("f")) {
					session.setAttribute("gender", "Female");
				} else if (user.getGender().contains("M") || user.getGender().contains("m")) {
					session.setAttribute("gender", "Male");
				}
		
				
				session.setAttribute("userID", user.getID());
				session.setAttribute("bday", user.getBday());
				session.setAttribute("year", user.getYday());
				session.setAttribute("month", user.getMday());
				session.setAttribute("email", user.getEmail());
				session.setAttribute("agreement", user.isPrivacyagr());
				session.setAttribute("offerEmail", user.isOffers());
				session.setAttribute("user", user);
				session.setAttribute("test", "tested");
				session.setAttribute("isAdmin", user.getIsAdmin());
				session.setAttribute("isAuthenticated", true);
				//System.out.println("this is the user ready to be sent to the JSP "+ user);
				//System.out.println("This is the session inside the login class"+ session.getAttribute("isAuthenticated"));
				request.getRequestDispatcher("/UserLanding.jsp").forward(request, response);
		}
	}

}
