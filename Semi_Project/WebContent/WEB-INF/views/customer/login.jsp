<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/member.css" />
<script>
function validate(){
	if($("#memberId").val().trim().length == 0){
		alert("아이디를 입력하세요.");
		$("#memberId").focus();
		return false;
	}
	if($("#memberPwd").val().trim().length == 0){
		alert("비밀번호를 입력하세요.");
		$("#memberPwd").focus();
		return false;
	}
	
	return true;
}
</script>
<div class="sub_container">
    <section class="login-wrap">
        <article>
            <h3 class="tit txt_center">로그인</h3>
            <div class="regFrm logrinFrm">	
            	<form action="<%=request.getContextPath()%>/customer/reallogin" id="logrinFrm" name="logrinFrm" method="post" onsubmit="return validate();">
		            <input type="text" placeholder="아이디" id="memberId" name="memberId" required>
		            <input type="password" placeholder="비밀번호" id="memberPwd" name="memberPwd" required>
					<div class="checks">
						<input type="checkbox" name="saveId" id="saveId" <%-- <%=saveId?"checked":"" %> --%>/>
						<label for="saveId">아이디 저장</label>
					</div>
					<div class="txt_center">
						<input type="submit" value="로그인">
						<a href="<%=request.getContextPath()%>/customer/signup" class="dp_ib">회원가입</a>
					</div>
				</form>
            </div>
        </article>
    </section>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>