package com.kh.admin.banner.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.admin.banner.model.dao.BannerDAO;
import com.kh.admin.banner.model.vo.Banner;

public class BannerService {

	public int insertBanner(Banner b) {
		Connection conn = getConnection();
		int result = new BannerDAO().insertBanner(conn, b);
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public List<Banner> selectAllBanner() {
		Connection conn = getConnection();
		List<Banner> list = new BannerDAO().selectAllBanner(conn);
		close(conn);
		return list;
	}

	public int deleteBanner(int bannerNo) {
		Connection conn = getConnection();
		int result = new BannerDAO().deleteBanner(conn, bannerNo);
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int updateBanner(Banner b) {
		Connection conn = getConnection();
		int result = new BannerDAO().updateBanner(conn, b);
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

}
