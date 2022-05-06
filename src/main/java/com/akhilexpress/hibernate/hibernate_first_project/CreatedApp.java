package com.akhilexpress.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.akhilexpress.entity.Song;
import com.akhilexpress.utils.HibernateUtils;

public class CreatedApp {

	public static void main(String[] args) {

		// create configuration
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// Initialize session object
		Session session = sessionFactory.openSession();
		Song song = new Song();
		song.setSongName("Dhoom macha le ");
		song.setArtist("Shreya");

		Transaction tnx = session.beginTransaction();
		try {
			session.save(song);

			tnx.commit();

			System.out.println("Song saved..Check DB");

			session.close();
		} catch (Exception e) {
			tnx.rollback();
		}

	}

}
