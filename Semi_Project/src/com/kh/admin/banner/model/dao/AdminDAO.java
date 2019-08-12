package com.kh.admin.banner.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.admin.banner.model.vo.SpaceAll;

public class AdminDAO {

	private Properties prop = new Properties();
	
	public AdminDAO() {
		String fileName = AdminDAO.class.getResource("/sql/admin/admin-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<SpaceAll> selectNoChkSpace(Connection conn) {
		List<SpaceAll> noChkSpaceList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNoChkSpace");
		
		try {
			pstmt = conn.prepareStatement(sql);
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
				noChkSpaceList.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return noChkSpaceList;
	}

	public int spaceChkOK(Connection conn, int spaceNo, String spaceChk) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("spaceChkOK");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, spaceChk);
			pstmt.setInt(2, spaceNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
}
