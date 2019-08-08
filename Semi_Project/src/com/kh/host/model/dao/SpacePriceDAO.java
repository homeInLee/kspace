package com.kh.host.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.customer.model.dao.BookingDAO;
import com.kh.host.model.vo.SpacePrice;

public class SpacePriceDAO {
	private Properties prop = new Properties();
	public SpacePriceDAO() {
		String fileName = SpacePriceDAO.class.getResource("/sql/host/host-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
			System.out.println("[[prop loading 완료:"+fileName+"]]");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<SpacePrice> pirceList(Connection conn, int spaceNo) {
		List<SpacePrice> pricelist = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("pirceList");
		try {
			//1.PrepareStatement준비(미완성쿼리 완성)
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, spaceNo);
			//2.실행 및 ResultSet 리턴받기
			rset = pstmt.executeQuery();
			//3.ResultSet -> result
			while(rset.next()) {
				SpacePrice s = new SpacePrice();
				s.setSpaceNo(rset.getInt("space_no"));
				s.setPriceEvent(rset.getString("price_event"));
				s.setSpacePrice(rset.getInt("space_price"));
				pricelist.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return pricelist;
	}
}
