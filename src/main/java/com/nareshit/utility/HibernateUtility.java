package com.nareshit.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

	private static SessionFactory factory;
	
	
	
	
	
	private HibernateUtility() {
		
	}
	
	public static SessionFactory getInstance() {
		if(factory == null) {
			Configuration cfg = new Configuration().configure();
			
			factory = cfg.buildSessionFactory();
		}
		return factory;
	}
}
