package com.akhilexpress.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.akhilexpress.entity.Song;
import com.akhilexpress.utils.HibernateUtils;

public class UpdatedApp {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// Initialize session object
		Session session = sessionFactory.openSession();
		

		session.beginTransaction();

		Song song=session.get(Song.class, 1);
		System.out.println(song);
		song.setArtist("Kishore Kumar");

		session.getTransaction().commit();

	//	System.out.println("Song updated.."+song);  
		System.out.println("Song updated.."+session.get(Song.class, 1));  

		session.close();

	}

	

}
