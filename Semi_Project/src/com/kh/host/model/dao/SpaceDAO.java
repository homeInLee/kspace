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
	public Space spaceSelectOne(Connection conn, int spaceNo) {
		Space s = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("spaceSelectOne");
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

}
