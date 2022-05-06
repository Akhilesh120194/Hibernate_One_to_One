package com.akhilexpress.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.akhilexpress.entity.Song;
import com.akhilexpress.utils.HibernateUtils;

public class ReadApp {

	public static void main(String[] args) {

		// create configuration
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// Initialize session object
		Session session = sessionFactory.openSession();
		

		session.beginTransaction();

		Song song=session.get(Song.class, 1);

		session.getTransaction().commit();

		System.out.println("Song fetched.."+song);

		session.close();

	}


}
