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
import com.carpooling.serviceImpl.UserServiceImpl;

/**
 * Servlet implementation class EditFormController
 */
@WebServlet("/Edit")
public class EditFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			HttpSession session = request.getSession();
			
			User user = new User();
			UserServiceImpl userservice = new UserServiceImpl();
		

		request.setAttribute("fullname", user.getFullName());
		request.setAttribute("gender", user.getGender());
		request.setAttribute("state", user.getState());
		request.setAttribute("city", user.getCity());
		request.setAttribute("street", user.getStreet());
		request.setAttribute("zipcode", user.getZipCode());
		request.setAttribute("birthyear", user.getBirthYear());
		request.setAttribute("email", user.getEmail());
		request.setAttribute("email", user.getEmail());

		RequestDispatcher view= request.getRequestDispatcher("WEB-INF/views/editProfile.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		// System.out.println("INSIDE POST");

		HttpSession session = request.getSession();
		String sessionMail = (String) session.getAttribute("userSession");
		
		User user = new User();
		UserServiceImpl userservice = new UserServiceImpl();
		user.setFullName(request.getParameter("fullname"));
		user.setGender(Integer.parseInt(request.getParameter("gender")));
		user.setState(request.getParameter("state"));
		user.setCity(request.getParameter("city"));
		user.setStreet(request.getParameter("street"));
		user.setZipCode(Integer.parseInt(request.getParameter("zipcode")));
		user.setBirthYear(Integer.parseInt(request.getParameter("birthyear")));
		String email = request.getParameter("email");
		user.setEmail(email);
		user.setPassword(request.getParameter("password"));
		
		RequestDispatcher view = null;
		try {
			if (userservice.updateUserByEmail(user) == true) {
				view = request.getRequestDispatcher("WEB-INF/views/home.jsp");
				view.forward(request, response);
			} else {
				System.out.println("Error Registering User");
				view = request.getRequestDispatcher("WEB-INF/views/editProfile.jsp");
				view.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			view = request.getRequestDispatcher("WEB-INF/views/editProfile.jsp");
			view.forward(request, response);
		};
	}


}
