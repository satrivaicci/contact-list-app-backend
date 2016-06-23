package com.contactList.rest;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.contactList.business.UserBusiness;
import com.contactList.businessimpl.UserBusinessImpl;

import com.contactList.entity.*;
import com.contactList.guice.ContactListModule;
import com.google.inject.Guice;

import com.google.inject.Injector;

@Path("users")
public class RESTfulUser {
	

	private Injector injector = Guice.createInjector(new ContactListModule());
	private UserBusiness userBusiness = injector.getInstance(UserBusinessImpl.class);
	
	@GET
	@Path("{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("userId") Integer userId){
		try{
			User user = userBusiness.getUser(userId);
			return Response.status(Response.Status.OK).entity(user).build();
		}
		catch(Exception ex){
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Could not get User with userId").build();
		}
		
    }

	
}
