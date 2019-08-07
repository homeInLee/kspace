package com.kh.host.model.vo;

import java.io.Serializable;

public class SpaceImageFile implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int spaceNo;
	private String imageOriginalFileName;
	private String imageRenamedFileName;
	private String flag;
	
	public SpaceImageFile() {}

	public SpaceImageFile(int spaceNo, String imageOriginalFileName, String imageRenamedFileName, String flag) {
		super();
		this.spaceNo = spaceNo;
		this.imageOriginalFileName = imageOriginalFileName;
		this.imageRenamedFileName = imageRenamedFileName;
		this.flag = flag;
	}

	public int getSpaceNo() {
		return spaceNo;
	}

	public void setSpaceNo(int spaceNo) {
		this.spaceNo = spaceNo;
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
		return "SpaceImageFile [spaceNo=" + spaceNo + ", imageOriginalFileName=" + imageOriginalFileName
				+ ", imageRenamedFileName=" + imageRenamedFileName + ", flag=" + flag + "]";
	}

}
