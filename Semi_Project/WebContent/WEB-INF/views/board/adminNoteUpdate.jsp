<%@page import="com.kh.board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	Board b = (Board)request.getAttribute("board");
System.out.println(b);
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sub.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/board.css" />
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
<div class="sub_container">
    <section class="subPage">
     	<article>
	        <h3 class="tit txt_center">공지사항 수정</h3>
	         	<form action="<%=request.getContextPath()%>/admin/adminNoteUpdateEnd" method="post" enctype="multipart/form-data">
	         	<table id="noteUpload">
	         		<tr>
	         			<th>제목</th>
	         			<td><input type="text" name="title" id="title" value="<%=b.getBoardTitle() != null?b.getBoardTitle():""%>"/></td>
	         		</tr>
	         		<tr>
	         			<th>작성자</th>
	         			<td><input type="text" name="writer" id="writer" value="<%=b.getBoardWriter()!= null?b.getBoardWriter():""%>"/></td>
	         		</tr>
	         		<tr>
	         			<th>내용</th>
	         			<td><textarea name="content" required="required" /><%=b.getBoardContent()!= null?b.getBoardContent():""%></textarea></td>
	         		</tr>
	         		<tr>
	         			<th>첨부파일</th>
	         			<td>
	         				<input type="file" name="file"/>
	         				<span id="fname"><%=b.getOriginalFileName()!=null?b.getOriginalFileName():"" %></span>
	         				<%if(b.getOriginalFileName()!=null){ %>
							<br>
								<input type="checkbox" name="delFile" id="delFile" />
								<label for="delFile">첨부파일삭제</label>
							<%} %>
							<input type="hidden" name="oldOName" value="<%=b.getOriginalFileName()!=null?b.getOriginalFileName():""%>"/>
							<input type="hidden" name="oldRName" value="<%=b.getRenameFileName()!= null?b.getRenameFileName():""%>"/>
							<input type="hidden" name="boardNo" value="<%=b.getBoardNo()%>"/>
	         			</td>
	         		</tr>
	         		<tr>
	         			<th>
	         				<input type="submit" value="등록" onclick="return validate();"/>
	         			</th>
	         		</tr>
	         	</table>
	         	</form>
	         	<script>
	         	function validate() {
					
				}
	         	</script>
        </article>
    </section>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>