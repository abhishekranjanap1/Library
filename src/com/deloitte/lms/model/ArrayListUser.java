package com.deloitte.lms.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListUser {
	public static void main(String[] args) throws SQLException {

		ArrayList<User> alist = new ArrayList<User>();
		// register the Driver
		try {
			Connection con=null;
			Statement stmt=null;
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Create Connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "Qjebqkcy@3659");
			// Create Statement
			stmt = con.createStatement();
			// Excecute the Querry
			String querry = "SELECT UserId,UserName,Age,Gender,UserRole,password from userdetails";
			// Process the result
			ResultSet rs = stmt.executeQuery(querry);
			while (rs.next()) {
				User details = new User(rs.getString("UserId"), rs.getString("UserName"), rs.getInt("Age"),
						rs.getString("Gender").charAt(0), rs.getString("UserRole"), rs.getString("password"));
				alist.add(details);
			}
			Iterator<User> it = alist.iterator();
			while(it.hasNext())
			{
				Object j=it.next();
				User u = (User)j;
				System.out.println("************************");
				System.out.println("Name |"+u.getUserName()+" User ID |"+u.getUserId());
		
			}
//			con.close();
//			stmt.close();
			alist.forEach((t)->System.out.println(" "+t.getUserName()+t.getUserId()+t.getAge()+t.getPassword()));
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		finally {
			//Close the Connection
			
			
		}
	}
}
