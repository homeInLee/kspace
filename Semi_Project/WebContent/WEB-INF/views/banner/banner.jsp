<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ page import="java.util.*, com.kh.admin.banner.model.vo.*, com.kh.admin.banner.model.service.*" %>
<%
	List<Banner> list = new BannerService().selectAllBanner();
%>
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
<%@ include file="/WEB-INF/views/common/footer.jsp" %>