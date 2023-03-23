package com.deborasroka.simpleform.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static Connection conn;
	private DatabaseConnection() {
		
	}

	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/simple_form", "root", "password");
			System.out.println("Connected, success");
			
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println("oops: "+ e.getMessage());
			
		}
	}
	
	public static Connection getconnection() throws SQLException {
		return conn;
		
	}

}
