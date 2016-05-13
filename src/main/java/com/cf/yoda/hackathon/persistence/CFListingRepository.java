package com.cf.yoda.hackathon.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cf.yoda.hackathon.model.CFListing;

@Repository
public interface CFListingRepository extends CrudRepository<CFListing, Long>{
	
	
	@Query(value = "select count(1) from (select id from realestate_listing_user_filters as rluf join realestate_listing_lead_source as rls on rluf.pool_id = rls.source_id where listing_id=?1) T", nativeQuery = true)
	long fetchNumberOfInterestsShown(String listingId);
	
	
	 
	
	
}
