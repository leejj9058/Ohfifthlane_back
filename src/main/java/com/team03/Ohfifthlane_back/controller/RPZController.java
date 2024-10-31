package com.team03.Ohfifthlane_back.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team03.Ohfifthlane_back.dao.RPZDAO;
import com.team03.Ohfifthlane_back.vo.RPZVO;
import com.team03.Ohfifthlane_back.vo.UserLocationVO;

@RestController
@RequestMapping("/api")

public class RPZController {

	@Autowired
	RPZDAO dao;
	
	//반경 500m 리스트만 가져오기
	@PostMapping("/nearRPZList")
	public ResponseEntity<List<RPZVO>> getNearRPZList(@RequestBody UserLocationVO ulVO) {
		
		ulVO.setUserLat(BigDecimal.valueOf(37.6173693));
		ulVO.setUserlon(BigDecimal.valueOf(127.0315535));
		
		List<RPZVO> nearRPZList = dao.getNearRPZList(ulVO);
		
		System.out.println("nearRPZList: " + nearRPZList);
		
		return ResponseEntity.ok(nearRPZList);
	}
}
