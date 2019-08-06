<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sub.css" />

<div class="sub_container">
    <section class="spacePage">
        <article class="spaceSrch-wrap">
            <h3 class="fw300"><span class="fw500">검색어</span>(으)로 검색한 결과입니다.</h3>
            <form action="" method="get" class="dp_block">
                <div class="noFilter">
                    <div>
                        <p>공간 유형</p>
                        <div class="custom-select">
                            <select name="spaceType" id="spaceType">
                                <option value="1">공간 유형1</option>
                                <option value="2">공간 유형2</option>
                            </select>
                        </div>
                    </div>
                    <div>
                        <p>지역</p>
                        <div class="custom-select">
                            <select name="spaceArea" id="spaceArea"  class="dp_block">
                                <option value="1">지역 1</option>
                                <option value="2">지역 2</option>
                            </select>
                        </div>
                    </div>
                    <div class="txt_right">
                        <a href="" class="dp_ib txt_center">필터</a>
                    </div>
                </div>
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
    <section class="spacePage">
        <article class="spaceList-wrap">
            <!--프리미엄 존-->
            <ul class="recom-space clearfix">
                <li>
                    <a href="" class="dp_block">
                        <div class="recom-space-img"><img src="<%=request.getContextPath() %>/images/example.jpeg" alt="이미지영역" class="dp_block"></div>
                        <div class="recom-space-conts">
                            <h4 class="recom-tit">제목</h4>
                            <p class="recom-cont">
                                <span class="dp_ib fw600">위치 |</span>
                                <span class="dp_ib">해시태그</span>
                            </p>
                            <p class="recom-price">
                                <span class="fw600">가격</span>원/시간
                            </p>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="" class="dp_block">
                        <div class="recom-space-img"><img src="<%=request.getContextPath() %>/images/example.jpeg" alt="이미지영역" class="dp_block"></div>
                        <div class="recom-space-conts">
                            <h4 class="recom-tit">제목</h4>
                            <p class="recom-cont">
                                <span class="dp_ib fw600">위치 |</span>
                                <span class="dp_ib">해시태그</span>
                            </p>
                            <p class="recom-price">
                                <span class="fw600">가격</span>원/시간
                            </p>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="" class="dp_block">
                        <div class="recom-space-img"><img src="<%=request.getContextPath() %>/images/example.jpeg" alt="이미지영역" class="dp_block"></div>
                        <div class="recom-space-conts">
                            <h4 class="recom-tit">제목</h4>
                            <p class="recom-cont">
                                <span class="dp_ib fw600">위치 |</span>
                                <span class="dp_ib">해시태그</span>
                            </p>
                            <p class="recom-price">
                                <span class="fw600">가격</span>원/시간
                            </p>
                        </div>
                    </a>
                </li>
            </ul>
        </article>
    </section>
    <section class="subPage">
        <article>
            <!--일반 존-->
            <ul class="recom-space clearfix">
                <li>
                    <a href="" class="dp_block">
                        <div class="recom-space-img"><img src="<%=request.getContextPath() %>/images/example.jpeg" alt="이미지영역" class="dp_block"></div>
                        <div class="recom-space-conts">
                            <h4 class="recom-tit">제목</h4>
                            <p class="recom-cont">
                                <span class="dp_ib fw600">위치 |</span>
                                <span class="dp_ib">해시태그</span>
                            </p>
                            <p class="recom-price">
                                <span class="fw600">가격</span>원/시간
                            </p>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="" class="dp_block">
                        <div class="recom-space-img"><img src="<%=request.getContextPath() %>/images/example.jpeg" alt="이미지영역" class="dp_block"></div>
                        <div class="recom-space-conts">
                            <h4 class="recom-tit">제목</h4>
                            <p class="recom-cont">
                                <span class="dp_ib fw600">위치 |</span>
                                <span class="dp_ib">해시태그</span>
                            </p>
                            <p class="recom-price">
                                <span class="fw600">가격</span>원/시간
                            </p>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="" class="dp_block">
                        <div class="recom-space-img"><img src="<%=request.getContextPath() %>/images/example.jpeg" alt="이미지영역" class="dp_block"></div>
                        <div class="recom-space-conts">
                            <h4 class="recom-tit">제목</h4>
                            <p class="recom-cont">
                                <span class="dp_ib fw600">위치 |</span>
                                <span class="dp_ib">해시태그</span>
                            </p>
                            <p class="recom-price">
                                <span class="fw600">가격</span>원/시간
                            </p>
                        </div>
                    </a>
                </li>
            </ul>
        </article>
    </section>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>