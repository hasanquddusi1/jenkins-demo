package dao;

import java.util.Map;

import models.User;
//interface define what methods we need to have 
public interface UserDao {
	Map<Integer, User> getAll();
	User getOne(Integer key); //defining how impl be from dao
	void createOne(User user);
	void deleteOne(Integer key);
	

}
