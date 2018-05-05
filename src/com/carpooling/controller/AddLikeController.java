package com.carpooling.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.carpooling.domain.Like;
import com.carpooling.domain.User;
import com.carpooling.service.LikeService;
import com.carpooling.service.PostService;
import com.carpooling.service.UserService;
import com.carpooling.serviceImpl.LikeServiceImpl;
import com.carpooling.serviceImpl.PostServiceImpl;
import com.carpooling.serviceImpl.UserServiceImpl;

@WebServlet("/AddLike")
public class AddLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	LikeService likeService = new LikeServiceImpl();
	UserService userService = new UserServiceImpl();
	PostService postService = new PostServiceImpl();
       
    public AddLikeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		long postId = Long.parseLong(request.getParameter("post-id"));
		Calendar calendar = Calendar.getInstance();
		Timestamp date = new Timestamp(calendar.getTime().getTime());
		
		HttpSession session = request.getSession();
		String userEmail = session.getAttribute("userSession").toString();
		User user = userService.getUserByemail(userEmail);

		List<Like> likes = likeService.getAllLikes(postId);
		boolean isAlreadyLiked = false;
		for(Like existingLike : likes) {
			if(existingLike.getUserId() == user.getUserId()) {
				likeService.deleteLike(existingLike.getLikeId());
				isAlreadyLiked = true;
			}
		}
		
		boolean check = true;
		if(!isAlreadyLiked) {
			Like like = new Like();
			like.setUserId(user.getUserId());
			like.setPostId(postId);
			like.setDateCreated(date);
			like.setDateUpdated(date);
			
			check = likeService.createLike(like);
		}
		
		if(check) {
			request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
			System.out.println("Successfully Added Like");
		} else {
			System.out.println("Couldn't Add Like");
		}
		
	}

}
