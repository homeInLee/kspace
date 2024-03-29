package com.kh.host.model.vo;

import java.io.Serializable;

public class Space implements Serializable {

	private static final long serialVersionUID = 1L;
	
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
	
	public Space() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Space(int spaceNo, int companyNo, String spaceIntro, String bookingTime, int maxBookingPeople,
			int minBookingPeople, String spaceThema, String spaceCheck, String hashtag, String spaceName,
			String spaceFacilities, String spaceSlogan) {
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
	}
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Space [spaceNo=" + spaceNo + ", companyNo=" + companyNo + ", spaceIntro=" + spaceIntro
				+ ", bookingTime=" + bookingTime + ", maxBookingPeople=" + maxBookingPeople + ", minBookingPeople="
				+ minBookingPeople + ", spaceThema=" + spaceThema + ", spaceCheck=" + spaceCheck + ", hashtag="
				+ hashtag + ", spaceName=" + spaceName + ", spaceFacilities=" + spaceFacilities + ", spaceSlogan="
				+ spaceSlogan + "]";
	}
	
}
