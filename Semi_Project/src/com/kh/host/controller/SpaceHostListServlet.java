package com.kh.host.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.admin.banner.model.vo.SpaceAll;
import com.kh.customer.model.vo.User;
import com.kh.host.model.service.HostService;

/**
 * Servlet implementation class SpaceHostListServlet
 */
@WebServlet(urlPatterns="/host/mySpaceList",name="SpaceHostListServlet")
public class SpaceHostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpaceHostListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//공간테이블에서 본인이 쓴 리스트 가져오기
		HttpServletRequest httpreq = (HttpServletRequest)request;
		HttpSession session = httpreq.getSession();
		User memberLoggedIn = (User)session.getAttribute("memberLoggedIn");
		
		String hostId = null;
		if(memberLoggedIn!=null) {
			hostId = memberLoggedIn.getUserId();
		}
		//String hostId = "JeonGaNe";
		List<SpaceAll> hostSpaceList = new HostService().selectSpaceListByHostId(hostId);
		request.setAttribute("hostSpaceList", hostSpaceList);
		request.getRequestDispatcher("/WEB-INF/views/host/spaceHostEnrollList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
