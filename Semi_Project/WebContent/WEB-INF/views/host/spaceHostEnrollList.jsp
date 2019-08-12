<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@page import="com.kh.admin.banner.model.vo.SpaceAll"%>
<%@page import="java.util.List"%>
<%
	List<SpaceAll> hostSpaceList = (List<SpaceAll>)request.getAttribute("hostSpaceList");
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sub.css" />

<div class="sub_container">
    <section class="subPage">
        <article>
            <h3 class="tit txt_center">공간 목록</h3>
            <ul class="recom-space clearfix">
            <% if(hostSpaceList!=null) { 
            	for(int i=0; i<hostSpaceList.size(); i++){
            		SpaceAll prev = null;
            		SpaceAll s = hostSpaceList.get(i);
            		if(i!=0) {
            			prev = hostSpaceList.get(i-1);
            		}
            		if(prev!=null && prev.getSpaceNo()==s.getSpaceNo()) 
            			continue;
            %>
            	<li>
	                <a href="<%=request.getContextPath() %>/host/spaceHostListView?spaceNo=<%=s.getSpaceNo() %>" class="dp_block">
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