package com.cf.yoda.hackathon.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "realestate_listing_review")
public class CFRealestateListingReview {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name = "lr_id")
	  private long lrId;

	  @Column(name = "review_id")
	  private long reviewId;
	  
	  @Column(name = "listing_id")
	  private String listingId;

	  @Column(name = "property_id")
	  private String propertyId;


	  // Public methods
	  
	  public CFRealestateListingReview() { }

	  public CFRealestateListingReview(long lrId) { 
	    this.lrId = lrId;
	  }

	public long getLr_id() {
		return lrId;
	}

	public long getLrId() {
		return lrId;
	}

	public void setLrId(long lrId) {
		this.lrId = lrId;
	}

	public long getReviewId() {
		return reviewId;
	}

	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}

	public String getListingId() {
		return listingId;
	}

	public void setListingId(String listingId) {
		this.listingId = listingId;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

}
