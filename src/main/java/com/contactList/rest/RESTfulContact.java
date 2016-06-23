package com.contactList.rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.contactList.business.ContactBusiness;
import com.contactList.businessimpl.ContactBusinessImpl;
import com.contactList.entity.Contact;
import com.contactList.guice.ContactListModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

@Path("contacts")
public class RESTfulContact {
	
	private Injector injector = Guice.createInjector(new ContactListModule());
	private ContactBusiness contactBusiness = injector.getInstance(ContactBusinessImpl.class);
	
	@GET
	@Path("/{contactId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContact(@PathParam("contactId") Integer contactId){
		
		try{
			Contact contact = contactBusiness.getContact(contactId);
			return Response.status(Response.Status.OK).entity(contact).build();
		}
		catch(Exception ex){
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Could not get contact").build();
		}
    }
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response contactsByUserId(@QueryParam("userName") String username, @QueryParam("userId") Integer userId){
		
		if(username == null && userId == null)
			return Response.status(Response.Status.BAD_REQUEST).entity("Username or UserId must be specified").build();
		
		try{
			List<Contact> contacts = contactBusiness.getContactsByUserId(username, userId);
			return Response.status(Response.Status.OK).entity(contacts).build();
		}
		catch(Exception ex){
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Contacts could not be retrieved").build();
		}
    }
	
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveContact(Contact contact){
		
		try{
			contactBusiness.saveContact(contact);
			return Response.status(Response.Status.OK).build();
		}
		catch(Exception ex){
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Contact was NOT saved").build();
		}
    }
	
	@PUT
	@Path("{contactId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateContact(@PathParam("contactId") Integer contactId, Contact contact){
		try{
			contactBusiness.updateContact(contact);
			return Response.status(Response.Status.OK).build();
		}catch(Exception ex){
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Contact was NOT updated").build();
		}
    }
	
	@DELETE
	@Path("{contactId}")
    public Response deleteContact(@PathParam("contactId") Integer contactId){
		try{
			contactBusiness.deleteContact(contactId);
			return Response.status(Response.Status.OK).build();
		}
		catch(Exception ex){
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Contact was NOT deleted").build();
		}
		
    }
	
	
}
