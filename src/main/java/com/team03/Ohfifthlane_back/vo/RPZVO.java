package com.team03.Ohfifthlane_back.vo;

import java.math.BigDecimal;

import org.locationtech.jts.geom.Point;

public class RPZVO {

	private int RPZId;                
    private String RPZNum;             // VARCHAR(30) => String
    private BigDecimal RPZLat;         // NUMERIC => BigDecimal
    private BigDecimal RPZLon;         // NUMERIC => BigDecimal
    private String RPZAddress;         // VARCHAR(200) => String
    private String RPZManageTel;       // VARCHAR(30) => String
    private String RPZManageName;      // VARCHAR(50) => String
    private int RPZFee;            // INTEGER => Integer
    private Point RPZCoord;            // GEOMETRY(Point, 4326) => Point (JTS 라이브러리 사용)
    private Long userId;
    
	public int getRPZId() {
		return RPZId;
	}
	public void setRPZId(int rPZId) {
		RPZId = rPZId;
	}
	public String getRPZNum() {
		return RPZNum;
	}
	public void setRPZNum(String rPZNum) {
		RPZNum = rPZNum;
	}
	public BigDecimal getRPZLat() {
		return RPZLat;
	}
	public void setRPZLat(BigDecimal rPZLat) {
		RPZLat = rPZLat;
	}
	public BigDecimal getRPZLon() {
		return RPZLon;
	}
	public void setRPZLon(BigDecimal rPZLon) {
		RPZLon = rPZLon;
	}
	public String getRPZAddress() {
		return RPZAddress;
	}
	public void setRPZAddress(String rPZAddress) {
		RPZAddress = rPZAddress;
	}
	public String getRPZManageTel() {
		return RPZManageTel;
	}
	public void setRPZManageTel(String rPZManageTel) {
		RPZManageTel = rPZManageTel;
	}
	public String getRPZManageName() {
		return RPZManageName;
	}
	public void setRPZManageName(String rPZManageName) {
		RPZManageName = rPZManageName;
	}
	public int getRPZFee() {
		return RPZFee;
	}
	public void setRPZFee(int rPZFee) {
		RPZFee = rPZFee;
	}
	public Point getRPZCoord() {
		return RPZCoord;
	}
	public void setRPZCoord(Point rPZCoord) {
		RPZCoord = rPZCoord;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "RPZVO [RPZId=" + RPZId + ", RPZNum=" + RPZNum + ", RPZLat=" + RPZLat + ", RPZLon=" + RPZLon
				+ ", RPZAddress=" + RPZAddress + ", RPZManageTel=" + RPZManageTel + ", RPZManageName=" + RPZManageName
				+ ", RPZFee=" + RPZFee + ", RPZCoord=" + RPZCoord + ", userId=" + userId + "]";
	}
	
}
