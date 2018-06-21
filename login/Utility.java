/**
 * 
 */
package com.bridgelabz.login;

import java.util.Scanner;

/*************************************************************************************************************
 *
 * purpose:
 *
 * @author sowjanya467
 * @version 1.0
 * @since -05-17
 *
 * **************************************************************************************************/

public class Utility 
{
	//Matcher matcher;
	static Scanner sc=new Scanner(System.in);
	public static String userInputString()
	{
		return sc.next();
	}
	/**
	 * @param userName
	 * @param password
	 * @return
	 */
	public static boolean valid(String password) 
	{
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
	      if(password.matches(pattern))
	      {
	    	return true;  
	      }
	      else
	      {
	    	  System.out.println("enter the valid password with requierd specifications");
		return false;
	      }
	
	}
	/**
	 * @return
	 */
	public static int readInteger() 
	{
		int a=sc.nextInt();
		return a;
	}

}
