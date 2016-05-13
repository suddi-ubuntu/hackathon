package com.cf.yoda.hackathon.persistence;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cf.yoda.hackathon.model.CFUser;

@Transactional
public interface CFUserRepository extends CrudRepository<CFUser, Long>{

	
	/**
	   * This method will find an User instance in the database by its email.
	   * Note that this method is not implemented and its working code will be
	   * automagically generated from its signature by Spring Data JPA.
	   */
	  public CFUser findByEmail(String email);
	  
	  

}
