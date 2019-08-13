package com.kh.board.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.board.model.dao.BoardDAO;
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

	public int deleteBoard(int boardNo) {
		Connection conn = getConnection();
		int result = new BoardDAO().deleteBoard(conn, boardNo);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Board selectBoard(int boardNo) {
		Connection conn = getConnection();
		Board b = new BoardDAO().selectBoard(conn, boardNo);
		close(conn);
		return b;
	}

	public Board selectBoardNo(int boardNo) {
		Connection conn = getConnection();
		Board b = new BoardDAO().selectBoardNo(conn, boardNo);
		close(conn);
		return b;
	}

	public int updateBoard(Board b) {
		Connection conn = getConnection();
		int result = new BoardDAO().updateBoard(conn, b);
		if(result>0){
			commit(conn);
		}
		else 
			rollback(conn);
		
		close(conn);
		
		return result;
	}

}
