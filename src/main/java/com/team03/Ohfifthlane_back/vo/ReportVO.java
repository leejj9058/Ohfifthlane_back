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
				+ reportStatus + ", reportLat=" + reportLat + ", reportLon=" + reportLon + "]";
	}
	
	
	
}
