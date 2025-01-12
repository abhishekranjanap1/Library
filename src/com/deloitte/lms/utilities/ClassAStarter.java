package com.deloitte.lms.utilities;

import java.sql.Connection;
import java.sql.SQLException;

public class ClassAStarter {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//ClassA obj = new ClassA(); //We Cannot create ClassA because the Constructor is Private
		
		SingleTonClass objA =SingleTonClass.getObjA(); //It will Create the Class Because this method is Public and Static and Static method
		//can Access with the ClassNAme here i just assign that method to ClassA obj
	//	Connection con=objA.getConnection();
		Connection con2=SingleTonClass.getObjA().getConnection();
		
		
		
		//Avoid con.close() because it will  create again and again so dont have  to close so the singleton instance means same
	}
	
}
