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
});

//주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();
// 주소로 좌표를 검색합니다
geocoder.addressSearch('서울특별시 강남구 강남구 테헤란로14길 6', function(result, status) {
// 정상적으로 검색이 완료됐으면
	if (status === kakao.maps.services.Status.OK) {
		var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		// 결과값으로 받은 위치를 마커로 표시합니다
		var marker = new kakao.maps.Marker({
		    map: map,
		    position: coords
		});
		// 인포윈도우로 장소에 대한 설명을 표시합니다
		var infowindow = new kakao.maps.InfoWindow({
		    content: '<div style="width:150px;text-align:center;padding:6px 0;">kh정보교육원</div>'
		});
		infowindow.open(map, marker);
		// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		map.setCenter(coords);
		console.log(coords)
		$("#searchMap").attr("href", "https://map.kakao.com/link/to/kh정보교육원,"+coords.Ha+","+coords.Ga);
	}	 
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
            	<form action="" id="registerFrm" name="registerFrm" method="post" onsubmit="return validate();">
		            <input type="text" placeholder="아이디" id="memberId" name="memberId" required>
		            <input type="text" placeholder="이름" id="memberName" name="memberName" required>
		            <input type="password" placeholder="비밀번호" id="memberPwd" name="memberPwd" required>
		            <input type="password" placeholder="비밀번호 확인" id="memberPwd2" name="memberPwd2" required>
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
            	<form action="" id="hostRegisterFrm" name="hostRegisterFrm" method="post" onsubmit="return validate();">
		            <input type="text" placeholder="아이디" id="hostId" name="hostId" required>
		            <input type="text" placeholder="이름" id="hostName" name="hostName" required>
		            <input type="password" placeholder="비밀번호" id="hostPwd" name="hostPwd" required>
		            <input type="password" placeholder="비밀번호 확인" id="hostPwd2" name="hostPwd2" required>
		            <input type="text" placeholder="전화번호" id="hostPhone" name="memberPhone" required>
		            <input type="text" placeholder="이메일" id="hostEmail" name="memberEmail">
		            <input type="text" placeholder="회사 이름" id="hostEmail" name="memberEmail" required>
		            <input type="text" placeholder="회사 주소" id="hostEmail" name="memberEmail" required>
					<div class="txt_center">
						<input type="submit" value="회원가입">
						<input type="reset" value="초기화">
					</div>
				</form>
            </div>
        </article>
    </section>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>