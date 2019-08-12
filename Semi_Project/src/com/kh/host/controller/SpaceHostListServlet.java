package com.kh.host.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.banner.model.vo.SpaceAll;
import com.kh.host.model.service.HostService;

/**
 * Servlet implementation class SpaceHostListServlet
 */
@WebServlet("/host/mySpaceList")
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
		//String hostId = request.getParameter("");
		String hostId = "JeonGaNe";
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
