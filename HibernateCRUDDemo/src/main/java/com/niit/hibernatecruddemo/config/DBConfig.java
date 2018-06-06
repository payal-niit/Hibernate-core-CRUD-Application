package com.niit.hibernatecruddemo.config;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.niit.hibernatecruddemo.model.User;

public class DBConfig {
	
	private static SessionFactory sessionFactory = null;
	 
    static {
        try{
        	System.out.println("Not Successful");
            loadSessionFactory();
            System.out.println("Successful");
        }catch(Exception e){
            System.err.println("Exception while initializing hibernate util.. ");
            e.printStackTrace();
        }
    }
 
    public static void loadSessionFactory(){
 
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(User.class);
        ServiceRegistry srvcReg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        setSessionFactory(configuration.buildSessionFactory(srvcReg));
    }
 
    public static Session getSession() throws HibernateException {
 
        Session session=null;
            try {
                session=getSessionFactory().openSession();
                //session.getTransaction().begin();;
            }catch(Throwable t){
            System.err.println("Exception while getting session.. ");
            t.printStackTrace();
            }
            if(session == null) {
                System.err.println("session is discovered null");
            }
 
            return session;
    }

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void setSessionFactory(SessionFactory sessionFactory) {
		DBConfig.sessionFactory = sessionFactory;
	}
}
