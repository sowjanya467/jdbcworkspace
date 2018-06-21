/**
 * 
 */
package com.bridgelabz.transactionManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

/*************************************************************************************************************
 *
 * purpose:
 *
 * @author sowjanya467
 * @version 1.0
 * @since -05-17
 *
 **************************************************************************************************/

public class TransactionExample {

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws ClassNotFoundException 
	{
		Connection con = null;
		PreparedStatement pst=null;

		String query = "insert into citizenDetails  " + "values (109208,'sasi','ga')";
		String query1 = "inserted into citizenDetails  " + "values (10782983,'Sita', 'Singh')";
		// String query2= "insert into citizenDetails " + "values
		// (1309208,'mamata','n')";

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			try 
			{
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/citizens?useSSL=false", "root", "root");

				con.setAutoCommit(false);
                pst=con.prepareStatement(query);
                Savepoint savepoint=con.setSavepoint("save");
                pst.executeUpdate();
                
				//stmt.executeUpdate(query);
                pst=con.prepareStatement(query1);
                int c=pst.executeUpdate();
                
				System.out.println(c);
				/*pst=con.prepareStatement(query2);
                int a=pst.executeUpdate();
				 System.out.println(a);*/
				con.commit();
			} 
			catch (SQLException se) 
			{
				//con.rollback();
				con.setSavepoint("savepoint");
				System.out.println("rollback");
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
