package com.kh.customer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.customer.model.service.ReviewService;

/**
 * Servlet implementation class CustomerReviewDeleteServlet
 */
@WebServlet(urlPatterns="/customer/customerReviewDelete",name="CustomerReviewDeleteServlet")
public class CustomerReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerReviewDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		int spaceNo = Integer.parseInt(request.getParameter("spaceNo"));
		System.out.println("servlet="+reviewNo+spaceNo);
		
		int result = new ReviewService().deleteReview(reviewNo);
		
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "/customer/spaceView?spaceNo="+spaceNo;
		
		if(result>0)
			msg = "댓글 삭제 성공!";
			
		else 
			msg = "댓글 삭제 실패!";	
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher(view);
		reqDispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
