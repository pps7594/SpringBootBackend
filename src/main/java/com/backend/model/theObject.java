package com.backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class theObject {
	@Id
	private String id;
	private String description;
	private String theFile;
	
	public theObject() {
	}
	
	public theObject(String id, String description, String theFile) {
		super();
		this.id = id;
		this.description = description;
		this.theFile = theFile;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTheFile() {
		return theFile;
	}
	public void setTheFile(String theFile) {
		this.theFile = theFile;
	}
	
	
}
