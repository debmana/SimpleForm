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
		String[] bdate;
		String day="";
		String month="";
		String year="";
		
		
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
			
			if(qdate != null && qdate.toString() !="") {
				String date = qdate.toString();
			
			 bdate = date.split("-", 3);
			 year = bdate[0];
			 month = bdate[1];
			 day = bdate[2];
			 //System.out.println("This is the date insie the split: " + year + " " + month + " " + day);
		}
			
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
			user.setBday(day);
			user.setMday(month);
			user.setYday(year);;
			user.setZipcode(rs.getString("zipcode"));
			user.setPrivacyagr(rs.getBoolean("privacyAgr"));
			user.setOffers(rs.getBoolean("offersAgr"));
			user.setIsAdmin(rs.getBoolean("isAdmin"));
			user.setIsConfirmed(rs.getBoolean("isConfirmed"));
			user.setIsActive(rs.getBoolean("isActive"));
			//System.out.println("These are the results " + rs.getBoolean("isActive") + "These are the results " + rs.getBoolean("isAdmin"));
			
		}
		
		return user;
	}
	
	
	public User searchByEmail(String email) throws SQLException {
		User user = new User();
		ResultSet rs = null;
		String[] bdate;
		String day="";
		String month="";
		String year="";
		
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
			
			if(qdate != null && qdate.toString() !="") {
				String date = qdate.toString();
			
				bdate = date.split("-", 3);
				year = bdate[0];
				month = bdate[1];
				day = bdate[2];
				//System.out.println("This is the date insie the split: " + year + " " + month + " " + day);
			}
			
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
			user.setBday(day);
			user.setMday(month);
			user.setYday(year);
			user.setZipcode(rs.getString("zipcode"));
			user.setIsActive(rs.getBoolean("isActive"));
			//System.out.println("These are the results " + rs.getBoolean("isActive") + "These are the results " + rs.getBoolean("isAdmin"));
			user.setIsAdmin(rs.getBoolean("isAdmin"));
			user.setIsConfirmed(rs.getBoolean("isConfirmed"));
			user.setPrivacyagr(rs.getBoolean("privacyAgr"));
			user.setOffers(rs.getBoolean("offersAgr"));
		}

		return user;
	}
	
	public int update(User t) throws SQLException {
		int result=0;
		Connection conn = DatabaseConnection.getconnection();
		
		String monthString = t.getMday();
		String customerDate = (t.getYday()+"-"+monthString+"-"+t.getBday());
		java.sql.Date qdate = java.sql.Date.valueOf(customerDate);
		
		if (t.getID() >=0) {
			if (t.getPassword()==null || t.getPassword().isEmpty()) {
		

						String sql = "UPDATE users SET fname=? ,lname=? ,email=? ,phone=?, address=?, city=?, country=?, Website=?, gender=?, bdate=?, "
							+ "zipcode=?, isAdmin=?, isActive=? WHERE id = ?" ;
				
						PreparedStatement stmt = (conn.prepareStatement(sql));
						stmt.setString(1, t.getFirstName());
						stmt.setString(2, t.getLastName());
						stmt.setString(3, t.getEmail());
						stmt.setString(4, t.getPhone());
						stmt.setString(5, t.getAddress());
						stmt.setString(6, t.getCity());
						stmt.setString(7, t.getCountry());
						stmt.setString(8, t.getWebsite());
						stmt.setString(9, t.getGender());
						stmt.setDate(10, qdate);
						stmt.setString(11, t.getZipcode());
						stmt.setBoolean(12, t.getIsAdmin());
						stmt.setBoolean(13, t.getIsActive());
						stmt.setInt(14, t.getID());
						try {
							result = stmt.executeUpdate(); 
						} catch (SQLException e) {
							System.out.println("Exception during update statement: "+e);
							return result;
						}
						System.out.println("update statement result: " +result);
						return result;
			
	} else {
		
				String sql = "UPDATE users SET fname=? ,lname=? ,email=? ,password=?, phone=?, address=?, city=?, country=?, Website=?, gender=?, bdate=?, "
						+ "zipcode=?, isAdmin=?, isActive=? WHERE id = ?" ;
	
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
					stmt.setString(12, t.getZipcode());
					stmt.setBoolean(13, t.getIsAdmin());
					stmt.setBoolean(14, t.getIsActive());
					stmt.setInt(15,  t.getID());
					try {
						result = stmt.executeUpdate(); 
					} catch (SQLException e) {
						System.out.println("Exception during update statement: "+e);
						return result;
					}
					System.out.println("update statement result: " +result);
					return result;
			}
			
		} 
		
		return 0;
	}
	
}
