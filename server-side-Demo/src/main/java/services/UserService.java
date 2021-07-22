package services;

import java.util.Map;

import models.User;

public interface UserService {
	
	Map<Integer, User> getAll();
	User getOne(Integer key); //defining how impl be from dao
	void createOne(User user);
	void deleteOne(Integer key);

}
