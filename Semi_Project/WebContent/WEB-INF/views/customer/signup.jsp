<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/member.css" />
<script>
$(document).ready(function(){
	$(".regFrm").hide();
	$(".registerFrm").show();
	$("input[name=registerChoose]").on('change', function(){
		var regChoose = $(this).attr("id");
		$(".regFrm").hide();
		$("."+regChoose+"Frm").show();
	});
	
	$("#hostId").on("change paste keyup", function() {
		
		var hostId = $(this).val();
		
		$.ajax({
			type: "post",
			url: "<%=request.getContextPath()%>/host/hostIdCheck",
			data: {
				hostId : hostId
			},
			dataType: "json",
			success: function(result) {
				if (result == 1) {
                    $("#hostIdCheck").html("아이디를 6글자 이상 입력해주세요");
                } else if(result == -1) {
                	$("#hostIdCheck").html("중복된 아이디입니다");
                } else {
                	$("#hostIdCheck").html("좋은 아이디에요!");
                }
			}
		});
	});
	
	$('#hostPwd2').change(function(){
		var hostPwd = $("#hostPwd").val();
		var hostPwd2 = $(this).val();
		
		   if(hostPwd != hostPwd2){
			   $("#hostPwd2Check").html("비밀번호가 일치하지 않습니다");
			   $('#hostPwd2').focus();
		   } else {
			   $("#hostPwd2Check").html("비밀번호 일치!");
		   }
	});
	
	$("#memberId").on("change paste keyup", function() {
		
		var memberId = $(this).val();
		
		$.ajax({
			type: "post",
			url: "<%=request.getContextPath()%>/customer/memberIdCheck",
			data: {
				memberId : memberId
			},
			dataType: "json",
			success: function(result) {
				if (result == 1) {
                    $("#memberIdCheck").html("아이디를 6글자 이상 입력해주세요");
                } else if(result == -1) {
                	$("#memberIdCheck").html("중복된 아이디입니다");
                } else {
                	$("#memberIdCheck").html("좋은 아이디에요!");
                }
			}
		});
	});
	
	$('#memberPwd2').change(function(){
		var hostPwd = $("#memberPwd").val();
		var hostPwd2 = $(this).val();
		
		   if(hostPwd != hostPwd2){
			   $("#memberPwd2Check").html("비밀번호가 일치하지 않습니다");
			   $('#memberPwd2').focus();
		   } else {
			   $("#memberPwd2Check").html("비밀번호 일치!");
		   }
	});

});
</script>
<div class="sub_container">
    <section class="login-wrap">
        <article>
            <h3 class="tit txt_center">회원가입</h3>
            <div class="checks txt_center">
            	<input type="radio" name="registerChoose" id="register" checked />
            	<label for="register">일반 회원가입</label>
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	<input type="radio" name="registerChoose" id="hostRegister" />
            	<label for="hostRegister">호스트 회원가입</label>
            </div>
            <!-- 일반 회원가입 폼 -->
            <div class="regFrm registerFrm">	
            	<form action="<%=request.getContextPath() %>/customer/memberInsert" id="registerFrm" name="registerFrm" method="post" onsubmit="return validate();">
		            <input type="text" placeholder="아이디" id="memberId" name="memberId" required>
		            <span id="memberIdCheck" class="effectCheck"></span>
		            <input type="text" placeholder="이름" id="memberName" name="memberName" required>
		            <input type="password" placeholder="비밀번호" id="memberPwd" name="memberPwd" required>
		            <input type="password" placeholder="비밀번호 확인" id="memberPwd2" name="memberPwd2" required>
		            <span id="memberPwd2Check" class="effectCheck"></span>
		            <input type="text" placeholder="전화번호" id="memberPhone" name="memberPhone" required>
		            <input type="text" placeholder="이메일" id="memberEmail" name="memberEmail">
					<div class="txt_center">
						<input type="submit" value="회원가입">
						<input type="reset" value="초기화">
					</div>
				</form>
            </div>
            <!-- 호스트 회원가입 폼 -->
            <div class="regFrm hostRegisterFrm">	
            	<form action="<%=request.getContextPath() %>/host/hostInsert" id="hostRegisterFrm" name="hostRegisterFrm" method="post" onsubmit="return validate();">
		            <input type="hidden" id="coordsHa" name="coordsHa">
		            <input type="hidden" id="coordsGa" name="coordsGa">
		            <input type="text" placeholder="아이디" id="hostId" name="hostId" required>
		            <span id="hostIdCheck" class="effectCheck"></span>
		            <input type="text" placeholder="이름" id="hostName" name="hostName" required>
		            <input type="password" placeholder="비밀번호" id="hostPwd" name="hostPwd" required>
		            <input type="password" placeholder="비밀번호 확인" id="hostPwd2" name="hostPwd2" required>
		            <span id="hostPwd2Check" class="effectCheck"></span>
		            <input type="text" placeholder="전화번호" id="hostPhone" name="hostPhone" required>
		            <input type="text" placeholder="이메일" id="hostEmail" name="hostEmail">
		            <input type="text" placeholder="회사 이름" id="companyName" name="companyName" required>
		            <input type="text" placeholder="회사 주소" id="companyPlace" name="companyPlace" required>
		            <input type="number" placeholder="수수료" id="companyFee" name="companyFee">
					<div class="txt_center">
						<input type="submit" value="회원가입">
						<input type="reset" value="초기화">
					</div>
				</form>
            </div>
        </article>
    </section>
</div>
<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=17a175acb43ce7feb97791cd23eb85e7&libraries=services"></script>
<script>
$("#companyPlace").focusout(function() {
	var geocoder = new kakao.maps.services.Geocoder();
	
	// 주소로 좌표를 검색합니다
	geocoder.addressSearch($("#companyPlace").val(), function(result, status) {
	// 정상적으로 검색이 완료됐으면
	if (status === kakao.maps.services.Status.OK) {
		var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		// 결과값으로 받은 위치를 마커로 표시합니다
		
		console.log(coords)
		//$("#searchMap").attr("href", "https://map.kakao.com/link/to/"+ $("#companyName").val() +","+coords.Ha+","+coords.Ga);
		$("#coordsHa").val(coords.Ha);
		$("#coordsGa").val(coords.Ga);
	}
	});
//주소-좌표 변환 객체를 생성합니다
});
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>