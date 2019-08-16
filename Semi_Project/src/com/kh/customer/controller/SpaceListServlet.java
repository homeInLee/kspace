package com.kh.customer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.customer.model.service.CustomerService;
import com.kh.host.model.vo.SpaceImageFile;
import com.kh.host.model.vo.SpaceJoin;
import com.kh.search.model.service.SearchService;

/**
 * Servlet implementation class SpaceListServlet
 */
@WebServlet("/customer/spaceList")
public class SpaceListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpaceListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.인코딩
		request.setCharacterEncoding("utf-8");
		
		//1.업무로직
		List<SpaceJoin> list = new CustomerService().selectSpaceList();
		List<SpaceImageFile> imageList = new CustomerService().selectImageList();
		
		//2.view단처리
		request.setAttribute("list", list);
		request.setAttribute("imageList", imageList);
		request.getRequestDispatcher("/WEB-INF/views/customer/spaceList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
