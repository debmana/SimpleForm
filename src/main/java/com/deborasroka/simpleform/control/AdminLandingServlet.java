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
		String search = request.getParameter("search"); 
		User user = new User();
		UserDAO userDAO = new UserDAO();
		Integer userID = 0;
			
		
		if (request.getParameter("search") != null){
			
			search = request.getParameter("search");
			
			if (user.validateEmail(search)) {
				try {
					user = userDAO.searchByEmail(search);
					
						request.setAttribute("suserID", user.getID());
						request.setAttribute("sname", user.getFirstName());
						request.setAttribute("slastname", user.getLastName());
						request.setAttribute("sphone", user.getPhone());
						request.setAttribute("saddress", user.getAddress());
						request.setAttribute("szipCode", user.getZipcode());
						request.setAttribute("scity", user.getCity());
						request.setAttribute("scountry", user.getCountry());
						request.setAttribute("swebsite", user.getWebsite());
						request.setAttribute("sgender", user.getGender());
						request.setAttribute("sbday", user.getBday());
						request.setAttribute("syear", user.getYday());
						request.setAttribute("smonth", user.getMday());
						request.setAttribute("semail", user.getEmail());
						request.setAttribute("searchResult", "true");
						request.setAttribute("ErrorSearch", "");
						System.out.println("This is what is coming from the servlet Admin " + user.getIsAdmin() +" Active: "+ user.getIsActive());
						request.setAttribute("sisAdmin", user.getIsAdmin());
						request.setAttribute("sisActive", user.getIsActive());
						
					
						request.getRequestDispatcher("/AdminLanding.jsp").forward(request, response);
					
				} catch (SQLException e) {
					System.out.println("Error during search from admin Panel" + e);
					request.setAttribute("search", search);
					request.setAttribute("ErrorSearch", "Your search did not return any value.");
					request.setAttribute("suserID", 0);
					request.getRequestDispatcher("/AdminLanding.jsp").forward(request, response);
				} 
				
			}else {
					
					try {
							
						userID = (Integer.parseInt(search));
						
							try {
								user = userDAO.searchByID(userID);
									request.setAttribute("suserID", user.getID());
									request.setAttribute("sname", user.getFirstName());
									request.setAttribute("slastname", user.getLastName());
									request.setAttribute("sphone", user.getPhone());
									request.setAttribute("saddress", user.getAddress());
									request.setAttribute("szipCode", user.getZipcode());
									request.setAttribute("scity", user.getCity());
									request.setAttribute("scountry", user.getCountry());
									request.setAttribute("swebsite", user.getWebsite());
									request.setAttribute("sgender", user.getGender());
									request.setAttribute("sbday", user.getBday());
									request.setAttribute("syear", user.getYday());
									request.setAttribute("smonth", user.getMday());
									request.setAttribute("semail", user.getEmail());
									request.setAttribute("sisAdmin", user.getIsAdmin());
									request.setAttribute("sisActive", user.getIsActive());
									request.setAttribute("ssearchResult", "true");
									request.setAttribute("ErrorSearch", "");
									System.out.println("This is what is coming from the servlet Admin: " + user.getIsAdmin() +" Active: "+ user.getIsActive());
									request.getRequestDispatcher("/AdminLanding.jsp").forward(request, response);

								
							} catch (SQLException e) {
								System.out.println("Ecception thrown when search user using ID: " +e);
								request.setAttribute("search", search);
								request.setAttribute("ErrorSearch", "Your search did not return any value.");
								request.setAttribute("suserID", 0);
								request.getRequestDispatcher("/AdminLanding.jsp").forward(request, response);
								
							}
						
					} catch(NumberFormatException nfe) {
						
						System.out.println("Edxception while converting Integer in search "+nfe);
						request.setAttribute("suserID", 0);
						request.setAttribute("search", search);
						request.setAttribute("ErrorSearch", "Your search did not return any value.");
						request.getRequestDispatcher("/AdminLanding.jsp").forward(request, response);
					}
					
				}
			} else {
				
				request.setAttribute("search", search);
				request.setAttribute("ErrorSearch", "Your search did not return any value.");
				request.setAttribute("suserID", 0);
				request.getRequestDispatcher("/AdminLanding.jsp").forward(request, response);
			}
			
			
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	
}
