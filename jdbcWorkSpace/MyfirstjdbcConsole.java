/**
 * 
 */
package com.bridgelabz.jdbcWorkSpace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

public class MyfirstjdbcConsole {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws ClassNotFoundException
	{
		Connection con=null;
		Statement stmt=null;
		ResultSet rst=null;
		
		 try {
			//Driver driveRef=new Driver();
			// String dburl=
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL=false","root","root");
			 String query="select distinct * from studentDetails";
			 
			 stmt=con.createStatement();
		    rst= stmt.executeQuery(query);
		    while(rst.next())
		    {
		    	int id=rst.getInt("id");
		    	String fName=rst.getString("firstName");
		    	String lName=rst.getString("lastName");
		    	System.out.println("id="+id);
		    	System.out.println("firstname="+fName);
		    	System.out.println("lastname="+lName);
		    	System.out.println();
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
					 
					 if(stmt!=null)
					 {
						 stmt.close();
					 }
					 if(rst!=null)
					 {
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
