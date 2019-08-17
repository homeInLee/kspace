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
import com.kh.host.model.service.SpaceService;
import com.kh.host.model.vo.Company;
import com.kh.host.model.vo.Space;

/**
 * Servlet Filter implementation class SpaceHostListViewFilter
 */
@WebFilter(servletNames = { "SpaceHostListViewServlet" })
public class SpaceHostListViewFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SpaceHostListViewFilter() {
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
		
		int spaceNo = Integer.parseInt(request.getParameter("spaceNo"));
		Space s = new SpaceService().spaceSelectOneBySpaceNo(spaceNo);
		
		int companyNo = s.getCompanyNo();
		Company c = new SpaceService().selectCompanyByCompanyNo(companyNo);
		
		//로그인한 아이디가 해당 공간을 등록한 아이디만 열람 가능.
		if(memberLoggedIn!= null && !memberLoggedIn.getUserId().equals(c.getUserId())) {
			request.setAttribute("msg", "공간을 등록한 호스트 회원만 볼 수 있습니다.");
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
