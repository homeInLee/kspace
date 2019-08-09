package com.kh.search.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.host.model.vo.Space;
import com.kh.search.model.dao.SearchDAO;

import static com.kh.common.JDBCTemplate.*;

public class SearchService {

	public List<String> selectByName(String spaceSrch) {
		Connection conn = getConnection();
		List<String> list = new SearchDAO().selectByName(conn, spaceSrch);
		close(conn);
		return list;
	}

	public List<String> selectByHash(String spaceSrch) {
		Connection conn = getConnection();
		List<String> list = new SearchDAO().selectByHash(conn, spaceSrch);
		close(conn);
		return list;
	}

	public List<Space> selectSpacelist(String spaceSrch) {
		Connection conn = getConnection();
		List<Space> list = new SearchDAO().selectSpacelist(conn, spaceSrch);
		close(conn);
		return list;
	}

}
