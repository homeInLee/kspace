package com.kh.host.model.dao;

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

import com.kh.host.model.vo.Space;
import com.kh.host.model.vo.SpaceDayOff;
import com.kh.host.model.vo.SpacePrice;

public class SpaceDAO {
	
	private Properties prop = new Properties();
	
	public SpaceDAO() {
		try {
			//클래스객체 위치찾기 : 절대경로를 반환한다. 
			// "/" : 루트디렉토리를 절대경로로 URL객체로 반환한다.
			// "./" : 현재디렉토리를 절대경로로 URL객체로 반환한다.
			// "./query.properties : 현재경로의 query.properties파일의 경로를 URL객체로 반환함.
			String fileName = SpaceDAO.class.getResource("/sql/host/host-query.properties").getPath();
			prop.load(new FileReader(fileName));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public List<String> selectByName(Connection conn, String spaceSrch) {
		List<String> nameList = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectByName");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+spaceSrch+"%");
			
			rset = pstmt.executeQuery();
			nameList = new ArrayList<>();
			
			while(rset.next()) {
				nameList.add(rset.getString("space_name"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return nameList;
	}
	public Space spaceSelectOneBySpaceNo(Connection conn, int spaceNo) {
		Space s = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("spaceSelectOneBySpaceNo");
		try {
			//1.PrepareStatement준비(미완성쿼리 완성)
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, spaceNo);
			//2.실행 및 ResultSet 리턴받기
			rset = pstmt.executeQuery();
			//3.ResultSet -> result
			if(rset.next()) {
				s = new Space();
				s.setSpaceNo(rset.getInt("space_no"));
				s.setCompanyNo(rset.getInt("company_no"));
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return s;
	}

	public int insertSpace(Connection conn, Space space) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertSpace");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, space.getCompanyNo());
			pstmt.setString(2, space.getSpaceIntro());
			pstmt.setString(3, space.getBookingTime());
			pstmt.setInt(4, space.getMaxBookingPeople());
			pstmt.setInt(5, space.getMinBookingPeople());
			pstmt.setString(6, space.getSpaceThema());
			pstmt.setString(7, space.getHashtag());
			pstmt.setString(8, space.getSpaceName());
			pstmt.setString(9, space.getSpaceFacilities());
			pstmt.setString(10, space.getSpaceSlogan());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectCompanyNo(Connection conn, String userId) {
		int companyNo = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCompanyNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				companyNo = rset.getInt("A");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return companyNo;
	}

	public int selectSpaceLastSeq(Connection conn) {
		int spaceNo = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectSpaceLastSeq");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				spaceNo = rset.getInt("A");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return spaceNo;
	}

	public int insertDayOff(Connection conn, int spaceNo, SpaceDayOff dayoff) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertDayOff");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, spaceNo);
			pstmt.setString(2, dayoff.getDayOffEvent());
			pstmt.setString(3, dayoff.getMaxSpaceDayOff());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertPrice(Connection conn, int spaceNo, SpacePrice eventPrice) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, spaceNo);
			pstmt.setString(2, eventPrice.getPriceEvent());
			pstmt.setInt(3, eventPrice.getSpacePrice());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
