package com.kh.host.model.vo;

import java.util.Date;

public class SpaceJoin {
	public SpaceJoin(int spaceNo, int companyNo, String spaceIntro, String bookingTime, int maxBookingPeople,
			int minBookingPeople, String spaceThema, String spaceCheck, String hashtag, String spaceName,
			String spaceFacilities, String spaceSlogan, String priceEvent, int spacePrice, String companyName,
			String companyPlace, int companyPointGa, int companyPointHa, String userId, String delType, Date delDate) {
		super();
		this.spaceNo = spaceNo;
		this.companyNo = companyNo;
		this.spaceIntro = spaceIntro;
		this.bookingTime = bookingTime;
		this.maxBookingPeople = maxBookingPeople;
		this.minBookingPeople = minBookingPeople;
		this.spaceThema = spaceThema;
		this.spaceCheck = spaceCheck;
		this.hashtag = hashtag;
		this.spaceName = spaceName;
		this.spaceFacilities = spaceFacilities;
		this.spaceSlogan = spaceSlogan;
		this.priceEvent = priceEvent;
		this.spacePrice = spacePrice;
		this.companyName = companyName;
		this.companyPlace = companyPlace;
		this.companyPointGa = companyPointGa;
		this.companyPointHa = companyPointHa;
		this.userId = userId;
		this.delType = delType;
		this.delDate = delDate;
	}
	public SpaceJoin() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int spaceNo;
	private int companyNo;
	private String spaceIntro;
	private String bookingTime;
	private int maxBookingPeople;
	private int minBookingPeople;
	private String spaceThema;
	private String spaceCheck;
	private String hashtag;
	private String spaceName;
	private String spaceFacilities;
	private String spaceSlogan;
	private String priceEvent;
	private int spacePrice;
	private String companyName;
	private String companyPlace;
	private int companyPointGa;
	private int companyPointHa;
	private String userId;
	private String delType;
	private Date delDate;
	public int getSpaceNo() {
		return spaceNo;
	}
	public void setSpaceNo(int spaceNo) {
		this.spaceNo = spaceNo;
	}
	public int getCompanyNo() {
		return companyNo;
	}
	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}
	public String getSpaceIntro() {
		return spaceIntro;
	}
	public void setSpaceIntro(String spaceIntro) {
		this.spaceIntro = spaceIntro;
	}
	public String getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}
	public int getMaxBookingPeople() {
		return maxBookingPeople;
	}
	public void setMaxBookingPeople(int maxBookingPeople) {
		this.maxBookingPeople = maxBookingPeople;
	}
	public int getMinBookingPeople() {
		return minBookingPeople;
	}
	public void setMinBookingPeople(int minBookingPeople) {
		this.minBookingPeople = minBookingPeople;
	}
	public String getSpaceThema() {
		return spaceThema;
	}
	public void setSpaceThema(String spaceThema) {
		this.spaceThema = spaceThema;
	}
	public String getSpaceCheck() {
		return spaceCheck;
	}
	public void setSpaceCheck(String spaceCheck) {
		this.spaceCheck = spaceCheck;
	}
	public String getHashtag() {
		return hashtag;
	}
	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}
	public String getSpaceName() {
		return spaceName;
	}
	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}
	public String getSpaceFacilities() {
		return spaceFacilities;
	}
	public void setSpaceFacilities(String spaceFacilities) {
		this.spaceFacilities = spaceFacilities;
	}
	public String getSpaceSlogan() {
		return spaceSlogan;
	}
	public void setSpaceSlogan(String spaceSlogan) {
		this.spaceSlogan = spaceSlogan;
	}
	public String getPriceEvent() {
		return priceEvent;
	}
	public void setPriceEvent(String priceEvent) {
		this.priceEvent = priceEvent;
	}
	public int getSpacePrice() {
		return spacePrice;
	}
	public void setSpacePrice(int spacePrice) {
		this.spacePrice = spacePrice;
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
	@Override
	public String toString() {
		return "SpaceJoin [spaceNo=" + spaceNo + ", companyNo=" + companyNo + ", spaceIntro=" + spaceIntro
				+ ", bookingTime=" + bookingTime + ", maxBookingPeople=" + maxBookingPeople + ", minBookingPeople="
				+ minBookingPeople + ", spaceThema=" + spaceThema + ", spaceCheck=" + spaceCheck + ", hashtag="
				+ hashtag + ", spaceName=" + spaceName + ", spaceFacilities=" + spaceFacilities + ", spaceSlogan="
				+ spaceSlogan + ", priceEvent=" + priceEvent + ", spacePrice=" + spacePrice + ", companyName="
				+ companyName + ", companyPlace=" + companyPlace + ", companyPointGa=" + companyPointGa
				+ ", companyPointHa=" + companyPointHa + ", userId=" + userId + ", delType=" + delType + ", delDate="
				+ delDate + "]";
	}
}
