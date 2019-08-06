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
</head>
<body>
    <header id="header">
        <h1 id="logo">
            <a href="index.html" class="dp_block fw700"><span>KH</span> Space</a>
        </h1>
        <div id="search-area">
            <form action="" method="get" name="spaceSearchFrm"  class="dp_block clearfix">
                <input type="text" name="spaceSrch" id="spaceSrch" placeholder="지역 또는 공간유형을 검색해보세요!">
                <input type="submit" id="srchBtn" value="검색">
            </form>
        </div>
        <a href="" class="go-space dp_block">공간 등록하기</a>
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
	                <li><a href="" class="dp_block">예약 리스트</a></li>
	                <li><a href="" class="dp_block">찜한 공간</a></li>
	                <li><a href="<%=request.getContextPath() %>/customer/spaceList" class="dp_block">전체 공간보기</a></li>
	                <li><a href="" class="dp_block">추천 공간</a></li>
	                <li><a href="" class="dp_block">공지사항</a></li>
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