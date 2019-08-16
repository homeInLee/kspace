package com.kh.host.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.host.model.service.CompanyService;
import com.kh.host.model.service.SpaceService;
import com.kh.host.model.vo.Company;
import com.kh.host.model.vo.Space;
import com.kh.host.model.vo.SpaceDayOff;
import com.kh.host.model.vo.SpaceImageFile;
import com.kh.host.model.vo.SpacePrice;

/**
 * Servlet implementation class SpaceChkViewServlet
 */
@WebServlet(urlPatterns="/host/spaceHostListView",name="SpaceHostListViewServlet")
public class SpaceHostListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpaceHostListViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인한 아이디가 null이 아니고, 공간 등록한 호스트 아이디가 맞는지 확인
		
		int spaceNo = Integer.parseInt(request.getParameter("spaceNo"));
		
		Space s = new SpaceService().spaceSelectOneBySpaceNo(spaceNo);
		Company c = new CompanyService().CompanySelectOneByCompanyNo(s.getCompanyNo());
		List<SpaceImageFile> sImg = new SpaceService().selectSpaceImgBySpaceNo(spaceNo);
		List<SpacePrice> sPrice = new SpaceService().selectSpacePriceBySpaceNo(spaceNo);
		List<SpaceDayOff> sDayOff = new SpaceService().selectSpaceDayOffBySpaceNo(spaceNo);
		
		request.setAttribute("space", s);
		request.setAttribute("company", c);
		request.setAttribute("spaceImg", sImg);
		request.setAttribute("sPrice", sPrice);
		request.setAttribute("sDayOff", sDayOff);
		request.getRequestDispatcher("/WEB-INF/views/host/hostMySpaceEnrollView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
