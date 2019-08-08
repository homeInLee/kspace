package com.kh.customer.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.customer.model.vo.Booking;
import com.kh.host.model.vo.Space;
import com.kh.host.model.vo.SpacePrice;

public class BookingDAO {
	
	private Properties prop = new Properties();
	
	public BookingDAO() {
		String fileName = BookingDAO.class.getResource("/sql/customer/customer-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
			System.out.println("[[prop loading 완료:"+fileName+"]]");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<Booking> myBookingList(Connection conn, String userId) {
		List<Booking> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("myBookingList");
		try {
			//1.PrepareStatement준비(미완성쿼리 완성)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			//2.실행 및 ResultSet 리턴받기
			rset = pstmt.executeQuery();
			//3.ResultSet -> result
			while(rset.next()) {
				Booking b = new Booking();
				b.setBookingNo(rset.getInt("booking_no"));
				b.setMaxTime(rset.getTimestamp("max_booking_time"));
				b.setMinTime(rset.getTimestamp("min_booking_time"));
				b.setSpaceNo(rset.getInt("space_no"));
				b.setBookingPeople(rset.getInt("booking_people"));
				b.setUserId(rset.getString("user_id"));
				b.setRequest(rset.getString("request"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public Booking bookingSelectOne(Connection conn, int bookingNo) {
		Booking b = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("bookingSelectOne");
		try {
			//1.PrepareStatement준비(미완성쿼리 완성)
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookingNo);
			//2.실행 및 ResultSet 리턴받기
			rset = pstmt.executeQuery();
			//3.ResultSet -> result
			if(rset.next()) {
				b = new Booking();
				b.setBookingNo(rset.getInt("booking_no"));
				b.setMaxTime(rset.getTimestamp("max_booking_time"));
				b.setMinTime(rset.getTimestamp("min_booking_time"));
				b.setSpaceNo(rset.getInt("space_no"));
				b.setBookingPeople(rset.getInt("booking_people"));
				b.setUserId(rset.getString("user_id"));
				b.setRequest(rset.getString("request"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return b;
	}
	

}
