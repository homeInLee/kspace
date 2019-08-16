<%@page import="com.kh.host.model.vo.Company"%>
<%@page import="com.kh.customer.model.vo.User"%>
<%@page import="com.kh.host.model.vo.SpacePrice"%>
<%@page import="com.kh.host.model.vo.Space"%>
<%@page import="com.kh.customer.model.vo.Booking"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Booking b = (Booking) request.getAttribute("b");
	Space s = (Space) request.getAttribute("s");
	User u = (User) request.getAttribute("u");
	Company c = (Company) request.getAttribute("c");
	User hu = (User) request.getAttribute("hu");
	int realprice = (int) request.getAttribute("realprice");
	int price = (int) request.getAttribute("price");
%>
<include file="/WEB-INF/views/common/header.jsp">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sub.css" />
<style>
.booking_data_name {
	font-size: 18px;
	font-weight: bold;
}

.booking_data_frame {
	top: 244px;
	left: 53px;
	width: 500px;
	height: 420px;
}

.booking_data_list {
	background-color: rgb(255, 255, 255);
	border-width: 2px 0px 1px;
	border-style: solid;
	border-color: rgb(142, 68, 173) rgb(51, 51, 51) rgb(224, 224, 224);
	height: 420px;
}

.booking_img {
	width: 140px;
	height: 140px;
	margin: 25px;
	border: 1px solid gray;
}

#main_name {
	font-size: 24px;
	font-weight: bold;
}

.sub_li {
	font-size: 17px;
	border-top: 1px solid #ccc;
	padding: 13px 0;
	vertical-align: center;
}
</style>
<script>
function bookingCancle(){
	location.href = "<%=request.getContextPath()%>/customer/bookingCancle?bookingNo=<%=b.getBookingNo()%>"
}
</script>
<div class="sub_container">
	<section class="subPage">
		<article>
			<h3 class="tit txt_center">예약확인</h3>
			<div class="booking_data_name">예약 공간</div>
			<div class="booking_data_frame">
				<div class="booking_data_list">
					<div style="width: 100%; height: 180px; ">
						<img src="<%=request.getContextPath()%>/images/example.jpeg"
							alt="이미지영역" class="booking_img" align="left";> <br />
						<ul style="width: 480px; padding-left: 190px;">
							<li id="main_name"><%=s.getSpaceName()%></li>
							<li class="sub_li"><%=s.getSpaceIntro()%></li>
						</ul>

					</div>
					<div style="width: 100%; height: 200px; padding: 10px 30px 10px 30px;">
					<ul>
						<li class="sub_li">공간유형&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=s.getSpaceThema()%></li>
						<li class="sub_li">예약인원&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=s.getMaxBookingPeople()%>~<%=s.getMinBookingPeople()%></li>
						<li class="sub_li">추가인원&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1명 초과시 <%=price%>원 추가</li>
						<li class="sub_li">편의시설&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=s.getSpaceFacilities()%></li>					
					</ul>
					</div>
				</div>
				<%-- <li class="sub_li">예약자:<%=u.getUserName()%></li>
				<li class="sub_li">연락처:<%=u.getPhone()%></li>
				<li class="sub_li">이메일:<%=u.getEmail()%></li>
				<li class="sub_li">요청사항:<%=b.getRequest()%></li>
				<li class="sub_li">호스트:<%=hu.getUserName()%></li>
				<li class="sub_li">연락처:<%=hu.getPhone()%></li>
				<li class="sub_li">공간명:<%=s.getSpaceName()%></li>
				<li class="sub_li">주소:<%=c.getCompanyPlace()%></li>
				<li class="sub_li">예약날짜:<%=b.getMaxTime()%></li>
				<li class="sub_li">예약시간:<%=(int) Math.ceil((b.getMinTime().getTime() - b.getMaxTime().getTime()) / 1000.0 / 3600.0)%></li>
				<li class="sub_li">예약인원:<%=b.getBookingPeople()%></li>
				<li class="sub_li">가격:<%=realprice%></li> --%>
			</div>
			<button onclick="bookingCancle();">예약 취소하기</button>
		</article>
	</section>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>