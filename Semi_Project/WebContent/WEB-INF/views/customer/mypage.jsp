<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.kh.customer.model.vo.User"%>
<%@page import="com.kh.host.model.vo.Company"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	User u = (User)request.getAttribute("user");
	Company c = (Company)request.getAttribute("company");
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/member.css" />
<div class="sub_container">
    <section class="login-wrap">
        <article>
            <h3 class="tit txt_center">마이페이지</h3>
            <div class="regFrm myPage">	
            	<div class="txt_center">
            		<img src="<%=request.getContextPath() %>/images/mypageimg.PNG" alt="마이페이지" class="dp_ib" />
            		<p class="fw600"><%=u.getUserId()!=null?u.getUserId():"" %></p>
            	</div>
            	<table>
            		<tr>
            			<th>이름</th>
            			<td><%=u.getUserName()!=null?u.getUserName():"" %></td>
            		</tr>
            		<tr>
            			<th>전화번호</th>
            			<td><%=u.getPhone()!=null?u.getPhone():"" %></td>
            		</tr>
            		<tr>
            			<th>이메일</th>
            			<td><%=u.getEmail()!=null?u.getEmail():"" %></td>
            		</tr>
            		<tr>
            			<th>가입일</th>
            			<td><%=u.getEnrolldate()!=null?u.getEnrolldate():"" %></td>
            		</tr>
            		<tr>
            			<th>회원 유형</th>
            			<td><%=u.getFlag().equals("H")?"호스트":"일반" %></td>
            		</tr>
            		<% if(u.getFlag().equals("H")) { %>
            		<tr>
            			<th>회사명</th>
            			<td><%=c!=null&&c.getCompanyName()!=null?c.getCompanyName():"" %></td>
            		</tr>
            		<tr>
            			<th>회사 주소</th>
            			<td><%=c!=null&&c.getCompanyPlace()!=null?c.getCompanyPlace():"" %></td>
            		</tr>
            		<% } %>
            	</table>
            	<!-- <a href="" class="txt_center">회원 탈퇴하기</a> -->
            </div>
        </article>
    </section>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>