package com.carpooling.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.carpooling.domain.User;
import com.carpooling.serviceImpl.UserServiceImpl;

@WebServlet("/Register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/register.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String fullname = request.getParameter("fullname");
		int gender = Integer.parseInt(request.getParameter("gender"));
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		int zipCode = Integer.parseInt(request.getParameter("zipcode"));
		int birthYear = Integer.parseInt(request.getParameter("birthyear"));
		String email = request.getParameter("email");
		String password = request.getParameter("password");
				
		HttpSession session = request.getSession(); 
		session.setAttribute("sessionEmail", email);
		session.setAttribute("sessionCity", city);
		
		User user = new User();
		UserServiceImpl userService = new UserServiceImpl(); 
		user.setFullName(fullname);
		user.setBirthYear(birthYear);
		user.setCity(city);
		user.setEmail(email);
		user.setStreet(street);
		user.setPassword(password);
		user.setState(state);
		user.setZipCode(zipCode);
		user.setGender(gender);
		Calendar calendar = Calendar.getInstance();
		Timestamp date = new Timestamp(calendar.getTime().getTime());
		user.setDateCreated(date);
		user.setDateUpdated(date);
		
		RequestDispatcher view = null;
		try {
			if (userService.createUser(user) == true) {
				response.sendRedirect(request.getContextPath() + "/Home");
			} else {
				System.out.println("Error Registering User");
				view = request.getRequestDispatcher("WEB-INF/views/register.jsp");
				view.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			view = request.getRequestDispatcher("WEB-INF/views/register.jsp");
			view.forward(request, response);
		}

	}
}