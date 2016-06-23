package com.contactList.business;

import java.util.List;

import com.contactList.entity.Contact;

public interface ContactBusiness {
	public Contact getContact(Integer contactId);
	public List<Contact> getContactsByUserId(String username, Integer userId);
	public void saveContact(Contact contact);
	public void updateContact(Contact contact);
	public void deleteContact(Integer contactId);
}
