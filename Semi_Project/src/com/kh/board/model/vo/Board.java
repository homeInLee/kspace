package com.kh.board.model.vo;

import java.io.Serializable;
import java.util.Date;

public class Board implements Serializable{
	private int boardNo;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
	private String originalFileName;
	private String renameFileName;
	private Date boardDate;
	private int readCount;
	private Date delDate;
	private String delType;
	
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Board(int boardNo, String boardTitle, String boardWriter, String boardContent, String originalFileName,
			String renameFilName, Date boardDate, int readCount, Date delDate, String delType) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
		this.boardContent = boardContent;
		this.originalFileName = originalFileName;
		this.renameFileName = renameFilName;
		this.boardDate = boardDate;
		this.readCount = readCount;
		this.delDate = delDate;
		this.delType = delType;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getRenameFileName() {
		return renameFileName;
	}

	public void setRenameFileName(String renameFilName) {
		this.renameFileName = renameFilName;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public Date getDelDate() {
		return delDate;
	}

	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}

	public String getDelType() {
		return delType;
	}

	public void setDelType(String delType) {
		this.delType = delType;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardWriter=" + boardWriter
				+ ", boardContent=" + boardContent + ", originalFileName=" + originalFileName + ", renameFilName="
				+ renameFileName + ", boardDate=" + boardDate + ", readCount=" + readCount + ", delDate=" + delDate
				+ ", delType=" + delType + "]";
	}
	
}
