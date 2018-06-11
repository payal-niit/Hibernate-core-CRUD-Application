package com.niit.hibernatecruddemo.dao;

import java.util.List;

import com.niit.hibernatecruddemo.model.User;

public interface UserDAO {
	
	public boolean addUser(User user);
	public User getUserById(int userId);
	public List<User> getUserList();
	public boolean updateUser(User user);
	public void delete(int userId);
}
