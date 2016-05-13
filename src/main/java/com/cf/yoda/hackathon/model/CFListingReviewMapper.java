package com.cf.yoda.hackathon.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

public class CFListingReviewMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		CFListingReviews cflr = new CFListingReviews();
		
		cflr.setReviewId(rs.getLong("review_id"));
		
		cflr.setReviewComments(rs.getString("review_comments"));
		cflr.setCreatedBy(rs.getString("created_by"));
		cflr.setCreatedOn(rs.getDate("created_on"));

		cflr.setRating(rs.getString("rating"));
		cflr.setPid(rs.getLong("pid"));
		
		return cflr;
	}
}
