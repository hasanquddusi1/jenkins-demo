package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;



import models.User;

/*
 * we need to pull data from db. Currently the data below is dummy data. We are refactoring this dao.
 */

public class UserDaoImpl2_DB implements UserDao{
	
//	//substitute of db
//	private static Map<Integer, User> users; //db fake
//	private static int id;
	
	public UserDaoImpl2_DB() {

	}
	
	
	
	
	@Override
	public Map<Integer, User> getAll() {
		HashMap<Integer, User> users = new HashMap<>();
		
		//db connection allow to establish connection with a specific db
		//using connection interface of JDBC to establish this connection
		// we use this interface in conjuction with the DriverManager class to manage JDBC drivers
		// system class is useful for accessing input output streams, and system variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		
		try {
			 conn = DriverManager.getConnection("jdbc:postgresql://"+ System.getenv("db_url"), System.getenv("db_username"), System.getenv("db_password"));
		
			//After connection we want to execute sql statement, will use statement interface 
			final String SQL = "select user_id, first_name, last_name from users";
		stmt =  conn.createStatement();
			
			//once you execute query, you get back a resultSet. Resultset is an object which contains the data returned from executing
			//resultset are not iterable
		 set = stmt.executeQuery(SQL);
			
			//We have the data, now we just need to move through and place it into our map that we will return to the caller.
			
			//will start by moving through the each row in resultSet. Using the next() method on the result set
			//this moves the cursor forward to the next row
			// while means while there is a record get the next row
			while(set.next()) {
				 User retrievedUser = new User(
						 set.getString(2),
						 set.getString(3),
						 1337
						 );
				users.put(set.getInt(1), retrievedUser);		 
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				set.close();
				stmt.close();
				conn.close();
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
		return users;
	}
	
	@Override
	public User getOne(Integer key) {
	
		return null;
	}

	@Override
	public void createOne(User user) {
		return;
		
	}

	@Override
	public void deleteOne(Integer key) {
		return;
		
	}
	
}



//package dao;
//
//import java.util.HashMap;
//import java.util.Map;
//
//
//
//import models.User;
//
///*
//* we need to pull data from db. Currently the data below is dummy data. We are refactoring this dao.
//*/
//
//public class UserDaoImpl implements UserDao{
//	
//	//substitute of db
//	private static Map<Integer, User> users; //db fake
//	private static int id;
//	
//	public UserDaoImpl() {
//		// TODO Auto-generated constructor stub
//		users = new HashMap(); // just initializing for fake db //only body will change with actual db and same structure
//		id = 0;
//	}
//	
//	
//	
//	@Override
//	public Map<Integer, User> getAll() {
//		// TODO Auto-generated method stub
//		return users;
//	}
//
//	@Override
//	public User getOne(Integer key) {
//	
//		return users.get(key);
//	}
//
//	@Override
//	public void createOne(User user) {
//			users.put(id, user);
//			id++;
//		
//	}
//
//	@Override
//	public void deleteOne(Integer key) {
//		users.remove(key);
//		
//	}
//	
//}
