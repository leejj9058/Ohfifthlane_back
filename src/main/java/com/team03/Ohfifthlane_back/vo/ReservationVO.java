package com.team03.Ohfifthlane_back.vo;

public class ReservationVO {

	private int reservationId;
	private int userId;	
	private String reservationStartTime;
	private String reservationEndTime;
	private String reservationDay;
	private int reservationTotalFee;
	private int RPZId;
	
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
	public String getReservationStartTime() {
		return reservationStartTime;
	}
	public void setReservationStartTime(String reservationStartTime) {
		this.reservationStartTime = reservationStartTime;
	}
	public String getReservationEndTime() {
		return reservationEndTime;
	}
	public void setReservationEndTime(String reservationEndTime) {
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
	public int getRPZId() {
		return RPZId;
	}
	public void setRPZId(int rPZId) {
		this.RPZId = rPZId;
	}
	
	@Override
	public String toString() {
		return "ReservationVO [reservationId=" + reservationId + ", userId=" + userId + ", reservationStartTime="
				+ reservationStartTime + ", reservationEndTime=" + reservationEndTime + ", reservationDay="
				+ reservationDay + ", reservationTotalFee=" + reservationTotalFee + ", RPZId=" + RPZId + "]";
	}
	
}