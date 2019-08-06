<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sub.css" />

<div class="sub_container">
    <section class="subPage spaceEnroll">
        <article>
        	<div class="clearfix">
        		<h3 class="tit">어떤 공간을 공유하실건가요?</h3>
        		<p>필수 선택</p>
        	</div>
            <p>신중하게 공간 유형을 선택해주세요!</p>
            <form action="<%=request.getContextPath() %>/host/spaceEnrollEnd" name="spaceEnrollEndFrm" 
            		method="post" encType="multipart/form-data">
            	<div class="clearfix">
            		<h4>공간유형</h4>
            		<p>최대 5개 선택 가능</p>
            	</div>
            	<ul class="facility-list space-list clearfix">
	                <li>
	                    <input type="checkbox" name="spaceType" id="spaceType0" value="studyroom">
	                    <label for="spaceType0">스터디룸</label>
	                </li>
	                <li>
	                    <input type="checkbox" name="spaceType" id="spaceType1" value="concertHall">
	                    <label for="spaceType1">공연장</label>
	                </li>
	                <li>
	                    <input type="checkbox" name="spaceType" id="spaceType2" value="seminar">
	                    <label for="spaceType2">세미나실</label>
	                </li>
	                <li>
	                    <input type="checkbox" name="spaceType" id="spaceType3" value="partyroom">
	                    <label for="spaceType3">파티룸</label>
	                </li>
	                <li>
	                    <input type="checkbox" name="spaceType" id="spaceType4" value="cafe">
	                    <label for="spaceType4">카페</label>
	                </li>
	                <li>
	                    <input type="checkbox" name="spaceType" id="spaceType5" value="etc">
	                    <label for="spaceType5">기타</label>
	                </li>
	            </ul>
            	<h4>대표이미지<span>*</span></h4>
            	<div class="clearfix">
            		<div class="spaceEnroll-img"></div>
            		<div class="filebox"> 
            			<input class="upload-name" value="파일선택" disabled="disabled">
	            		<label for="spaceEnrollFile">업로드</label> 
	            		<input type="file" id="spaceEnrollFile">
            		</div>
            	</div>
            </form>
        </article>
    </section>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>