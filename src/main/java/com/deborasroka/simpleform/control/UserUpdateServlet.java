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
import com.deborasroka.simpleform.model.dao.UserDAO;


@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserUpdateServlet() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		int userID = 0;
		UserDAO userDAO = new UserDAO();
		int udated = 0;
		boolean isAdmin = false;
		boolean isActive = false;
		String password="";
		
		
		if (user.validateUserPassword(request.getParameter("password")))  {
			password = Password.encrypt(request.getParameter("password"));
			
		}
		
		System.out.println("This is the value if the userID field: "+request.getParameter("UserIDText"));
		
		
		try {
			userID = Integer.parseInt(request.getParameter("UserIDText"));
			System.out.println("This is the value if the userID field from the try block: "+ userID);
		} catch (NumberFormatException e) {
			System.out.println("This is an exception of update User: "+ e);
			userID = 0;
		}
		
		
		
		String [] checkboxes = request.getParameterValues("checkbox");

		System.out.println("This is the value of the check0:  " +checkboxes[0]);
		
		if (checkboxes != null) {
			for (int i=0; i<checkboxes.length; i++) {
					
					if (checkboxes[i].contains("isAdmin")) {
						isAdmin = true;
						System.out.println("THis is the admin from inside UserUpdate: "+isAdmin);
					} 
					
			}
			
			for (int i=0; i<checkboxes.length; i++) {
				
				if (checkboxes[i].contains("isActive")) {
					isActive = true;
					System.out.println("THis is the active from inside UserUpdate: "+isActive);
				} 
				
			}		
				
		} 
		user.setFirstName(request.getParameter("name"));
		user.setLastName(request.getParameter("lastName"));
		user.setPhone(request.getParameter("phone"));
		user.setAddress(request.getParameter("address"));
		user.setZipcode((request.getParameter("zipCode")));
		user.setCity(request.getParameter("city"));
		user.setCountry(request.getParameter("country"));
		user.setWebsite(request.getParameter("website"));
		user.setBday(request.getParameter("bday"));
		user.setMday(request.getParameter("bmonth"));
		user.setYday(request.getParameter("bdayYear"));
		user.setID(userID);
		user.setGender(request.getParameter("gender"));
		user.setPassword(password);
		user.setEmail(request.getParameter("email"));
		user.setIsActive(isActive);
		System.out.println("##################  Is this active: " + isActive);
		user.setIsAdmin(isAdmin);
		System.out.println(user);
		
		try {
			udated = userDAO.update(user);
			request.setAttribute("updateResult", udated);
			request.getRequestDispatcher("/AdminLanding.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("updateResult", "failed");
			request.getRequestDispatcher("/AdminLanding.jsp").forward(request, response);
			e.printStackTrace();
		}
	}
}
