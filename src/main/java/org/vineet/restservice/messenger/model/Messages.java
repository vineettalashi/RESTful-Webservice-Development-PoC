package org.vineet.restservice.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Messages {
	
	
	String message;
	long id;
	String creation;
	String Author;
	
	
	public Messages() {
	}
	
	
	
	public Messages(String message, long id, String author) {
		this.message = message;
		this.id = id;
		this.Author = author;
		this.creation = new Date().toString();
	}
	
	public Messages(String message, String author) {
		this.message = message;
		this.Author = author;
		this.creation = new Date().toString();
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getCreation() {
		return creation;
	}
	public void setCreation(String creation) {
		this.creation = creation;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}


}
