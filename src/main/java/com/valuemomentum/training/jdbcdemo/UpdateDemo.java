package com.valuemomentum.training.jdbcdemo;
import java.sql.*;
import java.util.Scanner;

public class UpdateDemo {

	public static void main(String[] args) {
		
		Connection con;
	     //  Statement stmt;
	      // ResultSet rs;
	       //int cnt=0;
	       //String sqlUpdate;
	       
	       
	       try
	       {
	    	   
	    	   Class.forName("com.mysql.cj.jdbc.Driver");
	    	   
	    	   System.out.println("Connecting to database...");
	    	  
	    	   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","exoluhan90");
	    	   
	    	  // sqlUpdate= "UPDATE candidates"+ "SET last_name"+"WHERE ID= ?";
	    	   PreparedStatement pstmt= con.prepareStatement("UPDATE candidates"+ " SET last_name=? "+"WHERE ID= ?");
	    	   
	    	   //// prepare data for update
	    	   Scanner s= new Scanner(System.in);
	    	   System.out.println("Enter Employee id: ");
	    	   int eid= s.nextInt();
	    	   System.out.println("Enter employee's new last name: ");
	    	   String lastname=s.next();
	    	   
	    	   pstmt.setString(1, lastname);
	    	   pstmt.setInt(2,eid);
	    	   
	    	   int rowAffected = pstmt.executeUpdate();
	    	   System.out.println(String.format("Rows affected %d", rowAffected));
	    	   
	    	   // reuse the prepared statement
	    	   lastname= "Grohe";
	    	   eid = 101;
	    	   
	    	   pstmt.setString(1, lastname);
	    	   pstmt.setInt(2,eid);
	    	   
	    	   rowAffected= pstmt.executeUpdate();
	    	   System.out.println(String.format("Rows affected %d", rowAffected));
	    	   
	    	   s.close();
	    	    con.close();
	    	         
	    	    }
	    		catch(Exception ce)
	    		{
	    			System.out.println(ce);
	    		}

		
		
	}

}
