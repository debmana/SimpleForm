<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<% 
boolean isAuthenticated= false;
boolean isAdmin = false;

response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");


System.out.println("THis is what is in the session yralalalalalalalala" + session.getAttribute("isAuthenticated"));

try{
	
	if (session.getAttribute("isAuthenticated")!=null){
		isAuthenticated = (boolean) session.getAttribute("isAuthenticated");
	} else  isAuthenticated=false;
	
} catch(Exception e){
	
		isAuthenticated=false;
		System.out.println("Null pointer" +e);
	
		request.getRequestDispatcher("/AuthenticationError.jsp").forward(request, response);
}

try{
	
	if (session.getAttribute("isAdmin")!=null){
		isAdmin = (boolean) session.getAttribute("isAdmin");
	} else  {isAdmin=false;}
	
	} catch(Exception e){
	
		isAdmin=false;
		System.out.println("Null pointer" +e);
	
		request.getRequestDispatcher("/AuthenticationError.jsp").forward(request, response);
}

	if(isAuthenticated){
		if (isAdmin){
			
		} else {
			request.setAttribute("Unauthorizes", "You need to have adminn priviledges to access this page");
			request.getRequestDispatcher("/AuthenticationError.jsp").forward(request, response);
		}
	} else {request.getRequestDispatcher("/AuthenticationError.jsp").forward(request, response);}
%> 


<meta charset="UTF-8">
<title>Administrator Search Page:</title>

<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600'
	rel='stylesheet' type='text/css'>
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700"
	rel="stylesheet">
	
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">

<style type="text/css">
html, body {
	min-height: 100%;
}

body, div, form, input, select, p {
	padding: 0;
	margin: 0;
	outline: none;
	font-family: Roboto, Arial, sans-serif;
	font-size: 14px;
	color: #666;
}

h1 {
	margin: 0;
	font-weight: 400;
}

h3 {
	margin: 12px 0;
	color: #8ebf42;
}

.main-block {
	display: block;
	justify-content: center;
	align-items: center;
	background: #fff;
}

form {
	width: 100%;
	padding: 20px;
}

fieldset {
	border: none;
	border-top: 1px solid #8ebf42;
}

.fakeForm{

	width: 100%;
	padding: 20px;

}

.account-details, .personal-details {
	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
}

.account-details>div, .personal-details>div>div {
	display: flex;
	align-items: center;
	margin-bottom: 10px;
}

.account-details>div, .personal-details>div, input, label {
	width: 100%;
}

label {
	padding: 0 5px;
	text-align: right;
	vertical-align: middle;
}

.error {
	padding: 0 5px;
	color: #c90e11;
	width: 100%;
	font-size: 20px;
	position: absolute;
	text-align: center;
	align-content: center;
}

input {
	padding: 5px;
	vertical-align: middle;
}

input .error {
	padding: 5px;
	vertical-align: middle;
	border-color: #f57682;
	background-color: #f57682;
}

.checkbox {
	margin-bottom: 10px;
}

select, .children, .gender, .bdate-block {
	width: calc(100% + 26px);
	padding: 5px 0;
}

select {
	background: transparent;
}

.gender input {
	width: auto;
}

.gender label {
	padding: 0 5px 0 0;
}

.bdate-block {
	display: flex;
	justify-content: space-between;
}

.birthday select.day {
	width: 35px;
}

.birthdate select.month {
	width: calc(100% - 94px);
}

.birthday input {
	width: 38px;
	vertical-align: unset;
}

.checkbox input, .children input {
	width: auto;
	margin: -2px 10px 0 0;
}

.checkbox a {
	color: #8ebf42;
}

.checkbox a:hover {
	color: #82b534;
}

button {
	width: 100%;
	padding: 10px 0;
	margin: 10px auto;
	border-radius: 5px;
	border: none;
	background: #8ebf42;
	font-size: 14px;
	font-weight: 600;
	color: #fff;
}

button:hover {
	background: #82b534;
}

@media ( min-width : 568px) {
	.account-details>div, .personal-details>div {
		width: 50%;
	}
	label {
		width: 40%;
	}
	input {
		width: 60%;
	}
	select, .children, .gender, .bdate-block {
		width: calc(60% + 16px);
	}
}

input:-webkit-autofill,
input:-webkit-autofill:hover, 
input:-webkit-autofill:focus, 
input:-webkit-autofill:active{
    -webkit-box-shadow: 0 0 0 30px #fff inset !important;
    border: 1px solid black;
} 

input:-webkit-autofill{
    -webkit-text-fill-color: #000 !important;
}

</style>



</head>

<body>
	<div class="main-block">
			<form action="usersearch" method="get" name="form1">
			<fieldset>

			<h1>Search User (enter the user ID or EMAIL):</h1>

				<input style="width:28em;" type="text" name="search" TABINDEX=0 id="search" required maxlength="30"> 
				
				<button type="submit" style="width:14em;" id ="searchButton" value="search">Search!</button>

			</fieldset>

		</form>
		
 		<div>
			<fieldset>
				<legend>
					<h3>Account Details</h3>
				</legend>
				<div class="account-details">
					<div>

						<label>Email*</label><input type="text" name="email" TABINDEX=1
							id="email" required maxlength="25">
					</div>
					<div>

						<label>Password* (@$!%*#?& - [A-z, 0-9])- 6 to 15 characters. At least one upper case, one special and one number</label><input TABINDEX=3 type="password"
							name="password" id="password" maxlength="15" required><i class="fa-solid fa-eye" id="eye"></i>
					</div>
					<div>
						<label>Repeat email*</label><input TABINDEX=2 type="text"
							name="email_conf" id="email_conf" required>
					</div>
					<div>

						<label>Repeat password*</label><input TABINDEX=4 type="password"
							name="password_conf" id="password_conf" maxlength="15"
							required><i class="fa-solid fa-eye" id="eye2"></i>
					</div>
					
				</div>
				
			</fieldset>
			<fieldset>
				<legend>
					<h3>Personal Details</h3>
				</legend>
				<div class="personal-details">
					<div>
						<div>
							<label>First name*</label><input type="text" name="name"
								id="firstname" required>
						</div>
						<div>
							<label>Last name*</label><input type="text" name="lastName"
								id="lastname" required>
						</div>
						<div>
							<label>Phone*</label><input type="text" name="phone"
								maxlength="13" id="phone" required>
						</div>
						<div>
							<label>Address</label><input type="text" name="address"
								id="address">
						</div>
						<div>
							<label>ZipCode</label><input type="text" name="zipCode"
								id="zipcode">
						</div>
						<div>
							<label>City</label><input type="text" name="city" id="city"
								required>
						</div>
						<div>
							<label>Country*</label> <select name="country" id="country">
								<option value="USA">USA</option>
								<option value="Armenia" >Armenia</option>
								<option value="Brazil">Brazil</option>
								<option value="Russia">Russia</option>
								<option value="Germany">Germany</option>
								<option value="France">France</option>
								<option value="UK">UK</option>
							</select>
						</div>
						<div>
							<label>Website</label><input type="text" name="website"
								id="website">
						</div>
					</div>
					<div>
						<div>
							<label>Gender*</label>
							<div class="gender">
								<input type="radio" value="M" id="male" name="gender" required />
								<label for="male" class="radio">Male</label> 
								<input type="radio" value="F" id="female" name="gender" required /> <label
									for="female" class="radio">Female</label>
							</div>
						</div>
						<div class="birthdate">
							<label> Birthday*</label>
							<div class="bdate-block">
								<select class="day" required name="bday" id="bdayselector">
									<option value="01" id="01">01</option>
									<option value="02" id="02">02</option>
									<option value="03" id="03">03</option>
									<option value="04" id="04">04</option>
									<option value="05" id="05">05</option>
									<option value="06" id="06">06</option>
									<option value="07" id="07">07</option>
									<option value="08" id="08">08</option>
									<option value="09" id="09">09</option>
									<option value="10" id="10">10</option>
									<option value="11" id="11">11</option>
									<option value="12" id="12">12</option>
									<option value="13" id="13">13</option>
									<option value="14" id="14">14</option>
									<option value="15" id="15">15</option>
									<option value="16" id="16">16</option>
									<option value="17" id="17">17</option>
									<option value="18" id="18">18</option>
									<option value="19" id="19">19</option>
									<option value="20" id="20">20</option>
									<option value="21" id="21">21</option>
									<option value="22" id="22">22</option>
									<option value="23" id="23">23</option>
									<option value="24" id="24">24</option>
									<option value="25" id="25">25</option>
									<option value="26" id="26">26</option>
									<option value="27" id="27">27</option>
									<option value="28" id="28">28</option>
									<option value="29" id="29">29</option>
									<option value="30" id="30">30</option>
									<option value="31" id="31">31</option>
								</select> <select class="month" required value="nothing" name="bmonth"
									id="monthselector">

									<option value="1">January</option>
									<option value="2">February</option>
									<option value="3">March</option>
									<option value="4">April</option>
									<option value="5">May</option>
									<option value="6">June</option>
									<option value="7">July</option>
									<option value="8">August</option>
									<option value="9">September</option>
									<option value="10">October</option>
									<option value="11">November</option>
									<option value="12">December</option>
								</select> <select class="month" required value="nothing" name="bdayYear"
									id="yearselector">

									<option value="1940">1940</option>
									<option value="1941">1941</option>
									<option value="1942">1942</option>
									<option value="1943">1943</option>
									<option value="1944">1944</option>
									<option value="1945">1945</option>
									<option value="1946">1946</option>
									<option value="1947">1947</option>
									<option value="1948">1948</option>
									<option value="1949">1949</option>
									<option value="1950">1950</option>
									<option value="1951">1951</option>
									<option value="1952">1952</option>
									<option value="1953">1953</option>
									<option value="1954">1954</option>
									<option value="1955">1955</option>
									<option value="1956">1956</option>
									<option value="1957">1957</option>
									<option value="1958">1958</option>
									<option value="1959">1959</option>
									<option value="1960">1960</option>
									<option value="1961">1961</option>
									<option value="1962">1962</option>
									<option value="1963">1963</option>
									<option value="1964">1964</option>
									<option value="1965">1965</option>
									<option value="1966">1966</option>
									<option value="1967">1967</option>
									<option value="1968">1968</option>
									<option value="1969">1969</option>
									<option value="1970">1970</option>
									<option value="1971">1971</option>
									<option value="1972">1972</option>
									<option value="1973">1973</option>
									<option value="1974">1974</option>
									<option value="1975">1975</option>
									<option value="1976">1976</option>
									<option value="1977">1977</option>
									<option value="1978">1978</option>
									<option value="1979">1979</option>
									<option value="1980">1980</option>
									<option value="1981">1981</option>
									<option value="1982">1982</option>
									<option value="1983">1983</option>
									<option value="1984">1984</option>
									<option value="1985">1985</option>
									<option value="1986">1986</option>
									<option value="1987">1987</option>
									<option value="1988">1988</option>
									<option value="1989">1989</option>
									<option value="1990">1990</option>
									<option value="1991">1991</option>
									<option value="1992">1992</option>
									<option value="1993">1993</option>
									<option value="1994">1994</option>
									<option value="1995">1995</option>
									<option value="1996">1996</option>
									<option value="1997">1997</option>
									<option value="1998">1998</option>
									<option value="1999">1999</option>
									<option value="2000">2000</option>
									<option value="2001">2001</option>
									<option value="2002">2002</option>
									<option value="2003">2003</option>
									<option value="2004">2004</option>
									<option value="2005">2005</option>
									<option value="2006">2006</option>
									<option value="2007">2007</option>
									<option value="2008">2008</option>
									<option value="2009">2009</option>
									<option value="2010">2010</option>
									<option value="2011">2011</option>
									<option value="2012">2012</option>
									<option value="2013">2013</option>
									<option value="2014">2014</option>
									<option value="2015">2015</option>
									<option value="2016">2016</option>
									<option value="2017">2017</option>
									<option value="2018">2018</option>
									<option value="2019">2019</option>
									<option value="2020">2020</option>
									<option value="2021">2021</option>
									<option value="2022">2022</option>
									<option value="2023">2023</option>
								</select>
							</div>
						</div>

					</div>
				</div>
			</fieldset>
			<fieldset>
				<legend>
					<h3>Terms and Mailing</h3>
				</legend>
				<div class="terms-mailing">
					<div class="checkbox">
						<input type="checkbox" name="checkbox" value="accept"
							id="checkpriv"><span>I accept the Privacy Policy.
						</span>
					</div>
					<div class="checkbox">
						<input type="checkbox" name="checkbox" id="check" value="receive"><span>I
							want to receive personalized offers by your site</span>
					</div>
				</div>
			</fieldset>

			<button disabled type="button" id="save"
				style="background: #7d8c65">Save Changes</button> 
			<button disabled type="button" id="discard"
				style="background: #7d8c65">Discard Changes</button> 

		</div>
	</div>
	<c:set var="name" value="${name}" />
	<c:set var="lastName" value="${lastname}" />
	<c:set var="phone" value="${phone}" />
	<c:set var="address" value="${address}" />
	<c:set var="zipcode" value="${zipcode}" />
	<c:set var="city" value="${city}" />
	<c:set var="country" value="${country}" />
	<c:set var="website" value="${website}" />
	<c:set var="bday" value="${bday}" />
	<c:set var="year" value="${year}" />
	<c:set var="month" value="${month}" />
	<c:set var="email" value="${email}" />
	
	<script>
	
	<c:if test="${not empty searchResult}">
		document.getElementById("email").value = '<c:out value="${email}"/>'
    	document.getElementById("firstname").value = '<c:out value="${name}"/>'
    	document.getElementById("lastname").value = '<c:out value="${lastname}"/>'
    	document.getElementById("phone").value = '<c:out value="${phone}"/>'
    	document.getElementById("address").value = '<c:out value="${address}"/>'
    	document.getElementById("zipcode").value = '<c:out value="${zipcode}"/>'
    	document.getElementById("city").value = '<c:out value="${city}"/>'
    	document.getElementById("country").value = '<c:out value="${country}"/>'
    	document.getElementById("website").value = '<c:out value="${website}"/>'
    	document.getElementById("bdayselector").value = '<c:out value="${bday}"/>'
    	document.getElementById("monthselector").value = '<c:out value="${month}"/>'
    	document.getElementById("yearselector").value = '<c:out value="${year}"/>'
    	
   <c:if/>
    	
   <c:if test="${empty searchResult}">
		document.getElementById("email").value = "";
    	document.getElementById("firstname").value = "";
    	document.getElementById("lastname").value = "";
    	document.getElementById("phone").value = "";
    	document.getElementById("address").value = "";
    	document.getElementById("zipcode").value = "";
    	document.getElementById("city").value = "";
    	document.getElementById("country").value = "";
    	document.getElementById("website").value = "";
    	document.getElementById("bdayselector").value = "";
    	document.getElementById("monthselector").value = "";
    	document.getElementById("yearselector").value = "";
    	
   <c:if/>
    						
    </script>

	<script>
		<c:if test="${gender.pSystem == 'F'}">
			document.getElementById("female").checked = true;
		<c:if/>

		<c:if test="${gender.pSystem == 'M'}">
			document.getElementById("male").checked = true;
		<c:if/>
	</script>



	<c:forEach var="vmap" items="${errors}">
		<c:set var="key" value="${vmap.key}" />
		<script>
    		document.getElementById('<c:out value="${key}"/>').style.background = "#eda6ac";
			document.getElementById('<c:out value="${key}"/>').style.borderColor = "#f50015";
			document.getElementById('<c:out value="${key}"/>').style.borderStyle = "solid"; 
			document.getElementById('<c:out value="${key}"/>').style.borderWidth = "1px 1px 1px 1px";
		</script>
		<c:if test = "${vmap.key=='emailExist'}">
			<script>
				document.getElementById('email').style.background = "#eda6ac";
				document.getElementById('email').style.borderColor = "#f50015";
				document.getElementById('email').style.borderStyle = "solid"; 
				document.getElementById('email').style.borderWidth = "1px 1px 1px 1px";
			</script>
		</c:if>
	</c:forEach>

</body>
</html>

