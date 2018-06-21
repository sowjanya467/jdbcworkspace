/**
 * 
 */
package com.bridgelabz.batchprocess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.preparedstatement.PreparedStatementOperations;

/*************************************************************************************************************
 *
 * purpose:
 *
 * @author sowjanya467
 * @version 1.0
 * @since -05-17
 *
 * **************************************************************************************************/

public class BatchPrepared {

	static Connection con=null;
	static PreparedStatement pst=null;
	static ResultSet rst=null;
	public static void main(String[] args) 
	{
		String insert = "insert into citizenDetails " + "values(?,?,?)";
		String update="update  citizenDetails set firstName='sowji' where lastName='m'" ;
		
		try 
		{
			con=PreparedStatementOperations.getConnection();

			pst = con.prepareStatement(insert);
	
			pst.setInt(1, 913282973);
			pst.setString(2,"priya");
			pst.setString(3, "g");
			
			pst.addBatch();
			pst.setString(1, "sow");
			pst.setString(2, "m");
			pst.addBatch(update);
			
			pst.executeBatch();
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

}
