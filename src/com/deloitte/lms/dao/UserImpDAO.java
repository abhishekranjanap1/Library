package com.deloitte.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.deloitte.lms.model.User;

public class UserImpDAO {
public static void main(String[] args) throws SQLException {
	System.out.println("Before Update");
	System.out.println(getUser("5"));
//	System.out.println(deleteUser("8"));
	System.out.println(updateAge("5",15));
}
	public static User getUser(String userid) throws SQLException
	{
		Connection con=null;
		PreparedStatement pst=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Create Connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "Qjebqkcy@3659");
			
			String query = "SELECT UserId,UserName,Age,Gender,UserRole,password from userdetails where UserId=?";
			pst = con.prepareStatement(query);
			pst.setString(1, userid);
			ResultSet result = pst.executeQuery();
			result.next();
			
			String UserId=result.getNString("UserId");
			String UserName=result.getString("UserName");
			int Age=result.getInt("Age");
			String gender=result.getString("Gender");
			String UserRole = result.getString("UserRole");
			String password=result.getNString("password");
			User obj = new User(UserId,UserName,Age,gender.charAt(0),UserRole,password);
			return obj;
			
			
		}
		catch(Exception e)
		{
			System.out.println("Error");
			e.printStackTrace();
			return null;
		}
		finally {
			con.close();
			pst.close();
		}
		
	}
	public static boolean deleteUser(String userid) throws SQLException
	{
		Connection con=null;
		PreparedStatement pst=null;
		try {
			//register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create the Connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","Qjebqkcy@3659");
			
			//Execute the Querry
			String query ="delete from userdetails where UserId=?";
			//Now it is Dyynamic Query SO we Have to use Prepared Statement
			pst = con.prepareStatement(query); //In the Prepare Statment i have to pass the Query
			pst.setString(1, userid);
			int result = pst.executeUpdate();//When we Want Table so we use execute Query
			
			if(result==1)
			{
				return true;
			}
			else
			{
				return false;
			}
		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		finally {
			con.close();
			pst.close();
		}
		
	}
	
	public static User updateAge(String userid,int newAge) throws SQLException
	{
		Connection con=null;
		PreparedStatement pst=null;
		//Register The Driver
		try {
			//Register The Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","Qjebqkcy@3659");
			//Write the Querry First
			String query = "Update userdetails set age=? where UserId=?";
			//Create Statmenet
			pst = con.prepareStatement(query);
			//Now Setting The Age
			pst.setInt(1, newAge);
			pst.setString(2, userid);
			//ResultSet ir = pst.executeQuery()
			int result = pst.executeUpdate();
			if(result==1)
			{
				System.out.println("Age has Been updated");
			}
			else
			{
				System.out.println("User id Not Found");
			}
			
			String query2="SELECT UserId, UserName, Age, Gender, UserRole, password FROM userdetails WHERE UserId = ?";
			pst=con.prepareStatement(query2);
			pst.setString(1, userid);
			ResultSet st = pst.executeQuery();
			if(st.next())
			{
				String UserId=st.getNString("UserId");
				String UserName=st.getString("UserName");
				int Age=st.getInt("Age");
				String gender=st.getString("Gender");
				String UserRole = st.getString("UserRole");
				String password=st.getNString("password");
				
				return new User(UserId, UserName, Age, gender.charAt(0), UserRole, password);
			}
			else
			{
				return null;	
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			con.close();
			pst.close();
		}
		
		
	}
	

}

