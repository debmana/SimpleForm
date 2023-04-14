package com.deborasroka.simpleform.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.deborasroka.simpleform.model.Customer;
import com.deborasroka.simpleform.model.User;

public class UserDAO extends CustomerDAO{
	
	
	public User searchByID(int id) throws SQLException {
		User user = new User();
		ResultSet rs = null;
		
		
		try {
				Connection conn = DatabaseConnection.getconnection();
				String sql = "Select * from users where id = ?";
				PreparedStatement stmt = (conn.prepareStatement(sql));
				stmt.setInt(1, id);
				rs = stmt.executeQuery();
		} catch (SQLException e) {
			
				System.out.println(e); 
				return null;
		}
		
		if (rs.next()) {
			
			java.sql.Date qdate = rs.getDate("bdate");
			String bday = Integer.toString((qdate.getDay()));
			String bmonth = Integer.toString((qdate.getMonth()));
			String byear = Integer.toString((qdate.getYear()));
			
			user.setID(rs.getInt("ID"));
			user.setFirstName(rs.getString("fname"));
			user.setEmail(rs.getString("email"));
			//user.setPassword(rs.getString("password"));
			user.setLastName(rs.getString("lname"));
			user.setPhone(rs.getString("phone"));
			user.setAddress(rs.getString("address"));
			user.setCity(rs.getString("city"));
			user.setCountry(rs.getString("Country"));
			user.setWebsite(rs.getString("website"));
			user.setPassword(rs.getString("password"));
			user.setGender(rs.getString("gender"));
			user.setBday(bday);
			user.setMday(bmonth);
			user.setYday(byear);
			user.setZipcode(rs.getString("zipcode"));
			user.setPrivacyagr(rs.getBoolean("privacyAgr"));
			user.setOffers(rs.getBoolean("offersAgr"));
			user.setIsAdmin(rs.getBoolean("isAdmin"));
			user.setIsConfirmed(rs.getBoolean("isConfirmed"));
			user.setIsActive(rs.getBoolean("isActive"));
			
		}
		
		return user;
	}
	
	
	public User searchByEmail(String email) throws SQLException {
		User user = new User();
		ResultSet rs = null;
		
		try {
			Connection conn = DatabaseConnection.getconnection();
			String sql = "Select * from users where email = ?";
			PreparedStatement stmt = (conn.prepareStatement(sql));
			stmt.setString(1, email);
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			
			System.out.println(e); 
			return null;			
			
		}
		
		if (rs.next()) {
			
			java.sql.Date qdate = rs.getDate("bdate");
			String bday = Integer.toString((qdate.getDay()));
			String bmonth = Integer.toString((qdate.getMonth()));
			String byear = Integer.toString((qdate.getYear()));
			
			user.setID(rs.getInt("ID"));
			user.setFirstName(rs.getString("fname"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
		
			user.setLastName(rs.getString("lname"));
			user.setPhone(rs.getString("phone"));
			user.setAddress(rs.getString("address"));
			user.setCity(rs.getString("city"));
			user.setCountry(rs.getString("Country"));
			user.setWebsite(rs.getString("website"));
			user.setGender(rs.getString("gender"));
			user.setBday(bday);
			user.setMday(bmonth);
			user.setYday(byear);
			user.setZipcode(rs.getString("zipcode"));
			user.setIsActive(rs.getBoolean("isActive"));
			user.setIsAdmin(rs.getBoolean("isAdmin"));
			user.setIsConfirmed(rs.getBoolean("isConfirmed"));
			user.setPrivacyagr(rs.getBoolean("privacyAgr"));
			user.setOffers(rs.getBoolean("offersAgr"));
		}

		return user;
	}
	
	

}
