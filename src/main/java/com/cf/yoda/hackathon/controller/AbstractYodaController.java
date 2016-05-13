package com.cf.yoda.hackathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cf.yoda.hackathon.service.AbstractYodaService;
import com.cf.yoda.hackathon.service.CFListingGroupService;
import com.cf.yoda.hackathon.service.CFListingService;
import com.cf.yoda.hackathon.service.CFReviewService;
import com.cf.yoda.hackathon.service.CFUserService;


@RestController
public abstract class   AbstractYodaController extends AbstractYodaService{
	
	@Autowired
	private CFListingGroupService listingGroupService;
	
	@Autowired
	private CFListingService listingService;
	
	
	@Autowired
	private CFUserService userService;
	
	@Autowired
	private CFReviewService reviewService;
	
	
	
	
	
	public AbstractYodaController() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CFListingGroupService getListingGroupService() {
		return listingGroupService;
	}
	public void setListingGroupService(CFListingGroupService listingGroupService) {
		this.listingGroupService = listingGroupService;
	}
	public CFListingService getListingService() {
		return listingService;
	}
	public void setListingService(CFListingService listingService) {
		this.listingService = listingService;
	}
	public CFUserService getUserService() {
		return userService;
	}
	public void setUserService(CFUserService userService) {
		this.userService = userService;
	}
	public CFReviewService getReviewService() {
		return reviewService;
	}
	public void setReviewService(CFReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	
	

}
