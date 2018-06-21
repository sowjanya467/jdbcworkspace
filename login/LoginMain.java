/**
 * 
 */
package com.bridgelabz.login;

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

public class LoginMain 
{

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		
		 LoginService l = new LoginService();

		System.out.println("enter the choice");
		int choice = Utility.readInteger();

		switch (choice) 
		{
		case 1:
			System.out.println("registration");
			LoginService.registration();
			break;
		case 2:
			System.out.println("login");
			l.checkLogin();
			break;

		case 3:
			System.out.println("forgot password");
			l.forgotPassword();
			break;
		default:
			System.out.println("invalid entry");
		}
	}

}
