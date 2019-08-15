package com.kh.customer.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.admin.banner.model.vo.SpaceAll;
import com.kh.customer.model.dao.CustomerDAO;
import com.kh.customer.model.vo.Review;
import com.kh.customer.model.vo.SpaceDibs;
import com.kh.customer.model.vo.User;
import com.kh.host.model.vo.Space;
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

	public int insertJjim(SpaceDibs jjim) {
		Connection conn = getConnection();
		int result = new CustomerDAO().insertJjim(conn, jjim);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		return result;
	}

	public SpaceDibs selectCehckJjim(SpaceDibs jjim) {
		Connection conn = getConnection();
		SpaceDibs jjimCheck = new CustomerDAO().selectCehckJjim(conn, jjim);
		close(conn);
		return jjimCheck;
	}

	public int deleteJjim(SpaceDibs jjim) {
		Connection conn = getConnection();
		int result = new CustomerDAO().deleteJjim(conn, jjim);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		return result;
	}

	public List<SpaceDibs> selectJjimList(String userId) {
		Connection conn = getConnection();
		List<SpaceDibs> jjimList = new CustomerDAO().selectJjimList(conn, userId);
		close(conn);
		return jjimList;
	}

	public SpaceAll selectSpace(int spaceNo) {
		Connection conn = getConnection();
		SpaceAll space = new CustomerDAO().selectSpace(conn, spaceNo);
		close(conn);
		return space;
	}

	public int InsertUserCustomer(User u) {
		Connection conn = getConnection();
		int result = new CustomerDAO().InsertUserCustomer(conn, u);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		return result;
	}

}
