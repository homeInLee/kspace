<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sub.css" />
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
<div class="sub_container">
    <section class="subPage">
        <article>
            <h3 class="tit txt_center">공지사항 등록</h3>
         	<form action="<%=request.getContextPath()%>/board/adminNoteFormEnd" method="post">
         	<table id="noteUpload">
         		<tr>
         			<th>제목</th>
         			<td><input type="text" name="title"/></td>
         		</tr>
         		<tr>
         			<th>작성자</th>
         			<td><input type="text" name="writer"/></td>
         		</tr>
         		<tr>
         			<th>내용</th>
         			<td><textarea name="content" required="required"/></textarea></td>
         		</tr>
         		<tr>
         			<th>첨부파일</th>
         			<td><input type="file" name="file"/></td>
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
				var content = $("[name=content]").val();
				if(content.trim().length == 0){
					alert("내용을 입력하세요");
					return false;
				}
				return true;
			}
         	</script>
        </article>
    </section>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>