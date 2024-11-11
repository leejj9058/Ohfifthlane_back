package com.team03.Ohfifthlane_back.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team03.Ohfifthlane_back.dao.ReservationDAO;
import com.team03.Ohfifthlane_back.dto.RPZDTO;
import com.team03.Ohfifthlane_back.vo.RPZVO;
import com.team03.Ohfifthlane_back.vo.ReservationVO;

@RestController
@RequestMapping("/api")

public class ReservationController {

	@Autowired
	ReservationDAO dao;

	// 1. 지정 시간 예약 가능 주차장 리스트 가져오기 (날짜, 시작 시간, 종료 시간)
	@PostMapping("/getRPZListByTime")
	public ResponseEntity<List<RPZVO>> getReservationListByTime(@RequestBody RPZDTO dto) {
	// dto -> UserLocationVO 사용자 위치 정보, ReservationVO 예약정보 (날짜, 시작시각, 종료시각)
		// 반경 500m 거주자 우선 주차장 리스트 가져오기 
		List<RPZVO> RPZList = dao.getNearRPZList(dto.getUserLocationVo());
		
		// iterator 생성
		Iterator<RPZVO> iterator = RPZList.iterator();
		
		// 주차장 별 예약 정보 리스트에 넣기
		while (iterator.hasNext()) {
            RPZVO RPZOne = iterator.next();
 
			// 주차장별 예약 정보 저장할 리스트 생성 및 예약 리스트 추가하기
			List<ReservationVO> reservationList = dao.getReservationListByRPZId(RPZOne.getRpzId());
			
			for(ReservationVO reserv : reservationList) {
				// 시작시각 비교 (예약 시작 시각이 기존 예약시간 사이에 있는지)
				if(dto.getReservationVo().getReservationStartTime().isBefore(reserv.getReservationEndTime()) &&
						dto.getReservationVo().getReservationStartTime().isAfter(reserv.getReservationStartTime())) {
					iterator.remove();
					break;
				}
				
				// 종료시각 비교 (예약 종료 시각이 기존 예약시간 사이에 있는지)
				else if(dto.getReservationVo().getReservationEndTime().isBefore(reserv.getReservationEndTime()) &&
						dto.getReservationVo().getReservationEndTime().isAfter(reserv.getReservationStartTime())) {
					iterator.remove();
					break;
				}
			}
		}
		
		if(RPZList.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}	
		return ResponseEntity.ok(RPZList);
	}

	// 2. 주차구역 아이디로 예약 가져오기
	@PostMapping("/getReservationListByRpzId")
	public ResponseEntity<List<ReservationVO>> getReservationListByRpzId(@RequestParam int rpzId) {

		List<ReservationVO> list = dao.getReservationListByRPZId(rpzId);
		
		// 예약 리스트가 비어있을 경우
		if (list == null || list.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(list);
	}
	
	// 3. 해당 주차 구역 예약하기
	@PostMapping("/putReservationByRpzId")
	public ResponseEntity<List<ReservationVO>> putReservationByRpzId(@RequestBody ReservationVO vo) {
		
		// 예약 가능 표시
		boolean availability = true;
		
		// 해당 주차 구역의 예약 리스트 가져오기
		List<ReservationVO> reservationlist = dao.getReservationListByRPZId(vo.getRPZId());
		
		// 예약 겹치는지 확인 하기
		for(ReservationVO reserv : reservationlist) {
			// 시작시각 비교 (예약 시작 시각이 기존 예약시간 사이에 있는지)
			if(vo.getReservationStartTime().isBefore(reserv.getReservationEndTime()) &&
					vo.getReservationStartTime().isAfter(reserv.getReservationStartTime())) {
				availability = false;
				break;
			}
			
			// 종료시각 비교 (예약 종료 시각이 기존 예약시간 사이에 있는지)
			else if(vo.getReservationEndTime().isBefore(reserv.getReservationEndTime()) &&
					vo.getReservationEndTime().isAfter(reserv.getReservationStartTime())) {
				availability = false;
				break;
			}
		}
						
		// 예약이 불가능 한 경우
		if (availability == false) {
			
			return ResponseEntity.badRequest().build();
		}
		
		// 예약 가능 시 주차장 예약 생성하기
		dao.putReservationByRPZId(vo);
					
		return ResponseEntity.ok().build();
	}
	
	
}
