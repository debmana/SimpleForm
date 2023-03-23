package com.deborasroka.simpleform.model.dao;
//import com.deborasroka.simpleform.model.dao.DatabaseConnection;
import com.deborasroka.simpleform.model.*;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.time.LocalDate;
//import java.text.*;

public class CustomerDAO implements DAO<Customer> {
	private int result;

	@Override
	public Customer searchByID(int id) throws SQLException {
		Customer customer = new Customer();
		Connection conn = DatabaseConnection.getconnection();
		String sql = "Select * from users where id = ?";
		PreparedStatement stmt = (conn.prepareStatement(sql));
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		
		if (rs.next()) {
			
			java.sql.Date qdate = rs.getDate("bdate");
			String bday = Integer.toString((qdate.getDay()));
			String bmonth = Integer.toString((qdate.getMonth()));
			String byear = Integer.toString((qdate.getYear()));
			
			customer.setID(rs.getInt("ID"));
			customer.setFirstName(rs.getString("fname"));
			customer.setEmail(rs.getString("email"));
			customer.setPassword(rs.getString("password"));
			customer.setLastName(rs.getString("lname"));
			customer.setPhone(rs.getString("phone"));
			customer.setAddress(rs.getString("address"));
			customer.setCity(rs.getString("city"));
			customer.setCountry(rs.getString("Country"));
			customer.setWebsite(rs.getString("website"));
			customer.setPassword(rs.getString("password"));
			customer.setGender(rs.getString("gender"));
			customer.setBday(bday);
			customer.setMday(bmonth);
			customer.setYday(byear);
			customer.setZipcode(rs.getString("zipcode"));
		}
		
		return customer;
	}

	@Override
	public Customer searchByEmail(String email) throws SQLException {
		Customer customer = new Customer();
		Connection conn = DatabaseConnection.getconnection();
		String sql = "Select * from users where email = ?";
		PreparedStatement stmt = (conn.prepareStatement(sql));
		stmt.setString(1, email);
		ResultSet rs = stmt.executeQuery();
		
		if (rs.next()) {
			
			java.sql.Date qdate = rs.getDate("bdate");
			String bday = Integer.toString((qdate.getDay()));
			String bmonth = Integer.toString((qdate.getMonth()));
			String byear = Integer.toString((qdate.getYear()));
			
			customer.setID(rs.getInt("ID"));
			customer.setFirstName(rs.getString("fname"));
			customer.setEmail(rs.getString("email"));
			customer.setPassword(rs.getString("password"));
			customer.setLastName(rs.getString("lname"));
			customer.setPhone(rs.getString("phone"));
			customer.setAddress(rs.getString("address"));
			customer.setCity(rs.getString("city"));
			customer.setCountry(rs.getString("Country"));
			customer.setWebsite(rs.getString("website"));
			customer.setPassword(rs.getString("password"));
			customer.setGender(rs.getString("gender"));
			customer.setBday(bday);
			customer.setMday(bmonth);
			customer.setYday(byear);
			customer.setZipcode(rs.getString("zipcode"));
		}

		return customer;
	}

	@Override
	public void insert(Customer t) throws SQLException {
		Connection conn = DatabaseConnection.getconnection();
		String monthString = t.getMday();
		String customerDate = (t.getYday()+"-"+monthString+"-"+t.getBday());
		java.sql.Date qdate = java.sql.Date.valueOf(customerDate);
		String sql = "INSERT INTO users  (fname,lname,email,password,phone,address,city,country,Website,gender,bdate,privacyAgr,offersAgr, zipcode) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = (conn.prepareStatement(sql));
		stmt.setString(1, t.getFirstName());
		stmt.setString(2, t.getLastName());
		stmt.setString(3, t.getEmail());
		stmt.setString(4, t.getPassword());
		stmt.setString(5, t.getPhone());
		stmt.setString(6, t.getAddress());
		stmt.setString(7, t.getCity());
		stmt.setString(8, t.getCountry());
		stmt.setString(9, t.getWebsite());
		stmt.setString(10, t.getGender());
		stmt.setDate(11, qdate);
		stmt.setBoolean(12, t.isPrivacyagr());
		stmt.setBoolean(13, t.isOffers());
		stmt.setString(14,t.getZipcode());
			
		result = stmt.executeUpdate(); 
		System.out.println("insert statement result: " +result);

	}

	@Override
	public void update(Customer t) throws SQLException {
		Connection conn = DatabaseConnection.getconnection();
		String monthString = t.getMday();
		String customerDate = (t.getYday()+"-"+monthString+"-"+t.getBday());
		java.sql.Date qdate = java.sql.Date.valueOf(customerDate);
		String sql = "UPDATE users SET fname=? ,lname=? ,email=? ,password=?, phone=?, address=?, city=?, country=?, Website=?, gender=?, bdate=?, "
				+ "privacyAgr=?, offersAgr=?, zipcode=? WHERE id = ?" ;
				
		PreparedStatement stmt = (conn.prepareStatement(sql));
		stmt.setString(1, t.getFirstName());
		stmt.setString(2, t.getLastName());
		stmt.setString(3, t.getEmail());
		stmt.setString(4, t.getPassword());
		stmt.setString(5, t.getPhone());
		stmt.setString(6, t.getAddress());
		stmt.setString(7, t.getCity());
		stmt.setString(8, t.getCountry());
		stmt.setString(9, t.getWebsite());
		stmt.setString(10, t.getGender());
		stmt.setDate(11, qdate);
		stmt.setBoolean(12, t.isPrivacyagr());
		stmt.setBoolean(13, t.isOffers());
		stmt.setInt(14,  t.getID());
		stmt.setString(15, t.getZipcode());
			
		result = stmt.executeUpdate(); 
		System.out.println("update statement result: " +result);

		
	}

	@Override
	public void delete(Customer t) throws SQLException {
		Connection conn = DatabaseConnection.getconnection();
		String sql = "DELETE FROM users WHERE id = ?" ;
				
		PreparedStatement stmt = (conn.prepareStatement(sql));
		stmt.setInt(1, t.getID());
		
		result = stmt.executeUpdate();

	}

}
