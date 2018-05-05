package com.carpooling.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carpooling.domain.Comment;
import com.carpooling.service.CommentService;
import com.carpooling.serviceImpl.CommentServiceImpl;

@WebServlet("/AddComment")
public class AddCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CommentService commentService = new CommentServiceImpl();
       
    public AddCommentController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String commentText = request.getParameter("new-comment");
		long postId = Long.parseLong(request.getParameter("post-id"));
		Calendar calendar = Calendar.getInstance();
		Timestamp date = new Timestamp(calendar.getTime().getTime());
		
		Comment comment = new Comment();
		
		comment.setComment(commentText);
		comment.setDateCreated(date);
		comment.setDateUpdated(date);
		comment.setPostId(postId);
		
		boolean check = commentService.createComment(comment);
		
		if(check) {
			request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
			System.out.println("Successfully Added Comment");
		} else {
			System.out.println("Couldn't Add Comment");
		}
	}

}
