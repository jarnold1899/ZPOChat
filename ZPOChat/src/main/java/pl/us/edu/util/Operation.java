package pl.us.edu.util;

import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pl.us.edu.model.Message;
import pl.us.edu.model.User;

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
//	   /* Method to UPDATE salary for an employee */
//	   public void updateEmployee(Integer EmployeeID, int salary ){
//	      Session session = factory.openSession();
//	      Transaction tx = null;
//	      try{
//	         tx = session.beginTransaction();
//	         Employee employee = 
//	                    (Employee)session.get(Employee.class, EmployeeID); 
//	         employee.setSalary( salary );
//			 session.update(employee); 
//	         tx.commit();
//	      }catch (HibernateException e) {
//	         if (tx!=null) tx.rollback();
//	         e.printStackTrace(); 
//	      }finally {
//	         session.close(); 
//	      }
//	   }
//	   /* Method to DELETE an employee from the records */
//	   public void deleteEmployee(Integer EmployeeID){
//	      Session session = factory.openSession();
//	      Transaction tx = null;
//	      try{
//	         tx = session.beginTransaction();
//	         Employee employee = 
//	                   (Employee)session.get(Employee.class, EmployeeID); 
//	         session.delete(employee); 
//	         tx.commit();
//	      }catch (HibernateException e) {
//	         if (tx!=null) tx.rollback();
//	         e.printStackTrace(); 
//	      }finally {
//	         session.close(); 
//	      }
//	   }

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

}