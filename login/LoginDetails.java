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

public class LoginDetails 
{
	String userName;
	String password;
	static LoginService l=new LoginService();

	public static void main(String[] args) throws SQLException 
	{
		int count=3;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;

		try 
		{
			Driver driveRef = new Driver();

			DriverManager.registerDriver(driveRef);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logincredentials?useSSL=false", "root",
					"root");
			
			String query1 = "select * from loginDetails";
			pstmt = con.prepareStatement(query1);
			rst = pstmt.executeQuery();
			System.out.println("enter the id");
			int id = Utility.readInteger();
			System.out.println("enter the user name");
			String userName = Utility.userInputString();
			while(rst.next())
			{
			
			if (userName.equals(rst.getString(2)) )
			{
				 String query=" update loginDetails set userName='userName' where id=3";

				for(int i=0;i<count;i++)
				{
				
				System.out.println("enter the password");
				String password = Utility.userInputString();
					
				if (password.equals(rst.getString(3))) 
				{
					System.out.println("login sucessful");
					 
				}
				else 
				{
					int c=count-1-i;
					System.out.println("wrong password you have only "+c+ "chances");
				}
				
			} 
				pstmt=con.prepareStatement(query);
				String password=l.forgotPasswordMethod();
				pstmt.setInt(1,id);
				pstmt.setString(2, userName);
				pstmt.setString(3, password);
				pstmt.executeUpdate();			
				
		} 
			
		}
		}
		finally 
		{
			{
				try {
					if (con != null)

						con.close();
					if (pstmt != null) {
						pstmt.close();
					}
					if (rst != null) {
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
