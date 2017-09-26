package com.bjss.traffic.config;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SqlServerValidation {
	public static void main(String[] args) {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		      // Create a variable for the connection string.  
		      String connectionUrl = "jdbc:sqlserver://az-tma-dv-sql.uksouth.cloudapp.azure.com;" +  
		         "databaseName=PreCom;user=michael.umenyiora;password=5678";  
		      
		     // MQQueueManager queueManager = new MQQueueManager("qMgrName");
		      
		      // Declare the JDBC objects.  
		      Connection con = null;  
		      Statement stmt = null;  
		      ResultSet rs = null;  

		      try {  
		         // Establish the connection.  
		         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
		         con = DriverManager.getConnection(connectionUrl);  

		         // Create and execute an SQL statement that returns some data.  
		         String SQL = "SELECT TOP 10 * FROM Person.Contact";  
		         stmt = con.createStatement();  
		         rs = stmt.executeQuery(SQL);  

		         // Iterate through the data in the result set and display it.  
		         while (rs.next()) {  
		            System.out.println(rs.getString(4) + " " + rs.getString(6));  
		         }  
		      }  

		      // Handle any errors that may have occurred.  
		      catch (Exception e) {  
		         e.printStackTrace();  
		      }  
		      finally {  
		         if (rs != null) try { rs.close(); } catch(Exception e) {}  
		         if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
		         if (con != null) try { con.close(); } catch(Exception e) {}  
		      }  
		   }  
}

