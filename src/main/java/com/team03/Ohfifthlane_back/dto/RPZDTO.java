package com.team03.Ohfifthlane_back.dto;

import com.team03.Ohfifthlane_back.vo.ReservationVO;
import com.team03.Ohfifthlane_back.vo.UserLocationVO;

public class RPZDTO {
	UserLocationVO userLocationVo;
	ReservationVO reservationVo;

	public UserLocationVO getUserLocationVo() {
		return userLocationVo;
	}

	public void setUserLocationVo(UserLocationVO userLocationVo) {
		this.userLocationVo = userLocationVo;
	}

	public ReservationVO getReservationVo() {
		return reservationVo;
	}

	public void setReservationVo(ReservationVO reservationVo) {
		this.reservationVo = reservationVo;
	}

	@Override
	public String toString() {
		return "RPZDTO [userLocationVo=" + userLocationVo + ", reservationVo=" + reservationVo + "]";
	}

}
