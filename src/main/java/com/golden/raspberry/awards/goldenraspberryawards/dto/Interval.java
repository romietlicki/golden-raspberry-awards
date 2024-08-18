package com.golden.raspberry.awards.goldenraspberryawards.dto;

public class Interval {
    private String producer;
    private int interval;
    private int previousWin;
    private int followingWin;

    public Interval(String producer, int minInterval, int maxInterval, int previousWin, int followingWin) {
        this.producer = producer;
        this.interval = maxInterval - minInterval;
        this.previousWin = previousWin;
        this.followingWin = followingWin;
    }

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public int getPreviousWin() {
		return previousWin;
	}

	public void setPreviousWin(int previousWin) {
		this.previousWin = previousWin;
	}

	public int getFollowingWin() {
		return followingWin;
	}

	public void setFollowingWin(int followingWin) {
		this.followingWin = followingWin;
	}
    
    
    

}