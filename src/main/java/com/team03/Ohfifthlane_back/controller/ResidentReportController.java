package com.team03.Ohfifthlane_back.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team03.Ohfifthlane_back.dao.RPZDAO;
import com.team03.Ohfifthlane_back.dao.ReportDAO;
import com.team03.Ohfifthlane_back.dto.RPZReportDTO;
import com.team03.Ohfifthlane_back.vo.RPZVO;
import com.team03.Ohfifthlane_back.vo.ReportVO;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")

public class ResidentReportController {

	@Autowired
	ReportDAO reportDAO;
	
	@Autowired
	RPZDAO rpzDAO;
	
	@Autowired
	HttpSession session;
	
	//신고하는 메서드
	@PostMapping("/report")
	public ResponseEntity<?> createReport(@RequestBody RPZReportDTO dto) {
		
		System.out.println("dto: " + dto);
		
	    ReportVO reportVO = dto.getReport();
	    
	    reportVO.getReportCarNumber();
	    
	    RPZVO rpzVO = dto.getRpz();

	    rpzVO.getRpzNum();
	    
	    // 유효성 검사 
	    if (reportVO == null || rpzVO == null) {
	        return ResponseEntity.badRequest().body("잘못된 요청입니다.");
	    }
	    
	    if (reportVO.getReportCarNumber() == null || reportVO.getReportCarNumber().isEmpty()) {
	        return ResponseEntity.badRequest().body("차량번호를 입력해주세요.");
	    }

	    // 주차면 번호 입력했을 때, db에 있는 구획번호인지 확인
	    Boolean parkingSpot = rpzDAO.existsByRPZNum(rpzVO.getRpzNum());
	    if (!parkingSpot) {
	        return ResponseEntity.badRequest().body("유효하지 않은 주차면 번호입니다.");
	    }

	    // 주차면 ID 가져오기
	    int rpzId = rpzDAO.getRPZIdByRPZNum(rpzVO.getRpzNum());
	    reportVO.setRpzId(rpzId);

	    // 신고 정보 설정
	    reportVO.setPhotoTime(LocalDateTime.now());
	    reportVO.setReportTime(LocalDateTime.now());
	    reportVO.setReportStatus(0); // 0을 default 대기중으로
	    reportVO.setReportLat(new BigDecimal(37.6173693)); // 더미 위치
	    reportVO.setReportLon(new BigDecimal(127.0315535));
	    reportVO.setReportImage("assets/images/example-photo.png"); // 더미 이미지 경로 설정
	    reportVO.setReportCarNumber(reportVO.getReportCarNumber());

	    Integer userId = (Integer) session.getAttribute("userId");
	    reportVO.setUserId(userId);

	    // DB에 저장
	    try {
	        reportDAO.createReport(reportVO);
	    } catch (Exception e) {
	        e.printStackTrace(); // 로그 출력
	        return ResponseEntity.status(500).body("신고 저장 중 오류가 발생했습니다.");
	    }

	    return ResponseEntity.ok("신고가 접수되었습니다.");
	}

	
}
