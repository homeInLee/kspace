<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sub.css" />
<script src="<%=request.getContextPath()%>/js/spaceEnroll.js"></script>
<script>
function enrollValidate(){
	if($("input[name=spaceType]:checked").length>5){
		alert("공간 유형은 최대 5개까지 선택 가능합니다.");
		return false;
	}
	return true;
}
</script>

<div class="sub_container">
    <section class="subPage spaceEnroll">
        <article>
        	<div class="spaceEnrollTit clearfix">
        		<h3 class="tit">어떤 공간을 공유하실건가요?</h3>
        		<p class="req">필수 선택</p>
        	</div>
            <p class="req">신중하게 공간 유형을 선택해주세요!</p>
            <form action="<%=request.getContextPath() %>/host/spaceEnrollEnd" name="spaceEnrollEndFrm" 
            		method="post" encType="multipart/form-data" onsubmit="return enrollValidate();">
            	<!-- 호스트 아이디 value값 바꾸기 -->
            	<input type="hidden" name="hostId" value="JeonGaNe" />
            	<div class="clearfix">
            		<h4>공간유형<span class="req">*</span></h4>
            		<p>최대 5개 선택 가능</p>
            	</div>
            	<ul class="facility-list space-list clearfix">
	                <li>
	                    <input type="checkbox" name="spaceType" id="spaceType0" value="스터디룸">
	                    <label for="spaceType0">스터디룸</label>
	                </li>
	                <li>
	                    <input type="checkbox" name="spaceType" id="spaceType1" value="공연장">
	                    <label for="spaceType1">공연장</label>
	                </li>
	                <li>
	                    <input type="checkbox" name="spaceType" id="spaceType2" value="세미나실">
	                    <label for="spaceType2">세미나실</label>
	                </li>
	                <li>
	                    <input type="checkbox" name="spaceType" id="spaceType3" value="파티룸">
	                    <label for="spaceType3">파티룸</label>
	                </li>
	                <li>
	                    <input type="checkbox" name="spaceType" id="spaceType4" value="카페">
	                    <label for="spaceType4">카페</label>
	                </li>
	                <li>
	                    <input type="checkbox" name="spaceType" id="spaceType5" value="기타">
	                    <label for="spaceType5">기타</label>
	                </li>
	            </ul>
            	<h4>대표이미지<span class="req">*</span></h4>
            	<p>이미지 사이즈 : 1024*450, 크기 : 10MB 권장</p>
            	<div class="clearfix">
            		<div id="enrollImg1" class="spaceEnroll-img"></div>
            		<div class="filebox"> 
	            		<label for="spaceEnrollFile">파일 첨부</label> 
	            		<input type="file" name="spaceEnrollFile" id="spaceEnrollFile" class="upload-hidden">
            		</div>
            	</div>
            	<h4>이미지</h4>
            	<p>이미지 사이즈 : 1024*450, 크기 : 10MB 권장(1장당), <span>최대 3장 업로드 가능</span></p>
            	<div class="multipleFile clearfix">
            		<div id="enrollImg2" class="spaceEnroll-img"></div>
            		<div class="filebox"> 
	            		<label for="spaceEnrollFileMultiple">파일 첨부</label> 
	            		<input type="file" multiple name="spaceEnrollFileMultiple" id="spaceEnrollFileMultiple" class="upload-hidden" maxlength="3">
            		</div>
            	</div>
            	<h4>공간 정보</h4>
            	<div id="spaceEnroll-wrap">
            		<div class="spaceEnroll">
            			<h5>공간명<span class="req">*</span></h5>
            			<p><input type="text" name="spaceName" id="spaceName" class="inputStyle dp_block" required  placeholder="공간명을 입력해주세요" /></p>
            		</div>
            		<div class="spaceEnroll">
            			<h5>공간 슬로건</h5>
            			<p><input type="text" name="spaceSlogan" id="spaceSlogan" class="inputStyle dp_block" placeholder="ex) 하루 종일 / 인원 무관" /></p>
            		</div>
            		<div class="spaceEnroll">
            			<h5>공간 소개<span class="req">*</span></h5>
            			<p><textarea name="spaceIntro" id="spaceIntro" required class="dp_block" cols="30" rows="10"></textarea></p>
            		</div>
            		<div class="spaceEnroll">
            			<h5>수용인원<span class="req">*</span></h5>
            			<p>
            				최소 :&nbsp;
            				<span class="bookingsrchPrice srchPrice dp_ib"><input type="number" name="minBookingPeople" required id="minBookingPeople" class="dp_block" /></span>
            				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;최대 :&nbsp;
            				<span class="bookingsrchPrice srchPrice dp_ib"><input type="number" name="maxBookingPeople" required id="maxBookingPeople" class="dp_block" /></span>
            			</p>
            		</div>
            		<div class="spaceEnroll">
            			<h5>해시태그&nbsp;&nbsp;<span class="req">쉼표(,)로 구분</span></h5>
            			<p><input type="text" name="hashTag" id="hashTag" class="inputStyle dp_block" placeholder="ex) 홍대, 카페, 홍대카페" /></p>
            		</div>
            		<div class="spaceEnroll">
            			<h5>편의시설</h5>
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
                                <input type="checkbox" name="facility" id="facility4" value="음식물 반입금지">
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
                                <input type="checkbox" name="facility" id="facility7" value="반려동물 동반 가능">
                                <label for="facility7">반려동물 동반 가능</label>
                            </li>
                        </ul>
            		</div>
            		<div class="spaceEnroll">
            			<h5>가격<span class="req">*</span></h5>
            			<p class="srchPrice"><input type="number" name="spaceEnrollPrice" required id="spaceEnrollPrice" class="dp_block" /></p>
            		</div>
            		<div class="spaceEnroll enrollDayOff">
            			<h5>이벤트</h5>
            			<p>이벤트 여부</p>
            			<input type="checkbox" name="spaceEnrollEvent" id="spaceEnrollEvent" />
            			<label for="spaceEnrollEvent">적용</label>
            			<p>정기/비정기</p>
            			<div class="spaceEnrollEvent">
            				<input type="checkbox" name="spaceEnrollEventType" disabled="disabled" id="spaceEnrollAlwaysEvent" value="정기 이벤트" />
            				<label for="spaceEnrollAlwaysEvent" class="dp_ib">정기 이벤트</label>
            				<div class="custom-select">
            					<select name="spaceEnrollAlwaysEventType" id="spaceEnrollAlwaysEventType" class="dp_block">
            						<option value="">선택</option>
            						<option value="1주일">1주일</option>
            						<option value="1개월">1개월</option>
            					</select>
            				</div>
            				<div class="clearfix" style="float:none; width:100%; padding-top:15px;">
            					<input type="text" name="spaceEnrollAlwaysEventDate" id="spaceEnrollAlwaysEventDate" placeholder="이벤트 주기가 1주일이면 요일을, 1개월이면 몇일인지 입력해주세요." class="dp_ib"/>
            					<p id="spaceEnrollAlwaysEventPrice" class="srchPrice dp_ib" style="margin-bottom:0;">
            						<input type="number" name="spaceEnrollAlwaysEventPrice" class="dp_ib"/>
            					</p>
            				</div>
            			</div>
            			<div class="spaceEnrollEvent">
            				<div class="clearfix" style="width:100%; float:none;">
            					<input type="checkbox" name="spaceEnrollEventType" disabled="disabled" id="spaceEnrollNotAlwaysEvent" value="비정기 이벤트" />
	            				<label for="spaceEnrollNotAlwaysEvent" class="dp_ib">비정기 이벤트</label>
            				</div>
	            			
	            			<div style="float:none; width:100%;">
	            				<div class="dp_ib spaceEnrollNotAlwaysEventDate">
	            					<input type="text" name="spaceEnrollNotAlwaysEventStartDate" id="spaceEnrollNotAlwaysEventStartDate" placeholder="ex) 2019-08-09" class="eventInput dp_ib"/>
	            					~
	            					<input type="text" name="spaceEnrollNotAlwaysEventEndDate" id="spaceEnrollNotAlwaysEventEndDate" placeholder="ex) 2019-08-12" class="eventInput dp_ib"/>
	            				</div>
            					<p id="spaceEnrollNotAlwaysEventPrice" class="srchPrice dp_ib" style="width:255px; margin-left:0;"><input type="number" name="spaceEnrollNotAlwaysEventPrice" class="dp_block" style="width:253px;" /></p>
	            			</div>
            			</div>
            		</div>
            		<div class="spaceEnroll">
            			<h5>예약 가능 시간<span class="req">*</span></h5>
            			<div>
            				<div class="custom-select">
            					<select name="spaceEnrollTime1" required id="spaceEnrollTime1" class="dp_block">
	                            	<option value="00:00">00:00</option>
	                            	<option value="01:00">01:00</option>
	                            	<option value="02:00">02:00</option>
	                            	<option value="03:00">03:00</option>
	                            	<option value="04:00">04:00</option>
	                            	<option value="05:00">05:00</option>
	                            	<option value="06:00">06:00</option>
	                            	<option value="07:00">07:00</option>
	                            	<option value="08:00">08:00</option>
	                            	<option value="09:00">09:00</option>
	                            	<option value="10:00">10:00</option>
	                            	<option value="11:00">11:00</option>
	                            	<option value="12:00">12:00</option>
	                            	<option value="13:00">13:00</option>
	                            	<option value="14:00">14:00</option>
	                            	<option value="15:00">15:00</option>
	                            	<option value="16:00">16:00</option>
	                            	<option value="17:00">17:00</option>
	                            	<option value="18:00">18:00</option>
	                            	<option value="19:00">19:00</option>
	                            	<option value="20:00">20:00</option>
	                            	<option value="21:00">21:00</option>
	                            	<option value="22:00">22:00</option>
	                            	<option value="23:00">23:00</option>
	                            	<option value="24:00">24:00</option>
	                            </select>
            				</div>
            				<div class="custom-select">
            					<select name="spaceEnrollTime2" required id="spaceEnrollTime2" class="dp_block">
	                            	<option value="00:00">00:00</option>
	                            	<option value="01:00">01:00</option>
	                            	<option value="02:00">02:00</option>
	                            	<option value="03:00">03:00</option>
	                            	<option value="04:00">04:00</option>
	                            	<option value="05:00">05:00</option>
	                            	<option value="06:00">06:00</option>
	                            	<option value="07:00">07:00</option>
	                            	<option value="08:00">08:00</option>
	                            	<option value="09:00">09:00</option>
	                            	<option value="10:00">10:00</option>
	                            	<option value="11:00">11:00</option>
	                            	<option value="12:00">12:00</option>
	                            	<option value="13:00">13:00</option>
	                            	<option value="14:00">14:00</option>
	                            	<option value="15:00">15:00</option>
	                            	<option value="16:00">16:00</option>
	                            	<option value="17:00">17:00</option>
	                            	<option value="18:00">18:00</option>
	                            	<option value="19:00">19:00</option>
	                            	<option value="20:00">20:00</option>
	                            	<option value="21:00">21:00</option>
	                            	<option value="22:00">22:00</option>
	                            	<option value="23:00">23:00</option>
	                            	<option value="24:00">24:00</option>
	                            </select>
            				</div>
            			</div>
            		</div>
            		<div class="spaceEnroll enrollDayOff">
            			<h5>휴무일</h5>
            			<ul class="clearfix">
            				<li>
            					<input type="checkbox" name="spaceEnrollDayOff" id="dayOff0" value="일요일" />
            					<label for="dayOff0">일요일</label>
            				</li>
            				<li>
            					<input type="checkbox" name="spaceEnrollDayOff" id="dayOff1" value="월요일" />
            					<label for="dayOff1">월요일</label>
            				</li>
            				<li>
            					<input type="checkbox" name="spaceEnrollDayOff" id="dayOff2" value="화요일" />
            					<label for="dayOff2">화요일</label>
            				</li>
            				<li>
            					<input type="checkbox" name="spaceEnrollDayOff" id="dayOff3" value="수요일" />
            					<label for="dayOff3">수요일</label>
            				</li>
            				<li>
            					<input type="checkbox" name="spaceEnrollDayOff" id="dayOff4" value="목요일" />
            					<label for="dayOff4">목요일</label>
            				</li>
            				<li>
            					<input type="checkbox" name="spaceEnrollDayOff" id="dayOff5" value="금요일" />
            					<label for="dayOff5">금요일</label>
            				</li>
            				<li>
            					<input type="checkbox" name="spaceEnrollDayOff" id="dayOff6" value="토요일" />
            					<label for="dayOff6">토요일</label>
            				</li>
            				<li class="clearfix etcDayOff">
            					<input type="checkbox" name="spaceEnrollDayOff" id="dayOff7" value="기타" />
            					<label for="dayOff7">기타</label>
            					<input type="text" name="spaceEnrollDayOffETC" disabled="disabled" id="spaceEnrollDayOffETC" placeholder="ex) 2019-08-07 ~ 2019-08-10" />
            				</li>
            			</ul>
            		</div>
            		<div class="spaceEnroll">
            			<h5>휴무 사유</h5>
            			<p><input type="text" name="spaceEnrollDayOffEvent" id="spaceEnrollDayOffEvent" class="inputStyle dp_block" /></p>
            		</div>
            	</div>
            	<div class="spaceEnroll-btn txt_center clearfix">
            		<input type="submit" value="검수 신청" class="dp_ib fw600"/>
            		<a href="<%=request.getContextPath() %>" class="dp_ib fw600">취소</a>
            	</div>
            </form>
        </article>
    </section>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>