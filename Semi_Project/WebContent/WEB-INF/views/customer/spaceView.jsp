<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@page import="com.kh.admin.banner.model.vo.SpaceAll"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.host.model.vo.Company"%>
<%@page import="com.kh.host.model.vo.SpaceDayOff"%>
<%@page import="com.kh.host.model.vo.SpaceImageFile"%>
<%@page import="com.kh.host.model.vo.Space"%>
<%@page import="com.kh.customer.model.vo.SpaceDibs"%>
<%
	Space s = (Space)request.getAttribute("space");

	String[] hashTagArr = null;
	if(s.getHashtag()!=null){
		hashTagArr = s.getHashtag().split(", ");
	}
	
	List<SpaceImageFile> spaceImg = (List<SpaceImageFile>)request.getAttribute("spaceImg");
	String yImg = null;
	String[] nImg = new String[4];
	if(!spaceImg.isEmpty()){
		for(int i=0; i<spaceImg.size(); i++){
			SpaceImageFile sImg = spaceImg.get(i);
			if(!sImg.getImageRenamedFileName().equals("") && sImg.getFlag().equals("Y")){
				yImg = sImg.getImageRenamedFileName();
			} else if(!sImg.getImageRenamedFileName().equals("") && sImg.getFlag().equals("N")){
				nImg[i] = sImg.getImageRenamedFileName();
			}
		}
	}
	
	List<SpaceDayOff> dayOffList = (List<SpaceDayOff>)request.getAttribute("dayOff");
	String dayOff = null;
	String dayOffReason = null;
	if(!dayOffList.isEmpty()){
		for(SpaceDayOff day : dayOffList){
			dayOff = day.getMaxSpaceDayOff();
			dayOffReason = day.getDayOffEvent();
		}
	}
	
	Company company = (Company)request.getAttribute("company");
	SpaceDibs jjimCheck = (SpaceDibs)request.getAttribute("jjimCheck");
%>
<script>
function insertBooking(){
	location.href = "<%=request.getContextPath()%>/customer/insertBooking?userId=datbot&spaceNo=1";
}

$(()=>{
	$("#jjim-btn").click(function(e){
		var jjim_info = {
			spaceNo : <%=request.getParameter("spaceNo") %>,
			userId : "JeonGaNe" //찜하는 사람 아이디 -> 로그인한 아이디, 로그인 안한 사람은 로그인 하게 할 것.
		}
		
		if(<%=jjimCheck!=null%>){ //찜 되어있으면,
			if(!confirm("찜한 공간을 취소하시겠습니까?")){
				return;
			}
			
			$.ajax({
				url: "<%=request.getContextPath()%>/customer/jjimDelete",
				type: "post",
				data: jjim_info,
				dataType : "json",
				success: function(data){
					if(data>0){
						alert("찜 취소되었습니다.");
						$("#jjim-btn img").attr("src", "<%=request.getContextPath()%>/images/heart.png");
					} else {
						alert("찜 취소 실패");
					}
				},
				error: function(jqxhr, textStatus, errorThrown){
					console.log("ajax 처리 실패!");
					console.log(jqxhr, textStatus, errorThrown);
				}
			});
		
		
		} else { //찜 안되어있으면,
			$.ajax({
				url: "<%=request.getContextPath()%>/customer/jjim",
				type: "post",
				data: jjim_info,
				dataType : "json",
				success: function(data){
					if(data>0){
						alert("해당 공간을 찜하였습니다.");
						$("#jjim-btn img").attr("src", "<%=request.getContextPath()%>/images/like.png");
					} else {
						alert("찜 실패");
					}
				},
				error: function(jqxhr, textStatus, errorThrown){
					console.log("ajax 처리 실패!");
					console.log(jqxhr, textStatus, errorThrown);
				}
			});
		}
		
	});
});
</script>
<style>
	#spaceViewTitleImg {
		background:url('<%=request.getContextPath() %>/upload/host/<%=yImg %>') no-repeat center center;
		background-size:cover;
	}
</style>
<div class="sub_container">
	<section id="spaceViewTitleImg">
		<% if(yImg==null) {%>
			<p class="txt_center" style="line-height:450px;">등록된 이미지가 없습니다.</p>
		<% } %>
		<%-- <% if(yImg!=null){ %>
		<img src="<%=request.getContextPath() %>/upload/host/<%=yImg %>" alt="대표이미지" class="dp_block" />
		<%} else { %>
			<p class="txt_center" style="line-height:450px;">등록된 이미지가 없습니다.</p>
		<% }%> --%>
		<button id="jjim-btn" class="dibs-area dp_block">
			<%if(jjimCheck!=null){ %>
				<img src="<%=request.getContextPath() %>/images/like.png" width="42" alt="찜하기" class="dp_block"/>
			<% } else { %>
				<img src="<%=request.getContextPath() %>/images/heart.png" width="42" alt="찜하기" class="dp_block"/>
			<% }%>
		</button>
	</section>
    <section class="spaceView-container subPage">
        <article>
        	<button onclick="insertBooking();">예약하기</button>
        	<div class="spaceInfo-container">
        		<h3 class="tit"><%=s.getSpaceName()!=null?s.getSpaceName():"" %></h3>
	            <p class="fw300"><%=s.getSpaceSlogan()!=null?s.getSpaceSlogan():"" %></p>
	            <div class="hashTags">
	            	<%if(hashTagArr!=null){
	            		for(int i=0; i<hashTagArr.length; i++){
	            	%>
	            	<span class="dp_ib">#<%=hashTagArr[i] %></span>
	            	<%		
	            		}
	            	} %>
	            </div>
	            <div id="spaceViewImg-wrap" class="spaceViewImg-wrap clearfix">
	            	<% for(int i=0; i<nImg.length; i++){
	            		if(nImg[i]!=null) { %>
	            	<div class="spaceViewImg"><img src="<%=request.getContextPath() %>/upload/host/<%=nImg[i] %>" class="dp_block" alt="" /></div>
	            	<% }
	            	} %>
	            </div>
	            <h4 class="fw300"><%=s.getSpaceSlogan()!=null?s.getSpaceSlogan():"" %></h4>
	            <h5 class="spaceInfo-tit">공간 소개</h5>
	            <div>
	            	<p><%=s.getSpaceIntro()!=null?s.getSpaceIntro():"" %></p>
	            	<table class="spaceInfo-tb">
	            		<tr>
	            			<th style="width:110px;">예약 가능 시간</th>
	            			<td><%=s.getBookingTime()!=null?s.getBookingTime():"" %></td>
	            		</tr>
	            		<tr>
	            			<th style="width:75px;">휴무일</th>
	            			<td>
	            				<%=dayOff!=null?dayOff:"없음" %>
	            				<%=dayOffReason!=null?"<br />"+dayOffReason:"" %>
	            			</td>
	            		</tr>
	            	</table>
	            </div>
	            <h5 class="spaceInfo-tit mt50">편의 시설</h5>
	            <p class="refund-info"><%=s.getSpaceFacilities()!=null?s.getSpaceFacilities():"없음" %></p>
	            <h5 class="spaceInfo-tit mt50">환불 규정 안내</h5>
	            <p class="refund-info">
	            	<span class="dp_block req">이용당일(첫 날) 이후에 환불 관련 사항은 호스트에게 직접 문의하셔야 합니다.</span>
	            	결제 후 2시간 이내 어쩌구
	            </p>
	            <table class="spaceInfo-tb refund-desk">
	            	<tr>
	            		<td>이용 8일전</td>
	            		<td>총 금액의 100% 환불</td>
	            	</tr>
	            	<tr>
	            		<td>이용 8일전</td>
	            		<td>총 금액의 100% 환불</td>
	            	</tr>
	            	<tr>
	            		<td>이용 8일전</td>
	            		<td>총 금액의 100% 환불</td>
	            	</tr>
	            </table>
	            <div class="spaceCompanyInfo-wrap">
	            	<div class="spaceCompanyInfo">
	            		<h3><%=s.getSpaceName()!=null?s.getSpaceName():"" %></h3>
	            		<p><%=company.getCompanyPlace()!=null?company.getCompanyPlace():"" %></p>
	            		<div class="txt_right">
	            			<a id="searchMap" href="" class="dp_ib txt_center" target="_blank">길찾기</a>
	            		</div>
	            	</div>
	            	<div id="spaceCompanyInfo-map" class="spaceCompanyInfo-map" style="height:450px;"></div>
	            </div>
	            <%@ include file="/WEB-INF/views/customer/review.jsp" %>
        	</div>
            <div class="reservation-container">
            <!-- 예약 -->
            </div>
        </article>
    </section>
</div>
<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=17a175acb43ce7feb97791cd23eb85e7&libraries=services"></script>
<script>
	var mapContainer = document.getElementById('spaceCompanyInfo-map'), // 지도를 표시할 div 
	mapOption = {
	    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	    level: 3 // 지도의 확대 레벨
	};  
	//지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption);
	
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
<%@ include file="/WEB-INF/views/common/footer.jsp" %>