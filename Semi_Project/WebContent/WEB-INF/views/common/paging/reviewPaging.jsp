<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.host.model.vo.Space"%>
<%@page import="com.kh.customer.model.vo.Review"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
 Space space = (Space)request.getAttribute("space");
	
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
<style type="text/css">
#paging{
    font-size: 15pt;
}
</style>
<div id="paging">
<c:url var="action" value="/customer/spaceView"/>
<c:if test="${param.prev}">
    <a href="${action}?spaceNo=<%=space.getSpaceNo() %>&cPage=${param.startPage}">prev</a>
</c:if>
<c:forEach begin="${param.startPage}" end="${param.endPage}" step="1" var="index">
    <c:choose>
        <c:when test="${param.page==index}">
            ${index}
        </c:when>
        <c:otherwise>
            <a href="${action}?spaceNo=<%=space.getSpaceNo() %>&cPage=${index}">${index}</a>
        </c:otherwise>
    </c:choose>
</c:forEach>
<c:if test="${param.next}">
    <a href="${action}?spaceNo=<%=space.getSpaceNo() %>&cPage=${param.endPage+1}">next</a>
</c:if>
</div>