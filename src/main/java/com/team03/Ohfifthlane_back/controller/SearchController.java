package com.team03.Ohfifthlane_back.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.team03.Ohfifthlane_back.dao.SearchDAO;
import com.team03.Ohfifthlane_back.vo.ChargingStationVO;
import com.team03.Ohfifthlane_back.vo.PublicParkingVO;



@RestController
@RequestMapping("/api")

public class SearchController {

	@Autowired
	SearchDAO dao;

	private final String API_KEY = "4e686376586c756e37336d5948737a";
    private final String BASE_URL = "https://api.odcloud.kr/api/";
	
	
	/**
	 * 네이버 검색 API를 이용하여 동적으로 검색어를 지정하여 장소를 검색합니다.
	 *
	 * @param query 동적으로 지정된 검색어
	 * @return 검색된 장소 목록
	 */
	@GetMapping("/search")
	public ResponseEntity<?> naverSearchDynamic(@RequestParam String name) {
		System.out.println(name);
		List<Map<String, String>> destinationList = dao.searchDestination(name);
		return ResponseEntity.ok(destinationList);
	}
	
	@PostMapping("/chargingStationList")
	public ResponseEntity<?> getChargingStationList() {
		
		List<ChargingStationVO> chargingStationList = dao.getChargingStationList();
		
		return ResponseEntity.ok(chargingStationList);
	}
	
	@PostMapping("/publicParkingList")
	public ResponseEntity<?> getPublicParkingList() {
		
		List<PublicParkingVO> publicParkingList = dao.getPublicParkingList();
		
		return ResponseEntity.ok(publicParkingList);
	}
}
