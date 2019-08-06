package com.kh.host.model.dao;

import java.io.Serializable;

public class Company implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String companyNo;
	private String companyName;
	private String companyPlace;
	private int companyPointGa;
	private int companyPointHa;
	private String userId;
	
	public Company() {}

	public Company(String companyNo, String companyName, String companyPlace, int companyPointGa, int companyPointHa,
			String userId) {
		super();
		this.companyNo = companyNo;
		this.companyName = companyName;
		this.companyPlace = companyPlace;
		this.companyPointGa = companyPointGa;
		this.companyPointHa = companyPointHa;
		this.userId = userId;
	}

	public String getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyPlace() {
		return companyPlace;
	}

	public void setCompanyPlace(String companyPlace) {
		this.companyPlace = companyPlace;
	}

	public int getCompanyPointGa() {
		return companyPointGa;
	}

	public void setCompanyPointGa(int companyPointGa) {
		this.companyPointGa = companyPointGa;
	}

	public int getCompanyPointHa() {
		return companyPointHa;
	}

	public void setCompanyPointHa(int companyPointHa) {
		this.companyPointHa = companyPointHa;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Company [companyNo=" + companyNo + ", companyName=" + companyName + ", companyPlace=" + companyPlace
				+ ", companyPointGa=" + companyPointGa + ", companyPointHa=" + companyPointHa + ", userId=" + userId
				+ "]";
	}

}
