package com.kh.host.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.kh.host.model.dao.SpaceDAO;
import com.kh.host.model.vo.Company;
import com.kh.host.model.vo.Space;
import com.kh.host.model.vo.SpaceDayOff;
import com.kh.host.model.vo.SpaceImageFile;
import com.kh.host.model.vo.SpacePrice;

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
	public List<SpaceImageFile> selectSpaceImgBySpaceNo(int spaceNo) {
		Connection conn = getConnection();
		List<SpaceImageFile> spaceImg = new SpaceDAO().selectSpaceImgBySpaceNo(conn, spaceNo);
		close(conn);
		return spaceImg;
	}
	public List<SpacePrice> selectSpacePriceBySpaceNo(int spaceNo) {
		Connection conn = getConnection();
		List<SpacePrice> spacePrice = new SpaceDAO().selectSpacePriceBySpaceNo(conn, spaceNo);
		close(conn);
		return spacePrice;
	}
	
	public List<SpaceDayOff> selectSpaceDayOffBySpaceNo(int spaceNo) {
		Connection conn = getConnection();
		List<SpaceDayOff> sDayOff = new SpaceDAO().selectSpaceDayOffBySpaceNo(conn, spaceNo);
		close(conn);
		return sDayOff;
	}
	
	public int deleteSpace(int delSpaceNo) {
		Connection conn = getConnection();
		int result = new SpaceDAO().deleteSpace(conn, delSpaceNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	
	public int updateDayOff(int spaceNo, SpaceDayOff dayoff) {
		Connection conn = getConnection();
		int result = new SpaceDAO().updateDayOff(conn, spaceNo, dayoff);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	public int updateSpace(int spaceNo, Space space) {
		Connection conn = getConnection();
		int result = new SpaceDAO().updateSpace(conn, spaceNo, space);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	public int selectSpaceImg(int spaceNo) {
		Connection conn = getConnection();
		int result = new SpaceDAO().selectSpaceImg(conn, spaceNo);
		close(conn);
		return result;
	}
	
	public int deleteSpaceImg(int spaceNo) {
		Connection conn = getConnection();
		int result = new SpaceDAO().deleteSpaceImg(conn, spaceNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	
	public int selectSpacePrice(int spaceNo) {
		Connection conn = getConnection();
		int result = new SpaceDAO().selectSpacePrice(conn, spaceNo);
		close(conn);
		return result;
	}
	
	public int deleteSpacePrice(int spaceNo) {
		Connection conn = getConnection();
		int result = new SpaceDAO().deleteSpacePrice(conn, spaceNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	
	public Company selectCompanyByCompanyNo(int companyNo) {
		Connection conn = getConnection();
		Company company = new SpaceDAO().selectCompanyByCompanyNo(conn, companyNo);
		close(conn);
		return company;
	}
	public SpaceImageFile selectSpaceImgBySpaceNoSelY(int spaceNo) {
		Connection conn = getConnection();
		SpaceImageFile spaceImg = new SpaceDAO().selectSpaceImgBySpaceNoSelY(conn, spaceNo);
		close(conn);
		return spaceImg;
	}
	public List<Space> spaceListbyCompanyNo(int companyNo) {
		Connection conn = getConnection();
		List<Space> slist = new SpaceDAO().spaceListbyCompanyNo(conn, companyNo);
		close(conn);
		return slist;
	}
	
}
