package com.team03.Ohfifthlane_back.vo;

import java.math.BigDecimal;

import org.locationtech.jts.geom.Point;

public class RPZVO {

	private int rpzId;                
    private String rpzNum;             // VARCHAR(30) => String
    private BigDecimal rpzLat;         // NUMERIC => BigDecimal
    private BigDecimal rpzLon;         // NUMERIC => BigDecimal
    private String rpzAddress;         // VARCHAR(200) => String
    private String rpzManageTel;       // VARCHAR(30) => String
    private String rpzManageName;      // VARCHAR(50) => String
    private int rpzFee;            // INTEGER => Integer
    private Point rpzCoord;            // GEOMETRY(Point, 4326) => Point (JTS 라이브러리 사용)
    private Long userId;
    
	public int getRpzId() {
		return rpzId;
	}
	public void setRpzId(int rpzId) {
		this.rpzId = rpzId;
	}
	public String getRpzNum() {
		return rpzNum;
	}
	public void setRpzNum(String rpzNum) {
		this.rpzNum = rpzNum;
	}
	public BigDecimal getRpzLat() {
		return rpzLat;
	}
	public void setRpzLat(BigDecimal rpzLat) {
		this.rpzLat = rpzLat;
	}
	public BigDecimal getRpzLon() {
		return rpzLon;
	}
	public void setRpzLon(BigDecimal rpzLon) {
		this.rpzLon = rpzLon;
	}
	public String getRpzAddress() {
		return rpzAddress;
	}
	public void setRpzAddress(String rpzAddress) {
		this.rpzAddress = rpzAddress;
	}
	public String getRpzManageTel() {
		return rpzManageTel;
	}
	public void setRpzManageTel(String rpzManageTel) {
		this.rpzManageTel = rpzManageTel;
	}
	public String getRpzManageName() {
		return rpzManageName;
	}
	public void setRpzManageName(String rpzManageName) {
		this.rpzManageName = rpzManageName;
	}
	public int getRpzFee() {
		return rpzFee;
	}
	public void setRpzFee(int rpzFee) {
		this.rpzFee = rpzFee;
	}
	public Point getRpzCoord() {
		return rpzCoord;
	}
	public void setRpzCoord(Point rpzCoord) {
		this.rpzCoord = rpzCoord;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "RPZVO [rpzId=" + rpzId + ", rpzNum=" + rpzNum + ", rpzLat=" + rpzLat + ", rpzLon=" + rpzLon
				+ ", rpzAddress=" + rpzAddress + ", rpzManageTel=" + rpzManageTel + ", rpzManageName=" + rpzManageName
				+ ", rpzFee=" + rpzFee + ", rpzCoord=" + rpzCoord + ", userId=" + userId + "]";
	}
    
	
    
	
	
}
