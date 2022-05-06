package com.akhilexpress.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.akhilexpress.entity.Song;
import com.akhilexpress.utils.HibernateUtils;

public class UpdatedApp {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// Initialize session object
		Session session = sessionFactory.openSession();

		Transaction tnx = session.beginTransaction();

		try {
			Song song = session.get(Song.class, 1);
			System.out.println(song);
			song.setArtist("Kishore Kumar1");
			
			session.update(song);
			session.getTransaction().commit();

			// System.out.println("Song updated.."+song);
		// 	System.out.println("Song updated.." + session.get(Song.class, 1));

			session.close();
			
			song.setArtist("Kumar Sanu");  //Changing artist name in a new session can be achieved through merge
			//not by using update() method .update method will throw an exception.  So in short we can persist detach object using merge() method in new session .
			Session session2 = sessionFactory.openSession();
			
			Song song2 = session2.get(Song.class, 1);
			session2.beginTransaction();
			session2.merge(song);
		//	session2.update(song); //exception
			session2.getTransaction().commit();
		} catch (Exception e) {

			tnx.rollback();
		}

	}

}
