<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ page import="java.util.*, com.kh.admin.banner.model.vo.*, com.kh.admin.banner.model.service.*, com.kh.host.model.vo.*, com.kh.customer.model.service.*, com.kh.customer.model.vo.*, com.kh.search.model.service.*" %>
<%
	List<Banner> list = new BannerService().selectAllBanner();
	List<SpaceJoin> spaceList = new CustomerService().selectSpaceList();
	List<Review> pointList = new CustomerService().selectPointList();
	List<SpaceImageFile> imageList = new SearchService().selectImageList();
	List<SpaceJoin> editorSpaceList = new CustomerService().selectSpaceListByEditor();
%>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/slick/slick.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/index.js"></script>
    <div id="main_container">
        <section id="main-sec1">
        	<div id="main-banner-container">
	        	<div id="main-banner-wrap" class="clearfix">
	                <div class="main-banner"><img src="<%=request.getContextPath() %>/images/example2.jpeg" alt=""></div>
	                <div class="main-banner"><img src="<%=request.getContextPath() %>/images/example2.jpeg" alt=""></div>
	                <div class="main-banner"><img src="<%=request.getContextPath() %>/images/example2.jpeg" alt=""></div>
	                <%if(!list.isEmpty()) { %>
					<% for(Banner b : list) { %>
					<div class="main-banner">
						<img src="<%=request.getContextPath() %>/upload/banner/<%=b.getBannerRenamedFileName() %>" alt="" />
					</div>
					<% }} %>
	            </div>
        		<div class="prev"><img src="<%=request.getContextPath() %>/images/prev-arrow.png" alt="이전" width="45" /></div>
            	<div class="next"><img src="<%=request.getContextPath() %>/images/next-arrow.png" alt="다음" width="45" /></div>
        	</div>
        </section>
        <section id="main-sec2" class="sec">
            <article>
                <h3 class="tit txt_center">유형으로 검색하기</h3>
                <ul class="space-type clearfix">
                    <li><a href="<%=request.getContextPath()%>/search/spaceFinder?spaceType=스터디룸" class="dp_block">스터디룸</a></li>
                    <li><a href="<%=request.getContextPath()%>/search/spaceFinder?spaceType=공연장" class="dp_block">공연장</a></li>
                    <li><a href="<%=request.getContextPath()%>/search/spaceFinder?spaceType=세미나실" class="dp_block">세미나실</a></li>
                    <li><a href="<%=request.getContextPath()%>/search/spaceFinder?spaceType=파티룸" class="dp_block">파티룸</a></li>
                    <li><a href="<%=request.getContextPath()%>/search/spaceFinder?spaceType=카페" class="dp_block">카페</a></li>
                    <li><a href="<%=request.getContextPath()%>/search/spaceFinder?spaceType=기타" class="dp_block">기타</a></li>
                </ul>
            </article>
            <article>
                <h3 class="tit txt_center">에디터 추천 공간</h3>
                <ul class="recom-space clearfix">
                    <% int index = 0;
                    if(!editorSpaceList.isEmpty()) { %>
                <% for(SpaceJoin s : editorSpaceList) { 
                	if(index == 6) {
    					continue;
    				}
                %>
                	<li>
                    	<a href="" class="dp_block">
                        	<div class="recom-space-img">
                        	<% if(!imageList.isEmpty()) { %>
								<% for(SpaceImageFile i : imageList) { 
									if(s.getSpaceNo() == i.getSpaceNo()) {
								%>
									<img src="<%=request.getContextPath() %>/upload/host/<%=i.getImageRenamedFileName() %>" alt="" />
							<% } else { %>
								<img src="<%=request.getContextPath() %>/images/example.jpeg" alt="이미지영역" class="dp_block">
							<% }}} else { %>
								<img src="<%=request.getContextPath() %>/images/example.jpeg" alt="이미지영역" class="dp_block">
							<% } %>
                        	</div>
                        	<div class="recom-space-conts">
                            	<h4 class="recom-tit"><%=s.getSpaceName() %></h4>
                            	<p class="recom-cont">
                                	<span class="dp_ib fw600"><%=s.getCompanyPlace() %></span><br>
                                	<span class="dp_ib">
                                	<%
                                	if(s.getHashtag() != null) {
                                		if(s.getHashtag().contains(",")) {
                                			String[] HashArr = s.getHashtag().split(",");
                                			for(int i=0; i<HashArr.length; i++) {
                                	%>
                                	# <%=HashArr[i] %>
                                	<% }} else { %>
                                		# <%=s.getHashtag() %>
                                	<% }} %>
                                	</span>
                            	</p>
                            	<p class="recom-price">
                                	<span class="fw600">
                                	<% if(s.getPriceEvent() == null) { %>
                                	<%=s.getSpacePrice() %>
                                	<% } %>
                                	</span>원/시간
                            	</p>
                        	</div>
                    	</a>
                	</li>
                	<% index++; %>
                <% }} %>
                </ul>
            </article>
        </section>
        <section id="main-sec3" class="sec">
            <article>
                <h3 class="tit txt_center">회원 추천 공간</h3>
                <ul class="member-recom-wrap clearfix">
                    <% int k = 0;
                    if(!spaceList.isEmpty() && !pointList.isEmpty()) {
                    	for(int i=0; i<pointList.size(); i++) {
                    		for(SpaceJoin s : spaceList) {
                    			if(pointList.get(i).getSpaceNo() == s.getSpaceNo()) {
                    				if(k == 6) {
                    					continue;
                    				}
                    %>
                    	<li>
                        <a href="" class="dp_block">
                            <div class="recom-space-img">
							<%if(!imageList.isEmpty()) { %>
								<% for(SpaceImageFile img : imageList) { 
									if(s.getSpaceNo() == img.getSpaceNo()) {
								%>
									<img src="<%=request.getContextPath() %>/upload/host/<%=img.getImageRenamedFileName() %>" alt="" />
							<% } else { %>
								<img src="<%=request.getContextPath() %>/images/example3.jpeg" alt="이미지영역" class="dp_block">
							<% }}} else { %>
								<img src="<%=request.getContextPath() %>/images/example3.jpeg" alt="이미지영역" class="dp_block">
							<% } %>
							</div>
                            	<div class="member-recom-conts">
                                	<p class="hashTag">
                                	<%
                                	if(s.getHashtag() != null) {
                                		if(s.getHashtag().contains(",")) {
                                			String[] HashArr = s.getHashtag().split(",");
                                			for(int j=0; j<HashArr.length; j++) {
                                	%>
                                	<span class="dp_ib"><%=HashArr[j] %></span>
                                	<% }} else { %>
                                		<span class="dp_ib"><%=s.getHashtag() %></span>
                                	<% }} %>
                                	</p>
                                	<h4 class="recom-tit"><%=s.getSpaceName() %></h4>
                                	<p class="recom-price"><span class="fw600">
									<% if(s.getPriceEvent() == null) { %>
                                	<%=s.getSpacePrice() %>
                                	<% } %>
									</span>원/시간</p>
                                	<p class="star">
                                	<%
                                	int point = pointList.get(i).getSpacePoint();
                                	for(int j=0; j<point; j++) {
                                	%>
                                	★
                                	<% } %>
                                	</p>
                            	</div>
                        	</a>
                    	</li>
                    	<% k++; %>
                    <% }}}} %>
                </ul>
            </article>
        </section>
    </div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>