/**
 * 
 */
package com.bridgelabz.jdbcWorkSpace;
import java.io.FileInputStream;
import java.sql.*;
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

     
    public class InsertImage {  
    public static void main(String[] args) {  
    try{  
        Driver d=new Driver();
		DriverManager.registerDriver(d);

	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL=false","root","root");
                  
    PreparedStatement ps=con.prepareStatement("insert into image values(?,?)");  
    ps.setString(1,"sony");  
      
    FileInputStream fin=new FileInputStream("/home/bridgelabz/Pictures/sc.jpg");  
    ps.setBinaryStream(2,fin,fin.available());  
    int i=ps.executeUpdate();  
    System.out.println(i+" records affected");  
              
    con.close();  
    }catch (Exception e) {e.printStackTrace();}  
    }      
}
