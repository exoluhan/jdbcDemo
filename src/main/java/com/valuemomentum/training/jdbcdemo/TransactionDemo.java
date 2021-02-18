package com.valuemomentum.training.jdbcdemo;

 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

 

public class TransactionDemo {

 

    public static void main(String[] args) throws Exception
        {
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","exoluhan90");
        System.out.println("Driver is loaded");
        Statement stmt=con.createStatement();
        con.setAutoCommit(false);
        try
        {
            int i1=stmt.executeUpdate("INSERT INTO candidate_skills VALUES(100,7)");
            int i2=stmt.executeUpdate("UPDATE skills set name='ENHYPEN' WHERE id=2");
            int i3=stmt.executeUpdate("DELETE FROM candidates WHERE id=34");
            
            con.commit();
            System.out.println("Transaction is success");
        }
        catch(Exception e)
        {
            try
            {
                con.rollback();
                System.out.println("Transaction is failed");
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
        }
        stmt.close();
        con.close();
        System.out.println("connection is closed");
    }

 

}