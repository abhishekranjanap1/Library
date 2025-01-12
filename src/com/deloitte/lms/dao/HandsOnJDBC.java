package com.deloitte.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.deloitte.lms.utilities.DBUtilities;

public class HandsOnJDBC {

	public static void main(String[] args) throws SQLException {
		System.out.println(getPassword("3"));
	}

	public static String getPassword(String userid) throws SQLException {
		PreparedStatement pstmt = null;
		Connection con = null;
		String s = null;
		try {
			con=DBUtilities.getConnection();	// Step 1->>>> Register Driver // Step 2->>>> Establish Connection
		
//			Class.forName("com.mysql.cj.jdbc.Driver");

			
			//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "Qjebqkcy@3659");
			// Step 3->>>>> Create Statement (Statement Has to be Prepared because we Want
			// to Add The Data Dynamically
			// con.preparedStatement()

			String query = "select password from userdetails where UserId=?";

			pstmt = con.prepareStatement(query);
			System.out.println(userid);

			// Here We are Setting the values to Database by our Variables using setString
			pstmt.setString(1, userid);
			ResultSet result = pstmt.executeQuery();

			while (result.next()) {
				s = result.getString("password");
			}

			return s;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			// Close Connerction
			pstmt.close();
			con.close();
		}

	}
	
	
	
}

