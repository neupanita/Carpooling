package com.carpooling.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.carpooling.domain.Post;
import com.carpooling.domain.User;
import com.carpooling.service.PostService;
import com.carpooling.service.UserService;
import com.carpooling.serviceImpl.PostServiceImpl;
import com.carpooling.serviceImpl.UserServiceImpl;

@WebServlet("/Post")
public class InsertPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PostService postService = new PostServiceImpl();

	public InsertPostController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService us = new UserServiceImpl();
		String post = request.getParameter("post");
		int postType = Integer.parseInt(request.getParameter("posttype"));
		Calendar calendar = Calendar.getInstance();
		Timestamp date = new Timestamp(calendar.getTime().getTime());
		
		
		String email = (String) request.getSession().getAttribute("userSession");
		User user = us.getUserByemail(email);

		Post p = new Post();
		p.setDateCreated(date);
		p.setDateUpdated(date);
		p.setPost(post);
		p.setPostType(postType);
		p.setUserId(user.getUserId());

		boolean check = postService.createPost(p);

		if(check) {
			response.sendRedirect(request.getContextPath() + "/Home");
//			request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
			System.out.println("successfully inserteed");
		} else {
			System.out.println("not inserted");
		}
	}
}