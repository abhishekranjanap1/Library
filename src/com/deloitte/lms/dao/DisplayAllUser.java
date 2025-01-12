package com.deloitte.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.deloitte.lms.utilities.DBUtilities;

public class DisplayAllUser {
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		// Register Driver

		try {
			
		
			con=DBUtilities.getConnection();
			
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			// Establish Connection
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "Qjebqkcy@3659");
			// Create Statement
			stmt = con.createStatement();

			// Execute Query
			String query = "SELECT UserId,UserName,Age,Gender,UserRole,password from userdetails";
		//	String query2= "SELECT * from userdetails";
			// Process Result
			ResultSet rs = stmt.executeQuery(query);
		//	ResultSet rs2 = stmt.executeQuery(query2); For printing I have to give again rs2.getString(1, rs2.getString(2) and so on as data available in my table
			while (rs.next())  //It has Two Methods rs.getString(Column number) rs.getString("Column Name" (String) )
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
//				System.out.println();
//				System.out.println(rs.getInt(3));
//				System.out.println(rs.getString(4));
//				System.out.println(rs.getString(5));
//				System.out.println(rs.getString(6));

			}

		}

		catch (Exception e) {
			System.out.println("Error");
		}

		finally {
			// Close Connection
			con.close();
			stmt.close();
		}

	}
	
		
	
}
