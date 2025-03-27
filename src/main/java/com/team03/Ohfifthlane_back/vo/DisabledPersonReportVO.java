package com.team03.Ohfifthlane_back.vo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DisabledPersonReportVO {

	private int disabledPersonReportId;
	private int userId;
	private String disabledPersonReportImage;
	private LocalDateTime disabledPersonReportTime;
	private int disabledPersonReportStatus;
	private BigDecimal disabledPersonReportLat;
	private BigDecimal disabledPersonReportLon;
	private String disabledPersonReportCarNumber;
	private String disabledPersonReportAddress;
	
	private String userName;
	private String userTel;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public int getDisabledPersonReportId() {
		return disabledPersonReportId;
	}
	public void setDisabledPersonReportId(int disabledPersonReportId) {
		this.disabledPersonReportId = disabledPersonReportId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getDisabledPersonReportImage() {
		return disabledPersonReportImage;
	}
	public void setDisabledPersonReportImage(String disabledPersonReportImage) {
		this.disabledPersonReportImage = disabledPersonReportImage;
	}
	public LocalDateTime getDisabledPersonReportTime() {
		return disabledPersonReportTime;
	}
	public void setDisabledPersonReportTime(LocalDateTime disabledPersonReportTime) {
		this.disabledPersonReportTime = disabledPersonReportTime;
	}
	public int getDisabledPersonReportStatus() {
		return disabledPersonReportStatus;
	}
	public void setDisabledPersonReportStatus(int disabledPersonReportStatus) {
		this.disabledPersonReportStatus = disabledPersonReportStatus;
	}
	public BigDecimal getDisabledPersonReportLat() {
		return disabledPersonReportLat;
	}
	public void setDisabledPersonReportLat(BigDecimal disabledPersonReportLat) {
		this.disabledPersonReportLat = disabledPersonReportLat;
	}
	public BigDecimal getDisabledPersonReportLon() {
		return disabledPersonReportLon;
	}
	public void setDisabledPersonReportLon(BigDecimal disabledPersonReportLon) {
		this.disabledPersonReportLon = disabledPersonReportLon;
	}
	public String getDisabledPersonReportCarNumber() {
		return disabledPersonReportCarNumber;
	}
	public void setDisabledPersonReportCarNumber(String disabledPersonReportCarNumber) {
		this.disabledPersonReportCarNumber = disabledPersonReportCarNumber;
	}
	public String getDisabledPersonReportAddress() {
		return disabledPersonReportAddress;
	}
	public void setDisabledPersonReportAddress(String disabledPersonReportAddress) {
		this.disabledPersonReportAddress = disabledPersonReportAddress;
	}
	
	@Override
	public String toString() {
		return "DisabledPersonReportVO [disabledPersonReportId=" + disabledPersonReportId + ", userId=" + userId
				+ ", disabledPersonReportImage=" + disabledPersonReportImage + ", disabledPersonReportTime="
				+ disabledPersonReportTime + ", disabledPersonReportStatus=" + disabledPersonReportStatus
				+ ", disabledPersonReportLat=" + disabledPersonReportLat + ", disabledPersonReportLon="
				+ disabledPersonReportLon + ", disabledPersonReportCarNumber=" + disabledPersonReportCarNumber
				+ ", disabledPersonReportAddress=" + disabledPersonReportAddress + ", userName=" + userName
				+ ", userTel=" + userTel + "]";
	}
	
	
	
	
	
}
