package com.cf.yoda.hackathon.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "realestate_review_user_action")
public class CFRealestateReviewUserAction {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name = "ua_id")
	  private long uaId;
	  
	  @Column(name = "review_id")
	  private long reviewId;
	  
	  @Column(name = "created_by")
	  private String createdBy;
	  
	  @Column(name = "created_on")
	  private Date createdOn;
	  
	  @Column(name = "action")
	  private String action;


	  // Public methods
	  
	  public CFRealestateReviewUserAction() { }

	  public CFRealestateReviewUserAction(long uaId) { 
	    this.uaId = uaId;
	  }

	public long getUaId() {
		return uaId;
	}

	public void setUaId(long uaId) {
		this.uaId = uaId;
	}

	public long getReviewId() {
		return reviewId;
	}

	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}
