package com.kh.customer.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.kh.board.model.dao.BoardDAO;
import com.kh.customer.model.dao.ReviewDAO;
import com.kh.customer.model.vo.Review;



public class ReviewService {

	public int insertReview(Review review) {
		Connection conn = getConnection();
		int result = new ReviewDAO().insertBoardComment(conn, review);
		//트랜잭션
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public List<Review> selectReviewList(int spaceNo, int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Review> list = new ReviewDAO().selectReviewList(conn, spaceNo, cPage, numPerPage);
		close(conn);
		return list;
	}

	public int selectTotalContents() {
		Connection conn = getConnection();
		int result = new ReviewDAO().selectTotalContents(conn);
		close(conn);
		return result;
	}

	

}
