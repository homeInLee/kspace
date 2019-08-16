package com.kh.customer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.customer.model.service.UserService;
import com.kh.customer.model.vo.User;

/**
 * Servlet implementation class LoginRealServlet
 */
@WebServlet("/customer/reallogin")
public class LoginRealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginRealServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String saveId = request.getParameter("saveId");
		User user = new User();
		user.setUserId(memberId);
		user.setPassword(memberPwd);
		System.out.println("user@loginSerlvet="+user);
		int result = new UserService().loginCheck(user);
		
		System.out.println("result@LoginServlet="+result);
		//3.view단 선정처리
		String view = "";
		String loc = "/";
		
		String referer = (String) request.getSession().getAttribute("redirectURI");
		String origin = request.getHeader("Origin");
		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI();
		
		System.out.println("referer="+referer);
		System.out.println("origin="+origin);
		System.out.println("url="+url);
		System.out.println("uri="+uri);
		
		int idx = referer.indexOf(request.getContextPath())+request.getContextPath().length();
		loc = referer.substring(idx);
		System.out.println("loc="+loc);
		
		
		if(result == UserService.LOGIN_OK) {
			view = "/index.jsp";
			//로그인한 사용자정보를 가져오기
			User memberLoggedIn = new UserService().selectOne(memberId);
//			request.setAttribute("memberLoggedIn", memberLoggedIn);
			
			//클라이언트(브라우져)에서 최초요청시,
			//tomcat 유일한 session id값을 발행함.
			//response에 session id 값을 리턴함.
			//이후 session id는 쿠키(클라이언트)로 보관.
			//매요청시 session id값 함께 전송
			
			//세션에 로그인한 사용자 정보를 담는다.
			//create여부 파라미터로 전달(기본값 true)
			//세션객체가 있으면, 해당 객체를 리턴
			//없으면, 세션객체 생성후, 해당 객체를 리턴(브라우져 최초 접속시)
			HttpSession session = request.getSession(true);
			//web.xml보다 우선순위가 높은 세션유효기간 설정
			session.setMaxInactiveInterval(10*60);
			System.out.println("sessionId="+session.getId());
			session.setAttribute("memberLoggedIn", memberLoggedIn);
			System.out.println("memberLoggedIn="+memberLoggedIn);
			//아이디 저장관련 쿠키처리
			if(saveId != null) {
				Cookie c = new Cookie("saveId", memberId);
				c.setMaxAge(7*24*60*60);//쿠키유효기간 7일(초단위로 설정)
				c.setPath("/");//쿠키사용디렉토리.지정디렉토리의 url요청시 해당쿠기사용
				response.addCookie(c);
			}
			else {
				//쿠키삭제
				Cookie c = new Cookie("saveId", memberId);
				c.setMaxAge(0);//쿠키 유효기간 0으로 삭제
				c.setPath("/");
				response.addCookie(c);
			}
			
			//로그인 성공후에는 view단 없이 리다이렉트시킴.
//			response.sendRedirect(request.getContextPath());// http://localhost:9090/mvc
			response.sendRedirect(referer);
			
		}
		else {
			view = "/WEB-INF/views/common/msg.jsp";
			String msg = "";
			if(result == UserService.WRONG_PASSWORD) {
				msg = "비밀번호가 틀렸습니다.";
			}
			else if(result == UserService.ID_NOT_EXIST) {
				msg = "아이디가 존재하지 않습니다.";
			}
			
			//처리할 정보를 request속성으로 저장
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
			
			//로그인 실패시만, msg.jsp를 뷰단으로 사용
			RequestDispatcher reqDispatcher = request.getRequestDispatcher(view);
			reqDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
