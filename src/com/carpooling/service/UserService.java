package com.carpooling.service;

import java.util.List;

import com.carpooling.domain.User;

public interface UserService {
	public boolean createUser(User user);
	public User getUser(long id);
	public List<User> getAllUsers();
	public boolean updateUser(User user);
	public boolean deleteUser(long id);
	boolean ifLoggedIn(String email, String password);
	User getUserByemail(String email);
}
