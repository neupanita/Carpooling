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

/**
 * Servlet implementation class RequestController
 */
@WebServlet("/RequestPost")
public class RequestPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestPostController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		PostService postService = new PostServiceImpl();
		UserService user =new UserServiceImpl();
		User u = user.getUserByemail((String)request.getSession().getAttribute("userSession"));

		try{
			Gson gson=new Gson();
			String jsonData = gson.toJson(postService.getRequestPosts());
			out.println("{\"JSONDATA\":"+jsonData+"}");
			//System.out.println(message);

		}
		catch(Exception ex){
			System.out.println(ex.toString());
		}
	}
}
