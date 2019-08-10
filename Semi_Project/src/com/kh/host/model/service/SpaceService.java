package com.kh.host.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.kh.customer.model.dao.BookingDAO;
import com.kh.host.model.dao.SpaceDAO;
import com.kh.host.model.vo.Space;
import com.kh.host.model.vo.SpaceDayOff;
import com.kh.host.model.vo.SpaceImageFile;
import com.kh.host.model.vo.SpacePrice;

import static com.kh.common.JDBCTemplate.*;

public class SpaceService {

	public List<String> selectByName(String spaceSrch) {
		Connection conn = getConnection();
		List<String> list = new SpaceDAO().selectByName(conn, spaceSrch);
		close(conn);
		return list;
	}
	public Space spaceSelectOneBySpaceNo(int spaceNo) {
		Connection conn = getConnection();
		Space s = new SpaceDAO().spaceSelectOneBySpaceNo(conn, spaceNo);
		close(conn);
		return s;
	}
	
	public int selectCompanyNo(String userId) {
		Connection conn = getConnection();
		int companyNo = new SpaceDAO().selectCompanyNo(conn, userId);
		close(conn);
		return companyNo;
	}
	
	public int insertSpace(Space space) {
		Connection conn = getConnection();
		int result = new SpaceDAO().insertSpace(conn, space);
		if(result > 0) { 
			//공간등록에 성공하면 공간 번호 가져오기
			result = new SpaceDAO().selectSpaceLastSeq(conn);
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result; //공간번호 리턴.
	}
	public int insertDayOff(int spaceNo, SpaceDayOff dayoff) {
		Connection conn = getConnection();
		int result = new SpaceDAO().insertDayOff(conn, spaceNo, dayoff);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		return result; 
	}
	public int insertPrice(SpacePrice eventPrice) {
		Connection conn = getConnection();
		int result = new SpaceDAO().insertPrice(conn, eventPrice);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		return result; 
	}
	
	public int insertSpaceImg(SpaceImageFile spaceImg) {
		Connection conn = getConnection();
		int result = new SpaceDAO().insertSpaceImg(conn, spaceImg);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		return result;
	}
	
}
