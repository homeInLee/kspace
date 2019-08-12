package com.kh.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.vo.Board;
import com.kh.board.service.BoardService;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/board/adminNote")
public class BoardAdminListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardAdminListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 핸들링
		final int numPerPage = 5;
		int cPage = 1;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		}catch (NumberFormatException e) {
			// TODO: handle exception
		}
		
		//업무로직
		List<Board> list = new BoardService().selectBoardList(cPage, numPerPage);
//		System.out.println("servlet"+list);
		
		int totalContents = new BoardService().selectTotalContents();
		int totalPage = (int)Math.ceil((double)totalContents/numPerPage);
		
		String pageBar ="";
		final int pageBarSize = 5;
		int pageEnd = (int)Math.ceil((double)totalContents/numPerPage)*5;
		int pageStart = (pageEnd-pageBarSize)+1;
		int pageNo = pageStart;
		if(pageNo == 1) {
			pageBar += "<span>[이전]</span>";
		}else {
			pageBar += "<a href='"+request.getContextPath()+"/admin/adminNote?cpage="
					+(pageNo-1)+"'>[이전]</a>";
		}
		
		while(pageNo<= pageEnd && pageNo<=totalPage) {
			if(pageNo == cPage) {
				pageBar += "<span class='cPage'>"+pageNo+"</span>";
			}else {
				pageBar += "<a href='"+request.getContextPath()+"/admin/adminNote?cPage="
						+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		
		request.setAttribute("list", list);
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("cPage", cPage);
		request.setAttribute("numPerPage", numPerPage);
		request.getRequestDispatcher("/WEB-INF/views/board/adminNote.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
