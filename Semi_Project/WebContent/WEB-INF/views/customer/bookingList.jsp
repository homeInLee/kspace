<%@page import="com.kh.host.model.vo.Space"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.kh.host.model.vo.SpacePrice"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.customer.model.vo.Booking"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<Booking> list = (ArrayList<Booking>)request.getAttribute("list");
	Map<Integer,Integer> realprice = (HashMap<Integer,Integer>)request.getAttribute("realprice");
	List<Space> spacelist = (ArrayList<Space>)request.getAttribute("spacelist");
	SimpleDateFormat format1 = new SimpleDateFormat ("HH:mm");
	SimpleDateFormat format2 = new SimpleDateFormat ("yyyy-MM-dd");
%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sub.css" />

<div class="sub_container">
	<section class="subPage">
		<article>
			<h3 class="tit txt_center">예약 내역 리스트</h3>
			<!--예약 리스트-->
			<select name="bookingListSearch" id="">
				<option value="">전체</option>
				<option value="">승인대기</option>
				<option value="">결제대기</option>
				<option value="">예약확정</option>
				<option value="">이용완료</option>
				<option value="">취소환불</option>
				<option value="">변경요청</option>
			</select>
			<ul class="recom-space clearfix">
				<%for(int i=0; i<list.size(); i++){ %>
					<li><a href="<%=request.getContextPath() %>/customer/bookingSelect?userId=datbot&bookingNo=<%=list.get(i).getBookingNo() %>" class="dp_block">
							<div class="recom-space-img">
								<img src="<%=request.getContextPath()%>/images/example.jpeg"
									alt="이미지영역" class="dp_block">
							</div>
							<div class="recom-space-conts">
								<h4 class="recom-tit"><%=spacelist.get(i).getSpaceName() %></h4>
								<p class="recom-cont">
									<span class="dp_ib fw600">이용일시:<%=format2.format(list.get(i).getMinTime()) %></span><br />
									<span class="dp_ib">이용시간:<%=format1.format(list.get(i).getMaxTime()) %>~<%=format1.format(list.get(i).getMinTime()) %></span>
								</p>
								<p class="recom-price">
									<span class="fw600">
									<%=
										realprice.get(list.get(i).getSpaceNo())
									%>
									</span>원/시간
								</p>
							</div>
					</a></li>
				<%} %>
			</ul>
		</article>
	</section>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>