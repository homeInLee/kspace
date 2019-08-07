<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.kh.admin.banner.model.vo.*, com.kh.admin.banner.model.service.*" %>
<%
	List<Banner> list = new BannerService().selectAllBanner();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Index</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/default.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/gh/moonspam/NanumBarunGothic@1.0/nanumbarungothicsubset.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/slick.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/slick-theme.css">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="<%=request.getContextPath()%>/js/common.js"></script>
<script src="<%=request.getContextPath()%>/js/slick/slick/slick.js"></script>
<style>
button.btn-delete, .btn-update {
	display: none;
}

tr:hover button.btn-delete, tr:hover .btn-update {
	display: inline;
}

#update {
	border: 1px solid green;
}
</style>
</head>
<body>
	<header id="header">
		<h1 id="logo">
			<a href="index.html" class="dp_block fw700"><span>KH</span> Space</a>
		</h1>
		<div id="search-area">
			<form action="" method="get" name="spaceSearchFrm"
				class="dp_block clearfix">
				<input type="text" name="spaceSrch" id="spaceSrch"
					placeholder="지역 또는 공간유형을 검색해보세요!"> <input type="submit"
					id="srchBtn" value="검색">
			</form>
		</div>
		<a href="" class="go-space dp_block">공간 등록하기</a>
		<div class="menu-btn clearfix">
			<p></p>
			<p></p>
			<p></p>
		</div>
	</header>
	<div id="nav_wrap">
		<div id="nav-top" class="clearfix">
			<div class="menu-close">
				<img src="<%=request.getContextPath()%>/img/close.png" alt=""
					width="24px">
			</div>
			<div class="nav-ico"></div>
			<p>
				<a href="" class="dp_ib fw600">로그인</a>이 필요합니다.
			</p>
		</div>
		<nav id="menu">
			<ul class="menu1">
				<li><a href="index.html" class="dp_block">KH Space Home</a></li>
				<li><a href="subPage.html" class="dp_block">내 정보 보기</a></li>
				<li><a href="" class="dp_block">예약 리스트</a></li>
				<li><a href="" class="dp_block">찜한 공간</a></li>
				<li><a href="" class="dp_block">추천 공간</a></li>
				<li><a href="" class="dp_block">공지사항</a></li>
			</ul>
		</nav>
		<div id="nav-bottom" class="txt_center">
			<div class="clearfix">
				<a href="" class="dp_ib">로그인</a> <a href="" class="dp_ib">회원가입</a>
			</div>
			<p>Copyright KH SPACE Corp. All Rights Reserved.</p>
		</div>
	</div>
	<div id="dim-layer"></div>
	<div class="sub_container">
		<section class="subPage">
			<article>
				<h3 class="tit txt_center">서브페이지 제목</h3>
				<form action="<%=request.getContextPath()%>/banner/bannerInsert"
					method="post" enctype="multipart/form-data">
					<label for="upFile">배너 사진 넣기</label>&nbsp;&nbsp;|&nbsp;&nbsp; <input
						type="file" name="upFile" id="upFile" /> <label for="content">배너에
						들어갈 멘트</label> <input type="text" name="content" id="content" /> <input
						type="submit" value="등록" />
				</form>
				<br /><br />
				<h2>배너 목록</h2>
				<table>
					<tr>
						<th>배너사진</th>
						<th>배너설명</th>
						<th>수정할 내용</th>
					</tr>
					<% if(!list.isEmpty()) { %>
					<% for(Banner b : list) { %>
					<tr>
						<td>
							<img src="<%=request.getContextPath() %>/upload/banner/<%=b.getBannerRenamedFileName() %>" alt="" style="width: 150px;" />
						</td>
						<td><%=b.getBannerContent() %></td>
						<form action="<%=request.getContextPath()%>/banner/bannerUpdate?bannerNo=<%=b.getBannerNo()%>&renamedFileName=<%=b.getBannerRenamedFileName()%>" method="post">
						<td><input type="text" name="update" id="update" /></td>
						<td><input type="submit" class="btn-update" value="수정" /></td>						
						</form>
						<td><button class="btn-delete" onclick="location.href='<%=request.getContextPath()%>/banner/bannerDelete?bannerNo=<%=b.getBannerNo()%>&renamedFileName=<%=b.getBannerRenamedFileName()%>'">삭제</button></td>
					</tr>
					<% }} else { %>
						<td colspan="3">조회된 배너가 없습니다.</td>
					<% } %>
				</table>
			</article>
		</section>
	</div>
	<footer id="footer">
		<article>
			<h2 id="f_logo">
				<a href="index.jsp" class="dp_block fw700"><span>KH</span> Space</a>
			</h2>
			<p class="f_info">
				상호명 : 케이에이치 스페이스 | 대표 : 이호민 | 영업소재지 : 서울특별시 강남구 테헤란로 10 10길 9 <br>
				영업시간 : 오후 3시30분 ~ 오후 9시50분 | 대표전화 : 02)1234-1234 <br> *공간에 대한
				문의사항은 해당 공간 호스트에게 문의해주세요.
			</p>
			<div class="clearfix">
				<p class="f_info2">
					KH SPACE는 통신판매중개자이며 통신 판매의 당사자가 아닙니다. <br> 따라서 KH SPACE 는 공간
					거래 정보 및 거래에 대해 책임지지 않습니다.
				</p>
				<p class="cop">Copyright KH SPACE Corp. All Rights Reserved.</p>
			</div>
		</article>
	</footer>
</body>
</html>