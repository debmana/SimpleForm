package com.deborasroka.simpleform.model;

public class Customer {
	
	
	int ID;
	String firstName;
	String LastName;
	String email;
	String password;
	String phone;
	String address;
	String city;
	String country;
	String website;
	String gender;
	String bday;
	String mday;
	String yday;
	boolean privacyAgr;
	boolean offers;
	
	
	
	@Override
	public String toString() {
		return "Customer [ID=" + ID + ", firstName=" + firstName + ", LastName=" + LastName + ", email=" + email
				+ ", password=" + password + ", phone=" + phone + ", address=" + address + ", city=" + city
				+ ", country=" + country + ", website=" + website + ", gender=" + gender + ", bday=" + bday + ", mday="
				+ mday + ", yday=" + yday + ", privacyagr=" + privacyAgr + ", offers=" + offers + "]";
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

	
}
