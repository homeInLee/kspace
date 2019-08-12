package com.kh.admin.banner.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.banner.model.service.AdminService;

/**
 * Servlet implementation class SpaceEnrollOkServlet
 */
@WebServlet("/admin/spaceChk")
public class SpaceEnrollOkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpaceEnrollOkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int spaceNo = 0;
		System.out.println(request.getParameter("spaceChkNo"));
		try {
			spaceNo = Integer.parseInt(request.getParameter("spaceChkNo"));
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
		String spaceChk = "Y";
		
		int result = new AdminService().spaceChkOK(spaceNo, spaceChk);
		
		String msg = "";
		if(result > 0) {
			msg = "공간 등록을 허용하였습니다.";
		} else {
			msg = "공간 등록을 허용 실패하였습니다.";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", "/");
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
