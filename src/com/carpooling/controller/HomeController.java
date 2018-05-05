package com.carpooling.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carpooling.domain.User;
import com.carpooling.service.UserService;
import com.carpooling.serviceImpl.UserServiceImpl;

@WebServlet("/Home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService us = new UserServiceImpl();
		String email = (String) request.getSession().getAttribute("userSession");
		User user = us.getUserByemail(email);
		int id = user.getUserId();
		
		request.setAttribute("userId", id);

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/home.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}