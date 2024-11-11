package com.team03.Ohfifthlane_back.vo;

import java.math.BigDecimal;

public class UserLocationVO {

	private BigDecimal userLat;
	private BigDecimal userLon;
	
	public BigDecimal getUserLat() {
		return userLat;
	}
	public void setUserLat(BigDecimal userLat) {
		this.userLat = userLat;
	}
	public BigDecimal getUserLon() {
		return userLon;
	}
	public void setUserLon(BigDecimal userLon) {
		this.userLon = userLon;
	}
	@Override
	public String toString() {
		return "UserLocationVO [userLat=" + userLat + ", userLon=" + userLon + "]";
	}

	
}
