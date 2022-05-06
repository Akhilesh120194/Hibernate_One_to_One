package com.akhilexpress.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.akhilexpress.entity.Song;
import com.akhilexpress.utils.HibernateUtils;

public class CreatedApp {

	public static void main(String[] args) {

		// create configuration
		SessionFactory sessionFactory =HibernateUtils.getSessionFactory();

		// Initialize session object
		Session session = sessionFactory.openSession();
		Song song = new Song(2, "fsdf", "bob");

		session.beginTransaction();

		session.save(song);

		session.getTransaction().commit();

		System.out.println("Song saved..Check DB");

		session.close();

	}

	

}
