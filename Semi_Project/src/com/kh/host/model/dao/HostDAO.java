package com.kh.host.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.admin.banner.model.dao.AdminDAO;
import com.kh.admin.banner.model.vo.SpaceAll;
import com.kh.customer.model.vo.User;
import com.kh.host.model.vo.Company;

public class HostDAO {
	
private Properties prop = new Properties();
	
	public HostDAO() {
		String fileName = HostDAO.class.getResource("/sql/host/host-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<SpaceAll> selectSpaceListByHostId(Connection conn, String hostId) {
		List<SpaceAll> hostSpaceList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectSpaceListByHostId");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hostId);
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
				hostSpaceList.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return hostSpaceList;
	}

	public List<User> selectUserList(Connection conn) {
		List<User> userList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectUserList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				User u = new User();
				u.setUserId(rset.getString("user_id"));
				
				userList.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return userList;
	}

	public int InsertUserHost(Connection conn, User u) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("InsertUserHost");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, u.getUserId());
			pstmt.setString(2, u.getUserName());
			pstmt.setString(3, u.getPassword());
			pstmt.setString(4, u.getPhone());
			pstmt.setString(5, u.getEmail());
			result = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int InsertCompany(Connection conn, Company c, String hostId) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("InsertCompany");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, c.getCompanyName());
			pstmt.setString(2, c.getCompanyPlace());
			pstmt.setString(3, c.getUserId());
			result = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

}
