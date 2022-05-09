package com.akhilexpress.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.akhilexpress.entity.Passport;
import com.akhilexpress.entity.Student;
import com.akhilexpress.utils.HibernateUtils;

public class CreatedApp {

	static Session session = null;
	static Transaction tnx = null;

	public static void main(String[] args) {

		// create configuration
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		session = sessionFactory.openSession();

		tnx = session.getTransaction();
		tnx.begin();
		try {

			/*Passport akhil_Passport=new Passport();
			//akhil_Passport.setPassport_id(10);
					akhil_Passport.setPassport_number("377DSDHGSD");
			Student akhil=new Student();	
			akhil.setName("Akhilesh");
			akhil.setCountry("India");
			akhil.setPassport(akhil_Passport);
			session.save(akhil_Passport);
			session.save(akhil);*/
			
			Student student = session.get(Student.class, 1);
			System.out.println(student);
			
			/*Passport passport = session.get(Passport.class, 1);
			System.out.println(passport +"   "+passport.getStudent());
			*/
			

		} catch (Exception e) {
			e.printStackTrace();
			tnx.rollback();
		}

		finally {
			session.close();
		}

	}

	

}
