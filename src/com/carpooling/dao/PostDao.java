package com.carpooling.dao;

import java.sql.SQLException;
import java.util.List;

import com.carpooling.domain.Post;

public interface PostDao {

	public boolean createPost(Post post) throws SQLException;
	public Post getPost(long id) throws SQLException;
	public List<Post> OfferPosts() throws SQLException;
	public List<Post> RequestPosts() throws SQLException;
	public boolean updatePost(Post post) throws SQLException;
	public boolean deletePost(long id) throws SQLException;
}
