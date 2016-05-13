package com.cf.yoda.hackathon.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cf.yoda.hackathon.model.CFListingGroup;

@Repository
public interface CFListingGroupRepository extends CrudRepository<CFListingGroup, Long>{

}
