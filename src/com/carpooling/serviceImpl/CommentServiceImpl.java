package com.carpooling.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import com.carpooling.dao.CommentDao;
import com.carpooling.daoImpl.CommentDaoImpl;
import com.carpooling.domain.Comment;
import com.carpooling.service.CommentService;

public class CommentServiceImpl implements CommentService {

	CommentDao commentDao = new CommentDaoImpl();

	@Override
	public boolean createComment(Comment comment) {
		try {
			return commentDao.createComment(comment);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public Comment getComment(long id) {
		try {
			return commentDao.getComment(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Comment> getAllComments(long postId) {
		try {
			return commentDao.getAllComments(postId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateComment(Comment comment) {
		try {
			return commentDao.updateComment(comment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteComment(long id) {
		try {
			return commentDao.deleteComment(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean deleteCommentByPostId(long id) {
		try {
			return commentDao.deleteCommentByPostId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
