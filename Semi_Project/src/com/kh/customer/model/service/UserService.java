package com.kh.customer.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.kh.customer.model.dao.UserDAO;
import com.kh.customer.model.vo.User;

public class UserService {
	public static final int LOGIN_OK = 1;
	public static final int WRONG_PASSWORD = 0;
	public static final int ID_NOT_EXIST = -1;

	public User UserSelectOneById(String userId) {
		Connection conn = getConnection();
		User u = new UserDAO().UserSelectOneById(conn, userId);
		close(conn);
		return u;
	}


	public int loginCheck(User user) {
		Connection conn = getConnection();
		int result = new UserDAO().loginCheck(conn, user);
		close(conn);
		return result;
	}


	public User selectOne(String memberId) {
		Connection conn = getConnection();
		User u = new UserDAO().selectOne(conn, memberId);
		close(conn);
		return u;
	}

}
