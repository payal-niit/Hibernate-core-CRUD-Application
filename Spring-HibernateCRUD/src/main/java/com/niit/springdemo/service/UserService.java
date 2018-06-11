package com.niit.springdemo.service;

import java.util.List;

import com.niit.springdemo.model.User;

public interface UserService {
	
	public List<User> getUserList();
	
	public boolean createUser(User user);
	
	public User getUserById(int userId);
	
	public boolean updateUser(User user);
	
	public boolean deleteUser(User user);
	
	public List<User> getUserListByName(String username);

}
