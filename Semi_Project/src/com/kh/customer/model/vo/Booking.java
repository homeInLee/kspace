package com.kh.customer.model.vo;

import java.util.Date;

public class Booking {
	private int bookingNo; //예약번호
	private Date maxTime; //max예약시간
	private Date minTime; //min예약시간
	private int spaceNo; //공간번호
	private int bookingPeople; //예약인원
	private String userId; //고객아이디
	private String request; //요구사항
	private String delType; //환불여부
	private Date delDate; //환불일
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(int bookingNo, Date maxTime, Date minTime, int spaceNo, int bookingPeople, String userId,
			String request, String delType, Date delDate) {
		super();
		this.bookingNo = bookingNo;
		this.maxTime = maxTime;
		this.minTime = minTime;
		this.spaceNo = spaceNo;
		this.bookingPeople = bookingPeople;
		this.userId = userId;
		this.request = request;
		this.delType = delType;
		this.delDate = delDate;
	}
	public int getBookingNo() {
		return bookingNo;
	}
	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}
	public Date getMaxTime() {
		return maxTime;
	}
	public void setMaxTime(Date maxTime) {
		this.maxTime = maxTime;
	}
	public Date getMinTime() {
		return minTime;
	}
	public void setMinTime(Date minTime) {
		this.minTime = minTime;
	}
	public int getSpaceNo() {
		return spaceNo;
	}
	public void setSpaceNo(int spaceNo) {
		this.spaceNo = spaceNo;
	}
	public int getBookingPeople() {
		return bookingPeople;
	}
	public void setBookingPeople(int bookingPeople) {
		this.bookingPeople = bookingPeople;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getDelType() {
		return delType;
	}
	public void setDelType(String delType) {
		this.delType = delType;
	}
	public Date getDelDate() {
		return delDate;
	}
	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}
	@Override
	public String toString() {
		return "Booking [bookingNo=" + bookingNo + ", maxTime=" + maxTime + ", minTime=" + minTime + ", spaceNo="
				+ spaceNo + ", bookingPeople=" + bookingPeople + ", userId=" + userId + ", request=" + request
				+ ", delType=" + delType + ", delDate=" + delDate + "]";
	}
	
	
	
}
