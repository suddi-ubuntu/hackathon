package com.cf.yoda.hackathon.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cf.yoda.hackathon.model.CFUser;
import com.cf.yoda.hackathon.model.ListingStat;

@RestController
@RequestMapping("/yoda/listing")
public class CFListingController extends AbstractYodaController{

	
	 /**
	   * GET /get-by-email  --> Return the id for the user having the passed
	   * email.
	   */
	  @RequestMapping("/{id}/numInterests")
	  @ResponseBody
	  public long getNumInterests(@PathVariable("id")String id) {
		  long count=0;
	    try {
	    	  count = getListingRepository().fetchNumberOfInterestsShown(id);
	    }
	    catch (Exception ex) {
	    	ex.printStackTrace();
	      return count;
	    }
	    return count;
	  }
	  
	  
	  /**
	   * GET /get-by-email  --> Return the id for the user having the passed
	   * email.
	   */
	  @RequestMapping("/{id}/interestedUserEmailIds")
	  @ResponseBody
	  public List<String> getInterestedUsersEmailId(@PathVariable("id")String id) {
		  List<String> emailIds;
	    try {
	    	emailIds = getDefaultRepository().getUserIdsForListing(id);
	    }
	    catch (Exception ex) {
	    	ex.printStackTrace();
	      return emailIds= new ArrayList<String>();
	    }
	    return emailIds;
	  }
	  
	  
	  /**
	   * GET /get-by-email  --> Return the id for the user having the passed
	   * email.
	   */
	  @RequestMapping("/{id}/userGroupStats")
	  @ResponseBody
	  public List<ListingStat> getUserGroupStats(@PathVariable("id")String id) {
		  List<ListingStat> userGroupStats;
	    try {
	    	userGroupStats = getDefaultRepository().getInterestCount(id);
	    }
	    catch (Exception ex) {
	    	ex.printStackTrace();
	      return userGroupStats= new ArrayList<ListingStat>();
	    }
	    return userGroupStats;
	  }
	  
	  
	  
	  /**
	   * GET /get-by-email  --> Return the id for the user having the passed
	   * email.
	   */
	  @RequestMapping("/{id}/numViews/{days}")
	  @ResponseBody
	  public long getNumInterests(@PathVariable("id")String id,@PathVariable("days")int days) {
		  long count=0;
	    try {
	    	  count = getDefaultRepository().getNumViewsGlobalWithinLastNDays(id,days);
	    }
	    catch (Exception ex) {
	    	ex.printStackTrace();
	      return count;
	    }
	    return count;
	  }
	  
	  
	  
	  /**
	   * GET /get-by-email  --> Return the id for the user having the passed
	   * email.
	   */
	  @RequestMapping("/{id}/starStats")
	  @ResponseBody
	  public ListingStat getStarStats(@PathVariable("id")String id) {
		  ListingStat starStats=new ListingStat(id);
	    try {
	    	starStats = getDefaultRepository().getStarStats(id);
	    }
	    catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	    return starStats;
	  }
	  
	  
	
	
	  
	     
}
