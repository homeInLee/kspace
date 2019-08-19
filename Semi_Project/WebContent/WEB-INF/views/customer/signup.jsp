<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/member.css" />
<script>
var checkHostId = 0;
var checkMemberId = 0;

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
                	checkHostId = -1;
                } else {
                	$("#hostIdCheck").html("좋은 아이디에요!");
                }
			}
		});
	});
	
	$('#hostPwd2').on("change paste keyup", function(){
		var hostPwd = $("#hostPwd").val();
		var hostPwd2 = $(this).val();
		
		   if(hostPwd != hostPwd2 && hostPwd2 != ""){
			   $("#hostPwd2Check").html("비밀번호가 일치하지 않습니다");
			   $('#hostPwd2').focus();
		   } else if(hostPwd == hostPwd2 && hostPwd2 != "") {
			   $("#hostPwd2Check").html("비밀번호 일치!");
		   } else {
			   $("#hostPwd2Check").html("");
		   }
	});
	
	$("#hostPwd2").on("focus", function() {
		var hostPwd = $("#hostPwd").val();
		
		if(hostPwd == "") {
			alert("먼저 비밀번호란을 입력해주세요!");
			$("#hostPwd").focus();
		}
	});
	
	$("#memberId").on("change paste keyup", function() {
		
		var memberId = $(this).val();
		check = -1;
		
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
                	checkMemberId = -1
                } else {
                	$("#memberIdCheck").html("좋은 아이디에요!");
                }
			}
		});
	});
	
	$('#memberPwd2').on("change paste keyup", function(){
		var memberPwd = $("#memberPwd").val();
		var memberPwd2 = $(this).val();
		
		   if(memberPwd != memberPwd2 && memberPwd2 != ""){
			   $("#memberPwd2Check").html("비밀번호가 일치하지 않습니다");
			   $('#memberPwd2').focus();
		   } else if(memberPwd == memberPwd2 && memberPwd2 != "") {
			   $("#memberPwd2Check").html("비밀번호 일치!");
		   } else {
			   $("#memberPwd2Check").html("");
		   }
	});
	
	$("#memberPwd2").on("focus", function() {
		var hostPwd = $("#memberPwd").val();
		
		if(hostPwd == "") {
			alert("먼저 비밀번호란을 입력해주세요!");
			$("#memberPwd").focus();
		}
	});
	
	$("#companyFee").on("change paste keyup", function() {
		var companyFee = $("#companyFee").val();
		
		if(companyFee < 10 && companyFee != "") {
			$("#companyFeeCheck").html("수수료는 10이상부터 가능합니다.");
		} else if(companyFee > 10 && companyFee != "") {
			$("#companyFeeCheck").html("");
		} else {
			$("#companyFeeCheck").html("");
		}
	});
	
	$("#hostResetButton").on("click", function() {
		$("#hostIdCheck").html("");
		$("#hostPwd2Check").html("");
		$("#companyFeeCheck").html("");
	});
	
	$("#memberResetButton").on("click", function() {
		$("#memberIdCheck").html("");
		$("#memberPwd2Check").html("");
	});
});

function hostEnrollCheck() {
	var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
    var getCheck= RegExp(/^[a-zA-Z0-9]{6,12}$/);
    var getName= RegExp(/^[가-힣]+$/);
    var getPhone = RegExp(/^[0-9]+$/);
    
  //아이디 공백 확인
    if($("#hostId").val() == ""){
      alert("아이디를 입력해주세요");
      $("#hostId").focus();
      return false;
    }

    //아이디의 유효성 검사
    if(!getCheck.test($("#hostId").val())){
      alert("아이디를 형식에 맞게 입력해주세요");
      $("#hostId").val("");
      $("#hostId").focus();
      return false;
    }
    
    // 증복체크
    if(checkHostId == -1) {
    	alert("중복된 아이디입니다");
    	$("#hostId").val("");
        $("#hostId").focus();
    	return false;
    }

    //이름 유효성
    if (!getName.test($("#hostName").val())) {
      alert("이름을 한글로 입력해주세요");
      $("#hostName").val("");
      $("#hostName").focus();
      return false;
    }

    //비밀번호
    if(!getCheck.test($("#hostPwd").val())) {
    alert("비밀번호를 형식에 맞게 입력해주세요");
    $("#hostPwd").val("");
    $("#hostPwd").focus();
    return false;
    }

    //아이디랑 비밀번호랑 같은지
    if ($("#hostId").val()==($("#hostPwd").val())) {
    alert("비밀번호가 ID와 같습니다");
    $("#hostPwd").val("");
    $("#hostPwd").focus();
  	}

    //비밀번호 똑같은지
    if($("#hostPwd").val() != ($("#hostPwd2").val())){ 
    alert("비밀번호가 다릅니다");
    $("#hostPwd2").val("");
    $("#hostPwd2").focus();
    return false;
   }
    
    // 전화번호 유효성
    if(!getPhone.test($("#hostPhone").val())) {
    	alert("전화번호는 숫자만 입력해주세요");
    	$("#hostPhone").val("");
    	$("#hostPhone").focus;
    	return false;
    }
         
    //이메일 유효성 검사
    if(!getMail.test($("#hostEmail").val())){
      alert("이메일형식에 맞게 입력해주세요");
      $("#hostEmail").val("");
      $("#hostEmail").focus();
      return false;
    }
    
    // 수수료 유효성
    if($("#companyFee").val() < 10 && $("#companyFee").val() != "") {
    	alert("수수료는 10 이상부터 가능합니다");
    	$("#companyFee").val("");
    	$("#companyFee").focus;
    	return false;
    }
};

function memberEnrollCheck() {
	var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
    var getCheck= RegExp(/^[a-zA-Z0-9]{6,12}$/);
    var getName= RegExp(/^[가-힣]+$/);
    var getPhone = RegExp(/^[0-9]+$/);
	
	//아이디 공백 확인
    if($("#memberId").val() == ""){
      alert("아이디를 입력해주세요");
      $("#memberId").focus();
      return false;
    }

    //아이디의 유효성 검사
    if(!getCheck.test($("#memberId").val())){
      alert("아이디를 형식에 맞게 입력해주세요");
      $("#memberId").val("");
      $("#memberId").focus();
      return false;
    }
    
    // 아이디 중복체크
    if(checkMemberId == -1) {
    	alert("중복된 아이디입니다");
    	$("#memberId").val("");
        $("#memberId").focus();
    	return false;
    }

    //이름 유효성
    if (!getName.test($("#memberName").val())) {
      alert("이름을 한글로 입력해주세요");
      $("#memberName").val("");
      $("#memberName").focus();
      return false;
    }

    //비밀번호
    if(!getCheck.test($("#memberPwd").val())) {
    alert("비밀번호를 형식에 맞게 입력해주세요");
    $("#memberPwd").val("");
    $("#memberPwd").focus();
    return false;
    }

    //아이디랑 비밀번호랑 같은지
    if ($("#memberId").val()==($("#memberPwd").val())) {
    alert("비밀번호가 ID와 같습니다");
    $("#memberPwd").val("");
    $("#memberPwd").focus();
  	}

    //비밀번호 똑같은지
    if($("#memberPwd").val() != ($("#memberPwd2").val())){ 
    alert("비밀번호가 다릅니다");
    $("#memberPwd2").val("");
    $("#memberPwd2").focus();
    return false;
   }
    
    // 전화번호 유효성
    if(!getPhone.test($("#memberPhone").val())) {
    	alert("전화번호는 숫자만 입력해주세요");
    	$("#memberPhone").val("");
    	$("#memberPhone").focus;
    	return false;
    }
         
    //이메일 유효성 검사
    if(!getMail.test($("#memberEmail").val())){
      alert("이메일형식에 맞게 입력해주세요");
      $("#memberEmail").val("");
      $("#memberEmail").focus();
      return false;
    }
};
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
            	<form onsubmit="return memberEnrollCheck()" action="<%=request.getContextPath() %>/customer/memberInsert" id="registerFrm" name="registerFrm" method="post" onsubmit="return validate();">
		     		<input type="text" placeholder="아이디 (영어, 숫자만 가능 6~12글자)"" id="memberId" name="memberId" required>
		            <span id="memberIdCheck" class="effectCheck"></span>
		            <input type="text" placeholder="이름" id="memberName" name="memberName" required>
		            <input type="password" placeholder="비밀번호 (영어, 숫자만 가능 6~12글자)"" id="memberPwd" name="memberPwd" required>
		            <input type="password" placeholder="비밀번호 확인" id="memberPwd2" name="memberPwd2" required>
		            <span id="memberPwd2Check" class="effectCheck"></span>
		            <input type="text" placeholder="전화번호 (- 제외)" id="memberPhone" name="memberPhone" required>
		            <input type="text" placeholder="이메일" id="memberEmail" name="memberEmail">
					<div class="txt_center">
						<input type="submit" value="회원가입">
						<input type="reset" id="memberResetButton" value="초기화">
					</div>
				</form>
            </div>
            <!-- 호스트 회원가입 폼 -->
            <div class="regFrm hostRegisterFrm">	
            	<form onsubmit="return hostEnrollCheck()" action="<%=request.getContextPath() %>/host/hostInsert" id="hostRegisterFrm" name="hostRegisterFrm" method="post" onsubmit="return validate();">
		            <input type="hidden" id="coordsHa" name="coordsHa">
		            <input type="hidden" id="coordsGa" name="coordsGa">
		            <input type="text" placeholder="아이디 (영어, 숫자만 가능 6~12글자)" id="hostId" name="hostId" required>
		            <span id="hostIdCheck" class="effectCheck"></span>
		            <input type="text" placeholder="이름" id="hostName" name="hostName" required>
		            <input type="password" placeholder="비밀번호 (영어, 숫자만 가능 6~12글자)" id="hostPwd" name="hostPwd" required>
		            <input type="password" placeholder="비밀번호 확인" id="hostPwd2" name="hostPwd2" required>
		            <span id="hostPwd2Check" class="effectCheck"></span>
		            <input type="text" placeholder="전화번호 (- 제외)" id="hostPhone" name="hostPhone" required>
		            <input type="text" placeholder="이메일" id="hostEmail" name="hostEmail">
		            <input type="text" placeholder="회사 이름" id="companyName" name="companyName" required>
		            <input type="text" placeholder="회사 주소" id="companyPlace" name="companyPlace" required>
		            <input type="number" placeholder="수수료" id="companyFee" name="companyFee">
		            <span id="companyFeeCheck" class="effectCheck"></span>
					<div class="txt_center">
						<input type="submit" value="회원가입">
						<input type="reset" id="hostResetButton" value="초기화">
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