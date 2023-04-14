package com.deborasroka.simpleform.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deborasroka.simpleform.model.User;
import com.deborasroka.simpleform.model.dao.UserDAO;


@WebServlet("/AdminLandingServlet")
public class AdminLandingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AdminLandingServlet() {

    }


    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("This is clearly the fufu: " +request.getParameter("search"));
		//response.getWriter().append("Served at dodododododododo: ").append(request.getContextPath()+" "+request.getParameter("search"));
		String search = request.getParameter("search"); 
		User user = new User();
		UserDAO userDAO = new UserDAO();
		int userID = 0;
			
		
		if (request.getParameter("search") != null){
			
			search = request.getParameter("search");
			if (user.validateEmail(search)) {
				try {
					user = userDAO.searchByEmail(search);
					request.setAttribute("userID", user.getID());
					request.setAttribute("name", user.getFirstName());
					request.setAttribute("lastname", user.getLastName());
					request.setAttribute("phone", user.getPhone());
					request.setAttribute("address", user.getAddress());
					request.setAttribute("zipcode", user.getZipcode());
					request.setAttribute("city", user.getCity());
					request.setAttribute("country", user.getCountry());
					request.setAttribute("website", user.getWebsite());
					request.setAttribute("gender", user.getGender());
					request.setAttribute("bday", user.getBday());
					request.setAttribute("year", user.getYday());
					request.setAttribute("month", user.getMday());
					request.setAttribute("email", user.getEmail());
					request.setAttribute("searchResult", "true");
					
					request.getRequestDispatcher("/AdminLanding.jsp").forward(request, response);
					
				} catch (SQLException e) {
					System.out.println("Error during search from admin Panel" + e);
					user = null;
					request.setAttribute("search", search);
					request.setAttribute("searchResult", null);
					request.setAttribute("userID", null);
					request.getRequestDispatcher("/AdminLanding.jsp").forward(request, response);
				} 
				
			}else {
					
					try {
							
						userID = (Integer.parseInt(search));
						if (userID >0){
							try {
								user = userDAO.searchByID(userID);
								request.setAttribute("userID", user.getID());
								request.setAttribute("name", user.getFirstName());
								request.setAttribute("lastname", user.getLastName());
								request.setAttribute("phone", user.getPhone());
								request.setAttribute("address", user.getAddress());
								request.setAttribute("zipcode", user.getZipcode());
								request.setAttribute("city", user.getCity());
								request.setAttribute("country", user.getCountry());
								request.setAttribute("website", user.getWebsite());
								request.setAttribute("gender", user.getGender());
								request.setAttribute("bday", user.getBday());
								request.setAttribute("year", user.getYday());
								request.setAttribute("month", user.getMday());
								request.setAttribute("email", user.getEmail());
								request.setAttribute("searchResult", "true");
								
								request.getRequestDispatcher("/AdminLanding.jsp").forward(request, response);
								
								
							} catch (SQLException e) {
								System.out.println("Eccept thrown when search user: " +e);
							}
							
						}
						
						
						
					} catch(NumberFormatException nfe) {
						
						System.out.println("Edxception while converting Integer in search "+nfe);
						request.setAttribute("search", search);
						request.setAttribute("searchResult", null);
						request.getRequestDispatcher("/AdminLanding.jsp").forward(request, response);
					}
					
				}
				
				
			} else {
				
				request.setAttribute("search", search);
				request.setAttribute("searchResult", null);
				request.getRequestDispatcher("/AdminLanding.jsp").forward(request, response);
			}
			
			
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
