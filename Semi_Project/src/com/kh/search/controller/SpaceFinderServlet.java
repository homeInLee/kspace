package com.kh.search.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.host.model.vo.SpaceImageFile;
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
		
		request.setCharacterEncoding("utf-8");
		
		String spaceSrch = "";
		String spaceType = "";
		String spaceArea = "";
		
		if(request.getParameter("spaceSrch") != null) {
			spaceSrch = request.getParameter("spaceSrch");
		}
		
		if(request.getParameter("spaceType") != null) {
			spaceType = request.getParameter("spaceType");
		}
		
		if(request.getParameter("spaceArea") != null) {
			spaceArea = request.getParameter("spaceArea");
		}
		
		List<SpaceJoin> list = new SearchService().selectSpaceList(spaceSrch, spaceType, spaceArea);
		List<SpaceImageFile> imageList = new SearchService().selectImageList();

		request.setAttribute("list", list);
		request.setAttribute("spaceSrch", spaceSrch);
		request.setAttribute("spaceType", spaceType);
		request.setAttribute("spaceArea", spaceArea);
		request.setAttribute("imageList", imageList);
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
