<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ page import = "java.util.*, com.kh.host.model.vo.*" %>
<%
	List<SpaceJoin> spaceList = (List<SpaceJoin>)request.getAttribute("list");
	String spaceSrch = request.getParameter("spaceSrch");
	String spaceType = request.getParameter("spaceType") == null ? "" : request.getParameter("spaceType");
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sub.css" />
<script src="<%=request.getContextPath()%>/js/spaceList.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
<script>
$(()=> {
$(".select-items").click(function() {
	var spaceType = $("#spaceType-select option:selected").val();
	
	location.href= "<%=request.getContextPath()%>/search/spaceFinder?spaceType=" + spaceType + "<%if(spaceSrch!=null){%>&spaceSrch=<%=spaceSrch%><%}%>";
});	
});

</script>
<div class="sub_container">
    <section class="spacePage">
        <article class="spaceSrch-wrap">
            <h3 class="fw300"><span class="fw500"><%if(spaceSrch != null){%><%=spaceSrch %><% } %> <%if(spaceType != null){%><%=spaceType %><% } %></span>(으)로 검색한 결과입니다.</h3>
                <div class="noFilter">
                    <div>
                        <p>공간 유형</p>
                        <div class="custom-select" id="spaceType-select">
                            <select name="spaceType" id="spaceType">
                            	<option value="">전체</option>
                                <option value="스터디룸" <%=spaceType.equals("스터디룸")?"selected":"" %>>스터디룸</option>
                                <option value="공연장" <%=spaceType.equals("공연장")?"selected":"" %>>공연장</option>
                                <option value="세미나실" <%=spaceType.equals("세미나실")?"selected":"" %>>세미나실</option>
                                <option value="파티룸" <%=spaceType.equals("파티룸")?"selected":"" %>>파티룸</option>
                                <option value="카페" <%=spaceType.equals("카페")?"selected":"" %>>카페</option>
                                <option value="기타" <%=spaceType.equals("기타")?"selected":"" %>>기타</option>
                            </select>
                        </div>
                    </div>
                    <div class="placeFilter">
                        <p>지역</p>
                        <div class="custom-select">
                            <select name="spaceArea" id="spaceArea"  class="dp_block">
                            	<option value="spaceAreaTotal">전체</option>
                                <option value="도봉구">도봉구</option>
                                <option value="노원구">노원구</option>
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
            <input type="hidden" name="spaceSrch" value="<%=spaceSrch%>" />
            <input type="hidden" name="spaceType" value="<%=spaceType%>" />
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
                        <span class="srchPrice dp_ib"><input type="text" name="srchPrice2" id="srchPrice2" class="dp_block"> </span>

                        <div class="srchFilter clearfix">
                            <h4 class="fw300"><span class="fw600">편의시설</span>을 선택하세요.</h4>
                            <p>
                                <input type="checkbox" name="chkAll" id="chkAll">
                                <label for="chkAll">전체 선택</label>
                            </p>
                        </div>
                        <ul class="facility-list clearfix">
                            <li>
                                <input type="checkbox" name="facility" id="facility0" value="주차">
                                <label for="facility0">주차</label>
                            </li>
                            <li>
                                <input type="checkbox" name="facility" id="facility1" value="흡연">
                                <label for="facility1">흡연</label>
                            </li>
                            <li>
                                <input type="checkbox" name="facility" id="facility2" value="와이파이">
                                <label for="facility2">와이파이</label>
                            </li>
                            <li>
                                <input type="checkbox" name="facility" id="facility3" value="컴퓨터">
                                <label for="facility3">컴퓨터</label>
                            </li>
                            <li>
                                <input type="checkbox" name="facility" id="facility4" value="음식물">
                                <label for="facility4">음식물 반입금지</label>
                            </li>
                            <li>
                                <input type="checkbox" name="facility" id="facility5" value="콘센트">
                                <label for="facility5">콘센트</label>
                            </li>
                            <li>
                                <input type="checkbox" name="facility" id="facility6" value="의자/테이블">
                                <label for="facility6">의자/테이블</label>
                            </li>
                            <li>
                                <input type="checkbox" name="facility" id="facility7" value="반려동물">
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
                    	<a href="" class="dp_block">
                        	<div class="recom-space-img"><img src="<%=request.getContextPath() %>/images/example.jpeg" alt="이미지영역" class="dp_block"></div>
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
                                	#<%=HashArr[i] %>
                                	<% }} else { %>
                                		#<%=s.getHashtag() %>
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