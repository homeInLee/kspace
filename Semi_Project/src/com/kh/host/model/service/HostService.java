package com.kh.host.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.kh.admin.banner.model.vo.SpaceAll;
import com.kh.board.model.dao.BoardDAO;
import com.kh.customer.model.vo.User;
import com.kh.host.model.dao.HostDAO;
import com.kh.host.model.vo.Company;

public class HostService {

	public List<SpaceAll> selectSpaceListByHostId(String hostId) {
		Connection conn = getConnection();
		List<SpaceAll> hostSpaceList = new HostDAO().selectSpaceListByHostId(conn, hostId);
		close(conn);
		return hostSpaceList;
	}

	public List<User> selectUserList() {
		Connection conn = getConnection();
		List<User> userList = new HostDAO().selectUserList(conn);
		close(conn);
		return userList;
	}

	public int InsertUserHost(User u) {
		Connection conn = getConnection();
		int result = new HostDAO().InsertUserHost(conn, u);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int InsertCompany(Company c, String hostId) {
		Connection conn = getConnection();
		int result = new HostDAO().InsertCompany(conn, c, hostId);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
}
