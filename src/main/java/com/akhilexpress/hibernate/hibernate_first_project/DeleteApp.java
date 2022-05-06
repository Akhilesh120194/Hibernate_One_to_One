package com.akhilexpress.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.akhilexpress.entity.Song;
import com.akhilexpress.utils.HibernateUtils;

public class DeleteApp {

	public static void main(String[] args) {

		// create configuration
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// Initialize session object
		Session session = sessionFactory.openSession();
		

		session.beginTransaction();

		Song song=session.get(Song.class, 2);
		session.delete(song);

		session.getTransaction().commit();

		System.out.println("Song deleted..");

		session.close();

	}

	

}
