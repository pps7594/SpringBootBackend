package com.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.theObject;
import com.backend.repository.theObjRepo;


@Service
public class theObjService {

	@Autowired
	private theObjRepo repository;
	
	/* GET */
	public List<theObject> getObjectList(){
		//code
		List<theObject> objList = new ArrayList<>();
		repository.findAll().forEach(objList::add);
		return objList;
	}
	
	public theObject getObject(String id){
		//code
		return repository.findById(id).orElse(null);
	}
	
	
	/* POST*/
	public void insertTheObject(theObject obj) {
		repository.save(obj);
	}
	
	public void updateTheObject(theObject obj) {
		theObject newObj = repository.findById(obj.getId()).get();
		
		newObj.setDescription(obj.getDescription());
		newObj.setTheFile(obj.getTheFile());
		repository.save(newObj);
	}
	
	public void deleteTheObject(theObject obj) {
		repository.delete(obj);
	}	
}
