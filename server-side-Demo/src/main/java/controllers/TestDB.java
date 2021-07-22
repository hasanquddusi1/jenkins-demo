package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDB {
	public static void main(String[] args) {

		   	String dbName = System.getenv("db_name");
		    String userName = System.getenv("db_username");
		    String password = System.getenv("db_password");
		    String hostname = System.getenv("db_url");
		    String port = System.getenv("db_port");
		    String jdbcUrl = "jdbc:postgresql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
		    String QUERY = "SELECT * FROM reimb_report";

		    try(Connection con = DriverManager.getConnection(jdbcUrl);
		    		Statement stmt = con.createStatement();
			         ResultSet rs = stmt.executeQuery(QUERY);) {
		    	 while (rs.next()) {
			            // Retrieve by column name
			            System.out.println(rs.getString(4));
			           
			         }
			      } catch (SQLException e) {
			         e.printStackTrace();
			      } 
		    }
	
	

}
