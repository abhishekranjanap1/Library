package com.deloitte.lms.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.deloitte.lms.utilities.DBUtilities;
import com.deloitte.lms.utilities.SingleTonClass;

public class Starter {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
			Connection con=null;
			CallableStatement cst= null; //callable Interface without Argument
			ResultSet rs=null;
			try {
				con=SingleTonClass.getObjA().getConnection();
				String query = "call displayUser()";
				
				cst=con.prepareCall(query);
				rs = cst.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getNString(1));
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			finally {
				rs.close();
				cst.close();
				//con.close();
			}
	}
}
