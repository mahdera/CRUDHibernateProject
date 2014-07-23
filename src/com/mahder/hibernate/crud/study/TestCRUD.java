/**
 * 
 */
package com.mahder.hibernate.crud.study;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author alemayehu
 *
 */
public class TestCRUD {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		/*for(int i=1; i<=10;i++){
			User user = new User();
			user.setFullName("Name"+i);
			session.save(user);
		}//end for...loop*/
		//now lets read an object back...
		User user = (User) session.load(User.class, 5);
		user.setFullName("Mahder Neway");
		//now try to delete the User6
		session.update(user);

		session.getTransaction().commit();
		session.close();
	}

}//end class
