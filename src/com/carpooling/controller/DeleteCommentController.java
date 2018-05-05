package com.carpooling.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carpooling.service.CommentService;
import com.carpooling.serviceImpl.CommentServiceImpl;
import com.google.gson.Gson;

@WebServlet("/DeleteComment")
public class DeleteCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CommentService commentService = new CommentServiceImpl();
	
	public DeleteCommentController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		int commentId = Integer.parseInt(request.getParameter("commentId"));

		boolean check = commentService.deleteComment(commentId);

		if(check) {
			Gson gson = new Gson();
			String jsonData = gson.toJson("DeleteSuccess");
			out.println("{\"JSONMESSAGE\":" + jsonData + "}");
			System.out.println("{\"JSONMESSAGE\":" + jsonData + "}");
		}else{
			System.out.println("error");
		}
	}

}
