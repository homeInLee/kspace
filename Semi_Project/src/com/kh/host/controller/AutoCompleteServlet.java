package com.kh.host.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.host.model.dao.SpaceDAO;
import com.kh.host.model.service.SpaceService;

/**
 * Servlet implementation class AutoCompleteServlet
 */
@WebServlet("/search/autoComplete.do")
public class AutoCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoCompleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/csv; charset=utf-8");
		
		String spaceSrch = request.getParameter("spaceSrch");
		
		List<String> nameList = new SpaceService().selectByName(spaceSrch);
		
		String csv = "";
		for(int i=0; i<nameList.size(); i++) {
			if(i!=0)
				csv += ",";
			
			csv += nameList.get(i);
		}
		
		response.getWriter().append(csv);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
