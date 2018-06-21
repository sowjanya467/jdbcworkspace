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

public class Practice {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		
		 
			Driver driveRef=new Driver();
			 try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/citizendetails?useSSL=false","root","root");
				String query ="create table citizens (name varchar(20),aadharNo int(40),city varchar(20))";
				pstmt=con.prepareStatement(query);
			    pstmt.executeUpdate();
			     
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
