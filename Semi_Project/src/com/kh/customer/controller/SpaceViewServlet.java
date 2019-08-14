package com.kh.customer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.BoardService;
import com.kh.customer.model.service.ReviewService;
import com.kh.customer.model.vo.Review;
import com.kh.host.model.service.SpaceService;
import com.kh.host.model.vo.Space;
import com.kh.paging.model.vo.Paging;

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
		final int numPerPage = 5;
		int cPage = 1;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		}catch (NumberFormatException e) {
			// TODO: handle exception
		}
		int spaceNo = Integer.parseInt(request.getParameter("spaceNo"));
//		try{
//			spaceNo = Integer.parseInt(request.getParameter("spaceNo"));
//		} catch(NumberFormatException e) {
//			e.printStackTrace();
//		}
		
		Space space = new SpaceService().spaceSelectOneBySpaceNo(spaceNo);
		List<Review> review = new ReviewService().selectReviewList(spaceNo,cPage, numPerPage );
		
		int totalContents = new ReviewService().selectTotalContents();
		int totalPage = (int)Math.ceil((double)totalContents/numPerPage);
		
		Paging paging = new Paging();
		paging.setPage(cPage);
		paging.setTotalCount(totalContents);
		
		request.setAttribute("space", space);
		request.setAttribute("review", review);
		request.setAttribute("paging", paging);
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
