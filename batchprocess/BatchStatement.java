/**
 * 
 */
package com.bridgelabz.batchprocess;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.preparedstatement.PreparedStatementOperations;
import com.bridgelabz.statement.StatementOperations;

public class BatchStatement {

    public static void main(String[] args) throws SQLException {
    Connection connection=null;
    Statement statement=null;
    String insert="insert into studentDetails values(4,'nikki','k')";
    String update="update studentDetails set id=6 where firstName='chaitra'";
    String delete="delete from studentDetails where id=2";
    try {
    connection=StatementOperations.gettconnection();
    statement=connection.createStatement();
    
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
            statement.close();
        }
        if(connection!=null) {
            connection.close();
        }
    }
   
    }

}