package com.carpooling.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.carpooling.config.DBconnection;
import com.carpooling.dao.LikeDao;
import com.carpooling.domain.Like;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class LikeDaoImpl implements LikeDao {
	private Connection con;

	@Override
	public boolean createLike(Like like) throws SQLException {
		boolean flag = false;

		try {
			con = this.getConnection();
			Statement stm = (Statement) con.createStatement();
			String query = "INSERT INTO likes (userid, postid, datecreated, dateupdated) "
					+ "VALUES ('"  + like.getUserId() + "', '" + like.getPostId() +"', '"
					+ like.getDateCreated()+"', '" + like.getDateUpdated()+"')";
			stm.executeUpdate(query);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Like getLike(long id) throws SQLException {
		try {
			con = this.getConnection();
			Statement stm = (Statement) con.createStatement();
			String query = "select from likes where likeid = '" + id + "'";
			ResultSet rs = stm.executeQuery(query);

			Like like = new Like();
			like.setUserId(rs.getInt("userid"));
			like.setPostId(rs.getInt("postid"));
			like.setDateCreated(rs.getTimestamp("datecreated"));
			like.setDateUpdated(rs.getTimestamp("dateupdated"));
			rs.close();

			return like;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Like> getAllLikes(long postId) throws SQLException {
		ArrayList<Like> allLikes = new ArrayList<>();
		try {
			con = this.getConnection();
			Statement stm = (Statement) con.createStatement();
			String query = "select * from likes where postid = '" + postId + "'";
			ResultSet rs = stm.executeQuery(query);

			while(rs.next()) {
				Like like = new Like();
				like.setUserId(rs.getInt("userid"));
				like.setPostId(rs.getInt("postid"));
				like.setDateCreated(rs.getTimestamp("datecreated"));
				like.setDateUpdated(rs.getTimestamp("dateupdated"));
				allLikes.add(like);
			}
			rs.close();

			return allLikes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateLike(Like like) throws SQLException {
		boolean flag = false;

		try {
			con = this.getConnection();
			Statement stm = (Statement) con.createStatement();
			String sql = "UPDATE comments " +
					"SET userid = '" + like.getUserId() 
					+ "',postid = '" + like.getPostId() 
					+ "', datecreated ='" + like.getDateCreated()
					+ "',dateupdated='" + like.getDateUpdated() 
					+ "' WHERE likeid='" + like.getLikeId() + "'";
			stm.executeUpdate(sql);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deleteLikeByPostId(long id) throws SQLException {
		boolean flag = false;

		try {
			con = this.getConnection();
			Statement stm = (Statement) con.createStatement();
			String query = "DELETE FROM likes WHERE postid = '" + id + "'";
			stm.executeUpdate(query);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deleteLike(long id) throws SQLException {
		boolean flag = false;

		try {
			con = this.getConnection();
			Statement stm = (Statement) con.createStatement();
			String query = "DELETE FROM likes WHERE likeid = '" + id + "'";
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
