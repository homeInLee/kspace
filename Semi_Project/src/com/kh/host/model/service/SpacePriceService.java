package com.kh.host.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.host.model.dao.SpacePriceDAO;
import com.kh.host.model.vo.SpacePrice;

public class SpacePriceService {
	public List<SpacePrice> pirceList(int spaceNo) {
		Connection conn = getConnection();
		List<SpacePrice> pricelist = new SpacePriceDAO().pirceList(conn, spaceNo);
		close(conn);
		return pricelist;
	}
}
