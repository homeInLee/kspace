package com.kh.admin.model.vo;

import java.io.Serializable;

public class Banner implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int bannerNo;
	private String bannerContent;
	private String bannerOriginalFileName;
	private String bannerRenamedFileName;
	
	public Banner() {}

	public Banner(int bannerNo, String bannerContent, String bannerOriginalFileName, String bannerRenamedFileName) {
		super();
		this.bannerNo = bannerNo;
		this.bannerContent = bannerContent;
		this.bannerOriginalFileName = bannerOriginalFileName;
		this.bannerRenamedFileName = bannerRenamedFileName;
	}

	public int getBannerNo() {
		return bannerNo;
	}

	public void setBannerNo(int bannerNo) {
		this.bannerNo = bannerNo;
	}

	public String getBannerContent() {
		return bannerContent;
	}

	public void setBannerContent(String bannerContent) {
		this.bannerContent = bannerContent;
	}

	public String getBannerOriginalFileName() {
		return bannerOriginalFileName;
	}

	public void setBannerOriginalFileName(String bannerOriginalFileName) {
		this.bannerOriginalFileName = bannerOriginalFileName;
	}

	public String getBannerRenamedFileName() {
		return bannerRenamedFileName;
	}

	public void setBannerRenamedFileName(String bannerRenamedFileName) {
		this.bannerRenamedFileName = bannerRenamedFileName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Banner [bannerNo=" + bannerNo + ", bannerContent=" + bannerContent + ", bannerOriginalFileName="
				+ bannerOriginalFileName + ", bannerRenamedFileName=" + bannerRenamedFileName + "]";
	}

}
