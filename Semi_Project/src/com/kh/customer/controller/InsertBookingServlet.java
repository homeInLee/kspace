package com.kh.customer.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.customer.model.service.BookingService;
import com.kh.customer.model.vo.Booking;

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
		String myCalendar = request.getParameter("myCalendar");
		String timepicker1 = request.getParameter("timepicker1");
		String timepicker2 = request.getParameter("timepicker2");
		int people = Integer.parseInt(request.getParameter("people"));
		String request1 = "없음";
		//request받아야함
//		'2019-08-05 13:00:00', 'yyyy-mm-dd hh24:mi:ss'
		System.out.println("userId="+userId);
		System.out.println("spaceNo="+spaceNo);
		System.out.println("myCalendar="+myCalendar);
		System.out.println("timepicker1="+timepicker1);
		System.out.println("timepicker2="+timepicker2);
		System.out.println("people="+people);
		System.out.println("request1="+request1);
		String mintime = myCalendar+" "+timepicker1+":00";
		String maxtime = myCalendar+" "+timepicker2+":00";
		SimpleDateFormat format2 = new SimpleDateFormat ("yyyy-MM-dd");
		SimpleDateFormat format1 = new SimpleDateFormat ("dd");
		SimpleDateFormat format3 = new SimpleDateFormat ("HH:mm");
		
		List<Booking> blist = new BookingService().spaceBookingListBySpaceNo(spaceNo);
		
		String msg = "";
		String loc = "/customer/spaceView?spaceNo="+spaceNo;
		String view = "/WEB-INF/views/common/msg.jsp";


		for(int i=0; i<blist.size(); i++) {

			if(myCalendar.equals(format2.format(blist.get(i).getMinTime()))) {
				if(Integer.parseInt(timepicker1.substring(0,2))<Integer.parseInt(format3.format(blist.get(i).getMinTime()).substring(0,2))) {
					if(Integer.parseInt(timepicker2.substring(0,2))<=Integer.parseInt(format3.format(blist.get(i).getMinTime()).substring(0,2))) {
						msg = "예약이 성공하였습니다.";
					}
					else {
						msg = myCalendar+"은"+format3.format(blist.get(i).getMinTime()).substring(0,2)+"~"+format3.format(blist.get(i).getMaxTime()).substring(0,2)+"에 예약이 차있습니다1.";
						break;
					}
				}
				else if(Integer.parseInt(timepicker1.substring(0,2))>=Integer.parseInt(format3.format(blist.get(i).getMaxTime()).substring(0,2))) {
					msg = myCalendar+"은"+format3.format(blist.get(i).getMinTime()).substring(0,2)+"~"+format3.format(blist.get(i).getMaxTime()).substring(0,2)+"에 예약이 차있습니다2.";
					if(Integer.parseInt(timepicker2.substring(0,2))>Integer.parseInt(format3.format(blist.get(i).getMaxTime()).substring(0,2))) {
						msg = "예약이 성공하였습니다.";
					}
					else {
						msg = myCalendar+"은"+format3.format(blist.get(i).getMinTime()).substring(0,2)+"~"+format3.format(blist.get(i).getMaxTime()).substring(0,2)+"에 예약이 차있습니다3.";
						break;
					}
				}
				else {
					msg = myCalendar+"은"+format3.format(blist.get(i).getMinTime()).substring(0,2)+"~"+format3.format(blist.get(i).getMaxTime()).substring(0,2)+"에 예약이 차있습니다4.";
					break;
				}
			}
			else {
				msg = "예약이 성공하였습니다.";
			}
			System.out.println(format2.format(blist.get(i).getMinTime()));
			System.out.println("예약테이블="+Integer.parseInt(format3.format(blist.get(i).getMinTime()).substring(0,2)));
			System.out.println("예약테이블="+Integer.parseInt(format3.format(blist.get(i).getMaxTime()).substring(0,2)));
			System.out.println("예약하려는 시간"+Integer.parseInt(timepicker1.substring(0,2)));
			System.out.println("예약하려는 시간"+Integer.parseInt(timepicker2.substring(0,2)));
			System.out.println(blist.get(i).getMinTime());
			System.out.println(blist.get(i).getMaxTime());
		}
		if(msg.equals("예약이 성공하였습니다.")) {
			int result = new BookingService().insertBooking(userId, spaceNo, mintime, maxtime, request1, people);			
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
