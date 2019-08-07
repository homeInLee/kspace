<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sub.css" />
<script src="<%=request.getContextPath()%>/js/spaceEnroll.js"></script>

<div class="sub_container">
    <section class="subPage spaceEnroll">
        <article>
        	<div class="spaceEnrollTit clearfix">
        		<h3 class="tit">어떤 공간을 공유하실건가요?</h3>
        		<p class="req">필수 선택</p>
        	</div>
            <p class="req">신중하게 공간 유형을 선택해주세요!</p>
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
            			<h5>공간 소개</h5>
            			<p><textarea name="spaceIntro" id="spaceIntro" class="dp_block" cols="30" rows="10"></textarea></p>
            		</div>
            		<div class="spaceEnroll">
            			<h5>수용인원<span class="req">*</span></h5>
            			<p>
            				최소 :&nbsp;
            				<span class="bookingsrchPrice srchPrice dp_ib"><input type="text" name="minBookingPeople" required id="minBookingPeople" class="dp_block" /></span>
            				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;최대 :&nbsp;
            				<span class="bookingsrchPrice srchPrice dp_ib"><input type="text" name="maxBookingPeople" required id="maxBookingPeople" class="dp_block" /></span>
            			</p>
            		</div>
            		<div class="spaceEnroll">
            			<h5>해시태그&nbsp;&nbsp;<span class="req">쉼표(,)로 구분</span></h5>
            			<p><input type="text" name="hashTag" id="hashTag" class="inputStyle dp_block" placeholder="ex)홍대, 카페, 홍대카페" /></p>
            		</div>
            		<div class="spaceEnroll">
            			<h5>편의시설</h5>
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
            		</div>
            		<div class="spaceEnroll">
            			<h5>가격<span class="req">*</span></h5>
            			<p class="srchPrice"><input type="text" name="spaceEnrollPrice" required id="spaceEnrollPrice" class="dp_block" /></p>
            		</div>
            		<div class="spaceEnroll enrollDayOff">
            			<h5>이벤트</h5>
            			<p>이벤트 여부</p>
            			<input type="checkbox" name="spaceEnrollEvent" id="spaceEnrollEvent" value="eventOk" />
            			<label for="spaceEnrollEvent">적용</label>
            			<p>정기/비정기</p>
            			<div class="spaceEnrollEvent">
            				<input type="checkbox" name="spaceEnrollEventType" disabled="disabled" id="spaceEnrollAlwaysEvent" value="alwaysEvent" />
            				<label for="spaceEnrollAlwaysEvent" class="dp_ib">정기 이벤트</label>
            				<div class="custom-select">
            					<select name="spaceEnrollAlwaysEventType" id="spaceEnrollAlwaysEventType" class="dp_block">
            						<option value="">선택</option>
            						<option value="weekEvent">1주일에 한번</option>
            						<option value="monthEvent">1개월에 한번</option>
            					</select>
            				</div>
            				<input type="text" name="spaceEnrollAlwaysEventDate" id="spaceEnrollAlwaysEventDate" placeholder="1주일에 한번이면 요일을, 1개월에 한번이면 몇일인지 입력해주세요." class="dp_block"/>
            			</div>
            			<div class="spaceEnrollEvent">
	            			<input type="checkbox" name="spaceEnrollEventType" disabled="disabled" id="spaceEnrollNotAlwaysEvent" value="notAlwaysEvent" />
	            			<label for="spaceEnrollNotAlwaysEvent" class="dp_ib">비정기 이벤트</label>
	            			<input type="text" name="spaceEnrollNotAlwaysEventDateYear" id="spaceEnrollNotAlwaysEventDate1" placeholder="년 ex)2019" class="eventInput dp_ib"/>
	            			<input type="text" name="spaceEnrollNotAlwaysEventDateMonth" id="spaceEnrollNotAlwaysEventDate2" placeholder="월 ex)08" class="eventInput dp_ib"/>
	            			<input type="text" name="spaceEnrollNotAlwaysEventDateDay" id="spaceEnrollNotAlwaysEventDate3" placeholder="일 ex)07" class="eventInput dp_ib"/>
            			</div>
            			<p>이벤트 가격</p>
            			<p class="srchPrice"><input type="text" name="spaceEnrollEventPrice" disabled="disabled" id="spaceEnrollEventPrice" class="dp_block" /></p>
            		</div>
            		<div class="spaceEnroll">
            			<h5>예약 가능 시간</h5>
            			<div>
            				<div class="custom-select">
            					<select name="spaceEnrollTime1" id="spaceEnrollTime1" class="dp_block">
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
            					<select name="spaceEnrollTime2" id="spaceEnrollTime2" class="dp_block">
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
            					<input type="text" name="spaceEnrollDayOffETC" disabled="disabled" id="spaceEnrollDayOffETC" placeholder="ex)2019-08-07 ~ 2019-08-10" />
            				</li>
            			</ul>
            		</div>
            		<div class="spaceEnroll">
            			<h5>휴무 사유</h5>
            			<p><input type="text" name="spaceEnrollDayOffEvent" id="spaceEnrollDayOffEvent" class="inputStyle dp_block" /></p>
            		</div>
            	</div>
            </form>
        </article>
    </section>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>