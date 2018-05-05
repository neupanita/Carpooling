package com.carpooling.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import com.carpooling.dao.UserDao;
import com.carpooling.daoImpl.UserDaoImpl;
import com.carpooling.domain.User;
import com.carpooling.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();
	
	@Override
	public boolean createUser(User user) {
		try {
			return userDao.createUser(user);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User getUser(long id) {
		try {
			return userDao.getUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<User> getAllUsers() {
		try {
			return userDao.getAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateUser(User user) {
		try {
			return userDao.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateUserByEmail(User userEmail) {
		try {
			return userDao.updateUser(userEmail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean deleteUser(long id) {
		try {
			return userDao.deleteUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean ifLoggedIn(String email, String password) {
		try {
			User user = userDao.getUserByEmail(email);
			if(user != null) {
				if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User getUserByemail(String email) {
		try {
			return userDao.getUserByEmail(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}