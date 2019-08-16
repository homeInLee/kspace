package com.kh.customer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.customer.model.service.BookingService;

/**
 * Servlet implementation class BookingCancleServlet
 */
@WebServlet(urlPatterns="/customer/bookingCancle",name="BookingCancleServlet")
public class BookingCancleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingCancleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookingNo = Integer.parseInt(request.getParameter("bookingNo"));
		System.out.println("bookingNo="+bookingNo);
		
		int result = new BookingService().bookingCancle(bookingNo);
		
		
		
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
