package com.kh.admin.banner.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.banner.model.service.BannerService;

/**
 * Servlet implementation class bannerDeleteServlet
 */
@WebServlet("/banner/bannerDelete")
public class bannerDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bannerDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bannerNo = Integer.parseInt(request.getParameter("bannerNo"));
		String renamedFileName = request.getParameter("renamedFileName");
		
		int result = new BannerService().deleteBanner(bannerNo);
		
		if(result > 0 && !"".equals(renamedFileName)) {
			String saveDirectory = getServletContext().getRealPath("/upload/banner");
			File delFile = new File(saveDirectory + File.separator + renamedFileName);
			
			boolean bool = delFile.delete();
			System.out.println("삭제여부 : " + bool);
		}
		
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "/";
		
		if(result >0)
			msg = "배너 삭제 성공!";
		else
			msg = "배너 삭제 실패!";
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher(view);
		reqDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
