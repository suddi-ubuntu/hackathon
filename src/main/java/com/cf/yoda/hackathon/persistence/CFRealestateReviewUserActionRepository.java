package com.cf.yoda.hackathon.persistence;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import com.cf.yoda.hackathon.model.CFRealestateReviewUserAction;

@Transactional
public interface CFRealestateReviewUserActionRepository extends CrudRepository<CFRealestateReviewUserAction, Long> {
	
	  public CFRealestateReviewUserAction findByuaId(Long uaId);

}
