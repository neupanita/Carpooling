package com.carpooling.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.carpooling.domain.User;
import com.carpooling.service.UserService;
import com.carpooling.serviceImpl.UserServiceImpl;

@WebServlet("/WeatherMap")
public class WeatherMapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	UserService userService = new UserServiceImpl();
	
    public WeatherMapController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String userEmail = session.getAttribute("userSession").toString();
		User user = userService.getUserByemail(userEmail);
		
		request.setAttribute("userCity", user.getCity().toString());
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/weathermap.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
	}

}
