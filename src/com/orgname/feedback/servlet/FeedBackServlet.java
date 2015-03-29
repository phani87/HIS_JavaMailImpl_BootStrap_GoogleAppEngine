package com.orgname.feedback.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.orgname.utility.SendFeedBackMail;
import com.orgname.vo.MailVO;

/**
 * Servlet implementation class FeedBackServlet
 */

public class FeedBackServlet extends HttpServlet {
	SendFeedBackMail feedBackMail;
	public MailVO mailVO;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FeedBackServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("FeedBackServlet() Enter");
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();

		if (request.getParameter("googleLogin") != null
				&& request.getParameter("googleLogin").equals("googleLogin")) {
			if (user != null) {
				response.sendRedirect("/jsp/homepage.jsp");
			} else {
				System.out.println("Its trying to login");
				response.sendRedirect(userService.createLoginURL(request
						.getRequestURI()));
			}

		} else if ((request.getParameter("googleLogin") != null && request
				.getParameter("googleLogin").equals("logout"))) {
			response.sendRedirect(userService.createLogoutURL(request
					.getRequestURI()));
		} else {
			System.out.println("if there is no parameter");
			if (user != null) {
				System.out.println("there is a user");
				if(request.getParameter("pagename") != null && request.getParameter("pagename").equals("about")){
					System.out.println("he wants to go to about page");
					request.setAttribute("user", user.getNickname());
					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher("/jsp/About.jsp");
					rd.forward(request, response);
				}else if (request.getParameter("pagename") != null && request.getParameter("pagename").equals("contactus")) {
					System.out.println("he wants to go to contact us page");
					request.setAttribute("user", user.getNickname());
					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher("/jsp/ContactUs.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("he wants to go to homepage");
					request.setAttribute("user", user.getNickname());
					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher("/jsp/homepage.jsp");
				}
				
			} else {
				System.out.println("Login in again....");
				response.sendRedirect("/jsp/homepageLogin.jsp");
			}
		}
		System.out.println("FeedBackServlet() Exit");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("googleLogin").toString());

		mailVO = new MailVO();
		mailVO.setEmailID(request.getParameter("emailID"));
		mailVO.setName(request.getParameter("name"));
		mailVO.setFeedback(request.getParameter("feedback"));
		feedBackMail = new SendFeedBackMail();

		feedBackMail.sendMail(mailVO);
		response.sendRedirect("/jsp/ContactUs.jsp");

	}

}
