package com.deborasroka.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.deborasroka.simpleform.model.CONST;
import com.deborasroka.simpleform.model.Customer;
import com.deborasroka.simpleform.model.Password;
import com.deborasroka.simpleform.model.dao.CustomerDAO;
import com.deborasroka.simpleform.model.dao.DatabaseConnection;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		
		
//		Customer customer = new Customer();
//		
//		CustomerDAO customerDAO = new CustomerDAO();
//		
//		boolean test = customerDAO.searchByEmailBool(null);
//		
//		System.out.println("this is the result in main " + test);

		
		/*System.out.println("AAAAAAAAAAAAAAAAHHHHHHHHHHHHHHH " + CONST.DB_PASS);
		System.out.println("AAAAAAAAAAAAAAAAHHHHHHHHHHHHHHH " + CONST.DB_USER);
		System.out.println("AAAAAAAAAAAAAAAAHHHHHHHHHHHHHHH " + CONST.CAPKEY);
		System.out.println("AAAAAAAAAAAAAAAAHHHHHHHHHHHHHHH " + CONST.CAPSEC); */
		
		
		String test = "a";
		String test1 = "      ";
		String test4 = "";
		String test3= null;
		
		System.out.println("Hello this is the test with character a:  isblank " + test.isBlank() + " isEmpty " + test.isEmpty());
		
		System.out.println("Hello this is the test with character \"    \": isblank  " + test1.isBlank() + " isEmpty " + test1.isEmpty());
		System.out.println("Hello this is the test with character \"\": isblank " + test4.isBlank() + " isEmpty " + test4.isEmpty());
		
		System.out.println("Hello this is the test with character null:  isblank " + test3.isBlank() + " isEmpty  " + test3.isEmpty());
		
		// TODO Auto-generated method stub
		
//		//System.out.println("These are the number of processors available: " + Runtime.getRuntime().availableProcessors());
//		Connection conn = DatabaseConnection.getconnection();
//		//CustomerDAO customerDAO = new CustomerDAO();
//
//
//		try {
//			PreparedStatement stmt = (conn.prepareStatement("select * from users"));
//			ResultSet result = stmt.executeQuery(); 
//			while(result.next()) {
//				String name = result.getString("fname");
//				int id = result.getInt("id");
//				System.out.println("Name: "+ name + " ID: "+ id);
//			}
//
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//		List<Customer> customers = new ArrayList<Customer>();
//
//		customers.add(new Customer(1, "Maria Maria Benedita da Silva", "AngelShiny", "test##@google.com", "quat", "(801p7093881",
//				"rua Bonita bem feita dadadada","841111234", "SLC", "Brazil", "bombombombombombombombombom.com", "M", "01", "01", "2011", true, false));
//
//
//		customers.add(new Customer(2, "Jose", "Smith", "eggbombom@google.com", "Ysdfsdf_-!", "(801)7093881",
//				"rua Bonita","84111", "SLC", "Brazil", "bombom.com", "M", "01", "01", "2011", true, false));
//
//
//		customers.add(new Customer(3, "Jose", "Smith", "test@google.com", "Clayton", "(801)7093881",
//				"rua Bonita","84111", "SLC", "Brazil", "bombom.com", "M", "01", "01", "2011", true, true));
//
//
//		HashMap<String, String> map = new HashMap<>();
//
//		for (int i=0; i<customers.size(); i++) {
//
//			map = customers.get(i).validateInput(customers.get(i));
//
//			for (String key : map.keySet()) {
//				System.out.println(key + ": " + map.get(key));
//				if (key.contains("email")) {System.out.println("======>> " +customers.get(i).getEmail());}
//				if (key.contains("phone")) {System.out.println("======>> " +customers.get(i).getPhone());}
//				if (key.contains("zipcode")) {System.out.println("======>> " +customers.get(i).getZipcode());}
//				if (key.contains("password")) {System.out.println("======>> " +customers.get(i).getPassword());}
//				if (key.contains("firstName")) {System.out.println("======>> " +customers.get(i).getFirstName());}
//				if (key.contains("lastName")) {System.out.println("======>> " +customers.get(i).getLastName());}
//				if (key.contains("address")) {System.out.println("======>> " +customers.get(i).getAddress());}
//			}
//		}
//
//
//
//		String rawpass = "pumba034950839458039458)(*)(*()*";
//
//		String encrypted = Password.encrypt(rawpass);
//		System.out.println("THis is the encrypted password "+ encrypted + " Original "+rawpass);


		

}
	
}
