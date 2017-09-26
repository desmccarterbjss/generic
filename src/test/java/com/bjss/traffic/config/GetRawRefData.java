package com.bjss.traffic.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class GetRawRefData {

	private final static String DIRECTORY_WITH_CSVS = System.getProperty("csvpath"); 
	private static String query = "";
			

	public GetRawRefData(){
		
	}
	
	/** Queries the CSV files that contains the reference data
	 * 
	 * @param tableName
	 * @param columnName
	 * @param whereClause
	 * @return
	 */
	public ArrayList<String> getRefData(String tableName, String columnName, String whereClause, String columnTypes){
		
		query = "select "+columnName+" from "+tableName+" "+whereClause+" ";
		System.out.println("executed query is"+query+" and the where clasue is "+whereClause);
		//Create a data source and use it to create a JDBC template.
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl("jdbc:relique:csv:" + DIRECTORY_WITH_CSVS);

		ds.setConnectionProperties(columnTypes);
		JdbcTemplate template = new JdbcTemplate(ds);

		//Query for all records using the JDBC template.
		ArrayList<String> results = (ArrayList<String>) template.queryForList(query, String.class);
		//System.out.println(results);	
		
		return results;
	}
	
}
