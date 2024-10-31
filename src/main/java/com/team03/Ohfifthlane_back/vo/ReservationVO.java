package com.team03.Ohfifthlane_back.vo;

import java.time.LocalDateTime;

public class ReservationVO {

	private int reservationId;
	private int userId;
	private LocalDateTime reservationStartTime;
	private LocalDateTime reservationEndTime;
	private String reservationDay;
	private int reservationTotalFee;
	private int rpzId;
	
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public LocalDateTime getReservationStartTime() {
		return reservationStartTime;
	}
	public void setReservationStartTime(LocalDateTime reservationStartTime) {
		this.reservationStartTime = reservationStartTime;
	}
	public LocalDateTime getReservationEndTime() {
		return reservationEndTime;
	}
	public void setReservationEndTime(LocalDateTime reservationEndTime) {
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
		return "ReservationVO [reservationId=" + reservationId + ", userId=" + userId + ", reservationStartTime="
				+ reservationStartTime + ", reservationEndTime=" + reservationEndTime + ", reservationDay="
				+ reservationDay + ", reservationTotalFee=" + reservationTotalFee + ", rpzId=" + rpzId + "]";
	}
	
	
	
	
}
