/**
 * 
 */
package com.bridgelabz.jdbcWorkSpace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

/*************************************************************************************************************
 *
 * purpose:
 *
 * @author sowjanya467
 * @version 1.0
 * @since -05-17
 *
 * **************************************************************************************************/

public class MyFitstJdbcPrgm {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args)
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		
		 try {
			Driver driveRef=new Driver();
			// String dburl=
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL=false","root","root");
			 String query="create table studentDetails (id int(10),firstName varchar(20),"
			 		+ "lastName varchar(20))";
			 pstmt=con.prepareStatement(query);
		    pstmt.executeUpdate();
		    // System.out.println(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally
		 {
			 {
				 try
				 {
					 if(con!=null)
						 
					con.close();
					 if(pstmt!=null)
					 {
						 pstmt.close();
					 }
					 if(rst!=null)
					 {
						 rst.close();
					 }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		 }
		
		 
		   
			 
	}
}
