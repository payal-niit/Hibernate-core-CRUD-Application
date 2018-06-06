package com.niit.hibernatecruddemo.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.niit.hibernatecruddemo.config.DBConfig;
import com.niit.hibernatecruddemo.dao.UserDAO;
import com.niit.hibernatecruddemo.model.User;

public class UserDAOImpl implements UserDAO{
	
	Session session = DBConfig.getSession();
	
	public List<User> getUserList() {
		
		session.getTransaction().begin();
		
		 System.out.println("Session Is Opened :: "+session.isOpen());
		 System.out.println("Session Is Connected :: "+session.isConnected()); 
		 
		@SuppressWarnings("unchecked")
		List<User> getUserList = session.createQuery("from User").list();
		 session.getTransaction().commit();
		return getUserList;
	}

	public boolean createUser(User user) {
		session.getTransaction().begin();
		session.save(user);
		session.getTransaction().commit();
		return true;
	}
	
	public boolean updateUser(User user) {
		session.getTransaction().begin();
		session.update(user);
		session.getTransaction().commit();
		return true;
	}
	
	public User getUserById(int userId) {
		
		User user = (User) session.createQuery("from user where userId = " + userId).list().get(0);
		return user;
	}
	
	

}
