package com.cf.yoda.hackathon.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "realestate_review")
public class CFRealestateReview {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name = "review_id")
	  private long reviewId;

	  @Column(name = "review_comments")
	  private String reviewComments;

	  @Column(name = "created_by")
	  private String createdBy;

	  @Column(name = "created_on")
	  private Date createdOn;

	  @Column(name = "rating")
	  private String rating;

	  @Column(name = "pid")
	  private long pid;

	  // Public methods
	  
	  public CFRealestateReview() { }

	  public CFRealestateReview(long reviewId) { 
	    this.reviewId = reviewId;
	  }

	public long getReviewId() {
		return reviewId;
	}

	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}

	public String getReviewComments() {
		return reviewComments;
	}

	public void setReviewComments(String reviewComments) {
		this.reviewComments = reviewComments;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}
}
