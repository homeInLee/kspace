<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sub.css" />
<%@ page import = "java.util.*, com.kh.host.model.vo.*" %>
<%
	List<SpaceJoin> spaceList = (List<SpaceJoin>)request.getAttribute("list");
	List<SpaceImageFile> imageList = (List<SpaceImageFile>)request.getAttribute("imageList");
%>
<script src="<%=request.getContextPath()%>/js/spaceList.js"></script>
<script>
$(()=> {
$("#spaceType-select .select-items").click(function() {
	var spaceType = $("#spaceType-select option:selected").val();
	
	location.href= "<%=request.getContextPath()%>/search/spaceFinder?spaceType=" + spaceType;
});

$("#spaceArea-select .select-items").click(function() {
	var spaceArea = $("#spaceArea-select option:selected").val();
	
	location.href= "<%=request.getContextPath()%>/search/spaceFinder?spaceArea=" + spaceArea;
});
});

</script>
<div class="sub_container">
    <section class="spacePage">
        <article class="spaceSrch-wrap">
                <div class="noFilter">
                    <div>
                        <p>공간 유형</p>
                        <div class="custom-select" id="spaceType-select">
                            <select name="spaceType" id="spaceType">
                            	<option value="">전체</option>
                                <option value="스터디룸">스터디룸</option>
                                <option value="공연장">공연장</option>
                                <option value="세미나실">세미나실</option>
                                <option value="파티룸">파티룸</option>
                                <option value="카페">카페</option>
                                <option value="기타">기타</option>
                            </select>
                        </div>
                    </div>
                    <div>
                        <p>지역</p>
                        <div class="custom-select" id="spaceArea-select">
                            <select name="spaceArea" id="spaceArea"  class="dp_block">
                            	<option value="spaceAreaTotal">전체</option>
                                <option value="노원구">노원구</option>
                                <option value="도봉구">도봉구</option>
                                <option value="강북구">강북구</option>
                                <option value="중랑구">중랑구</option>
                                <option value="동대문구">동대문구</option>
                                <option value="성북구">성북구</option>
                                <option value="종로구">종로구</option>
                                <option value="은평구">은평구</option>
                                <option value="마포구">마포구</option>
                                <option value="용산구">용산구</option>
                                <option value="성동구">성동구</option>
                                <option value="광진구">광진구</option>
                                <option value="강서구">강서구</option>
                                <option value="양천구">양천구</option>
                                <option value="영등포구">영등포구</option>
                                <option value="구로구">구로구</option>
                                <option value="동작구">동작구</option>
                                <option value="관악구">관악구</option>
                                <option value="금천구">금천구</option>
                                <option value="서초구">서초구</option>
                                <option value="강남구">강남구</option>
                                <option value="송파구">송파구</option>
                                <option value="강동구">강동구</option>
                                <option value="중구">중구</option>
                                <option value="서대문구">서대문구</option>
                            </select>
                        </div>
                    </div>
                    <div class="txt_right">
                        <a href="" class="dp_ib txt_center">필터</a>
                    </div>
                </div>
            	<form action="<%=request.getContextPath() %>/search/searchFilter" method="get" class="dp_block">
                <div class="srchFilter-wrap">
                    <div>
                        <div class="srchFilter clearfix" style="width: 587px;">
                            <h4 class="fw300"><span class="fw600">가격범위</span>를 선택하세요.</h4>
                            <p>
                                <input type="checkbox" name="chkTotal" id="chkTotal">
                                <label for="chkTotal">전체 범위</label>
                            </p>
                        </div>
                        <span class="srchPrice dp_ib"><input type="text" name="srchPrice1" id="srchPrice1" class="dp_block"> </span>
                        ~ 
                        <span class="srchPrice dp_ib"><input type="text" name="srchPrice1" id="srchPrice2" class="dp_block"> </span>

                        <div class="srchFilter clearfix">
                            <h4 class="fw300"><span class="fw600">편의시설</span>을 선택하세요.</h4>
                            <p>
                                <input type="checkbox" name="chkAll" id="chkAll">
                                <label for="chkAll">전체 선택</label>
                            </p>
                        </div>
                        <ul class="facility-list clearfix">
                            <li>
                                <input type="checkbox" name="facility" id="facility0" value="parking">
                                <label for="facility0">주차</label>
                            </li>
                            <li>
                                <input type="checkbox" name="facility" id="facility1" value="smoking">
                                <label for="facility1">흡연</label>
                            </li>
                            <li>
                                <input type="checkbox" name="facility" id="facility2" value="wifi">
                                <label for="facility2">와이파이</label>
                            </li>
                            <li>
                                <input type="checkbox" name="facility" id="facility3" value="computer">
                                <label for="facility3">컴퓨터</label>
                            </li>
                            <li>
                                <input type="checkbox" name="facility" id="facility4" value="noFood">
                                <label for="facility4">음식물 반입금지</label>
                            </li>
                            <li>
                                <input type="checkbox" name="facility" id="facility5" value="electric">
                                <label for="facility5">콘센트</label>
                            </li>
                            <li>
                                <input type="checkbox" name="facility" id="facility6" value="chair">
                                <label for="facility6">의자/테이블</label>
                            </li>
                            <li>
                                <input type="checkbox" name="facility" id="facility7" value="pet">
                                <label for="facility7">반려동물 동반 가능</label>
                            </li>
                        </ul>
                        <div class="filter-btn txt_center">
                            <button type="reset" class="dp_ib">초기화</button>
                            <button type="submit" class="dp_ib">필터 적용하기</button>
                        </div>
                    </div>
                </div>
            </form>
        </article>
    </section>
    <section class="subPage">
        <article>
            <!--일반 존-->
            <ul class="recom-space clearfix">
                <% if(!spaceList.isEmpty()) { %>
                <% for(SpaceJoin s : spaceList) { %>
                	<li>
                    	<a href="<%=request.getContextPath() %>/customer/spaceView?spaceNo=<%=s.getSpaceNo() %>" class="dp_block">
                        	<div class="recom-space-img">
                        	<% int chk = 0;
                        		if(!imageList.isEmpty()) { %>
								<% for(SpaceImageFile i : imageList) { 
									if(s.getSpaceNo() == i.getSpaceNo()) {
										chk = 1;
								%>
									<img src="<%=request.getContextPath() %>/upload/host/<%=i.getImageRenamedFileName() %>" alt="" />
							<% }}} %>
							
							<% if(chk == 0) { %>
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
                <% }} %>
            </ul>
        </article>
    </section>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>