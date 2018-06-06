package com.niit.hibernatecruddemo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.niit.hibernatecruddemo.dao.UserDAO;
import com.niit.hibernatecruddemo.daoimpl.UserDAOImpl;
import com.niit.hibernatecruddemo.model.User;

public class UserTest {
	
	UserDAO userDAO;

	@Before
	public void setUp() throws Exception {
		userDAO = new UserDAOImpl();
	}

	@After
	public void tearDown() throws Exception {
		userDAO=null;
	}
	
	@Test
	public void userListTest() {
		
		List<User> getUserList = userDAO.getUserList();
		for(User user:getUserList) {
			System.out.println("Name: "+user.getUsername());
		}
		assertEquals(getUserList.size() >0, userDAO.getUserList());
	}
	@Ignore
	@Test
	public void addUser() {
		User user = new User();
		user.setUsername("John");
		user.setPassword("12345");
		user.setPhone_number("1234567890");
		
		assertEquals(true, userDAO.createUser(user));
	}
	
	public void updateUser() {
		User user = userDAO.getUserById(1);
	}

}
