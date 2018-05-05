package com.carpooling.service;

import java.util.List;

import com.carpooling.domain.Comment;

public interface CommentService {
	public boolean createComment(Comment comment);
	public Comment getComment(long id);
	public List<Comment> getAllComments(long postId);
	public boolean updateComment(Comment comment);
	public boolean deleteComment(long id);
	public boolean deleteCommentByPostId(long id);
}
