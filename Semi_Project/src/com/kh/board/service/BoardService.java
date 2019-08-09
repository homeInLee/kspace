package com.kh.board.service;

import java.sql.Connection;
import java.util.List;

import com.kh.board.dao.BoardDAO;
import com.kh.board.model.vo.Board;
import static com.kh.common.JDBCTemplate.*;

public class BoardService {

	public List<Board> selectBoardList(int cPage, int numPerPage) {
		Connection conn = getConnection(); 
		List<Board> list = new BoardDAO().selectBoardList(conn, cPage, numPerPage);
		close(conn);
		return list;
	}

	public int selectTotalContents() {
		Connection conn = getConnection();
		int result = new BoardDAO().selectTotalContents(conn);
		close(conn);
				
		return result;
	}

	public int insertBoard(Board b) {
		Connection conn = getConnection();
		int result = new BoardDAO().insertBoard(conn, b);
		if(result > 0) {
			result = new BoardDAO().selectLastSeq(conn);
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

}
