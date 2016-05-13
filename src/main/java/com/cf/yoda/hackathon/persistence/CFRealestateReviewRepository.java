package com.cf.yoda.hackathon.persistence;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import com.cf.yoda.hackathon.model.CFRealestateListingReview;
import com.cf.yoda.hackathon.model.CFRealestateReview;

@Transactional
public interface CFRealestateReviewRepository extends CrudRepository<CFRealestateReview, Long> {
	
	  public CFRealestateListingReview findByreviewId(Long reviewId);

}
