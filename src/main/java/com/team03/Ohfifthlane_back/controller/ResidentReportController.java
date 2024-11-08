package com.team03.Ohfifthlane_back.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
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

	@Value("${upload.dir}")
	private String uploadDir;

	@Autowired
	ReportDAO reportDAO;

	@Autowired
	RPZDAO rpzDAO;

	@Autowired
	HttpSession session;

	@PostMapping("/uploadPhoto")
	public ResponseEntity<?> uploadPhoto(@RequestBody ReportVO rvo) {

		// base64 문자열에서 이미지 추출
		String base64Image = rvo.getReportImage().split(",")[1];
		
		byte[] imageBytes = Base64.getDecoder().decode(base64Image);

		// 파일 이름 생성
		String fileName = UUID.randomUUID().toString() + ".png";
		Path filePath = Paths.get(uploadDir + File.separator + fileName);

		// 파일 저장
		try {
			Files.write(filePath, imageBytes);
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("파일 저장 중 오류 발생: " + e.getMessage());
		}
		
//		String imageUrl = "http://172.168.10.73:8080/uploads/" + fileName;

		

		// 저장된 파일 경로를 vo에 설정
		rvo.setReportImage(fileName); // 이미지 경로 설정

		return ResponseEntity.ok(rvo); // 업로드된 이미지 경로를 반환
	}

	@PostMapping("/report")
	public ResponseEntity<?> createReport(@RequestBody RPZReportDTO dto) {

		System.out.println("dto: " + dto);

		ReportVO reportVO = dto.getReport();

		// 이미지 경로가 설정되어 있는지 확인
		if (reportVO.getReportImage() == null || reportVO.getReportImage().isEmpty()) {
			return ResponseEntity.badRequest().body("이미지가 업로드되지 않았습니다.");
		}

		RPZVO rpzVO = dto.getRpz();

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
		reportVO.setReportLat(reportVO.getReportLat()); // 더미 위치
		reportVO.setReportLon(reportVO.getReportLon());
		reportVO.setReportCarNumber(reportVO.getReportCarNumber());
		reportVO.setReportImage(reportVO.getReportImage());

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
