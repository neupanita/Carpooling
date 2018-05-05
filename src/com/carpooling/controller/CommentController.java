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

@WebServlet("/Comment")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommentController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		CommentService commentService = new CommentServiceImpl();
		long postId = Long.parseLong(request.getParameter("postId"));
		
		try {
			Gson gson=new Gson();
			String jsonData = gson.toJson(commentService.getAllComments(postId));
			out.println("{\"JSONDATA\":" + jsonData + "}");
			System.out.println("{\"JSONDATA\":" + jsonData + "}");

		} catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}

}
