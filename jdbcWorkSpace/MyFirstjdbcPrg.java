/**
 * 
 */
package com.bridgelabz.jdbcWorkSpace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

/*************************************************************************************************************
 *
 * purpose:
 *
 * @author sowjanya467
 * @version 1.0
 * @since -05-17
 *
 * **************************************************************************************************/

public class MyFirstjdbcPrg {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args)
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		String query="insert into studentDetails values(4,'pratyusha','m')";
		 try {
			java.sql.Driver driveRef=new Driver();
			DriverManager.registerDriver(driveRef);

			// String dburl=
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL=true","root","root");
			 
			 pstmt=con.prepareStatement(query);
		     int c=pstmt.executeUpdate();
		     System.out.println(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally
		 {
			 
				 try
				 {
					 if(rst!=null)
						 
					rst.close();
					 if(pstmt!=null)
					 {
						 pstmt.close();
					 }
					 if(con!=null)
					 {
						 con.close();
					 }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
		 }
		
		 
		   
			 
	}
}
