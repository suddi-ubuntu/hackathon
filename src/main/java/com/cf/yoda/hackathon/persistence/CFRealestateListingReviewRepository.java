package com.cf.yoda.hackathon.persistence;


import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import com.cf.yoda.hackathon.model.CFRealestateListingReview;


@Transactional
public interface CFRealestateListingReviewRepository extends CrudRepository<CFRealestateListingReview, Long> {

	  public CFRealestateListingReview findBylrId(Long lrId);
	  public List<CFRealestateListingReview> findBylistingId(String listingId);
}
