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
import com.kh.host.model.vo.SpaceImageFile;
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

	public int insertPrice(Connection conn, SpacePrice eventPrice) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eventPrice.getSpaceNo());
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

	public int insertSpaceImg(Connection conn, SpaceImageFile spaceImg) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertSpaceImg");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, spaceImg.getSpaceNo());
			pstmt.setString(2, spaceImg.getImageOriginalFileName());
			pstmt.setString(3, spaceImg.getImageRenamedFileName());
			if(spaceImg.getFlag()!=null) {
				pstmt.setString(4, spaceImg.getFlag());
			} else {
				pstmt.setString(4, "Y");
			}
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public List<SpaceImageFile> selectSpaceImgBySpaceNo(Connection conn, int spaceNo) {
		List<SpaceImageFile> spaceImg = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectSpaceImgBySpaceNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, spaceNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				SpaceImageFile s = new SpaceImageFile();
				s.setSpaceNo(rset.getInt("space_no"));
				s.setImageOriginalFileName(rset.getString("image_original_filename"));
				s.setImageRenamedFileName(rset.getString("image_renamed_filename"));
				s.setFlag(rset.getString("flag"));
				spaceImg.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return spaceImg;
	}

	public List<SpacePrice> selectSpacePriceBySpaceNo(Connection conn, int spaceNo) {
		List<SpacePrice> spacePrice = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectSpacePriceBySpaceNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, spaceNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				SpacePrice s = new SpacePrice();
				s.setSpaceNo(rset.getInt("space_no"));
				s.setPriceEvent(rset.getString("price_event"));
				s.setSpacePrice(rset.getInt("space_price"));
				spacePrice.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return spacePrice;
	}

	public List<SpaceDayOff> selectSpaceDayOffBySpaceNo(Connection conn, int spaceNo) {
		List<SpaceDayOff> sDayOff = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectSpaceDayOffBySpaceNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, spaceNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				SpaceDayOff s = new SpaceDayOff();
				s.setSpaceNo(rset.getInt("space_no"));
				s.setDayOffEvent(rset.getString("dayoff_event"));
				s.setMaxSpaceDayOff(rset.getString("max_space_dayoff"));
				sDayOff.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return sDayOff;
	}

	public int deleteSpace(Connection conn, int delSpaceNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteSpace");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, delSpaceNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateDayOff(Connection conn, int spaceNo, SpaceDayOff dayoff) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateDayOff");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dayoff.getDayOffEvent());
			pstmt.setString(2, dayoff.getMaxSpaceDayOff());
			pstmt.setInt(3, spaceNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateSpace(Connection conn, int spaceNo, Space space) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateSpace");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, space.getSpaceIntro());
			pstmt.setString(2, space.getBookingTime());
			pstmt.setInt(3, space.getMaxBookingPeople());
			pstmt.setInt(4, space.getMinBookingPeople());
			pstmt.setString(5, space.getSpaceThema());
			pstmt.setString(6, "N");
			pstmt.setString(7, space.getHashtag());
			pstmt.setString(8, space.getSpaceName());
			pstmt.setString(9, space.getSpaceFacilities());
			pstmt.setString(10, space.getSpaceSlogan());
			pstmt.setInt(11, spaceNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectSpaceImg(Connection conn, int spaceNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectSpaceImg");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, spaceNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int deleteSpaceImg(Connection conn, int spaceNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteSpaceImg");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, spaceNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectSpacePrice(Connection conn, int spaceNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectSpacePrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, spaceNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int deleteSpacePrice(Connection conn, int spaceNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteSpacePrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, spaceNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
