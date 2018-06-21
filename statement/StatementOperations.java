/**
 * 
 */
package com.bridgelabz.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
 * **************************************************************************************************/

public class StatementOperations 
{
	static Connection con=null;
	static Statement statement=null;
	static ResultSet rst=null;
	static Scanner sc=new Scanner(System.in);
	public static String userInputString()
	{
		return sc.next();
	}
	
	public static int readInteger() 
	{
		int a=sc.nextInt();
		return a;
	}
	public static Connection gettconnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL=false","root","root");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}


	
   public static void insertData() 
   {
	   String query="insert into studentDetails values(6,'chaitra','a')";
		 try {
			   con=gettconnection();

			 statement=con.createStatement();
		     int c=statement.executeUpdate(query);
		     System.out.println(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally
		 {
			 
				 try
				 {
					 if(rst!=null)
						 
					rst.close();
					 if(statement!=null)
					 {
						 statement.close();
					 }
					 if(con!=null)
					 {
						 con.close();
					 }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
		 }
   }
   public static void update()
   {
		 String query=" update studentDetails set lastName='roy' where id=3";


		 try {
			 con=gettconnection();
			 //String query1="delete from  studentDetails where firstName='sowjanya'";
			 statement=con.createStatement();
		     int c=statement.executeUpdate(query);
		     System.out.println(c);     
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
					 if(statement!=null)
					 {
						 statement.close();
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
   public static void readTable() 
	{
		String query = "select distinct * from studentDetails";
		try 
		{
			con = gettconnection();

			statement=con.createStatement();
		     rst=statement.executeQuery(query);
			while (rst.next()) 
			{
				int id = rst.getInt(1);
				String fName = rst.getString("firstName");
				String lName = rst.getString("lastName");
				System.out.println("id=" + id);
				System.out.println("firstName=" + fName);
				System.out.println("lastName=" + lName);
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

			   if (statement != null) 
			   {
				   statement.close();
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

   public static void delete()
   {
		 String query="delete from  studentDetails where firstName='sowji'";


		 try {
			 con=gettconnection();
			 statement=con.createStatement();
		     int c=statement.executeUpdate(query);
		     System.out.println(c);     
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
					 if(statement!=null)
					 {
						 statement.close();
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
   public static void insertMultiple() throws SQLException
	{
	   try {
			con = gettconnection();
			boolean close = false;
			while (close == false) {
				String query = "insert into citizenDetails " + "values(?,?,?)";
				System.out.println("enter the aadhar number");
				String aNum = sc.next();
				System.out.println("enter first name");
				String fname = sc.next();
				System.out.println("enter the second name");
				String lName = sc.next();
				statement = con.createStatement();
	            
				/*statement.setString(1, aNum);
				statement.setString(2, fname);
				pst.setString(3, lName)*/;
				statement.executeUpdate(query);
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
					if (statement != null) {
						statement.close();
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
   public static void batch()
   {
	   String insert="insert into studentDetails values(5,'sowmya','p')";
	    String update="update studentDetails set id=9 where firstName='chaitra'";
	    String delete="delete from studentDetails where id=5";
	    try {
	    con=gettconnection();
	    statement=con.createStatement();
	   
	    statement.addBatch(insert);
	    statement.addBatch(update);
	    statement.addBatch(delete);

	    int[] array=statement.executeBatch();
	    for (int i:array) {
	        System.out.println(i);
	    }
	    }catch(SQLException e) {
	        e.printStackTrace();
	    }
	   
	    finally {
	        if(statement!=null) {
	            try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        if(con!=null) {
	            try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	    }
	   
	    }

/**
 * 
 */
public static void createTabel() {
	// TODO Auto-generated method stub
	
}

   
}
