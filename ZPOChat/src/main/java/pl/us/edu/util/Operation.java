package pl.us.edu.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pl.us.edu.model.Log;
import pl.us.edu.model.Message;
import pl.us.edu.model.User;
import pl.us.edu.types.LogType;

public class Operation {
	
	private static SessionFactory factory; 

	   /* Method to CREATE an employee in the database */
	   public static Integer saveUser(User user){
		   try{
		         factory = new Configuration().configure().buildSessionFactory();
		      }catch (Throwable ex) { 
		         System.err.println("Failed to create sessionFactory object." + ex);
		         throw new ExceptionInInitializerError(ex); 
		      }
	      Session session = factory.openSession();
	      Transaction tx = null;
	      Integer employeeID = null;
	      try{
	         tx = session.beginTransaction();
	         employeeID = (Integer) session.save(user); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return employeeID;
	   }
	   
	   public static User loguj(String login, char[] passwd){
		   try{
		         factory = new Configuration().configure().buildSessionFactory();
		      }catch (Throwable ex) { 
		         System.err.println("Failed to create sessionFactory object." + ex);
		         throw new ExceptionInInitializerError(ex); 
		      }
	      Session session = factory.openSession();
	      Transaction tx = null;
	      User user = null;
	      try{
	         tx = session.beginTransaction();
	         User user1 = (User) session.createQuery("FROM User WHERE login like '" + login + "'").list().get(0); 
	         if (Arrays.equals(user1.getPassword().toCharArray(), passwd)
						&& user1.getLogin().equals(login)) {
	        	 user = user1;
	         }
	         
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return user;
	   }

	   public static List<Message> listMessage( ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      List<Message> msg = null;
	      try{
	         tx = session.beginTransaction();
	         msg = session.createQuery("FROM Message").list(); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return msg;
	   }

	public static void post(Message msg) {
		 try{
	         factory = new Configuration().configure().buildSessionFactory();
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         session.save(msg); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
	}

	public static void aktUser(User user, int akt) {
		Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         User user1 = 
	                    (User)session.get(User.class, user.getId()); 
	         user1.setAkt(akt);
			 session.update(user1); 
			 String ip = null;
			 try {
				ip = InetAddress.getLocalHost().toString();
			} catch (UnknownHostException e) {
				ip = "";
			}
			 Log log = new Log(user1,ip,new Date(), LogType.values()[akt]);
			 session.save(log);
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		
	}

	public static List<User> listUser() {
		 Session session = factory.openSession();
	      Transaction tx = null;
	      List<User> us = null;
	      try{
	         tx = session.beginTransaction();
	         us = session.createQuery("FROM User WHERE akt = 1").list(); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return us;
	}
	
}