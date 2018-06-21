/**
 * 
 */
package com.bridgelabz.login;

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
 **************************************************************************************************/

public class LoginTable 
{

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;

		try 
		{
			Driver driveRef = new Driver();
			DriverManager.registerDriver(driveRef);

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logincredentials?useSSL=false", 
					"root","root");
			String query = "create table loginData (ID int NOT NULL AUTO_INCREMENT,userName varchar(20),"
					+ "" + "password varchar(20), PRIMARY KEY (ID))";
			pstmt = con.prepareStatement(query);
			int i = pstmt.executeUpdate();
			System.out.println("rows affected=" + i);
			// System.out.println(c);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally 
		{
				try 
				{
					if (con != null)

						con.close();
					if (pstmt != null)
					{
						pstmt.close();
					}
					if (rst != null)
					{
						rst.close();
					}
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		

	}
}
