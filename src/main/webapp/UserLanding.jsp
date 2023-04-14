<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">

<% 
	boolean isAuthenticated= false;

	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	
	System.out.println("THis is what is in the session" + session.getAttribute("isAuthenticated"));
	System.out.println("THis is the name inside the JSP name %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" + session.getAttribute("name"));

	try{
		
		if (session.getAttribute("isAuthenticated")!=null){
			isAuthenticated = (boolean) session.getAttribute("isAuthenticated");
		} else  isAuthenticated=false;
		
	} catch(Exception e){
		
			isAuthenticated=false;
			System.out.println("Null pointer " +e);
		
			request.getRequestDispatcher("/AuthenticationError.jsp").forward(request, response);
	}
	
	
	if(!isAuthenticated){
		request.getRequestDispatcher("/AuthenticationError.jsp").forward(request, response);
	} 
%> 


	


<meta charset="UTF-8">



<title>Landing page</title>
</head>
		<div class="display-form">
			<div class="content">
	 		<h1 id="userID">This is your info:</h1>
	 		</div>
	 				
					<label id="name"> Name: ${sessionScope.name}</label>
					<label id="lastname"> Last Name: ${sessionScope.lastname}</label>
					<label id="bday"> Birthday: ${sessionScope.month} / ${sessionScope.bday} / ${sessionScope.year}</label> 
					<label id="gender">Gender: ${sessionScope.gender}</label>
					<label id="email"> Email: ${sessionScope.email}</label>
					<label id="phone"> Phone: ${sessionScope.phone}</label>
					<label id="address">Address: ${sessionScope.address}</label>
					<label id="zipcode"> ZipCode: ${sessionScope.zipcode}</label>
					<label id="city"> City: ${sessionScope.city}</label>
					<label id="country"> Country: ${sessionScope.country}</label>
					<label id="website"> WebSite: ${sessionScope.website}</label>
					<label id="agreement">Accepted Privacy Agreement: ${sessionScope.agreement}</label>
					<label id="offerEmail">Accepted Email Offers: ${sessionScope.offerEmail}</label><br>
					<label> To request any changes, please contact us.</label>
					
					
								
			<form class="display-form" method="get" action="logout" >
				
      			<button id="logout" type="submit" value="logout">Logout</button>
      		</form>
					
					
			</div>

	</body>
</html>