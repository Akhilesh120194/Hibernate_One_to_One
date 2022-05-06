package com.akhilexpress.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.akhilexpress.entity.Song;
import com.akhilexpress.utils.HibernateUtils;

public class ReadApp {

	public static void main(String[] args) {

		// create configuration
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// Initialize session object
		Session session = sessionFactory.openSession();

		Transaction tnx = session.beginTransaction();

		try {
			Song song = session.get(Song.class, 1);

			System.out.println("does song object managed by session : " + session.contains(song));// true

			tnx.commit();

			System.out.println("Song fetched.." + song);

			session.detach(song);

			System.out.println("does song object managed by session : " + session.contains(song));// false

			session.close();

			System.out.println("does song object managed by session : " + session.contains(song));// exception

		} catch (Exception e) {
			tnx.rollback();
		}

	}

}
