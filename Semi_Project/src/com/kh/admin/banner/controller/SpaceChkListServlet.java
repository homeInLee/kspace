package com.kh.admin.banner.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.banner.model.service.AdminService;
import com.kh.admin.banner.model.vo.SpaceAll;

/**
 * Servlet implementation class SpaceChkListServlet
 */
@WebServlet("/admin/spaceChkList")
public class SpaceChkListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpaceChkListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//공간테이블에서 검수가 안된 데이터 가져오기
		List<SpaceAll> noChkSpaceList = new AdminService().selectNoChkSpace();
		request.setAttribute("noChkSpaceList", noChkSpaceList);
		request.getRequestDispatcher("/WEB-INF/views/admin/spaceCheckList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
