package com.kh.search.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.host.model.vo.SpaceJoin;
import com.kh.search.model.dao.SearchDAO;

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

	public List<SpaceJoin> selectSpacelist(String spaceSrch) {
		Connection conn = getConnection();
		List<SpaceJoin> list = new SearchDAO().selectSpacelist(conn, spaceSrch);
		close(conn);
		return list;
	}

	public List<String> selectByPlace(String spaceSrch) {
		Connection conn = getConnection();
		List<String> list = new SearchDAO().selectByPlace(conn, spaceSrch);
		close(conn);
		return list;
	}

	public List<SpaceJoin> selectFilterList(int srchPrice1, int srchPrice2, String[] facility, List<SpaceJoin> spaceList) {
		Connection conn = getConnection();
		List<SpaceJoin> list = new SearchDAO().selectFilterList(conn, srchPrice1, srchPrice2, facility, spaceList);
		close(conn);
		return list;
	}

}
