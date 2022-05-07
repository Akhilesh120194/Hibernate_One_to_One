package com.akhilexpress.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.akhilexpress.entity.Address;
import com.akhilexpress.entity.Student;
import com.akhilexpress.utils.HibernateUtils;

public class CreatedApp {

	public static void main(String[] args) {

		// create configuration
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
/*		
		Address address=new Address();
		address.setAddressLine1("mig-778");
		address.setAddressLine2("colony");
		address.setCity("Morena");
		
		Student student=new Student();
		student.setName("Akhilesh");
		student.setMobile(74774747);
		student.setAddress(address);
	
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(student);
			transaction.commit();
			
		} catch (Exception e) {

				transaction.rollback();
		}*/

	}
}
