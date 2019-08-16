package com.kh.customer.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.customer.model.service.BookingService;
import com.kh.customer.model.service.UserService;
import com.kh.customer.model.vo.Booking;
import com.kh.customer.model.vo.User;
import com.kh.host.model.service.CompanyService;
import com.kh.host.model.service.SpacePriceService;
import com.kh.host.model.service.SpaceService;
import com.kh.host.model.vo.Company;
import com.kh.host.model.vo.Space;
import com.kh.host.model.vo.SpacePrice;

/**
 * Servlet implementation class BookingSelectServlet
 */
@WebServlet(urlPatterns="/customer/bookingSelect",name="BookingSelectServlet")
public class BookingSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		int bookingNo = Integer.parseInt(request.getParameter("bookingNo"));
		
		//예약공간 = bookingNo로 spaceNo가져와서 space_tbl로 가서 각 값을 채워넣기*/
		Booking b = new BookingService().bookingSelectOneByNo(bookingNo);
		Space s = new SpaceService().spaceSelectOneBySpaceNo(b.getSpaceNo());
		System.out.println("booking="+b);
		System.out.println("space="+s);
		//공간명 = space = s.getSpaceName()
		//소개글 = space = s.getSpaceIntro()
		//공간유형 = space(thema) = s.getSpaceThema()
		//예약인원 = space = s.getMaxBookingPeople(),s.getMinBookingPeople()
		//추가인원 = 1명초과시 방값원(price) 추가
		List<SpacePrice> sp = new SpacePriceService().priceListBySpaceNo(b.getSpaceNo());
		System.out.println("spaceprice="+sp);
		//편의시설 = space = s.getSpaceFacilities()
		
		//예약자정보 = userId로 user_tbl가서  각값을 가져오고, bookingNo로 booking_tbl로 가서 요청사항 채워넣기
		User u = new UserService().UserSelectOneById(userId);
		System.out.println("user="+u);
		//예약자 = user = u.getUserId()
		//연락처 = user = u.getPhone()
		//이메일 = user = u.getEmail()
		//요청사항 = booking = b.getRequest()
		
		//호스트정보 = bookingNo로 space_tbl로 가서 공간명, companyNo받고 companyNo로 company_tbl로 가서 주소, userId받고 userId로 user_tbl로 가서 호스트,연락처 채워넣기
		Company c = new CompanyService().CompanySelectOneByCompanyNo(s.getCompanyNo());
		User hu = new UserService().UserSelectOneById(c.getUserId());
		System.out.println("company="+c);
		System.out.println("hu="+hu);
		//호스트 = user = hu.getUserName()
		//연락처 = user = hu.getPhone()
		//공간명 = space = s.getSpaceName()
		//주소 = company = c.getCompanyPlace()
		
		//결제금액 = bookingNo로 날짜, 시간, 인원, spaceNo구하고 spaceNo로 price_tbl로가서  날짜에 맞는 가격 구하기
		System.out.println((int)Math.ceil((b.getMinTime().getTime()-b.getMaxTime().getTime())/1000.0/3600.0));
		//예약날짜 = booking = b.getMaxTime()
		//예약시간 = booking = (int)Math.ceil((b.getMinTime().getTime()-b.getMaxTime().getTime())/1000.0/3600.0)
		//인원 = booking = b.getBookingPeople()
		//총가격 = price_tbl(price)*booking_tbl(people)*booking_tbl(time)
		SimpleDateFormat format2 = new SimpleDateFormat ("yyyy-MM-dd");
		int price = 0;
		Calendar cal = Calendar.getInstance(); 
		int dayNum = 0;
		String day = "";
		
		for(int i=0; i<sp.size(); i++) {
			try {
				cal.setTime(format2.parse(format2.format(b.getMaxTime())));
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
			//키값이 공간번호(i)인 방의 y번째 가격이유가 null이면 평소가격
			if(sp.get(i).getPriceEvent() == null){
				price = sp.get(i).getSpacePrice();
			}
			//키값이 공간번호(i)인 방의 y번째 가격이유가 빌린날짜의 요일이 포함되어 있다면 이벤트 가격
			else if(sp.get(i).getPriceEvent().contains(day)) {
				price = sp.get(i).getSpacePrice();
			}
			
			//키값이 공간번호(i)인 방의 y번째 가격이유가 빌린날짜의 년월일과 같다면 이벤트 가격
			else if(format2.format(b.getMaxTime()).equals(sp.get(i).getPriceEvent())) {
				price = sp.get(i).getSpacePrice();
			}
		}
		int realprice = price*b.getBookingPeople()*(int)Math.ceil((b.getMinTime().getTime()-b.getMaxTime().getTime())/1000.0/3600.0);
		
		System.out.println(realprice);
		
		request.setAttribute("b", b);//booking
		request.setAttribute("s", s);//space
		request.setAttribute("u", u);//user
		request.setAttribute("c", c);//company
		request.setAttribute("hu", hu);//hostuser
		request.setAttribute("realprice", realprice);//realprice
		request.setAttribute("price", price);
		request.getRequestDispatcher("/WEB-INF/views/customer/bookingSelect.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
