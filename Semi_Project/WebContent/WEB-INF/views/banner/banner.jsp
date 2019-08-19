<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ page import="java.util.*, com.kh.admin.banner.model.vo.*, com.kh.admin.banner.model.service.*" %>
<%
	List<Banner> list = new BannerService().selectAllBanner();
%>
<script>
$(document).ready(function(){
	$("#submit").on("click", function() {	
		var str = $('#content').val();
		str = str.replace(/(?:\r\n|\r|\n)/g, '<br/>');
		$('#content').val(str);
	});
	
	$(".btn-update").on("click", function() {
		var str = $('#update').val();
		str = str.replace(/(?:\r\n|\r|\n)/g, '<br/>');
		$('#update').val(str);
	});
});
</script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/banner.css" />
	<div class="sub_container">
		<section class="subPage">
			<article>
				<h3 class="tit txt_center">배너 등록</h3>
				<form action="<%=request.getContextPath()%>/banner/bannerInsert"
					method="post" enctype="multipart/form-data">
					<table id="banner_insert">
						<tr height="60px">
							<th width="80px">
								<label for="upFile">사진 선택</label>
							</th>
							<td width="300px">
								<input type="file" name="upFile" id="upFile" />							
							</td>
						</tr>
						<tr>
							<th>
								<label for="content">멘트</label><br/>							
							</th>
							<td>
								<textarea name="content" id="content" cols="30" rows="10"></textarea>							
							</td>
						</tr>
						<tr>
							<th colspan="2">
								<input type="submit" id="submit" value="등록" />						
							</th>
						</tr>
					</table>
				</form>
				<br /><br />
				<h2 class="tit txt_center">현재 배너 목록</h2>
				<table id="banner_list">
					<tr>
						<th width="200px">배너사진</th>
						<th width="200px">배너설명</th>
						<th width="200px">수정할 내용</th>
						<th width="70px"></th>
						<th width="70px"></th>
					</tr>
					<% if(!list.isEmpty()) { %>
					<% for(Banner b : list) { %>
					<tr>
						<td>
							<img src="<%=request.getContextPath() %>/upload/banner/<%=b.getBannerRenamedFileName() %>" alt="" style="width: 150px;" />
						</td>
						<td><%=b.getBannerContent() %></td>
						<form action="<%=request.getContextPath()%>/banner/bannerUpdate?bannerNo=<%=b.getBannerNo()%>&renamedFileName=<%=b.getBannerRenamedFileName()%>" method="post">
						<td>
						<textarea name="update" id="update" cols="30" rows="7"></textarea>
						</td>
						<td><input type="submit" class="btn-update" value="수정" /></td>						
						<td><button class="btn-delete" onclick="location.href='<%=request.getContextPath()%>/banner/bannerDelete?bannerNo=<%=b.getBannerNo()%>&renamedFileName=<%=b.getBannerRenamedFileName()%>'">삭제</button></td>
						</form>
					</tr>
					<% }} else { %>
						<td colspan="3">조회된 배너가 없습니다.</td>
					<% } %>
				</table>
			</article>
		</section>
	</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>