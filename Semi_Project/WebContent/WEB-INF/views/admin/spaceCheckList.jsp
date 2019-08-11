<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@page import="com.kh.admin.banner.model.vo.SpaceAll"%>
<%@page import="java.util.List"%>
<%
	List<SpaceAll> noChkSpaceList = (List<SpaceAll>)request.getAttribute("noChkSpaceList");
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sub.css" />

<div class="sub_container">
    <section class="subPage">
        <article>
            <h3 class="tit txt_center">공간 검수 목록</h3>
            <ul class="recom-space clearfix">
            <% if(noChkSpaceList!=null) { 
            	for(int i=0; i<noChkSpaceList.size(); i++){
            		SpaceAll prev = null;
            		SpaceAll s = noChkSpaceList.get(i);
            		if(i!=0) {
            			prev = noChkSpaceList.get(i-1);
            		}
            		if(prev!=null && prev.getSpaceNo()==s.getSpaceNo()) 
            			continue;
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
            }%>
            </ul>
        </article>
    </section>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>