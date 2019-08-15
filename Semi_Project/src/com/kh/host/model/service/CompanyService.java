package com.kh.host.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.kh.customer.model.dao.BookingDAO;
import com.kh.customer.model.vo.Booking;
import com.kh.host.model.dao.CompanyDAO;
import com.kh.host.model.vo.Company;

public class CompanyService {

	public Company CompanySelectOneByCompanyNo(int companyNo) {
		Connection conn = getConnection();
		Company c = new CompanyDAO().CompanySelectOneByCompanyNo(conn, companyNo);
		close(conn);
		return c;
	}

	public Company selectCompanyByUserId(String userId) {
		Connection conn = getConnection();
		Company c = new CompanyDAO().selectCompanyByUserId(conn, userId);
		close(conn);
		return c;
	}

}
