<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/member.css" />
<div class="sub_container">
    <section class="login-wrap">
        <article>
            <h3 class="tit txt_center">마이페이지</h3>
            <div class="regFrm myPage">	
            	<div class="txt_center">
            		<img src="<%=request.getContextPath() %>/images/mypageimg.PNG" alt="마이페이지" class="dp_ib" />
            		<p class="fw600">아이디</p>
            	</div>
            	<table>
            		<tr>
            			<th>이름</th>
            			<td>ㅇㅇㅇㅇㅇㅇㅇㅇ</td>
            		</tr>
            		<tr>
            			<th>전화번호</th>
            			<td>010-1234-1234</td>
            		</tr>
            		<tr>
            			<th>이메일</th>
            			<td>abcd@naver.com</td>
            		</tr>
            		<tr>
            			<th>가입일</th>
            			<td>ㅇㅇㅇ</td>
            		</tr>
            		<tr>
            			<th>회원 유형</th>
            			<td>호스트or일반</td>
            		</tr>
            		<tr>
            			<th>회사명</th>
            			<td>ㅋㅋ</td>
            		</tr>
            		<tr>
            			<th>회사 주소</th>
            			<td>서울특별시</td>
            		</tr>
            	</table>
            	<!-- <a href="" class="txt_center">회원 탈퇴하기</a> -->
            </div>
        </article>
    </section>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>