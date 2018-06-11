package com.niit.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.springdemo.dao.UserDAO;
import com.niit.springdemo.model.User;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO userDAO;

	@Override
	public List<User> getUserList() {		
		return userDAO.getUserList();
	}

	@Override
	public boolean createUser(User user) {
		userDAO.createUser(user);
		return true;
	}

	@Override
	public User getUserById(int userId) {
		
		return userDAO.getUserById(userId);
	}

	@Override
	public boolean updateUser(User user) {
		userDAO.updateUser(user);
		return true;
	}

	@Override
	public boolean deleteUser(User user) {
		userDAO.deleteUser(user);
		return true;
	}

	@Override
	public List<User> getUserListByName(String username) {
		// TODO Auto-generated method stub
		return userDAO.getUserListByName(username);
	}

}
