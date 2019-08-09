package com.kh.board.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.board.model.vo.Board;
import com.kh.board.service.BoardService;
import com.kh.common.util.MvcRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

/**
 * Servlet implementation class BoardAdminUploadServlet
 */
@WebServlet("/board/adminNoteFormEnd")
public class BoardAdminUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardAdminUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//업로드체크
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "등록 오류");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			return;
		}
		//업로드시작
		String root = getServletContext().getRealPath("/");
		String save = root+"upload"+File.separator+"board";
		System.out.println("save"+save);
		
		int postSize = 1024*1024*10;
		String encoding= "utf-8";
		FileRenamePolicy renamePolicy = new MvcRenamePolicy();
		MultipartRequest mreq = new MultipartRequest(request, save, postSize, encoding, renamePolicy);
		
		//파마리터
		String title = mreq.getParameter("boardTitle");
		String writer = mreq.getParameter("boardWriter");
		String renamefileName = mreq.getFilesystemName("upFile");//폼테그에 작성한 이름을 적어야 한ㄷ,.
		String originalFileName = mreq.getOriginalFileName("upFile");
		String boardContent = mreq.getParameter("boardContent");
		boardContent = boardContent.replaceAll("<", "$lt;");
		boardContent = boardContent.replaceAll(">", "$gt;");
		
		Board b = new Board();
		b.setBoardTitle(title);
		b.setBoardWriter(writer);
		b.setBoardContent(boardContent);
		b.setOriginalFileName(originalFileName);
		b.setRenameFilName(renamefileName);
		System.out.println("boardForm="+b);
		
		//업무로직
		int result = new BoardService().insertBoard(b);
		
		String msg = "";
		String loc = "/board/adminNote";
		if(result>0) {
			msg = "게시글 등록성공!";
			loc= "/board/adminNote?boardNo="+result;
			
		}
		else {
			msg = "게시글 등록실패!";
		}

		//3.view단 처리
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
