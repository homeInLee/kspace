package com.kh.booking.model.service;
import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.booking.model.dao.BookingDAO;
import com.kh.booking.model.vo.Booking;
public class BookingService {

	public List<Booking> myBookingList(String userId) {
		Connection conn = getConnection();
		List<Booking> list = new BookingDAO().myBookingList(conn, userId);
		close(conn);
		return list;
	}

}
