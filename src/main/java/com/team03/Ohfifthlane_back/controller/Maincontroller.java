package com.team03.Ohfifthlane_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team03.Ohfifthlane_back.dao.UserDAO;
import com.team03.Ohfifthlane_back.vo.UserVO;

@RestController
@RequestMapping("/api")

public class Maincontroller {
	
	@Autowired UserDAO dao;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserVO vo) {
		UserVO user = dao.userLogin(vo);
		if(user == null) {
			return ResponseEntity.badRequest().body("회원 정보가 없습니다."); // 에러메세지
		}
		return ResponseEntity.ok(user);
	}
	
	
		
	
}
