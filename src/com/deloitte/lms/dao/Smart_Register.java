package com.deloitte.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Smart_Register {
	public static void main(String[] args) throws SQLException {
		Add("abhi1khs", "abhishekranjanap", 55, 'M', "Subscriber", "Abhishek#123");
	}

	public static void Add(String userId, String Username, int age, char gender, String UserRole, String password)
			throws SQLException {
		PreparedStatement pstmt1 = null;
		Connection con = null;
		try {
			// Step 1->>>>     Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 2->>>>    Establish Connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "Qjebqkcy@3659");
			//Step 3->>>>>	  Create Statement (Statement Has to be Prepared because we Want to Add The Data Dynamically
			   // con.preparedStatement()
			
			
			
			// I dont want to hard code the query i want that it prints dynamically
			// Preparing the Statement for dynamic instead of Creating Statement
			// Prepare statement when query is dynamic and Create Statment when Query is
			// When Statment is Static so We Can Use con.createStatement()
			
			String query = "INSERT INTO userdetails values(?, ?, ?, ?, ?, ?)";
			pstmt1 = con.prepareStatement(query);
			//Here We are Setting the values to Database by our Variables using setString
			pstmt1.setString(1, userId);
			pstmt1.setString(2, Username);
			pstmt1.setInt(3, age);
			pstmt1.setString(4, String.valueOf(gender));
			pstmt1.setString(5, UserRole);
			pstmt1.setString(6, password);
			
			
			//we have to  think which i have to Execute the Query if we want to add the data and return integer so 
			//We can Use pstmt.executeUpdate(); to know data added or not if we want to get the data so use executeQUery
			// Execute Querry 
			int result = pstmt1.executeUpdate();
			// Process The Result
			if (result == 1) {
				System.out.println("AddedSucessfully");
			} else {
				System.out.println("Not Added");
			}

			
			
		} catch (Exception e) {
			System.out.println();
		} finally {
			// Close Connerction
			pstmt1.close();
			con.close();
		}

	}
}
