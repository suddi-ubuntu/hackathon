package com.cf.yoda.hackathon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cf.yoda.hackathon.persistence.CFListingGroupRepository;
import com.cf.yoda.hackathon.persistence.CFListingRepository;
import com.cf.yoda.hackathon.persistence.CFRealestateListingReviewRepository;
import com.cf.yoda.hackathon.persistence.CFRealestateReviewRepository;
import com.cf.yoda.hackathon.persistence.CFRealestateReviewUserActionRepository;
import com.cf.yoda.hackathon.persistence.CFUserRepository;
import com.cf.yoda.hackathon.persistence.DefaultRepository;

@Service
public abstract class AbstractYodaService  {
	
@Autowired	
private CFListingGroupRepository listingGroupRepository;
@Autowired
private CFUserRepository userRepository;
@Autowired
private CFListingRepository listingRepository;
@Autowired
private CFRealestateListingReviewRepository realestateListingReviewRepository;
@Autowired
private CFRealestateReviewRepository realestateReviewRepository;
@Autowired
private CFRealestateReviewUserActionRepository realestateReviewUserActionRepository;

@Autowired
private DefaultRepository defaultRepository;



public AbstractYodaService() {
	super();
	// TODO Auto-generated constructor stub
}
public CFListingGroupRepository getListingGroupRepository() {
	return listingGroupRepository;
}
public void setListingGroupRepository(CFListingGroupRepository listingGroupRepository) {
	this.listingGroupRepository = listingGroupRepository;
}
public CFUserRepository getUserRepository() {
	return userRepository;
}
public void setUserRepository(CFUserRepository userRepository) {
	this.userRepository = userRepository;
}
public CFListingRepository getListingRepository() {
	return listingRepository;
}
public void setListingRepository(CFListingRepository listingRepository) {
	this.listingRepository = listingRepository;
}
public CFRealestateListingReviewRepository getRealestateListingReviewRepository() {
	return realestateListingReviewRepository;
}
public void setRealestateListingReviewRepository(
		CFRealestateListingReviewRepository realestateListingReviewRepository) {
	this.realestateListingReviewRepository = realestateListingReviewRepository;
}
public CFRealestateReviewRepository getRealestateReviewRepository() {
	return realestateReviewRepository;
}
public void setRealestateReviewRepository(CFRealestateReviewRepository realestateReviewRepository) {
	this.realestateReviewRepository = realestateReviewRepository;
}
public CFRealestateReviewUserActionRepository getRealestateReviewUserActionRepository() {
	return realestateReviewUserActionRepository;
}
public void setRealestateReviewUserActionRepository(
		CFRealestateReviewUserActionRepository realestateReviewUserActionRepository) {
	this.realestateReviewUserActionRepository = realestateReviewUserActionRepository;
}
public DefaultRepository getDefaultRepository() {
	return defaultRepository;
}
public void setDefaultRepository(DefaultRepository defaultRepository) {
	this.defaultRepository = defaultRepository;
}


}
