package com.kh.customer.model.dao;

import java.io.Serializable;

public class SpaceDibs implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int spaceNo;
	private String userId;
	private String dibsCheck;
	
	public SpaceDibs() {}

	public SpaceDibs(int spaceNo, String userId, String dibsCheck) {
		super();
		this.spaceNo = spaceNo;
		this.userId = userId;
		this.dibsCheck = dibsCheck;
	}

	public int getSpaceNo() {
		return spaceNo;
	}

	public void setSpaceNo(int spaceNo) {
		this.spaceNo = spaceNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDibsCheck() {
		return dibsCheck;
	}

	public void setDibsCheck(String dibsCheck) {
		this.dibsCheck = dibsCheck;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SpaceDibs [spaceNo=" + spaceNo + ", userId=" + userId + ", dibsCheck=" + dibsCheck + "]";
	}

}
