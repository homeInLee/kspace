<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>KH Space</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/default.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/gh/moonspam/NanumBarunGothic@1.0/nanumbarungothicsubset.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/main.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/slick.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/slick-theme.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/common.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/slick/slick.js"></script>
<script>
$(()=> {
	$("#spaceSrch").keyup(e => {
		
		var $sel = $(".sel");
		var $li = $("#autoComplete li");
		
		if(e.key == "ArrowDown"){
			if($sel.length == 0){
				$li.eq(0).addClass("sel");
			}	
			else if($sel.is($li.last())){
				//처리코드 없음
			}
			else{
				$sel.removeClass("sel")
				    .next()
				    .addClass("sel");
			}
		}
		else if(e.key == "ArrowUp"){
			if($sel.length == 0){
				//처리코드 없음
			}	
			else if($sel.is($li.first())){
				$sel.removeClass("sel");
			}
			else{
				$sel.removeClass("sel")
				    .prev()
				    .addClass("sel");
			}
		}
		else if(e.key == "Enter"){
			//값입력
			$(e.target).val($sel.text());
			//#autoComplete 감춤
			$("#autoComplete").hide()
							  .children()
							  .remove();
		}
		else{
			
			var spaceSrch = $(e.target).val();
			
			//사용자입력값이 없는 경우, 조기 리턴처리함.
			if(spaceSrch.trim().length == 0)
				return;
			
			$.ajax({
				url:"<%=request.getContextPath()%>/search/autoComplete.do",
				type:"post",
				data:"spaceSrch="+spaceSrch,
				success: function(data){
					console.log(data);
					
					if(data.trim().length == 0){
						$("#autoComplete").hide();
					}
					else{
						var nameArr = data.split(',');
						var html = "";
						$.each(nameArr, (i, name)=>{
							name = name.replace(spaceSrch,
												"<span class='srchVal'>"+spaceSrch+"</span>");
							html += "<li>"+name+"</li>";
						});
						
						$("#autoComplete").html(html)
										  .fadeIn(200);
					
					}
					
					//마우스 이벤트 핸들러 추가
					$("#autoComplete li")
						.click(e=>{
							//값입력
							$("#spaceSrch").val($(e.target).text());
							//#autoComplete 감춤
							$("#autoComplete").hide()
											  .children()
											  .remove();
						})
						.hover(e=>{
							$(e.target).addClass("sel")
									   .siblings()
									   .removeClass("sel");
							
						}, e=>{
							$(e.target).removeClass("sel");
						});
					
					
					
					
					
				},
				error: function(jqxhr, textStatus, errorThrown){
					console.log("ajax처리실패!");
					console.log(jqxhr, textStatus, errorThrown);
				}
			});
			
			
		}
	});
});
</script>
</head>
<body>
    <header id="header">
        <h1 id="logo">
            <a href="<%=request.getContextPath() %>" class="dp_block fw700"><span>KH</span> Space</a>
        </h1>
        <div id="search-area">
            <form action="<%=request.getContextPath() %>/search/spaceFinder" method="get" name="spaceSearchFrm"  class="dp_block clearfix">
                <input type="text" name="spaceSrch" id="spaceSrch" placeholder="지역 또는 공간유형을 검색해보세요!" autocomplete="off">
                <input type="submit" id="srchBtn" value="검색">
            </form>
                <ul id="autoComplete"></ul>
        </div>
        <a href="<%=request.getContextPath() %>/host/spaceEnroll" class="go-space dp_block">공간 등록하기</a>
        <div class="menu-btn clearfix">
            <p></p>
            <p></p>
            <p></p>
        </div>
    </header>
    <div id="nav_wrap">
    	<div>
	        <div id="nav-top" class="clearfix">
	            <div class="menu-close"><img src="<%=request.getContextPath() %>/images/close.png" alt="" width="24px"></div>
	            <div class="nav-ico"></div>
	            <p>
	                <a href="" class="dp_ib fw600">로그인</a>이 필요합니다.
	            </p>
	        </div>
	        <nav id="menu">
	            <ul class="menu1">
	                <li><a href="<%=request.getContextPath() %>" class="dp_block">KH Space Home</a></li>
	                <li><a href="" class="dp_block">내 정보 보기</a></li>
	                <li><a href="<%=request.getContextPath() %>/booking/bookingList?userId=datbot" class="dp_block">예약 리스트</a></li>
	                <li><a href="" class="dp_block">찜한 공간</a></li>
	                <li><a href="<%=request.getContextPath() %>/customer/spaceList" class="dp_block">전체 공간보기</a></li>
	                <li><a href="" class="dp_block">추천 공간</a></li>
	                <li><a href="<%=request.getContextPath() %>/board/adminNote" class="dp_block">공지사항</a></li>
	                <li><a href="<%=request.getContextPath()%>/banner/information" class="dp_block">배너 등록</a></li>
	                <li><a href="<%=request.getContextPath()%>/admin/spaceChkList" class="dp_block">관리자 공간 검수 리스트</a></li>
	                <li><a href="<%=request.getContextPath()%>/host/mySpaceList" class="dp_block">호스트 본인이 등록한 공간 리스트</a></li>
	            </ul>
	        </nav>
	        <div id="nav-bottom" class="txt_center">
	            <div class="clearfix">
	                <a href="" class="dp_ib">로그인</a>
	                <a href="" class="dp_ib">회원가입</a>
	            </div>
	            <p>Copyright KH SPACE Corp. All Rights Reserved.</p>
	        </div>
        </div>
    </div>
    <div id="dim-layer"></div>