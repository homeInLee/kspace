package com.kh.customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.customer.model.service.UserService;
import com.kh.customer.model.vo.User;
import com.kh.host.model.service.CompanyService;
import com.kh.host.model.vo.Company;

/**
 * Servlet implementation class MypageServlet
 */
@WebServlet(urlPatterns="/customer/mypage",name="MypageServlet")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		
		User u = new UserService().UserSelectOneById(userId);
		System.out.println("u"+u);
		Company c = null;
		if(u.getFlag().equals("H")) {
			c = new CompanyService().selectCompanyByUserId(userId);
			request.setAttribute("company", c);
		}
		
		request.setAttribute("user", u);
		request.getRequestDispatcher("/WEB-INF/views/customer/mypage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
