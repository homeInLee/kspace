package com.kh.customer.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.kh.customer.model.dao.UserDAO;
import com.kh.customer.model.vo.User;

public class UserService {

	public User UserSelectOneById(String userId) {
		Connection conn = getConnection();
		User u = new UserDAO().UserSelectOneById(conn, userId);
		close(conn);
		return u;
	}

}
