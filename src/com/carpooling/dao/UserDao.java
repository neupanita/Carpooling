package com.carpooling.dao;

import java.sql.SQLException;
import java.util.List;

import com.carpooling.domain.User;

public interface UserDao {
	
	public boolean createUser(User user) throws SQLException;
	public User getUser(long id) throws SQLException;
	public User getUserByEmail(String email) throws SQLException;
	public List<User> getAllUsers() throws SQLException;
	public boolean updateUser(User user) throws SQLException;
	public boolean deleteUser(long id) throws SQLException;	
	boolean updateUserByEmail(User userEmail)throws SQLException;
}
