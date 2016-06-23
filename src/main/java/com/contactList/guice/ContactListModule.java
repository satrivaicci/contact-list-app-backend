package com.contactList.guice;

import com.contactList.business.ContactBusiness;
import com.contactList.business.UserBusiness;
import com.contactList.businessimpl.ContactBusinessImpl;
import com.contactList.businessimpl.UserBusinessImpl;
import com.contactList.dao.ContactDAO;
import com.contactList.dao.UserDAO;
import com.contactList.daoimpl.ContactDAOImpl;
import com.contactList.daoimpl.UserDAOImpl;
import com.google.inject.AbstractModule;

public class ContactListModule extends AbstractModule {
	  @Override 
	  protected void configure() {
	    bind(UserDAO.class).to(UserDAOImpl.class);
	    bind(ContactDAO.class).to(ContactDAOImpl.class);
	    bind(ContactBusiness.class).to(ContactBusinessImpl.class);
	    bind(UserBusiness.class).to(UserBusinessImpl.class);
	  }
	}
