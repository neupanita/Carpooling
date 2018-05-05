package com.carpooling.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carpooling.domain.Post;
import com.carpooling.service.LikeService;
import com.carpooling.service.PostService;
import com.carpooling.serviceImpl.LikeServiceImpl;
import com.carpooling.serviceImpl.PostServiceImpl;
import com.google.gson.Gson;

@WebServlet("/Like")
public class LikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	LikeService likeService = new LikeServiceImpl();
	PostService postService = new PostServiceImpl();

    public LikeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		try {
			Gson gson=new Gson();
			List<Post> posts = new ArrayList<>();
			posts.addAll(postService.getOfferPosts());
			posts.addAll(postService.getRequestPosts());
			Map<String, Integer> likes = new HashMap<String, Integer>();
			
			for(Post post: posts) {
				int count = likeService.getAllLikes(post.getPostId()).size();
				likes.put("like-count-"+post.getPostId(), count);
			}
			
			String jsonData = gson.toJson(likes);
			out.println("{\"JSONDATA\":"+jsonData+"}");
			System.out.println("{\"JSONDATA\":"+jsonData+"}");
		} catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}

}
