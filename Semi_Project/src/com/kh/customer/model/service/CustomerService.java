package com.kh.customer.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.admin.banner.model.vo.SpaceAll;
import com.kh.customer.model.dao.CustomerDAO;

import static com.kh.common.JDBCTemplate.*;

public class CustomerService {

	public List<SpaceAll> selectSpaceAll(int spaceNo) {
		Connection conn = getConnection();
		List<SpaceAll> spaceList = new CustomerDAO().selectSpaceAll(conn, spaceNo);
		close(conn);
		return spaceList;
	}

}
