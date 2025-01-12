package com.deloitte.lms.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleTonClass {
private static SingleTonClass instance;
private Connection con;
	private SingleTonClass() throws ClassNotFoundException, SQLException {
		//Private Constructor
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(DBConstants.DBlocation, DBConstants.DBuname, DBConstants.DBpswd);
	}
	//Now i want singleton means it has only single instance of Class A
	public static SingleTonClass getObjA() throws ClassNotFoundException, SQLException
	{
		if(instance==null)
		{
			return new SingleTonClass();
		}
		else {
			return instance;
		}
	}
	
	public Connection getConnection()
	{
		return con;
		
	}
	
	
	
	
	//Single ton properties private static class a obj
	//Private Constructor
}
