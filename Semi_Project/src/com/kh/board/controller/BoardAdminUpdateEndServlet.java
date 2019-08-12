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
 * Servlet implementation class BoardAdminUpdateEndServlet
 */
@WebServlet("/admin/adminNoteUpdateEnd")
public class BoardAdminUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardAdminUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/******* 파일업로드 로직 시작 ********/
		//enctype="multipart/form-data" 로 전송되었는지 확인. 
		//아래 두패키지에서 제공함.
		//org.apache.commons.fileupload.servlet.ServletFileUpload
		//org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "게시판작성오류![form:enctype 관리자에게 문의하세요.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
				   .forward(request, response);
			return;
		}
		
		
		//a.현재 웹 컨테이너에서 구동중인 웹 어플리케이션의 루트 절대경로 알아내기
		//ServletContext javax.servlet.GenericServlet.getServletContext()
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root + "upload"+File.separator+"board";
		System.out.println("saveDirectory => "+saveDirectory);
		
		//b.파일최대용량 : 업로드할 파일 10MB까지 제한.
		//1KB*1KB*10
		int maxPostSize = 1024 * 1024 * 10;
		
		//c.FileRenamePolicy객체 생성
		FileRenamePolicy policy
			= new MvcRenamePolicy();

		//d. MultipartRequest 객체 생성함 : 자동 파일 업로드됨
		//업로드 파일최대크기를 초과하면 IOException이 발생된다. 반드시 Exception처리해야 한다.(try~catch)
		/* 
		 com.oreilly.servlet.MultipartRequest.MultipartRequest(HttpServletRequest request, 
															   String saveDirectory, 
															   int maxPostSize, 
															   String encoding, 
															   FileRenamePolicy 중복파일네이밍정책객체) throws IOException
															
		 */
		MultipartRequest mrequest = new MultipartRequest(request, saveDirectory, maxPostSize,"UTF-8",policy);
		/******* 파일업로드 로직 끝 ********/
		
		//1.파라미터값 가져오기
		//이제 request가 아닌 MultipartRequest객체에서 폼파라미터를 가져와야함.
		int boardNo = Integer.parseInt(mrequest.getParameter("boardNo"));
		String boardTitle = mrequest.getParameter("title");
		String boardWriter = mrequest.getParameter("writer");
		String boardContent = mrequest.getParameter("content");
		
		//업로드한 첨부파일명을 얻을 때는 cos.jar라이브러리에서 제공하는 .getfilesystemName("name")을 이용하자.
		String renamedFileName = mrequest.getFilesystemName("file");// 현재 시스템에 저장된 파일명(renamed)을 리턴함. (경로제외)
		String originalFileName = mrequest.getOriginalFileName("file");//rename policy가 적용되기 전 파일명을 리턴함.
		 
		//기존첨부파일에 대한 정보
		String oldOName = mrequest.getParameter("oldOName");
		String oldRName = mrequest.getParameter("oldRName");
		
		//기존에 첨부한 파일이 있다면, 후처리작업
		if(!"".equals(oldOName)) {
			System.out.println("******* 기존 첨부파일이 있는 경우, 후처리 ********");
			
			
			//업로드된 파일에 대한 객체생성
			File f = mrequest.getFile("file");
			
			//1.전송된 파일이 있는 경우
			if(f!=null && f.length()>0) {
				//기존파일이 있다면, 삭제
				File delFile 
					= new File(saveDirectory+"/"+mrequest.getParameter("oldRName"));
				boolean bool = delFile.delete();
				System.out.println(bool?"파일 삭제 성공":"파일 삭제 실패");
				
			}
			//2.기존첨부파일을 삭제하려는 경우
			else if(mrequest.getParameter("delFile") != null){
				//기존파일이 삭제
				//기존파일이 있다면, 삭제
				File delFile 
					= new File(saveDirectory+"/"+mrequest.getParameter("oldRName"));
				boolean bool = delFile.delete();
				System.out.println(bool?"파일 삭제 성공":"파일 삭제 실패");
				
			}
			//3.첨부한 파일이 없는 경우
			else {
				//기존파일명을 다시 대입
				originalFileName = oldOName;
				renamedFileName = oldRName;
			}
		}
		
		//Board객체생성
		Board b = new Board();
		b.setBoardNo(boardNo);
		b.setBoardTitle(boardTitle);
		b.setBoardWriter(boardWriter);
		b.setBoardContent(boardContent);
		b.setOriginalFileName(originalFileName);
		b.setRenameFileName(renamedFileName);
		
		//2. 비지니스로직 호출
		int result = new BoardService().updateBoard(b);
		
		//3. 처리결과에 따른 view단에 처리위임.
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		//javascript/html에서 사용할 url은 contextPath를 포함한다.
		String loc = "board/adminNote";

		if(result>0){
			msg = "게시판 등록 성공!";
			loc = "/board/adminNote?boardNo="+boardNo;
		}
		else {
			msg = "게시판 등록 실패!";				
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
