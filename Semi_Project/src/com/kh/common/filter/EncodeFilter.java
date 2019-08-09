package com.kh.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

public class EncodeFilter implements Filter {
	
	private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//System.out.println("EncodeFilter.init() 호출됨!!");
		this.filterConfig=filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//web.xml에서 init-param으로 선언한 utf-8 값 가져오기.
		String encodeType = filterConfig.getInitParameter("encodeType"); //utf-8
		
		//request 객체 인코딩 처리
		request.setCharacterEncoding(encodeType);
		System.out.println("[[ Encoding: "+encodeType+" 처리됨!! ]]");
		
		//필터체인 호출 : 다음 필터로 전달
		//다음 필터가 없다면, 서블릿 호출
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
