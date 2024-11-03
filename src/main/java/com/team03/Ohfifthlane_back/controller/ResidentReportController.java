package com.team03.Ohfifthlane_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team03.Ohfifthlane_back.dao.RPZDAO;
import com.team03.Ohfifthlane_back.dao.ReportDAO;
import com.team03.Ohfifthlane_back.vo.RPZReportDTO;
import com.team03.Ohfifthlane_back.vo.RPZVO;
import com.team03.Ohfifthlane_back.vo.ReportVO;

@RestController
@RequestMapping("/api")

public class ResidentReportController {

	@Autowired
	ReportDAO reportDAO;
	
	@Autowired
	RPZDAO rpzDAO;
	
	
	//신고하는 메서드
	@PostMapping("/report")
	public ResponseEntity<?> createReport(@RequestBody RPZReportDTO dto) {
		
		ReportVO reportvo = dto.getReport();
		
        RPZVO rpzvo = dto.getRpz();
		
        //추가 유효성 검사
        if (reportvo.getReportCarNumber() == null || reportvo.getReportCarNumber().isEmpty()) {
        	return ResponseEntity.badRequest().body("차량번호를 입력해주세요.");
        }
        
        if (rpzvo.getRpzNum() == null || rpzvo.getRpzNum().isEmpty()) {
        	return ResponseEntity.badRequest().body("주차면 번호를 입력해주세요.");
        }
        
        
        //주차면 번호 입력했을 때, db에 있는 구획번호인지 확인
        RPZVO parkingSpot = rpzDAO.getByRPZNum(rpzvo.getRpzNum());
        
		
		return ResponseEntity.ok("신고가 접수되었습니다.");
	}
	
}
