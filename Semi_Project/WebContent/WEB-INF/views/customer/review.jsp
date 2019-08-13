<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</style>
<script>
$(document).ready(function(){
	$('.starR').click(function(){
		 $(this).parent().children('span').removeClass('on');
		  $(this).addClass('on').prevAll('span').addClass('on');
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
	<form action="<%=request.getContextPath()%>/customer/customerReview" method="post" name="reviewFrm">
			<table>
				<tr>				
					<th>
						<div class="star">
							<span class="starR on">별1</span>
							<span class="starR">별2</span> 
							<span class="starR">별3</span> 
							<span class="starR">별4</span> 
							<span class="starR">별5</span>
						</div>					
					</th>
					<th>
						<textarea name="reviewContent" id="reviewContent" placeholder="리뷰를 남겨 주세요"></textarea>					
					</th>
					<th>
						<a href="" class="dp_block">후기 작성하기</a>					
					</th>
				</tr>
			</table>
		</form>
	<ul class="review-list">
		<li>
			<div class="review-conts">
				<strong>후기 남긴 아이디</strong>
				<p class="review-con">후기 내용</p>
				<p class="review-time">후기 남긴 시간</p>
				<p class="review-star">★★★★★</p>
			</div>
			<div class="review-reply">
				<strong>호스트의 답글</strong>
				<p class="review-con">답한 내용</p>
				<p class="review-time">답한 시간</p>
			</div>
		</li>
	</ul>
</li>
