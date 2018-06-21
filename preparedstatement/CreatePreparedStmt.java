/**
 * 
 */
package com.bridgelabz.preparedstatement;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*************************************************************************************************************
 *
 * purpose:
 *
 * @author sowjanya467
 * @version 1.0
 * @since -05-17
 *
 * **************************************************************************************************/

public class CreatePreparedStmt {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException 
	{
		Connection con=null;
		PreparedStatement pst=null;
		String query="create table citizenDetails (aadharNo int(20),firstName varchar(20),"
				+ "lastName varchar(20))";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/citizens?useSSL=false","root","root");
			    pst=con.prepareStatement(query);
			    pst.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(pst!=null)
			{
				pst.close();
			}
			if(con!=null)
			{
				con.close();
			}
		}
		
	}

}
