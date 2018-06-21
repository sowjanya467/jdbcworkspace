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

public class LoginService 
{
	static LoginPojo l = new LoginPojo();

	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet rst = null;
    static int count=3;
	public static void registration() throws SQLException
	{
		try 
		{
			con = connection();
			System.out.println("enter id");
			int id = Utility.readInteger();
			System.out.println("enter the user name");
			String userName = Utility.userInputString();
			l.setUserName(userName);
			System.out.println("enter the password");
			String password = Utility.userInputString();
			l.setPassword(password);
			boolean validated = Utility.valid(password);
			// System.out.println(validated);

			if (validated) 
			{
				String query = "insert into loginDetails " + "values(?,?,?)";
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, id);
				pstmt.setString(2, userName);
				pstmt.setString(3, password);
				pstmt.executeUpdate();
				System.out.println("login credentials are valid added to the database now you can use our services");
			} 
			System.out.println();

		} 
		finally 
		{
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

	public void checkLogin() throws SQLException 
	{
		try 
		{
			con = connection();
			String query1 = "select * from loginDetails";
			pstmt = con.prepareStatement(query1);
			rst = pstmt.executeQuery();
			System.out.println("enter the id");
			@SuppressWarnings("unused")
			int id = Utility.readInteger();
			System.out.println("enter the user name");
			String userName = Utility.userInputString();
			while (rst.next()) 
			{

				if (userName.equals(rst.getString(2)))
				{
					System.out.println("enter the password");
					String password = Utility.userInputString();
					if (password.equals(rst.getString(3))) 
					{
						System.out.println("login sucessful");

					} 
					else
					{
						System.out.println("wrong password");
					}
					break;
				} 
				
				
					System.out.println("you are not registered please register");
					registration();
				

			}
		}

		finally {
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
	public void forgotPassword() throws SQLException
	{
		
		try {
			con=connection();
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
				 String query="insert into loginDetails "+"values(?,?,?)";
                
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
				String password=forgotPasswordMethod();
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

	public String forgotPasswordMethod() 
	{
		System.out.println("enter the password you remember");
		String password=Utility.userInputString();
	    l.setPassword(password);
	    System.out.println("enter the new password");
	    String password1=Utility.userInputString();
	    l.setPassword(password1);
	    boolean validd=Utility.valid(password1);
	    if(validd)
	    {
	    System.out.println("re-enter the password");
	    String password2=Utility.userInputString();
	    l.setPassword(password2);
	    if(password1.equals(password2))
	    {
	    	System.out.println("password has been set");
	    	
	    }
	    else
	    {
	    	System.out.println("passwords mismatch re enter the password");
	    	forgotPasswordMethod();
	    }
	    }
		return password1;

	}

	public static Connection connection()
	{
		Connection con = null;
		try 
		{
			Driver driveRef = new Driver();

			DriverManager.registerDriver(driveRef);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logincredentials?useSSL=false", "root",
					"root");
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return con;

	}

}
