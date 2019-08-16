package com.kh.customer.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.customer.model.vo.Booking;
import com.kh.customer.model.vo.User;

public class UserDAO {
	
	private Properties prop = new Properties();
	
	public UserDAO() {
		String fileName = BookingDAO.class.getResource("/sql/customer/customer-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
			System.out.println("[[prop loading 완료:"+fileName+"]]");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public User UserSelectOneById(Connection conn, String userId) {
		User u = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("UserSelectOneById");
		try {
			//1.PrepareStatement준비(미완성쿼리 완성)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			//2.실행 및 ResultSet 리턴받기
			rset = pstmt.executeQuery();
			//3.ResultSet -> result
			if(rset.next()) {
				u = new User();
				u.setUserId(rset.getString("user_id"));
				u.setUserName(rset.getString("user_name"));
				u.setPassword(rset.getString("password"));
				u.setPhone(rset.getString("phone"));
				u.setEmail(rset.getString("email"));
				u.setEnrolldate(rset.getDate("enrolldate"));
				u.setDelDate(rset.getDate("deldate"));
				u.setDelType(rset.getString("deltype"));
				u.setFlag(rset.getString("flag"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return u;
	}
	public int loginCheck(Connection conn, User user) {
		int result = -1;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("loginCheck");
		try {
			//1.PrepareStatement준비(미완성쿼리 완성)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getUserId());
			//2.실행 및 ResultSet 리턴받기
			rset = pstmt.executeQuery();
			//3.ResultSet -> result
			if(rset.next()) {
				result = rset.getInt("login_check");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
	public User selectOne(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		User u = null;
		String sql = prop.getProperty("selectOne");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				u = new User();
				u.setUserId(rset.getString("user_id"));
				u.setUserName(rset.getString("user_name"));
				u.setPassword(rset.getString("password"));
				u.setPhone(rset.getString("phone"));
				u.setEmail(rset.getString("email"));
				u.setEnrolldate(rset.getDate("enrolldate"));
				u.setDelDate(rset.getDate("deldate"));
				u.setDelType(rset.getString("deltype"));
				u.setFlag(rset.getString("flag"));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return u;
	}

}
