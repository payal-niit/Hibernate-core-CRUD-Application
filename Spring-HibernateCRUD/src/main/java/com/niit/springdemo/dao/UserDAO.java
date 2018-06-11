package com.niit.springdemo.dao;

import java.util.List;

import com.niit.springdemo.model.User;

public interface UserDAO {
	
	public List<User> getUserList();
	
	public boolean createUser(User user);
	
	public User getUserById(int userId);
	
	public boolean updateUser(User user);
	
	public boolean deleteUser(User user);
	
	public List<User> getUserListByName(String username);

}
