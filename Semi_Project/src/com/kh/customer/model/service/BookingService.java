package com.kh.customer.model.service;
import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.customer.model.dao.BookingDAO;
import com.kh.customer.model.vo.Booking;
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


	public int bookingCancle(int bookingNo) {
		Connection conn = getConnection();
		int result = new BookingDAO().bookingCancle(conn, bookingNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}


	public int insertBooking(String userId, int spaceNo, String timepicker1, String timepicker2, String request1, int people) {
		Connection conn = getConnection();
		int result = new BookingDAO().insertBooking(conn, userId, spaceNo, timepicker1, timepicker2, request1, people);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}


	public List<Booking> spaceBookingListBySpaceNo(int spaceNo) {
		Connection conn = getConnection();
		List<Booking> list = new BookingDAO().spaceBookingListBySpaceNo(conn,spaceNo);
		close(conn);
		return list;
	}


}
