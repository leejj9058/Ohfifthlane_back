package com.team03.Ohfifthlane_back.controller;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team03.Ohfifthlane_back.dao.RPZDAO;
import com.team03.Ohfifthlane_back.dao.ReservationDAO;
import com.team03.Ohfifthlane_back.dto.RPZDTO;
import com.team03.Ohfifthlane_back.vo.RPZVO;
import com.team03.Ohfifthlane_back.vo.ReservationVO;
import com.team03.Ohfifthlane_back.vo.UserLocationVO;

@RestController
@RequestMapping("/api")

public class RPZController {

	@Autowired
	RPZDAO dao;

	@Autowired
	ReservationDAO rdao;
	
	// 1. 반경 500m 리스트만 가져오기
	@PostMapping("/nearRPZList")
	public ResponseEntity<List<RPZVO>> getNearRPZList(@RequestBody UserLocationVO ulVO) {
		
		List<RPZVO> nearRPZList = dao.getNearRPZList(ulVO);
		
		return ResponseEntity.ok(nearRPZList);
	}
	
	// 2. rpzId로 RPZ정보 가져오기
	@PostMapping("/getRPZById")
	public ResponseEntity<RPZVO> getRPZById(@RequestParam int rpzId) {
		
	    RPZVO rpz = dao.getRPZById(rpzId);
	    
	    return ResponseEntity.ok(rpz);
	}
	
	
	// 1. 지정 시간 예약 가능 주차장 리스트 가져오기 (날짜, 시작 시간, 종료 시간)
		@PostMapping("/getRecommendRPZList")
		public ResponseEntity<List<RPZVO>> getReservationListByTime(@RequestBody RPZDTO dto) {
			// dto -> UserLocationVO 사용자 위치 정보, ReservationVO 예약정보 (날짜, 시작시각, 종료시각)
			// 반경 500m 거주자 우선 주차장 리스트 가져오기
			List<RPZVO> RPZList = dao.getNearRPZList(dto.getUserLocationVo());

			if (RPZList.isEmpty()) {
				return ResponseEntity.badRequest().build();
			}

			// 예약하려는 시작 시간
			LocalTime reservationStartTime = rdao.changeLocalTime(dto.getReservationVo().getReservationStartTime());

			// 예약하려는 종료 시간
			LocalTime reservationEndTime = rdao.changeLocalTime(dto.getReservationVo().getReservationEndTime());

				// iterator 생성
				Iterator<RPZVO> iterator = RPZList.iterator();

				// 주차장 별 예약 정보 리스트에 넣기
				while (iterator.hasNext()) {
					RPZVO RPZOne = iterator.next();

					// 주차장별 예약 정보 저장할 리스트 생성 및 예약 리스트 추가하기
					List<ReservationVO> reservationList = rdao.getReservationListByRPZId(RPZOne.getRpzId());

					for (ReservationVO reserv : reservationList) {
						
						// 기존 예약의 시작 시간
						LocalTime previousReservationStartTime = rdao.changeLocalTime(reserv.getReservationStartTime());
						
						// 기존 예약의 종료 시간
						LocalTime previousReservationEndTime = rdao.changeLocalTime(reserv.getReservationEndTime());				
						
						// 시작시각 비교 (예약 시작 시각이 기존 예약시간 사이에 있는지)
						if (reservationStartTime.isBefore(previousReservationEndTime)
								&& reservationStartTime.isAfter(previousReservationStartTime)) {
							iterator.remove();
							break;
						}

						// 종료시각 비교 (예약 종료 시각이 기존 예약시간 사이에 있는지)
						else if (reservationEndTime.isBefore(previousReservationEndTime)
								&& reservationEndTime.isAfter(previousReservationStartTime)) {
							iterator.remove();
							break;
						}
					}

				}

				if (RPZList.isEmpty()) {
					return ResponseEntity.badRequest().build();
				}
				
				// rpz_distance 기준으로 정렬하여 상위 5개 추출
			    List<RPZVO> topFiveRPZList = RPZList.stream()
			        .sorted(Comparator.comparingDouble(RPZVO::getRpzDistance)) // 거리 기준 정렬
			        .limit(5) // 상위 5개 추출
			        .toList(); // 리스트로 변환 (Java 16 이상)
				
				return ResponseEntity.ok(topFiveRPZList);
			}
	
	
}
