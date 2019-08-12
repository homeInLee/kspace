package com.kh.admin.banner.model.vo;

import java.io.Serializable;
import java.util.Date;

public class SpaceAll implements Serializable {

	private static final long serialVersionUID = 1L;

	private int companyNo;
	private String companyName;
	private String companyPlace;
	private int companyPointGa;
	private int companyPointHa;
	private String userId;
	private String delType;
	private Date delDate;
	private int spaceNo;
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
	private String dayOffEvent;
	private String maxSpaceDayOff;
	private String imageOriginalFileName;
	private String imageRenamedFileName;
	private String flag; //대표이미지인지 아닌지
	
	public SpaceAll() {}

	public SpaceAll(int companyNo, String companyName, String companyPlace, int companyPointGa, int companyPointHa,
			String userId, String delType, Date delDate, int spaceNo, String spaceIntro, String bookingTime,
			int maxBookingPeople, int minBookingPeople, String spaceThema, String spaceCheck, String hashtag,
			String spaceName, String spaceFacilities, String spaceSlogan, String priceEvent, int spacePrice,
			String dayOffEvent, String maxSpaceDayOff, String imageOriginalFileName, String imageRenamedFileName,
			String flag) {
		super();
		this.companyNo = companyNo;
		this.companyName = companyName;
		this.companyPlace = companyPlace;
		this.companyPointGa = companyPointGa;
		this.companyPointHa = companyPointHa;
		this.userId = userId;
		this.delType = delType;
		this.delDate = delDate;
		this.spaceNo = spaceNo;
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
		this.dayOffEvent = dayOffEvent;
		this.maxSpaceDayOff = maxSpaceDayOff;
		this.imageOriginalFileName = imageOriginalFileName;
		this.imageRenamedFileName = imageRenamedFileName;
		this.flag = flag;
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

	public int getSpaceNo() {
		return spaceNo;
	}

	public void setSpaceNo(int spaceNo) {
		this.spaceNo = spaceNo;
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

	public String getDayOffEvent() {
		return dayOffEvent;
	}

	public void setDayOffEvent(String dayOffEvent) {
		this.dayOffEvent = dayOffEvent;
	}

	public String getMaxSpaceDayOff() {
		return maxSpaceDayOff;
	}

	public void setMaxSpaceDayOff(String maxSpaceDayOff) {
		this.maxSpaceDayOff = maxSpaceDayOff;
	}

	public String getImageOriginalFileName() {
		return imageOriginalFileName;
	}

	public void setImageOriginalFileName(String imageOriginalFileName) {
		this.imageOriginalFileName = imageOriginalFileName;
	}

	public String getImageRenamedFileName() {
		return imageRenamedFileName;
	}

	public void setImageRenamedFileName(String imageRenamedFileName) {
		this.imageRenamedFileName = imageRenamedFileName;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SpaceAll [companyNo=" + companyNo + ", companyName=" + companyName + ", companyPlace=" + companyPlace
				+ ", companyPointGa=" + companyPointGa + ", companyPointHa=" + companyPointHa + ", userId=" + userId
				+ ", delType=" + delType + ", delDate=" + delDate + ", spaceNo=" + spaceNo + ", spaceIntro="
				+ spaceIntro + ", bookingTime=" + bookingTime + ", maxBookingPeople=" + maxBookingPeople
				+ ", minBookingPeople=" + minBookingPeople + ", spaceThema=" + spaceThema + ", spaceCheck=" + spaceCheck
				+ ", hashtag=" + hashtag + ", spaceName=" + spaceName + ", spaceFacilities=" + spaceFacilities
				+ ", spaceSlogan=" + spaceSlogan + ", priceEvent=" + priceEvent + ", spacePrice=" + spacePrice
				+ ", dayOffEvent=" + dayOffEvent + ", maxSpaceDayOff=" + maxSpaceDayOff + ", imageOriginalFileName="
				+ imageOriginalFileName + ", imageRenamedFileName=" + imageRenamedFileName + ", flag=" + flag + "]";
	}
	
}
