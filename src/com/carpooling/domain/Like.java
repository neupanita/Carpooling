package com.carpooling.domain;

import java.sql.Timestamp;

public class Like {
	private long likeId;
	private long userId;
	private long postId;
	private Timestamp dateCreated;
	private Timestamp dateUpdated;

	public long getLikeId() {
		return likeId;
	}
	public void setLikeId(long likeId) {
		this.likeId = likeId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getPostId() {
		return postId;
	}
	public void setPostId(long postId) {
		this.postId = postId;
	}
	public Timestamp getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Timestamp getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(Timestamp dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
}
