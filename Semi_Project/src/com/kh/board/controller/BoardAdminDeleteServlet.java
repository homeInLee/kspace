package com.kh.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.vo.Board;
import com.kh.board.service.BoardService;

/**
 * Servlet implementation class BoardAdminDeleteServlet
 */
@WebServlet("/admin/adminNoteDel")
public class BoardAdminDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardAdminDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String renamedFileName = request.getParameter("renamedFileName");
		
		int result = new BoardService().deleteBoard(boardNo);
		System.out.println(boardNo+"boardNO");
		if(result>0 && !"".equals(renamedFileName)) {
			//파일삭제
			String saveDirectory = getServletContext().getRealPath("/upload/board");
			File delFile = new File(saveDirectory+File.separator+renamedFileName);
			
			//삭제폴더이동
			String delDirectory = getServletContext().getRealPath("deleteFile/board");
			File renameFile = new File(delDirectory+File.separator+renamedFileName);
			
			System.out.println("파일삭제"+delFile);
			System.out.println("삭제폴더이동"+renameFile);
			
		}
		String view= "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "/board/adminNote";
		if(result > 0) {
			msg = "게시물이 삭제 되었습니다.";
		}else {
			msg = "실패 했습니다.";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
