package com.carpooling.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carpooling.domain.Post;
import com.carpooling.service.PostService;
import com.carpooling.serviceImpl.PostServiceImpl;

@WebServlet("/EditPost")
public class EditPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditPostController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PostService postService =  new PostServiceImpl();
		int postId = Integer.parseInt(request.getParameter("postId"));
		Post post = postService.getPost(postId);
	}

}
