package com.kh.admin.banner.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.admin.banner.model.dao.AdminDAO;
import com.kh.admin.banner.model.vo.SpaceAll;

public class AdminService {

	public List<SpaceAll> selectNoChkSpace() {
		Connection conn = getConnection();
		List<SpaceAll> noChkSpaceList = new AdminDAO().selectNoChkSpace(conn);
		close(conn);
		return noChkSpaceList;
	}

	public int spaceChkOK(int spaceNo, String spaceChk) {
		Connection conn = getConnection();
		int result = new AdminDAO().spaceChkOK(conn, spaceNo, spaceChk);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
}
