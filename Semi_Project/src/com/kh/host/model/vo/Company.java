package com.kh.host.model.vo;

import java.io.Serializable;
import java.util.Date;

public class Company implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int companyNo;
	private String companyName;
	private String companyPlace;
	private int companyPointGa;
	private int companyPointHa;
	private String userId;
	private String delType;
	private Date delDate;
	private int fees;
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Company(int companyNo, String companyName, String companyPlace, int companyPointGa, int companyPointHa,
			String userId, String delType, Date delDate, int fees) {
		super();
		this.companyNo = companyNo;
		this.companyName = companyName;
		this.companyPlace = companyPlace;
		this.companyPointGa = companyPointGa;
		this.companyPointHa = companyPointHa;
		this.userId = userId;
		this.delType = delType;
		this.delDate = delDate;
		this.fees = fees;
	}
	public int getCompanyNo() {
		return companyNo;
	}
	public void setCompanyNo(int companyNo) {
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
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Company [companyNo=" + companyNo + ", companyName=" + companyName + ", companyPlace=" + companyPlace
				+ ", companyPointGa=" + companyPointGa + ", companyPointHa=" + companyPointHa + ", userId=" + userId
				+ ", delType=" + delType + ", delDate=" + delDate + ", fees=" + fees + "]";
	}
	

}
