<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sub.css" />

<div class="sub_container">
    <section class="subPage spaceEnroll">
        <article>
        	<div class="clearfix">
        		<h3 class="tit">어떤 공간을 공유하실건가요?</h3>
        		<p class="req">필수 선택</p>
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
            	<h4>대표이미지<span class="req">*</span></h4>
            	<p>이미지 사이즈 : 1024*450, 크기 : 10MB 권장</p>
            	<div class="clearfix">
            		<div class="spaceEnroll-img"></div>
            		<div class="filebox"> 
	            		<label for="spaceEnrollFile">파일 첨부</label> 
	            		<input type="file" id="spaceEnrollFile" class="upload-hidden">
            		</div>
            	</div>
            	<h4>이미지</h4>
            	<p>이미지 사이즈 : 1024*450, 크기 : 10MB 권장(1장당), <span>최대 5장 업로드 가능</span></p>
            	<div class="clearfix">
            		<div class="spaceEnroll-img"></div>
            		<div class="filebox"> 
	            		<label for="spaceEnrollFile">파일 첨부</label> 
	            		<input type="file" id="spaceEnrollFile" class="upload-hidden">
            		</div>
            	</div>
            	<h4>공간 정보</h4>
            	<table>
            		<tr>
            			<th>공간명<span class="req">*</span></th>
            			<td><input type="text" name="spaceName" id="spaceName" class="dp_block" required  placeholder="공간명을 입력해주세요" /></td>
            		</tr>
            		<tr>
            			<th>공간 슬로건</th>
            			<td><input type="text" name="spaceSlogan" id="spaceSlogan" class="dp_block" placeholder="ex) 하루 종일 / 인원 무관" /></td>
            		</tr>
            		<tr>
            			<th>장소 소개</th>
            			<td><textarea name="spaceIntro" id="spaceIntro" class="dp_block" cols="30" rows="10"></textarea></td>
            		</tr>
            		<tr>
            			<th>수용인원<span class="req">*</span></th>
            			<td>
            				최소 : <input type="number" name="minBookingPeople" class="dp_block" required id="minBookingPeople" /><br />
            				최대 : <input type="number" name="maxBookingPeople" class="dp_block" required id="maxBookingPeople" />
            			</td>
            		</tr>
            		<!-- 
            		   booking_time varchar2(50),--예약가능시간 : 달력 api
					   hashtag varchar2(200) default null, --해시태그
					   space_facilities varchar2(150),--편의시설
					-->
            		<tr>
            			<th></th>
            			<td></td>
            		</tr>
            		<tr>
            			<th></th>
            			<td></td>
            		</tr>
            	</table>
            </form>
        </article>
    </section>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>