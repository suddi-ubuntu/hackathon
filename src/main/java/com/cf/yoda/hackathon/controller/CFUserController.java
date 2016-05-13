package com.cf.yoda.hackathon.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cf.yoda.hackathon.model.CFUser;
import com.cf.yoda.hackathon.persistence.CFUserRepository;

@RestController
@RequestMapping("/yoda/user")
public class CFUserController extends AbstractYodaController{
	  
	
	/**
	   * GET /create  --> Create a new user and save it in the database.
	   */
	  @RequestMapping("/create")
	  @ResponseBody
	  public String create(String email, String name) {
	    CFUser user = null;
	    try {
	      user = new CFUser(email, name);
	      getUserRepository().save(user);
	    }
	    catch (Exception ex) {
	      return "Error creating the user: " + ex.toString();
	    }
	    return "User succesfully created! (id = " + user.getId() + ")";
	  }
	  
	  /**
	   * GET /delete  --> Delete the user having the passed id.
	   */
	  @RequestMapping("/delete")
	  @ResponseBody
	  public String delete(long id) {
	    try {
	    	CFUser user = new CFUser(id);
	      getUserRepository().delete(user);
	    }
	    catch (Exception ex) {
	      return "Error deleting the user:" + ex.toString();
	    }
	    return "User succesfully deleted!";
	  }
	  
	  /**
	   * GET /get-by-email  --> Return the id for the user having the passed
	   * email.
	   */
	  @RequestMapping("/get-by-email")
	  @ResponseBody
	  public String getByEmail(String email) {
	    String userId;
	    try {
	    	CFUser user = getUserRepository().findByEmail(email);
	      userId = String.valueOf(user.getId());
	    }
	    catch (Exception ex) {
	      return "User not found";
	    }
	    return "The user id is: " + userId;
	  }
	  
	  
	  
	  /**
	   * GET /get-by-email  --> Return the id for the user having the passed
	   * email.
	   */
	  @RequestMapping("/{id}")
	  @ResponseBody
	  public CFUser getById(@PathVariable("id")Long id) {
	    CFUser user = null;
	    try {
	    	  user = getUserRepository().findOne(id);
	    }
	    catch (Exception ex) {
	      return null;
	    }
	    return  user;
	  }
	  
	  /**
	   * GET /update  --> Update the email and the name for the user in the 
	   * database having the passed id.
	   */
	  @RequestMapping("/update")
	  @ResponseBody
	  public String updateUser(long id, String email, String name) {
	    try {
	    	CFUser user = getUserRepository().findOne(id);
	      user.setEmail(email);
	      user.setName(name);
	      getUserRepository().save(user);
	    }
	    catch (Exception ex) {
	      return "Error updating the user: " + ex.toString();
	    }
	    return "User succesfully updated!";
	  }

	  // Private fields

	  	
	
	

}
