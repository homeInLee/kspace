package com.kh.customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.host.model.service.SpaceService;
import com.kh.host.model.vo.Space;

/**
 * Servlet implementation class SpaceViewServlet
 */
@WebServlet("/customer/spaceView")
public class SpaceViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpaceViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int spaceNo = Integer.parseInt(request.getParameter("spaceNo"));
//		try{
//			spaceNo = Integer.parseInt(request.getParameter("spaceNo"));
//		} catch(NumberFormatException e) {
//			e.printStackTrace();
//		}
		
		Space space = new SpaceService().spaceSelectOneBySpaceNo(spaceNo);
		
		request.setAttribute("space", space);
		request.getRequestDispatcher("/WEB-INF/views/customer/spaceView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
