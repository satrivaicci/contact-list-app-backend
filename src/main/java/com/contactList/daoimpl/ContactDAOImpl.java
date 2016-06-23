package com.contactList.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.contactList.dao.ContactDAO;
import com.contactList.entity.Contact;
import com.contactList.entity.User;

public class ContactDAOImpl implements ContactDAO{
	
	public ContactDAOImpl(){
	}
	
	public Contact getContact(Integer contactId){
		
		Contact contact = null;
		
		try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("contactListPU");
			EntityManager em = emf.createEntityManager();
			
			Query query = em.createQuery("SELECT c FROM Contact c WHERE c.contactId = " + contactId);
			
			contact = (Contact)query.getSingleResult();
			
			em.close();
			emf.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			throw ex;
		}
		
		return contact;
	 }
	 
	 public List<Contact> getContactsByUserId(String username, Integer userId){
		 
		 List<Contact> contacts = null;
		 
		 try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("contactListPU");
			EntityManager em = emf.createEntityManager();
			
			Integer id = null;
			
			if(userId != null){
				id = userId;
			}
			else if(username != null)
			{
				Query query = em.createQuery("SELECT u FROM User u WHERE u.username = \"" + username + "\"");
				
				User user = (User)query.getSingleResult();
				id = user.getUserId();
			}
	
			Query query = em.createQuery("SELECT c FROM Contact c WHERE c.useruserId = " + id);
			contacts = query.getResultList();
			
			em.close();
			emf.close();
		 }
		 catch(Exception ex){
			 System.out.println(ex.getMessage());
			 throw ex;
		 }
		
		return contacts;
	 }
	 
	 public void saveContact(Contact contact){
		 
		 try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("contactListPU");
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
			em.persist(contact);
			tx.commit();
			
			em.close();
			emf.close();
		 }
		 catch(Exception ex)
		 {
			 System.out.println(ex.getMessage());
			 throw ex;
		 }
	 }
	 
	 public void updateContact(Contact contact){
		 try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("contactListPU");
			EntityManager em = emf.createEntityManager();
			
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
			em.merge(contact);
			tx.commit();
			
			em.close();
			emf.close();
		 }
		 catch(Exception ex)
		 {
			 System.out.println(ex.getMessage());
			 throw ex;
		 }
	 }

	 public void deleteContact(Integer contactId){
		 try{
			 EntityManagerFactory emf = Persistence.createEntityManagerFactory("contactListPU");
			 EntityManager em = emf.createEntityManager();
			 EntityTransaction tx = em.getTransaction();
			
			 tx.begin();
			 em.remove(em.find(Contact.class, contactId));
			 tx.commit();
			
			 em.close();
			 emf.close();
		 }
		 catch(Exception ex)
		 {
			 System.out.println(ex.getMessage());
			 throw ex;
		 }
	 }
}
