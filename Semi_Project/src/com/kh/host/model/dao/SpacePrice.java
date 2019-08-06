package com.kh.host.model.dao;

import java.io.Serializable;

public class SpacePrice implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int spaceNo;
	private String priceEvent;
	private int spacePrice;
	
	public SpacePrice() {}

	public SpacePrice(int spaceNo, String priceEvent, int spacePrice) {
		super();
		this.spaceNo = spaceNo;
		this.priceEvent = priceEvent;
		this.spacePrice = spacePrice;
	}

	public int getSpaceNo() {
		return spaceNo;
	}

	public void setSpaceNo(int spaceNo) {
		this.spaceNo = spaceNo;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SpacePrice [spaceNo=" + spaceNo + ", priceEvent=" + priceEvent + ", spacePrice=" + spacePrice + "]";
	}

}
