package com.team03.Ohfifthlane_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team03.Ohfifthlane_back.dao.QRDAO;
import com.team03.Ohfifthlane_back.vo.DisabledPersonVO;

@RestController
@RequestMapping("/api")

public class QRController {

	@Autowired
	QRDAO dao;
	
	@PostMapping("/checkVehicle")
	public ResponseEntity<?> checkVehicle(@RequestBody DisabledPersonVO vo) {
		Boolean result = dao.checkVehicle(vo);
		System.out.println(result);
		return ResponseEntity.ok(result);
	}
}
