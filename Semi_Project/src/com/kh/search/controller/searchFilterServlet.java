package com.kh.search.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.host.model.vo.SpaceJoin;
import com.kh.search.model.service.SearchService;

/**
 * Servlet implementation class searchFilterServlet
 */
@WebServlet("/search/searchFilter")
public class searchFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public searchFilterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int srchPrice1 = 0;
		int srchPrice2 = 0;
		List<SpaceJoin> list = null;

		if (request.getParameter("srchPrice1") != null && !request.getParameter("srchPrice1").equals("")) {
			try {

				srchPrice1 = Integer.parseInt(request.getParameter("srchPrice1"));

			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (request.getParameter("srchPrice2") != null && !request.getParameter("srchPrice2").equals("")) {
			try {
				srchPrice2 = Integer.parseInt(request.getParameter("srchPrice2"));

			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String[] facility = request.getParameterValues("facility");
		
		String spaceSrch = request.getParameter("spaceSrch");
		String spaceType = "";
		
		List<SpaceJoin> spaceList = new SearchService().selectSpaceList(spaceSrch, spaceType);

		if(srchPrice2 != 0 && facility != null) {
			list = new SearchService().selectFilterList(srchPrice1, srchPrice2, facility, spaceList);			
		} else if(srchPrice2 == 0 && facility != null) {
			list = new SearchService().selectFilterPriceZeroList(srchPrice1, facility, spaceList);
		} else if(srchPrice2 != 0 && facility == null) {
			list = new SearchService().selectFilterFacilityNullList(srchPrice1, srchPrice2, spaceList);
		} else {
			list = new SearchService().selectFilterNullList(srchPrice1, spaceList);
		}

		request.setAttribute("list", list);
		request.setAttribute("spaceSrch", spaceSrch);
		request.getRequestDispatcher("/WEB-INF/views/search/spaceFilter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
