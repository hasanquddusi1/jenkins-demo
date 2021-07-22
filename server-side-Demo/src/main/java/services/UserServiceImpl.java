package services;

import java.util.Map;

import dao.UserDao;
import dao.UserDaoImpl;
import models.User;
//talking to dao and let doa do all the work 
public class UserServiceImpl implements UserService{
	
	UserDao userDao;
	
	 public UserServiceImpl() {
		this.userDao = new UserDaoImpl();
	}

	@Override
	public Map<Integer, User> getAll() {
		// TODO Auto-generated method stub
		return this.userDao.getAll();
	}

	@Override
	public User getOne(Integer key) {
		// TODO Auto-generated method stub
		return this.userDao.getOne(key);
	}

	@Override
	public void createOne(User user) {
		// TODO Auto-generated method stub
		this.userDao.createOne(user);
		
	}

	@Override
	public void deleteOne(Integer key) {
		// TODO Auto-generated method stub
		this.userDao.deleteOne(key);
		
	}

}
