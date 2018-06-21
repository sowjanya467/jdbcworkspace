/**
 * 
 */
package com.bridgelabz.statement;

import java.sql.SQLException;

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

public class CreateStatementMain 
{
	public static void main(String[] args) throws SQLException 
	{

		System.out.println("enter the choice you want to enter");
		int choice = PreparedStatementOperations.readInteger();
		switch (choice) 
		{
		case 1:
			System.out.println("create tabel");
			StatementOperations.createTabel();
			break;
		case 2:
			System.out.println("insert values");
			StatementOperations.insertData();
			break;
		case 3:
			System.out.println("multiple insert values");
			StatementOperations.insertMultiple();
			break;
		case 4:
			System.out.println("reading details from table");
		    StatementOperations.readTable();
			break;
		case 5:
			System.out.println("updating details");
			StatementOperations.update();
			break;
		case 6:
			System.out.println("deleting");
			StatementOperations.delete();
			break;
		case 7:
			System.out.println("batch operations");
			StatementOperations.batch();
			break;
		default:
			System.out.println("invalid choice");

		}

		
	}

}
