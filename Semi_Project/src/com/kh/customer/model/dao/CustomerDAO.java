package com.kh.customer.model.dao;

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

import com.kh.admin.banner.model.vo.SpaceAll;
import com.kh.customer.model.vo.Review;
import com.kh.host.model.vo.SpaceJoin;

import static com.kh.common.JDBCTemplate.*;

public class CustomerDAO {

	private Properties prop = new Properties();
	
	public CustomerDAO() {
		String fileName = BookingDAO.class.getResource("/sql/customer/customer-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<SpaceAll> selectSpaceAll(Connection conn, int spaceNo) {
		List<SpaceAll> spaceList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectSpaceAll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, spaceNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				SpaceAll s = new SpaceAll();
				s.setCompanyNo(rset.getInt("company_no"));
				s.setCompanyName(rset.getString("company_name"));
				s.setCompanyPlace(rset.getString("company_place"));
				s.setCompanyPointGa(rset.getInt("company_point_ga"));
				s.setCompanyPointHa(rset.getInt("company_point_ha"));
				s.setUserId(rset.getString("user_id"));
				s.setDelType(rset.getString("del_type"));
				s.setDelDate(rset.getDate("del_date"));
				s.setSpaceNo(rset.getInt("space_no"));
				s.setSpaceIntro(rset.getString("space_intro"));
				s.setBookingTime(rset.getString("booking_time"));
				s.setMaxBookingPeople(rset.getInt("max_booking_people"));
				s.setMinBookingPeople(rset.getInt("min_booking_people"));
				s.setSpaceThema(rset.getString("space_thema"));
				s.setSpaceCheck(rset.getString("space_check"));
				s.setHashtag(rset.getString("hashtag"));
				s.setSpaceName(rset.getString("space_name"));
				s.setSpaceFacilities(rset.getString("space_facilities"));
				s.setSpaceSlogan(rset.getString("space_slogan"));
				s.setPriceEvent(rset.getString("price_event"));
				s.setSpacePrice(rset.getInt("space_price"));
				s.setDayOffEvent(rset.getString("dayoff_event"));
				s.setMaxSpaceDayOff(rset.getString("max_space_dayoff"));
				s.setImageOriginalFileName(rset.getString("image_original_filename"));
				s.setImageRenamedFileName(rset.getString("image_renamed_filename"));
				s.setFlag(rset.getString("flag"));
				spaceList.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return spaceList;
	}

	public List<SpaceJoin> selectSpaceList(Connection conn) {
		List<SpaceJoin> spaceList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectSpaceList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				SpaceJoin s = new SpaceJoin();
				s.setCompanyNo(rset.getInt("company_no"));
				s.setCompanyName(rset.getString("company_name"));
				s.setCompanyPlace(rset.getString("company_place"));
				s.setCompanyPointGa(rset.getInt("company_point_ga"));
				s.setCompanyPointHa(rset.getInt("company_point_ha"));
				s.setUserId(rset.getString("user_id"));
				s.setDelType(rset.getString("del_type"));
				s.setDelDate(rset.getDate("del_date"));
				s.setSpaceNo(rset.getInt("space_no"));
				s.setSpaceIntro(rset.getString("space_intro"));
				s.setBookingTime(rset.getString("booking_time"));
				s.setMaxBookingPeople(rset.getInt("max_booking_people"));
				s.setMinBookingPeople(rset.getInt("min_booking_people"));
				s.setSpaceThema(rset.getString("space_thema"));
				s.setSpaceCheck(rset.getString("space_check"));
				s.setHashtag(rset.getString("hashtag"));
				s.setSpaceName(rset.getString("space_name"));
				s.setSpaceFacilities(rset.getString("space_facilities"));
				s.setSpaceSlogan(rset.getString("space_slogan"));
				s.setPriceEvent(rset.getString("price_event"));
				s.setSpacePrice(rset.getInt("space_price"));
				spaceList.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return spaceList;
	}

	public List<Review> selectPointList(Connection conn) {
		List<Review> pointList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectPointList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Review r = new Review();
				r.setSpaceNo(rset.getInt("space_no"));
				r.setSpacePoint(rset.getInt("point"));
				pointList.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return pointList;
	}
	
	
	
}
