package com.kh.customer.controller;

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
import com.kh.host.model.service.SpacePriceService;
import com.kh.host.model.service.SpaceService;
import com.kh.host.model.vo.Space;
import com.kh.host.model.vo.SpacePrice;

/**
 * Servlet implementation class BookingList
 */
@WebServlet(urlPatterns="/customer/bookingList",name="BookingListServlet")
public class BookingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		System.out.println(userId);
		
		//예약리스트
		List<Booking> list = new BookingService().myBookingListById(userId);
		//각 공간의 가격 맵(공간번호, SpacePrice리스트)
		Map<Integer, List<SpacePrice>> pricemap = new HashMap<>();
		//공간리스트
		List<Space> spacelist = new ArrayList<>();
		//예약리스트를 가진 사람이 빌린 공간의 특정날짜 가격 맵(공간번호, 가격)
		Map<Integer, Integer> realprice = new HashMap<>();
		System.out.println("list="+list);
		SimpleDateFormat format2 = new SimpleDateFormat ("yyyy-MM-dd");
		SimpleDateFormat format1 = new SimpleDateFormat ("dd");
		
		Calendar cal = Calendar.getInstance(); 
		int dayNum = 0;
		 
		String day = "";
		for(int i=0; i<list.size(); i++) {
			System.out.println(i);
			try {
				cal.setTime(format2.parse(format2.format(list.get(i).getMaxTime())));
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
			pricemap.put(list.get(i).getSpaceNo(), new SpacePriceService().priceListBySpaceNo(list.get(i).getSpaceNo()));
			System.out.println("pricemap="+pricemap);
			//예약리스트로 뽑은 공간번호로 예약한 사람의 공간리스트 생성(이름뽑기용)
			spacelist.add(new SpaceService().spaceSelectOneBySpaceNo(list.get(i).getSpaceNo()));
			System.out.println("spacelist="+spacelist);
			
			for(int y=0; y<pricemap.get(list.get(i).getSpaceNo()).size(); y++) {
				System.out.println("bookingsize="+i+"pricemap size="+y);
				
				//키값이 공간번호(i)인 방의 y번째 가격이유가 null이면 평소가격
				if(pricemap.get(list.get(i).getSpaceNo()).get(y).getPriceEvent() == null){
					realprice.put(list.get(i).getSpaceNo(), pricemap.get(list.get(i).getSpaceNo()).get(y).getSpacePrice());
					System.out.println(realprice);
				}
				//키값이 공간번호(i)인 방의 y번째 가격이유가 빌린날짜의 요일이 포함되어 있다면 이벤트 가격
				else if(pricemap.get(list.get(i).getSpaceNo()).get(y).getPriceEvent().contains(day)) {
					realprice.put(list.get(i).getSpaceNo(), pricemap.get(list.get(i).getSpaceNo()).get(y).getSpacePrice());
					System.out.println(realprice);
				}
				
				else if(format1.format(list.get(i).getMaxTime()).equals(pricemap.get(list.get(i).getSpaceNo()).get(y).getPriceEvent())) {
					realprice.put(list.get(i).getSpaceNo(), pricemap.get(list.get(i).getSpaceNo()).get(y).getSpacePrice());
				}
				
				//키값이 공간번호(i)인 방의 y번째 가격이유가 빌린날짜의 년월일과 같다면 이벤트 가격
				else if(format2.format(list.get(i).getMaxTime()).equals(pricemap.get(list.get(i).getSpaceNo()).get(y).getPriceEvent())) {
					realprice.put(list.get(i).getSpaceNo(), pricemap.get(list.get(i).getSpaceNo()).get(y).getSpacePrice());
					System.out.println(realprice);
				}
			}
		}
		request.setAttribute("list", list);
		request.setAttribute("realprice", realprice);
		request.setAttribute("spacelist", spacelist);
		request.getRequestDispatcher("/WEB-INF/views/customer/bookingList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
