/**
 * 
 */
package com.bridgelabz.jdbcWorkSpace;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*************************************************************************************************************
 *
 * purpose:
 *
 * @author sowjanya467
 * @version 1.0
 * @since -05-17
 *
 * **************************************************************************************************/

public class MyJdbcStore {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
		Connection con=null;
		Statement st=null;
		ResultSet res=null;
		
		

			 try
			 {
                //Driver d=new Driver();
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/address?useSSL=false","root","root");
			
				PreparedStatement ps=con.prepareStatement("insert into  values(?,?)");  
				ps.setString(1,"sam");  
				  
				FileInputStream fin=new FileInputStream("home/Pictures/CMS_Creative_164657191_Kingfisher.jpg");  
				ps.setBinaryStream(2,fin,fin.available());  
				int i=ps.executeUpdate();  
				System.out.println(i+" records affected");  
				          
				con.close();  
			 } 
			 catch (SQLException e) 
			 {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	
	

}
