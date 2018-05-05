package com.carpooling.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.carpooling.config.DBconnection;
import com.carpooling.dao.CommentDao;
import com.carpooling.domain.Comment;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class CommentDaoImpl implements CommentDao {

	private Connection con;

	@Override
	public boolean createComment(Comment comment) throws SQLException {
		boolean flag = false;

		try {
			con = this.getConnection();
			Statement stm = (Statement) con.createStatement();
			String query = "INSERT INTO comments (userid, postid, comment, datecreated, dateupdated) "
					+ "VALUES ('"  + comment.getUserId() + "', '" 
					+ comment.getPostId() +"', '" + comment.getComment() +"', '" 
					+ comment.getDateCreated()+"', '" + comment.getDateUpdated()+"')";
			stm.executeUpdate(query);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Comment getComment(long id) throws SQLException {
		try {
			con = this.getConnection();
			Statement stm = (Statement) con.createStatement();
			String query = "select from comments where commentid = '" + id + "'";
			ResultSet rs = stm.executeQuery(query);

			Comment comment = new Comment();
			comment.setUserId(rs.getInt("userid"));
			comment.setPostId(rs.getInt("postid"));
			comment.setComment(rs.getString("comment"));
			comment.setDateCreated(rs.getTimestamp("datecreated"));
			comment.setDateUpdated(rs.getTimestamp("dateupdated"));
			rs.close();

			return comment;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Comment> getAllComments(long postId) throws SQLException {
		ArrayList<Comment> allComments = new ArrayList<>();
		try {
			con = this.getConnection();
			Statement stm = (Statement) con.createStatement();
			String query = "select * from comments where postid = '" + postId + "'";
			ResultSet rs = stm.executeQuery(query);

			while(rs.next()) {
				Comment comment = new Comment();
				comment.setCommentId(rs.getInt("commentid"));
				comment.setUserId(rs.getInt("userid"));
				comment.setPostId(rs.getInt("postid"));
				comment.setComment(rs.getString("comment"));
				comment.setDateCreated(rs.getTimestamp("datecreated"));
				comment.setDateUpdated(rs.getTimestamp("dateupdated"));
				allComments.add(comment);
			}
			rs.close();

			return allComments;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateComment(Comment comment) throws SQLException {
		boolean flag = false;

		try {
			con = this.getConnection();
			Statement stm = (Statement) con.createStatement();
			String sql = "UPDATE comments " +
					"SET userid = '" + comment.getUserId() 
					+ "',postid = '" + comment.getPostId() 
					+ "', comment ='" + comment.getComment()
					+ "', datecreated ='" + comment.getDateCreated()
					+ "',dateupdated='" + comment.getDateUpdated() 
					+ "' WHERE commentid='" + comment.getCommentId() + "'";
			stm.executeUpdate(sql);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deleteCommentByPostId(long id) throws SQLException {
		boolean flag = false;

		try {
			con = this.getConnection();
			Statement stm = (Statement) con.createStatement();
			String query = "DELETE FROM comments WHERE postid = '" + id + "'";
			stm.executeUpdate(query);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public boolean deleteComment(long id) throws SQLException {
		boolean flag = false;

		try {
			con = this.getConnection();
			Statement stm = (Statement) con.createStatement();
			String query = "DELETE FROM comments WHERE commentid = '" + id + "'";
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

}
