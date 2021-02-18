package com.valuemomentum.training.jdbcdemo;
import java.sql.*;

public class BatchDemo {

	public static void main(String[] args) throws Exception
	{
		
		Connection con;
	       Statement stmt;
	      // ResultSet rs;
	       //int cnt=0;
	       //String sqlUpdate;
	       
	       
	        
	    	   Class.forName("com.mysql.cj.jdbc.Driver");
	    	   
	    	   System.out.println("Connecting to database...");
	    	  
	    	   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","exoluhan90");
	    	   stmt= con.createStatement();
	    	   
	    	   //create batch
	    	   stmt.addBatch("insert into candidate_skills values(100,5)");
	    	   stmt.addBatch("update skills set name='BTS' where id=3");
	    	   stmt.addBatch("delete from candidates where id=80");
	    	   
	    	   //diable auto=commit mode
	    	   con.setAutoCommit(false);
	    	   try
	    	   {
	    		   stmt.executeBatch();
	    		   con.commit();
	    		   System.out.println("batch is successfully executed");
	    		   
	    	   }
	    	   catch(Exception e)
	    	   {
	    		   try
	    		   {
	    			   con.rollback();
	    			   System.out.println("batch is failed");
	    			   System.out.println("Exception is  "+e);
	    		   }
	    		   catch(Exception e1)
	    		   {
	    			   System.out.println("Exception is :"+e1);
	    		   }

	    		   
	    	   }
	}

}
	    	   
	    	   
		

	


