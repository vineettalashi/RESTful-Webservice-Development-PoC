package org.vineet.restservice.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.vineet.restservice.messenger.model.Messages;
import org.vineet.restservice.messenger.service.MessageDAOService;

@Path("/messages")
public class MessagesResource {

	
	MessageDAOService service = new MessageDAOService();


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	 public List<Messages> getAllMessages()
	 {
		 return service.getAllMessages();
	 }
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	 public Messages addMesssage(Messages msg)
	 {	
		 System.out.println("Hello Yaar");
		 return service.addMessage(msg);
	 }
	
	@PUT
	@Path("/{messageID}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	 public Messages updateMesssage(@PathParam("messageID") long id, Messages updatedmsg)
	 {
		 return service.updateMessage(id, updatedmsg);
	 }
	

	@DELETE
	@Path("/{messageID}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	 public void deleteMesssage(@PathParam("messageID") long id)
	 {
		 service.removeMessage(id);
	 }
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageID}")
	public Messages getMessage(@PathParam("messageID") long id)
	{
		return service.getMessage(id);
		
		
	}
	
	
}
