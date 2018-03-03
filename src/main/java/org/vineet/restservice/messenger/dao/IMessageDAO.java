package org.vineet.restservice.messenger.dao;

import java.util.List;

import org.vineet.restservice.messenger.model.Messages;


public interface IMessageDAO {
	
	List<Messages> getAllMessages() ;
	Messages getMessage(long id);
	Messages addMessage(Messages message);
	Messages updateMessage(Messages OldMessage, Messages NewMessage);
	Messages updateMessage(long id, Messages NewMessage);
	void removeMessage(long id);

}
