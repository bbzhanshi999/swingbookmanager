package edu.hyit.bm.service;

import edu.hyit.bm.dao.UserDao;
import edu.hyit.bm.model.User;

public class UserService {
	private UserDao userDao = new UserDao();;
	
	
	public User login(User user) {
		User result = userDao.findByUsername(user.getUsername());
		if(result!=null && user.getPassword().equals(result.getPassword())) {
			return result;
		}
		return null;
	}
	
	
}
