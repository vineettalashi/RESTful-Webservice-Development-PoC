package org.vineet.restservice.messenger.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.vineet.restservice.messenger.dao.IMessageDAO;
import org.vineet.restservice.messenger.database.DatabaseConnectionFactory;
import org.vineet.restservice.messenger.model.Messages;



public class MessageDAOService implements IMessageDAO{
	
	private Connection conn = DatabaseConnectionFactory.getDBConnection();
	private Statement stmt = null;
	private ResultSet rs = null;
	private Messages messages;
	

	public MessageDAOService() {
		
		
	}

	public List<Messages> getAllMessages() 
	{	
		/*ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(new ArrayList<Message>(messages.values()).get(0)));*/
		List<Messages> messagesList = new ArrayList<Messages>(); 
		
		try{
			stmt = conn.createStatement();
			 rs = stmt.executeQuery("Select * from Messages");
			 
			while(rs.next())
			{	
				messages = new Messages();
				messages.setMessage(rs.getString("message"));
				messages.setAuthor(rs.getString("Author"));
				messages.setId(Long.parseLong(rs.getString("id")));
				messages.setCreation(rs.getString("creation"));
				
				messagesList.add(messages);
			}
			
		  }
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return messagesList;
		
	}

	@Override
	public Messages getMessage(long id) {
		try{
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery("Select * from Messages where id ="+ id);
			 {	
				 while(rs.next())
					{	
						messages = new Messages();
						messages.setMessage(rs.getString("message"));
						messages.setAuthor(rs.getString("Author"));
						messages.setId(Long.parseLong(rs.getString("id")));
						messages.setCreation(rs.getString("creation"));
						return messages;
					}
					
			 }
		  }
				catch (SQLException e) {
					
					e.printStackTrace();
				}
		
		return null;
	}


	public Messages addMessage(Messages message) {
		
		try{
			 PreparedStatement pstmt = conn.prepareStatement("insert into Messages (message,Author,ID,creation) values ('"+message.getMessage()+"','"+message.getAuthor()+"',"+message.getId()+",'"+message.getCreation()+"')");
			 pstmt.execute();
			
		  }
				catch (SQLException e) {
					
					e.printStackTrace();
				}
		
		return null;
	}

	@Override
	public Messages updateMessage(Messages OldMessage, Messages NewMessage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Messages updateMessage(long id, Messages NewMessage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeMessage(long id) {

		try{
			 PreparedStatement ps = conn.prepareStatement("DELETE FROM Messages WHERE id="+id);
			 ps.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
