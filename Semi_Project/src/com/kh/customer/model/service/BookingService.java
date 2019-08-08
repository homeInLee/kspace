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

	public List<Booking> myBookingList(String userId) {
		Connection conn = getConnection();
		List<Booking> list = new BookingDAO().myBookingList(conn, userId);
		close(conn);
		return list;
	}


	public Booking bookingSelectOne(int bookingNo) {
		Connection conn = getConnection();
		Booking b = new BookingDAO().bookingSelectOne(conn, bookingNo);
		close(conn);
		return b;
	}


}
