package com.carpooling.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.carpooling.config.DBconnection;
import com.carpooling.dao.UserDao;
import com.carpooling.domain.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class UserDaoImpl implements UserDao {
	private Connection con;

	@Override
	public boolean createUser(User user) throws SQLException {
		boolean flag = false;

		try {
			con = this.getConnection();
			Statement stm = (Statement) con.createStatement();
			String query = "INSERT INTO users (userid, fullname, gender, state, city, street,"
					+ "zipcode, birthyear, email, password, datecreated, dateupdated) "
					+ "VALUES ('"  + this.getAutoUserId() + "', '" 
					+ user.getFullName() + "', '" + user.getGender() + "', '"
					+ user.getState() + "', '" + user.getCity() + "', '" 
					+ user.getStreet() + "', '"
					+ user.getZipCode() + "', '" + user.getBirthYear() + "', '" 
					+ user.getEmail() + "', '" + user.getPassword() + "', '" 
					+ user.getDateCreated()+"', '" + user.getDateUpdated()+"')";
			stm.executeUpdate(query);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public User getUser(long id) throws SQLException {
		try {
			con = this.getConnection();
			Statement stm = (Statement) con.createStatement();
			String query = "select * from users where userid= '" + id + "'";
			ResultSet rs = stm.executeQuery(query);
			rs.next();
	
			User user = new User();
			user.setUserId(rs.getInt("userid"));
			user.setFullName(rs.getString("fullname"));
			user.setGender(rs.getInt("gender"));
			user.setState(rs.getString("state"));
			user.setCity(rs.getString("city"));
			user.setStreet(rs.getString("street"));
			user.setZipCode(rs.getInt("zipcode"));
			user.setBirthYear(rs.getInt("birthyear"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setDateCreated(rs.getTimestamp("datecreated"));
			user.setDateUpdated(rs.getTimestamp("dateupdated"));
			rs.close();

			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> getAllUsers() throws SQLException {
		ArrayList<User> allUsers = new ArrayList<>();
		try {
			con = this.getConnection();
			Statement stm = (Statement) con.createStatement();
			String query = "select * from users";
			ResultSet rs = stm.executeQuery(query);

			while(rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("userid"));
				user.setFullName(rs.getString("fullname"));
				user.setGender(rs.getInt("gender"));
				user.setState(rs.getString("state"));
				user.setCity(rs.getString("city"));
				user.setStreet(rs.getString("street"));
				user.setZipCode(rs.getInt("zipcode"));
				user.setBirthYear(rs.getInt("birthyear"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setDateCreated(rs.getTimestamp("datecreated"));
				user.setDateUpdated(rs.getTimestamp("dateupdated"));
				allUsers.add(user);
			}
			rs.close();

			return allUsers;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateUser(User user) throws SQLException {
		boolean flag = false;

		try {
			con = this.getConnection();
			Statement stm = (Statement) con.createStatement();
			
			String sql = "UPDATE users " +
					"SET fullname = '" + user.getFullName() 
					+ "',gender = '" + user.getGender()
					+ "',state = '" + user.getState()
					+ "',city = '" + user.getCity()
					+ "',street = '" + user.getStreet()
					+ "',zipcode = '" + user.getZipCode()
					+ "',birthyear = '" + user.getBirthYear()
					+ "',email = '" + user.getEmail()
					+ "',email = '" + user.getEmail()
					+ "', password ='" + user.getDateCreated()
					+ "',dateupdated='" + user.getDateUpdated() 
					+ "' WHERE userid='" + user.getUserId() + "'";
			stm.executeUpdate(sql);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public boolean updateUserByEmail(User userEmail) throws SQLException{
		boolean flag=false;
		
		try{
			con = this.getConnection();
			Statement stm = (Statement) con.createStatement();
			
			String sql = "UPDATE users " +
					"SET fullname = '" + userEmail.getFullName() 
					+ "',gender = '" + userEmail.getGender()
					+ "',state = '" + userEmail.getState()
					+ "',city = '" + userEmail.getCity()
					+ "',street = '" + userEmail.getStreet()
					+ "',zipcode = '" + userEmail.getZipCode()
					+ "',birthyear = '" + userEmail.getBirthYear()
					+ "', password ='" + userEmail.getDateCreated()
					+ "',dateupdated='" + userEmail.getDateUpdated() 
					+ "' WHERE userEmail='" + userEmail.getEmail()+ "'";
			stm.executeUpdate(sql);
			flag = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
		
	}

	@Override
	public boolean deleteUser(long id) throws SQLException {
		boolean flag = false;

		try {
			con = this.getConnection();
			Statement stm = (Statement) con.createStatement();
			String query = "DELETE FROM users WHERE userid = '" + id + "'";
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
	
	private int getAutoUserId() {
		try {
			return this.getAllUsers().size() + 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public User getUserByEmail(String email) throws SQLException {
		try {
			con = this.getConnection();
			Statement stm = (Statement) con.createStatement();
			String query = "select * from users where email= '" + email + "'";
			ResultSet rs = stm.executeQuery(query);
			rs.next();
			User user = new User();
			user.setUserId(rs.getInt("userid"));
			user.setFullName(rs.getString("fullname"));
			user.setGender(rs.getInt("gender"));
			user.setState(rs.getString("state"));
			user.setCity(rs.getString("city"));
			user.setStreet(rs.getString("street"));
			user.setZipCode(rs.getInt("zipcode"));
			user.setBirthYear(rs.getInt("birthyear"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setDateCreated(rs.getTimestamp("datecreated"));
			user.setDateUpdated(rs.getTimestamp("dateupdated"));
			rs.close();

			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}