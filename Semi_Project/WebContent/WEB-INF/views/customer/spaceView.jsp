<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@page import="com.kh.admin.banner.model.vo.SpaceAll"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.host.model.vo.Company"%>
<%@page import="com.kh.host.model.vo.SpaceDayOff"%>
<%@page import="com.kh.host.model.vo.SpaceImageFile"%>
<%@page import="com.kh.host.model.vo.Space"%>
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
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sub.css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/js/slick/slick.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$(".spaceViewImg-wrap").slick({
	    infinite: true,
	    speed:500,
	    autoplay: true,
	    autoplaySpeed: 3000,
	    slidesToShow: 1,
	    slidesToScroll: 1,
	    adaptiveHeight: true
	});
});
</script>
<script>
function insertBooking(){
	location.href = "<%=request.getContextPath()%>/customer/insertBooking?userId=datbot&spaceNo=1";
}
</script>
<div class="sub_container">
	<section id="spaceViewTitleImg">
		<% if(yImg!=null){ %>
		<img src="<%=request.getContextPath() %>/upload/host/<%=yImg %>" alt="대표이미지" class="dp_block" />
		<%} else { %>
			<p class="txt_center" style="line-height:450px;">등록된 이미지가 없습니다.</p>
		<% }%>
		<a href="" class="dibs-area dp_block">
			<img src="<%=request.getContextPath() %>/images/heart.png" width="42" alt="찜하기" class="dp_block"/>
		</a>
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
	            <div class="spaceViewImg-wrap clearfix">
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
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
	    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	    level: 3 // 지도의 확대 레벨
	};  
	//지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption);
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>