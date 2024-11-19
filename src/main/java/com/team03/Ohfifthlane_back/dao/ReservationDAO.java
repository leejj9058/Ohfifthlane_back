package com.team03.Ohfifthlane_back.dao;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.team03.Ohfifthlane_back.dto.ReservationDTO;
import com.team03.Ohfifthlane_back.vo.RPZVO;
import com.team03.Ohfifthlane_back.vo.ReservationVO;
import com.team03.Ohfifthlane_back.vo.UserLocationVO;

@Component
public class ReservationDAO {
	@Autowired
	SqlSession session;

	// 현재 위치 반경 500m내 주차장 가져오기
	public List<RPZVO> getNearRPZList(UserLocationVO ulVO) {

		return session.selectList("getNearRPZList", ulVO);
	}

	// 주차구역 아이디로 예약 가져오기
	public List<ReservationVO> getReservationListByRPZId(int rpzId) {
		List<ReservationVO> list = session.selectList("getReservationListByRPZId", rpzId);
		return list;
	}
	
	// 해당 주차구역 예약 생성하기
	public void putReservationByRPZId(ReservationVO vo) {
		session.insert("putReservationByRPZId", vo);
	}
	
	public LocalTime changeLocalTime(String timeString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm[:ss]");
		LocalTime time = LocalTime.parse(timeString, formatter);
        return time.withSecond(0); // 초 단위 제거
	}

	public void insertReservation(ReservationDTO dto) {
		System.out.println("mapper vo = " + dto);
		session.insert("insertReservationByRPZId", dto);
	}
	
}
