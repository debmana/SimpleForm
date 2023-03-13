<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Account registration form</title>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600'
	rel='stylesheet' type='text/css'>
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700"
	rel="stylesheet">
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
	display: flex;
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

input {
	padding: 5px;
	vertical-align: middle;
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
</style>
</head>
<body>
	<div class="main-block">
		<form action="formSend" method="post" >
			<h1>Create a free account</h1>
			<fieldset>
				<legend>
					<h3>Account Details</h3>
				</legend>
				<div class="account-details">
					<div>
						<label>Email*</label><input type="text" name="email" required>
					</div>
					<div>
						<label>Password*</label><input type="password" name="password"
							required>
					</div>
					<div>
						<label>Repeat email*</label><input type="text" name="email_conf"
							required>
					</div>
					<div>
						<label>Repeat password*</label><input type="password" name="password_conf"
							required>
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
							<label>First name*</label><input type="text" name="name" required>
						</div>
												<div>
						<label>Last name*</label><input type="text" name="lastName" required>
						</div>
						<div>
							<label>Phone*</label><input type="text" name="phone" required>
						</div>
						<div>
							<label>Address</label><input type="text" name="address">
						</div>
						<div>
							<label>City</label><input type="text" name="city" required>
						</div>
						<div>
							<label>Country*</label> <select name="country">
								<option value="USA">USA</option>
								<option value="Armenia">Armenia</option>
								<option value="Brazil">Brazil</option>
								<option value="Russia">Russia</option>
								<option value="Germany">Germany</option>
								<option value="France">France</option>
								<option value="UK">UK</option>
							</select>
						</div>
						<div>
							<label>Website</label><input type="text" name="website">
						</div>
					</div>
					<div>
						<div>
							<label>Gender*</label>
							<div class="gender">
								<input type="radio" value="M" id="male" name="gender"
									required /> <label for="male" class="radio">Male</label> 
								<input type="radio" value="F" id="female" name="gender" required />
								<label for="female" class="radio">Female</label>
							</div>
						</div>
						<div class="birthdate">
							<label>Day*</label>
							<div class="bdate-block">
								<select class="day" required name="bday">
									<option value="01">01</option>
									<option value="02">02</option>
									<option value="03">03</option>
									<option value="04">04</option>
									<option value="05">05</option>
									<option value="06">06</option>
									<option value="07">07</option>
									<option value="08">08</option>
									<option value="09">09</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
									<option value="13">13</option>
									<option value="14">14</option>
									<option value="15">15</option>
									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
									<option value="21">21</option>
									<option value="22">22</option>
									<option value="23">23</option>
									<option value="24">24</option>
									<option value="25">25</option>
									<option value="26">26</option>
									<option value="27">27</option>
									<option value="28">28</option>
									<option value="29">29</option>
									<option value="30">30</option>
									<option value="31">31</option>
								</select> 
								
								<select class="month" required value="nothing" name="bmonth">
									
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
								</select> 
								<input type="text" name="bdayYear" required>
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
						<input type="checkbox" name="checkbox" value="accept"><span>I
							accept the Debora Sroka Privacy
								Policy.
						</span>
					</div>
					<div class="checkbox">
						<input type="checkbox" name="checkbox" value="receive"><span>I want
							to receive personalized offers by your site</span>
					</div>
				</div>
			</fieldset>
			<button type="submit">Submit</button>
		</form>
	</div>
</body>
</html>

