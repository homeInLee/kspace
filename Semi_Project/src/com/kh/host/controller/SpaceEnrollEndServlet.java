package com.kh.host.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.common.util.MvcRenamePolicy;
import com.kh.host.model.vo.Space;
import com.kh.host.model.vo.SpaceDayOff;
import com.kh.host.model.vo.SpacePrice;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

/**
 * Servlet implementation class SpaceEnrollEndServlet
 */
@WebServlet("/host/spaceEnrollEnd")
public class SpaceEnrollEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpaceEnrollEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.파일 업로드 체크
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "공간 등록 파일 업로드 오류입니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String root = getServletContext().getRealPath("/");
		System.out.println("root : "+root);
		String saveDirectory = root + "upload" + File.separator + "host";
		System.out.println("saveDirectory : "+saveDirectory);
		
		int maxPostSize = 1024*1024*40;
		String encoding = "UTF-8";
		
		FileRenamePolicy mvcRenamePolicy = new MvcRenamePolicy();
		MultipartRequest mReq = new MultipartRequest(request, saveDirectory, maxPostSize, encoding, mvcRenamePolicy);
		
		//1.파라미터 핸들링
		
		/*********공간 테이블 데이터************/
		//=>객체 생성 완료
		String spaceIntro = mReq.getParameter("spaceIntro"); //공간 소개
		System.out.println("소개 : "+spaceIntro);
		String enrollTime1 = mReq.getParameter("spaceEnrollTime1"); //예약가능시간1
		String enrollTime2 = mReq.getParameter("spaceEnrollTime2"); //예약가능시간2
		String bookingTime = enrollTime1+"~"+enrollTime2;
		System.out.println("예약가능시간 : "+bookingTime);
		int minBookingPeople = Integer.parseInt(mReq.getParameter("minBookingPeople")); //예약 최소인원
		int maxBookingPeople = Integer.parseInt(mReq.getParameter("maxBookingPeople")); //예약 최대인원
		System.out.println("예약인원 : "+minBookingPeople+"~"+maxBookingPeople);
		String[] spaceTypeArr = mReq.getParameterValues("spaceType"); //공간유형
		String spaceThema = String.join(",", spaceTypeArr);
		System.out.println("공간유형 : "+spaceThema);
		String hashTag = mReq.getParameter("hashTag"); //해시태그
		System.out.println("해시태그 : "+hashTag);
		String spaceName = mReq.getParameter("spaceName"); //공간명
		System.out.println("공간명 : "+spaceName);
		String spaceSlogan = mReq.getParameter("spaceSlogan"); //공간 슬로건
		System.out.println("슬로건 : "+spaceSlogan);
		String[] facilityArr = mReq.getParameterValues("facility"); //편의 시설
		String facility = String.join(",", facilityArr);
		System.out.println("편의 시설 : "+facility);
		
		Space space = new Space();
		space.setSpaceIntro(spaceIntro);
		space.setBookingTime(bookingTime);
		space.setMaxBookingPeople(maxBookingPeople);
		space.setMinBookingPeople(minBookingPeople);
		space.setSpaceThema(spaceThema);
		space.setHashtag(hashTag);
		space.setSpaceName(spaceName);
		space.setSpaceFacilities(facility);
		space.setSpaceSlogan(spaceSlogan);
		
		
		/*********가격 테이블 데이터************/
		//공간테이블에 데이터 넣고 해당 공간의 번호를 가져와야함.
		int enrollPrice = Integer.parseInt(mReq.getParameter("spaceEnrollPrice")); //공간 가격
		System.out.println("공간 가격 : "+enrollPrice);
		String enrollEvent = mReq.getParameter("spaceEnrollEvent"); //이벤트 여부
		System.out.println("이벤트 여부 : "+enrollEvent);
		String[] enrollEventTypeArr = mReq.getParameterValues("spaceEnrollEventType"); //정기/비정기 이벤트
		System.out.println("정기/비정기 : "+Arrays.toString(enrollEventTypeArr));
		String enrollAlwaysEventType = mReq.getParameter("spaceEnrollAlwaysEventType"); //정기 이벤트 주기
		String enrollAlwaysEventDate = mReq.getParameter("spaceEnrollAlwaysEventDate"); //정기 이벤트 날짜
		System.out.println("정기 주기/날짜 : "+enrollAlwaysEventType+", "+enrollAlwaysEventDate);
		String enrollNotAlwaysEventDateYear = mReq.getParameter("spaceEnrollNotAlwaysEventDateYear"); //비정기이벤트 년도
		String enrollNotAlwaysEventDateMonth = mReq.getParameter("spaceEnrollNotAlwaysEventDateMonth"); //비정기이벤트 년도
		String enrollNotAlwaysEventDateDay = mReq.getParameter("spaceEnrollNotAlwaysEventDateDay"); //비정기이벤트 년도
		String enrollNotAlwaysEventDate = enrollNotAlwaysEventDateYear+"-"+enrollNotAlwaysEventDateMonth+"-"+enrollNotAlwaysEventDateDay;
		System.out.println("비정기 날짜 : "+enrollNotAlwaysEventDate);
		//int enrollEventPrice = Integer.parseInt(mReq.getParameter("spaceEnrollEventPrice")); //이벤트 가격
		//System.out.println("이벤트 가격 : "+enrollEventPrice);
		
		//이벤트 여부 체크
		if(enrollEvent!=null) { //이벤트가 있는 경우
			
		} else { //이벤트 없는 경우
			
		}
		
		/*********휴무 테이블 데이터************/
		//=>객체 생성 완료
		String[] enrollDayOffArr = mReq.getParameterValues("spaceEnrollDayOff"); //휴무일
		System.out.println("휴무일 : "+Arrays.toString(enrollDayOffArr));
		String spaceEnrollDayOffETC = mReq.getParameter("spaceEnrollDayOffETC"); //휴무일에 기타가 있을 경우
		System.out.println("기타 휴무일 : "+spaceEnrollDayOffETC);

		String maxSpaceDayOff = "";
		for(int i=0; i<enrollDayOffArr.length; i++) {
			if(enrollDayOffArr[i].equals("기타")) {
				maxSpaceDayOff += spaceEnrollDayOffETC;
			} else {
				maxSpaceDayOff += enrollDayOffArr[i]+",";
			}
		}
		
		System.out.println("가공한 휴무일 : "+maxSpaceDayOff);
		
		String enrollDayOffEvent = mReq.getParameter("spaceEnrollDayOffEvent"); //휴무사유
		System.out.println("휴무사유 : "+enrollDayOffEvent);
		
		SpaceDayOff dayoff = new SpaceDayOff();
		dayoff.setDayOffEvent(enrollDayOffEvent);
		dayoff.setMaxSpaceDayOff(maxSpaceDayOff);
		
		
		/*********이미지 테이블 데이터************/
		String renamedFileNameTit = mReq.getFilesystemName("spaceEnrollFile"); //대표이미지 rename
		System.out.println("대표이미지 rename : "+renamedFileNameTit);
		String originalFileNameTit = mReq.getOriginalFileName("spaceEnrollFile"); //대표이미지 original
		System.out.println("대표이미지 original : "+originalFileNameTit);
		String renamedFileNameMultiple = mReq.getFilesystemName("spaceEnrollFileMultiple"); //다중이미지 rename
		System.out.println("다중이미지 rename : "+renamedFileNameMultiple);
		String originalFileNameMultiple = mReq.getOriginalFileName("spaceEnrollFileMultiple"); //다중이미지 rename
		System.out.println("다중이미지 original : "+originalFileNameMultiple);
		
		//2.업무로직
		
		
		//3.view단 처리
//		String msg = "공간 등록 검수가 요청되었습니다.";
//		String loc = "/";
		//request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
