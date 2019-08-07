package com.kh.admin.banner.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.banner.model.service.BannerService;
import com.kh.admin.banner.model.vo.Banner;

/**
 * Servlet implementation class bannerUpdateServlet
 */
@WebServlet("/banner/bannerUpdate")
public class bannerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bannerUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String updateContent = request.getParameter("update");
		int bannerNo = Integer.parseInt(request.getParameter("bannerNo"));
		
		Banner b = new Banner();
		b.setBannerNo(bannerNo);
		b.setBannerContent(updateContent);
		
		int result = new BannerService().updateBanner(b);
		
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "/banner/information";
		
		if(result>0) {
			msg = "배너 수정 성공!";
		} else {
			msg = "배너 수정 실패!";
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
