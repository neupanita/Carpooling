package com.carpooling.serviceImpl;

import java.util.List;

import com.carpooling.dao.PostDao;
import com.carpooling.daoImpl.PostDaoImpl;
import com.carpooling.domain.Post;
import com.carpooling.service.PostService;

public class PostServiceImpl implements PostService {
	PostDao postdao = new PostDaoImpl();

	public boolean createPost(Post post){
		try {
			return postdao.createPost(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public Post getPost(long id) {
		try {
			return postdao.getPost(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updatePost(Post post) {
		try {
			return postdao.updatePost(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deletePost(long id) {
		try {
			return postdao.deletePost(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Post> getOfferPosts() {
		try {
			return postdao.OfferPosts();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Post> getRequestPosts() {
		try {
			return postdao.RequestPosts();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
