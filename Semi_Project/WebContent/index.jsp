<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ page import="java.util.*, com.kh.admin.banner.model.vo.*, com.kh.admin.banner.model.service.*" %>
<%
	List<Banner> list = new BannerService().selectAllBanner();
%>
    <div id="main_container">
        <section id="main-sec1">
        	<div id="main-banner-container">
	        	<div id="main-banner-wrap" class="clearfix">
	                <div class="main-banner"><img src="<%=request.getContextPath() %>/images/example2.jpeg" alt=""></div>
	                <div class="main-banner"><img src="<%=request.getContextPath() %>/images/example2.jpeg" alt=""></div>
	                <div class="main-banner"><img src="<%=request.getContextPath() %>/images/example2.jpeg" alt=""></div>
	                <%if(!list.isEmpty()) { %>
					<% for(Banner b : list) { %>
					<div class="main-banner">
						<img src="<%=request.getContextPath() %>/upload/banner/<%=b.getBannerRenamedFileName() %>" alt="" />
					</div>
					<% }} %>
	            </div>
        		<div class="prev"><img src="<%=request.getContextPath() %>/images/prev-arrow.png" alt="이전" width="45" /></div>
            	<div class="next"><img src="<%=request.getContextPath() %>/images/next-arrow.png" alt="다음" width="45" /></div>
        	</div>
        </section>
        <section id="main-sec2" class="sec">
            <article>
                <h3 class="tit txt_center">유형으로 검색하기</h3>
                <ul class="space-type clearfix">
                    <li><a href="<%=request.getContextPath()%>/search/spaceFinder?spaceType=스터디룸" class="dp_block">스터디룸</a></li>
                    <li><a href="<%=request.getContextPath()%>/search/spaceFinder?spaceType=공연장" class="dp_block">공연장</a></li>
                    <li><a href="<%=request.getContextPath()%>/search/spaceFinder?spaceType=세미나실" class="dp_block">세미나실</a></li>
                    <li><a href="<%=request.getContextPath()%>/search/spaceFinder?spaceType=파티룸" class="dp_block">파티룸</a></li>
                    <li><a href="<%=request.getContextPath()%>/search/spaceFinder?spaceType=카페" class="dp_block">카페</a></li>
                    <li><a href="<%=request.getContextPath()%>/search/spaceFinder?spaceType=기타" class="dp_block">기타</a></li>
                </ul>
            </article>
            <article>
                <h3 class="tit txt_center">에디터 추천 공간</h3>
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
        <section id="main-sec3" class="sec">
            <article>
                <h3 class="tit txt_center">회원 추천 공간</h3>
                <ul class="member-recom-wrap clearfix">
                    <li>
                        <a href="" class="dp_block">
                            <div class="recom-space-img"><img src="<%=request.getContextPath() %>/images/example3.jpeg" alt="이미지영역" class="dp_block"></div>
                            <div class="member-recom-conts">
                                <p class="hashTag">
                                    <span class="dp_ib">해시태그1</span>
                                    <span class="dp_ib">해시태그2</span>
                                    <span class="dp_ib">해시태그3</span>
                                </p>
                                <h4 class="recom-tit">제목</h4>
                                <p class="recom-price"><span class="fw600">가격</span>원/시간</p>
                                <p class="star">★★★★★</p>
                                <p class="member-conts">댓글 내용</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="" class="dp_block">
                            <div class="recom-space-img"><img src="<%=request.getContextPath() %>/images/example3.jpeg" alt="이미지영역" class="dp_block"></div>
                            <div class="member-recom-conts">
                                <p class="hashTag">
                                    <span class="dp_ib">해시태그1</span>
                                    <span class="dp_ib">해시태그2</span>
                                    <span class="dp_ib">해시태그3</span>
                                </p>
                                <h4 class="recom-tit">제목</h4>
                                <p class="recom-price"><span class="fw600">가격</span>원/시간</p>
                                <p class="star">★★★★★</p>
                                <p class="member-conts">댓글 내용</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="" class="dp_block">
                            <div class="recom-space-img"><img src="<%=request.getContextPath() %>/images/example3.jpeg" alt="이미지영역" class="dp_block"></div>
                            <div class="member-recom-conts">
                                <p class="hashTag">
                                    <span class="dp_ib">해시태그1</span>
                                    <span class="dp_ib">해시태그2</span>
                                    <span class="dp_ib">해시태그3</span>
                                </p>
                                <h4 class="recom-tit">제목</h4>
                                <p class="recom-price"><span class="fw600">가격</span>원/시간</p>
                                <p class="star">★★★★★</p>
                                <p class="member-conts">댓글 내용</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="" class="dp_block">
                            <div class="recom-space-img"><img src="<%=request.getContextPath() %>/images/example3.jpeg" alt="이미지영역" class="dp_block"></div>
                            <div class="member-recom-conts">
                                <p class="hashTag">
                                    <span class="dp_ib">해시태그1</span>
                                    <span class="dp_ib">해시태그2</span>
                                    <span class="dp_ib">해시태그3</span>
                                </p>
                                <h4 class="recom-tit">제목</h4>
                                <p class="recom-price"><span class="fw600">가격</span>원/시간</p>
                                <p class="star">★★★★★</p>
                                <p class="member-conts">댓글 내용</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="" class="dp_block">
                            <div class="recom-space-img"><img src="<%=request.getContextPath() %>/images/example3.jpeg" alt="이미지영역" class="dp_block"></div>
                            <div class="member-recom-conts">
                                <p class="hashTag">
                                    <span class="dp_ib">해시태그1</span>
                                    <span class="dp_ib">해시태그2</span>
                                    <span class="dp_ib">해시태그3</span>
                                </p>
                                <h4 class="recom-tit">제목</h4>
                                <p class="recom-price"><span class="fw600">가격</span>원/시간</p>
                                <p class="star">★★★★★</p>
                                <p class="member-conts">댓글 내용</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="" class="dp_block">
                            <div class="recom-space-img"><img src="<%=request.getContextPath() %>/images/example3.jpeg" alt="이미지영역" class="dp_block"></div>
                            <div class="member-recom-conts">
                                <p class="hashTag">
                                    <span class="dp_ib">해시태그1</span>
                                    <span class="dp_ib">해시태그2</span>
                                    <span class="dp_ib">해시태그3</span>
                                </p>
                                <h4 class="recom-tit">제목</h4>
                                <p class="recom-price"><span class="fw600">가격</span>원/시간</p>
                                <p class="star">★★★★★</p>
                                <p class="member-conts">댓글 내용</p>
                            </div>
                        </a>
                    </li>
                </ul>
            </article>
        </section>
    </div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>