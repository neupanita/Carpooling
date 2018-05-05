package com.carpooling.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import com.carpooling.dao.LikeDao;
import com.carpooling.daoImpl.LikeDaoImpl;
import com.carpooling.domain.Like;
import com.carpooling.service.LikeService;

public class LikeServiceImpl implements LikeService {

	LikeDao likeDao = new LikeDaoImpl();

	@Override
	public boolean createLike(Like like) {
		try {
			return likeDao.createLike(like);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Like getLike(long id) {
		try {
			return likeDao.getLike(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Like> getAllLikes(long postId) {
		try {
			return likeDao.getAllLikes(postId);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateLike(Like like) {
		try {
			return likeDao.updateLike(like);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteLike(long id) {
		try {
			return likeDao.deleteLike(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteLikeByPostId(long id) {
		try {
			return likeDao.deleteLikeByPostId(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
