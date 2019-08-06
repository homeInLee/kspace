package com.kh.customer.model.dao;

import java.io.Serializable;
import java.util.Date;

public class Review implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int reviewNo;
	private String reviewWriter;
	private String reviewContent;
	private int spaceNo;
	private int spacePoint;
	private Date reviewDate;
	
	public Review() {}

	public Review(int reviewNo, String reviewWriter, String reviewContent, int spaceNo, int spacePoint,
			Date reviewDate) {
		super();
		this.reviewNo = reviewNo;
		this.reviewWriter = reviewWriter;
		this.reviewContent = reviewContent;
		this.spaceNo = spaceNo;
		this.spacePoint = spacePoint;
		this.reviewDate = reviewDate;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getReviewWriter() {
		return reviewWriter;
	}

	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public int getSpaceNo() {
		return spaceNo;
	}

	public void setSpaceNo(int spaceNo) {
		this.spaceNo = spaceNo;
	}

	public int getSpacePoint() {
		return spacePoint;
	}

	public void setSpacePoint(int spacePoint) {
		this.spacePoint = spacePoint;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", reviewWriter=" + reviewWriter + ", reviewContent=" + reviewContent
				+ ", spaceNo=" + spaceNo + ", spacePoint=" + spacePoint + ", reviewDate=" + reviewDate + "]";
	}

}
