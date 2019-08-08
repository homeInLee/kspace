package com.kh.customer.model.service;
import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.customer.model.dao.BookingDAO;
import com.kh.customer.model.vo.Booking;
import com.kh.host.model.vo.Space;
import com.kh.host.model.vo.SpacePrice;
public class BookingService {

	public List<Booking> myBookingListById(String userId) {
		Connection conn = getConnection();
		List<Booking> list = new BookingDAO().myBookingListById(conn, userId);
		close(conn);
		return list;
	}


	public Booking bookingSelectOneByNo(int bookingNo) {
		Connection conn = getConnection();
		Booking b = new BookingDAO().bookingSelectOneByNo(conn, bookingNo);
		close(conn);
		return b;
	}


}
