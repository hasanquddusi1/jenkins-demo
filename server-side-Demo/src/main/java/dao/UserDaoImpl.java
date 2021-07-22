package dao;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import dbconfig.ConnectionUtil;
import dbconfig.ResourceClosers;
import models.User;

/*
 * we need to pull data from db. Currently the data below is dummy data. We are refactoring this dao.
 */

public class UserDaoImpl implements UserDao{
	
//	//substitute of db
//	private static Map<Integer, User> users; //db fake
//	private static int id;
	
	public UserDaoImpl() {

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
			 conn = ConnectionUtil.getConnection();
		
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
	
		ResourceClosers.closeConnection(conn);
		ResourceClosers.closeStatement(stmt);
		ResourceClosers.closeResultSet(set);
		}
		
		return users;
	}
	
	@Override
	public User getOne(Integer key) {
	
		return null;
	}

	@Override
	public void createOne(User user) {
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			//connect to db
			conn = ConnectionUtil.getConnection();
			
			//make sql statement, default next value in the sequence
			//formatting sql strings in java, use prepared statements instead
//			final String SQL = "insert into users values(default, '" 
//			+ user.getFirstName()+ "', '" 
//			+ user.getLastName() + "','someemail@asa.com', 'secret_sauce' )";
			final String SQL2 = "insert into users values(default, ?,?,?,?)";

			stmt = conn.prepareStatement(SQL2);
			((PreparedStatement) stmt).setString(1, user.getFirstName());
			((PreparedStatement) stmt).setString(2, user.getLastName());
			
			stmt.execute(SQL2);
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			ResourceClosers.closeConnection(conn);
			ResourceClosers.closeStatement(stmt);
		}
		
	}

	@Override
	public void deleteOne(Integer key) {
		return;
		
	}
	
}


