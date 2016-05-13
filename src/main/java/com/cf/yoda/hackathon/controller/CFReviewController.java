package com.cf.yoda.hackathon.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cf.yoda.hackathon.model.CFListingReviews;
import com.cf.yoda.hackathon.model.CFRealestateListingReview;
import com.cf.yoda.hackathon.model.CFRealestateReview;

@RestController
@RequestMapping("/yoda/review")
public class CFReviewController extends AbstractYodaController {

	

	@RequestMapping("/{reviewId}/upvote/{userId}")
	@ResponseBody
	public String upvoteReview(@PathVariable("reviewId") long reviewId, @PathVariable("userId") String userId) {
		System.out.println("upvoting:" + reviewId);
		getDefaultRepository().upvoteReview(reviewId, userId);
		return getUpvoteCount(reviewId)+"";

	}

	@RequestMapping("/{reviewId}/downvote/{userId}")
	@ResponseBody
	public long downvoteReview(@PathVariable("reviewId") long reviewId, @PathVariable("userId") String userId) {
		System.out.println("downvoting:" + reviewId);
		getDefaultRepository().downvoteReview(reviewId, userId);
		return getDownvoteCount(reviewId);

	}

	@RequestMapping("/{reviewId}/upvotes")
	@ResponseBody
	public long getUpvoteCount(@PathVariable("reviewId") long reviewId) {
		return getDefaultRepository().getUpvoteCount(reviewId);
	}

	@RequestMapping("/{reviewId}/downvotes")
	@ResponseBody
	public long getDownvoteCount(@PathVariable("reviewId") long reviewId) {
		return getDefaultRepository().getDownvoteCount(reviewId);
	}
	
	
	@RequestMapping("listingId/{id}")
	 @ResponseBody
	 public List<CFListingReviews> getById(@PathVariable("id")String listingId) {
		List<CFListingReviews> reviews = new ArrayList<CFListingReviews>();
		
		 try {
			 reviews = getDefaultRepository().getReviewsForListing(listingId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return reviews;
		}
		 
		 return reviews;
	}

	@RequestMapping("/create")
	 @ResponseBody
	 public void create(@RequestParam("listingId")String listingId, @RequestParam("createdBy")String createdBy,
			 @RequestParam("reviewComment")String reviewComment,@RequestParam("rating")String rating ) 
	{
		CFRealestateReview cfrr = new CFRealestateReview();
		cfrr.setCreatedBy(createdBy);
		cfrr.setRating(rating);
		cfrr.setReviewComments(reviewComment);
		getRealestateReviewRepository().save(cfrr);
		List<CFListingReviews> reviews = getDefaultRepository().getReviews(createdBy, reviewComment, rating);
		CFRealestateListingReview cfr = new CFRealestateListingReview();
		cfr.setPropertyId(listingId);
		cfr.setListingId(listingId);
		cfr.setReviewId(reviews.get(0).getReviewId());
		getRealestateListingReviewRepository().save(cfr);
	}
}
