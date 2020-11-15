package com.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.theObject;
import com.backend.service.theObjService;



@RestController
public class insertController {
	@Autowired
	private theObjService service;
	
	/*
	 * POST
	 */
	//Insert
	@RequestMapping("/insertTheObject")
	public void insertTheObject(String id, String description, String theFile){		
		//Simple validation - check PK no duplicate
		theObject obj = service.getObject(id);
		
		if(obj == null) {
			service.insertTheObject(new theObject(id, description, theFile));
		}
		else {
			System.out.println("Existed Object");
			return;
		}
	}
	
	//Update
	@RequestMapping("/updateTheObject")
	public void updateTheObject(String id, String description, String theFile){				 
		//Simple validation - check PK exists, actually is useless
		theObject obj = service.getObject(id);
		
		if(obj != null) {
			service.updateTheObject(new theObject(id, description, theFile));
		}
		else {
			System.out.println("New Object");
			//If then we do insert
			service.insertTheObject(new theObject(id, description, theFile));
			return;
		}
	}
	
	//Delete
	@RequestMapping("/deleteTheObject")
	public void deleteTheObject(String id){				 
		//Simple validation - check PK exists then delete
		theObject obj = service.getObject(id);
		
		if(obj != null) {
			service.deleteTheObject(obj);
		}
		else {
			System.out.println("No such object");
			return;
		}
	}
}
