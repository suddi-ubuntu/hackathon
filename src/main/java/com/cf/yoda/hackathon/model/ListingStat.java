package com.cf.yoda.hackathon.model;

public class ListingStat {
	
	private String listingId;
	private long count;
	private long oneStartCount;
	private long twoStartCount;
	private long threeStartCount;
	private long fourStartCount;
	private long fiveStartCount;
	private double avgRating;
	
	
	
	public ListingStat(String listingId) {
		super();
		this.listingId = listingId;
	}


	public ListingStat(String listingId, long count) {
		super();
		this.listingId = listingId;
		this.count = count;
	}
	
	
	public String getListingId() {
		return listingId;
	}
	public void setListingId(String listingId) {
		this.listingId = listingId;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}


	public long getOneStartCount() {
		return oneStartCount;
	}


	public void setOneStartCount(long oneStartCount) {
		this.oneStartCount = oneStartCount;
		calAvg();
	}


	public long getTwoStartCount() {
		return twoStartCount;
	}


	public void setTwoStartCount(long twoStartCount) {
		this.twoStartCount = twoStartCount;
		calAvg();
	}


	public long getThreeStartCount() {
		return threeStartCount;
	}


	public void setThreeStartCount(long threeStartCount) {
		this.threeStartCount = threeStartCount;
		calAvg();
	}


	public long getFourStartCount() {
		return fourStartCount;
	}


	public void setFourStartCount(long fourStartCount) {
		this.fourStartCount = fourStartCount;
		calAvg();
	}


	public long getFiveStartCount() {
		return fiveStartCount;
	}


	public void setFiveStartCount(long fiveStartCount) {
		
		this.fiveStartCount = fiveStartCount;
		calAvg();
	}

    
	public double getAvgRating() {
		return avgRating;
	}
	
	private void calAvg(){
		long totalVotes = getFiveStartCount()+getFourStartCount()+getThreeStartCount()+getTwoStartCount()+getOneStartCount();
		long totalStars = getFiveStartCount()*5+getFourStartCount()*4+getThreeStartCount()*3+getTwoStartCount()*2+getOneStartCount()*1;
		
		avgRating =  ((double)totalStars)/totalVotes;
	}
	
	
	

}
