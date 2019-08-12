<%@page import="com.kh.board.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	String pageBar = (String) request.getAttribute("pageBar");
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
</script>
<div class="sub_container">
	<section class="subPage">
		<article>
			<h3 class="tit txt_center">공지사항</h3>
			<div id="box_search">
				<input type="text"  id="serch" class="serch" placeholder="검색어를 입력해 주세요"/>
				<input type="button" id="ser-btn" value="검색">
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
								<span class="icon-dashboard"></span><%=b.getBoardTitle() %>
							</h3>
							<ul>
								<li>
								<%=b.getBoardNo() %>
								<%=b.getBoardContent() %>
								<%=b.getBoardWriter() %>
								<%=b.getBoardDate() %>
								<%if(b.getOriginalFileName() != null){ %>
								<img src="<%=request.getContextPath() %>" alt="" />
								<%=b.getOriginalFileName() %>
								<%} %>
								</li>
								<li>
								<%-- <%if(){ %> --%>
								<input type="button" value="수정" onclick="updateBoard();"/>
								<input type="button" value="삭제"  onclick="deleteBoard();"/>
								<form action="<%=request.getContextPath()%>/admin/adminNoteDel"
										id="boardDelete" method="post">
										<input type="hidden" name="boardNo" value="<%=b.getBoardNo()%>" /> 
										<input type="hidden" name="renamedFileName" value="<%=b.getRenameFileName() != null ? b.getRenameFileName() : ""%>" />
								</form> 
								<script>
								function updateBoard() {
									location.href ="<%=request.getContextPath()%>/admin/adminNoteUpdate?boardNo=<%=b.getBoardNo()%>";
								}
								function deleteBoard() {
									if(!confirm("정말하시겠습니까?")){
										return;
									}
									$("#boardDelete").submit();
								}
								</script>
								<%-- <%} %> --%>
								</li>
							</ul>
						</li>
					<% }
					}
					%>
					</ul>
				</div>
			</div>
			<div id="pageBar">
			<%=pageBar %>
			</div>
			<input type="button" value="등록" id="btn-add" onclick="upload();"/>
		</article>
	</section>
</div>


<%@ include file="/WEB-INF/views/common/footer.jsp"%>