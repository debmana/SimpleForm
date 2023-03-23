package com.deborasroka.simpleform.model;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Customer {
	private int ID;
	private String firstName;
	private String LastName;
	private String email;
	private String password;
	private String phone;
	private String address;
	private String zipcode;

	private String city;
	private String country;
	private String website;
	private String gender;
	private String bday;
	private String mday;
	private String yday;
	private boolean privacyAgr;
	private boolean offers;


	@Override
	public String toString() {
		return "Customer [ID=" + ID + ", firstName=" + firstName + ", LastName=" + LastName + ", email=" + email
				+ ", password=" + password + ", phone=" + phone + ", address=" + address + ", city=" + city
				+ ", country=" + country + ", website=" + website + ", gender=" + gender + ", bday=" + bday + ", mday="
				+ mday + ", yday=" + yday + ", privacyagr=" + privacyAgr + ", offers=" + offers + "]";
	}

	public Customer() {

	}

	public Customer(int ID, String firstName, String lastName, String email, String password, String phone,
			String address, String zipcode, String city, String country, String website, String gender, String bday, String mday,
			String yday, boolean privacyAgr, boolean offers) {
		super();
		this.ID = ID;
		this.firstName = firstName;
		this.LastName = lastName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.country = country;
		this.website = website;
		this.gender = gender;
		this.bday = bday;
		this.mday = mday;
		this.yday = yday;
		this.privacyAgr = privacyAgr;
		this.offers = offers;
		this.zipcode = zipcode;
	}



	public HashMap<String, String> validateInput(Customer customer){
		HashMap<String, String> map = new HashMap<>();

		//Pattern pattern = Pattern.compile("^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-]*$");

		Pattern emailPattern = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = emailPattern.matcher(customer.getEmail());
		if (!matcher.matches()) {
			map.put("email", "The email entered is invalid, please try characters: A-B, 0-9, . , -, _");
		} 

		if (customer.getEmail().length()>=31) {
			String error = map.get("email");
			if (error!= null) {
				map.put("email", error+ "The email entered is too long, max lenght 30 characters.");

			} else {map.put("email", "The email entered is too long, max lenght 30 characters.");
			}
		} 




		Pattern passwordPattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,15}$");
		matcher = passwordPattern.matcher(customer.getPassword());

		if (!matcher.matches()) {
			map.put("password", "The password is not valid!");

		} 

		if (customer.getPassword().length()<6 || customer.getPassword().length()>14) {
			String error = map.get("phone");
			if(error==null) {
				map.put("password", "The password should be from 6 to 15 characters");

			} else {
				map.put("password", error+ " ,The password should be from 6 to 15 characters");
			}

		}

		Pattern zipCodePattern = Pattern.compile("^[0-9]{5}(?:-[0-9]{4})?$");
		matcher = zipCodePattern.matcher(customer.getZipcode());
		if (!matcher.matches()) {

			map.put("zipcode", "The zipCode is invalid.");
		}

		Pattern passPattern = Pattern.compile("^[0-9a-zA-Z\\Q!?@#$%^&*()_-+=\"'?<>,.\\E]{5,15}");
		matcher = passPattern.matcher(customer.getPassword());
		if (!matcher.matches()) {
			map.put("password", "The password is invalid please use A-B 0-9 and !?@#$%^&*()_-+=\"'?<>,. characters.");
		}

		//accept anything in the ASCII table

		Pattern phonePattern = Pattern.compile("^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})*$");
		matcher = phonePattern.matcher(customer.getPhone());

		if (!matcher.matches()) {
			map.put("phone", "The phone number is not valid.");

		} 

		if (customer.getPhone().length()>13) {
			String error = map.get("phone");
			if(error==null) {
				map.put("phone", "The phone number is too long.");

			} else {
				map.put("phone", error+ " ,The phone number is too long.");
			}

		}

		Pattern addressPattern = Pattern.compile("[\\x00-\\x7F]{3,45}");
		matcher = addressPattern.matcher(customer.getAddress());
		if (!matcher.matches()) {
			map.put("address", "The address is invalid, limit 45 characters.");
		}


		Pattern namePattern = Pattern.compile("[\\x00-\\x7F]{3,15}");
		matcher = namePattern.matcher(customer.getFirstName());
		if (!matcher.matches()) {
			map.put("firstName", "The first name is too long.");
		}
		matcher = namePattern.matcher(customer.getLastName());
		if (!matcher.matches()) {
			map.put("lastName", "The last name is too long.");
		}

		return map;
	}




	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBday() {
		return bday;
	}
	public void setBday(String bday) {
		this.bday = bday;
	}
	public String getMday() {
		return mday;
	}
	public void setMday(String mday) {
		this.mday = mday;
	}
	public String getYday() {
		return yday;
	}
	public void setYday(String yday) {
		this.yday = yday;
	}
	public boolean isPrivacyagr() {
		return privacyAgr;
	}
	public void setPrivacyagr(boolean privacyagr) {
		this.privacyAgr = privacyagr;
	}
	public boolean isOffers() {
		return offers;
	}
	public void setOffers(boolean offers) {
		this.offers = offers;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


}
