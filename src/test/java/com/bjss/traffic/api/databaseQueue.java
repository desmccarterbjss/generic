package com.bjss.traffic.api;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class databaseQueue {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://az-tma-dev-sql.uksouth.cloudapp.azure.com;user=test;password=Passw0rd1;database=TMA");
		System.out.println("test");
		Statement sta = conn.createStatement();
		String Sql = "SELECT TOP 1000 [Id] "+
      ",[UserName] "+
      ",[DeviceIdentifier] "+
      ",[BatchId] "+
      ",[RecordId] "+
      ",[RecordType] "+
      ",[CaptureResult] "+
      ",[DateCreated] "+
      "FROM [TMA].[dbo].[CaptureResultHistory] "+
      "order by [DateCreated] desc";
		
		ResultSet rs = sta.executeQuery(Sql);
		while (rs.next()) {
			System.out.println(rs.getString("txt_title"));
		}
	}


}
