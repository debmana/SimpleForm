package com.deborasroka.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.deborasroka.simpleform.model.dao.DatabaseConnection;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println("These are the number of processors available: " + Runtime.getRuntime().availableProcessors());
		Connection conn = DatabaseConnection.getconnection();
		//CustomerDAO customerDAO = new CustomerDAO();
		
		
		try {
			PreparedStatement stmt = (conn.prepareStatement("select * from users"));
			ResultSet result = stmt.executeQuery(); 
			while(result.next()) {
				String name = result.getString("fname");
				int id = result.getInt("id");
				System.out.println("Name: "+ name + " ID: "+ id);
				
				
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
