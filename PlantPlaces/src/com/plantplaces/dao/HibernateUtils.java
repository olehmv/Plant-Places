package com.plantplaces.dao;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	private final static Logger logger=Logger.getLogger(HibernateUtils.class);
	
	private static final SessionFactory sessionFactory=buildSessionFactory();
		
	private static SessionFactory buildSessionFactory(){
		
		try {
			
			logger.info("Hibernate SessionFactory Initialize...");
			return new Configuration().configure().buildSessionFactory();
			
		} catch (Exception e) {
			logger.error("Error initializing Hibernate SessionFactory :"+e.getMessage());
			throw new ExceptionInInitializerError(e);
				
		}
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	public static void  shotdown(){
		sessionFactory.close();
	}
	
}
