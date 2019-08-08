<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sub.css" />
<style>
.booking_data_name{
	font-size: 18px; 
	font-weight: bold;
}
.booking_data_frame{
	top: 244px; 
	left: 53px; 
	width: 500px; 
	height: 419px;
}
.booking_data_list{
	background-color: rgb(255, 255, 255); 
	border-width: 2px 0px 1px; 
	border-style: solid; 
	border-color: rgb(142, 68, 173) rgb(51, 51, 51) rgb(224, 224, 224);
}
.booking_img{
	width: 140px;
	height: 140px;
	margin: 25px;
	border: 1px solid gray;
}
#main_name{
	font-size: 24px; 
	font-weight: bold;
}
</style>

<div class="sub_container">
    <section class="subPage">
        <article>
            <h3 class="tit txt_center">예약확인</h3>
            <div class="booking_data_name">예약 공간</div>
            <div class="booking_data_frame">
            	 <div class="booking_data_list">
					<img src="<%=request.getContextPath()%>/images/example.jpeg" alt="이미지영역" class="booking_img" align="left";>
					<br />
					<li id="main_name">공간명</li>
					<li>공간명</li>
					<li>공간명</li>
					<li>공간명</li>
					<li>공간명</li>
					<li>공간명</li>
					<li>공간명</li>
					<li>공간명</li>
					<li>공간명</li>
				</div>
			</div>
        </article>
    </section>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>