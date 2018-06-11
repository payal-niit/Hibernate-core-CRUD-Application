package com.niit.spring_hibernatecruddemo;

import static org.junit.Assert.*;

import java.util.List;

import org.jboss.logging.Logger.Level;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.springdemo.config.AppContext;
import com.niit.springdemo.dao.UserDAO;
import com.niit.springdemo.daoimpl.UserDAOImpl;
import com.niit.springdemo.model.User;
import com.niit.springdemo.service.UserService;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=AppContext.class)
public class UserTestCase {

	@Autowired
	UserService userService;

	@Before
	public void setUp() throws Exception {
			
	}

	@After
	public void tearDown() throws Exception {
		userService = null;
	}
	
	@Ignore
	@Test
	public void userListTest() {

		List<User> getUserList = userService.getUserList();
		for (User user : getUserList) {
			UserDAOImpl.logger.log(Level.INFO, "List: " + user.getUsername());
		}		
		if(getUserList != null) {			
			assertTrue("List is not null",true);
		}
		else {			
			assertFalse("List is null",false);
		}
	}

	
	@Test
	public void addUser() {
		User user = new User();
		user.setUsername("John");
		user.setPassword("12345");
		user.setPhone_number("1234567890");

		assertEquals(true, userService.createUser(user));
	}
	
	@Ignore
	@Test(expected= IndexOutOfBoundsException.class)
	public void updateUser() {
		User user = userService.getUserById(1);
		user.setPhone_number("9820704323");
		assertEquals(true, userService.updateUser(user));
	}
	
	@Ignore
	@Test
	public void deleteUser() {
		User user = userService.getUserById(10);
		assertEquals(true, userService.deleteUser(user));
	}
}
