package com.team03.Ohfifthlane_back.vo;

import java.math.BigDecimal;

public class ChargingStationVO {

	private int chargingStationId;
	private String chargingStationName;
	private String chargingStationAddress;
	private BigDecimal chargingStationLat;
	private BigDecimal chargingStationLon;
	
	
	public int getChargingStationId() {
		return chargingStationId;
	}
	public void setChargingStationId(int chargingStationId) {
		this.chargingStationId = chargingStationId;
	}
	public String getChargingStationName() {
		return chargingStationName;
	}
	public void setChargingStationName(String chargingStationName) {
		this.chargingStationName = chargingStationName;
	}
	public String getChargingStationAddress() {
		return chargingStationAddress;
	}
	public void setChargingStationAddress(String chargingStationAddress) {
		this.chargingStationAddress = chargingStationAddress;
	}
	public BigDecimal getChargingStationLat() {
		return chargingStationLat;
	}
	public void setChargingStationLat(BigDecimal chargingStationLat) {
		this.chargingStationLat = chargingStationLat;
	}
	public BigDecimal getChargingStationLon() {
		return chargingStationLon;
	}
	public void setChargingStationLon(BigDecimal chargingStationLon) {
		this.chargingStationLon = chargingStationLon;
	}
	
	@Override
	public String toString() {
		return "ChargingStationVO [chargingStationId=" + chargingStationId + ", chargingStationName="
				+ chargingStationName + ", chargingStationAddress=" + chargingStationAddress + ", chargingStationLat="
				+ chargingStationLat + ", chargingStationLon=" + chargingStationLon + "]";
	}
	
	
	
}
