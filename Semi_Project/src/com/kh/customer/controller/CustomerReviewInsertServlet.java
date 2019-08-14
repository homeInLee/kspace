package com.kh.customer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.customer.model.service.ReviewService;
import com.kh.customer.model.vo.Review;

/**
 * Servlet implementation class CustomerReviewServlet
 */
@WebServlet("/customer/customerReview")
public class CustomerReviewInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerReviewInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * review_no number,--리뷰번호
		 *  review_writer varchar2(15),--리뷰쓴사람
		 *   review_content
		 * varchar2(2000),--리뷰 내용
		 *  space_no number, --공간번호 
		 *  space_point number,--공간 평점
		 * review_date date default sysdate,--리뷰 날짜
		 */
		String reviewWriter = request.getParameter("reviewWriter");
		String reviewContent = request.getParameter("reviewContent");
		int spaceNo = Integer.parseInt(request.getParameter("spaceNo"));
		int spacePoint = Integer.parseInt(request.getParameter("spacePoint"));
		
		Review review = new Review(0, reviewWriter, reviewContent, spaceNo, spacePoint, null);
		System.out.println("servlet="+review);
		
		int result = new ReviewService().insertReview(review);
		
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg="";
		String loc= "/customer/spaceView?spaceNo="+spaceNo;
		if(result>0) {
			msg = "댓글 등록 성공!";
		}else {
			msg="댓글등록 실패";
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
