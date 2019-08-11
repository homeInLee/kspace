package com.kh.admin.banner.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

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

}
