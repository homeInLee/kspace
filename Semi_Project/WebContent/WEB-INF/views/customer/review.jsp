<%@page import="com.kh.customer.model.vo.Review"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<Review> review = (List<Review>)request.getAttribute("review");
	
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sub.css" />
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
<style>
.starR {
	background:
		url('http://miuu227.godohosting.com/images/icon/ico_review.png')
		no-repeat right 0;
	background-size: auto 100%;
	width: 15px;
	height: 15px;
	display: inline-block;
	text-indent: -9999px;
	cursor: pointer;
}

.starR.on {
	background-position: 0 0;
}
.review-star{
	width: 15px;
	height: 15px;
}
</style>
<script>
$(document).ready(function(){
	$('.starR').click(function(){
		 $(this).parent().children('span').removeClass('on');
		  $(this).addClass('on').prevAll('span').addClass('on');
		  $("#spacePoint").val($('.on').length);
		  return false;
	});
});
</script>
<li>
	<div class="review-tit mt50 clearfix">
		<h5 class="spaceInfo-tit">
			이용후기 <span class="dp_ib">후기갯수</span> · 평균평점 <span class="dp_ib">평점</span>
		</h5>
	</div>
	<!-- 리뷰작성 -->
	<form action="<%=request.getContextPath()%>/customer/customerReview" method="post" name="reviewFrm">
			<table>
				<tr>
					<th>
						<input type="hidden" name="reviewWriter" value="datbot"/>
						<input type="hidden" name="spaceNo" value="1"/>						
						<input type="hidden" id="spacePoint" name="spacePoint" value="1"/>						
					</th>			
					<th>
						<div class="star">
							<span class="starR on" value="1">별1</span>
							<span class="starR" value="2">별2</span> 
							<span class="starR" value="3">별3</span> 
							<span class="starR" value="4">별4</span> 
							<span class="starR" value="5">별5</span>
						</div>					
					</th>
					<th>
						<textarea name="reviewContent" id="reviewContent" placeholder="리뷰를 남겨 주세요"></textarea>					
					</th>
					<th>
						<button id="reviewBtn" type="submit">후기 작성하기</button>
					</th>
				</tr>
			</table>
		</form>
		<!-- 리뷰목록 -->
	<table class="review-list">
		<%if(!review.isEmpty()){
			for(int i=0; i<review.size(); i++){
				Review r = review.get(i);
			%>
		<tr>
			<td>
				<div class="review-conts">
					<strong>후기 남긴 아이디</strong>
					<p class="review-con"><%=r.getReviewContent() %></p>
					<p class="review-time"><%=r.getReviewDate() %></p>
					<p class="review-star"><%=r.getSpacePoint() %></p>
				</div>
				<!-- <div class="review-reply">
					<strong>호스트의 답글</strong>
					<p class="review-con">답한 내용</p>
					<p class="review-time">답한 시간</p>
				</div> -->
			</td>
		</tr>
		<%}
		}
		%>
	</table>
	<jsp:include page="/paging/reviewPaging.jsp">
		<jsp:param value="${paging.page}" name="page"/>
		<jsp:param value="${paging.startPage}" name="startPage"/>
		<jsp:param value="${paging.endPage}" name="endPage"/>
		<jsp:param value="${paging.prev}" name="prev"/>
		<jsp:param value="${paging.next}" name="next"/>
	</jsp:include>
</li>
