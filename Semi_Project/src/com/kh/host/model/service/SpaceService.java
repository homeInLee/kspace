package com.kh.host.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.host.model.dao.SpaceDAO;

import static com.kh.common.JDBCTemplate.*;

public class SpaceService {

	public List<String> selectByName(String spaceSrch) {
		Connection conn = getConnection();
		List<String> list = new SpaceDAO().selectByName(conn, spaceSrch);
		close(conn);
		return list;
	}

}
