package com.team03.Ohfifthlane_back.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team03.Ohfifthlane_back.dao.SearchDAO;



@RestController
@RequestMapping("/api")

public class SearchController {

	@Autowired
	SearchDAO dao;

	
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
	
}
