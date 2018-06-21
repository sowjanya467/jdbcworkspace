/**
 * 
 */
package com.bridgelabz.preparedstatement;

import java.sql.SQLException;

/*************************************************************************************************************
 *
 * purpose:
 *
 * @author sowjanya467
 * @version 1.0
 * @since -05-17
 *
 **************************************************************************************************/

public class PreparedstmtMain 
{

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException 
	{
		System.out.println("enter the choice you want to enter");
		int choice = PreparedStatementOperations.readInteger();
		switch (choice) 
		{
		case 1:
			System.out.println("create tabel");
			PreparedStatementOperations.createTabel();
			break;
		case 2:
			System.out.println("insert values");
			PreparedStatementOperations.insertData();
			break;
		case 3:
			System.out.println("multiple insert values");
			PreparedStatementOperations.insertMultiple();
			break;
		case 4:
			System.out.println("reading details from table");
			PreparedStatementOperations.readTable();
			break;
		case 5:
			System.out.println("updating details");
			PreparedStatementOperations.update();
			break;
		case 6:
			System.out.println("deleting");
			PreparedStatementOperations.delete();
			break;
		default:
			System.out.println("invalid choice");

		}

	}

}
