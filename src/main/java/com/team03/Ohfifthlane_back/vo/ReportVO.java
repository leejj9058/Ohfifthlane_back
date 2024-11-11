package com.team03.Ohfifthlane_back.vo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReportVO {

	private int reportId;
	private int userId;
	private int rpzId;
	private String reportImage;
	private LocalDateTime photoTime;
	private LocalDateTime reportTime;
	private int reportStatus;
	private BigDecimal reportLat;
	private BigDecimal reportLon;
	private String reportCarNumber;
	
	private String reportAddress;
	
	
	// dto 너무 귀찮아져서 그냥 여기에 추가
	private String userName;
	private String rpzNum;
	private String userTel;
	
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRpzNum() {
		return rpzNum;
	}
	public void setRpzNum(String rpzNum) {
		this.rpzNum = rpzNum;
	}
	public String getReportAddress() {
		return reportAddress;
	}
	public void setReportAddress(String reportAddress) {
		this.reportAddress = reportAddress;
	}
	public String getReportCarNumber() {
		return reportCarNumber;
	}
	public void setReportCarNumber(String reportCarNumber) {
		this.reportCarNumber = reportCarNumber;
	}
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRpzId() {
		return rpzId;
	}
	public void setRpzId(int rpzId) {
		this.rpzId = rpzId;
	}
	public String getReportImage() {
		return reportImage;
	}
	public void setReportImage(String reportImage) {
		this.reportImage = reportImage;
	}
	public LocalDateTime getPhotoTime() {
		return photoTime;
	}
	public void setPhotoTime(LocalDateTime photoTime) {
		this.photoTime = photoTime;
	}
	public LocalDateTime getReportTime() {
		return reportTime;
	}
	public void setReportTime(LocalDateTime reportTime) {
		this.reportTime = reportTime;
	}
	public int getReportStatus() {
		return reportStatus;
	}
	public void setReportStatus(int reportStatus) {
		this.reportStatus = reportStatus;
	}
	public BigDecimal getReportLat() {
		return reportLat;
	}
	public void setReportLat(BigDecimal reportLat) {
		this.reportLat = reportLat;
	}
	public BigDecimal getReportLon() {
		return reportLon;
	}
	public void setReportLon(BigDecimal reportLon) {
		this.reportLon = reportLon;
	}
	@Override
	public String toString() {
		return "ReportVO [reportId=" + reportId + ", userId=" + userId + ", rpzId=" + rpzId + ", reportImage="
				+ reportImage + ", photoTime=" + photoTime + ", reportTime=" + reportTime + ", reportStatus="
				+ reportStatus + ", reportLat=" + reportLat + ", reportLon=" + reportLon + ", reportCarNumber="
				+ reportCarNumber + ", reportAddress=" + reportAddress + ", userName=" + userName + ", rpzNum=" + rpzNum
				+ ", userTel=" + userTel + "]";
	}
	
}
