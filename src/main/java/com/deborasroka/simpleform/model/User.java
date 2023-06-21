package com.deborasroka.simpleform.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User extends Customer {

	private int customerID;
	private Boolean isAdmin;
	private Boolean isActive;
	private Boolean isConfirmed;
	
	
	
	
	public boolean validateEmail(String email){
			Matcher matcher;
		
			Pattern emailPattern = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
			matcher = emailPattern.matcher(email);

			return matcher.matches();
	}
	
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Boolean getIsConfirmed() {
		return isConfirmed;
	}
	public void setIsConfirmed(Boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	
	public boolean validateUserPassword(String password) {
		
		Matcher matcher;
	

		Pattern passwordPattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,15}$");

		if (password == null || password.isEmpty() ) {

			return false;

		} else {

			matcher = passwordPattern.matcher(password);

			if (!matcher.matches()) {
				return false;

			} else return true;
		}
	}
	
	
	@Override
	public String toString() {
		return "User [customerID=" + customerID + ", isAdmin=" + isAdmin + ", isActive=" + isActive + ", isConfirmed="
				+ isConfirmed + "]";
	}

}
