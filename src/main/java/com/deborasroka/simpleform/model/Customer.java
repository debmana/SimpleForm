package com.deborasroka.simpleform.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.deborasroka.simpleform.model.dao.CustomerDAO;


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



	public HashMap<String, String> validateInput(Customer customer) throws SQLException{
		HashMap<String, String> map = new HashMap<>();
		Matcher matcher;
		CustomerDAO customerDAO = new CustomerDAO();

		//Pattern pattern = Pattern.compile("^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-]*$");

		Pattern emailPattern = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
		
		if (customer.getEmail() == null || customer.getEmail().isEmpty() ) {

			map.put("email", "The email field is empty");

		} else {

			matcher = emailPattern.matcher(customer.getEmail());
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
		}

		
		if (customerDAO.searchByEmailBool(customer.getEmail())){
			
			map.put("emailExist", "This email is already being used, try a different one.");
		}


		Pattern passwordPattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,15}$");

		if (customer.getPassword() == null || customer.getPassword().isEmpty() ) {

			map.put("password", "The password field is empty");

		} else {

			matcher = passwordPattern.matcher(customer.getPassword());

			if (!matcher.matches()) {
				map.put("password", "The password is not valid!");

			} 

			if (customer.getPassword().length()<6 || customer.getPassword().length()>15) {
				String error = map.get("phone");
				if(error==null) {
					map.put("password", "The password should be 6 to 15 characters");

				} else {
					map.put("password", error+ " ,The password should be 6 to 15 characters");
				}
			}
		}


		Pattern zipCodePattern = Pattern.compile("^[0-9]{5}(?:-[0-9]{4})?$");


		if (customer.getZipcode() == null || customer.getZipcode().isEmpty() ) {

			map.put("zipcode", "Zipcode is empty");

		} else {
			matcher = zipCodePattern.matcher(customer.getZipcode());
			if (!matcher.matches()) {

				map.put("zipcode", "The zipCode is invalid.");
			}
		}


		//accept anything in the ASCII table

		Pattern phonePattern = Pattern.compile("^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})*$");

		if (customer.getPhone() == null || customer.getPhone().isEmpty() ) {

			map.put("phone", "The phone field is empty.");

		} else {

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

		}

		Pattern addressPattern = Pattern.compile("[\\x00-\\x7F]{3,45}");

		if (customer.getAddress() == null || customer.getAddress().isEmpty() ) {

			map.put("address", "The address field is empty.");

		} else {
			matcher = addressPattern.matcher(customer.getAddress());
			if (!matcher.matches()) {
				map.put("address", "The address is invalid, limit 45 characters.");
			}
		}


		Pattern namePattern = Pattern.compile("[\\x00-\\x7F]{3,15}");

		if (customer.getFirstName() == null || customer.getFirstName().isEmpty() ) {

			map.put("firstname", "The name field is empty.");

		} else {
			matcher = namePattern.matcher(customer.getFirstName());
			if (!matcher.matches()) {
				map.put("firstname", "The first name is invalid.");
			}
		}


		if (customer.getLastName() == null || customer.getLastName().isEmpty() ) {

			map.put("lastname", "The last name field is empty.");

		} else {
			matcher = namePattern.matcher(customer.getLastName());
			if (!matcher.matches()) {
				map.put("lastname", "The last name is invalid.");
			}
		}
		
		
		if (customer.getCity() == null || customer.getCity().isEmpty() ) {

			map.put("city", "The city field is empty.");

		} else {
			matcher = namePattern.matcher(customer.getCity());
			if (!matcher.matches()) {
				map.put("city", "The city field is invalid.");
			}
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
