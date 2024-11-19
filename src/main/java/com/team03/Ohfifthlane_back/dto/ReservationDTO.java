package com.team03.Ohfifthlane_back.dto;

import java.time.LocalTime;

public class ReservationDTO {
	
	private int userId;	
	private LocalTime reservationStartTime;
	private LocalTime reservationEndTime;
	private String reservationDay;
	private int reservationTotalFee;
	private int rpzId;
	private String rpzNum;
	private String rpzAddress;
	
	public String getRpzNum() {
		return rpzNum;
	}
	public void setRpzNum(String rpzNum) {
		this.rpzNum = rpzNum;
	}
	public String getRpzAddress() {
		return rpzAddress;
	}
	public void setRpzAddress(String rpzAddress) {
		this.rpzAddress = rpzAddress;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public LocalTime getReservationStartTime() {
		return reservationStartTime;
	}
	public void setReservationStartTime(LocalTime reservationStartTime) {
		this.reservationStartTime = reservationStartTime;
	}
	public LocalTime getReservationEndTime() {
		return reservationEndTime;
	}
	public void setReservationEndTime(LocalTime reservationEndTime) {
		this.reservationEndTime = reservationEndTime;
	}
	public String getReservationDay() {
		return reservationDay;
	}
	public void setReservationDay(String reservationDay) {
		this.reservationDay = reservationDay;
	}
	public int getReservationTotalFee() {
		return reservationTotalFee;
	}
	public void setReservationTotalFee(int reservationTotalFee) {
		this.reservationTotalFee = reservationTotalFee;
	}
	public int getRpzId() {
		return rpzId;
	}
	public void setRpzId(int rpzId) {
		this.rpzId = rpzId;
	}
	@Override
	public String toString() {
		return "ReservationDTO [userId=" + userId + ", reservationStartTime=" + reservationStartTime
				+ ", reservationEndTime=" + reservationEndTime + ", reservationDay=" + reservationDay
				+ ", reservationTotalFee=" + reservationTotalFee + ", rpzId=" + rpzId + ", rpzNum=" + rpzNum
				+ ", rpzAddress=" + rpzAddress + "]";
	}

	
	
	
}
