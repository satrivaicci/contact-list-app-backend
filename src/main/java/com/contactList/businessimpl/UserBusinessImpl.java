package com.contactList.businessimpl;

import com.contactList.business.UserBusiness;
import com.contactList.dao.UserDAO;
import com.contactList.entity.User;
import com.google.inject.Inject;


public class UserBusinessImpl implements UserBusiness {
	
	private UserDAO userDAO;
	
	@Inject
	public UserBusinessImpl(UserDAO userDAO){
		this.userDAO = userDAO;
	}
	    
	public User getUser(Integer userId){
		return userDAO.getUser(userId);
	}
}
