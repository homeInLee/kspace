<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.booking.model.vo.Booking"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<Booking> list = (ArrayList<Booking>)request.getAttribute("list");
	SimpleDateFormat format1 = new SimpleDateFormat ("HH:mm");
%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sub.css" />

<div class="sub_container">
	<section class="subPage">
		<article>
			<h3 class="tit txt_center">예약 내역 리스트</h3>
			<!--예약 리스트-->
			<ul class="recom-space clearfix">
				<%for(int i=0; i<list.size(); i++){ %>
					<li><a href="" class="dp_block">
							<div class="recom-space-img">
								<img src="<%=request.getContextPath()%>/images/example.jpeg"
									alt="이미지영역" class="dp_block">
							</div>
							<div class="recom-space-conts">
								<h4 class="recom-tit">공간명</h4>
								<p class="recom-cont">
									<span class="dp_ib fw600">이용일시:<%=list.get(i).getMinTime() %></span><br />
									<span class="dp_ib">이용시간:<%=format1.format(list.get(i).getMinTime())%>~<%=format1.format(list.get(i).getMaxTime()) %></span>
								</p>
								<p class="recom-price">
									<span class="fw600">가격</span>원/시간
								</p>
							</div>
					</a></li>
				<%} %>
			</ul>
		</article>
	</section>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>