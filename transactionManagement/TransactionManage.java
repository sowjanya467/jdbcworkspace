/**
 * 
 */
package com.bridgelabz.transactionManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*************************************************************************************************************
 *
 * purpose:
 *
 * @author sowjanya467
 * @version 1.0
 * @since -05-17
 *
 **************************************************************************************************/

public class TransactionManage 
{
	static Connection con = null;
	static PreparedStatement pst = null;
	static ResultSet rst = null;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException 
	{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		String insert = "insert into citizenDetails " + "values(?,?,?)";
		try 
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
			} 
			catch (ClassNotFoundException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try 
			{
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/citizens?useSSL=false", "root", "root");
				pst = con.prepareStatement(insert);
				con.setAutoCommit(false);
				boolean close = false;
				while (close == false) 
				{
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
					System.out.println("commit/rollback");
					String answer = buffer.readLine();
					if (answer.equals("commit")) 
					{
						con.commit();
					}
					if (answer.equals("rollback"))
					{
						con.rollback();
					}
					System.out.println("enter yout choice1.to continue or any other key to break");
					int ch = sc.nextInt();
					switch (ch) 
					{
					case 1:
						close = false;
						break;
					default:
						close = true;
						break;
					}
				}
				con.commit();
				System.out.println("details entered sucessfully");
			}

			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} finally 
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
					if (con != null) 
					{
						con.close();
						sc.close();
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

}
