package com.mahder.hibernate.crud.study;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHQL {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String minUserId = " 5 or 1 = 1";
		Query hibernateQuery = session.createQuery("from User where id > "+minUserId);
		hibernateQuery.setFirstResult(7);
		hibernateQuery.setMaxResults(1);
		List<User> userList = (List<User>) hibernateQuery.list();
		System.out.println("List size is : "+userList.size());
		session.getTransaction().commit();
		session.close();
		//now display the result to the user...
		for(User user : userList){
			System.out.println("User fullname : "+user.getFullName());
		}
	}

}//end class
