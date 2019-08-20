<%@page import="java.sql.ResultSet"%>
<%@page import="com.kh.customer.model.vo.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.host.model.vo.Space"%>
<%@page import="com.kh.customer.model.vo.Review"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Review> review = (ArrayList<Review>)request.getAttribute("review");
	Space sp = (Space)request.getAttribute("space");
	
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

.review-star {
	width: 15px;
	height: 15px;
}

#reviewContent {
	width: 350px;
	height: 32px;
	margin: 5px;
}

form[name=reviewFrm] {
	border: 2px solid;
}
.star_rating {font-size:0; letter-spacing:-4px;}
.star_rating a {
   font-size:22px;
   letter-spacing:0;
   display:inline-block;
   margin-left:5px;
   color:#ccc;
   text-decoration:none;
}
.star_rating a:first-child {margin-left:0;}
.star_rating a.on {color:#777;}
</style>

<script>
$(document).ready(function(){
	$('.starR').click(function(){
		 $(this).parent().children('span').removeClass('on');
		  $(this).addClass('on').prevAll('span').addClass('on');
		  $("#spacePoint").val($('.star .on').length);
		  return false;
	});
});
$(()=>{
	//로그인후 댓글쓰기
	
	//유효성검사
	$("[name=reviewFrm]").submit((e)=>{
		var len = $("#reviewContent").val().trim().length;
		if(len==0){
			e.preventDefault();
		}
	});
	$(".btn-delete").click(function() {
		if(!confirm("정말 삭제하시겠습니까?")) return;
        //삭제처리후 돌아올 현재게시판번호도 함께 전송함.
		location.href="<%=request.getContextPath()%>/customer/customerReviewDelete?spaceNo=<%=s.getSpaceNo()%>&reviewNo="+$(this).val();
	});
});
$(document).ready(function() {
	$("#reviewCnt").append($(".review-conts").length);
	
});

</script>
	<div class="review-tit mt50 clearfix">
		<h5 class="spaceInfo-tit">
			이용후기 <span class="dp_ib" id="reviewCnt"></span>
		</h5>
	</div>
	 <!-- 리뷰작성 -->
	<form action="<%=request.getContextPath()%>/customer/customerReview"
		method="post" name="reviewFrm">
		<table>
			<tr>
				<th><input type="hidden" name="reviewWriter" value="<%=memberLoggedIn != null ? memberLoggedIn.getUserId(): "" %>" />
					<input type="hidden" name="spaceNo" value="<%=sp.getSpaceNo() %>" /> <input
					type="hidden" id="spacePoint" name="spacePoint" value="1" /></th>
				<th>
					<div class="star">
						<span class="starR on" value="1">별1</span>
						<span class="starR" value="2">별2</span> 
						<span class="starR" value="3">별3</span> 
						<span class="starR" value="4">별4</span> 
						<span class="starR" value="5">별5</span>
					</div>
				</th>
				<th><textarea name="reviewContent" id="reviewContent"
						placeholder="리뷰를 남겨 주세요"></textarea>
				</th>
				<th>
					<button id="reviewBtn" type="submit">후기 작성하기</button>
				</th>
			</tr>
		</table>
	</form> <!-- 리뷰목록 -->
	<table class="review-list">
		<%if(!review.isEmpty()){
			for(int i=0; i<review.size(); i++){
				Review list = review.get(i);
			%>
		<tr>
			<td>
				<div class="review-conts">
					<strong><%=list.getReviewWriter() %></strong>
					<p class="review-con" id="cnt"><%=list.getReviewContent() %></p>
					<p class="review-time"><%=list.getReviewDate() %></p>
					<p class="star_rating" class="str">
					<%
					System.out.println("별점길이는?="+list.getSpacePoint());
						if(list.getSpacePoint()==1){
							 %>
							 <a href='#' class="on">★</a>
		                     <a href='#' >★</a>
		                     <a href='#' >★</a>
		                     <a href='#' >★</a>
		                     <a href='#' >★</a>
		                     
							 <%
						}else if(list.getSpacePoint()==2){
							%>
							 <a href='#' class="on">★</a>
		                     <a href='#' class="on">★</a>
		                     <a href='#' >★</a>
		                     <a href='#' >★</a>
		                     <a href='#' >★</a>
		                     
							 <%
						}else if(list.getSpacePoint()==3){
							%>
							 <a href='#' class="on">★</a>
		                     <a href='#' class="on">★</a>
		                     <a href='#' class="on">★</a>
		                     <a href='#' >★</a>
		                     <a href='#' >★</a>
		                     
							 <%
						}else if(list.getSpacePoint()==4){
							%>
							 <a href='#' class="on">★</a>
		                     <a href='#' class="on">★</a>
		                     <a href='#' class="on">★</a>
		                     <a href='#' class="on">★</a>
		                     <a href='#' >★</a>
		                    
							 <%
						}else if(list.getSpacePoint()==5){
							%>
							 <a href='#' class="on">★</a>
		                     <a href='#' class="on">★</a>
		                     <a href='#' class="on">★</a>
		                     <a href='#' class="on">★</a>
		                     <a href='#' class="on">★</a>
		                     
							 <%
						}
					%>
					</p>
				</div>
				<%if(memberLoggedIn != null &&"admin".equals(memberLoggedIn.getUserId())){ %>
				<button class="btn-delete" value="<%=list.getReviewNo()%>">삭제</button>
				<%} %>
			</td>
		</tr>
		<%}
		}
		%>
	</table> <jsp:include page="/WEB-INF/views/common/paging/reviewPaging.jsp">
		<jsp:param value="${paging.page}" name="page" />
		<jsp:param value="${paging.startPage}" name="startPage" />
		<jsp:param value="${paging.endPage}" name="endPage" />
		<jsp:param value="${paging.prev}" name="prev" />
		<jsp:param value="${paging.next}" name="next" />
	</jsp:include>
