package com.kh.host.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.host.model.service.SpaceService;

/**
 * Servlet implementation class SpaceDeleteServlet
 */
@WebServlet(urlPatterns="/host/delMySpace",name="SpaceDeleteServlet")
public class SpaceDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpaceDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int delSpaceNo = 0;
		try {
			delSpaceNo = Integer.parseInt(request.getParameter("delSpaceNo"));
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
		System.out.println("delSpaceNo:"+delSpaceNo);
		int result = new SpaceService().deleteSpace(delSpaceNo);
		
		String msg = "";
		if(result>0) {
			msg = "공간이 삭제되었습니다.";
		} else {
			msg = "공간 삭제 실패";
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
