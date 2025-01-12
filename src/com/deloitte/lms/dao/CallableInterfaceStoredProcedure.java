package com.deloitte.lms.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.deloitte.lms.utilities.DBUtilities;
import com.deloitte.lms.utilities.SingleTonClass;

public class CallableInterfaceStoredProcedure {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		getPasswordUser("4");
	}
	//Prepared Statement helps to call the stored Procedures Method of Mysql database First we have to create the Stored Procedure in
	//Sql workBench and then Write a query to call the Store Procedure "call MethodName()"
	
	//Prepared Statement helps to Call the Store Procedures
	
	
	//Utilities Class means the Classes which we are using Regular Basis and 
	//DAO =data access Object
	//Constants we make an interface
	
	
	
	public static void getPasswordUser(String UserId) throws SQLException, ClassNotFoundException
	{
		Connection con=null;
		CallableStatement cst=null;
		ResultSet rs=null;
		PreparedStatement pst=null;
		try {
		//	con = DBUtilities.getConnection(); // Step 1->>>>>>>>>>>>>>>>Register the Driver 
			
			con=SingleTonClass.getObjA().getConnection();
			//Step 2->>>>>>>>> Creating The Connection
			
			//Step 3->>>>>>>>>>Create Statement or Preparing The Statement
			
			String query="call getPassword(?)"; //Make a query in String
			cst=con.prepareCall(query); //Here I am calling with Callable
			//Setting The Value To Question Mark because it is Dynamic Query So we have to set the Values By Using setString or setInt()
			cst.setString(1, UserId);
		   //pst = con.prepareCall(query); //Here I am Calling with Prepared Statement Same as line 39
			
			
			
			
			//Step-4>>>>>>>>>>>>>>>Execute The Statement
			rs = cst.executeQuery();
			
			
			//Step-5>>>>>>>>>>>>>>Process the Result
			while(rs.next())
			{
				System.out.println(rs.getString(1)); //For Showing In Console
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			
			//Step-6>>>>>>>>>> Close the Connection
			rs.close();
			cst.close();
			//con.close();
		}
	}
}
