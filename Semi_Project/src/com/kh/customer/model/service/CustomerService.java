package com.kh.customer.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.admin.banner.model.vo.SpaceAll;
import com.kh.customer.model.dao.CustomerDAO;
import com.kh.customer.model.vo.Review;
import com.kh.host.model.vo.SpaceJoin;

public class CustomerService {

	public List<SpaceAll> selectSpaceAll(int spaceNo) {
		Connection conn = getConnection();
		List<SpaceAll> spaceList = new CustomerDAO().selectSpaceAll(conn, spaceNo);
		close(conn);
		return spaceList;
	}
	
	public List<SpaceJoin> selectSpaceList() {
		Connection conn = getConnection();
		List<SpaceJoin> list = new CustomerDAO().selectSpaceList(conn);
		close(conn);
		return list;
	}
	
	public List<Review> selectPointList() {
		Connection conn = getConnection();
		List<Review> list = new CustomerDAO().selectPointList(conn);
		close(conn);
		return list;
	}

}
