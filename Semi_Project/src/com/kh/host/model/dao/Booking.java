package com.kh.host.model.dao;

import java.io.Serializable;
import java.util.Date;

public class Booking implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int bookingNo;
	private Date maxBookingTime;
	private Date minBookingTime;
	private int spaceNo;
	private int bookingPeople;
	private String userId;
	private String request;
	
	public Booking() {}

	public Booking(int bookingNo, Date maxBookingTime, Date minBookingTime, int spaceNo, int bookingPeople,
			String userId, String request) {
		super();
		this.bookingNo = bookingNo;
		this.maxBookingTime = maxBookingTime;
		this.minBookingTime = minBookingTime;
		this.spaceNo = spaceNo;
		this.bookingPeople = bookingPeople;
		this.userId = userId;
		this.request = request;
	}

	public int getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}

	public Date getMaxBookingTime() {
		return maxBookingTime;
	}

	public void setMaxBookingTime(Date maxBookingTime) {
		this.maxBookingTime = maxBookingTime;
	}

	public Date getMinBookingTime() {
		return minBookingTime;
	}

	public void setMinBookingTime(Date minBookingTime) {
		this.minBookingTime = minBookingTime;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Booking [bookingNo=" + bookingNo + ", maxBookingTime=" + maxBookingTime + ", minBookingTime="
				+ minBookingTime + ", spaceNo=" + spaceNo + ", bookingPeople=" + bookingPeople + ", userId=" + userId
				+ ", request=" + request + "]";
	}

}
