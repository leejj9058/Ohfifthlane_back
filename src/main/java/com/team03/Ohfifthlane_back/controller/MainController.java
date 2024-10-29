package com.team03.Ohfifthlane_back.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team03.Ohfifthlane_back.dao.AccountDAO;
import com.team03.Ohfifthlane_back.dao.UserDAO;
import com.team03.Ohfifthlane_back.vo.AccountVO;
import com.team03.Ohfifthlane_back.vo.RegisterDTO;
import com.team03.Ohfifthlane_back.vo.UserVO;

@RestController
@RequestMapping("/api")

public class MainController {

	@Autowired
	UserDAO dao;
	
	@Autowired
	AccountDAO adao;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AccountVO vo) {
		AccountVO user = dao.userLogin(vo);
		System.out.println(vo);
		System.out.println(user);

		if (user == null) {
			return ResponseEntity.badRequest().body("회원 정보가 없습니다."); // 에러메세지
		}

		return ResponseEntity.ok(user);
	}

	// 아이디 찾기 대충
	@PostMapping("/findId")
	public ResponseEntity<?> findId(@RequestBody UserVO uvo) {

		String accountEmail = dao.userFindId(uvo);

		System.out.println("AccountVO avo = " + accountEmail);

		if (accountEmail == null) {
			return ResponseEntity.badRequest().body("등록된 회원 정보가 없습니다."); // 에러메세지
		}

		return ResponseEntity.ok(accountEmail);
	}

	// 비번 찾기 대충
//	@PostMapping("/findPassword")
//	public ResponseEntity<?> findPassword(@RequestBody UserVO uvo) {
//
//		String accountPassword = dao.userFindPassword(uvo);
//
//		System.out.println("accountPassword = " + accountPassword);
//
//		if (accountPassword == null) {
//			return ResponseEntity.badRequest().body("등록된 회원 정보가 없습니다."); // 에러메세지
//		}
//
//		return ResponseEntity.ok(accountPassword);
//	}
	
	//회원가입
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody RegisterDTO dto) {
		try {

			AccountVO avo = dto.getAccount();
			
			adao.createAccount(avo);
			
			UserVO uvo = dto.getUser();

			uvo.setAccountId(avo.getAccountId());
			
			dao.createUser(uvo);
			
			System.out.println("avo = " + avo);
			System.out.println("uvo = " + uvo);
			
			return ResponseEntity.ok("회원가입 성공");
			
		} catch (Exception e) {

			return ResponseEntity.badRequest().body("회원가입에 실패했습니다."); // 에러메세지
		}
		
	}
	
	@PostMapping("/checkEmail")
	public ResponseEntity<?> checkEmail(@RequestBody Map<String, String> requestBody) {
	    String accountEmail = requestBody.get("accountEmail");
	    int count = dao.checkEmail(accountEmail);

	    System.out.println("email : " + accountEmail);
	    System.out.println("count : " + count);

	    // count가 0이면 사용 가능, 1이면 이미 존재
	    return ResponseEntity.ok(count == 0);
	}

	
	

}
