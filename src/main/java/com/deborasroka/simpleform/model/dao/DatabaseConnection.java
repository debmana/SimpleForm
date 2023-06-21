package com.deborasroka.simpleform.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.deborasroka.simpleform.model.CONST;

public class DatabaseConnection {
	
	private static Connection conn;
	private DatabaseConnection() {
		
	}

	
	public static Connection getconnection() throws SQLException {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/simple_form", CONST.DB_USER, CONST.DB_PASS);
			System.out.println("Connected, success");
			
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println("oops: "+ e.getMessage());
			
		}
		return conn;
		
	}

}
