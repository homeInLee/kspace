package com.kh.admin.banner.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.admin.banner.model.service.BannerService;
import com.kh.admin.banner.model.vo.Banner;
import com.kh.admin.banner.util.BannerRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

/**
 * Servlet implementation class bannerUpdateServlet
 */
@WebServlet("/banner/bannerInsert")
public class bannerInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bannerInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "파일등록오류!");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root + "upload" + File.separator + "banner";
		System.out.println("saveDirectory=" + saveDirectory);
		
		int maxPostSize = 1024 * 1024 * 10;
		
		String encoding = "UTF-8";
		
		FileRenamePolicy bannerRenamePolicy = new BannerRenamePolicy();
		MultipartRequest mReq = new MultipartRequest(request, saveDirectory, maxPostSize, encoding, bannerRenamePolicy);
		
		String content = mReq.getParameter("content");
		String renamedFileName = mReq.getFilesystemName("upFile");
		String originalFileName = mReq.getOriginalFileName("upFile");
		
		Banner b = new Banner();
		b.setBannerContent(content);
		b.setBannerOriginalFileName(originalFileName);
		b.setBannerRenamedFileName(renamedFileName);
		
		int result = new BannerService().insertBanner(b);
		
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		//javascript/html에서 사용할 url은 contextPath를 포함한다.
		String loc = "/";

		if(result>0)
			msg = "배너 등록 성공!";
		else 
			msg = "배너 등록 실패!";	
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher(view);
		reqDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
