package com.niit.hibernatecruddemo.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.niit.hibernatecruddemo.config.DBConfig;
import com.niit.hibernatecruddemo.dao.UserDAO;
import com.niit.hibernatecruddemo.model.User;

public class UserDAOImpl implements UserDAO{
	
	SessionFactory sessionFactory;

	public boolean addUser(User user) {
		Session session = DBConfig.getSessionFactory().getCurrentSession();
		session.beginTransaction().begin();
		
		session.save(user);
		return true;
	}

	public User getUserById(int userId) {
		User user = (User) sessionFactory.getCurrentSession().createQuery("from User where userId = " + userId).getResultList().get(0);
		return user;
	}

	public List<User> getUserList() {
		List<User> userList = sessionFactory.getCurrentSession().createQuery("from User").getResultList();
		return userList;
	}

	public boolean updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		return false;
	}

	public void delete(int userId) {
		User user = getUserById(userId);
		sessionFactory.getCurrentSession().delete(user);
		
	}
	
	

}
