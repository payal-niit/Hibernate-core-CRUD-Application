package com.niit.hibernatecruddemo.dao;

import java.util.List;

import com.niit.hibernatecruddemo.model.User;

public interface UserDAO {
	
	public List<User> getUserList();
	
	public boolean createUser(User user);
	
	public User getUserById(int userId);

}
