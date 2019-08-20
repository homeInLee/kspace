<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.kh.host.model.vo.SpaceImageFile"%>
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
	Company company = (Company) request.getAttribute("c");
	User hu = (User) request.getAttribute("hu");
	int realprice = (int) request.getAttribute("realprice");
	int price = (int) request.getAttribute("price");
	SpaceImageFile Img = (SpaceImageFile) request.getAttribute("Img");
	SimpleDateFormat format1 = new SimpleDateFormat ("yyyy-MM-dd");
%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sub.css" />
<style>
.booking_data_name {
	font-size: 18px;
	font-weight: bold;
}

.booking_data_frame {
	float: left;
	width: 500px;
}
.booking_data_frame2 {
	float: right;
	width: 404px;
	padding-left : 30px;
}

.booking_data_list {
	background-color: rgb(255, 255, 255);
	border-width: 2px 0px 1px;
	border-style: solid;
	border-color: rgb(142, 68, 173) rgb(51, 51, 51) rgb(224, 224, 224);
	height: 420px;
}

.booking_data_list2 {
	background-color: rgb(255, 255, 255);
	border-width: 2px 0px 1px;
	border-style: solid;
	border-color: rgb(142, 68, 173) rgb(51, 51, 51) rgb(224, 224, 224);
	height: 260px;
}

.booking_data_list3 {
	background-color: rgb(255, 255, 255);
	border-width: 2px 0px 1px;
	border-style: solid;
	border-color: rgb(142, 68, 173) rgb(51, 51, 51) rgb(224, 224, 224);
	height: 260px;
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
			<div style="overflow : hidden;">
			
			<div style="float: left;">
				<div class="booking_data_name">예약 공간</div>
				<div class="booking_data_frame">
					<div class="booking_data_list">
						<div style="width: 100%; height: 180px;">
							<img
								src="<%=request.getContextPath()%>/upload/host/<%=Img.getImageRenamedFileName()%>"
								alt="이미지영역" class="booking_img" align="left";> <br />
							<ul style="width: 480px; padding-left: 190px;">
								<li id="main_name"><%=s.getSpaceName()%></li>
								<li class="sub_li"><%=s.getSpaceIntro()%></li>
							</ul>
						</div>
						<div
							style="width: 100%; height: 200px; padding: 10px 30px 10px 30px;">
							<ul>
								<li class="sub_li">공간유형&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=s.getSpaceThema() == null ? "없음" : s.getSpaceThema()%></li>
								<li class="sub_li">예약인원&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=s.getMinBookingPeople()%>~<%=s.getMaxBookingPeople()%></li>
								<li class="sub_li">추가인원&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1명 초과시
									<%=price%>원 추가
								</li>
								<li class="sub_li">편의시설&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=s.getSpaceFacilities() == null ? "없음" : s.getSpaceFacilities()%></li>
							</ul>
						</div>
					</div>
				</div>
				<br />
				<br />
				<br />
				<div class="booking_data_name">예약자 정보</div>
				<div class="booking_data_frame">
					<div class="booking_data_list2">
						<div
							style="width: 100%; height: 200px; padding: 10px 30px 10px 30px;">
							<ul>
								<li class="sub_li">예약자&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=u.getUserName()%></li>
								<li class="sub_li">연락처&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=u.getPhone()%></li>
								<li class="sub_li">이메일&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=u.getEmail()%></li>
								<li class="sub_li">요청사항&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=b.getRequest() == null ? "없음" : b.getRequest()%></li>
							</ul>
						</div>
					</div>
				</div>
				<br />
				<br />
				<br />
				<div class="booking_data_name">호스트 정보</div>
				<div class="booking_data_frame">
					<div class="booking_data_list2">
						<div
							style="width: 100%; height: 200px; padding: 10px 30px 10px 30px;">
							<ul>
								<li class="sub_li">호스트&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=hu.getUserName()%></li>
								<li class="sub_li">연락처&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=hu.getPhone()%></li>
								<li class="sub_li">공간명&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=s.getSpaceName()%></li>
								<li class="sub_li">주소&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=company.getCompanyPlace()%></li>
							</ul>
						</div>
					</div>
				</div>
				</div>

				<div class="booking_data_frame2">
						<div class="booking_data_name">결제 금액</div>
							<div class="booking_data_list3">
								<div style="width: 100%; height: 200px; padding: 10px 30px 10px 30px;">
									<ul>
										<li class="sub_li">예약날짜&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=format1.format(b.getMinTime())%></li>
										<li class="sub_li">예약시간&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=(int) Math.ceil((b.getMaxTime().getTime() - b.getMinTime().getTime()) / 1000.0 / 3600.0)%></li>
										<li class="sub_li">예약인원&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=b.getBookingPeople()%></li>
										<li class="sub_li">가격&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=realprice%></li>
										<button onclick="bookingCancle();">예약 취소하기</button>
									</ul>
								</div>
							</div>
					</div>
				</div>
			</div>
		</article>
	</section>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>