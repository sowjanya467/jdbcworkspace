/**
 * 
 */
package com.bridgelabz.jdbcWorkSpace;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
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

public class MyjdbcDynamic {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		
		 try {
			java.sql.Driver driveRef=new Driver();
			DriverManager.registerDriver(driveRef);
			// String dburl=
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL=false","root","root");
			boolean close=false;
			 while(close==false)
			 {
			 String query="insert into studentDetails "+"values(?,?,?)";
			 System.out.println("enter the id");
			 int id=sc.nextInt();
			 System.out.println("enter first name");
			 String fname=sc.next();
			 System.out.println("enter the second name");
			 String lName=sc.next();
			 pstmt=con.prepareStatement(query);
			 pstmt.setInt(1, id);
			 pstmt.setString(2, fname);
			 pstmt.setString(3, lName);
		     pstmt.executeUpdate();
		     System.out.println("enter yout choice1.to continue or any other key to break");
		     int ch=sc.nextInt();
		     switch(ch)
		     {
		     case 1: close=false;
		     break;
		     case 2: close=true;
		     break;
		     default: close=true;
		     }
			 }
			 
		     
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
						 sc.close();
					 }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		 }
		
		 
		   
			 
	}
}
