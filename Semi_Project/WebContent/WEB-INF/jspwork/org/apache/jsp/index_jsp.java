/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.42
 * Generated at: 2019-08-06 11:10:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1565086693901L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1565075659840L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n");
      out.write("    <title>KH Space</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/default.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdn.jsdelivr.net/gh/moonspam/NanumBarunGothic@1.0/nanumbarungothicsubset.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/main.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/slick.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/slick-theme.css\">\r\n");
      out.write("    <script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/js/common.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/js/slick/slick.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <header id=\"header\">\r\n");
      out.write("        <h1 id=\"logo\">\r\n");
      out.write("            <a href=\"");
      out.print(request.getContextPath() );
      out.write("\" class=\"dp_block fw700\"><span>KH</span> Space</a>\r\n");
      out.write("        </h1>\r\n");
      out.write("        <div id=\"search-area\">\r\n");
      out.write("            <form action=\"\" method=\"get\" name=\"spaceSearchFrm\"  class=\"dp_block clearfix\">\r\n");
      out.write("                <input type=\"text\" name=\"spaceSrch\" id=\"spaceSrch\" placeholder=\"지역 또는 공간유형을 검색해보세요!\">\r\n");
      out.write("                <input type=\"submit\" id=\"srchBtn\" value=\"검색\">\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("        <a href=\"");
      out.print(request.getContextPath() );
      out.write("/host/spaceEnroll\" class=\"go-space dp_block\">공간 등록하기</a>\r\n");
      out.write("        <div class=\"menu-btn clearfix\">\r\n");
      out.write("            <p></p>\r\n");
      out.write("            <p></p>\r\n");
      out.write("            <p></p>\r\n");
      out.write("        </div>\r\n");
      out.write("    </header>\r\n");
      out.write("    <div id=\"nav_wrap\">\r\n");
      out.write("    \t<div>\r\n");
      out.write("\t        <div id=\"nav-top\" class=\"clearfix\">\r\n");
      out.write("\t            <div class=\"menu-close\"><img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/close.png\" alt=\"\" width=\"24px\"></div>\r\n");
      out.write("\t            <div class=\"nav-ico\"></div>\r\n");
      out.write("\t            <p>\r\n");
      out.write("\t                <a href=\"\" class=\"dp_ib fw600\">로그인</a>이 필요합니다.\r\n");
      out.write("\t            </p>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t        <nav id=\"menu\">\r\n");
      out.write("\t            <ul class=\"menu1\">\r\n");
      out.write("\t                <li><a href=\"");
      out.print(request.getContextPath() );
      out.write("\" class=\"dp_block\">KH Space Home</a></li>\r\n");
      out.write("\t                <li><a href=\"\" class=\"dp_block\">내 정보 보기</a></li>\r\n");
      out.write("\t                <li><a href=\"\" class=\"dp_block\">예약 리스트</a></li>\r\n");
      out.write("\t                <li><a href=\"\" class=\"dp_block\">찜한 공간</a></li>\r\n");
      out.write("\t                <li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/customer/spaceList\" class=\"dp_block\">전체 공간보기</a></li>\r\n");
      out.write("\t                <li><a href=\"\" class=\"dp_block\">추천 공간</a></li>\r\n");
      out.write("\t                <li><a href=\"\" class=\"dp_block\">공지사항</a></li>\r\n");
      out.write("\t            </ul>\r\n");
      out.write("\t        </nav>\r\n");
      out.write("\t        <div id=\"nav-bottom\" class=\"txt_center\">\r\n");
      out.write("\t            <div class=\"clearfix\">\r\n");
      out.write("\t                <a href=\"\" class=\"dp_ib\">로그인</a>\r\n");
      out.write("\t                <a href=\"\" class=\"dp_ib\">회원가입</a>\r\n");
      out.write("\t            </div>\r\n");
      out.write("\t            <p>Copyright KH SPACE Corp. All Rights Reserved.</p>\r\n");
      out.write("\t        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"dim-layer\"></div>");
      out.write("\r\n");
      out.write("    <div id=\"main_container\">\r\n");
      out.write("        <section id=\"main-sec1\">\r\n");
      out.write("            <div id=\"main-banner-wrap\" class=\"clearfix\">\r\n");
      out.write("                <div class=\"main-banner\"><img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/example2.jpeg\" alt=\"\"></div>\r\n");
      out.write("                <div class=\"main-banner\"><img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/example2.jpeg\" alt=\"\"></div>\r\n");
      out.write("                <div class=\"main-banner\"><img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/example2.jpeg\" alt=\"\"></div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </section>\r\n");
      out.write("        <section id=\"main-sec2\" class=\"sec\">\r\n");
      out.write("            <article>\r\n");
      out.write("                <h3 class=\"tit txt_center\">유형으로 검색하기</h3>\r\n");
      out.write("                <ul class=\"space-type clearfix\">\r\n");
      out.write("                    <li><a href=\"\" class=\"dp_block\">스터디룸</a></li>\r\n");
      out.write("                    <li><a href=\"\" class=\"dp_block\">공연장</a></li>\r\n");
      out.write("                    <li><a href=\"\" class=\"dp_block\">세미나실</a></li>\r\n");
      out.write("                    <li><a href=\"\" class=\"dp_block\">파티룸</a></li>\r\n");
      out.write("                    <li><a href=\"\" class=\"dp_block\">카페</a></li>\r\n");
      out.write("                    <li><a href=\"\" class=\"dp_block\">기타</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </article>\r\n");
      out.write("            <article>\r\n");
      out.write("                <h3 class=\"tit txt_center\">에디터 추천 공간</h3>\r\n");
      out.write("                <ul class=\"recom-space clearfix\">\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\" class=\"dp_block\">\r\n");
      out.write("                            <div class=\"recom-space-img\"><img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/example.jpeg\" alt=\"이미지영역\" class=\"dp_block\"></div>\r\n");
      out.write("                            <div class=\"recom-space-conts\">\r\n");
      out.write("                                <h4 class=\"recom-tit\">제목</h4>\r\n");
      out.write("                                <p class=\"recom-cont\">\r\n");
      out.write("                                    <span class=\"dp_ib fw600\">위치 |</span>\r\n");
      out.write("                                    <span class=\"dp_ib\">해시태그</span>\r\n");
      out.write("                                </p>\r\n");
      out.write("                                <p class=\"recom-price\">\r\n");
      out.write("                                    <span class=\"fw600\">가격</span>원/시간\r\n");
      out.write("                                </p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\" class=\"dp_block\">\r\n");
      out.write("                            <div class=\"recom-space-img\"><img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/example.jpeg\" alt=\"이미지영역\" class=\"dp_block\"></div>\r\n");
      out.write("                            <div class=\"recom-space-conts\">\r\n");
      out.write("                                <h4 class=\"recom-tit\">제목</h4>\r\n");
      out.write("                                <p class=\"recom-cont\">\r\n");
      out.write("                                    <span class=\"dp_ib fw600\">위치 |</span>\r\n");
      out.write("                                    <span class=\"dp_ib\">해시태그</span>\r\n");
      out.write("                                </p>\r\n");
      out.write("                                <p class=\"recom-price\">\r\n");
      out.write("                                    <span class=\"fw600\">가격</span>원/시간\r\n");
      out.write("                                </p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\" class=\"dp_block\">\r\n");
      out.write("                            <div class=\"recom-space-img\"><img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/example.jpeg\" alt=\"이미지영역\" class=\"dp_block\"></div>\r\n");
      out.write("                            <div class=\"recom-space-conts\">\r\n");
      out.write("                                <h4 class=\"recom-tit\">제목</h4>\r\n");
      out.write("                                <p class=\"recom-cont\">\r\n");
      out.write("                                    <span class=\"dp_ib fw600\">위치 |</span>\r\n");
      out.write("                                    <span class=\"dp_ib\">해시태그</span>\r\n");
      out.write("                                </p>\r\n");
      out.write("                                <p class=\"recom-price\">\r\n");
      out.write("                                    <span class=\"fw600\">가격</span>원/시간\r\n");
      out.write("                                </p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\" class=\"dp_block\">\r\n");
      out.write("                            <div class=\"recom-space-img\"><img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/example.jpeg\" alt=\"이미지영역\" class=\"dp_block\"></div>\r\n");
      out.write("                            <div class=\"recom-space-conts\">\r\n");
      out.write("                                <h4 class=\"recom-tit\">제목</h4>\r\n");
      out.write("                                <p class=\"recom-cont\">\r\n");
      out.write("                                    <span class=\"dp_ib fw600\">위치 |</span>\r\n");
      out.write("                                    <span class=\"dp_ib\">해시태그</span>\r\n");
      out.write("                                </p>\r\n");
      out.write("                                <p class=\"recom-price\">\r\n");
      out.write("                                    <span class=\"fw600\">가격</span>원/시간\r\n");
      out.write("                                </p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\" class=\"dp_block\">\r\n");
      out.write("                            <div class=\"recom-space-img\"><img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/example.jpeg\" alt=\"이미지영역\" class=\"dp_block\"></div>\r\n");
      out.write("                            <div class=\"recom-space-conts\">\r\n");
      out.write("                                <h4 class=\"recom-tit\">제목</h4>\r\n");
      out.write("                                <p class=\"recom-cont\">\r\n");
      out.write("                                    <span class=\"dp_ib fw600\">위치 |</span>\r\n");
      out.write("                                    <span class=\"dp_ib\">해시태그</span>\r\n");
      out.write("                                </p>\r\n");
      out.write("                                <p class=\"recom-price\">\r\n");
      out.write("                                    <span class=\"fw600\">가격</span>원/시간\r\n");
      out.write("                                </p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\" class=\"dp_block\">\r\n");
      out.write("                            <div class=\"recom-space-img\"><img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/example.jpeg\" alt=\"이미지영역\" class=\"dp_block\"></div>\r\n");
      out.write("                            <div class=\"recom-space-conts\">\r\n");
      out.write("                                <h4 class=\"recom-tit\">제목</h4>\r\n");
      out.write("                                <p class=\"recom-cont\">\r\n");
      out.write("                                    <span class=\"dp_ib fw600\">위치 |</span>\r\n");
      out.write("                                    <span class=\"dp_ib\">해시태그</span>\r\n");
      out.write("                                </p>\r\n");
      out.write("                                <p class=\"recom-price\">\r\n");
      out.write("                                    <span class=\"fw600\">가격</span>원/시간\r\n");
      out.write("                                </p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </article>\r\n");
      out.write("        </section>\r\n");
      out.write("        <section id=\"main-sec3\" class=\"sec\">\r\n");
      out.write("            <article>\r\n");
      out.write("                <h3 class=\"tit txt_center\">회원 추천 공간</h3>\r\n");
      out.write("                <ul class=\"member-recom-wrap clearfix\">\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\" class=\"dp_block\">\r\n");
      out.write("                            <div class=\"recom-space-img\"><img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/example3.jpeg\" alt=\"이미지영역\" class=\"dp_block\"></div>\r\n");
      out.write("                            <div class=\"member-recom-conts\">\r\n");
      out.write("                                <p class=\"hashTag\">\r\n");
      out.write("                                    <span class=\"dp_ib\">해시태그1</span>\r\n");
      out.write("                                    <span class=\"dp_ib\">해시태그2</span>\r\n");
      out.write("                                    <span class=\"dp_ib\">해시태그3</span>\r\n");
      out.write("                                </p>\r\n");
      out.write("                                <h4 class=\"recom-tit\">제목</h4>\r\n");
      out.write("                                <p class=\"recom-price\"><span class=\"fw600\">가격</span>원/시간</p>\r\n");
      out.write("                                <p class=\"star\">★★★★★</p>\r\n");
      out.write("                                <p class=\"member-conts\">댓글 내용</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\" class=\"dp_block\">\r\n");
      out.write("                            <div class=\"recom-space-img\"><img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/example3.jpeg\" alt=\"이미지영역\" class=\"dp_block\"></div>\r\n");
      out.write("                            <div class=\"member-recom-conts\">\r\n");
      out.write("                                <p class=\"hashTag\">\r\n");
      out.write("                                    <span class=\"dp_ib\">해시태그1</span>\r\n");
      out.write("                                    <span class=\"dp_ib\">해시태그2</span>\r\n");
      out.write("                                    <span class=\"dp_ib\">해시태그3</span>\r\n");
      out.write("                                </p>\r\n");
      out.write("                                <h4 class=\"recom-tit\">제목</h4>\r\n");
      out.write("                                <p class=\"recom-price\"><span class=\"fw600\">가격</span>원/시간</p>\r\n");
      out.write("                                <p class=\"star\">★★★★★</p>\r\n");
      out.write("                                <p class=\"member-conts\">댓글 내용</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\" class=\"dp_block\">\r\n");
      out.write("                            <div class=\"recom-space-img\"><img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/example3.jpeg\" alt=\"이미지영역\" class=\"dp_block\"></div>\r\n");
      out.write("                            <div class=\"member-recom-conts\">\r\n");
      out.write("                                <p class=\"hashTag\">\r\n");
      out.write("                                    <span class=\"dp_ib\">해시태그1</span>\r\n");
      out.write("                                    <span class=\"dp_ib\">해시태그2</span>\r\n");
      out.write("                                    <span class=\"dp_ib\">해시태그3</span>\r\n");
      out.write("                                </p>\r\n");
      out.write("                                <h4 class=\"recom-tit\">제목</h4>\r\n");
      out.write("                                <p class=\"recom-price\"><span class=\"fw600\">가격</span>원/시간</p>\r\n");
      out.write("                                <p class=\"star\">★★★★★</p>\r\n");
      out.write("                                <p class=\"member-conts\">댓글 내용</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\" class=\"dp_block\">\r\n");
      out.write("                            <div class=\"recom-space-img\"><img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/example3.jpeg\" alt=\"이미지영역\" class=\"dp_block\"></div>\r\n");
      out.write("                            <div class=\"member-recom-conts\">\r\n");
      out.write("                                <p class=\"hashTag\">\r\n");
      out.write("                                    <span class=\"dp_ib\">해시태그1</span>\r\n");
      out.write("                                    <span class=\"dp_ib\">해시태그2</span>\r\n");
      out.write("                                    <span class=\"dp_ib\">해시태그3</span>\r\n");
      out.write("                                </p>\r\n");
      out.write("                                <h4 class=\"recom-tit\">제목</h4>\r\n");
      out.write("                                <p class=\"recom-price\"><span class=\"fw600\">가격</span>원/시간</p>\r\n");
      out.write("                                <p class=\"star\">★★★★★</p>\r\n");
      out.write("                                <p class=\"member-conts\">댓글 내용</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\" class=\"dp_block\">\r\n");
      out.write("                            <div class=\"recom-space-img\"><img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/example3.jpeg\" alt=\"이미지영역\" class=\"dp_block\"></div>\r\n");
      out.write("                            <div class=\"member-recom-conts\">\r\n");
      out.write("                                <p class=\"hashTag\">\r\n");
      out.write("                                    <span class=\"dp_ib\">해시태그1</span>\r\n");
      out.write("                                    <span class=\"dp_ib\">해시태그2</span>\r\n");
      out.write("                                    <span class=\"dp_ib\">해시태그3</span>\r\n");
      out.write("                                </p>\r\n");
      out.write("                                <h4 class=\"recom-tit\">제목</h4>\r\n");
      out.write("                                <p class=\"recom-price\"><span class=\"fw600\">가격</span>원/시간</p>\r\n");
      out.write("                                <p class=\"star\">★★★★★</p>\r\n");
      out.write("                                <p class=\"member-conts\">댓글 내용</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\" class=\"dp_block\">\r\n");
      out.write("                            <div class=\"recom-space-img\"><img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/example3.jpeg\" alt=\"이미지영역\" class=\"dp_block\"></div>\r\n");
      out.write("                            <div class=\"member-recom-conts\">\r\n");
      out.write("                                <p class=\"hashTag\">\r\n");
      out.write("                                    <span class=\"dp_ib\">해시태그1</span>\r\n");
      out.write("                                    <span class=\"dp_ib\">해시태그2</span>\r\n");
      out.write("                                    <span class=\"dp_ib\">해시태그3</span>\r\n");
      out.write("                                </p>\r\n");
      out.write("                                <h4 class=\"recom-tit\">제목</h4>\r\n");
      out.write("                                <p class=\"recom-price\"><span class=\"fw600\">가격</span>원/시간</p>\r\n");
      out.write("                                <p class=\"star\">★★★★★</p>\r\n");
      out.write("                                <p class=\"member-conts\">댓글 내용</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </article>\r\n");
      out.write("        </section>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <footer id=\"footer\">\r\n");
      out.write("        <article>\r\n");
      out.write("            <h2 id=\"f_logo\">\r\n");
      out.write("                <a href=\"index.html\" class=\"dp_block fw700\"><span>KH</span> Space</a>\r\n");
      out.write("            </h2>\r\n");
      out.write("            <p class=\"f_info\">\r\n");
      out.write("                상호명 : 케이에이치 스페이스  |  대표 : 이호민  |  영업소재지 : 서울특별시 강남구 테헤란로 10 10길 9 <br>\r\n");
      out.write("                영업시간 : 오후 3시30분 ~ 오후 9시50분  | 대표전화 : 02)1234-1234 <br>\r\n");
      out.write("                *공간에 대한 문의사항은 해당 공간 호스트에게 문의해주세요.\r\n");
      out.write("            </p>\r\n");
      out.write("            <div class=\"clearfix\">\r\n");
      out.write("                <p class=\"f_info2\">\r\n");
      out.write("                    KH SPACE는 통신판매중개자이며 통신 판매의 당사자가 아닙니다. <br>\r\n");
      out.write("                    따라서 KH SPACE 는 공간 거래 정보 및 거래에 대해 책임지지 않습니다.\r\n");
      out.write("                </p>\r\n");
      out.write("                <p class=\"cop\">Copyright KH SPACE Corp. All Rights Reserved.</p>\r\n");
      out.write("            </div>\r\n");
      out.write("        </article>\r\n");
      out.write("    </footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
