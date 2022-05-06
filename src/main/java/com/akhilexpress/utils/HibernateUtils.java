package com.akhilexpress.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.akhilexpress.entity.Student;

public class HibernateUtils {

	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null ) {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			configuration.addAnnotatedClass(Student.class);
			// create session factory

		sessionFactory = configuration.buildSessionFactory();

		}
		return sessionFactory;
	}
}
