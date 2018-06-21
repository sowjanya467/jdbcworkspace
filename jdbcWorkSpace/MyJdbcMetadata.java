/**
 * 
 */
package com.bridgelabz.jdbcWorkSpace;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

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

public class MyJdbcMetadata {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args)
	{
		Connection con=null;
		//PreparedStatement pstmt=null;
		//ResultSet rst=null;
		
		 try {
			Driver driveRef=new Driver();
			// String dburl=0
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL=false","root","root");
			 DatabaseMetaData dbmd=con.getMetaData();
			 System.out.println("Driver version:" +dbmd.getDatabaseMajorVersion());
			 System.out.println("Product Name:"+dbmd.getDatabaseProductName());
			 System.out.println("Driver name:"+dbmd.getDriverName());
			 System.out.println("user name:"+dbmd.getUserName());
			 System.out.println("Driver version"+dbmd.getCatalogSeparator());
			 System.out.println("sql keywords"+dbmd.getSQLKeywords());
			 System.out.println("Driver version :"+dbmd.getDatabaseProductVersion());
			 String table[]={"TABLE"};  
			 ResultSet rs=dbmd.getTables(null,null,null,table);  
			   
			 while(rs.next()){  
			 System.out.println(rs.getString(3));  
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
					 
				} 
				 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		 }
		
	}
}
