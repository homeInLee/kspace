package com.kh.admin.banner.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.host.model.service.SpaceService;
import com.kh.host.model.vo.Space;
import com.kh.host.model.vo.SpaceImageFile;
import com.kh.host.model.vo.SpacePrice;

/**
 * Servlet implementation class SpaceChkViewServlet
 */
@WebServlet("/admin/spaceCheckView")
public class SpaceChkViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpaceChkViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int spaceNo = Integer.parseInt(request.getParameter("spaceNo"));
		
		Space s = new SpaceService().spaceSelectOneBySpaceNo(spaceNo);
		List<SpaceImageFile> sImg = new SpaceService().selectSpaceImgBySpaceNo(spaceNo);
		List<SpacePrice> sPrice = new SpaceService().selectSpacePriceBySpaceNo(spaceNo);
		
		request.setAttribute("space", s);
		request.setAttribute("spaceImg", sImg);
		request.setAttribute("sPrice", sPrice);
		request.getRequestDispatcher("/WEB-INF/views/admin/spaceCheck.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
