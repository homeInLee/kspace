package com.kh.common.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.kh.common.util.MVCUtils;

public class EncryptWrapper extends HttpServletRequestWrapper{
	
	//부모타입에 기본생성자가 없음.
	//파라미터 생성자 반드시 구현할 것
	public EncryptWrapper(HttpServletRequest request) {
		super(request);
		
	}

	/**
	 * password파라미터 요청시,
	 * 암호화된 문자열을 리턴하도록 
	 * 메소드 오버라이딩
	 * -> 동적로딩에 의해 부모타입에서 메소드를 호출해도
	 * 자식객체의 오버라이딩된 메소드가 호출된다.
	 */
	@Override
	public String getParameter(String name) {
		String value = "";
		if(name != null && name.equals("password")) {
			System.out.println("암호화전: "+super.getParameter(name));
			//암호화처리
			value = MVCUtils.getSha512(super.getParameter(name));
			System.out.println("암호화후: "+value);
		}
		else {
			//password가 아닌 사용자입력값은 그대로 전달.
			value = super.getParameter(name);
		}
		return value;
	}
	
	@Override
	public String[] getParameterValues(String name) {
		String[] arr = super.getParameterValues(name);
		String[] value = new String[arr.length];
		
		if(name != null && name.equals("password")) {
			for(int i=0; i<arr.length; i++) {
				System.out.println("암호화전: "+arr[i]);				
			}
			
			//암호화처리
			for(int i=0; i<arr.length; i++) {
				value[i] = MVCUtils.getSha512(arr[i]);
				System.out.println("암호화후: "+value[i]);
			}
		}
		else {
			//password가 아닌 사용자입력값은 그대로 전달.
			value = super.getParameterValues(name);
		}
		return value;
	}

}