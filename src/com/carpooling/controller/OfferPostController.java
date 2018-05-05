package com.carpooling.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carpooling.domain.User;
import com.carpooling.service.PostService;
import com.carpooling.service.UserService;
import com.carpooling.serviceImpl.PostServiceImpl;
import com.carpooling.serviceImpl.UserServiceImpl;
import com.google.gson.Gson;

@WebServlet("/OfferPost")
public class OfferPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OfferPostController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		PostService postService = new PostServiceImpl();
		UserService user =new UserServiceImpl();
		User u = user.getUserByemail((String)request.getSession().getAttribute("userSession"));

		try{
			Gson gson=new Gson();
			String jsonData = gson.toJson(postService.getOfferPosts());
			out.println("{\"JSONDATA\":"+jsonData+"}");
			//System.out.println(message);

		}
		catch(Exception ex){
			System.out.println(ex.toString());
		}
	}
}
