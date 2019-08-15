package com.kh.customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.customer.model.service.CustomerService;
import com.kh.customer.model.vo.SpaceDibs;

/**
 * Servlet implementation class JjimServlet
 */
@WebServlet("/customer/jjim")
public class JjimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JjimServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int spaceNo = 0;
		try {
			if(!request.getParameter("spaceNo").equals("")) {
				spaceNo = Integer.parseInt(request.getParameter("spaceNo"));
			}
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		String userId = request.getParameter("userId");
		SpaceDibs jjim = new SpaceDibs(spaceNo, userId, "Y");
		
		int result = new CustomerService().insertJjim(jjim);
		
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(result, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
