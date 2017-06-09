package com.mihailproductions;

import org.junit.Test;

import junit.framework.TestCase;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class AppTest extends TestCase {
	public static List<Customer> getCustomers(){
		SessionFactory factory=HibernateUtil.getSessionFactory();
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         tx.commit();
	         return session.createQuery("FROM Customer").list();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return null;
	}
	@Test
	public void testInsert() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        if(session.get(Customer.class, 1)==null)
        {
        	Customer customer = new Customer();
            customer.setCustomerId(1);
            customer.setLastName("Smith");
            customer.setFirstName("John");
            customer.setEmail("js@email.com");
            session.save(customer);
            session.getTransaction().commit();
            
        }
	}
	@Test
	public void testSuccesfullyInserted() {
        List<Customer> customers = getCustomers();
        assertEquals(customers.get(0).getFirstName(), "John");
	}
}
