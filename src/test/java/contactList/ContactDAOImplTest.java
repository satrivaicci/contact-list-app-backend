package contactList;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.contactList.daoimpl.ContactDAOImpl;
import com.contactList.entity.Contact;

public class ContactDAOImplTest {

	@Test
	public void testCreate() {
	    ContactDAOImpl contactDAOImpl = new ContactDAOImpl();
	    
	    Contact contact = new Contact();
	    contact.setName("New Contact");
	    contact.setUseruserId(1);
	    
	    Integer oldSize = contactDAOImpl.getContactsByUserId(null, 1).size();
	    contactDAOImpl.saveContact(contact);
	    Integer newSize = contactDAOImpl.getContactsByUserId(null, 1).size();
		  
	    System.out.println(oldSize);
	    System.out.println(newSize);
	    assertTrue (newSize == (oldSize + 1));
	}
	
	@Test
	public void testDelete() {
	    ContactDAOImpl contactDAOImpl = new ContactDAOImpl();
	    
	    List<Contact> contacts = contactDAOImpl.getContactsByUserId(null, 1);
	    
	    Contact lastContact = contacts.get(contacts.size()-1);
	    
	    contactDAOImpl.deleteContact(lastContact.getContactId());
	    
	    Integer oldSize = contacts.size();
	    Integer newSize = contactDAOImpl.getContactsByUserId(null, 1).size();
		  
	    assertTrue ((newSize + 1) == oldSize);
	}
	
	@Test
	public void testUpdate() {
		
		DateFormat dateFormat = new SimpleDateFormat("dd HH:mm:ss");
		Date date = new Date();
		String timeStamp = dateFormat.format(date);
		
	    ContactDAOImpl contactDAOImpl = new ContactDAOImpl();
	    
	    List<Contact> contacts = contactDAOImpl.getContactsByUserId(null, 1);
	    
	    Contact contact = contacts.get(contacts.size()-1);
	    contact.setName("Contact Updated" + timeStamp);
	    
	    contactDAOImpl.updateContact(contact);
	   
	    Contact updatedContact = contactDAOImpl.getContact(contact.getContactId());
	   
		System.out.print(updatedContact.getName());
	    
		assertEquals(updatedContact.getName(), "Contact Updated" + timeStamp);
	}

}
