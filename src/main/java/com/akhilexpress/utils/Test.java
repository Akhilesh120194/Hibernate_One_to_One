package com.akhilexpress.utils;

import org.hibernate.SessionFactory;

public class Test {

	public static void main(String[] args) {

			SessionFactory sessionFactory1 = HibernateUtils.getSessionFactory();
			
			SessionFactory sessionFactory2 = HibernateUtils.getSessionFactory();
			
			System.out.println(sessionFactory1+ "  " +sessionFactory2);

	}

}
