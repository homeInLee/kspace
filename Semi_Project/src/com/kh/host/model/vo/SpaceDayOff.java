package com.kh.host.model.vo;

import java.io.Serializable;

public class SpaceDayOff implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int spaceNo;
	private String dayOffEvent;
	private String maxSpaceDayOff;
	
	public SpaceDayOff() {}

	public SpaceDayOff(int spaceNo, String dayOffEvent, String maxSpaceDayOff) {
		super();
		this.spaceNo = spaceNo;
		this.dayOffEvent = dayOffEvent;
		this.maxSpaceDayOff = maxSpaceDayOff;
	}

	public int getSpaceNo() {
		return spaceNo;
	}

	public void setSpaceNo(int spaceNo) {
		this.spaceNo = spaceNo;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SpaceDayOff [spaceNo=" + spaceNo + ", dayOffEvent=" + dayOffEvent + ", maxSpaceDayOff=" + maxSpaceDayOff
				+ "]";
	}

}
