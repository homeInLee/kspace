<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sub.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/member.css" />
<div class="sub_container">
    <section class="login-wrap">
        <article>
            <h3 class="tit txt_center">회원가입</h3>
            <form action="" id="enrollFrm" name="enrollFrm" method="post" onsubmit="return validate();">
	            <input type="text" placeholder="아이디" id="memberId" name="memberId" required>
	            <input type="text" placeholder="이름" id="memberName" name="memberName" required>
	            <input type="password" placeholder="비밀번호" id="memberPwd" name="memberPwd" required>
	            <input type="password" placeholder="비밀번호 확인" id="memberPwd2" name="memberPwd2" required>
	            <input type="text" placeholder="전화번호" id="memberPhone" name="memberPhone" required>
	            <input type="text" placeholder="이메일" id="memberEmail" name="memberEmail">
				<input type="submit" value="회원가입">
				<input type="reset" value="취소">
			</form>
        </article>
    </section>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>