package com.team03.Ohfifthlane_back.controller;

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
		
		
		List<RPZVO> nearRPZList = dao.getNearRPZList(ulVO);
		
		return ResponseEntity.ok(nearRPZList);
	}
	
	
}
