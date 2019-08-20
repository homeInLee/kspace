<%@page import="com.kh.board.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sub.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/board.css" />
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
<script>
	$(document).ready(function() {
		$("#accordian h3").click(function() {
			$("#accordian ul ul").slideUp();
			if (!$(this).next().is(":visible")) {
				$(this).next().slideDown();
			}
		});
	});
	function upload() {
		location.href="<%=request.getContextPath()%>/board/adminNoteForm";
	};
	function fileDownload(oName, rName) {
		//alert("확인");
		//ie에서 요청한 한글파일명을 오류를 유발하므로, 유니코드 문자로 직접변환함.
		oName = encodeURIComponent(oName);
		
		location.href = "<%=request.getContextPath()%>/board/boardFileDownload"
						+"?oName="+oName
						+"&rName="+rName;
	}
</script>
<style>
.assFrm{
overflow: hidden;
}
#btn-add{
	background: #FDBB00;
	width: 70px;
	height: 30px;
	text-align: center;
	display: block;
	margin: auto;
	margin-top: 30px;
}
#delBtn{
 background: #FDBB00;
 width: 70px;
height: 30px;
float: right;
}
#upBtn{
background: #FDBB00;
width: 70px;
height: 30px;
float: right;	
}
</style>
<div class="sub_container">
	<section class="subPage">
		<article>
			<h3 class="tit txt_center">공지사항</h3>
			<div id="box_search">
				<form action="<%=request.getContextPath()%>/admin/adminNoteSearch" method="get" name="adminNoteSearchFrm" >
					<input type="text" name="serch" id="serch" class="serch" placeholder="검색어를 입력해 주세요"/>
					<input type="submit" id="ser-btn" value="검색">
				</form>
			</div>
			<div id="note-container">
				<div id="accordian">
					<ul>
					<%if(!list.isEmpty()){
						for(int i=0; i<list.size(); i++){
							Board b = list.get(i);	
						%>
						<li>
							<h3>
								<span class="icon-dashboard"></span>
								<a href="#"><%=b.getBoardTitle() %></a>
							</h3>
							<ul>
								<li>
									<div class="noteBox">
										<input type="hidden" value="<%=b.getBoardNo() %>"/>
										<p style="text-align: center;">
										<%=b.getBoardContent() %>
										</p>
										<p>
										<input type="hidden" value="<%=b.getBoardDate() %>"/>
										</p>
										<p style="text-align: center;">										
										<%if(b.getOriginalFileName() != null){ %>								
										<img src="<%=request.getContextPath()%>/upload/board/<%=b.getRenameFileName() %>" alt="" />
										<%} %>
										</p>
										<p class="p2">
										Team Cloud
										</p>
										<p>
										<%=b.getBoardWriter() %> <span>드림</span>
										</p>
									</div>
								</li>
								<li class="addFrm">
								<%if(memberLoggedIn != null &&"admin".equals(memberLoggedIn.getUserId())){ %>
								<input type="button" id="upBtn" value="수정" onclick="updateBoard();"/>
								<form action="<%=request.getContextPath()%>/admin/adminNoteUpdate"
										id="boardUpdate" method="post">
										<input type="hidden" name="boardNo" value="<%=b.getBoardNo()%>" /> 
										<input type="hidden" name="renamedFileName" value="<%=b.getRenameFileName() != null ? b.getRenameFileName() : ""%>" />
								</form>
								<input type="button" id="delBtn" value="삭제"  onclick="deleteBoard();"/>
								<form action="<%=request.getContextPath()%>/admin/adminNoteDel"
										id="boardDelete" method="post">
										<input type="hidden" name="boardNo" value="<%=b.getBoardNo()%>" /> 
										<input type="hidden" name="renamedFileName" value="<%=b.getRenameFileName() != null ? b.getRenameFileName() : ""%>" />
								</form> 
								<script>
								function updateBoard() {
									<%-- location.href ="<%=request.getContextPath()%>/admin/adminNoteUpdate?boardNo=<%=b.getBoardNo()%>"; --%>
									console.log(<%=b.getBoardNo()%>);
									$("#boardUpdate").submit();
								}
								function deleteBoard() {
									if(!confirm("정말하시겠습니까?")){
										return;.
										000
									}
									$("#boardDelete").submit();
								}
								</script>
								<%} %>
								</li>
							</ul>
						</li>
					<% }
					}
					%>
					</ul>
				</div>
			</div>
			<%if(memberLoggedIn != null &&"admin".equals(memberLoggedIn.getUserId())){ %>
			<input type="button" value="등록" id="btn-add" onclick="upload();"/>
			<%} %>
			<jsp:include page="/WEB-INF/views/common/paging/notePaging.jsp">
			    <jsp:param value="${paging.page}" name="page"/>
			    <jsp:param value="${paging.startPage}" name="startPage"/>
			    <jsp:param value="${paging.endPage}" name="endPage"/>
			    <jsp:param value="${paging.prev}" name="prev"/>
			    <jsp:param value="${paging.next}" name="next"/>
			</jsp:include>
		</article>
	</section>
</div>


<%@ include file="/WEB-INF/views/common/footer.jsp"%>