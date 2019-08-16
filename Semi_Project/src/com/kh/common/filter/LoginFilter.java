package com.kh.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kh.customer.model.vo.User;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(
		servletNames = { 
				"BookingCancleServlet", 
				"BookingListServlet", 
				"BookingSelectServlet", 
				"CustomerReviewDeleteServlet",
				"CustomerReviewInsertServlet", 
				"InsertBookingServlet",
				"CustomerReviewDeleteServlet", 
				"JjimDeleteServlet", 
				"JjimSpaceListServlet", 
				"JjimServlet", 
				"MypageServlet",
				"SpaceHostListViewServlet", 
				"SpaceHostListServlet", 
				"SpaceChkViewServlet",
				"SpaceUpdateServlet",
				"SpaceDeleteServlet",
				"SpaceEnrollEndServlet",
				"SpaceEnrollServlet"
		})
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpreq = (HttpServletRequest)request;
		HttpSession session = httpreq.getSession();
		User memberLoggedIn = (User)session.getAttribute("memberLoggedIn");
		
		//로그인 하지 않은 경우
		if(memberLoggedIn == null) {
			
			request.setAttribute("msg", "로그인 후 이용하실 수 있습니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			
			return;
		}
		
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
