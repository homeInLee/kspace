<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@page import="java.util.List"%>
<%@page import="com.kh.admin.banner.model.vo.SpaceAll"%>
<%
	List<SpaceAll> jjimList = (List<SpaceAll>)request.getAttribute("jjimList");
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sub.css" />
<style>
	.recom-space > li.non-list {
		float:none;
		background:transparent;
		border:none;
		width:100%;
		height:230px;
		line-height:230px;
	}
</style>
<div class="sub_container">
    <section class="subPage">
        <article>
            <h3 class="tit txt_center">찜한 공간</h3>
            <ul class="recom-space clearfix">
            <% if(!jjimList.isEmpty()) { 
            	for(int i=0; i<jjimList.size(); i++){
            		SpaceAll s = jjimList.get(i);
            %>
            	<li>
            		<a href="<%=request.getContextPath() %>/customer/spaceView?spaceNo=<%=s.getSpaceNo() %>" class="dp_block">
	                    <div class="recom-space-img">
	                    	<%if("Y".equals(s.getFlag()) && s.getFlag()!=null && s.getImageRenamedFileName()!=null) %>
	                    	<img src="<%=request.getContextPath()%>/upload/host/<%=s.getImageRenamedFileName() %>" alt="이미지영역" class="dp_block">
	                    </div>
	                    <div class="recom-space-conts">
	                        <h4 class="recom-tit"><%=s.getSpaceName() %></h4>
	                        <p class="recom-cont"><%=s.getUserId() %></p>
	                        <p class="recom-price">
	                            <span class="fw600"><%=s.getSpacePrice() %></span>원/시간
	                        </p>
	                    </div>
	                </a>
	            </li>
            <%
            	}
            } else {%>
            	<li class="txt_center non-list">찜한 공간이 없습니다.</li>
            <% } %>
            </ul>
        </article>
    </section>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>