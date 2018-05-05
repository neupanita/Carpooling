package com.carpooling.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.carpooling.config.DBconnection;
import com.carpooling.dao.PostDao;
import com.carpooling.domain.Post;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class PostDaoImpl implements PostDao {

	private Connection con;

	@Override
	public boolean createPost(Post post) throws SQLException {
		boolean flag = false;

		try {
			con = this.getConnection();
			Statement stm = (Statement) con.createStatement();
			String query = "INSERT INTO posts (userid, post, posttype, datecreated, dateupdated) "
					+ "VALUES ('"  +post.getUserId() + "', '" + post.getPost()+"', '"+post.getPostType()+"', '"+post.getDateCreated()+"', '"+post.getDateUpdated()+"')";
			stm.executeUpdate(query);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Post getPost(long id) throws SQLException {
		try {
			con = this.getConnection();
			Statement stm = (Statement) con.createStatement();
			String query = "select from posts where postid = '" + id + "'";
			ResultSet rs = stm.executeQuery(query);

			Post post = new Post();
			post.setUserId(rs.getInt("userid"));
			post.setPostId(rs.getInt("postid"));
			post.setPost(rs.getString("post"));
			post.setPostType(rs.getInt("postype"));
			post.setDateCreated(rs.getTimestamp("datecreated"));
			post.setDateUpdated(rs.getTimestamp("dateupdated"));
			rs.close();

			return post;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updatePost(Post post) throws SQLException {
		boolean flag = false;

		try {
			con = this.getConnection();
			Statement stm = (Statement) con.createStatement();
			String sql = "UPDATE posts " +
					"SET userid = '" + post.getUserId()
					+ "', post = '" + post.getPost()
					+ "', posttype='" + post.getPostType()
					+ "', datecreated ='" + post.getDateCreated()
					+ "',dateupdated='" + post.getDateUpdated() 
					+ "' WHERE postid='" + post.getPostId() + "'";
			stm.executeUpdate(sql);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deletePost(long id) throws SQLException {
		boolean flag = false;

		try {
			con = this.getConnection();
			Statement stm = (Statement) con.createStatement();
			String query = "DELETE FROM posts WHERE postid = '"+id+"'";
			stm.executeUpdate(query);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	private Connection getConnection() throws Exception {
		return (Connection)DBconnection.getConnection();
	}

	@Override
	public List<Post> OfferPosts() throws SQLException {
		ArrayList<Post> offPosts = new ArrayList<>();
		try {
			con = this.getConnection();
			Statement stm = (Statement) con.createStatement();
			String query = "select * from posts where posttype = 1 ORDER BY `dateupdated` DESC ";
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()) {
				Post post = new Post();
				post.setPostId(rs.getInt("postid"));
				post.setUserId(rs.getInt("userid"));
				post.setPost(rs.getString("post"));
				post.setPostType(rs.getInt("posttype"));
				post.setDateCreated(rs.getTimestamp("datecreated"));
				post.setDateUpdated(rs.getTimestamp("dateupdated"));
				offPosts.add(post);
			}
			rs.close();

			return offPosts;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Post> RequestPosts() throws SQLException {
		ArrayList<Post> requestPosts = new ArrayList<>();
		try {
			con = this.getConnection();
			Statement stm = (Statement) con.createStatement();
			String query = "select * from posts where posttype = 0 ORDER BY `dateupdated` DESC ";
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()) {
				Post post = new Post();
				post.setPostId(rs.getInt("postid"));
				post.setUserId(rs.getInt("userid"));
				post.setPost(rs.getString("post"));
				post.setPostType(rs.getInt("posttype"));
				post.setDateCreated(rs.getTimestamp("datecreated"));
				post.setDateUpdated(rs.getTimestamp("dateupdated"));
				requestPosts.add(post);
			}
			rs.close();

			return requestPosts;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
