package com.carpooling.dao;

import java.sql.SQLException;
import java.util.List;

import com.carpooling.domain.Like;

public interface LikeDao {
	
	public boolean createLike(Like like) throws SQLException;
	public Like getLike(long id) throws SQLException;
	public List<Like> getAllLikes(long postId) throws SQLException;
	public boolean updateLike(Like like) throws SQLException;
	public boolean deleteLike(long id) throws SQLException;
	public boolean deleteLikeByPostId(long id) throws SQLException;
}
