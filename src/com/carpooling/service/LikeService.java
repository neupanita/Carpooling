package com.carpooling.service;

import java.util.List;

import com.carpooling.domain.Like;

public interface LikeService {
	public boolean createLike(Like like);
	public Like getLike(long id);
	public List<Like> getAllLikes(long postId);
	public boolean updateLike(Like like);
	public boolean deleteLike(long id);
	public boolean deleteLikeByPostId(long id);
}
