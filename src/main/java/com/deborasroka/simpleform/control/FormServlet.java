package com.deborasroka.simpleform.control;

import com.deborasroka.simpleform.model.dao.CustomerDAO;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deborasroka.simpleform.model.Customer;


@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FormServlet() {
        super();
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Customer customer = new Customer();
    	CustomerDAO customerDAO = new CustomerDAO();
    	String confEmail="";
		String confPass="";
		HashMap<String, String> result = new HashMap<>();
		String email = request.getParameter("email");

    	customer.setEmail(email);
    		
    		confEmail = request.getParameter("email_conf");
    		confPass = request.getParameter("password_conf");
    		customer.setEmail(request.getParameter("email"));
    		customer.setPassword(request.getParameter("password"));
    		customer.setFirstName(request.getParameter("name"));
    		customer.setLastName(request.getParameter("lastName"));
    		customer.setPhone(request.getParameter("phone"));
    		customer.setAddress(request.getParameter("address"));
    		customer.setCity(request.getParameter("city"));
    		customer.setZipcode(request.getParameter("zipCode"));
    		customer.setCountry(request.getParameter("country"));
    		customer.setWebsite(request.getParameter("website"));
    		customer.setGender(request.getParameter("gender"));
    		customer.setBday(request.getParameter("bday"));
    		customer.setMday(request.getParameter("bmonth"));
    		customer.setYday(request.getParameter("bdayYear"));
    		String [] checkboxes = request.getParameterValues("checkbox");
    		if (checkboxes != null) {
    			for (int i=0; i<checkboxes.length; i++) {
    				if (checkboxes[i] != null) {
    					if (checkboxes[i].contains("accept")) {
    						customer.setPrivacyagr(true);
    					} else if (checkboxes[i].contains("receive")) {
    						customer.setOffers(true);
    					} else {
    						customer.setPrivacyagr(false);
    						customer.setOffers(false);
    					}
    					
    				}
    			}
    			
    		}

		String gRecaptchaResponse = request.getParameter("g-recaptcha-response");

		boolean captcha = Captcha.verify(gRecaptchaResponse);
		System.out.println("This is the value of boolean "+captcha);
		

		
			try {
				result = customer.validateInput(customer);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			
			if (confEmail != null) {
				if (!customer.getEmail().toLowerCase().equals(confEmail.toLowerCase())) {
						result.put("email_conf", "Emails do not match.");
				}
			}
			
		
		
		
		if (!result.containsValue("password")) {
			if (confPass != null) {
					if (!customer.getPassword().equals(confPass)) {
						result.put("password_conf", "Passwords do not match.");
					}
			}
			
		}
			if (result.isEmpty() && customer.isPrivacyagr() && captcha) {
			
				try {
						request.setAttribute("errors", null);
						customerDAO.insert(customer);
						request.getRequestDispatcher("/index.jsp").forward(request, response);

				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				request.setAttribute("errors", result);
				request.setAttribute("name", customer.getFirstName());
				request.setAttribute("lastname", customer.getLastName());
				request.setAttribute("phone", customer.getPhone());
				request.setAttribute("address", customer.getAddress());
				request.setAttribute("zipcode", customer.getZipcode());
				request.setAttribute("city", customer.getCity());
				request.setAttribute("country", customer.getCountry());
				request.setAttribute("website", customer.getWebsite());
				request.setAttribute("gender", customer.getGender());
				request.setAttribute("bday", customer.getBday());
				request.setAttribute("year", customer.getYday());
				request.setAttribute("month", customer.getMday());
				request.setAttribute("email", customer.getEmail());
				request.setAttribute("captcha", captcha);
			
				request.getRequestDispatcher("/form.jsp").forward(request, response);

		}
	

    
}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
