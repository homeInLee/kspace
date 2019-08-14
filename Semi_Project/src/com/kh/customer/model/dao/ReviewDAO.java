package com.kh.customer.model.dao;

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

import com.kh.board.model.dao.BoardDAO;
import com.kh.customer.model.vo.Review;
import com.sun.xml.internal.ws.Closeable;
import static com.kh.common.JDBCTemplate.*;

public class ReviewDAO {
	
	private Properties prop;
	
	public ReviewDAO(){
		prop = new Properties();
		String FilName = BoardDAO.class.getResource("/sql/customer/customer-query.properties").getPath();
		try {
			prop.load(new FileReader(FilName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertBoardComment(Connection conn, Review review) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review.getReviewWriter());
			pstmt.setString(2, review.getReviewContent());
			pstmt.setInt(3, review.getSpaceNo());
			pstmt.setInt(4, review.getSpacePoint());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public List<Review> selectReviewList(Connection conn, int spaceNo, int cPage, int numPerPage) {
		List<Review> list = new ArrayList<Review>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReviewList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, spaceNo);
			int start = (cPage-1)*numPerPage+1;
			int end = cPage * numPerPage;
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Review r = new Review();
				r.setReviewNo(rset.getInt("review_no"));
				r.setReviewWriter(rset.getString("review_writer"));
				r.setReviewContent(rset.getNString("review_content"));
				r.setSpaceNo(rset.getInt("space_no"));
				r.setSpacePoint(rset.getInt("space_point"));
				r.setReviewDate(rset.getDate("review_date"));
				list.add(r);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
	
		return list;
	}

	public int selectTotalContents(Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectTotalContents");
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("totalContents");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
//		System.out.println("contents@admin="+result);
		
		return result;
	}

}
