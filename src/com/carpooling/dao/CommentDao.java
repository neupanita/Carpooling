package com.carpooling.dao;

import java.sql.SQLException;
import java.util.List;

import com.carpooling.domain.Comment;

public interface CommentDao {
	
	public boolean createComment(Comment comment) throws SQLException;
	public Comment getComment(long id) throws SQLException;
	public List<Comment> getAllComments(long postId) throws SQLException;
	public boolean updateComment(Comment comment) throws SQLException;
	public boolean deleteComment(long id) throws SQLException;
	public boolean deleteCommentByPostId(long id) throws SQLException;
}
