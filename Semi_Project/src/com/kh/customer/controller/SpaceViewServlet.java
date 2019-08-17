package com.kh.customer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.customer.model.service.CustomerService;
import com.kh.customer.model.service.ReviewService;
import com.kh.customer.model.service.UserService;
import com.kh.customer.model.vo.Review;
import com.kh.customer.model.vo.SpaceDibs;
import com.kh.customer.model.vo.User;
import com.kh.host.model.service.SpaceService;
import com.kh.host.model.vo.Company;
import com.kh.host.model.vo.Space;
import com.kh.host.model.vo.SpaceDayOff;
import com.kh.host.model.vo.SpaceImageFile;
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
		
		HttpServletRequest httpreq = (HttpServletRequest)request;
		HttpSession session = httpreq.getSession();
		User memberLoggedIn = (User)session.getAttribute("memberLoggedIn");
		
		String userId = null;
		if(memberLoggedIn!=null) {
			userId = memberLoggedIn.getUserId();
		}
		
		Space space = new SpaceService().spaceSelectOneBySpaceNo(spaceNo);
		List<SpaceImageFile> spaceImg = new SpaceService().selectSpaceImgBySpaceNo(spaceNo);
		List<SpaceDayOff> dayOff = new SpaceService().selectSpaceDayOffBySpaceNo(spaceNo);
		Company company = new SpaceService().selectCompanyByCompanyNo(space.getCompanyNo());
		User u = new UserService().selectOne(company.getUserId());
		SpaceDibs jjimCheck = null;
		
		if(userId!=null) {
			SpaceDibs jjim = new SpaceDibs();
			jjim.setSpaceNo(spaceNo);
			jjim.setUserId(userId);
			jjimCheck = new CustomerService().selectCehckJjim(jjim);
		}
		
		
		List<Review> review = new ReviewService().selectReviewList(spaceNo,cPage, numPerPage );
		
		int totalContents = new ReviewService().selectTotalContents(spaceNo);
		int totalPage = (int)Math.ceil((double)totalContents/numPerPage);
		
		Paging paging = new Paging();
		paging.setPage(cPage);
		paging.setTotalCount(totalContents);
		
		request.setAttribute("space", space);
		request.setAttribute("review", review);
		request.setAttribute("paging", paging);
		request.setAttribute("spaceImg", spaceImg);
		request.setAttribute("dayOff", dayOff);
		request.setAttribute("company", company);
		request.setAttribute("jjimCheck", jjimCheck);
		request.setAttribute("user", u);
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
