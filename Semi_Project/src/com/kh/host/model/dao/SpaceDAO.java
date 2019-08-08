package com.kh.host.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SpaceDAO {
	
	private Properties prop = new Properties();
	
	public SpaceDAO() {
		try {
			//클래스객체 위치찾기 : 절대경로를 반환한다. 
			// "/" : 루트디렉토리를 절대경로로 URL객체로 반환한다.
			// "./" : 현재디렉토리를 절대경로로 URL객체로 반환한다.
			// "./query.properties : 현재경로의 query.properties파일의 경로를 URL객체로 반환함.
			String fileName = SpaceDAO.class.getResource("/sql/host/host-query.properties").getPath();
			prop.load(new FileReader(fileName));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public List<String> selectByName(Connection conn, String spaceSrch) {
		List<String> nameList = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectByName");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+spaceSrch+"%");
			
			rset = pstmt.executeQuery();
			nameList = new ArrayList<>();
			
			while(rset.next()) {
				nameList.add(rset.getString("space_name"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return nameList;
	}

}
