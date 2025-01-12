package com.deloitte.lms.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtilities {

	public static Connection getConnection() throws SQLException
	{
		Connection con =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DBConstants.DBlocation, DBConstants.DBuname, DBConstants.DBpswd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
		
	}
}
