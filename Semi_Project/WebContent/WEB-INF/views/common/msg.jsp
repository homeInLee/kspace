<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg");
	String loc = (String)request.getAttribute("loc");
	String script = (String)request.getAttribute("script");
	
	System.out.println("msg@msg.jsp="+msg);
	System.out.println("loc@msg.jsp="+loc);
%>
<script>
alert("<%=msg%>");

<%=script!=null?script:""%>

//dml요청시 반드시 페이지 이동시켜줄것.
location.href = "<%=request.getContextPath() + loc%>"; // /product/
</script>
