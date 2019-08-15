package com.kh.customer.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.banner.model.vo.SpaceAll;
import com.kh.customer.model.service.CustomerService;
import com.kh.customer.model.vo.SpaceDibs;
import com.kh.host.model.vo.Space;

/**
 * Servlet implementation class JjimSpaceListServlet
 */
@WebServlet("/customer/jjimSpace")
public class JjimSpaceListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JjimSpaceListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = "JeonGaNe";
		
		List<SpaceDibs> jjimSpace = new CustomerService().selectJjimList(userId);
		
		//jjimSpace에 있는 공간번호들로 공간 정보 가져오기.
		List<SpaceAll> jjimList = new ArrayList<>();
		for(SpaceDibs s : jjimSpace) {
			System.out.println("SpaceDibs="+s);
			SpaceAll space = new CustomerService().selectSpace(s.getSpaceNo());
			jjimList.add(space);
		}
		
		System.out.println("jjimList="+jjimList);
		
		request.setAttribute("jjimList", jjimList);
		request.getRequestDispatcher("/WEB-INF/views/customer/jjimSpace.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
