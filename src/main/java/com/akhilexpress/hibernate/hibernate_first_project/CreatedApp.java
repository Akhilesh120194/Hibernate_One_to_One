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
	static Transaction tnx = null;

	public static void main(String[] args) {

		// create configuration
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		session = sessionFactory.openSession();

		tnx = session.beginTransaction();
		try {

			// getAllStudent();
			// findStudentByAge(24);
			// findStudentByAge_Name(22, "Ram");
			// findStudentBetweenAges(20, 25);
			// findName_and_Age();
		//	findAllStudentUsingNamedQuery();  //Named Query
		//	findStudentsUsingNativeQuery();  //Native Query
		//	findStudentByName_SqlInjection("Laxman' or '1'='1"); //SQL Injection 
	//	findStudentByAggregation();
	//updateAllStudentAgeBy1();		
			deleteStdentById(3);
			

		} catch (Exception e) {
			e.printStackTrace();
			tnx.rollback();
		}

		finally {
			session.close();
		}

	}

	private static void deleteStdentById(int id) {
		
		int rowDeleted = session.createQuery("delete from Student s where s.id=:id").setParameter("id", id).executeUpdate();
		System.out.println(rowDeleted);
	}

	private static void updateAllStudentAgeBy1() {

		int rowUpdated = session.createQuery("update Student s set s.age=s.age+1").executeUpdate();
		System.out.println(rowUpdated);
	}

	private static void findStudentByAggregation() {

	List<Object[]> list = session.createQuery("select sum(age) from Student s ", Object[].class).list();
		System.out.println(list);
		
		 List<Object[]> list2 = session.createQuery("select s.country, sum(age) from Student s group by s.country ", Object[].class).list();
		System.out.println(list2);
		for(Object[] temp:list2)
		{
			System.out.println(temp[0]+" - "+temp[1]);
		}
		
		 List<Object[]> list3 = session.createQuery("select s.country, count(*) from Student s group by s.country ", Object[].class).list();
			System.out.println(list3);
			for(Object[] temp:list3)
			{
				System.out.println(temp[0]+" - "+temp[1]);
			}
		
	}

	private static void findStudentByName_SqlInjection(String name) {

		String hql="from Student s where s.name='"+name+"'";
		List<Student> list = session.createQuery(hql,Student.class).list();
		System.out.println(list);
		
		/*String hql2="from Student s where s.name=:name";
		
		List<Student> list2 = session.createQuery(hql,Student.class).setParameter("name",name).list();
		System.out.println(list2);*/
		
	}

	private static void findStudentsUsingNativeQuery() {

List<Student> list = session.createNativeQuery("select * from students where student_name='Ram'", Student.class).list();
System.out.println(list);

List<Student> list2 = session.createNativeQuery("select * from students where student_name='Venkat can''t'", Student.class).list();
System.out.println(list2);
	}

	private static void findAllStudentUsingNamedQuery() {

		List<Student> list = session.createNamedQuery("myapp.allstudents", Student.class).list();
		System.out.println(list);

		List<Student> list2 = session.createNamedQuery("myapp.allstudents.namelike", Student.class).setParameter("substring", "%l%").list();
		System.out.println(list2);

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
		// String hql = "Select s from Student s where s.age=:AGE";
		Query<Student> query = session.createQuery(hql, Student.class);
		query.setParameter(1, age);
		// query.setParameter("AGE", age);
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
		for (Object[] temp : list) {
			System.out.println(temp[0] + "          " + temp[1]);
		}

		tnx.commit();

	}

}
