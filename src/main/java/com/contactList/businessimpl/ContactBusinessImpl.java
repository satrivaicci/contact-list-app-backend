package com.contactList.businessimpl;

import java.util.List;

import com.contactList.business.ContactBusiness;
import com.contactList.dao.ContactDAO;
import com.contactList.entity.Contact;
import com.google.inject.Inject;

public class ContactBusinessImpl implements ContactBusiness {
	
	private ContactDAO contactDAO;

	@Inject
	public ContactBusinessImpl(ContactDAO contactDAO){
		this.contactDAO = contactDAO;
	}
	    
	public Contact getContact(Integer contactId){
		return contactDAO.getContact(contactId);
	}
	public List<Contact> getContactsByUserId(String username, Integer userId){
		return contactDAO.getContactsByUserId(username, userId);
	}
	
	public void saveContact(Contact contact){
		contactDAO.saveContact(contact);
	}
	
	public void updateContact(Contact contact){
		contactDAO.updateContact(contact);
	}
	
	public void deleteContact(Integer contactId){
		contactDAO.deleteContact(contactId);
	}
}
