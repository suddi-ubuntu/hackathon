package com.cf.yoda.hackathon.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.cf.yoda.hackathon.model.CFListingReviewMapper;
import com.cf.yoda.hackathon.model.CFListingReviews;
import com.cf.yoda.hackathon.model.CFListingReviewsMapper;
import com.cf.yoda.hackathon.model.ListingStat;

@Repository
public class DefaultRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println("setDataSource" + dataSource);
	}

	public List<String> getUserIdsForListing(String listingId) {

		String sql = "select distinct email_id from realestate_listing_user_filters as rluf join realestate_listing_lead_source as rls on rluf.pool_id = rls.source_id  where listing_id=?";

		List<String> emailIds = jdbcTemplate.queryForList(sql, new String[] { listingId }, String.class);
		return emailIds;
	}

	public List<CFListingReviews> getReviewsForListing(String listingId) {

		String sql = "select * from realestate_listing_review as rlr join realestate_review as rr on rlr.review_id = rr.review_id  where listing_id=?";

		List<CFListingReviews> reviews = jdbcTemplate.query(sql, new String[] { listingId },
				new CFListingReviewsMapper());
		return reviews;
	}
	
	public List<CFListingReviews> getReviews(String createdBy,
			 String reviewComment,String rating) {

		String sql = "select * from realestate_review where review_comments=? and created_by=? and rating=?";

		List<CFListingReviews> reviews = jdbcTemplate.query(sql, new String[] { reviewComment, createdBy, rating},
				new CFListingReviewMapper());
		return reviews;
	}

	
	
	
	public List<ListingStat> getInterestCount(String listingId) {
		String sql = " select   listing_id ,count(1) as num_interest from realestate_listing_user_filters as rluf join realestate_listing_lead_source as rls on rluf.pool_id = rls.source_id "
				+ " where email_id in ("
				+ " select distinct email_id from realestate_listing_user_filters as rluf join realestate_listing_lead_source as rls on rluf.pool_id = rls.source_id"
				+ " where listing_id=? )" + "group by listing_id" + " order by num_interest desc";
		List<ListingStat> result = jdbcTemplate.query(sql, new String[] { listingId }, new RowMapper<ListingStat>() {

			public ListingStat mapRow(ResultSet resultSet, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				return new ListingStat(resultSet.getString(1), resultSet.getInt(2));
			}
		});
		return result;
	}

	public void upvoteReview(long reviewId, String userId) {
		String sql = "insert into realestate_review_user_action(review_id,user_action,created_by) values (?,'upvote',?) ";
		jdbcTemplate.update(sql, new Object[] { reviewId, userId });
	}

	public void downvoteReview(long reviewId, String userId) {
		String sql = "insert into realestate_review_user_action(review_id,user_action,created_by) values (?,'downvote',?) ";
		jdbcTemplate.update(sql, new Object[] { reviewId, userId });
	}

	public Long getUpvoteCount(long reviewId) {
		String sql = "select count(1) from realestate_review_user_action where review_id=? and user_action='upvote'";
		Long count = jdbcTemplate.queryForLong(sql, new Long[] { reviewId });
		return count;
	}

	public long getDownvoteCount(long reviewId) {
		String sql = "select count(1) from realestate_review_user_action where review_id=? and user_action='downvote'";
		Long count = jdbcTemplate.queryForLong(sql, new Long[] { reviewId });
		return count;
	}

	public long getNumViewsGlobalWithinLastNDays(String listingId, int days) {
		String sql = "select   count(email_id )  from realestate_listing_user_filters as rluf join "
				+ " realestate_listing_lead_source as rls " + " on rluf.pool_id = rls.source_id "
				+ " where added_on between date_sub(now(),INTERVAL ? DAY) and NOW() " + " and listing_id=? "
				+ " group by listing_id ";

		Long count = jdbcTemplate.queryForLong(sql, new Object[] { Integer.valueOf(days), listingId });
		return count;
	}

	public ListingStat getStarStats(String id) {
		String sql = " select rating,count(1) from realestate_review as rr join realestate_listing_review as rlr "
				+ " on rr.review_id=rlr.review_id " + " where listing_id=? " + " group by listing_id , rating ";
		final ListingStat listingStat = new ListingStat(id);
		jdbcTemplate.query(sql,new String[]{id}, new RowCallbackHandler(){

			public void processRow(ResultSet rs) throws SQLException {
				int starVal = rs.getInt(1);
				int count = rs.getInt(2);
				switch (starVal) {
				case 1:
					listingStat.setOneStartCount(count);
					break;
					
				case 2:
					listingStat.setTwoStartCount(count);
					break;

					
				case 3:
					listingStat.setThreeStartCount(count);
					break;

					
				case 4:
					listingStat.setFourStartCount(count);
					break;

				case 5:
					listingStat.setFiveStartCount(count);
					break;


				default:
					break;
				}
				 
			}});

		return listingStat;
	}

}
