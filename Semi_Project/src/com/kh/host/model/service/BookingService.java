package com.kh.host.model.service;
import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.host.model.dao.BookingDAO;
import com.kh.host.model.vo.Booking;
import com.kh.host.model.vo.Space;
import com.kh.host.model.vo.SpacePrice;
public class BookingService {

	public List<Booking> myBookingList(String userId) {
		Connection conn = getConnection();
		List<Booking> list = new BookingDAO().myBookingList(conn, userId);
		close(conn);
		return list;
	}

	public List<SpacePrice> pirceList(int spaceNo) {
		Connection conn = getConnection();
		List<SpacePrice> pricelist = new BookingDAO().pirceList(conn, spaceNo);
		close(conn);
		return pricelist;
	}

	public Space spaceSelectOne(int spaceNo) {
		Connection conn = getConnection();
		Space s = new BookingDAO().spaceSelectOne(conn, spaceNo);
		close(conn);
		return s;
	}


}
