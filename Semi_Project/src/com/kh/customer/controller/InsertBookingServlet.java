package com.kh.customer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.customer.model.service.BookingService;

/**
 * Servlet implementation class InsertBookingServlet
 */
@WebServlet(urlPatterns="/customer/insertBooking",name="InsertBookingServlet")
public class InsertBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int spaceNo = Integer.parseInt(request.getParameter("spaceNo"));
		String userId = request.getParameter("userId");
		System.out.println("userId="+userId);
		System.out.println("spaceNo="+spaceNo);
		
		int result = new BookingService().insertBooking(userId, spaceNo);
		
		String msg = "";
		String loc = "/customer/bookingList?userId=datbot";
		String view = "/WEB-INF/views/common/msg.jsp";
		if(result > 0) {
			msg = "예약이 취소되었습니다.";
		}
		else {
			msg = "예약취소가 실패하였습니다.";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
