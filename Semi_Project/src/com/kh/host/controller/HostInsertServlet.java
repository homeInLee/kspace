package com.kh.host.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.customer.model.vo.User;
import com.kh.host.model.service.HostService;
import com.kh.host.model.vo.Company;

/**
 * Servlet implementation class HostInserServlet
 */
@WebServlet("/host/hostInsert")
public class HostInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HostInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String hostId = request.getParameter("hostId");
		String hostName = request.getParameter("hostName");
		String hostPwd = request.getParameter("hostPwd");
		String hostPhone = request.getParameter("hostPhone");
		String hostEmail = request.getParameter("hostEmail");
		String companyName = request.getParameter("companyName");
		String companyPlace = request.getParameter("companyPlace");
		
		User u = new User();
		u.setUserId(hostId);
		u.setUserName(hostName);
		u.setPassword(hostPwd);
		u.setPhone(hostPhone);
		u.setEmail(hostEmail);
		
		Company c = new Company();
		c.setCompanyName(companyName);
		c.setCompanyPlace(companyPlace);
		
		int result = new HostService().InsertUserHost(u);
		int result2 = new HostService().InsertCompany(c, hostId);
		
		String msg = "";
		String loc = "/";
		if(result>0 && result2>0) {
			msg = "회원 등록성공!";
		}
		else {
			msg = "회원 등록실패!";
		}

		//3.view단 처리
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
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
