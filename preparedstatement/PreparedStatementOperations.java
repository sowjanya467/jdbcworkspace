/**
 * 
 */
package com.bridgelabz.preparedstatement;

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
 **************************************************************************************************/

public class PreparedStatementOperations 
{
	static Connection con = null;
	static PreparedStatement pst = null;
	static ResultSet rst = null;
	static Scanner sc = new Scanner(System.in);

	public static String userInputString() 
	{
		return sc.next();
	}

	public static int readInteger() 
	{
		int a = sc.nextInt();
		return a;
	}

	public static Connection getConnection()
	{
		try 
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
			} 
			catch (ClassNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/citizens?useSSL=false", "root", "root");
	
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;

	}

	// creating tabel
	public static void createTabel() throws SQLException 
	{
		String query = "create table citizens (aadharNo int(20),firstName varchar(20)," + "lastName varchar(20))";

		con = getConnection();
		pst = con.prepareStatement(query);
		pst.executeUpdate();
		if (pst != null) 
		{
			pst.close();
		}
		if (con != null)
		{
			con.close();
		}
	}

	public static void insertData()
	{
		
		String query = "insert into citizenDetails " + "values(?,?,?)";
		try 
		{
			con = getConnection();

			pst = con.prepareStatement(query);
	
			pst.setInt(1, 918973);
			pst.setString(2,"medini");
			pst.setString(3, "n");
			
			pst.executeUpdate();
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally 
		{
			if (pst != null)
			{
				try 
				{
					pst.close();
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) 
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void readTable() 
	{
		String query = "select distinct * from citizenDetails";
		try 
		{
			con = getConnection();

			pst = con.prepareStatement(query);
			rst = pst.executeQuery();
			while (rst.next()) 
			{
				String aNum = rst.getString("aadharNo");
				String fName = rst.getString("firstName");
				String lName = rst.getString("lastName");
				System.out.println("aadharNo=" + aNum);
				System.out.println("firstname=" + fName);
				System.out.println("lastname=" + lName);
				System.out.println();
			}

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
			   if (rst != null)
			   {
				  rst.close();
			   }

			   if (pst != null) 
			   {
					pst.close();
			   }
				if (con != null)
				{
				   con.close();
				}
				}
		       catch (SQLException e) 
		       {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}

	public static void update()
	{
		String query = " update citizenDetails set firstName=? where lastName=?";

		try 
		{
			con=getConnection();
			pst = con.prepareStatement(query);

			pst.setString(1, "jaya");
			pst.setString(2, "roy");
			con = getConnection();
			// String query1="delete from studentDetails where firstName='sowjanya'";
			int c = pst.executeUpdate();
			System.out.println(c);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally 
		{
			{
				try 
				{
					if (rst != null) 
					{

						rst.close();
					}
					if (pst != null) 
					{
						pst.close();
					}
					if (con != null) {
						con.close();
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

	public static void delete() 
	{
		String query = "delete from  citizenDetails where firstName='sasi'";

		try 
		{
			con = getConnection();
			pst = con.prepareStatement(query);
			int c = pst.executeUpdate();
			System.out.println(c);
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally 
		{
				try 
				{
					if (rst != null)

						rst.close();
					if (pst != null) 
					{
						pst.close();
					}
					if (con != null) 
					{
						con.close();
					}
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public static void insertMultiple() throws SQLException {
		try {
			con = getConnection();
			boolean close = false;
			while (close == false) {
				String query = "insert into citizenDetails " + "values(?,?,?)";
				System.out.println("enter the aadhar number");
				String aNum = sc.next();
				System.out.println("enter first name");
				String fname = sc.next();
				System.out.println("enter the second name");
				String lName = sc.next();
				pst = con.prepareStatement(query);
				pst.setString(1, aNum);
				pst.setString(2, fname);
				pst.setString(3, lName);
				pst.executeUpdate();
				System.out.println("enter yout choice1.to continue or any other key to break");
				int ch = sc.nextInt();
				switch (ch) {
				case 1:
					close = false;
					break;
				default:
					close = true;
					break;
				}
			}
		} finally {
			{
				try {
					if (rst != null)

						rst.close();
					if (pst != null) {
						pst.close();
					}
					if (con != null) {
						con.close();
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
