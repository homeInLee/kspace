<%@page import="com.kh.host.model.vo.SpaceImageFile"%>
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
	List<Space> slist = (ArrayList<Space>)request.getAttribute("slist");
	List<Booking> blist = (ArrayList<Booking>)request.getAttribute("blist");
	List<Booking> fakeblist = (ArrayList<Booking>)request.getAttribute("fakeblist");
	Map<Integer,Booking> bmap = (HashMap<Integer,Booking>)request.getAttribute("bmap");
	Map<Integer,SpaceImageFile> spaceImg = (HashMap<Integer,SpaceImageFile>)request.getAttribute("spaceImg");
	Map<Integer,String> namemap = (HashMap<Integer,String>)request.getAttribute("namemap");
	Map<Integer, Integer> realprice = (HashMap<Integer,Integer>)request.getAttribute("realprice");
	SimpleDateFormat format1 = new SimpleDateFormat ("HH:mm");
	SimpleDateFormat format2 = new SimpleDateFormat ("yyyy-MM-dd");
	System.out.println("ssize="+slist.size());
	System.out.println("bsize="+blist.size());
	System.out.println("bmsize="+bmap.size());
%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sub.css" />

<div class="sub_container">
	<section class="subPage">
		<article>
			<h3 class="tit txt_center">예약 내역 리스트</h3>
			<ul class="recom-space clearfix">
				<%if(bmap == null || bmap.isEmpty()){%>
					<h2 style="text-align: center;">예약 내역이 존재하지 않습니다.</h2>
				<%}
				for(int i=0; i<blist.size(); i++) {%>
					<li><a href="<%-- <%=request.getContextPath() %>/customer/bookingSelect?userId=admin&bookingNo=<%=bmap.get(i).getBookingNo() %> --%>" class="dp_block">
							<div class="recom-space-img">
								<img src="<%=request.getContextPath() %>/upload/host/<%=spaceImg.get(blist.get(i).getBookingNo()).getImageRenamedFileName() %>" alt="" />
							</div>
							<div class="recom-space-conts">
								<h4 class="recom-tit"><%=namemap.get(blist.get(i).getBookingNo()) %></h4>
								<p class="recom-cont">
									<span class="dp_ib fw600">이용일시:<%=format2.format(bmap.get(blist.get(i).getBookingNo()).getMinTime()) %></span><br />
									<span class="dp_ib">이용시간:<%=format1.format(bmap.get(blist.get(i).getBookingNo()).getMinTime()) %>~<%=format1.format(bmap.get(blist.get(i).getBookingNo()).getMaxTime()) %></span>
								</p>
								<p class="recom-price">
									<span class="fw600">
									<%=
										realprice.get(blist.get(i).getBookingNo())
									%>
									</span>원/시간
								</p>
							</div>
					</a></li>
				<%
				}%>
			</ul>
		</article>
	</section>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>