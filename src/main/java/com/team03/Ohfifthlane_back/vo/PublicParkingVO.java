package com.team03.Ohfifthlane_back.vo;

import java.math.BigDecimal;

public class PublicParkingVO {

	private int publicParkingId;
	private String publicParkingName;
	private String publicParkingAddress;
	private BigDecimal publicParkingLat;
	private BigDecimal publicParkingLon;
	private int publicParkingTotal;
	
	public int getPublicParkingId() {
		return publicParkingId;
	}
	public void setPublicParkingId(int publicParkingId) {
		this.publicParkingId = publicParkingId;
	}
	public String getPublicParkingName() {
		return publicParkingName;
	}
	public void setPublicParkingName(String publicParkingName) {
		this.publicParkingName = publicParkingName;
	}
	public String getPublicParkingAddress() {
		return publicParkingAddress;
	}
	public void setPublicParkingAddress(String publicParkingAddress) {
		this.publicParkingAddress = publicParkingAddress;
	}
	public BigDecimal getPublicParkingLat() {
		return publicParkingLat;
	}
	public void setPublicParkingLat(BigDecimal publicParkingLat) {
		this.publicParkingLat = publicParkingLat;
	}
	public BigDecimal getPublicParkingLon() {
		return publicParkingLon;
	}
	public void setPublicParkingLon(BigDecimal publicParkingLon) {
		this.publicParkingLon = publicParkingLon;
	}
	
	public int getPublicParkingTotal() {
		return publicParkingTotal;
	}
	public void setPublicParkingTotal(int publicParkingTotal) {
		this.publicParkingTotal = publicParkingTotal;
	}
	@Override
	public String toString() {
		return "PublicParkingVO [publicParkingId=" + publicParkingId + ", publicParkingName=" + publicParkingName
				+ ", publicParkingAddress=" + publicParkingAddress + ", publicParkingLat=" + publicParkingLat
				+ ", publicParkingLon=" + publicParkingLon + ", publicParkingTotal=" + publicParkingTotal + "]";
	}
	

	
	
	
}
