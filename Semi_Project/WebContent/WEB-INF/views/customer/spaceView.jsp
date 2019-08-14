<%@page import="com.kh.host.model.vo.Space"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@page import="com.kh.admin.banner.model.vo.SpaceAll"%>
<%@page import="java.util.List"%>
<%
	Space s = (Space)request.getAttribute("space");
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sub.css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/js/slick/slick.js"></script>
<script>
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
		<img src="<%=request.getContextPath() %>/images/example2.jpeg" alt="대표이미지" class="dp_block" />
		<a href="" class="dibs-area dp_block">
			<img src="<%=request.getContextPath() %>/images/heart.png" width="42" alt="찜하기" class="dp_block"/>
		</a>
	</section>
    <section class="spaceView-container subPage">
        <article>
        	<button onclick="insertBooking();">예약하기</button>
        	<div class="spaceInfo-container">
        		<h3 class="tit"></h3>
	            <p class="fw300">공간 슬로건</p>
	            <div class="hashTags">
	            	<span class="dp_ib">#해시태그1</span>
	            	<span class="dp_ib">#해시태그1</span>
	            	<span class="dp_ib">#해시태그1</span>
	            </div>
	            <div class="spaceViewImg-wrap clearfix">
	            	<div class="spaceViewImg"><img src="<%=request.getContextPath() %>/images/example.jpeg" class="dp_block" alt="" /></div>
	            	<div class="spaceViewImg"><img src="<%=request.getContextPath() %>/images/example2.jpeg" class="dp_block" alt="" /></div>
	            	<div class="spaceViewImg"><img src="<%=request.getContextPath() %>/images/example3.jpeg" class="dp_block" alt="" /></div>
	            </div>
	            <h4 class="fw300">공간 슬로건</h4>
	            <h5 class="spaceInfo-tit">공간 소개</h5>
	            <div>
	            	<p>공간 내용</p>
	            	<table class="spaceInfo-tb">
	            		<tr>
	            			<th style="width:75px;">영업시간</th>
	            			<td>ㅇㅇㅇㅇ</td>
	            		</tr>
	            		<tr>
	            			<th style="width:75px;">휴무일</th>
	            			<td>없음/날짜</td>
	            		</tr>
	            	</table>
	            </div>
	            <h5 class="spaceInfo-tit mt50">편의 시설</h5>
	            <ul class="infoFacility clearfix">
	            	<li>편의시설1</li>
	            	<li>편의시설2</li>
	            	<li>편의시설3</li>
	            </ul>
	            <h5 class="spaceInfo-tit mt50">예약시 주의사항</h5>
	            <table class="spaceInfo-tb">
	            	<tr>
	            		<th>1</th>
	            		<td>어쩌구 저쩌구</td>
	            	</tr>
	            	<tr>
	            		<th>2</th>
	            		<td>어쩌구 저쩌구</td>
	            	</tr>
	            	<tr>
	            		<th>3</th>
	            		<td>어쩌구 저쩌구</td>
	            	</tr>
	            </table>
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
	            		<h3>공간명</h3>
	            		<p>회사 주소</p>
	            	</div>
	            	<div class="spaceCompanyInfo-map">지도들어갈 곳</div>
	            </div>
	            <div class="review-tit mt50 clearfix">
	            	<h5 class="spaceInfo-tit">Q&ampA <span class="dp_ib">질문갯수</span></h5>
	            	<a href="" class="dp_block">질문 작성하기</a>
	            </div>
	            <ul class="review-list">
	            	<li>
	            		<div class="review-conts">
	            			<strong>질문자 아이디</strong>
	            			<p class="review-con">질문 내용</p>
	            			<p class="review-time">질문 시간</p>
	            		</div>
	            		<div class="review-reply">
	            			<strong>호스트의 답글</strong>
	            			<p class="review-con">답한 내용</p>
	            			<p class="review-time">답한 시간</p>
	            		</div>
	            	</li>
	            	<li>
	            		<div class="review-conts">
	            			<strong>질문자 아이디</strong>
	            			<p class="review-con">질문 내용</p>
	            			<p class="review-time">질문 시간</p>
	            		</div>
	            		<div class="review-reply">
	            			<strong>호스트의 답글</strong>
	            			<p class="review-con">답한 내용</p>
	            			<p class="review-time">답한 시간</p>
	            		</div>
	            	</li>
	            </ul>
	            <div class="review-tit mt50 clearfix">
	            	<%-- <h5 class="spaceInfo-tit">
	            		이용후기 <span class="dp_ib">후기갯수</span> 
	            		· 평균평점 <span class="dp_ib">평점</span>
	            	</h5>
	            	<a href="<%=request.getContextPath() %>/customer/customerReviewFrom" class="dp_block">후기 작성하기</a>
	            </div>
	            <ul class="review-list">
	            </ul> --%>
	            <%@ include file="/WEB-INF/views/customer/review.jsp" %>
        	</div>
            <div class="reservation-container">
            <!-- 예약 -->
            </div>
        </article>
    </section>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>