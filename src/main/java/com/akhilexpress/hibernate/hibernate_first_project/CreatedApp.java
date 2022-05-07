package com.akhilexpress.hibernate.hibernate_first_project;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.akhilexpress.entity.Student;
import com.akhilexpress.utils.HibernateUtils;

public class CreatedApp {

	static Session session = null;
	static Transaction tnx=null;

	public static void main(String[] args) {

		// create configuration
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		session = sessionFactory.openSession();

		 tnx = session.beginTransaction();
		try {

			// getAllStudent();
			// findStudentByAge(24);
			// findStudentByAge_Name(22, "Ram");
		//	findStudentBetweenAges(20, 25);
			findName_and_Age();

		} catch (Exception e) {
			e.printStackTrace();
			tnx.rollback();
		}
		
		finally {
			session.close();
		}
		
	}

	
	private static void getAllStudent() {
		/*
		 * Query query = session.createQuery("SELECt s FROM Student s" );
		 * 
		 * List list = query.list(); for(Object temp:list) {
		 * System.out.println((Student)temp); }
		 */

		// Query<Student> query = session.createQuery("SELECt s FROM Student
		// s",Student.class );
		Query<Student> query = session.createQuery("FROM Student", Student.class);
		List<Student> list = query.list();
		for (Student temp : list) {
			System.out.println(temp);
		}
		tnx.commit();
	}

	private static void findStudentByAge(int age) {

		String hql = "Select s from Student s where s.age=?1";
		//	String hql = "Select s from Student s where s.age=:AGE";
		Query<Student> query = session.createQuery(hql, Student.class);
		query.setParameter(1, age);
	//query.setParameter("AGE", age);
		List<Student> list = query.list();

		for (Student temp : list) {

			System.out.println(temp);
		}
		tnx.commit();

	}

	private static void findStudentByAge_Name(int age, String name) {

		String hql = "from Student s where s.age=?1 and s.name=?2";
		Query<Student> query = session.createQuery(hql, Student.class);
		query.setParameter(1, age);
		query.setParameter(2, name);
		List<Student> list = query.list();

		for (Student temp : list) {
			System.out.println(temp);
		}
		tnx.commit();
	}

	private static void findStudentBetweenAges(int age_Min, int age_Max) {
		String hql = "from Student s where s.age between ?1 and ?2";
		Query<Student> query = session.createQuery(hql, Student.class);
		query.setParameter(1, age_Min);
		query.setParameter(2, age_Max);
		List<Student> list = query.list();

		System.out.println(list);
		tnx.commit();

	}
	private static void findName_and_Age() {
		String hql = "Select s.name,s.age from Student s";
		 Query<Object[]> query = session.createQuery(hql, Object[].class);
		
		List<Object[]> list = query.list();
		for(Object[] temp:list)
		{
			System.out.println(temp[0]+"          "+temp[1]);
		}
		
		tnx.commit();
		
		


	}

	
}
