package com.kh.host.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.common.util.MvcRenamePolicy;
import com.kh.host.model.service.SpaceService;
import com.kh.host.model.vo.Space;
import com.kh.host.model.vo.SpaceDayOff;
import com.kh.host.model.vo.SpaceImageFile;
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
		String userId = mReq.getParameter("hostId"); //공간을 등록하는 호스트 아이디
		//호스트 아이디로 회사번호 가져오기(공간테이블에 필요함)
		int companyNo = new SpaceService().selectCompanyNo(userId);
		System.out.println("회사번호 : "+companyNo);
		
		/*********공간 테이블 데이터************/
		//=>객체 생성 완료, 데이터 추가 성공
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
		
		String hashTag = null; //해시태그
		if(mReq.getParameter("hashTag")!=null) {
			hashTag = mReq.getParameter("hashTag");
		}
		System.out.println("해시태그 : "+hashTag);
		
		String spaceName = mReq.getParameter("spaceName"); //공간명
		System.out.println("공간명 : "+spaceName);
		String spaceSlogan = mReq.getParameter("spaceSlogan"); //공간 슬로건
		System.out.println("슬로건 : "+spaceSlogan);
		String[] facilityArr = mReq.getParameterValues("facility"); //편의 시설
		String facility = null;
		if(facilityArr!=null) {
			facility = String.join(",", facilityArr);
		}
		System.out.println("편의 시설 : "+facility);
		
		Space space = new Space();
		space.setCompanyNo(companyNo);
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
		//=>데이터 추가 성공
		int enrollPrice = Integer.parseInt(mReq.getParameter("spaceEnrollPrice")); //공간 원래 가격
		System.out.println("공간 가격 : "+enrollPrice);
		
		String enrollEvent = mReq.getParameter("spaceEnrollEvent"); //이벤트 여부 --> 사용 끝
		System.out.println("이벤트 여부 : "+enrollEvent);
		
		String[] enrollEventTypeArr = mReq.getParameterValues("spaceEnrollEventType"); //정기/비정기 이벤트
		String enrollEventType = null;
		if(enrollEventTypeArr!=null) {
			enrollEventType = String.join(",", enrollEventTypeArr);
		}
		System.out.println("정기/비정기 : "+enrollEventType);
		
		String enrollAlwaysEventType = mReq.getParameter("spaceEnrollAlwaysEventType"); //정기 이벤트 주기
		String enrollAlwaysEventDate = mReq.getParameter("spaceEnrollAlwaysEventDate"); //정기 이벤트 날짜
		int enrollAlwaysEventPrice = 0; //정기 이벤트 가격
		try {
				enrollAlwaysEventPrice = Integer.parseInt(mReq.getParameter("spaceEnrollAlwaysEventPrice")); //정기 이벤트 가격
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
		System.out.println("정기 주기/날짜/가격 : "+enrollAlwaysEventType+", "+enrollAlwaysEventDate+", "+enrollAlwaysEventPrice);
		
		String enrollNotAlwaysEventStartDate = mReq.getParameter("spaceEnrollNotAlwaysEventStartDate"); //비정기이벤트 시작일
		String enrollNotAlwaysEventEndDate = mReq.getParameter("spaceEnrollNotAlwaysEventEndDate"); //비정기이벤트 마지막일
		int enrollNotAlwaysEventPrice = 0; //비정기 이벤트 가격
		
		try {
				enrollNotAlwaysEventPrice = Integer.parseInt(mReq.getParameter("spaceEnrollNotAlwaysEventPrice")); //비정기 이벤트 가격
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		System.out.println("비정기 날짜/가격 : "+enrollNotAlwaysEventStartDate+"~"+enrollNotAlwaysEventEndDate+", "+enrollNotAlwaysEventPrice);
		
		
		/*********휴무 테이블 데이터************/
		//=>객체 생성 완료, 데이터 추가 성공
		String[] enrollDayOffArr = mReq.getParameterValues("spaceEnrollDayOff"); //휴무일
		System.out.println("휴무일 : "+Arrays.toString(enrollDayOffArr));
		
		String spaceEnrollDayOffETC = mReq.getParameter("spaceEnrollDayOffETC"); //휴무일에 기타가 있을 경우
		System.out.println("기타 휴무일 : "+spaceEnrollDayOffETC);
		
		String maxSpaceDayOff = "";
		if(enrollDayOffArr!=null) {
			for(int i=0; i<enrollDayOffArr.length; i++) {
				if(enrollDayOffArr[i].equals("기타")) {
					maxSpaceDayOff += spaceEnrollDayOffETC;
				} else {
					maxSpaceDayOff += enrollDayOffArr[i]+",";
				}
			}
		}
		
		System.out.println("가공한 휴무일 : "+maxSpaceDayOff);
		
		String enrollDayOffEvent = null; //휴무사유
		if(mReq.getParameter("spaceEnrollDayOffEvent")!=null) {
			enrollDayOffEvent = mReq.getParameter("spaceEnrollDayOffEvent");
		}
		System.out.println("휴무사유 : "+enrollDayOffEvent);
		
		SpaceDayOff dayoff = new SpaceDayOff();
		dayoff.setDayOffEvent(enrollDayOffEvent);
		dayoff.setMaxSpaceDayOff(maxSpaceDayOff);
		
		
		/*********이미지 테이블 데이터************/
		//=>데이터 추가 성공
		String[] renamedFileImgArr = new String[4];
		String[] originalFileImgArr = new String[4];
		
		for(int i=0; i<4; i++) {
			if(i==0) { //대표이미지
				renamedFileImgArr[i]=mReq.getFilesystemName("spaceEnrollFile");
				originalFileImgArr[i]=mReq.getOriginalFileName("spaceEnrollFile");
			} else { //다중이미지
				renamedFileImgArr[i]=mReq.getFilesystemName("spaceEnrollFileImg"+i);
				originalFileImgArr[i]=mReq.getOriginalFileName("spaceEnrollFileImg"+i);
			}
		}
		
		System.out.println(Arrays.toString(renamedFileImgArr));
		System.out.println(Arrays.toString(originalFileImgArr));
		
		//2.업무로직
		int spaceNo = new SpaceService().insertSpace(space);
		System.out.println(spaceNo);
		if(spaceNo>0) { //공간등록에 성공해서 spaceNo를 가져온다면 0보다 클 것.
			//휴무 테이블 추가
			int dayOffResult = new SpaceService().insertDayOff(spaceNo, dayoff);
			if(dayOffResult > 0) {
				System.out.println("휴무테이블 추가 성공");
			}
			
			//이미지 테이블 추가
			int spaceImgResult = 0;
			for(int i=0; i<renamedFileImgArr.length; i++) {
				if(renamedFileImgArr[i]!=null && originalFileImgArr[i]!=null) {
					SpaceImageFile spaceImg = new SpaceImageFile();
					spaceImg.setSpaceNo(spaceNo);
					spaceImg.setImageOriginalFileName(originalFileImgArr[i]);
					spaceImg.setImageRenamedFileName(renamedFileImgArr[i]);
					if(i!=0) {
						spaceImg.setFlag("N");
					}
					System.out.println(spaceImg);
					spaceImgResult = new SpaceService().insertSpaceImg(spaceImg);
				}
			}
			if(spaceImgResult>0) {
				System.out.println("이미지 등록 성공!");
			}
			
			//가격 - 이벤트 테이블 추가
			//이벤트 여부 체크
			SpacePrice eventPrice = new SpacePrice();
			int eventResult = 0;
			if(enrollEvent!=null) { //이벤트가 있는 경우
				if(enrollEventType.contains("비정기 이벤트") && enrollEventType.contains("정기 이벤트")) { //정기, 비정기이벤트
					System.out.println("이벤트 둘 다 있음");
					eventPrice.setSpaceNo(spaceNo);
					eventPrice.setPriceEvent(enrollAlwaysEventDate); //1주일에 한번이면 토, 1개월에 한번이면 20일
					eventPrice.setSpacePrice(enrollAlwaysEventPrice);
					eventResult = new SpaceService().insertPrice(eventPrice);
					
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					try {
						Date startEvent = df.parse(enrollNotAlwaysEventStartDate);
						Date endEvent = df.parse(enrollNotAlwaysEventEndDate);
						Calendar startDay = Calendar.getInstance();
						Calendar endDay = Calendar.getInstance();
						startDay.setTime(startEvent);
						endDay.setTime(endEvent);
						//시작날짜와 끝 날짜를 비교해, 시작날짜가 작거나 같은 경우 출력
						while(startDay.compareTo(endDay) !=1 ){
							System.out.printf("%tF\n", startDay.getTime());
							
							String strDate = df.format(startDay.getTime());
							eventPrice.setSpaceNo(spaceNo);
							eventPrice.setPriceEvent(strDate);
							eventPrice.setSpacePrice(enrollNotAlwaysEventPrice);
							eventResult = new SpaceService().insertPrice(eventPrice);
							System.out.println(eventPrice);
							//시작날짜 + 1 일
							startDay.add(Calendar.DATE, 1);
						}
						
					} catch (ParseException e) {
						e.printStackTrace();
					}
					
				} else if(enrollEventType.equals("정기 이벤트")) { //정기 이벤트
					
					eventPrice.setSpaceNo(spaceNo);
					eventPrice.setPriceEvent(enrollAlwaysEventDate); //1주일에 한번이면 토, 1개월에 한번이면 20일
					eventPrice.setSpacePrice(enrollAlwaysEventPrice);
					System.out.println("eventPrice객체 : "+eventPrice);
					eventResult = new SpaceService().insertPrice(eventPrice);
					
				} else if(enrollEventType.equals("비정기 이벤트")) { //비정기 이벤트
					
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					try {
						Date startEvent = df.parse(enrollNotAlwaysEventStartDate);
						Date endEvent = df.parse(enrollNotAlwaysEventEndDate);
						Calendar startDay = Calendar.getInstance();
						Calendar endDay = Calendar.getInstance();
						startDay.setTime(startEvent);
						endDay.setTime(endEvent);
						//시작날짜와 끝 날짜를 비교해, 시작날짜가 작거나 같은 경우 출력
						while(startDay.compareTo(endDay) !=1 ){
							System.out.printf("%tF\n", startDay.getTime());
							
							String strDate = df.format(startDay.getTime());
							eventPrice.setSpaceNo(spaceNo);
							eventPrice.setPriceEvent(strDate);
							eventPrice.setSpacePrice(enrollNotAlwaysEventPrice);
							eventResult = new SpaceService().insertPrice(eventPrice);
							System.out.println(eventPrice);
							//시작날짜 + 1 일
							startDay.add(Calendar.DATE, 1);
						}
						
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			} else { //이벤트 없는 경우
				eventPrice.setSpaceNo(spaceNo);
				eventPrice.setPriceEvent(enrollEvent);
				eventPrice.setSpacePrice(enrollPrice);
				eventResult = new SpaceService().insertPrice(eventPrice);
			}
			
			if(eventResult > 0) {
				System.out.println("이벤트 등록 성공!");
			}
			
		} else { //로직 실패.
			
		}
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
