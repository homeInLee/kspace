package com.kh.search.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.host.model.vo.SpaceJoin;
import com.kh.search.model.service.SearchService;

/**
 * Servlet implementation class SpaceFinderServlet
 */
@WebServlet("/search/spaceFinder")
public class SpaceFinderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpaceFinderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String spaceSrch = request.getParameter("spaceSrch");
		String spaceType = "";
		
		if(spaceSrch.equals("")) {
			request.setAttribute("msg", "검색어를 입력해주세요.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		if(request.getParameter("spaceType") != null) {
			spaceType = request.getParameter("spaceType");
		}
		
		List<SpaceJoin> list = new SearchService().selectSpaceList(spaceSrch, spaceType);
		
		
		request.setAttribute("list", list);
		request.setAttribute("spaceSrch", spaceSrch);
		request.setAttribute("spaceType", spaceType);
		request.getRequestDispatcher("/WEB-INF/views/search/spaceFinder.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
