<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@page import="com.kh.host.model.vo.SpaceImageFile"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.host.model.vo.Space"%>
<%@page import="com.kh.host.model.vo.SpacePrice"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.host.model.vo.SpaceDayOff"%>
<%
	Space s = (Space)request.getAttribute("space");
	List<SpaceImageFile> sImg = (List<SpaceImageFile>)request.getAttribute("spaceImg");
	List<SpacePrice> sPrice = (List<SpacePrice>)request.getAttribute("sPrice");
	List<SpaceDayOff> sDayOff = (List<SpaceDayOff>)request.getAttribute("sDayOff");
	
	boolean bool = false; //이벤트 여부 체크
	int spacePrice = 0; //공간 원래 가격
	boolean alwaysEvent = false; //정기 이벤트 여부
	boolean notAlwaysEvent = false; //비정기 이벤트 여부
	String alwaysEventType = "";
	int alwaysEventPrice = 0;
	String alwaysEventDate = ""; //정기이벤트 날짜
	List<String> notAlwaysEventDate = new ArrayList<>(); //비정기이벤트 날짜
	String minnotAlwaysEventDate = "";
	String maxnotAlwaysEventDate = "";
	
	for(SpacePrice sp : sPrice){
		if(sp.getPriceEvent()!=null){
			bool = true;
			if(sp.getPriceEvent().contains("일")) {
				alwaysEvent = true;
				alwaysEventType = "1개월";
				if(sp.getPriceEvent().contains("요일")){
					alwaysEventType = "1주일";
				}
				alwaysEventPrice = sp.getSpacePrice();
				alwaysEventDate = sp.getPriceEvent();
			} else if(sp.getPriceEvent().contains("-")) {
				notAlwaysEvent = true;
				notAlwaysEventDate.add(sp.getPriceEvent());
			}
		} else if(sp.getPriceEvent()==null) {
			spacePrice = sp.getSpacePrice();
		}
	}
	
	for(int i=0; i<notAlwaysEventDate.size(); i++){
		minnotAlwaysEventDate = notAlwaysEventDate.get(0);
		maxnotAlwaysEventDate = notAlwaysEventDate.get(notAlwaysEventDate.size()-1);
	}
	
	String sDayOffDate = "";
	String sDayOffEvent = "";
	for(SpaceDayOff sdo :sDayOff){
		if(sdo.getMaxSpaceDayOff()!=null){
			sDayOffDate = sdo.getMaxSpaceDayOff();
		}
		if(sdo.getDayOffEvent()!=null){
			sDayOffEvent = sdo.getDayOffEvent();
		}
	}
	
	String[] sDayOffDateArr = null;
	if(!sDayOffDate.equals("")){
		sDayOffDateArr = sDayOffDate.split(",");
	}
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sub.css" />
<script src="<%=request.getContextPath()%>/js/spaceEnroll.js"></script>
<script>
$(document).ready(function(){
	$("#spaceEnrollFile").on('change', fileCheck);
	var str = "<%=s.getSpaceIntro()!=null?s.getSpaceIntro():""%>";
	str = str.split('<br/>').join("\r\n");
	$('#spaceIntro').val(str); 
});

function fileCheck(){
	if($(this).val()!=""){
		//파일 용량 체크
		var fileSize = this.files[0].size;
		var maxSize = 1024*1024*10;
		if(fileSize > maxSize){
			alert('파일 용량을 초과했습니다.');
			$(this).val("");
		}
		
		//확장자 체크
		var ext = $(this).val().split(".").pop().toLowerCase();
		if($.inArray(ext, ["gif", "jpg", "jpeg", "png"]) == -1){
			alert('이미지 확장자만 첨부해주세요.');
			$(this).val("");
		}
	}
}

function enrollValidate(){
	if($("input[name=spaceType]:checked").length>5){
		alert("공간 유형은 최대 5개까지 선택 가능합니다.");
		return false;
	}
	
	//textarea 엔터 : 글 입력 후 DB 저장시 적용
	var str = $('#spaceIntro').val();
	str = str.replace(/(?:\r\n|\r|\n)/g, '<br/>');
	$('#spaceIntro').val(str);
	
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
	                    <input type="checkbox" name="spaceType" id="spaceType0" value="스터디룸" <%=s.getSpaceThema().contains("스터디룸")?"checked":""%> >
	                    <label for="spaceType0">스터디룸</label>
	                </li>
	                <li>
	                    <input type="checkbox" name="spaceType" id="spaceType1" value="공연장" <%=s.getSpaceThema().contains("공연장")?"checked":""%>>
	                    <label for="spaceType1">공연장</label>
	                </li>
	                <li>
	                    <input type="checkbox" name="spaceType" id="spaceType2" value="세미나실" <%=s.getSpaceThema().contains("세미나실")?"checked":""%>>
	                    <label for="spaceType2">세미나실</label>
	                </li>
	                <li>
	                    <input type="checkbox" name="spaceType" id="spaceType3" value="파티룸" <%=s.getSpaceThema().contains("파티룸")?"checked":""%>>
	                    <label for="spaceType3">파티룸</label>
	                </li>
	                <li>
	                    <input type="checkbox" name="spaceType" id="spaceType4" value="카페" <%=s.getSpaceThema().contains("카페")?"checked":""%>>
	                    <label for="spaceType4">카페</label>
	                </li>
	                <li>
	                    <input type="checkbox" name="spaceType" id="spaceType5" value="기타" <%=s.getSpaceThema().contains("기타")?"checked":""%>>
	                    <label for="spaceType5">기타</label>
	                </li>
	            </ul>
            	<h4>대표이미지<span class="req">*</span></h4>
            	<p>이미지 사이즈 : 1024*450, 크기 : 10MB 권장</p>
            	<div class="clearfix">
            		<div id="enrollImg1" class="spaceEnroll-img">
            		<% for(SpaceImageFile s1 : sImg){
            			if(s1.getImageRenamedFileName()!=null && s1.getFlag().equals("Y")){
            		%>
            			<img src="<%=request.getContextPath() %>/upload/host/<%=s1.getImageRenamedFileName() %>" alt="" height="110" />
            		<%		
            			}
            		} %>
            		</div>
            		<div class="filebox"> 
	            		<label for="spaceEnrollFile">파일 첨부</label> 
	            		<input type="file" name="spaceEnrollFile" id="spaceEnrollFile" class="upload-hidden">
            		</div>
            	</div>
            	<h4>이미지</h4>
            	<p>이미지 사이즈 : 1024*450, 크기 : 10MB 권장(1장당), <span>최대 3장 업로드 가능</span></p>
            	<div class="multipleFile clearfix">
            		<div id="enrollImg2" class="spaceEnroll-img">
            		<% for(SpaceImageFile s2 : sImg){
            			if(s2.getImageRenamedFileName()!=null && s2.getFlag().equals("N")){
            		%>
            			<img src="<%=request.getContextPath() %>/upload/host/<%=s2.getImageRenamedFileName() %>" alt="" height="110"/>
            		<%		
            			}
            		} %>
            		</div>
            		<div class="filebox"> 
	            		<label for="spaceEnrollFileImg1">파일 첨부1</label> 
	            		<input type="file" name="spaceEnrollFileImg1" id="spaceEnrollFileImg1" class="upload-hidden">
	            		<label for="spaceEnrollFileImg2" style="margin: 14px 0;">파일 첨부2</label> 
	            		<input type="file" name="spaceEnrollFileImg2" id="spaceEnrollFileImg2" class="upload-hidden">
	            		<label for="spaceEnrollFileImg3">파일 첨부3</label> 
	            		<input type="file" name="spaceEnrollFileImg3" id="spaceEnrollFileImg3" class="upload-hidden">
            		</div>
            	</div>
            	<h4>공간 정보</h4>
            	<div id="spaceEnroll-wrap">
            		<div class="spaceEnroll">
            			<h5>공간명<span class="req">*</span></h5>
            			<p><input type="text" name="spaceName" id="spaceName" class="inputStyle dp_block" value="<%=s.getSpaceName()!=null?s.getSpaceName():""%>" /></p>
            		</div>
            		<div class="spaceEnroll">
            			<h5>공간 슬로건</h5>
            			<p><input type="text" name="spaceSlogan" id="spaceSlogan" class="inputStyle dp_block" value="<%=s.getSpaceSlogan()!=null?s.getSpaceSlogan():""%>" /></p>
            		</div>
            		<div class="spaceEnroll">
            			<h5>공간 소개<span class="req">*</span></h5>
            			<p><textarea name="spaceIntro" id="spaceIntro" required class="dp_block" cols="30" rows="10"></textarea></p>
            		</div>
            		<div class="spaceEnroll">
            			<h5>수용인원<span class="req">*</span></h5>
            			<p>
            				최소 :&nbsp;
            				<span class="bookingsrchPrice srchPrice dp_ib"><input type="number" name="minBookingPeople" required id="minBookingPeople" value="<%=s.getMinBookingPeople()%>" class="dp_block" /></span>
            				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;최대 :&nbsp;
            				<span class="bookingsrchPrice srchPrice dp_ib"><input type="number" name="maxBookingPeople" required id="maxBookingPeople" value="<%=s.getMaxBookingPeople()%>" class="dp_block" /></span>
            			</p>
            		</div>
            		<div class="spaceEnroll">
            			<h5>해시태그&nbsp;&nbsp;<span class="req">쉼표(,)로 구분</span></h5>
            			<p><input type="text" name="hashTag" id="hashTag" class="inputStyle dp_block" value="<%=s.getHashtag()!=null?s.getHashtag():""%>" /></p>
            		</div>
            		<div class="spaceEnroll">
            			<h5>편의시설</h5>
           				<ul class="facility-list clearfix">
                            <li>
                                <input type="checkbox" name="facility" id="facility0" value="주차" <%=s.getSpaceFacilities()!=null&&s.getSpaceFacilities().contains("주차")?"checked":""%>>
                                <label for="facility0">주차</label>
                            </li>
                            <li>
                                <input type="checkbox" name="facility" id="facility1" value="흡연" <%=s.getSpaceFacilities()!=null&&s.getSpaceFacilities().contains("흡연")?"checked":""%>>
                                <label for="facility1">흡연</label>
                            </li>
                            <li>
                                <input type="checkbox" name="facility" id="facility2" value="와이파이" <%=s.getSpaceFacilities()!=null&&s.getSpaceFacilities().contains("와이파이")?"checked":""%>>
                                <label for="facility2">와이파이</label>
                            </li>
                            <li>
                                <input type="checkbox" name="facility" id="facility3" value="컴퓨터" <%=s.getSpaceFacilities()!=null&&s.getSpaceFacilities().contains("컴퓨터")?"checked":""%>>
                                <label for="facility3">컴퓨터</label>
                            </li>
                            <li>
                                <input type="checkbox" name="facility" id="facility4" value="음식물 반입금지" <%=s.getSpaceFacilities()!=null&&s.getSpaceFacilities().contains("음식물 반입금지")?"checked":""%>>
                                <label for="facility4">음식물 반입금지</label>
                            </li>
                            <li>
                                <input type="checkbox" name="facility" id="facility5" value="콘센트" <%=s.getSpaceFacilities()!=null&&s.getSpaceFacilities().contains("콘센트")?"checked":""%>>
                                <label for="facility5">콘센트</label>
                            </li>
                            <li>
                                <input type="checkbox" name="facility" id="facility6" value="의자/테이블" <%=s.getSpaceFacilities()!=null&&s.getSpaceFacilities().contains("의자/테이블")?"checked":""%>>
                                <label for="facility6">의자/테이블</label>
                            </li>
                            <li>
                                <input type="checkbox" name="facility" id="facility7" value="반려동물 동반 가능" <%=s.getSpaceFacilities()!=null&&s.getSpaceFacilities().contains("반려동물 동반 가능")?"checked":""%>>
                                <label for="facility7">반려동물 동반 가능</label>
                            </li>
                        </ul>
            		</div>
            		<div class="spaceEnroll">
            			<h5>가격<span class="req">*</span></h5>
            			<p class="srchPrice">
            			<input type="number" name="spaceEnrollPrice" required id="spaceEnrollPrice" class="dp_block" value="<%=spacePrice%>" /></p>
            		</div>
            		<div class="spaceEnroll enrollDayOff">
            			<h5>이벤트</h5>
            			<p>이벤트 여부</p>
            			<input type="checkbox" name="spaceEnrollEvent" id="spaceEnrollEvent" <%=bool?"checked":"" %>/>
            			<label for="spaceEnrollEvent">적용</label>
            			<p>정기/비정기</p>
            			<div class="spaceEnrollEvent">
            				<input type="checkbox" name="spaceEnrollEventType" id="spaceEnrollAlwaysEvent" value="정기 이벤트" <%=alwaysEvent?"checked":"" %> />
            				<label for="spaceEnrollAlwaysEvent" class="dp_ib">정기 이벤트</label>
            				<div class="custom-select" style="display:block;">
            					<select name="spaceEnrollAlwaysEventType" id="spaceEnrollAlwaysEventType" class="dp_block" >
            						<option value="">선택</option>
            						<option value="1주일" <%=alwaysEventType.equals("1주일")?"selected":"" %>>1주일</option>
            						<option value="1개월" <%=alwaysEventType.equals("1개월")?"selected":"" %>>1개월</option>
            					</select>
            				</div>
            				<div class="clearfix" style="float:none; width:100%; padding-top:15px;">
            					<input type="text" name="spaceEnrollAlwaysEventDate" id="spaceEnrollAlwaysEventDate"
            					value="<%=alwaysEventDate %>" 
            					placeholder="이벤트 주기가 1주일이면 요일을, 1개월이면 몇일인지 입력해주세요." class="dp_ib" style="display:inline-block;"/>
            					<p id="spaceEnrollAlwaysEventPrice" class="srchPrice dp_ib" style="margin-bottom:0; display:inline-block;">
            						<input type="number" name="spaceEnrollAlwaysEventPrice" value="<%=alwaysEventPrice %>" class="dp_ib"/>
            					</p>
            				</div>
            			</div>
            			<div class="spaceEnrollEvent">
            				<div class="clearfix" style="width:100%; float:none;">
            					<input type="checkbox" name="spaceEnrollEventType" disabled="disabled" id="spaceEnrollNotAlwaysEvent" value="비정기 이벤트" <%=notAlwaysEvent?"checked":"" %> />
	            				<label for="spaceEnrollNotAlwaysEvent" class="dp_ib">비정기 이벤트</label>
            				</div>
	            			
	            			<div style="float:none; width:100%;">
	            				<div class="dp_ib spaceEnrollNotAlwaysEventDate" style="display:inline-block;">
	            					<input type="text" name="spaceEnrollNotAlwaysEventStartDate" id="spaceEnrollNotAlwaysEventStartDate" 
	            					value="<%=minnotAlwaysEventDate %>" placeholder="ex) 2019-08-09" class="eventInput dp_ib"/>
	            					~
	            					<input type="text" name="spaceEnrollNotAlwaysEventEndDate" id="spaceEnrollNotAlwaysEventEndDate" 
	            					value="<%=maxnotAlwaysEventDate %>" placeholder="ex) 2019-08-12" class="eventInput dp_ib"/>
	            				</div>
            					<p id="spaceEnrollNotAlwaysEventPrice" class="srchPrice dp_ib" style="width:255px; margin-left:0;"><input type="number" name="spaceEnrollNotAlwaysEventPrice" class="dp_block" style="width:253px;" /></p>
	            			</div>
            			</div>
            		</div>
            		<div class="spaceEnroll">
            			<h5>예약 가능 시간<span class="req">*</span></h5>
            			<%
            				String[] bookingTime = s.getBookingTime().split("~");
            			%>
            			<div>
            				<div class="custom-select">
            					<select name="spaceEnrollTime1" required id="spaceEnrollTime1" class="dp_block">
            						<option value="">선택</option>
	                            	<option value="00:00" <%=bookingTime[0].contains("00:00")?"selected":"" %>>00:00</option>
	                            	<option value="01:00" <%=bookingTime[0].contains("01:00")?"selected":"" %>>01:00</option>
	                            	<option value="02:00" <%=bookingTime[0].contains("02:00")?"selected":"" %>>02:00</option>
	                            	<option value="03:00" <%=bookingTime[0].contains("03:00")?"selected":"" %>>03:00</option>
	                            	<option value="04:00" <%=bookingTime[0].contains("04:00")?"selected":"" %>>04:00</option>
	                            	<option value="05:00" <%=bookingTime[0].contains("05:00")?"selected":"" %>>05:00</option>
	                            	<option value="06:00" <%=bookingTime[0].contains("06:00")?"selected":"" %>>06:00</option>
	                            	<option value="07:00" <%=bookingTime[0].contains("07:00")?"selected":"" %>>07:00</option>
	                            	<option value="08:00" <%=bookingTime[0].contains("08:00")?"selected":"" %>>08:00</option>
	                            	<option value="09:00" <%=bookingTime[0].contains("09:00")?"selected":"" %>>09:00</option>
	                            	<option value="10:00" <%=bookingTime[0].contains("10:00")?"selected":"" %>>10:00</option>
	                            	<option value="11:00" <%=bookingTime[0].contains("11:00")?"selected":"" %>>11:00</option>
	                            	<option value="12:00" <%=bookingTime[0].contains("12:00")?"selected":"" %>>12:00</option>
	                            	<option value="13:00" <%=bookingTime[0].contains("13:00")?"selected":"" %>>13:00</option>
	                            	<option value="14:00" <%=bookingTime[0].contains("14:00")?"selected":"" %>>14:00</option>
	                            	<option value="15:00" <%=bookingTime[0].contains("15:00")?"selected":"" %>>15:00</option>
	                            	<option value="16:00" <%=bookingTime[0].contains("16:00")?"selected":"" %>>16:00</option>
	                            	<option value="17:00" <%=bookingTime[0].contains("17:00")?"selected":"" %>>17:00</option>
	                            	<option value="18:00" <%=bookingTime[0].contains("18:00")?"selected":"" %>>18:00</option>
	                            	<option value="19:00" <%=bookingTime[0].contains("19:00")?"selected":"" %>>19:00</option>
	                            	<option value="20:00" <%=bookingTime[0].contains("20:00")?"selected":"" %>>20:00</option>
	                            	<option value="21:00" <%=bookingTime[0].contains("21:00")?"selected":"" %>>21:00</option>
	                            	<option value="22:00" <%=bookingTime[0].contains("22:00")?"selected":"" %>>22:00</option>
	                            	<option value="23:00" <%=bookingTime[0].contains("23:00")?"selected":"" %>>23:00</option>
	                            	<option value="24:00" <%=bookingTime[0].contains("24:00")?"selected":"" %>>24:00</option>
	                            </select>
            				</div>
            				<div class="custom-select">
            					<select name="spaceEnrollTime2" required id="spaceEnrollTime2" class="dp_block">
	                            	<option value="">선택</option>
	                            	<option value="00:00" <%=bookingTime[1].contains("00:00")?"selected":"" %>>00:00</option>
	                            	<option value="01:00" <%=bookingTime[1].contains("01:00")?"selected":"" %>>01:00</option>
	                            	<option value="02:00" <%=bookingTime[1].contains("02:00")?"selected":"" %>>02:00</option>
	                            	<option value="03:00" <%=bookingTime[1].contains("03:00")?"selected":"" %>>03:00</option>
	                            	<option value="04:00" <%=bookingTime[1].contains("04:00")?"selected":"" %>>04:00</option>
	                            	<option value="05:00" <%=bookingTime[1].contains("05:00")?"selected":"" %>>05:00</option>
	                            	<option value="06:00" <%=bookingTime[1].contains("06:00")?"selected":"" %>>06:00</option>
	                            	<option value="07:00" <%=bookingTime[1].contains("07:00")?"selected":"" %>>07:00</option>
	                            	<option value="08:00" <%=bookingTime[1].contains("08:00")?"selected":"" %>>08:00</option>
	                            	<option value="09:00" <%=bookingTime[1].contains("09:00")?"selected":"" %>>09:00</option>
	                            	<option value="10:00" <%=bookingTime[1].contains("10:00")?"selected":"" %>>10:00</option>
	                            	<option value="11:00" <%=bookingTime[1].contains("11:00")?"selected":"" %>>11:00</option>
	                            	<option value="12:00" <%=bookingTime[1].contains("12:00")?"selected":"" %>>12:00</option>
	                            	<option value="13:00" <%=bookingTime[1].contains("13:00")?"selected":"" %>>13:00</option>
	                            	<option value="14:00" <%=bookingTime[1].contains("14:00")?"selected":"" %>>14:00</option>
	                            	<option value="15:00" <%=bookingTime[1].contains("15:00")?"selected":"" %>>15:00</option>
	                            	<option value="16:00" <%=bookingTime[1].contains("16:00")?"selected":"" %>>16:00</option>
	                            	<option value="17:00" <%=bookingTime[1].contains("17:00")?"selected":"" %>>17:00</option>
	                            	<option value="18:00" <%=bookingTime[1].contains("18:00")?"selected":"" %>>18:00</option>
	                            	<option value="19:00" <%=bookingTime[1].contains("19:00")?"selected":"" %>>19:00</option>
	                            	<option value="20:00" <%=bookingTime[1].contains("20:00")?"selected":"" %>>20:00</option>
	                            	<option value="21:00" <%=bookingTime[1].contains("21:00")?"selected":"" %>>21:00</option>
	                            	<option value="22:00" <%=bookingTime[1].contains("22:00")?"selected":"" %>>22:00</option>
	                            	<option value="23:00" <%=bookingTime[1].contains("23:00")?"selected":"" %>>23:00</option>
	                            	<option value="24:00" <%=bookingTime[1].contains("24:00")?"selected":"" %>>24:00</option>
	                            </select>
            				</div>
            			</div>
            		</div>
            		<div class="spaceEnroll enrollDayOff">
            			<h5>휴무일</h5>
            			<ul class="clearfix">
            				<li>
            					<input type="checkbox" name="spaceEnrollDayOff" id="dayOff0" value="일요일" <%=sDayOffDate.contains("일요일")?"checked":"" %> />
            					<label for="dayOff0">일요일</label>
            				</li>
            				<li>
            					<input type="checkbox" name="spaceEnrollDayOff" id="dayOff1" value="월요일" <%=sDayOffDate.contains("월요일")?"checked":"" %> />
            					<label for="dayOff1">월요일</label>
            				</li>
            				<li>
            					<input type="checkbox" name="spaceEnrollDayOff" id="dayOff2" value="화요일" <%=sDayOffDate.contains("화요일")?"checked":"" %> />
            					<label for="dayOff2">화요일</label>
            				</li>
            				<li>
            					<input type="checkbox" name="spaceEnrollDayOff" id="dayOff3" value="수요일" <%=sDayOffDate.contains("수요일")?"checked":"" %> />
            					<label for="dayOff3">수요일</label>
            				</li>
            				<li>
            					<input type="checkbox" name="spaceEnrollDayOff" id="dayOff4" value="목요일" <%=sDayOffDate.contains("목요일")?"checked":"" %> />
            					<label for="dayOff4">목요일</label>
            				</li>
            				<li>
            					<input type="checkbox" name="spaceEnrollDayOff" id="dayOff5" value="금요일" <%=sDayOffDate.contains("금요일")?"checked":"" %> />
            					<label for="dayOff5">금요일</label>
            				</li>
            				<li>
            					<input type="checkbox" name="spaceEnrollDayOff" id="dayOff6" value="토요일" <%=sDayOffDate.contains("토요일")?"checked":"" %> />
            					<label for="dayOff6">토요일</label>
            				</li>
            				<li class="clearfix etcDayOff">
            					<input type="checkbox" name="spaceEnrollDayOff" id="dayOff7" value="기타" <%=sDayOffDate.contains("-")?"checked":"" %> />
            					<label for="dayOff7">기타</label>
            					<input type="text" name="spaceEnrollDayOffETC" disabled="disabled" id="spaceEnrollDayOffETC" 
            					value="<%=sDayOffDateArr[sDayOffDateArr.length-1] %>" placeholder="ex) 2019-08-07 ~ 2019-08-10" />
            				</li>
            			</ul>
            		</div>
            		<div class="spaceEnroll">
            			<h5>휴무 사유</h5>
            			<p><input type="text" name="spaceEnrollDayOffEvent" id="spaceEnrollDayOffEvent" class="inputStyle dp_block" value="<%=sDayOffEvent%>" /></p>
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