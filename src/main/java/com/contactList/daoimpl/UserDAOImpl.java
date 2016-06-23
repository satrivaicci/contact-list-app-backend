package com.contactList.daoimpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.contactList.dao.UserDAO;
import com.contactList.entity.User;
 

public class UserDAOImpl implements UserDAO {
	
	public UserDAOImpl(){	
	}
	
	public User getUser(Integer userId){
		
		User user = null;
		
		try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("contactListPU");
			EntityManager em = emf.createEntityManager();
			
			Query query = em.createQuery("SELECT u FROM User u WHERE u.userId = " + userId);
			user = (User)query.getSingleResult();
			
			em.close();
			emf.close();
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			throw ex;
		}
		
		return user;
	}
}
