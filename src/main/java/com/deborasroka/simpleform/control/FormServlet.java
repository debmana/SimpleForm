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
        // TODO Auto-generated constructor stub
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Customer customer = new Customer();
		
		customer.setEmail(request.getParameter("email"));
		customer.setPassword(request.getParameter("password"));
		customer.setFirstName(request.getParameter("lastName"));
		customer.setLastName(request.getParameter("name"));
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
					if (checkboxes[i].equals("accept")) {
						customer.setPrivacyagr(true);
					
					} else customer.setOffers(true);
				}
			}
			
		}
		
		HashMap<String, String> result = new HashMap<>();
		
		result = customer.validateInput(customer);
		
		if (result.isEmpty()) {
			CustomerDAO customerDAO = new CustomerDAO();
			try {
					request.setAttribute("errors", null);
					customerDAO.insert(customer);
				//System.out.println(customerDAO.searchByEmail("danny.sroka@gmail.com")); 
				//Customer customerTest = new Customer (6, "Jose", "Smith", "Myemail@test.com", "1234567", "8017093881",
				//	"rua Bonita", "84111", "SLC", "Brazil", "bombom.com", "M", "01", "01", "2011", true, false);
				//customerDAO.delete(customerTest);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			
			request.setAttribute("errors", result);
			request.setAttribute("test", "LITTLE TEST");
			request.getRequestDispatcher("/form.jsp").forward(request, response);
		}
    
		
		response.setContentType("text/html");
		PrintWriter output = response.getWriter();
		output.println("Hello, cat!! "+ customer.toString());
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
