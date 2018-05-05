package com.carpooling.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.carpooling.service.UserService;
import com.carpooling.serviceImpl.UserServiceImpl;

@WebServlet("/Login")
public class LoginController extends HttpServlet {
	
	private UserService userService = new UserServiceImpl();
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/home.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String remembercbox = request.getParameter("remember");
		
		if (remembercbox != null) {
			Cookie cEmail = new Cookie("cookuser", email.trim());
			Cookie cPassword = new Cookie("cookpass", password.trim());
			Cookie cRemember = new Cookie("cookrem", remembercbox.trim());
			cEmail.setMaxAge(60 * 60 * 15);
			cPassword.setMaxAge(60 * 60 * 15);
			cRemember.setMaxAge(60 * 60 * 15);
			response.addCookie(cEmail);
			response.addCookie(cPassword);
			response.addCookie(cRemember);
		}
		
		RequestDispatcher view = null;
		try {
			if (userService.ifLoggedIn(email, password)) {			
				session.setAttribute("userSession", email);
//				view = request.getRequestDispatcher("WEB-INF/views/home.jsp");
//				view.forward(request, response);
				response.sendRedirect(request.getContextPath() + "/Home");
			} else {
				System.out.println("User Login Failed");
				view = request.getRequestDispatcher("index.jsp");
				view.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}