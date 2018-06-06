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
		userDAO = null;
	}
	
	
	@Test
	public void userListTest() {

		List<User> getUserList = userDAO.getUserList();
		for (User user : getUserList) {
			System.out.println("Name: " + user.getUsername());
		}
		boolean flag=false;
		if(getUserList != null) {
			flag=true;
			assertTrue("List is not null",true);
		}
		else {
			flag=false;
			assertFalse("List is null",false);
		}
	}

	
	@Test
	public void addUser() {
		User user = new User();
		user.setUsername("John");
		user.setPassword("12345");
		user.setPhone_number("1234567890");

		assertEquals(true, userDAO.createUser(user));
	}
	
	@Ignore
	@Test
	public void updateUser() {
		User user = userDAO.getUserById(10);
		user.setPhone_number("9820704323");
		assertEquals(true, userDAO.updateUser(user));
	}
	
	@Ignore
	@Test
	public void deleteUser() {
		User user = userDAO.getUserById(10);
		assertEquals(true, userDAO.deleteUser(user));
	}

}
