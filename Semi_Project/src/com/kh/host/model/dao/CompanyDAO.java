package com.kh.host.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.customer.model.dao.BookingDAO;
import com.kh.customer.model.vo.Booking;
import com.kh.host.model.vo.Company;

public class CompanyDAO {

	private Properties prop = new Properties();
	
	public CompanyDAO() {
		String fileName = BookingDAO.class.getResource("/sql/host/host-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
			System.out.println("[[prop loading 완료:"+fileName+"]]");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Company CompanySelectOneByCompanyNo(Connection conn, int companyNo) {
		Company c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("CompanySelectOneByCompanyNo");
		try {
			//1.PrepareStatement준비(미완성쿼리 완성)
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, companyNo);
			//2.실행 및 ResultSet 리턴받기
			rset = pstmt.executeQuery();
			//3.ResultSet -> result
			if(rset.next()) {
				c = new Company();
				c.setCompanyNo(rset.getInt("company_no"));
				c.setCompanyName(rset.getString("company_name"));
				c.setCompanyPlace(rset.getString("company_place"));
				c.setCompanyPointGa(rset.getInt("company_point_ga"));
				c.setCompanyPointHa(rset.getInt("company_point_ha"));
				c.setUserId(rset.getString("user_id"));
				c.setDelType(rset.getString("del_type"));
				c.setDelDate(rset.getDate("del_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return c;
	}
	public Company selectCompanyByUserId(Connection conn, String userId) {
		Company c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCompanyByUserId");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				c = new Company();
				c.setCompanyNo(rset.getInt("company_no"));
				c.setCompanyName(rset.getString("company_name"));
				c.setCompanyPlace(rset.getString("company_place"));
				c.setCompanyPointGa(rset.getInt("company_point_ga"));
				c.setCompanyPointHa(rset.getInt("company_point_ha"));
				c.setUserId(rset.getString("user_id"));
				c.setDelType(rset.getString("del_type"));
				c.setDelDate(rset.getDate("del_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return c;
	}

}
