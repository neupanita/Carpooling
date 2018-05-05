package com.carpooling.service;

import java.util.List;

import com.carpooling.domain.Post;

public interface PostService {
	public boolean createPost(Post post);
	public Post getPost(long id);
	public List<Post> getOfferPosts();
	public List<Post> getRequestPosts();
	public boolean updatePost(Post post);
	public boolean deletePost(long id);
}
