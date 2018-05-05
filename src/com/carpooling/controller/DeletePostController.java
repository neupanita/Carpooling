package com.carpooling.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carpooling.domain.Comment;
import com.carpooling.domain.Post;
import com.carpooling.service.CommentService;
import com.carpooling.service.LikeService;
import com.carpooling.service.PostService;
import com.carpooling.serviceImpl.CommentServiceImpl;
import com.carpooling.serviceImpl.LikeServiceImpl;
import com.carpooling.serviceImpl.PostServiceImpl;
import com.google.gson.Gson;

@WebServlet("/DeletePost")
public class DeletePostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeletePostController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
		PostService postService = new PostServiceImpl();
		LikeService likeService = new LikeServiceImpl();
		CommentService commmentService = new CommentServiceImpl();
		
		int postId = Integer.parseInt(request.getParameter("postId"));
		
		boolean check = false;

		check = likeService.deleteLikeByPostId(postId);
		if(check){
			check = commmentService.deleteCommentByPostId(postId);
			if(check){
				check = postService.deletePost(postId);
				if(check){
					Gson gson = new Gson();
					String jsonData = gson.toJson("DeleteSuccess");
					out.println("{\"JSONMESSAGE\":" + jsonData + "}");
					System.out.println("{\"JSONMESSAGE\":" + jsonData + "}");
				}else{
					System.out.println("error");
				}
			}else{
				System.out.println("error");
			}
		}else{			
			System.out.println("error");
		}
	}
}
