package com.team03.Ohfifthlane_back.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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

	private static final String kakaoApiKey = "6f5eaf3c90ba70fdbe116148fc3b8465";

	@Autowired
	ReportDAO reportDAO;

	@Autowired
	RPZDAO rpzDAO;

	@Autowired
	HttpSession session;

	// 이미지 업로드 메서드
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

		// 저장된 파일 경로를 vo에 설정
		rvo.setReportImage(fileName); // 이미지 경로 설정

		return ResponseEntity.ok(rvo); // 업로드된 이미지 경로를 반환
	}

	// 신고하는 메서드
	@PostMapping("/report")
	public ResponseEntity<?> createReport(@RequestBody RPZReportDTO dto) {

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
		
		// 지오코딩으로 주소 설정
		String address = getAddressFromCoordinates(reportVO.getReportLat(), reportVO.getReportLon());
		reportVO.setReportAddress(address);

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

	// 신고 리스트 가져오기 - 주소 포함
	@PostMapping("/reportList")
	public ResponseEntity<List<ReportVO>> getReportList() {

		// 신고 목록 가져오기
		List<ReportVO> reportList = reportDAO.getReportList();

		return ResponseEntity.ok(reportList);
	}

	// 카카오 API로 경위도 -> 주소 변환
	private String getAddressFromCoordinates(BigDecimal lat, BigDecimal lon) {
	    try {
	        double latitude = lat.doubleValue();
	        double longitude = lon.doubleValue();

	        // 카카오 API URL 설정
	        String url = String.format("https://dapi.kakao.com/v2/local/geo/coord2address.json?x=%f&y=%f", longitude, latitude);

	        // RestTemplate을 사용해 카카오 API 호출
	        RestTemplate restTemplate = new RestTemplate();
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("Authorization", "KakaoAK " + kakaoApiKey); // API 키를 추가

	        HttpEntity<String> entity = new HttpEntity<>(headers);
	        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

	        // 카카오 API 응답 로그 추가
	        System.out.println("Kakao API response: " + response.getBody());

	        // 카카오 API에서 받은 응답 반환
	        if (response.getStatusCode().is2xxSuccessful()) {
	            return parseAddressFromResponse(response.getBody()); // 응답 본문을 파싱하여 주소 반환
	        } else {
	            System.out.println("Error: " + response.getStatusCode()); // 오류 상태 코드 출력
	            return "주소를 찾을 수 없습니다.";  // 응답이 실패한 경우
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "주소를 찾을 수 없습니다.";  // 예외 발생 시
	    }
	}


	// 카카오 API 응답에서 주소 파싱
	private String parseAddressFromResponse(String responseBody) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonResponse = objectMapper.readTree(responseBody);
			JsonNode documents = jsonResponse.get("documents");

			if (documents.isArray() && documents.size() > 0) {
				JsonNode address = documents.get(0).get("address");
				return address.get("address_name").asText(); // 주소명 반환
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "주소를 찾을 수 없습니다."; // 에러 발생 시 기본 반환 값
	}
	
	// 신고 상세 페이지
	@GetMapping("/reportDetail/{reportId}")
	public ResponseEntity<ReportVO> getReportDetail(@PathVariable("reportId") int reportId) {
		
		ReportVO report = reportDAO.getReportByReportId(reportId);
		
		System.out.println("report = " + report);
		
		return ResponseEntity.ok(report);
	}
	
	
	//신고 상태 변경
	@PutMapping("/updateReportStatus/{reportId}/{reportStatus}")
	public ResponseEntity<?> updateReportStatus(@PathVariable("reportId") int reportId,
			@PathVariable("reportStatus") int reportStatus) {
		
		ReportVO reportVO = new ReportVO();
		reportVO.setReportId(reportId);
		reportVO.setReportStatus(reportStatus);
		
		reportDAO.updateReportStatus(reportVO);
		
		return ResponseEntity.ok("상태가 변경되었습니다.");
	}

}
