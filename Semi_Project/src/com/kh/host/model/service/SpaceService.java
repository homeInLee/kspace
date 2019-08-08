package com.kh.host.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.customer.model.dao.BookingDAO;
import com.kh.host.model.dao.SpaceDAO;
import com.kh.host.model.vo.Space;

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
}
