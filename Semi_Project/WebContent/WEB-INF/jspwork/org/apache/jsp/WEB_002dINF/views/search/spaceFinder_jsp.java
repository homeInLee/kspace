/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.42
 * Generated at: 2019-08-12 12:28:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.search;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.kh.host.model.vo.*;

public final class spaceFinder_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1565612404411L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1565600118699L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("com.kh.host.model.vo");
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
      out.write("<script>\r\n");
      out.write("$(()=> {\r\n");
      out.write("\t$(\"#spaceSrch\").keyup(e => {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar $sel = $(\".sel\");\r\n");
      out.write("\t\tvar $li = $(\"#autoComplete li\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(e.key == \"ArrowDown\"){\r\n");
      out.write("\t\t\tif($sel.length == 0){\r\n");
      out.write("\t\t\t\t$li.eq(0).addClass(\"sel\");\r\n");
      out.write("\t\t\t}\t\r\n");
      out.write("\t\t\telse if($sel.is($li.last())){\r\n");
      out.write("\t\t\t\t//처리코드 없음\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse{\r\n");
      out.write("\t\t\t\t$sel.removeClass(\"sel\")\r\n");
      out.write("\t\t\t\t    .next()\r\n");
      out.write("\t\t\t\t    .addClass(\"sel\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse if(e.key == \"ArrowUp\"){\r\n");
      out.write("\t\t\tif($sel.length == 0){\r\n");
      out.write("\t\t\t\t//처리코드 없음\r\n");
      out.write("\t\t\t}\t\r\n");
      out.write("\t\t\telse if($sel.is($li.first())){\r\n");
      out.write("\t\t\t\t$sel.removeClass(\"sel\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse{\r\n");
      out.write("\t\t\t\t$sel.removeClass(\"sel\")\r\n");
      out.write("\t\t\t\t    .prev()\r\n");
      out.write("\t\t\t\t    .addClass(\"sel\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse if(e.key == \"Enter\"){\r\n");
      out.write("\t\t\t//값입력\r\n");
      out.write("\t\t\t$(e.target).val($sel.text());\r\n");
      out.write("\t\t\t//#autoComplete 감춤\r\n");
      out.write("\t\t\t$(\"#autoComplete\").hide()\r\n");
      out.write("\t\t\t\t\t\t\t  .children()\r\n");
      out.write("\t\t\t\t\t\t\t  .remove();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse{\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar spaceSrch = $(e.target).val();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//사용자입력값이 없는 경우, 조기 리턴처리함.\r\n");
      out.write("\t\t\tif(spaceSrch.trim().length == 0)\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl:\"");
      out.print(request.getContextPath());
      out.write("/search/autoComplete.do\",\r\n");
      out.write("\t\t\t\ttype:\"post\",\r\n");
      out.write("\t\t\t\tdata:\"spaceSrch=\"+spaceSrch,\r\n");
      out.write("\t\t\t\tsuccess: function(data){\r\n");
      out.write("\t\t\t\t\tconsole.log(data);\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tif(data.trim().length == 0){\r\n");
      out.write("\t\t\t\t\t\t$(\"#autoComplete\").hide();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\t\tvar nameArr = data.split(',');\r\n");
      out.write("\t\t\t\t\t\tvar html = \"\";\r\n");
      out.write("\t\t\t\t\t\t$.each(nameArr, (i, name)=>{\r\n");
      out.write("\t\t\t\t\t\t\tname = name.replace(spaceSrch,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\"<span class='srchVal'>\"+spaceSrch+\"</span>\");\r\n");
      out.write("\t\t\t\t\t\t\thtml += \"<li>\"+name+\"</li>\";\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t$(\"#autoComplete\").html(html)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t  .fadeIn(200);\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t//마우스 이벤트 핸들러 추가\r\n");
      out.write("\t\t\t\t\t$(\"#autoComplete li\")\r\n");
      out.write("\t\t\t\t\t\t.click(e=>{\r\n");
      out.write("\t\t\t\t\t\t\t//값입력\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#spaceSrch\").val($(e.target).text());\r\n");
      out.write("\t\t\t\t\t\t\t//#autoComplete 감춤\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#autoComplete\").hide()\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t  .children()\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t  .remove();\r\n");
      out.write("\t\t\t\t\t\t})\r\n");
      out.write("\t\t\t\t\t\t.hover(e=>{\r\n");
      out.write("\t\t\t\t\t\t\t$(e.target).addClass(\"sel\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t   .siblings()\r\n");
      out.write("\t\t\t\t\t\t\t\t\t   .removeClass(\"sel\");\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t}, e=>{\r\n");
      out.write("\t\t\t\t\t\t\t$(e.target).removeClass(\"sel\");\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror: function(jqxhr, textStatus, errorThrown){\r\n");
      out.write("\t\t\t\t\tconsole.log(\"ajax처리실패!\");\r\n");
      out.write("\t\t\t\t\tconsole.log(jqxhr, textStatus, errorThrown);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <header id=\"header\">\r\n");
      out.write("        <h1 id=\"logo\">\r\n");
      out.write("            <a href=\"");
      out.print(request.getContextPath() );
      out.write("\" class=\"dp_block fw700\"><span>KH</span> Space</a>\r\n");
      out.write("        </h1>\r\n");
      out.write("        <div id=\"search-area\">\r\n");
      out.write("            <form action=\"");
      out.print(request.getContextPath() );
      out.write("/search/spaceFinder\" method=\"get\" name=\"spaceSearchFrm\"  class=\"dp_block clearfix\">\r\n");
      out.write("                <input type=\"text\" name=\"spaceSrch\" id=\"spaceSrch\" placeholder=\"지역 또는 공간유형을 검색해보세요!\">\r\n");
      out.write("                <input type=\"submit\" id=\"srchBtn\" value=\"검색\">\r\n");
      out.write("            </form>\r\n");
      out.write("                <ul id=\"autoComplete\"></ul>\r\n");
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
      out.write("\t                <li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/booking/bookingList?userId=datbot\" class=\"dp_block\">예약 리스트</a></li>\r\n");
      out.write("\t                <li><a href=\"\" class=\"dp_block\">찜한 공간</a></li>\r\n");
      out.write("\t                <li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/customer/spaceList\" class=\"dp_block\">전체 공간보기</a></li>\r\n");
      out.write("\t                <li><a href=\"\" class=\"dp_block\">추천 공간</a></li>\r\n");
      out.write("\t                <li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/board/adminNote\" class=\"dp_block\">공지사항</a></li>\r\n");
      out.write("\t                <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/banner/information\" class=\"dp_block\">배너 등록</a></li>\r\n");
      out.write("\t                <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/spaceChkList\" class=\"dp_block\">관리자 공간 검수 리스트</a></li>\r\n");
      out.write("\t                <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/host/mySpaceList\" class=\"dp_block\">호스트 본인이 등록한 공간 리스트</a></li>\r\n");
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
      out.write("\r\n");

	List<SpaceJoin> spaceList = (List<SpaceJoin>)request.getAttribute("list");
	String spaceSrch = request.getParameter("spaceSrch");

      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/sub.css\" />\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/js/spaceList.js\"></script>\r\n");
      out.write("<div class=\"sub_container\">\r\n");
      out.write("    <section class=\"spacePage\">\r\n");
      out.write("        <article class=\"spaceSrch-wrap\">\r\n");
      out.write("            <h3 class=\"fw300\"><span class=\"fw500\">");
      out.print(spaceSrch );
      out.write("</span>(으)로 검색한 결과입니다.</h3>\r\n");
      out.write("                <div class=\"noFilter\">\r\n");
      out.write("                    <div>\r\n");
      out.write("                        <p>공간 유형</p>\r\n");
      out.write("                        <div class=\"custom-select\">\r\n");
      out.write("                            <select name=\"spaceType\" id=\"spaceType\">\r\n");
      out.write("                            \t<option value=\"\">전체</option>\r\n");
      out.write("                                <option value=\"스터디룸\">스터디룸</option>\r\n");
      out.write("                                <option value=\"공연장\">공연장</option>\r\n");
      out.write("                                <option value=\"세미나실\">세미나실</option>\r\n");
      out.write("                                <option value=\"파티룸\">파티룸</option>\r\n");
      out.write("                                <option value=\"카페\">카페</option>\r\n");
      out.write("                                <option value=\"기타\">기타</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"placeFilter\">\r\n");
      out.write("                        <p>지역</p>\r\n");
      out.write("                        <div class=\"custom-select\">\r\n");
      out.write("                            <select name=\"spaceArea\" id=\"spaceArea\"  class=\"dp_block\">\r\n");
      out.write("                            \t<option value=\"spaceAreaTotal\">전체</option>\r\n");
      out.write("                                <option value=\"도봉구\">도봉구</option>\r\n");
      out.write("                                <option value=\"노원구\">노원구</option>\r\n");
      out.write("                                <option value=\"강북구\">강북구</option>\r\n");
      out.write("                                <option value=\"중랑구\">중랑구</option>\r\n");
      out.write("                                <option value=\"동대문구\">동대문구</option>\r\n");
      out.write("                                <option value=\"성북구\">성북구</option>\r\n");
      out.write("                                <option value=\"종로구\">종로구</option>\r\n");
      out.write("                                <option value=\"은평구\">은평구</option>\r\n");
      out.write("                                <option value=\"마포구\">마포구</option>\r\n");
      out.write("                                <option value=\"용산구\">용산구</option>\r\n");
      out.write("                                <option value=\"성동구\">성동구</option>\r\n");
      out.write("                                <option value=\"광진구\">광진구</option>\r\n");
      out.write("                                <option value=\"강서구\">강서구</option>\r\n");
      out.write("                                <option value=\"양천구\">양천구</option>\r\n");
      out.write("                                <option value=\"영등포구\">영등포구</option>\r\n");
      out.write("                                <option value=\"구로구\">구로구</option>\r\n");
      out.write("                                <option value=\"동작구\">동작구</option>\r\n");
      out.write("                                <option value=\"관악구\">관악구</option>\r\n");
      out.write("                                <option value=\"금천구\">금천구</option>\r\n");
      out.write("                                <option value=\"서초구\">서초구</option>\r\n");
      out.write("                                <option value=\"강남구\">강남구</option>\r\n");
      out.write("                                <option value=\"송파구\">송파구</option>\r\n");
      out.write("                                <option value=\"강동구\">강동구</option>\r\n");
      out.write("                                <option value=\"중구\">중구</option>\r\n");
      out.write("                                <option value=\"서대문구\">서대문구</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"txt_right\">\r\n");
      out.write("                        <a href=\"\" class=\"dp_ib txt_center\">필터</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            <form action=\"");
      out.print(request.getContextPath() );
      out.write("/search/searchFilter\" method=\"get\" class=\"dp_block\">\r\n");
      out.write("            <input type=\"hidden\" name=\"spaceSrch\" value=\"");
      out.print(spaceSrch);
      out.write("\" />\r\n");
      out.write("                <div class=\"srchFilter-wrap\">\r\n");
      out.write("                    <div>\r\n");
      out.write("                        <div class=\"srchFilter clearfix\" style=\"width: 587px;\">\r\n");
      out.write("                            <h4 class=\"fw300\"><span class=\"fw600\">가격범위</span>를 선택하세요.</h4>\r\n");
      out.write("                            <p>\r\n");
      out.write("                                <input type=\"checkbox\" name=\"chkTotal\" id=\"chkTotal\">\r\n");
      out.write("                                <label for=\"chkTotal\">전체 범위</label>\r\n");
      out.write("                            </p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <span class=\"srchPrice dp_ib\"><input type=\"text\" name=\"srchPrice1\" id=\"srchPrice1\" class=\"dp_block\"> </span>\r\n");
      out.write("                        ~ \r\n");
      out.write("                        <span class=\"srchPrice dp_ib\"><input type=\"text\" name=\"srchPrice2\" id=\"srchPrice2\" class=\"dp_block\"> </span>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"srchFilter clearfix\">\r\n");
      out.write("                            <h4 class=\"fw300\"><span class=\"fw600\">편의시설</span>을 선택하세요.</h4>\r\n");
      out.write("                            <p>\r\n");
      out.write("                                <input type=\"checkbox\" name=\"chkAll\" id=\"chkAll\">\r\n");
      out.write("                                <label for=\"chkAll\">전체 선택</label>\r\n");
      out.write("                            </p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <ul class=\"facility-list clearfix\">\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" name=\"facility\" id=\"facility0\" value=\"주차\">\r\n");
      out.write("                                <label for=\"facility0\">주차</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" name=\"facility\" id=\"facility1\" value=\"흡연\">\r\n");
      out.write("                                <label for=\"facility1\">흡연</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" name=\"facility\" id=\"facility2\" value=\"와이파이\">\r\n");
      out.write("                                <label for=\"facility2\">와이파이</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" name=\"facility\" id=\"facility3\" value=\"컴퓨터\">\r\n");
      out.write("                                <label for=\"facility3\">컴퓨터</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" name=\"facility\" id=\"facility4\" value=\"음식물\">\r\n");
      out.write("                                <label for=\"facility4\">음식물 반입금지</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" name=\"facility\" id=\"facility5\" value=\"콘센트\">\r\n");
      out.write("                                <label for=\"facility5\">콘센트</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" name=\"facility\" id=\"facility6\" value=\"의자/테이블\">\r\n");
      out.write("                                <label for=\"facility6\">의자/테이블</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" name=\"facility\" id=\"facility7\" value=\"반려동물\">\r\n");
      out.write("                                <label for=\"facility7\">반려동물 동반 가능</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                        <div class=\"filter-btn txt_center\">\r\n");
      out.write("                            <button type=\"reset\" class=\"dp_ib\">초기화</button>\r\n");
      out.write("                            <button type=\"submit\" class=\"dp_ib\">필터 적용하기</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("        </article>\r\n");
      out.write("    </section>\r\n");
      out.write("    <section class=\"subPage\">\r\n");
      out.write("        <article>\r\n");
      out.write("            <!--일반 존-->\r\n");
      out.write("            <ul class=\"recom-space clearfix\">\r\n");
      out.write("                ");
 if(!spaceList.isEmpty()) { 
      out.write("\r\n");
      out.write("                ");
 for(SpaceJoin s : spaceList) { 
      out.write("\r\n");
      out.write("                \t<li>\r\n");
      out.write("                    \t<a href=\"\" class=\"dp_block\">\r\n");
      out.write("                        \t<div class=\"recom-space-img\"><img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/example.jpeg\" alt=\"이미지영역\" class=\"dp_block\"></div>\r\n");
      out.write("                        \t<div class=\"recom-space-conts\">\r\n");
      out.write("                            \t<h4 class=\"recom-tit\">");
      out.print(s.getSpaceName() );
      out.write("</h4>\r\n");
      out.write("                            \t<p class=\"recom-cont\">\r\n");
      out.write("                                \t<span class=\"dp_ib fw600\">");
      out.print(s.getCompanyPlace() );
      out.write("</span><br>\r\n");
      out.write("                                \t<span class=\"dp_ib\">\r\n");
      out.write("                                \t");

                                	if(s.getHashtag() != null) {
                                		if(s.getHashtag().contains(",")) {
                                			String[] HashArr = s.getHashtag().split(",");
                                			for(int i=0; i<HashArr.length; i++) {
                                	
      out.write("\r\n");
      out.write("                                \t#");
      out.print(HashArr[i] );
      out.write("\r\n");
      out.write("                                \t");
 }} else { 
      out.write("\r\n");
      out.write("                                \t\t#");
      out.print(s.getHashtag() );
      out.write("\r\n");
      out.write("                                \t");
 }} 
      out.write("\r\n");
      out.write("                                \t</span>\r\n");
      out.write("                            \t</p>\r\n");
      out.write("                            \t<p class=\"recom-price\">\r\n");
      out.write("                                \t<span class=\"fw600\">\r\n");
      out.write("                                \t");
 if(s.getPriceEvent() == null) { 
      out.write("\r\n");
      out.write("                                \t");
      out.print(s.getSpacePrice() );
      out.write("\r\n");
      out.write("                                \t");
 } 
      out.write("\r\n");
      out.write("                                \t</span>원/시간\r\n");
      out.write("                            \t</p>\r\n");
      out.write("                        \t</div>\r\n");
      out.write("                    \t</a>\r\n");
      out.write("                \t</li>\r\n");
      out.write("                ");
 }} 
      out.write("\r\n");
      out.write("            </ul>\r\n");
      out.write("        </article>\r\n");
      out.write("    </section>\r\n");
      out.write("</div>\r\n");
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
