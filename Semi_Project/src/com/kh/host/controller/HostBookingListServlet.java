package com.kh.host.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.customer.model.service.BookingService;
import com.kh.customer.model.vo.Booking;
import com.kh.host.model.service.CompanyService;
import com.kh.host.model.service.SpacePriceService;
import com.kh.host.model.service.SpaceService;
import com.kh.host.model.vo.Company;
import com.kh.host.model.vo.Space;
import com.kh.host.model.vo.SpaceImageFile;
import com.kh.host.model.vo.SpacePrice;

/**
 * Servlet implementation class HostBookingListServlet
 */
@WebServlet("/host/hostBookingList")
public class HostBookingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HostBookingListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		Company c = new CompanyService().selectCompanyByUserId(userId);
		List<Space> slist = new SpaceService().spaceListbyCompanyNo(c.getCompanyNo());
		List<Booking> fakeblist = new ArrayList<>();
		List<Booking> blist = new ArrayList<>();
		Map<Integer, Booking> bmap = new HashMap<>();
		Map<Integer, SpaceImageFile> spaceImg = new HashMap<>();
		Map<Integer, String> namemap = new HashMap<>();
		Map<Integer, List<SpacePrice>> pricemap = new HashMap<>();
		Map<Integer, Integer> realprice = new HashMap<>();
		SimpleDateFormat format2 = new SimpleDateFormat ("yyyy-MM-dd");
		SimpleDateFormat format1 = new SimpleDateFormat ("dd");
		
		Calendar cal = Calendar.getInstance(); 
		int dayNum = 0;
		String day = "";
		
		for(int a=0; a<slist.size(); a++) {
			fakeblist = new BookingService().spaceBookingListBySpaceNo(slist.get(a).getSpaceNo());
			System.out.println("fakeblist"+fakeblist);
			SpaceImageFile Img = new SpaceService().selectSpaceImgBySpaceNoSelY(slist.get(a).getSpaceNo());
			for(int y=0; y<fakeblist.size(); y++) {
				blist.add(fakeblist.get(y));
				spaceImg.put(fakeblist.get(y).getBookingNo(), Img);
				bmap.put(fakeblist.get(y).getBookingNo(), fakeblist.get(y));
				namemap.put(fakeblist.get(y).getBookingNo(), slist.get(a).getSpaceName());
			}
		}
		for(int i=0; i<blist.size(); i++) {
			System.out.println(i);
			try {
				cal.setTime(format2.parse(format2.format(blist.get(i).getMaxTime())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			dayNum = cal.get(Calendar.DAY_OF_WEEK);
			switch(dayNum){
			case 1:
				day = "일";
				break ;
			case 2:
				day = "월";
				break ;
			case 3:
				day = "화";
				break ;
			case 4:
				day = "수";
				break ;
			case 5:
				day = "목";
				break ;    
			case 6:
				day = "금";
				break ;
			case 7:
				day = "토";
				break ;
			}
			System.out.println(day);
			//예약리스트로 뽑은 공간번호가 키값, 그 공간의 가격 테이블리스트가 벨류값(가격뽑기용)
			pricemap.put(blist.get(i).getSpaceNo(), new SpacePriceService().priceListBySpaceNo(blist.get(i).getSpaceNo()));
			System.out.println("pricemap="+pricemap);
			//예약리스트로 뽑은 공간번호로 예약한 사람의 공간리스트 생성(이름뽑기용)
			for(int y=0; y<pricemap.get(blist.get(i).getSpaceNo()).size(); y++) {
				System.out.println("bookingsize="+i+"pricemap size="+y);
				
				//키값이 공간번호(i)인 방의 y번째 가격이유가 null이면 평소가격
				if(pricemap.get(blist.get(i).getSpaceNo()).get(y).getPriceEvent() == null){
					realprice.put(blist.get(i).getBookingNo(), pricemap.get(blist.get(i).getSpaceNo()).get(y).getSpacePrice());
					System.out.println(realprice);
				}
				//키값이 공간번호(i)인 방의 y번째 가격이유가 빌린날짜의 요일이 포함되어 있다면 이벤트 가격
				else if(pricemap.get(blist.get(i).getSpaceNo()).get(y).getPriceEvent().contains(day)) {
					realprice.put(blist.get(i).getBookingNo(), pricemap.get(blist.get(i).getSpaceNo()).get(y).getSpacePrice());
					System.out.println(realprice);
				}
				
				else if((format1.format(blist.get(i).getMaxTime())+"일").equals(pricemap.get(blist.get(i).getSpaceNo()).get(y).getPriceEvent())) {
					realprice.put(blist.get(i).getBookingNo(), pricemap.get(blist.get(i).getSpaceNo()).get(y).getSpacePrice());
				}
				
				//키값이 공간번호(i)인 방의 y번째 가격이유가 빌린날짜의 년월일과 같다면 이벤트 가격
				else if(format2.format(blist.get(i).getMaxTime()).equals(pricemap.get(blist.get(i).getSpaceNo()).get(y).getPriceEvent())) {
					realprice.put(blist.get(i).getBookingNo(), pricemap.get(blist.get(i).getSpaceNo()).get(y).getSpacePrice());
					System.out.println(realprice);
				}
			}
		}
		System.out.println("bmap"+bmap);
		System.out.println("slist"+slist);
		System.out.println("blist"+blist);
		System.out.println("namemap"+namemap);
		System.out.println("realprice"+realprice);
		request.setAttribute("bmap", bmap);
		request.setAttribute("slist", slist);
		request.setAttribute("blist", blist);
		request.setAttribute("fakeblist", fakeblist);
		request.setAttribute("spaceImg", spaceImg);
		request.setAttribute("namemap", namemap);
		request.setAttribute("realprice", realprice);
		request.getRequestDispatcher("/WEB-INF/views/host/hostBookingList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
