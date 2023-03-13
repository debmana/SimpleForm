package com.deborasroka.simpleform.model.dao;
import com.deborasroka.simpleform.model.dao.DatabaseConnection;
import com.deborasroka.simpleform.model.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.text.*;

public class CustomerDAO implements DAO<Customer> {
	private int result;

	@Override
	public Customer searchByID(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer searchByEmail(String email) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Customer t) throws SQLException {
		Connection conn = DatabaseConnection.getconnection();
		String monthString = t.getMday();
//		switch (monthString) {
//        case "January":  monthString = "01";      break;
//        case "February":  monthString = "02";     break;
//        case "March":  monthString = "03";        break;
//        case "April":  monthString = "04";        break;
//        case "May":  monthString = "05";          break;
//        case "June":  monthString = "06";         break;
//        case "July":  monthString = "07";         break;
//        case "August":  monthString = "08";       break;
//        case "September":  monthString = "09";    break;
//        case "October": monthString = "10";       break;
//        case "November": monthString = "11";      break;
//        case "December": monthString = "12";      break;
        //default: monthString = "Invalid month"; break;
    //}
		String customerDate = (t.getYday()+"-"+monthString+"-"+t.getBday());
		//this works down here
        //java.util.Date javaDate = new java.util.Date();
        //java.sql.Date mySQLDate = new java.sql.Date(javaDate.getTime());
		//LocalDate dt = LocalDate.parse(customerDate);
		java.sql.Date qdate = java.sql.Date.valueOf(customerDate);
		
		/// need to convert month written to number
		
		
		String sql = "INSERT INTO users  (fname,lname,email,password,phone,address,city,country,Website,gender,bdate,privacyAgr,offersAgr) "
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
			
		result = stmt.executeUpdate(); 
		System.out.println("insert statement result: " +result);
	}

	@Override
	public void update(Customer t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Customer t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
