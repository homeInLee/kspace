package com.kh.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.BoardExcaption;
import com.kh.board.model.vo.Board;
import com.kh.board.service.BoardService;

/**
 * Servlet implementation class AdminBoardUpdateServlet
 */
@WebServlet("/admin/adminNoteUpdate")
public class BoardAdminUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardAdminUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.파라미터 핸들링
				int boardNo;
				try {
				boardNo = Integer.parseInt(request.getParameter("boardNo"));
				}catch(NumberFormatException e) {
					throw new BoardExcaption("유효하지 않아");
				}
				//2.업무로직
				Board b = new BoardService().selectBoardNo(boardNo);
				
				//3.view단처리
				request.setAttribute("board", b);
				System.out.println(b);
				request.getRequestDispatcher("/WEB-INF/views/board/adminNoteUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
