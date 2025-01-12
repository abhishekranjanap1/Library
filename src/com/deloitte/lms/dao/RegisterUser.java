package com.deloitte.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//Example of Try Catch 
public class RegisterUser {
	public static void main(String[] args) throws SQLException {
		Statement stmt=null;
		Connection con=null;
		try {
			// Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish Connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "Qjebqkcy@3659");

			// Create Statement

			String query = "INSERT INTO userdetails values(17, 'Rupesh P', 15, 'M', 'Librarian', 'password@Rupesh12')";
			stmt = con.createStatement();
			// ExecuteQuerry

			int result = stmt.executeUpdate(query);// It will Give the Number
			// stmt.executeQuery(query); //It Will give result set (Table)

			// Process Results
			if (result == 1) {
				System.out.println("User Added SucessFully Inserted");
			} else {
				System.out.println("User Registration Failer");
			}
		} catch (Exception e) {
			System.out.println();
		}
		finally {
		// Close Connerction   
		stmt.close();
		con.close();
		}
	}
}
